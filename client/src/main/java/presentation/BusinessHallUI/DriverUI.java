package presentation.BusinessHallUI;

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
import vo.DriverVO;
import vo.InstitutionVO;
import client.Main;
import businessLogic.businessHallBL.DriverController;

public class DriverUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private DriverController dc;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private List<DriverVO> list;

	public DriverUI() {
		dc = new DriverController();
		vData = new Vector<Vector<String>>();
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "司机编号", "司机姓名", "性别" };
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
		final String[] title = { "新增司机", "删除司机", "查看信息", "修改信息", "返回" };
		for (int i = 0; i < 5; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(50 + 150 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new DriverAddUI(), "新增司机");
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个司机", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						dc.delete(list.get(index));
						initList();
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个司机", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						Main.frame.setView(new DriverCheckUI(list.get(index)),
								"查看司机信息");
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个司机", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						Main.frame.setView(new DriverModifyUI(list.get(index)),
								"修改司机信息");
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

	private Vector<String> toVector(DriverVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.id);
		str.add(vo.name);
		str.add(vo.sex.getSexString());
		return str;
	}

	private void initList() {
		vData.clear();
		list = dc.getDriversByIns(MainFrame.getUser().getInstitutionID());

		for (DriverVO vo : list) {
			vData.add(toVector(vo));
		}
		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}
}
