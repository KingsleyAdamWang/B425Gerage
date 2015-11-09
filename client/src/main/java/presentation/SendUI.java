package presentation;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendUI extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	
    private static final int PADDING = 10;
	//寄件人的label
	private JLabel nameS;
	private JLabel cityS;
	private JLabel postCodeS;
	private JLabel addressS;
	private JLabel companyS;
	private JLabel phoneS;
	
	//收件人的label
	private JLabel nameR;
	private JLabel cityR;
	private JLabel postCodeR;
	private JLabel addressR;
	private JLabel companyR;
	private JLabel phoneR;
	
	//货物的label
	private JLabel amount;
	private JLabel weight;
	private JLabel volume;
	private JLabel commodity;
	private JLabel method;
	private JLabel pack;
	private JLabel number;
	private JLabel price;
	
	//寄件人的JTextField
	private JTextField nameST;
	private JTextField postCodeST;
//	private JTextField cityST;通过comboBox来实现
	private JTextField addressST;
	private JTextField companyST;
	private JTextField phoneST;
	
	//收件人的JTextField
	private JTextField nameRT;
	private JTextField postCodeRT;
//	private JTextField cityRT;通过ComboBox来实现
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
	
	//快递类型选择框//城市选择
	private JComboBox expressType;
	private JComboBox cityComboR;
	private JComboBox cityComboS;
	
	 
	//选择按钮 提交或者不提交
	private JButton yesButton;
	private JButton noButton;

	
	public SendUI() {
		 this.setLayout(new GridLayout(4, 1));
		
		//注释这一行先自己画一下
//		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		this.setLayout(null);
		
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		nameS = new JLabel("寄件人姓名：");
		cityS = new JLabel("寄件人城市：");
		postCodeS = new JLabel("寄件地址邮编：");
		addressS = new JLabel("寄件人地址：");
		companyS = new JLabel("寄件人单位：");
		phoneS = new JLabel("寄件人联系电话：");
		nameR = new JLabel("收件人姓名：");
		cityR = new JLabel("收件人城市");
		postCodeR = new JLabel("收件地址邮编：");
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
		postCodeST = new JTextField(20);
		addressST = new JTextField(30);
		companyST = new JTextField(50);
		phoneST = new JTextField(50);
		
		
		nameRT = new JTextField(10);
		postCodeRT = new JTextField(20);
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
		expressType = new JComboBox();
		expressType.addItem("经济");
		expressType.addItem("标准");
		expressType.addItem("特快");
		
		//TODO 应该是从数据中引入的
		cityComboR = new JComboBox();
		cityComboR.addItem("北京");
		cityComboR.addItem("上海");
		cityComboR.addItem("广州");
		cityComboR.addItem("南京");
		
		
		cityComboS = new JComboBox();
		cityComboS.addItem("北京");
		cityComboS.addItem("上海");
		cityComboS.addItem("广州");
		cityComboS.addItem("南京");

		yesButton = new JButton("确定");
		noButton = new JButton("返回");
        
		//获取ui的宽的和长度
		int width = this.getWidth();
		int height = this.getHeight();
		
		nameS.setLocation(PADDING, PADDING);
		this.add(nameS);
		this.setVisible(true);
	
//		JPanel jp1 = new JPanel();
//		jp1.setLayout(new GridLayout(6, 2));
//		jp1.add(nameS);
//		jp1.add(nameST);
//		jp1.add(cityS);
//		jp1.add(cityComboS);
//		jp1.add(postCodeS);
//		jp1.add(postCodeST);
//		jp1.add(addressS);
//		jp1.add(addressST);
//		jp1.add(companyS);
//		jp1.add(companyST);
//		jp1.add(phoneS);
//		jp1.add(phoneST);
//
////		this.add(jp1);
////		jp1.setLocation(10, 10);
//		
//		
//		JPanel jp2 = new JPanel();
//		jp2.setLayout(new GridLayout(6, 2));
//
//		jp2.add(nameR);
//		jp2.add(nameRT);
//		jp2.add(cityR);
//		jp2.add(cityComboR);
//		jp2.add(postCodeR);
//		jp2.add(postCodeRT);
//		jp2.add(addressR);
//		jp2.add(addressRT);
//		jp2.add(companyR);
//		jp2.add(companyRT);
//		jp2.add(phoneR);
//		jp2.add(phoneRT);
//
//		JPanel jp12 = new JPanel();
//
//		jp12.setLayout(new GridLayout(1, 3));
//
//		jp12.add(jp1);
//		JPanel blank = new JPanel();
//
//		jp12.add(blank);
//		jp12.add(jp2);
//		this.add(jp12);
//		
//	
//		
//		JPanel jp4 = new JPanel();
//		jp4.setLayout(getLayout());
//		jp4.add(amount);
//		jp4.add(amountT);
//		jp4.add(commodity);
//		jp4.add(commodityT);
//		jp4.add(weight);
//		jp4.add(weightT);
//		jp4.add(volume);
//		jp4.add(volumeT);
//		jp4.add(method);
//		jp4.add(expressType);
//		jp4.add(pack);
//		jp4.add(packT);
//		jp4.add(price);
//		jp4.add(priceT);
//		this.add(jp4);
//		
//	
//		
//		JPanel jp3 = new JPanel();
//		jp3.add(number);
//		jp3.add(numberT);
//	
//		this.add(jp3);
//
//		
//
//		
//		JPanel jp5 = new JPanel();
//		jp5.add(yesButton);
//		jp5.add(noButton);
//		this.add(jp5);
	}
	
	//自定义一个添加组件的方法  自己来完善网格布局
	public void addComponent(Component comp,int row , int col){
		
	}
}
