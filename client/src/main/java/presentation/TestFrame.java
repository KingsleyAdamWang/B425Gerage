package presentation;

import javax.swing.JFrame;

public class TestFrame extends JFrame{
	public static void main(String[] args) {
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setView(new SendUI());
	}


}
