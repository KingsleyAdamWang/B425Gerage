package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.SalaryPO;
import util.Salary;
import dataService.SalaryDataService;

public class SalaryDataServiceImpl extends UnicastRemoteObject implements SalaryDataService{

	
	private SalaryPO po;
	
	private File file = new File("src/main/java/data/Salary.txt");
	public  SalaryDataServiceImpl() throws RemoteException {
		super();
	    init();
	}

	private void init(){
	 po = new SalaryPO(new ArrayList<Salary>());
	 
	 try {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = br.readLine();
		
		if(temp!=null){
			po = new SalaryPO(temp);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	private void update(){
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			fw.append(po.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public SalaryPO getSalaryPO() throws RemoteException {
		
		return po;
	}

	@Override
	public void modify(SalaryPO po) throws RemoteException {

		this.po = po ;
		update();
	}
	

}
