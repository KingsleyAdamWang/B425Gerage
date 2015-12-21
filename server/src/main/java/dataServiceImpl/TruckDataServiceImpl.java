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
import po.TruckPO;
import dataService.businessHallDataService.TruckDataService;

/**
 * 
 * @author 汪盼
 *
 */

public class TruckDataServiceImpl extends UnicastRemoteObject implements
		TruckDataService {

	// 存储汽车信息的文件地址
	private File file = new File("src/main/java/data/Truck.txt");

	// 用于获取文件中所有车辆的信息的列表
	private List<TruckPO> truck;

	public TruckDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	/**
	 * 初始化操作 从服务器将数据里面的所有车辆信息都读取出来 建立一个TruckPO的列表
	 * 
	 * @return
	 */
	private boolean init() {
		truck = new ArrayList<TruckPO>();
		// 初始化 将所有的行里面的信息读取出来 复制给一个列表
		String temp = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while ((temp = bf.readLine()) != null) {
				truck.add(new TruckPO(temp));
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

			System.out.println(truck.size());
			for (TruckPO po : truck) {
				// 将列表中的数据再一次的更新到Truck.txt文件中去
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return true;
	}

	public void add(TruckPO po) throws RemoteException {
		// TODO 注释该行
		truck.add(0, po);
		update();
	}

	public void delete(TruckPO po) throws RemoteException {
		if (truck.contains(po)) {
			truck.remove(po);
			update();
		}

	}

	// 查询可以用编号和车牌号
	public TruckPO find(String id) throws RemoteException {

		for (TruckPO po : truck) {
			if (po.getTruckNumber().equals(id)) {
				return po;
			}
		}
		return null;
	}

	@Override
	public void modify(TruckPO po) throws RemoteException {
	truck.set(truck.indexOf(po),po);
	update();
		
	}

	@Override
	public List<TruckPO> getList() throws RemoteException {
		return truck;
	}


}
