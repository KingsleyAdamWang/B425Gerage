package presentation.DeliverymanUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.MainFrame;
import presentation.ManageUI.ApproveChooseUI;
import vo.DeliverymanVo.ReceiveVO;
import businessLogic.manageBL.ApproveController;
import client.Main;

public class ReceiveApproveUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private ApproveController ac;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private List<ReceiveVO> list;

	public ReceiveApproveUI() throws RemoteException {
		ac = new ApproveController();
		this.initComponents();
		this.initList();
		this.validate();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
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
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个单据", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							Main.frame.setView(new ReceiveModifyUI(list
									.get(index)));
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个单据", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							ac.setApprovedReceive(list.get(index));
							JOptionPane.showMessageDialog(null, "审批完成", "",
									JOptionPane.INFORMATION_MESSAGE);
							Main.frame.setView(new ReceiveApproveUI());
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int n = JOptionPane.showConfirmDialog(null,
								"确定通过所有单据的审批?", "", JOptionPane.YES_NO_OPTION);
						if (n == 0) {
							try {
								ApproveController ac = new ApproveController();
								ac.setAllApprovedReceive();
								JOptionPane.showMessageDialog(null, "审批完成", "",
										JOptionPane.INFORMATION_MESSAGE);
								Main.frame.setView(new ReceiveApproveUI());
							} catch (RemoteException e1) {
								e1.printStackTrace();
							}
						}
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

	private Vector<String> toVector(ReceiveVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.id);
		str.add(vo.userID);
		str.add(vo.d);
		return str;
	}

	private void initList() {
		vData.clear();
		list = ac.getUnapproveReceive();

		for (ReceiveVO vo : list) {
			vData.add(toVector(vo));
		}
		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}
}
