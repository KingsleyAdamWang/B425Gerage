package presentation.FinanceUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.DateUtil;
import vo.FinanceVo.IncomeVO;
import vo.FinanceVo.PaymentVO;
import businessLogic.financeBL.FormController;
import client.Main;

public class RunFormUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private FormController fc;
	private JScrollPane mainPane;
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JTable tableP;
	private Vector<Vector<String>> vDataP;
	private JScrollPane spP;
	private JTable tableI;
	private Vector<Vector<String>> vDataI;
	private JScrollPane spI;
	private List<PaymentVO> listP;
	private List<IncomeVO> listI;
	private JButton searchBtn;
	private JButton exportBtn;
	private JButton returnBtn;
	private boolean flag = false;
	private Date d1;
	private Date d2;

	public RunFormUI() {
		fc = new FormController();
		vDataP = new Vector<Vector<String>>();
		vDataI = new Vector<Vector<String>>();
		this.initList();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 1000));
		panel.setBounds(0, 0, 800, 1000);
		panel.setLayout(null);
		mainPane = new JScrollPane(panel);
		mainPane.setBounds(0, 0, 800, 600);
		mainPane.getVerticalScrollBar().setUnitIncrement(20);
		// mainPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(mainPane);

		label1 = new JLabel("收款单信息：");
		label1.setBounds(20, 5, 100, 50);
		panel.add(label1);
		label2 = new JLabel("付款单信息：");
		label2.setBounds(20, 455, 100, 50);
		panel.add(label2);

		String[] infoI = { "员工编号", "机构编号", "收款日期", "收款金额", "快递员编号" };
		Vector<String> vColumnsI = new Vector<String>();
		for (int i = 0; i < 5; i++) {
			vColumnsI.add(infoI[i]);
		}

		tableI = new JTable(vDataI, vColumnsI) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableI.setBorder(BorderFactory.createEtchedBorder());
		tableI.setRowHeight(35);
		tableI.setRowSelectionAllowed(true);

		spI = new JScrollPane();
		spI.getViewport().add(tableI);
		spI.setBounds(50, 50, 700, 400);
		tableI.setFillsViewportHeight(true);
		panel.add(spI);

		String[] infoP = { "员工编号", "付款单编号", "付款日期", "付款金额", "付款人姓名", "付款账号",
				"付款种类", "次数" };
		Vector<String> vColumnsP = new Vector<String>();
		for (int i = 0; i < 8; i++) {
			vColumnsP.add(infoP[i]);
		}

		tableP = new JTable(vDataP, vColumnsP) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableP.setBorder(BorderFactory.createEtchedBorder());
		tableP.setRowHeight(35);
		tableP.setRowSelectionAllowed(true);

		spP = new JScrollPane();
		spP.getViewport().add(tableP);
		spP.setBounds(50, 500, 700, 400);
		tableP.setFillsViewportHeight(true);
		panel.add(spP);

		searchBtn = new JButton("按日期检索");
		searchBtn.setBounds(150, 930, 100, 30);
		panel.add(searchBtn);
		exportBtn = new JButton("导出报表");
		exportBtn.setBounds(350, 930, 100, 30);
		panel.add(exportBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(550, 930, 100, 30);
		panel.add(returnBtn);

		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RunFormDialog d = new RunFormDialog(getThis());
			}
		});
		exportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RunFormDialog d = new RunFormDialog(getThis(), 1);
			}
		});
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					initList();
					spI.getViewport().removeAll();
					spI.getViewport().add(tableI);
					tableI.repaint();
					spI.repaint();
					spP.getViewport().removeAll();
					spP.getViewport().add(tableP);
					tableP.repaint();
					spP.repaint();
					mainPane.repaint();
					flag = false;
					return;
				} else {
					Main.frame.returnToTop();
				}
			}
		});
	}

	private void initList() {
		listI = fc.getIncomes();
		listP = fc.getPayments();
		setVData();
		this.repaint();
	}

	public void reInitList(String start, String end) {
		if (DateUtil.isVaild(start, end) != null) {
			JOptionPane.showMessageDialog(null, DateUtil.isVaild(start, end),
					"", JOptionPane.ERROR_MESSAGE);
			return;
		}
		flag = true;
		d1 = DateUtil.stringToDate(start);
		d2 = DateUtil.stringToDate(end);

		listI = fc.getIncomes(d1, d2);
		vDataI.clear();

		for (IncomeVO vo : listI) {
			vDataI.add(toVectorI(vo));
		}

		listP = fc.getPayments(d1, d2);
		vDataP.clear();

		for (PaymentVO vo : listP) {
			vDataP.add(toVectorP(vo));
		}

		spI.getViewport().removeAll();
		spI.getViewport().add(tableI);
		tableI.repaint();
		spI.repaint();
		spP.getViewport().removeAll();
		spP.getViewport().add(tableP);
		tableP.repaint();
		spP.repaint();
		mainPane.repaint();
		this.repaint();
	}

	public void export(String start, String end) {
		if (DateUtil.isVaild(start, end) != null) {
			JOptionPane.showMessageDialog(null, DateUtil.isVaild(start, end),
					"", JOptionPane.ERROR_MESSAGE);
			return;
		}
		fc.exportRunForm(DateUtil.stringToDate(start),
				DateUtil.stringToDate(end));
		JOptionPane.showMessageDialog(null, "已导出到桌面");
	}

	private RunFormUI getThis() {
		return this;
	}

	private void setVData() {
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		int n = listI.size();
		for (int i = 0; i < n; i++) {
			Vector<String> tmp = toVectorI(listI.get(i));
			v.add(tmp);
			// System.out.println(vo.getName());
		}
		vDataI = v;
		v = new Vector<Vector<String>>();
		n = listP.size();
		for (int i = 0; i < n; i++) {
			Vector<String> tmp = toVectorP(listP.get(i));
			v.add(tmp);
			// System.out.println(vo.getName());
		}
		vDataP = v;
	}

	private Vector<String> toVectorI(IncomeVO vo) {
		Vector<String> tmp = new Vector<String>();
		tmp.add(vo.userID);
		tmp.add(vo.institutionID);
		tmp.add(DateUtil.dateToString(vo.date));
		// tmp.add(DateUtil.dateToString());
		tmp.add(vo.income + "");
		tmp.add(vo.kdyID);
		return tmp;
	}

	private Vector<String> toVectorP(PaymentVO vo) {
		Vector<String> tmp = new Vector<String>();
		tmp.add(vo.userID);
		tmp.add(vo.payID);
		tmp.add(DateUtil.dateToString(vo.d));
		tmp.add(vo.payment + "");
		tmp.add(vo.payName);
		tmp.add(vo.bankID);
		tmp.add(vo.type);
		tmp.add(vo.times + "");
		return tmp;
	}
}

class RunFormDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel label1;
	private JLabel label2;
	private JTextField field1;
	private JTextField field2;
	private JButton btn1;
	private JButton btn2;
	private RunFormUI ui;
	private boolean flag = false;

	public RunFormDialog(RunFormUI ui) {
		this.ui = ui;
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		initComponents();
	}

	public RunFormDialog(RunFormUI ui, int i) {
		this.ui = ui;
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.flag = true;

		initComponents();
	}

	private void initComponents() {
		label1 = new JLabel("起始日期：");
		label1.setBounds(25, 25, 100, 15);
		label2 = new JLabel("截止日期:");
		label2.setBounds(25, 75, 100, 15);
		field1 = new JTextField();
		field1.setBounds(100, 20, 175, 25);
		field1.setText(DateUtil.dateToString());
		field2 = new JTextField();
		field2.setBounds(100, 70, 175, 25);
		field2.setText(DateUtil.dateToString());
		this.getContentPane().add(label1);
		this.getContentPane().add(label2);
		this.getContentPane().add(field1);
		this.getContentPane().add(field2);

		btn1 = new JButton("确定");
		btn1.setBounds(50, 120, 75, 30);
		this.getContentPane().add(btn1);
		btn2 = new JButton("返回");
		btn2.setBounds(180, 120, 75, 30);
		this.getContentPane().add(btn2);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					ui.export(field1.getText(), field2.getText());
				} else {
					ui.reInitList(field1.getText(), field2.getText());
				}
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}