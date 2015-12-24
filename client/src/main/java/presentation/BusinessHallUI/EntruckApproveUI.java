package presentation.BusinessHallUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.ManageUI.ApproveChooseUI;
import util.DateUtil;
import vo.BussinessHallVo.DeliveryVO;
import vo.BussinessHallVo.EntruckVO;
import businessLogic.manageBL.ApproveController;
import client.Main;

public class EntruckApproveUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private ApproveController ac;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private List<EntruckVO> list;

	public EntruckApproveUI() throws RemoteException {
		ac = new ApproveController();
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "单据编号", "填写人编号", "填写日期" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 3; i++) {
			vColumns.add(info[i]);
		}
		vData = new Vector<Vector<String>>();

		table = new JTable(vData, vColumns) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setRowHeight(35);
		table.setRowSelectionAllowed(true);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(50, 50, 700, 385);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);

		funcButton = new JButton[4];
		final String[] title = { "查看信息", "通过审批", "一键审批", "返回" };
		for (int i = 0; i < 4; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(50 + 200 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new ApproveChooseUI(), "审批单据");
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	private Vector<String> toVector(EntruckVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.qyID);
		str.add(vo.userID);
		str.add(vo.d);
		return str;
	}

	private void initList() {
		vData.clear();
		list = ac.getUnapprovedEntruck();

		for (EntruckVO vo : list) {
			vData.add(toVector(vo));
		}
		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}
}
