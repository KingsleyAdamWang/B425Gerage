package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DriverPO;
import po.TruckPO;
import util.DateUtil;

public class DriverDataServiceImpl extends UnicastRemoteObject implements DriverDataService {

	// 存储司机信息的文件地址
	private File file = new File("src/main/java/data/Driver.txt");

	// 用于获取文件中的所有司机的信息的列表
	private List<DriverPO> driver = new ArrayList<DriverPO>();

	public DriverDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	/**
	 * 初始化操作 从服务器将数据里面的所有司机信息都读取出来 建立一个DriverPO的列表
	 */
	private boolean init() {
		// TODO Auto-generated method stub
		String temp = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while ((temp = bf.readLine()) != null) {
				driver.add(new DriverPO(temp.split(" ")[0], temp.split(" ")[1], temp.split(" ")[2],
						DateUtil.stringToDate(temp.split(" ")[3]), temp.split(" ")[4], temp.split(" ")[5],
						temp.split(" ")[6], Integer.parseInt(temp.split(" ")[7]),
						DateUtil.stringToDate(temp.split(" ")[8])));
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

			System.out.println(driver.size());
			for (DriverPO po : driver)
				// 将列表中的数据再一次的更新到Driver.txt文件中去
				fw.append(po.getId() + " " + po.getName() + " " + po.getIDnumber() + " "
						+ DateUtil.dateToString(po.getD()) + " " + po.getTelNumber() + " " + po.getInstitutionID() + " "
						+ po.getTruckID() + " " + String.valueOf(po.getWorkYears()) + " "
						+ DateUtil.dateToString(po.getDriveLicence()) + "\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void add(DriverPO po) throws RemoteException {
		// TODO 注释该行
		driver.add(po);
		update();
	}

	public void delete(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if (driver.contains(po)) {
			driver.remove(po);
			update();
		}

	}
	//查询可以用编号和姓名
	public DriverPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		DriverPO target = new DriverPO();
		for (DriverPO po : driver){
			target = po;
			if (po.getId().contains(id)
					|| po.getName().contains(id))
				break;
		}
		return target;	
	}
}
