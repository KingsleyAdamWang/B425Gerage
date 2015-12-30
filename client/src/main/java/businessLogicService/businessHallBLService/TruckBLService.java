package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;

import vo.BussinessHallVo.TruckVO;

public interface TruckBLService {
	public TruckVO find(String id) throws RemoteException;

	public String add(TruckVO vo) throws RemoteException;

	public String delete(TruckVO vo) throws RemoteException;

	public String modify(TruckVO vo) throws RemoteException;
	
}
