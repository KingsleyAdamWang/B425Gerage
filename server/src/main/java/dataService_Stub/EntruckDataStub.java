package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.EntruckPO;
import dataService.businessHallDataService.EntruckDataService;

public class EntruckDataStub implements EntruckDataService {

	@Override
	public void add(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntruckPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approval(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approvalAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntruckPO> getEntruckList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	


//	public EntruckPO find(String id) throws RemoteException {
//		// TODO Auto-generated method stub
//		EntruckPO po = new EntruckPO();
//		return po;
//	}

}
