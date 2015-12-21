package dataServiceImpl.businessHallDataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import po.DeliveryPO;
import dataService.businessHallDataService.DeliveryDataService;
import enumSet.ReceiptsState;

/**
 * 寄件单
 * 
 * @author 王栋
 *
 */
public class DeliveryDataServiceImpl extends UnicastRemoteObject implements
		DeliveryDataService {

	private File file = new File("src/main/java/data/Delivery.txt");
	private List<DeliveryPO> deliveryList;

	public DeliveryDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		deliveryList = new ArrayList<DeliveryPO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				deliveryList.add(new DeliveryPO(temp));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void update() {
		Iterator<DeliveryPO> temp = deliveryList.iterator();
		try {
			FileWriter fw = new FileWriter(file);

			fw.write("");
			while (temp.hasNext()) {
				fw.append(temp.next().toString());
				fw.flush();
			}

			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(DeliveryPO po) throws RemoteException {
		if (deliveryList.contains(po))
			return;
		deliveryList.add(0, po);
		update();
	}

	@Override
	public void delete(DeliveryPO po) throws RemoteException {
		if (deliveryList.contains(po)) {
			deliveryList.remove(po);
			update();
		}

	}

	@Override
	public void modify(DeliveryPO po) throws RemoteException {
		if (deliveryList.contains(po)) {
			deliveryList.set(deliveryList.indexOf(po), po);
			update();
		}

	}

	@Override
	public void approve(DeliveryPO po) throws RemoteException {
		deliveryList.get(deliveryList.indexOf(po)).setState(
				ReceiptsState.approve);
		update();

	}

	@Override
	public void approveAll() throws RemoteException {
		Iterator<DeliveryPO> temp = deliveryList.iterator();
		while (temp.hasNext()) {
			temp.next().setState(ReceiptsState.approve);
		}
		update();
	}

	@Override
	public List<DeliveryPO> getList() throws RemoteException {
	return deliveryList;
	}

	@Override
	public DeliveryPO find(String id) throws RemoteException {
		Iterator<DeliveryPO> temp = deliveryList.iterator();
		while (temp.hasNext()) {
			DeliveryPO po =temp.next();
			if(po.getId().equals(id))
				return po;
		}
		return null;
		
	}

}
