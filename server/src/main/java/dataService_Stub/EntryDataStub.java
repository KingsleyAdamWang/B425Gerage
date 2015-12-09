package dataService_Stub;

import java.rmi.RemoteException;
import java.util.List;

import po.EntryPO;
import dataService.EntryDataService;

public class EntryDataStub implements EntryDataService {

	@Override
	public void add(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntryPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approval(EntryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approvalAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntryPO> getEntryList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntryPO> getEntryList(String institutionID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}




//	public EntryPO find(String id) throws RemoteException {
//		EntryPO po = new EntryPO();
//		return po;
//	}

}
