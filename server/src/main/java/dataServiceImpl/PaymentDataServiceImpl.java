package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import po.PaymentPO;
import dataService.PaymentDataService;
import enumSet.ReceiptsState;

public class PaymentDataServiceImpl extends UnicastRemoteObject implements
		PaymentDataService {

	private File file = new File("src/main/java/data/Payment.txt");
	private List<PaymentPO> payList;

	public PaymentDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		payList = new ArrayList<PaymentPO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null)
				payList.add(new PaymentPO(temp));

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void update() {
		Iterator<PaymentPO> it = payList.iterator();
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			while (it.hasNext()) {
				fw.append(it.next().toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void add(PaymentPO po) throws RemoteException {
		payList.add(0, po);
		update();

	}

	@Override
	public void delete(PaymentPO po) throws RemoteException {
		if (payList.contains(po)) {
			payList.remove(po);
			update();
		}
	}

	@Override
	public void modify(PaymentPO po) throws RemoteException {
		payList.set(payList.indexOf(po), po);
		update();

	}

	@Override
	public List<PaymentPO> find(Date d) throws RemoteException {
		List<PaymentPO> result = new ArrayList<PaymentPO>();
		for (PaymentPO po : payList) {
			if (po.getD().equals(d))
				result.add(po);
		}
		return result;
	}

	@Override
	public List<PaymentPO> getList() throws RemoteException {
		return payList;
	}

	@Override
	public void approval(PaymentPO po) throws RemoteException {
		payList.get(payList.indexOf(po)).setState(ReceiptsState.approve);
		update();

	}

	@Override
	public void approvalAll() throws RemoteException {
		Iterator<PaymentPO> it = payList.iterator();
		while (it.hasNext()) {
			it.next().setState(ReceiptsState.approve);
		}
		update();
	}
}
