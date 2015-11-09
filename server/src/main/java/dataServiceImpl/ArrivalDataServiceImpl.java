package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import po.ArrivalPO;
import util.DateUtil;
import dataService.ArrivalDataService;
import enumSet.ArrivalState;
import enumSet.ReceiptsState;

public class ArrivalDataServiceImpl extends UnicastRemoteObject implements
		ArrivalDataService {

	private File file = new File("src/main/java/data/Arrival.txt");
	private List<ArrivalPO> arrivals = new ArrayList<ArrivalPO>();

	public ArrivalDataServiceImpl() throws RemoteException {
		//初始化先将所有的到达单的信息都读取到List里面 好在页面内显示
		super();
		init();
		
	}

	//初始化将所有的到达单读取出来
	public boolean init() throws RemoteException {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
		    String temp = "";
			while ((temp = br.readLine()) != null) {
				String[] infos = temp.split(" ");
			
				//TODO
			}
//			System.out.println(arrivals.size());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;

	}

	public  boolean  add(ArrivalPO po) throws RemoteException {
		
		//增加一个收款单
		arrivals.add(po);
        return true;
	}

	public boolean delete(ArrivalPO po) throws RemoteException {
		if(arrivals.contains(po)){
			arrivals.remove(po);
			return true;
		}
		return false;

	}

	public ArrivalPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrivalPO search(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public static void main(String[] args) throws RemoteException {
//		new ArrivalDataServiceImpl();
//	}

}
