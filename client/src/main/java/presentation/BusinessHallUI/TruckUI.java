package presentation.BusinessHallUI;

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
import vo.BussinessHallVo.TruckVO;
import businessLogic.businessHallBL.TruckController;
import client.Main;

public class TruckUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private TruckController tc;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private List<TruckVO> list;

	public TruckUI() {
		tc = new TruckController();
		vData = new Vector<Vector<String>>();
		this.initComponents();
		this.initList();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "车辆编号", "车牌号", "服役年限" };
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

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setAutoscrolls(false);
		scrollPane.setBounds(50, 50, 700, 385);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);

		funcButton = new JButton[5];
		final String[] title = { "新增车辆", "删除车辆", "查看信息", "修改信息", "返回" };
		for (int i = 0; i < 5; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(50 + 150 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new TruckAddUI(), "新增车辆");
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个车辆", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							int n = JOptionPane.showConfirmDialog(null,
									"确定删除该车辆信息?", "",
									JOptionPane.YES_NO_OPTION);
							if (n == 0) {
								try {
									tc.delete(list.get(index));
									JOptionPane
											.showMessageDialog(
													null,
													"删除成功",
													"",
													JOptionPane.INFORMATION_MESSAGE);
								} catch (RemoteException e1) {
									e1.printStackTrace();
								}
							}
						}
						initList();
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个车辆", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						Main.frame.setView(new TruckCheckUI(list.get(index)),
								"查看车辆信息");
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个车辆", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						Main.frame.setView(new TruckModifyUI(list.get(index)),
								"修改车辆信息");
					}
				});
				break;
			case 4:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.returnToTop();
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	private Vector<String> toVector(TruckVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.truckID);
		str.add(vo.truckNumber);
		str.add(vo.years + "");
		return str;
	}

	private void initList() {
		vData.clear();
		list = tc.getAllTruckVOList();

		for (TruckVO vo : list) {
			vData.add(toVector(vo));
		}
		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}
}
