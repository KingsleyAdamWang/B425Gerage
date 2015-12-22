package businessLogicService.deliveryBLService;

import java.rmi.RemoteException;

import vo.DeliverymanVo.ReceiveVO;

public interface ReceiveBLService {
	public String add(ReceiveVO rVO) throws RemoteException;

	public String delete(ReceiveVO rVO) throws RemoteException;

	/*
	 * 根据单号查找收件单
	 * */
	public ReceiveVO search(String id);
}
