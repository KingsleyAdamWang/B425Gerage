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

import po.EntryPO;
import dataService.EntryDataService;

public class EntryDataServiceImpl extends UnicastRemoteObject implements EntryDataService {

	private File file = new File("src/main/java/data/Entry.txt");
	private List<EntryPO> entryList;

	public EntryDataServiceImpl() throws RemoteException {
		super();
		init();
	    
	}

	
	private void init(){
		
		entryList = new ArrayList<EntryPO>();
		
		try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp ;
		 while((temp=br.readLine())!=null){
			 entryList.add(new EntryPO(temp));
		 }
		 br.close();
		}
		catch(IOException e){
			e.getStackTrace();
		}
	}

	
	
	public void add(EntryPO po) throws RemoteException {

		entryList.add(0,po);
		update();
		
	}


	public void delete(EntryPO po) throws RemoteException {
		entryList.remove(po);
		update();
		
	}

	private  void update(){
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write("");
			for(EntryPO po: entryList){
				fw.append(po.toString());
				fw.flush();
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public EntryPO find(String id) throws RemoteException {
	for(EntryPO po: entryList){
		if(po.getId().equals(id))
			return po;
	}
		return null;
	}
	
	
	
	public List<EntryPO> getEntryList(){
		return entryList;
	}

}
