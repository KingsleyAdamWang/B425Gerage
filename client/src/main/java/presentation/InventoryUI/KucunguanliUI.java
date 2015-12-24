package presentation.InventoryUI;

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

import presentation.MainFrame;
import presentation.ManageUI.ApproveChooseUI;
import util.DateUtil;
import vo.DeliverymanVo.SendVO;
import vo.InventoryVo.EntryVO;
import businessLogic.inventoryBL.InventoryController;
import businessLogic.manageBL.ApproveController;
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
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
