package dataService.manageDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.managePO.InstitutionPO;

/**
 * 机构管理的数据层接口
 * @author 王栋
 *
 */
public interface InstitutionDataService extends Remote{
	
	/**
	 * 增加一个机构
	 * @param po
	 * @throws RemoteException
	 */
	public void add(InstitutionPO po) throws RemoteException;
	/**
	 * 删除一个机构
	 * @param institutionID
	 * @throws RemoteException
	 */
	public void delete(String institutionID) throws RemoteException;
	
	/**
	 * 修改机构的部分信息
	 * @param id
	 * @param name
	 * @throws RemoteException
	 */
	public void modify(String id,String name)throws RemoteException;

	/**
	 * 返回所有机构的列表
	 * @return
	 * @throws RemoteException
	 */
	public List<InstitutionPO> getInsList() throws RemoteException;
	
	

}
