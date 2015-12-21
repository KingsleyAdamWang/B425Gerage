package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.PriceConstPO;
import dataService.manageDataService.PriceConstDataService;

public class PriceConstDataServiceImpl extends UnicastRemoteObject implements
		PriceConstDataService {

	private PriceConstPO price;
	private File file = new File("src/main/java/data/PriceConst.txt");

	public PriceConstDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	private void init() {
		price =  null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<String> result = new ArrayList<String>();
			String temp;
			while ((temp = br.readLine()) != null) {
				result.add(temp);
			}
			br.close();
			if (result.size() != 0) {

				price = new PriceConstPO(result);
			} else
				price = null;
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void update(PriceConstPO po) throws RemoteException {
		price = po ;
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			fw.write(po.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

	@Override
	public PriceConstPO getPriceConst() throws RemoteException {
		return price;
	}

}
