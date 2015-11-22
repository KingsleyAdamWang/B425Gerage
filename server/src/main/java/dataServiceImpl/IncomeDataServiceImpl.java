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

import po.IncomePO;
import dataService.IncomeDataService;

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

	
	public void add(IncomePO po) throws RemoteException {
		incomeList.add(po);
		update();

	}

	
	public void delete() throws RemoteException {
		// 我并不想删掉 收款单 …………
		// TODO 看情况吧

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

	
	public List<IncomePO> getIncomeList() throws RemoteException {

		return incomeList;
	}

}
