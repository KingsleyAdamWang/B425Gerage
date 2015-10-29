package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
 
public interface OrderBL extends Remote {

	
	public abstract String test() throws RemoteException;
}
