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

import po.UserPO;
import dataService.UserDataService;

public class UserDataServiceImpl extends UnicastRemoteObject implements
		UserDataService {

	private File file = new File("src/main/java/data/User.txt");
	private List<UserPO> users;

	public UserDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	/**
	 * 初始化 将所有的系统的用户信息PO加入到List里面
	 */
	public boolean init() throws RemoteException {

		users = new ArrayList<UserPO>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp = "";

			while ((temp = br.readLine()) != null) {
				String str[] = temp.split(" ");
				users.add(new UserPO(str[0], str[1], str[2], str[3], str[4]));

			}
			br.close();
		} catch (IOException e) {
			e.getStackTrace();
		}

		return true;
	}

	public UserPO find(String identityID) throws RemoteException {

		for (UserPO po : users) {
			if (po.getIdentityID().equals(identityID))
				return po;
		}
		return null;
	}

	// 增加一个用户
	public void add(UserPO po) throws RemoteException {

		users.add(po);

	}

	// 删除一个用户
	public void delete(UserPO po) throws RemoteException {

		if (users.contains(po))
			users.remove(po);

	}

	// 更新刷新 写入文件
	public void update() throws RemoteException {

		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");
			for (UserPO po : users) {
				fw.append(po.getName() + " " + po.getId() + " "
						+ po.getPassword() + " " + po.getIdentityID() + " "
						+ po.getInstitutionID() + "\n");

			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<UserPO> getUsers() {
		return users;
	}

	public void setUsers(List<UserPO> users) {
		this.users = users;
	}

}
