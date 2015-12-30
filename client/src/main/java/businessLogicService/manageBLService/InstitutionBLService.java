package businessLogicService.manageBLService;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import vo.InventoryVo.InventoryVO;
import vo.ManageVo.InstitutionVO;

public interface InstitutionBLService {
	public List<InstitutionVO> show() throws IOException;

	public String addIns(InstitutionVO insVO) throws RemoteException;
	
	public String addIns(InstitutionVO vo,InventoryVO ivo) throws RemoteException;
	
	public String deleteIns(InstitutionVO insVO) throws RemoteException;
	
	public String modify(String id,String newName) throws RemoteException;
	
	public String modify(String inventoryID,InventoryVO vo) throws RemoteException;
	
	public InstitutionVO searchInstitution(String institutionID);
	
	public InventoryVO searchInventory(String inventoryID) throws RemoteException;
	
}
