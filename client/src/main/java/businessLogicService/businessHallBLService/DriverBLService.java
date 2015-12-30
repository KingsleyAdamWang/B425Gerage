package businessLogicService.businessHallBLService;

import java.rmi.RemoteException;

import vo.BussinessHallVo.DriverVO;

public interface DriverBLService {
	public DriverVO find(String id) throws RemoteException;
	
	public String addDriver(DriverVO vo) throws RemoteException;
	
	public String delete(DriverVO vo) throws RemoteException;
	
	public String modify(DriverVO vo) throws RemoteException;
}
