package businessLogicService.adminBLService;

import java.rmi.RemoteException;

import javax.swing.text.Position;

public interface AdminBLService {

	public boolean add(String id,String name,String password,String identityID,String institutionID,Position work) throws RemoteException;

	public boolean delete(String id,String name,String password,String identityID,String institutionID,Position work) throws RemoteException;

	public void update(String message);
}
