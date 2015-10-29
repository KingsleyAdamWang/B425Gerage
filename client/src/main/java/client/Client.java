package client;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import BL.OrderBL;

public class Client {
	
    public static void main(String[] args) {
    	OrderBL order;
        try {
            RMIHelper.init();
//            new ClientFrame();
         order = RMIHelper.getOrderBL();
     System.out.println(     order.test());
        } catch (ClientInitException | RemoteException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Client boots fail!\nCause: " + e.getMessage(),
                    "Fatal Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }
}
