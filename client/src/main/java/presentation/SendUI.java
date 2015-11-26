package presentation;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import vo.CustomerVO;
import enumSet.Express;
import enumSet.PackType;

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
			"包装方式", "快递单号" };
	private JLabel[] labelO;
	private JTextField[] textFieldO;
	private String[] cities;
	private final String[] exType = { "标准", "经济", "特快", "其它" };
	private final String[] pkType = { "纸箱", "木箱", "快递袋", "其他" };

	private JComboBox<String> expressType;
	private JComboBox<String> packType;
	private JComboBox<String> cityComboR;
	private JComboBox<String> cityComboS;

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

		textFieldO[4].setVisible(false);
		textFieldO[5].setVisible(false);
		textFieldS[1].setVisible(false);
		textFieldR[1].setVisible(false);

		// JComboBox expressType;
		// JComboBox packType;

		initCities();
		cityComboR = new JComboBox<String>(cities);
		cityComboS = new JComboBox<String>(cities);
		cityComboR.setBounds(505, 80, 250, 30);
		cityComboS.setBounds(105, 80, 250, 30);
		this.add(cityComboR);
		this.add(cityComboS);
	}

	private void initCities() {
		cities = new String[4];
		cities[0] = "北京";
		cities[1] = "上海";
		cities[2] = "广州";
		cities[3] = "南京";
	}

	private CustomerVO getSender() {
		String name = textFieldS[0].getText();
		String city = cities[cityComboS.getSelectedIndex()];
		String postCode = textFieldS[2].getText();
		String address = textFieldS[3].getText();
		String company = textFieldS[4].getText();
		String telephone = textFieldS[5].getText();
		return new CustomerVO(name, city, postCode, address, company, telephone);
	}

	private CustomerVO getReceiver() {
		String name = textFieldR[0].getText();
		String city = cities[cityComboR.getSelectedIndex()];
		String postCode = textFieldR[2].getText();
		String address = textFieldR[3].getText();
		String company = textFieldR[4].getText();
		String telephone = textFieldR[5].getText();
		return new CustomerVO(name, city, postCode, address, company, telephone);
	}

	private Express getExpress() {
		return Express.getExpress((String) expressType.getSelectedItem());
	}

	private PackType getPackType() {
		return PackType.getPackType((String) packType.getSelectedItem());
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 6; i++) {
			if (i != 1) {
				if (textFieldR[i].getText() == null)
					return true;
				if (textFieldS[i].getText() == null)
					return true;
			}
		}
		for (int i = 0; i < 7; i++) {
			if (i != 4 && i != 5) {
				if (textFieldO[i].getText() == null)
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		f = new MainFrame();
		SendUI view = new SendUI();
		f.setView(view);
	}
}
