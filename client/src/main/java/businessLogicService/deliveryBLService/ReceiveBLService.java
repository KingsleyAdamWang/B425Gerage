package businessLogicService.deliveryBLService;

import vo.ReceiveVO;

public interface ReceiveBLService {
	public String add(ReceiveVO rVO);

	public String delete(ReceiveVO rVO);

	/*
	 * 根据单号查找收件单
	 * */
	public ReceiveVO search(String id);
}
