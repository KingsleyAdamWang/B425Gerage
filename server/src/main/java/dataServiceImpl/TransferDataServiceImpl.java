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

import po.TransferPO;
import dataService.intermidateDataService.TransferDataService;
import enumSet.ReceiptsState;

public class TransferDataServiceImpl extends UnicastRemoteObject implements
		TransferDataService {

	private File file = new File("src/main/java/data/Transfer.txt");

	private List<TransferPO> transList;

	public TransferDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		transList = new ArrayList<TransferPO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				transList.add(new TransferPO(temp));
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void add(TransferPO po) throws RemoteException {

		transList.add(0, po);
		update();

	}

	@Override
	public void delete(TransferPO po) throws RemoteException {
		if (transList.contains(po)) {
			transList.remove(po);
			update();
		}

	}

	@Override
	public List<TransferPO> getList() throws RemoteException {

		return transList;
	}

	@Override
	public void modify(TransferPO po) throws RemoteException {
		transList.set(transList.indexOf(po), po);
		update();

	}

	@Override
	public void approve(TransferPO po) throws RemoteException {

		transList.get(transList.indexOf(po)).setState(ReceiptsState.approve);
		update();

	}

	@Override
	public void approveAll() throws RemoteException {
		for (int i = 0; i < transList.size(); i++) {
			transList.get(i).setState(ReceiptsState.approve);

		}

		update();
	}

	@Override
	public TransferPO find(String id) throws RemoteException {
		for (TransferPO po : transList) {
			if (po.getTransferID().equals(id)) {
				return po;
			}
		}
		return null;
	}

	private void update() {
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write("");
			for (TransferPO po : transList) {
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
