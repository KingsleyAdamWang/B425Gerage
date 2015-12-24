package server;

import javax.swing.JOptionPane;

public class Server {

    public static void main(String[] args) {
    	ServerUI ui = new ServerUI();
        try {
//            Logger.info("Try start server...");
        	System.out.println("TRY START SERVER.....");
            RMIHelper.init();
//            Logger.info("Server is now running!");
            System.out.println("SERVER IS RUNNING...");
            ui.setLabel();
        } catch (ServerInitException e) {
        	System.out.println("SERVER START FAIL!!!");
        	e.printStackTrace();
    		JOptionPane.showMessageDialog(null, "无法连接到服务器,退出系统", "",
    				JOptionPane.ERROR_MESSAGE);
    		System.exit(0);

//            Logger.error("Server starts fail!");
//            Logger.error(e);
        }
    }
}
