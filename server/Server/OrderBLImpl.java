package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderBLImpl extends UnicastRemoteObject implements OrderBL {


	protected OrderBLImpl() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	
	@Override
	public String test() throws RemoteException{	
		// TODO 自动生成的方法存根
		return "test is success!!!";
	}

}
