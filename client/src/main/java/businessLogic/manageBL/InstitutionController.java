package businessLogic.manageBL;

import java.util.List;

import vo.InstitutionVO;
import vo.InventoryVO;
import businessLogicService.manageBLService.InstitutionBLService;

import java.rmi.RemoteException;


public class InstitutionController implements InstitutionBLService {
	InstitutionBL insBL;
	
	public InstitutionController() throws RemoteException{
		insBL=new InstitutionBL();
	}
	
	public List<InstitutionVO> show(){
		return insBL.show();
	}
	
	
	public String addIns(InstitutionVO vo) throws RemoteException{
		return insBL.addIns(vo);
	}
	
	public String deleteIns(InstitutionVO vo) throws RemoteException{
		return insBL.deleteIns(vo);
	}
	
	public String modify(String id,String newName) throws RemoteException{
		return insBL.modify(id, newName);
	}
	
	public String modify(String id, InventoryVO vo) throws RemoteException{
		return insBL.modify(id, vo);
	}
	
	public InstitutionVO searchInstitution(String id){
		return insBL.searchInstitution(id);
	}
	
	public InventoryVO searchInventory(String id) throws RemoteException{
		return insBL.searchInventory(id);
	}

	public InstitutionVO search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
