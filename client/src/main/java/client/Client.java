package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		// OrderBL order;
		try {
			RMIHelper.initAccountDataService();
			// RMIHelper.init();
			// new ClientFr ame();
			// order = RMIHelper.getOrderBL();
			// System.out.println( order.test());
		} catch (ClientInitException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Client boots fail!\nCause: "
					+ e.getMessage(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
