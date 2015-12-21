package dataServiceImpl.inventoryDataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import po.inventoryPO.EntryPO;
import dataService.inventoryDataService.EntryDataService;
import enumSet.ReceiptsState;

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
	
	
	public void modify(EntryPO po)throws RemoteException{
		entryList.set(entryList.indexOf(po), po);
		update();
	}
	
	
	public void approval(EntryPO po )throws RemoteException{
		entryList.get(entryList.indexOf(po)).setState(ReceiptsState.approve);
		update();
		
		
	}
	
	
	public void approvalAll()throws RemoteException{
		Iterator<EntryPO> it = entryList.iterator();
		while(it.hasNext()){
			it.next().setState(ReceiptsState.approve);
		}
		update();
	}
	
	public List<EntryPO> getEntryList(String institutionID)throws RemoteException{
		List<EntryPO> listByIns = new ArrayList<EntryPO>();
		for(EntryPO po : entryList){
			if(po.getInstitutionID().equals(institutionID)){
				listByIns.add(po);
			}
		}
		return listByIns;
	}
	
	public List<EntryPO> getEntryList()throws RemoteException{
		return entryList;
	}

}
