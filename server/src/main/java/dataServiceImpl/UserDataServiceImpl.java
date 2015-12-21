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
import dataService.manageDataService.UserDataService;
import enumSet.Position;

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
				// 一行存一个userPO的存储数据 读取出来就进行添加到Users的对应List中
				users.add(new UserPO(str[0], str[1], str[2], str[3],
						Position.getPosition(str[4])));

			}
			br.close();
		} catch (IOException e) {
			e.getStackTrace();
		}

		return true;
	}

	// 根据人员账号返回一个po 实现查找某个人员编号对应的人 个人认为是不需要的 暂时先放在这
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
		update();

	}

	// 删除一个用户
	public void delete(UserPO po) throws RemoteException {

		if (users.contains(po)) {
			users.remove(po);
			update();
		}

	}

	// 更新刷新 写入文件
	private void update() {

		try {
			FileWriter fw = new FileWriter(file);
			fw.write("");

			for (UserPO po : users) {
				fw.append(po.getName() + " " + po.getPassword() + " "
						+ po.getIdentityID() + " " + po.getInstitutionID()+" "
						+ po.getWork().getPositionString() + "\n");
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 返回从数据文件中读取的一个UsersPO的 List
	public List<UserPO> getUsers() throws RemoteException {
		return users;
	}

	
	public void modify(UserPO po, String password)
			throws RemoteException {

		UserPO temp = new UserPO(po.getName(), password,
				po.getIdentityID(), po.getInstitutionID(), po.getWork());
		users.remove(po);
		users.add(temp);
		update();

	}
}
