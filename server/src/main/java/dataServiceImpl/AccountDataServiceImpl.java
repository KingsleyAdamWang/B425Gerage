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

import po.AccountPO;
import dataService.AccountDataService;

public class AccountDataServiceImpl extends UnicastRemoteObject implements
		AccountDataService {

	// 存储账户信息的文件地址
	private File file = new File("src/main/java/data/Account.txt");

	// 用于获取文件中的所有的相关信息的所有的账户的信息 的列表
	private List<AccountPO> accounts = new ArrayList<AccountPO>();

	public AccountDataServiceImpl() throws RemoteException {
		super();
		init();

	}

	/**
	 * 初始化操作 从服务器端将数据里面的所有账户信息都读取出来 建立一个AccountPO的列表
	 */
	private boolean init() {
		// 初始化 将所有的行里面的信息读取出来 复制给一个列表
		String temp = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while ((temp = bf.readLine()) != null) {

				accounts.add(new AccountPO(temp.split(" ")[0],
						temp.split(" ")[1],
						Double.parseDouble(temp.split(" ")[2])));

				// System.out.println("成功");
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

			System.out.println(accounts.size());
			for (AccountPO po : accounts) {
				// 将列表中的数据再一次的更新到Account.txt文件中去
				fw.append(po.getName() + " " + po.getBalance() + "\n");
				fw.flush();
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean modify(AccountPO po, String name) throws RemoteException {

		double balance = po.getBalance();
		String accountID = po.getAccountID();
		accounts.remove(po);
		accounts.add(0, new AccountPO(name, accountID, balance));

		update();

		return true;
	}

	
	public boolean add(AccountPO po) throws RemoteException {
		// TODO 注释该行
		System.out.println("添加账户成功！！");
		// 是否重名等逻辑判断放在最后BL层实现
		accounts.add(po);
		update();
		return true;
	}


	public boolean delete(AccountPO po) throws RemoteException {

		// 由于重写了AccountPO的equals方法所以 只通过名称来进行查看
		if (accounts.contains(po)) {
			accounts.remove(po);
			update();
		}
		return true;
	}

	
	public List<AccountPO> search(String key) throws RemoteException {
		// TODO
		List<AccountPO> list = new ArrayList<AccountPO>();
		// 符合该关键字的po都加载到list里面
		for (AccountPO po : accounts)
			if (po.getName().contains(key))
				list.add(po);

		return list;
	}

	// //底层测试还好 成功了
	// public static void main(String[] args) throws RemoteException {
	// AccountDataServiceImpl temp = new AccountDataServiceImpl();
	// temp.add(new AccountPO("shabi", 456.2));
	// temp.delete(new AccountPO("呵呵", 123.2));
	// temp.update();
	//
	// }
	public List<AccountPO> getAccounts() throws RemoteException {
		// TODO Auto-generated method stub
		return this.accounts;
	}
}
