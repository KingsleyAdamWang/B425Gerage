package presentation;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class SendUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private static final int PADDING = 10;

	private final String[] labelName = { "姓名", "城市", "邮编", "地址", "单位", "电话" };
	private JLabel[] labelS;
	private JLabel[] labelR;
	private JTextField[] textFieldS;
	private JTextField[] textFieldR;
	private final String[] labelName2 = { "原件数", "内件品名", "实际重量", "体积", "运送方式",
			"包装费", "快递单号" };
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
		textFieldS = new JTextField[6];
		for (int i = 0; i < 6; i++) {
			labelS[i] = new JLabel("寄件人" + labelName[i] + ":");
			labelS[i].setBounds(20, 40 * (i + 1), 100, 20);
			textFieldS[i] = new JTextField();
			textFieldS[i].setBounds(105, 40 * (i + 1), 250, 30);
			this.add(labelS[i]);
			this.add(textFieldS[i]);
		}

		labelR = new JLabel[6];
		textFieldR = new JTextField[6];
		for (int i = 0; i < 6; i++) {
			labelR[i] = new JLabel("收件人" + labelName[i] + ":");
			labelR[i].setBounds(420, 40 * (i + 1), 100, 20);
			textFieldR[i] = new JTextField();
			textFieldR[i].setBounds(505, 40 * (i + 1), 250, 30);
			this.add(labelR[i]);
			this.add(textFieldR[i]);
		}

		JSeparator js = new JSeparator();
		js.setBounds(0, 300, 800, 10);
		this.add(js);

		labelO = new JLabel[7];
		textFieldO = new JTextField[7];
		for (int i = 0; i < 7; i++) {
			labelO[i] = new JLabel(labelName2[i] + ":");
			labelO[i]
					.setBounds(20 + 400 * (i % 2), 320 + 40 * (i / 2), 100, 20);
			textFieldO[i] = new JTextField();
			textFieldO[i].setBounds(105 + 400 * (i % 2), 320 + 40 * (i / 2),
					250, 30);
			this.add(labelO[i]);
			this.add(textFieldO[i]);
		}
		
		yesButton = new JButton("提交");
		yesButton.setBounds(200, 500, 100, 30);
		this.add(yesButton);
		noButton = new JButton("返回");
		noButton.setBounds(500, 500, 100, 30);
		this.add(noButton);
	}

	public static void main(String[] args) {
		f = new MainFrame();
		SendUI view = new SendUI();
		f.setView(view);
	}
}
