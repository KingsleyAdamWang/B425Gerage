package client;

import javax.swing.JOptionPane;

public class ClientInitException extends Exception {

	public ClientInitException(Throwable e) {
		super(e);
		JOptionPane.showMessageDialog(null, "无法连接到服务器,退出系统", "",
				JOptionPane.ERROR_MESSAGE);
		System.exit(0);
	}

}
