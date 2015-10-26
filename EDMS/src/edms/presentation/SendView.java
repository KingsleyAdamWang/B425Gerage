package edms.presentation;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel nameS;
	private JLabel addressS;
	private JLabel companyS;
	private JLabel phoneS;
	private JLabel nameR;
	private JLabel addressR;
	private JLabel companyR;
	private JLabel phoneR;
	private JLabel amount;
	private JLabel weight;
	private JLabel volume;
	private JLabel commodity;
	private JLabel method;
	private JLabel pack;
	private JLabel number;
	private JLabel price;
	private JTextField nameST;
	private JTextField addressST;
	private JTextField companyST;
	private JTextField phoneST;
	private JTextField nameRT;
	private JTextField addressRT;
	private JTextField companyRT;
	private JTextField phoneRT;
	private JTextField amountT;
	private JTextField weightT;
	private JTextField volumeT;
	private JTextField commodityT;
	private JTextField packT;
	private JTextField numberT;
	private JTextField priceT;
	private JComboBox comboBox;
	private JButton yesButton;
	private JButton noButton;

	public SendView() {
		// this.setLayout(new GridLayout(3, 1));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		nameS = new JLabel("寄件人姓名：");
		addressS = new JLabel("寄件人地址：");
		companyS = new JLabel("寄件人单位：");
		phoneS = new JLabel("寄件人联系电话：");
		nameR = new JLabel("收件人姓名：");
		addressR = new JLabel("收件人地址：");
		companyR = new JLabel("收件人单位：");
		phoneR = new JLabel("收件人联系电话：");
		amount = new JLabel("原件数：");
		weight = new JLabel("实际重量：");
		volume = new JLabel("体积：");
		commodity = new JLabel("内件品名：");
		method = new JLabel("运送方式：");
		pack = new JLabel("包装费：");
		number = new JLabel("订单号：");
		price = new JLabel("费用合计：");

		nameST = new JTextField(10);
		addressST = new JTextField(30);
		companyST = new JTextField(50);
		phoneST = new JTextField(50);
		nameRT = new JTextField(10);
		addressRT = new JTextField(50);
		companyRT = new JTextField(50);
		phoneRT = new JTextField(50);
		amountT = new JTextField(50);
		weightT = new JTextField(50);
		volumeT = new JTextField(50);
		commodityT = new JTextField(50);
		packT = new JTextField(50);
		numberT = new JTextField(50);
		priceT = new JTextField(50);
		comboBox = new JComboBox();
		comboBox.addItem("经济快递");
		comboBox.addItem("标准快递");
		comboBox.addItem("特快");
		
		yesButton = new JButton("确定");
		noButton = new JButton("返回");

		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(8, 4));
		jp1.add(nameS);
		jp1.add(nameST);
		jp1.add(addressS);
		jp1.add(addressST);
		jp1.add(companyS);
		jp1.add(companyST);
		jp1.add(phoneS);
		jp1.add(phoneST);
		jp1.add(nameR);
		jp1.add(nameRT);
		jp1.add(addressR);
		jp1.add(addressRT);
		jp1.add(companyR);
		jp1.add(companyRT);
		jp1.add(phoneR);
		jp1.add(phoneRT);
		jp1.add(amount);
		jp1.add(amountT);
		jp1.add(commodity);
		jp1.add(commodityT);
		jp1.add(weight);
		jp1.add(weightT);
		jp1.add(volume);
		jp1.add(volumeT);
		jp1.add(method);
		jp1.add(comboBox);
		jp1.add(pack);
		jp1.add(packT);
		jp1.add(price);
		jp1.add(priceT);
		this.add(jp1);
		JPanel jp2 = new JPanel();
		jp2.add(number);
		jp2.add(numberT);
		this.add(jp2);
		JPanel jp3 = new JPanel();
		jp3.add(yesButton);
		jp3.add(noButton);
		this.add(jp3);
	}
}
