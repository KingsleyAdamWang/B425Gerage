package businessLogic.manageBL;

import java.util.List;

import vo.InventoryVo.InventoryVO;
import vo.ManageVo.InstitutionVO;
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
	

	public String addIns(InstitutionVO vo,InventoryVO ivo) throws RemoteException{
		return insBL.addIns(vo,ivo);
	}
	public String deleteIns(InstitutionVO vo) throws RemoteException{
		return insBL.deleteIns(vo);
	}
	
	public String modify(String institutionID,String newName) throws RemoteException{
		return insBL.modify(institutionID, newName);
	}
	//用于更改inventoryPO，id与institutionPO相同
	public String modify(String inventoryID, InventoryVO vo) throws RemoteException{
		return insBL.modify(inventoryID, vo);
	}
	
	public InstitutionVO searchInstitution(String institutionID){
		return insBL.searchInstitution(institutionID);
	}
	
	public InventoryVO searchInventory(String inventoryID) throws RemoteException{
		return insBL.searchInventory(inventoryID);
	}
	
//下面这个别管，没用
	public InstitutionVO search(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}

}
