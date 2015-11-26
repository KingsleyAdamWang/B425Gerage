package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import businessLogic.manageBL.StrategyController;

public class StrategyUI extends JPanel implements TableModelListener {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private StrategyController sc;
	private JLabel[] title;
	private JLabel[] label;
	private JSeparator[] js;
	private JTextField[] field;
	private JTable table;
	private DefaultTableModel model;
	private Vector<Vector<String>> vData;
	private JScrollPane scroll;

	public StrategyUI() throws RemoteException {
		 this.sc = new StrategyController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);
		String[] titleMsg = { "运输成本（每公里每吨）：", "快递价格比：",
				"标准快递价格（x/(km*kg/1000)）：", "包装费：", "城市间距离（公里）：" };
		title = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			title[i] = new JLabel(titleMsg[i]);
			title[i].setFont(new Font("宋体", Font.BOLD, 13));
			title[i].setBounds(20, 20 + 70 * i, 300, 20);
			this.add(title[i]);
		}

		js = new JSeparator[4];
		for (int i = 0; i < 4; i++) {
			js[i] = new JSeparator();
			js[i].setBounds(20, 85 + 70 * i, 760, 20);
			this.add(js[i]);
		}

		label = new JLabel[4];
		label[0] = new JLabel(
				"汽车：        元;                      火车：        元;                      飞机：        元");
		label[1] = new JLabel("经济快递：标准快递：特快专递 =             :           :");
		label[2] = new JLabel("x =          元");
		label[3] = new JLabel(
				"纸箱：        元;          木箱：        元;          快递袋：        元;          其他：        元");
		for (int i = 0; i < 4; i++) {
			// label[i].setFont(new Font("宋体",Font.PLAIN, 12));
			label[i].setBounds(50, 30 + 70 * i, 760, 50);
			this.add(label[i]);
		}

		field = new JTextField[11];
		for (int i = 0; i < 3; i++) {
			field[i] = new JTextField();
			field[i].setBounds(80 + 235 * i, 45, 50, 20);
			this.add(field[i]);
		}
		for (int i = 0; i < 3; i++) {
			field[i + 3] = new JTextField();
			field[i + 3].setBounds(250 + 70 * i, 115, 50, 20);
			this.add(field[i + 3]);
		}
		field[6] = new JTextField();
		field[6].setBounds(75, 185, 50, 20);
		this.add(field[6]);
		for (int i = 0; i < 4; i++) {
			field[i + 7] = new JTextField();
			field[i + 7].setBounds(80 + 164 * i + 8 * (i / 2), 255, 50, 20);
			this.add(field[i + 7]);
		}

		// List<String> list = sc.getCities();
		// int n = list.size();
		JSeparator js1 = new JSeparator();
		JSeparator js2 = new JSeparator(JSeparator.VERTICAL);
		js1.setBounds(50, 349, 600, 1);
		js2.setBounds(49, 350, 1, 200);
		this.add(js1);
		this.add(js2);

		setVData();
		int n = vData.size();
		int rowHeight = 200 / n;
		// if (rowHeight < 30)
		// rowHeight = 30;
		model = new DefaultTableModel(n, n) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (row == 0 || column == 0 || row == column)
					return false;
				return true;
			}

		};
		model.setDataVector(vData, vData);
		model.addTableModelListener(this);
		table = new JTable(model);
		table.getTableHeader().setVisible(false);
		table.setBounds(50, 350, 600, 200);
		table.setRowSelectionAllowed(false);
		table.setBorder(null);
		table.setRowHeight(rowHeight);
		this.add(table);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				if (row == 0 || column == 0 )
//					cell.setBackground(Color.gray);
					cell.setFont(new Font("宋体", 1, 12));
				else
					cell.setBackground(Color.WHITE);
				return cell;
			}
		};
		for (int i = 0; i < n; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
//			table.getColumn(i).setCellRenderer(tcr);
		}
		// scroll = new JScrollPane();
		// scroll.getViewport().add(table);
		// scroll.setBounds(50, 350, 600, 200);
		// scroll.setBorder(null);
		// scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// table.setFillsViewportHeight(true);
		// this.add(scroll);
	}

	private void setVData() {
		vData = new Vector<Vector<String>>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("北京");
		list.add("上海");
		list.add("广州");
		list.add("南京");
		int n = list.size();
		for (int i = 0; i < n + 1; i++) {
			Vector<String> v = new Vector<String>();
			for (int j = 0; j < n + 1; j++) {
				if (i == 0) {
					if (j == 0)
						v.add("");
					else
						v.add(list.get(j - 1));
				} else {
					if (j == 0)
						v.add(list.get(i - 1));
					else if (i == j)
						v.add("-");
					else
						v.add(list.get(i - 1));
				}
			}
			vData.add(v);
		}
	}

	public static void main(String[] args) throws RemoteException {
		f = new MainFrame();
		StrategyUI view = new StrategyUI();
		f.setView(view);
	}

	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int col = e.getColumn();
		String s = (String) model.getValueAt(row, col);
		if (!isNumeric(s)) {
			setValue("0", row, col);
			setValue("0", col, row);
		} else {
			setValue(s, col, row);
		}
		table.repaint();
	}

	private void setValue(String s, int row, int col) {
		Vector<String> v = vData.get(row);
		v.set(col, s);
		vData.set(row, v);
	}

	private boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
