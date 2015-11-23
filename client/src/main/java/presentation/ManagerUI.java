.3package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑
	
	private JButton[] funcButton;
	private JTable table;
	private DefaultTableModel infoListModel;

	public ManagerUI() {
		this.initComponents();
		this.validate();
	}
	
	private void initComponents() {
		this.setLayout(null);
		String[] info = { "姓名", "员工编号", "职位", "所属机构", "机构编号" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 5; i++) {
			vColumns.add(info[i]);
		}
		Vector<String[]> vData = new Vector<String[]>();
		// vData.add(new String[]{"王栋","141250132","sb","b425","425"});

		infoListModel = new DefaultTableModel(vData, vColumns);
		infoListModel.addRow(new String[] { "王栋", "141250132", "sb", "b425",
				"425" });
		// table = new JTable(2, 5) {
		table = new JTable(infoListModel) {
			// table = new JTable(new String[][]{{"1","2","3","4","5"}},info) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		// table.setRowHeight(0, 35);
		table.setRowHeight(30);
		table.setCellSelectionEnabled(false);
		// table.setBounds(50, 50, 700, 70);
		// for (int i = 0; i < 5; i++) {
		// table.setValueAt(info[i], 0, i);
		// }

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(50, 50, 700, 58);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
		// this.add(table);

		funcButton = new JButton[6];
		final String[] title = { "人员机构管理", "查看统计分析", "审批单据", "薪水策略制定",
				"业务策略制定", "日志查询" };
		for (int i = 0; i < 6; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(150+(i/3)*300, 200 + 100 * (i%3), 200, 50);
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
					}
				});
				break;
			case 4:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	public static void main(String[] args) {
		f = new MainFrame();
		ManagerUI view = new ManagerUI();
		f.setView(view);
	}
}
