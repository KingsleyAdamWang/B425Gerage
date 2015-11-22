package businessLogic.manageBL;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import client.ClientInitException;
import client.RMIHelper;
import dataService.InstitutionDataService;
import dataService.InventoryDataService;
import dataService.UserDataService;
import enumSet.InsType;
import po.InstitutionPO;
import po.InventoryPO;
import po.UserPO;
import util.CheckUtil;
import vo.InstitutionVO;
import vo.InventoryVO;

public class InstitutionBL {
	
	InstitutionDataService insDS;
	List<InstitutionPO> insList;
	
	public  InstitutionBL() throws RemoteException {
		try {
			RMIHelper.initInstitutionDataService();
			insDS = RMIHelper.getInstitutionDataService();
			insList = insDS.getInsList();

		} catch (ClientInitException e) {
			e.printStackTrace();
		}
	}

	public List<InstitutionVO> show(){
		List<InstitutionVO> result =new ArrayList<InstitutionVO>();
		for(InstitutionPO temp : insList){
			result.add(new InstitutionVO(temp));
			//将list中所有PO转换成VO返回list
		}
		return result;
	}
	
	public String addIns(InstitutionVO vo) throws RemoteException{
		InstitutionPO po= vo.transToPO();
		
		if(!CheckUtil.checkInsID(po.getInstitutionID())){
			return "ID格式不符合标准";
		}
		
		for(InstitutionPO temp : insList){
			if(temp.getInstitutionID().equals(po.getInstitutionID())){
				//如果加入的po与原有po的机构ID重复
				return "存在相同ID，添加失败";
			}
		}
		insList.add(po);
		insDS.add(po);
		
		return null;
	}
	
	public String addIns(InstitutionVO insVO,InventoryVO invVO) throws RemoteException{
		InstitutionPO insPO= insVO.transToPO();
		InventoryPO invPO=invVO.transToPO();
		
		if(!CheckUtil.checkInsID(insVO.getInstitutionID())){
			return "ID格式不符合标准";
		}
		
		for(InstitutionPO temp : insList){
			if(temp.getInstitutionID().equals(insPO.getInstitutionID())){
				//如果加入的po与原有po的机构ID重复
				return "存在相同ID，添加失败";
			}
		}
		// 增加新增仓库对应的库存信息
		InventoryDataService invDS=RMIHelper.getInventoryDataService();
		List<InventoryPO> invList= invDS.getInventoryList();
		invList.add(invPO);
		invDS.add(invPO);
		
		insList.add(insPO);
		insDS.add(insPO);
		
		return null;
	}
	
	
	
	public String deleteIns(InstitutionVO vo) throws RemoteException{
		UserDataService userDS= RMIHelper.getUserDataService();
		List<UserPO> users= userDS.getUsers();
		
		if(vo.getType()==InsType.management){
			return "管理机构无法删除";
		}
		
		for(InstitutionPO temp : insList){
			
			if(temp.getInstitutionID().equals(vo.getInstitutionID())){
				//如果找到对应ID的PO，则删除机构，并删除对应该机构的所有人员信息
				for(UserPO tempUser : users){
					if(tempUser.getInstitutionID().equals(vo.getInstitutionID())){
						//机构内删除人员
						userDS.delete(tempUser);
						users.remove(tempUser);
					}
				}
				//删除机构，分情况，如果是仓库，则还需删除对应的库存信息
				if(temp.getType()==InsType.intermediate){
					InventoryDataService invDS=RMIHelper.getInventoryDataService();
					invDS.delete(temp.getInstitutionID());
				}
				
				insList.remove(temp);
				insDS.delete(vo.getInstitutionID());
				return null;
			}
		}
		
		return "未找到对应PO";
	}
	
	public String modify(String id,String newName) throws RemoteException{
		
//		if(newName)
		for(InstitutionPO temp : insList){
			if(temp.getInstitutionID().equals(id)){
				//找到了ID对应的PO，根据ID更改名称
				insList.get(insList.indexOf(temp)).setName(newName);;
				insDS.modify(id, newName);
				
				return null;
			}
		}
		return "未找到对应PO";
	}
}
