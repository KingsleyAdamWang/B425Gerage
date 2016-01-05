package businessLogic.deliveryBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.deliveryPO.ReceivePO;
import vo.DeliverymanVo.ReceiveVO;
import vo.DeliverymanVo.SendVO;
import businessLogic.logisticsBL.LogisticsBL;
import client.ClientInitException;
import client.RMIHelper;
import dataService.deliveryDataService.ReceiveDataService;
import enumSet.ReceiptsState;

public class ReceiveBL {
	private ReceiveDataService receiveDS;
	private List<ReceivePO> receiveList;
	private ReceivePO receivePO;

	public ReceiveBL() throws RemoteException {
		try {
			RMIHelper.initReceiveDataService();
			receiveDS = RMIHelper.getReceiveDataService();
			receiveList = receiveDS.getList();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public String add(ReceiveVO vo) throws RemoteException {
		SendBL sendBL = new SendBL();
		receivePO = vo.transToPO();
		for (ReceivePO temp : receiveList) {
			if (temp.equals(receivePO)) {
				return "存在相同收件单";
			}
		}

		SendVO sendVO = sendBL.getSend(receivePO.getId());
		sendVO.arriveDate = (int) ((receivePO.getD().getTime() - sendVO.getD()
				.getTime()) / (3600 * 24 * 1000)) + 1;
		sendBL.modify(sendVO);

		receiveList.add(receivePO);
		receiveDS.add(receivePO);
		
		LogisticsBL logisticsBL = new LogisticsBL();
		logisticsBL.update(receivePO.getId(), "已签收，签收人是"+receivePO.getName());
		return null;
	}

	public String delete(ReceiveVO vo) throws RemoteException {
		receivePO = vo.transToPO();
		for (ReceivePO temp : receiveList) {
			if (temp.equals(receivePO)) {
				receiveList.remove(temp);
				receiveDS.delete(receivePO);
				return null;
			}
		}

		return "未找到收件单";
	}

	public String modify(ReceiveVO vo) throws RemoteException {
		receivePO = vo.transToPO();
		for (ReceivePO temp : receiveList) {
			if (temp.equals(receivePO)) {
				receiveList.remove(temp);
				receiveList.add(receiveList.indexOf(temp), receivePO);
				receiveDS.modify(receivePO);
			}
		}
		return "未找到对应收件单";
	}

	public void approve(ReceivePO po) throws RemoteException {
		receiveDS.approve(po);
	}

	public void approveAll() throws RemoteException {
		receiveDS.approveAll();
	}

	public List<ReceiveVO> getUnapproved() {
		List<ReceiveVO> result = new ArrayList<ReceiveVO>();
		for (ReceivePO temp : receiveList) {
			if (temp.getState() == ReceiptsState.unapprove) {
				result.add(new ReceiveVO(temp));
			}
		}
		return result;
	}
}
