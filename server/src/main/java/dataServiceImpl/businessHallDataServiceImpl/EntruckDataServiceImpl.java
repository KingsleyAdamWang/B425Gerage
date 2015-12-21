package dataServiceImpl.businessHallDataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.businessPO.EntruckPO;
import dataService.businessHallDataService.EntruckDataService;
import enumSet.ReceiptsState;

public class EntruckDataServiceImpl extends UnicastRemoteObject implements
		EntruckDataService {

	private List<EntruckPO> enTruckList;
	private File file = new File("src/main/java/data/Entruck.txt");

	public EntruckDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	private void init() {

		enTruckList = new ArrayList<EntruckPO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				EntruckPO po = new EntruckPO(temp);
				enTruckList.add(po);
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void update() {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			for (EntruckPO po : enTruckList) {
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public void add(EntruckPO po) throws RemoteException {
		enTruckList.add(0, po);
		update();

	}

	public void delete(EntruckPO po) throws RemoteException {
		enTruckList.remove(po);
		update();

	}

	public EntruckPO find(String id) throws RemoteException {
		for (EntruckPO po : enTruckList) {
			if (po.getQyID().equals(id))
				return po;
		}

		return null;
	}

	@Override
	public void modify(EntruckPO po) throws RemoteException {
		
		enTruckList.set(enTruckList.indexOf(po),po);
		update();

	}

	@Override
	public void approval(EntruckPO po) throws RemoteException {
		
		enTruckList.get(enTruckList.indexOf(po)).setState(ReceiptsState.approve);;
		update();

	}

	

	@Override
	public void approvalAll() throws RemoteException {
		for(int i = 0 ; i < enTruckList.size() ; i++){
			enTruckList.get(i).setState(ReceiptsState.approve);
		}
		
		update();
	}
	
	
	public List<EntruckPO> getEntruckList()throws RemoteException{
		return enTruckList;
	}


}
