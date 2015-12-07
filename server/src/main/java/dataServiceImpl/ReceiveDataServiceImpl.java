package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.ReceivePO;
import dataService.ReceiveDataService;

public class ReceiveDataServiceImpl extends UnicastRemoteObject implements
		ReceiveDataService {
   
	private File file= new File("src/main/java/data/Receive.txt");
	private List<ReceivePO> receiveList ;

	public ReceiveDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	
	private void init(){
		receiveList = new ArrayList<ReceivePO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void update(){
		
	}
	
	@Override
	public void add(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ReceivePO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approve(ReceivePO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void approveAll() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReceivePO> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
