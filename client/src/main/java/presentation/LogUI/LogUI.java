package presentation.LogUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.MainFrame;
import presentation.FinanceUI.FinanceHighUI;
import presentation.ManageUI.ManagerUI;
import util.DateUtil;
import vo.LogVo.LogVO;
import businessLogic.logBL.LogController;
import client.Main;

public class LogUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private LogController lc;
	private JButton searchDateBtn;
	private JButton searchUserBtn;
	private JButton returnBtn;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane sp;
	private List<LogVO> list;

	public LogUI() throws RemoteException {
		this.lc = new LogController();
		vData = new Vector<Vector<String>>();
		this.initList();
		this.initComponents();
		this.validate();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "时间", "用户编号", "操作" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 3; i++) {
			vColumns.add(info[i]);
		}

		table = new JTable(vData, vColumns) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setRowHeight(35);
		table.setRowSelectionAllowed(true);

		sp = new JScrollPane();
		sp.getViewport().add(table);
		sp.setBounds(50, 50, 700, 400);
		table.setFillsViewportHeight(true);
		this.add(sp);

		searchDateBtn = new JButton("按日期检索");
		searchDateBtn.setBounds(150, 480, 100, 30);
		this.add(searchDateBtn);
		searchUserBtn = new JButton("按用户检索");
		searchUserBtn.setBounds(350, 480, 100, 30);
		this.add(searchUserBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(550, 480, 100, 30);
		this.add(returnBtn);

		searchDateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,
						"请输入需查询的日期：\n", "title", JOptionPane.PLAIN_MESSAGE,
						null, null, DateUtil.dateToString());
				if (s == null) {
					return;
				}
				if (DateUtil.isVaild(s) == null) {
					list = lc.getLogListOfDate(DateUtil.stringToDate(s));
					reInitList(DateUtil.stringToDate(s));
					return;
				} else {
					JOptionPane.showMessageDialog(null, DateUtil.isVaild(s),
							"", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});

		searchUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,
						"请输入需查询的员工编号：\n", "title", JOptionPane.PLAIN_MESSAGE,
						null, null, "");
				if (s == null) {
					return;
				}
				list = lc.getLogListOfUser(s);
				reInitList(s);
				return;
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = MainFrame.getUser().getWork().getPositionString();
				if (str.equals("财务人员（高）")) {
					Main.frame.setView(new FinanceHighUI());
				} else if (str.equals("财务人员（高）")) {
					Main.frame.setView(new FinanceHighUI());
				} else if (str.equals("总经理")) {
					Main.frame.setView(new ManagerUI());
				}
			}
		});
	}

	private void initList() {
		list = lc.getAllLogList();
		vData = getShowList();
		// table.validate();
		// scrollPane.getViewport().removeAll();
		// scrollPane.getViewport().add(table);
		// this.initComponents();
		this.repaint();
	}

	private void reInitList(Date d) {
		list = lc.getLogListOfDate(d);
		vData.clear();

		for (LogVO vo : list) {
			vData.add(toVector(vo));
		}

		sp.getViewport().removeAll();
		sp.getViewport().add(table);
		table.repaint();
		sp.repaint();
		this.repaint();
	}

	private void reInitList(String s) {
		list = lc.getLogListOfUser(s);
		vData.clear();

		for (LogVO vo : list) {
			vData.add(toVector(vo));
		}

		sp.getViewport().removeAll();
		sp.getViewport().add(table);
		table.repaint();
		sp.repaint();
		this.repaint();
	}

	private Vector<Vector<String>> getShowList() {
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			Vector<String> tmp = toVector(list.get(i));
			v.add(tmp);
			// System.out.println(vo.getName());
		}
		return v;
	}

	private Vector<String> toVector(LogVO vo) {
		Vector<String> tmp = new Vector<String>();
		tmp.add(DateUtil.dateToStringDetail(vo.getD()));
		tmp.add(vo.getIdentityID());
		tmp.add(vo.getMessage());
		return tmp;
	}
}
