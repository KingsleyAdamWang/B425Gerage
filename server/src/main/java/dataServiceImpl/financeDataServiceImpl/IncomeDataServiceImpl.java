package dataServiceImpl.financeDataServiceImpl;

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

import po.IncomePO;
import dataService.financeDataService.IncomeDataService;
import enumSet.ReceiptsState;

public class IncomeDataServiceImpl extends UnicastRemoteObject implements
		IncomeDataService {

	private List<IncomePO> incomeList;
	private File file = new File("src/main/java/data/Income.txt");

	/*
	 * 构造函数
	 */
	public IncomeDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	/**
	 * 初始化读取器数据
	 */
	private void init() {
		incomeList = new ArrayList<IncomePO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				incomeList.add(new IncomePO(temp));
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void update() {
		try {

			FileWriter fw = new FileWriter(file);
			fw.write("");
			for (IncomePO po : incomeList) {
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void add(IncomePO po) throws RemoteException {
		incomeList.add(0,po);
		update();
		
	}
	
	public List<IncomePO> getIncomeList() throws RemoteException {

		return incomeList;
	}

	@Override
	public void delete(IncomePO po) throws RemoteException {
	  if(incomeList.contains(po)){
		  incomeList.remove(po);
		  update();
	  }
		
	}

	@Override
	public void modify(IncomePO po) throws RemoteException {
		incomeList.set(incomeList.indexOf(po),po);
		update();
		
	}

	@Override
	public void approval(IncomePO po) throws RemoteException {
		incomeList.get(incomeList.indexOf(po)).setState(ReceiptsState.approve);
		update();
	}

	@Override
	public void apprivalAll() throws RemoteException {
		Iterator<IncomePO> it = incomeList.iterator();
		while(it.hasNext()){
			it.next().setState(ReceiptsState.approve);
		}
		update();
		
	}

	@Override
	public List<IncomePO> getListByDate(Date d) throws RemoteException {
		List<IncomePO> result = new ArrayList<IncomePO>();
		for(IncomePO po : incomeList){
			if(po.getDate().equals(d))
				result.add(po);
		}
		return result;
	}



}
