package businessLogic.businessHallBL;

import vo.EntruckVO;
import businessLogicService.businessHallBLService.EntruckBLService;
import java.rmi.RemoteException;

public class EntruckController implements EntruckBLService {

	EntruckBL entruckBL;
	
	public EntruckController() throws RemoteException{
		entruckBL=new EntruckBL();
	}
	
	public String add(EntruckVO entruckVO) throws RemoteException {
		
		return entruckBL.add(entruckVO);
	}


	public  EntruckVO search(String transferID) throws RemoteException {
		
		return entruckBL.search(transferID);
	}
	
	public String delete(EntruckVO entruckVO) throws RemoteException{

		return entruckBL.delete(entruckVO);
	}

	public String modify(EntruckVO entruckVO) throws RemoteException{
		
		return entruckBL.modify(entruckVO);
	}
	
//好像没用了，不管
	public String submit(EntruckVO eVO){
		// TODO Auto-generated method stub
		return null;
	}

}
