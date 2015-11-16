package businessLogic.adminBL;

import java.rmi.RemoteException;

import javax.swing.text.Position;

import java.rmi.RemoteException;
import java.util.List;

import businessLogicService.adminBLService.AdminBLService;

public class AdminController implements AdminBLService {
	AdminBL adminBL;
	
	public AdminController() throws RemoteException{
		adminBL= new AdminBL();
	}


	public boolean add(String id,String name,String password,String identityID,String institutionID,Position work) throws RemoteException{

		return adminBL.add(id,name,password,identityID,institutionID, work);
	}

	
	public boolean delete(String id,String name,String password,String identityID,String institutionID,Position work) throws RemoteException {
		// TODO Auto-generated method stub
		return adminBL.delete(id, name, password, identityID, institutionID, work);
	}

	
	public void update(String message) {
		// TODO Auto-generated method stub

	}



}
