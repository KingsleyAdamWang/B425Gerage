package dataServiceImpl.deliveryDataServiceImpl;

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

import po.ReceivePO;
import dataService.deliveryDataService.ReceiveDataService;
import enumSet.ReceiptsState;

public class ReceiveDataServiceImpl extends UnicastRemoteObject implements
		ReceiveDataService {

	private File file = new File("src/main/java/data/Receive.txt");
	private List<ReceivePO> receiveList;

	public ReceiveDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		receiveList = new ArrayList<ReceivePO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				receiveList.add(new ReceivePO(temp));
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
			Iterator<ReceivePO> iterator = receiveList.iterator();
			fw.write("");
			while (iterator.hasNext()) {
				fw.append(iterator.next().toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void add(ReceivePO po) throws RemoteException {
		receiveList.add(0, po);
		update();

	}

	@Override
	public void delete(ReceivePO po) throws RemoteException {
		if (receiveList.contains(po)) {
			receiveList.remove(po);
			update();
		}

	}

	@Override
	public void modify(ReceivePO po) throws RemoteException {
		if (receiveList.contains(po)) {
			receiveList.set(receiveList.indexOf(po), po);
			update();
		}

	}

	@Override
	public ReceivePO find(String id) throws RemoteException {
		Iterator<ReceivePO> iterator = receiveList.iterator();

		while (iterator.hasNext()) {
			ReceivePO po = iterator.next();
			if (po.getId().equals(id))
				;
			return po;
		}
		return null;
	}

	@Override
	public void approve(ReceivePO po) throws RemoteException {
		receiveList.get(receiveList.indexOf(po))
				.setState(ReceiptsState.approve);
		update();

	}

	@Override
	public void approveAll() throws RemoteException {
		Iterator<ReceivePO> iterator = receiveList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setState(ReceiptsState.approve);
		}
		update();
	}

	@Override
	public List<ReceivePO> getList() throws RemoteException {
		return receiveList;
	}

}
