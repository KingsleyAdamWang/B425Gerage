package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.InventoryPO;
import dataService.InventoryDataService;

public class InventoryDataServiceImpl extends UnicastRemoteObject implements
		InventoryDataService {

	private List<InventoryPO> inventoryList;
	private File file = new File("src/main/java/data/Inventory.txt");

	public InventoryDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		inventoryList = new ArrayList<InventoryPO>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				inventoryList.add(new InventoryPO(temp));
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(InventoryPO po) throws RemoteException {
		this.inventoryList.add(po);
		FileWriter fw;
		try {
			fw = new FileWriter(file);

			fw.append(po.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modify(InventoryPO po) throws RemoteException {
		inventoryList.set(inventoryList.indexOf(po), po);

		update();
	}

	public void delete(String InstitutionID) throws RemoteException {
		for (InventoryPO po : inventoryList) {
			if (po.getInstitutionID().equals(InstitutionID)) {
				inventoryList.remove(po);
				break;
			}
		}
		update();

	}

	private void update() {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write("");
			for (InventoryPO po : inventoryList) {
				fw.append(po.toString());
				fw.flush();
			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<InventoryPO> getInventoryList() throws RemoteException {
		return inventoryList;
	}

}
