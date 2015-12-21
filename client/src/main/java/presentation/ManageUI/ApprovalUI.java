package presentation.ManageUI;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.MainFrame;

public class ApprovalUI extends JPanel {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;

	public ApprovalUI(){
		
	}
	
	private void initComponents() {
		this.setLayout(null);

		String[] info = { "机构编号", "机构名称", "地点", "机构类型" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 4; i++) {
			vColumns.add(info[i]);
		}
		// vData = new Vector<Vector<String>>();

		table = new JTable(vData, vColumns) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setRowHeight(35);
		table.setRowSelectionAllowed(true);
		// table.setBounds(50, 50, 700, 385);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		// scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// scrollPane.setLocation(50, 50);
		scrollPane.setAutoscrolls(false);
		// scrollPane.setVisible(true);
		scrollPane.setBounds(50, 50, 700, 385);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}
}
