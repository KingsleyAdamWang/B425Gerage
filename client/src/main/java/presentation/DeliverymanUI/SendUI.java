package presentation.DeliverymanUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.CustomerVO;
import vo.SendVO;
import businessLogic.deliveryBL.SendController;
import client.ClientInitException;
import client.Main;
import enumSet.Express;
import enumSet.PackType;
import enumSet.ReceiptsState;

public class SendUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private static final int PADDING = 10;

	private SendController sc;
	private final String[] labelName = { "姓名", "城市", "邮编", "地址", "单位", "电话" };
	private JLabel[] labelS;
	private JLabel[] labelR;
	private JTextField[] textFieldS;
	private JTextField[] textFieldR;
	private final String[] labelName2 = { "原件数", "内件品名", "实际重量", "体积", "运送方式",
			"包装方式", "快递单号", "寄件日期", "预计天数" };
	private JLabel[] labelO;
	private JTextField[] textFieldO;
	private String[] cities;
	private final String[] exType = { "标准", "经济", "特快", "其它" };
	private final String[] pkType = { "纸箱", "木箱", "快递袋", "其他" };
	private double fare;

	private JComboBox<String> expressType;
	private JComboBox<String> packType;
	private JComboBox<String> cityComboR;
	private JComboBox<String> cityComboS;

	private JButton yesButton;
	private JButton noButton;

	public SendUI() throws RemoteException, ClientInitException {
		sc = new SendController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() throws RemoteException {
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
		js.setBounds(0, 290, 800, 10);
		this.add(js);

		labelO = new JLabel[9];
		textFieldO = new JTextField[9];
		for (int i = 0; i < 9; i++) {
			labelO[i] = new JLabel(labelName2[i] + ":");
			labelO[i]
					.setBounds(20 + 400 * (i % 2), 310 + 40 * (i / 2), 100, 20);
			textFieldO[i] = new JTextField();
			textFieldO[i].setBounds(105 + 400 * (i % 2), 310 + 40 * (i / 2),
					250, 30);
			this.add(labelO[i]);
			this.add(textFieldO[i]);
		}

		yesButton = new JButton("提交");
		yesButton.setBounds(200, 520, 100, 30);
		this.add(yesButton);
		noButton = new JButton("返回");
		noButton.setBounds(500, 520, 100, 30);
		this.add(noButton);

		textFieldO[4].setVisible(false);
		textFieldO[5].setVisible(false);
		textFieldS[1].setVisible(false);
		textFieldR[1].setVisible(false);

		expressType = new JComboBox<String>(exType);
		packType = new JComboBox<String>(pkType);
		expressType.setBounds(105, 390, 250, 30);
		packType.setBounds(505, 390, 250, 30);
		this.add(expressType);
		this.add(packType);

		initCities();
		cityComboR = new JComboBox<String>(cities);
		cityComboS = new JComboBox<String>(cities);
		cityComboR.setBounds(505, 80, 250, 30);
		cityComboS.setBounds(105, 80, 250, 30);
		this.add(cityComboR);
		this.add(cityComboS);

		textFieldO[7].setText(DateUtil.dateToString());
		setDays();

		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "尚未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					String dep = cities[cityComboS.getSelectedIndex()];
					String des = cities[cityComboR.getSelectedIndex()];
					double wei = Double.parseDouble(textFieldO[2].getText());
					double vol = Double.parseDouble(textFieldO[3].getText());

					fare = sc.getFare(dep, des, getPackType(), getExpress(),
							wei, vol, 1, 1);
					String result = sc.add(getSendVO());
					if (result != null) {
						JOptionPane.showMessageDialog(null, result, "",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "提交成功", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClientInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "输入信息有误", "",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});

		cityComboR.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent e) {
				setDays();
			}
		});

		cityComboS.addItemListener(new ItemListener() {
			public void itemStateChanged(final ItemEvent e) {
				setDays();
			}
		});
	}

	private void initCities() throws RemoteException {
		List<String> list = sc.getCities();
		cities = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			cities[i] = list.get(i);
		}
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

	private SendVO getSendVO() {
		return new SendVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), textFieldO[6].getText(),
				DateUtil.stringToDate(textFieldO[7].getText()), getSender(),
				getReceiver(), Integer.parseInt(textFieldO[0].getText()),
				textFieldO[1].getText(), Double.parseDouble(textFieldO[2]
						.getText()),
				Double.parseDouble(textFieldO[3].getText()), this.getExpress(),
				this.getPackType(), fare, 0);
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 6; i++) {
			if (i != 1) {
				if (textFieldR[i].getText().equals(""))
					return true;
				if (textFieldS[i].getText().equals(""))
					return true;
			}
		}
		for (int i = 0; i < 8; i++) {
			if (i != 4 && i != 5) {
				if (textFieldO[i].getText().equals(""))
					return true;
			}
		}
		return false;
	}

	private void setDays() {
		String s2 = (String) cityComboS.getSelectedItem();
		String s1 = (String) cityComboR.getSelectedItem();
		textFieldO[8].setText(sc.getDays(s1, s2) + "");
	}

	public static void main(String[] args) throws RemoteException,
			ClientInitException {
		f = new MainFrame();
		SendUI view = new SendUI();
		f.setView(view);
	}
}
