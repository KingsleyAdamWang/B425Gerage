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

import po.ArrivalPO;
import dataService.businessHallDataService.ArrivalDataService;
import enumSet.ReceiptsState;

/**
 * 到达单的数据层的实现类
 * 
 * @author 王栋
 *
 */
public class ArrivalDataServiceImpl extends UnicastRemoteObject implements
		ArrivalDataService {

	private File file = new File("src/main/java/data/Arrival.txt");
	private List<ArrivalPO> arrivals = new ArrayList<ArrivalPO>();

	public ArrivalDataServiceImpl() throws RemoteException {
		// 初始化先将所有的到达单的信息都读取到List里面 好在页面内显示
		super();
		init();

	}

	// 初始化将所有的到达单读取出来
	private boolean init() {
		arrivals = new ArrayList<ArrivalPO>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String temp = "";
			while ((temp = br.readLine()) != null) {
				arrivals.add(new ArrivalPO(temp));
			}
			// System.out.println(arrivals.size());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;

	}

	public void add(ArrivalPO po) throws RemoteException {

		// 增加一个收款单
		arrivals.add(0, po);
		update();

	}

	public void delete(ArrivalPO po) throws RemoteException {
		if (arrivals.contains(po)) {
			arrivals.remove(po);
			update();
		}

	}

	private void update() {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			
			for(ArrivalPO po: arrivals ){
				fw.append(po.toString());
				fw.flush();
				
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modify(ArrivalPO po) throws RemoteException{
		arrivals.set(arrivals.indexOf(po), po);
		update();
	}


	public List<ArrivalPO> getArrivalList() throws RemoteException {
		return arrivals;
	}
	

	public void  approval(ArrivalPO po)throws RemoteException{
		
		arrivals.get(arrivals.indexOf(po)).setState(ReceiptsState.approve);
		update();
	}
	
	public void approvalAll() throws RemoteException{
		for(int i = 0 ; i < arrivals.size() ;i++){
		arrivals.get(i).setState(ReceiptsState.approve);
		}
		update();
	}
}
