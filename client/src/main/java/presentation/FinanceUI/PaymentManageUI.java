//package presentation.FinanceUI;
//
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.rmi.RemoteException;
//import java.util.Date;
//import java.util.List;
//import java.util.Vector;
//
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//
//import presentation.MainFrame;
//import presentation.LogUI.LogUI;
//import presentation.ManageUI.ManagerUI;
//import util.DateUtil;
//import vo.FinanceVo.IncomeVO;
//import vo.FinanceVo.PaymentVO;
//import businessLogic.businessHallBL.CashRegisterController;
//import businessLogic.financeBL.PaymentController;
//import client.ClientInitException;
//import client.Main;
//
//public class PaymentManageUI extends JPanel {
//	private static final long serialVersionUID = 1L;
//
//	private PaymentController pc;
//	private JButton searchDateBtn;
//	private JButton searchUserBtn;
//	private JButton returnBtn;
//	private JTable table;
//	private Vector<Vector<String>> vData;
//	private JScrollPane sp;
//	private List<PaymentVO> list;
//
//	public PaymentManageUI() throws RemoteException {
//		this.pc = new PaymentController();
//		vData = new Vector<Vector<String>>();
//		this.initList();
//		this.initComponents();
//		this.validate();
//	}
//	
//	protected void paintComponent(Graphics g) {
//		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
//	}
//
//	private void initComponents() {
//		this.setLayout(null);
//
//		String[] info = { "员工编号", "付款单编号", "付款日期", "付款金额", "付款人姓名", "付款账号",
//				"付款种类", "次数" };
//		Vector<String> vColumns = new Vector<String>();
//		for (int i = 0; i < 8; i++) {
//			vColumns.add(info[i]);
//		}
//
//		table = new JTable(vData, vColumns) {
//			private static final long serialVersionUID = 1L;
//
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//		table.setBorder(BorderFactory.createEtchedBorder());
//		table.setRowHeight(35);
//		table.setRowSelectionAllowed(true);
//
//		sp = new JScrollPane();
//		sp.getViewport().add(table);
//		sp.setBounds(50, 50, 700, 400);
//		table.setFillsViewportHeight(true);
//		this.add(sp);
//
//		searchDateBtn = new JButton("按日期检索");
//		searchDateBtn.setBounds(150, 480, 100, 30);
//		this.add(searchDateBtn);
//		// searchUserBtn = new JButton("按用户检索");
//		// searchUserBtn.setBounds(350, 480, 100, 30);
//		// this.add(searchUserBtn);
//		returnBtn = new JButton("返回");
//		returnBtn.setBounds(550, 480, 100, 30);
//		this.add(returnBtn);
//
//		searchDateBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				PaymentDateDialog d = new PaymentDateDialog(getThis());
//			}
//		});
//
//		// searchUserBtn.addActionListener(new ActionListener() {
//		// public void actionPerformed(ActionEvent e) {
//		// String s = (String) JOptionPane.showInputDialog(null,
//		// "请输入需查询的员工编号：\n", "title", JOptionPane.PLAIN_MESSAGE,
//		// null, null, "");
//		// if (s == null) {
//		// return;
//		// }
//		// list = cc.getLogListOfUser(s);
//		// reInitList(s);
//		// return;
//		// }
//		// });
//
//		returnBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String str = MainFrame.getUser().getWork().getPositionString();
//				if (str.equals("财务人员（高）")) {
//					Main.frame.setView(new FinanceHighUI());
//				} else if (str.equals("财务人员（高）")) {
//					Main.frame.setView(new FinanceHighUI());
//				} else if (str.equals("总经理")) {
//					Main.frame.setView(new ManagerUI());
//				}
//			}
//		});
//	}
//
//	private PaymentManageUI getThis() {
//		return this;
//	}
//
//	private void initList() {
//		list = pc.getAllLogList();
//		vData = getShowList();
//		// table.validate();
//		// scrollPane.getViewport().removeAll();
//		// scrollPane.getViewport().add(table);
//		// this.initComponents();
//		this.repaint();
//	}
//
//	public void reInitList(Date d1, Date d2) {
//		list = pc.betweenDate(d1, d2);
//		vData.clear();
//
//		for (PaymentVO vo : list) {
//			vData.add(toVector(vo));
//		}
//
//		sp.getViewport().removeAll();
//		sp.getViewport().add(table);
//		table.repaint();
//		sp.repaint();
//		this.repaint();
//	}
//
//	// private void reInitList(String s) {
//	// list = cc.getLogListOfUser(s);
//	// vData.clear();
//	//
//	// for (IncomeVO vo : list) {
//	// vData.add(toVector(vo));
//	// }
//	//
//	// sp.getViewport().removeAll();
//	// sp.getViewport().add(table);
//	// table.repaint();
//	// sp.repaint();
//	// this.repaint();
//	// }
//
//	private Vector<Vector<String>> getShowList() {
//		Vector<Vector<String>> v = new Vector<Vector<String>>();
//		int n = list.size();
//		for (int i = 0; i < n; i++) {
//			Vector<String> tmp = toVector(list.get(i));
//			v.add(tmp);
//			// System.out.println(vo.getName());
//		}
//		return v;
//	}
//
//	private Vector<String> toVector(PaymentVO vo) {
//		Vector<String> tmp = new Vector<String>();
//		tmp.add(vo.userID);
//		tmp.add(vo.payID);
//		tmp.add(DateUtil.dateToString(vo.d));
//		tmp.add(vo.payment + "");
//		tmp.add(vo.payName);
//		tmp.add(vo.bankID);
//		tmp.add(vo.type);
//		tmp.add(vo.times + "");
//		return tmp;
//	}
//
//class PaymentDateDialog extends JDialog {
//	private static final long serialVersionUID = 1L;
//	private JLabel label1;
//	private JLabel label2;
//	private JTextField field1;
//	private JTextField field2;
//	private JButton btn1;
//	private JButton btn2;
//	private IncomeManageUI ui;
//
//	public PaymentDateDialog(IncomeManageUI ui) {
//		this.ui = ui;
//		this.setVisible(true);
//		this.setResizable(false);
//		this.setLayout(null);
//		this.setSize(300, 200);
//		this.setLocationRelativeTo(null);
//
//		initComponents();
//	}
//
//	private void initComponents() {
//		label1 = new JLabel("起始日期：");
//		label1.setBounds(25, 25, 50, 15);
//		label2 = new JLabel("结束日期:");
//		label2.setBounds(25, 75, 50, 15);
//		field1 = new JTextField();
//		field1.setBounds(100, 20, 175, 25);
//		field1.setText(DateUtil.dateToString());
//		field2 = new JTextField();
//		field2.setBounds(100, 70, 175, 25);
//		field2.setText(DateUtil.dateToString());
//		this.getContentPane().add(label1);
//		this.getContentPane().add(label2);
//		this.getContentPane().add(field1);
//		this.getContentPane().add(field2);
//
//		btn1 = new JButton("确定");
//		btn1.setBounds(50, 120, 75, 30);
//		this.getContentPane().add(btn1);
//		btn2 = new JButton("返回");
//		btn2.setBounds(50, 120, 75, 30);
//		this.getContentPane().add(btn2);
//		btn1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Date d1 = DateUtil.stringToDate(field1.getText());
//				Date d2 = DateUtil.stringToDate(field2.getText());
//				ui.reInitList(d1, d2);
//			}
//		});
//		btn2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
//	}
//}
