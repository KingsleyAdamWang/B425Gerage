package presentation;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final int frameWidth = 800;
	private final int frameHeight = 600;

	public MainFrame() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - frameWidth) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - frameHeight) / 2;
		this.setLocation(w, h);
		this.setSize(frameWidth, frameHeight);
		this.setResizable(false);
		// this.setVisible(true);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	public void setView(JPanel panel) {
		this.setVisible(true);
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().validate();
		this.repaint();
	}
	
	public void setView(JPanel panel,String s) {
		this.setTitle(s);
		this.setView(panel);
	}
}
