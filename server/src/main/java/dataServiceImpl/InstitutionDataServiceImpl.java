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

import dataService.InstitutionDataService;
import enumSet.InsType;
import po.InstitutionPO;

public class InstitutionDataServiceImpl extends UnicastRemoteObject implements InstitutionDataService {

	private List<InstitutionPO> insList;
	private File file = new File("src/main/java/data/Institution.txt");

	public InstitutionDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	private void init() {
		insList = new ArrayList<InstitutionPO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				insList.add(new InstitutionPO(temp.split(" ")[0], temp
						.split(" ")[1], temp.split(" ")[2],InsType.getInsType(temp.split(" ")[3])));
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void add(InstitutionPO po) throws RemoteException {
		insList.add(po);
		update();

	}

	@Override
	public void delete(String institutionID) throws RemoteException {
		for (InstitutionPO po : insList)
			if (po.getInstitutionID().equals(institutionID)) {
				insList.remove(po);
				update();
				return;
			}
	}

	private void update() {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			for (InstitutionPO po : insList) {
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void modify(String id, String name) throws RemoteException {
		for (InstitutionPO po : insList) {
			if (po.getInstitutionID().equals(id)) {
				insList.get(insList.indexOf(po)).setName(name);
				update();
				return ;
			}
		}

	}

	@Override
	public List<InstitutionPO> institutionList() throws RemoteException {

		return insList;
	}

}
