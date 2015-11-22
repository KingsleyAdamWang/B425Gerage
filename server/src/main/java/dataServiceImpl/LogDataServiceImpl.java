package dataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import po.LogPO;
import util.DateUtil;
import dataService.LogDataService;

public class LogDataServiceImpl extends UnicastRemoteObject implements
		LogDataService {

	private List<LogPO> logList;
	private File file = new File("src/main/java/data/Log.txt.");

	public LogDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	private void init() {
		logList = new ArrayList<LogPO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while ((temp = br.readLine()) != null)
				logList.add(new LogPO(temp));

			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<LogPO> check(String id) throws RemoteException {
		List<LogPO> result = new ArrayList<LogPO>();
		for (LogPO po : logList) {
			if (po.getIdentityID().equals(id))
				result.add(po);
		}
		return result;
	}

	@Override
	public List<LogPO> check(Date date) throws RemoteException {
		List<LogPO> result = new ArrayList<LogPO>();
		for (LogPO po : logList) {
			if (DateUtil.dateToString(po.getD()).equals(
					DateUtil.dateToString(date)))
				result.add(po);
		}

		return result;
	}

	public List<LogPO> check(String id, Date date) {
		List<LogPO> result = new ArrayList<LogPO>();
		for (LogPO po : logList) {
			if (DateUtil.dateToString(po.getD()).equals(
					DateUtil.dateToString(date))
					&& po.getIdentityID().equals(id))
				result.add(po);
		}
		return result;
	}

	public void clear() throws RemoteException {
		logList.clear();
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.write("");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<LogPO> getLogList() {
		return logList;
	}

	@Override
	public void add(LogPO po) throws RemoteException {
		logList.add(po);
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			fw.append(po.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
