package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import po.ShipmentPO;
import dataService.inventoryDataService.ShipmentDataService;
import enumSet.ReceiptsState;

public class ShipmentDataServiceImpl extends UnicastRemoteObject implements
		ShipmentDataService {

	private File file = new File("src/main/java/data/Shipment.txt");

	private List<ShipmentPO> shipList;

	public ShipmentDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		shipList = new ArrayList<ShipmentPO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				shipList.add(new ShipmentPO(temp));
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void update() {
		Iterator<ShipmentPO> it = shipList.iterator();
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			while (it.hasNext()) {
				fw.append(it.next().toString());
				fw.flush();
			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void add(ShipmentPO po) throws RemoteException {
		shipList.add(0, po);
		update();
	}

	@Override
	public void delete(ShipmentPO po) throws RemoteException {
		shipList.remove(po);
		update();

	}

	@Override
	public void modify(ShipmentPO po) throws RemoteException {
		shipList.set(shipList.indexOf(po), po);
		update();

	}

	@Override
	public void approval(ShipmentPO po) throws RemoteException {
		shipList.get(shipList.indexOf(po)).setState(ReceiptsState.approve);
		update();
	}

	@Override
	public void approvalAll() throws RemoteException {
		Iterator<ShipmentPO> it = shipList.iterator();
		while (it.hasNext()) {
			it.next().setState(ReceiptsState.approve);
		}
		update();
	}

	@Override
	public ShipmentPO find(String id) throws RemoteException {
		Iterator<ShipmentPO> it = shipList.iterator();
		while (it.hasNext()) {
			ShipmentPO po = it.next();
			if (po.getId().equals(id)) {
				return po;
			}
		}
		return null;

	}

	@Override
	public List<ShipmentPO> getList() throws RemoteException {
		return shipList;
	}

	@Override
	public List<ShipmentPO> getListByIns(String institutionID)
			throws RemoteException {
		List<ShipmentPO> result = new ArrayList<ShipmentPO>();
		Iterator<ShipmentPO> it = shipList.iterator();
		while (it.hasNext()) {
			result.add(it.next());
		}
		return result;
	}

}
