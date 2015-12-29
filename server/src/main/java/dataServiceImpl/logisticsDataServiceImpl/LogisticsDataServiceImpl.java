package dataServiceImpl.logisticsDataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.logisticsPO.LogisticsPO;
import util.DateUtil;
import dataService.logisticsDataService.LogisticsDataService;

public class LogisticsDataServiceImpl extends UnicastRemoteObject implements
		LogisticsDataService {
	// file文件的地址 创建了一个file
	private File file = new File("src/main/java/data/Logistics.txt");
	// po的集合
	private List<LogisticsPO> logisticsList;

	public LogisticsDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	// 初始化 读文件 获取所有的LogisticsPO的集合
	private void init() {
		logisticsList = new ArrayList<LogisticsPO>();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
//System.out.println(temp);
				logisticsList.add(new LogisticsPO(temp));
			}
			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 刷新更新数据
	public void update() throws RemoteException {

		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			for (LogisticsPO po : logisticsList) {
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @param message
	 * @return
	 * @throws RemoteException
	 */
	public boolean modify(String id, String message) throws RemoteException {
		message=DateUtil.dateToStringDetail()+"_"+message;
		// 更新物流信息
		for (LogisticsPO po : logisticsList) {
			if (po.getId().equals(id)) {
				po.addMessages(message);
				update();
				return true;
			}
		}
		return false;
	}

	//添加了快递单需要新增一个po对象 
	public void add(LogisticsPO po) throws RemoteException {
		logisticsList.add(po);
		update();
	}
	
	
	public List<LogisticsPO> getLogisticsList() throws RemoteException {
		return this.logisticsList;
	}
	
	

	
	//main主要用于测试
	public static void main(String[] args) {
	 try {
		LogisticsDataService temp  =  new LogisticsDataServiceImpl();
		System.out.println(temp.getLogisticsList().size());
		for(LogisticsPO po : temp.getLogisticsList())
			System.out.println(po.toString());
		temp.add(new LogisticsPO("8888888888","万贱人"));
		temp.modify("1234567890", "万姐姐好美丽！");
		
		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}





}
