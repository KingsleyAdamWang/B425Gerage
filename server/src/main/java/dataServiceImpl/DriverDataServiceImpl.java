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

import po.DriverPO;
import dataService.DriverDataService;

public class DriverDataServiceImpl extends UnicastRemoteObject implements
		DriverDataService {

	// 存储司机信息的文件地址
	private File file = new File("src/main/java/data/Driver.txt");
	// 用于获取文件中的所有司机的信息的列表
	private List<DriverPO> driver;

	public DriverDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	/**
	 * 初始化操作 从服务器将数据里面的所有司机信息都读取出来 建立一个DriverPO的列表
	 */
	private boolean init() {
		 driver = new ArrayList<DriverPO>();
		try {
			String temp;
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while ((temp = bf.readLine()) != null) {
				driver.add(new DriverPO(temp));
			}
			bf.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return true;

	}

	private boolean update() throws RemoteException {
		try {

			FileWriter fw = new FileWriter(file);
			fw.write("");
//			System.out.println(driver.size());
			for (DriverPO po : driver) {
				// 将列表中的数据再一次的更新到Driver.txt文件中去
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void add(DriverPO po) throws RemoteException {
		driver.add(0,po);
		update();
	}

	public void delete(DriverPO po) throws RemoteException {
		
		if (driver.contains(po)) {
			driver.remove(po);
			update();
		}

	}

	// 查询可以用编号和姓名
	public DriverPO find(String id) throws RemoteException {
		for(DriverPO po: driver){
			if(po.getId().equals(id))
				return po;
		}
		return null;
		
	}

	@Override
	public void Modify(DriverPO po) throws RemoteException {
		driver.set(driver.indexOf(po),po);
		update();
		
	}
}
