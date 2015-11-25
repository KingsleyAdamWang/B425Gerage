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

import po.SendPO;
import dataService.SendDataService;
import enumSet.ReceiptsState;

public class SendDataServiceImpl extends UnicastRemoteObject implements
		SendDataService {

	File file = new File("src/main/java/data/Send.txt");
	List<SendPO> sends = new ArrayList<SendPO>();

	//构造函数 初始化获取数据中存的寄件单的数据
	public SendDataServiceImpl() throws RemoteException {
		super();
		init();
	}

	
	
	// 初始化操作 将所有的寄件单写入一个列表
	private void init() {

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null) {
				sends.add(new SendPO(temp));
			}
			br.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	//新增寄件单
	public void add(SendPO po) throws RemoteException {
	sends.add(0,po);
	update();

	}

	//删除一个寄件单//暂时这样写着  记得好像在  需求设计文档中 假设的是快递员填写额信息无误 而且 寄件人不会悔单
	public void delete(SendPO po) throws RemoteException {
	sends.remove(po);
	update();

	}

	//将读取出来的po的List返回
	public List<SendPO> getSendList() throws RemoteException {
		return sends;
	}
	
	
//	刷新
	private void update(){
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			for(SendPO po:sends){
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
	public void modify(SendPO po) throws RemoteException {
		if(sends.contains(po)){
			sends.remove(po);
			sends.add(0,po);
			update();
		}
		
	}



	@Override
	public void approval(SendPO po) throws RemoteException {
	
				sends.get(sends.indexOf(po)).setState(ReceiptsState.approve);
			    update();
			
			}
		
		
	



	@Override
	public void approvalAll() throws RemoteException {
	  for(int i=0 ; i < sends.size() ;i ++){
		  sends.get(i).setState(ReceiptsState.approve);
	  }
		update();
	}





}
