package presentation;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑
	
	private static final long serialVersionUID = 1L;
	
    private static final int PADDING = 10;
    
    private final String[] labelName = {"姓名","城市","邮编","地址","单位","联系电话"};
	private JLabel[] labelS;
	private JLabel[] labelR;
	private JTextField[] textFieldS;
	private JTextField[] textFieldR;
    private final String[] labelName2 = {"原件数","内件品名","实际重量","体积","运送方式","包装费"};
    private JLabel[] labelO;
	private JTextField[] textFieldO;
    	
	private JComboBox expressType;
	private JComboBox cityComboR;
	private JComboBox cityComboS;
	
	private JButton yesButton;
	private JButton noButton;

	public SendUI() {
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);
		
		labelS = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			labelS[i] = new JLabel("寄件人"+labelName[i]);
		}
		labelR = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			labelR[i] = new JLabel("收件人"+labelName[i]);
		}
	}
	
	public void addComponent(Component comp,int row , int col){
	}
	
	public static void main(String[] args) {
		f = new MainFrame();
		SendUI view = new SendUI();
		f.setView(view);
	}
}
