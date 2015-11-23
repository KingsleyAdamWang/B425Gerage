package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.EntruckPO;
import dataService.EntruckDataService;

public class EntruckDataServiceImpl extends UnicastRemoteObject implements
		EntruckDataService {

	private List<EntruckPO> enTruckList;
	private File file = new File("src/main/java/data/Entruck.txt");

	public EntruckDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	private void init() {
    try {
		BufferedReader br = new BufferedReader(new FileReader(file));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //TODO
	
	}

	public void add(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void delete(EntruckPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public EntruckPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
