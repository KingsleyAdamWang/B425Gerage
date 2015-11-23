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
import dataService.TruckDataService;

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
	private List<TruckPO> truck = new ArrayList<TruckPO>();

	public TruckDataServiceImpl() throws RemoteException {
		super();
		init();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 初始化操作 从服务器将数据里面的所有车辆信息都读取出来 建立一个TruckPO的列表
	 * 
	 * @return
	 */
	private boolean init() {
		// 初始化 将所有的行里面的信息读取出来 复制给一个列表
		String temp = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while ((temp = bf.readLine()) != null) {
				truck.add(new TruckPO(temp.split(" ")[0], temp.split(" ")[1],
						Integer.parseInt(temp.split(" ")[2])));
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
			for (TruckPO po : truck)
				// 将列表中的数据再一次的更新到Truck.txt文件中去
				fw.append(po.getTruckID() + " " + po.getTruckNumber() + " "
						+ po.getYears() + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public void add(TruckPO po) throws RemoteException {
		// TODO 注释该行
		truck.add(po);
		update();
	}

	public void delete(TruckPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if (truck.contains(po)) {
			truck.remove(po);
			update();
		}

	}
	//查询可以用编号和车牌号
	public TruckPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		TruckPO target = new TruckPO(null, null, 0);
		for (TruckPO po : truck){
			target = po;
			if (po.getTruckID().contains(id)
					|| po.getTruckNumber().contains(id))
				break;
		}
		return target;	
	}
	
//	 public static void main(String[] args) throws RemoteException {
//		 TruckDataServiceImpl temp = new TruckDataServiceImpl();
//		 temp.add(new TruckPO("123","123" ,456));
//		 temp.delete(new TruckPO("123","123", 456));
//		 temp.update();		
//		 }

}
