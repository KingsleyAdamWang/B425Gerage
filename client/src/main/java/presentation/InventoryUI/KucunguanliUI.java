package presentation.InventoryUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import presentation.MainFrame;
import util.DateUtil;
import vo.InventoryVo.EntryVO;
import vo.InventoryVo.InventoryVO;
import businessLogic.inventoryBL.InventoryController;
import client.Main;
import enumSet.InventoryArea;

public class KucunguanliUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private InventoryController ic;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private List<EntryVO> list;
	private InventoryArea area;

	public KucunguanliUI(String s) throws RemoteException {
		ic = new InventoryController();
		area = InventoryArea.getInventoryArea(s);
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "快递编号", "入库时间", "排号", "架号", "位号" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 5; i++) {
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
		final String[] title = { "库存调整", "返回" };
		for (int i = 0; i < 2; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(250 + 200 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个货物", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						InvenDialog dialog = new InvenDialog(list.get(index),
								ic);
						return;
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.setView(new KucunChooseUI());
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	private Vector<String> toVector(EntryVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.id);
		str.add(DateUtil.dateToString(vo.date));
		str.add(vo.row + "");
		str.add(vo.shelf + "");
		str.add(vo.place + "");
		return str;
	}

	private void initList() throws RemoteException {
		vData.clear();
		list = ic.getEntryList(MainFrame.getUser().getInstitutionID(), area);

		for (EntryVO vo : list) {
			vData.add(toVector(vo));
		}
		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}
}

class InvenDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JButton okBtn;
	private JButton returnBtn;
	private JTextField[] field;
	private JLabel[] label;
	private String[] title = { "排号", "架号", "位号" };
	private EntryVO vo;
	private InventoryController ic;

	public InvenDialog(EntryVO vo, InventoryController ic) {
		this.vo = vo;
		this.ic = ic;
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		initComponents();
	}

	private void initComponents() {
		for (int i = 0; i < 3; i++) {
			label[i] = new JLabel(title[i] + ":");
			label[i].setBounds(20, 40 * i, 100, 20);
			field[i] = new JTextField();
			field[i].setBounds(105, 40 * i, 250, 30);
			this.add(label[i]);
			this.add(field[i]);
		}
		field[0].setText(vo.row + "");
		field[1].setText(vo.shelf + "");
		field[2].setText(vo.place + "");

		okBtn = new JButton("调整");
		okBtn.setBounds(50, 120, 75, 30);
		this.getContentPane().add(okBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(175, 120, 75, 30);
		this.getContentPane().add(returnBtn);

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = Integer.parseInt(field[0].getText());
				int shelf = Integer.parseInt(field[1].getText());
				int place = Integer.parseInt(field[2].getText());
				vo.row = row;
				vo.shelf = shelf;
				vo.place = place;
				try {
					String result = ic.adjust(vo);
					if (result != null) {
						JOptionPane.showMessageDialog(null, result, "",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "调整成功", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
