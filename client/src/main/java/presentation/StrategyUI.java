package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import client.Main;
import util.Distance;
import util.PackPrice;
import vo.PriceConstVO;
import businessLogic.manageBL.StrategyController;
import enumSet.PackType;

public class StrategyUI extends JPanel implements TableModelListener {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private StrategyController sc;
	private PriceConstVO vo;
	private JLabel[] title;
	private JLabel[] label;
	private JSeparator[] js;
	private JTextField[] field;
	private JTable table;
	private DefaultTableModel model;
	private Vector<Vector<String>> vData;
	// private JScrollPane scroll;
	private List<String> list;
	private JButton[] button;

	public StrategyUI() throws RemoteException {
		this.sc = new StrategyController();
		this.vo = sc.getVO();
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
				if (row == 0 || column == 0)
					// cell.setBackground(Color.gray);
					cell.setFont(new Font("宋体", 1, 12));
				else
					cell.setBackground(Color.WHITE);
				return cell;
			}
		};
		for (int i = 0; i < n; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
			// table.getColumn(i).setCellRenderer(tcr);
		}
		// scroll = new JScrollPane();
		// scroll.getViewport().add(table);
		// scroll.setBounds(50, 350, 600, 200);
		// scroll.setBorder(null);
		// scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// table.setFillsViewportHeight(true);
		// this.add(scroll);

		String[] btnName = { "添加城市", "保存修改", "返回" };
		button = new JButton[3];
		for (int i = 0; i < 3; i++) {
			button[i] = new JButton(btnName[i]);
			button[i].setBounds(680, 420 + 50 * i, 80, 30);
			this.add(button[i]);
		}
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String) JOptionPane.showInputDialog(null,
						"请输入城市名称：\n", "", JOptionPane.PLAIN_MESSAGE, null,
						null, "");
				if (name == null)
					return;
				if (list.contains(name)) {
					JOptionPane.showMessageDialog(null, "该城市已存在", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				list.add(name);
				setVData();
				updateTable();
				// System.out.println(name);
			}
		});
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "确定", "取消" };
				int m = JOptionPane
						.showOptionDialog(null, "确定保存修改吗？", "",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[0]);
				if (m == 0) {
					try {
						sc.modify(getVO());
						JOptionPane.showMessageDialog(null, "保存成功", "",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// System.out.println(m);
			}
		});
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.setView(new ManagerUI());
			}
		});

		setShowData();
	}

	private void updateTable() {
		this.remove(table);
		System.out.println("12345");
		setVData();
		int n = vData.size();
		int rowHeight = 200 / n;
		int colWidth = 600 / n;
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
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		for (int i = 0; i < n; i++) {
			TableColumn firsetColumn = table.getColumnModel().getColumn(i);
			firsetColumn.setWidth(colWidth);
		}
		this.add(table);

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				if (row == 0 || column == 0)
					cell.setFont(new Font("宋体", 1, 12));
				else
					cell.setBackground(Color.WHITE);
				return cell;
			}
		};
		for (int i = 0; i < n; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
		this.repaint();
	}

	private void setVData() {
		vData = new Vector<Vector<String>>();
		if (list == null) {
			list = sc.getCities();
		}
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
						v.add(sc.getDistance(list.get(i - 1), list.get(j - 1))
								+ "");
				}
			}
			vData.add(v);
		}
	}

	private void setShowData() {
		vo = sc.getVO();
		field[0].setText(vo.getCarCost() + "");
		field[1].setText(vo.getTrainCost() + "");
		field[2].setText(vo.getPlaneCost() + "");
		field[3].setText(vo.getEconomy() + "");
		field[4].setText(vo.getStandard() + "");
		field[5].setText(vo.getFast() + "");
		field[6].setText(vo.getStandard_const() + "");
		field[7].setText(vo.getPackPrice().get(0).getFare() + "");
		field[8].setText(vo.getPackPrice().get(1).getFare() + "");
		field[9].setText(vo.getPackPrice().get(2).getFare() + "");
		field[10].setText(vo.getPackPrice().get(3).getFare() + "");
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
		if (str.equals(""))
			return false;
		// for (int i = 0; i < str.length(); i++) {
		// System.out.println(str.charAt(i));
		// if (!Character.isDigit(str.charAt(i))) {
		// return false;
		// }
		// }
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private PriceConstVO getVO() {
		double[] d = new double[7];
		for (int i = 0; i < 7; i++) {
			d[i] = Double.parseDouble(field[i].getText());
		}
		List<PackPrice> listP = new ArrayList<PackPrice>();
		listP.add(new PackPrice(PackType.getPackType("纸箱"), Double
				.parseDouble(field[7].getText())));
		listP.add(new PackPrice(PackType.getPackType("木箱"), Double
				.parseDouble(field[8].getText())));
		listP.add(new PackPrice(PackType.getPackType("快递袋"), Double
				.parseDouble(field[9].getText())));
		listP.add(new PackPrice(PackType.getPackType("其他"), Double
				.parseDouble(field[10].getText())));
		List<Distance> listD = new ArrayList<Distance>();
		int n = list.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				listD.add(new Distance(list.get(i), list.get(j), Double
						.parseDouble((String) model.getValueAt(i + 1, j + 1))));
			}
		}
		PriceConstVO vo = new PriceConstVO(d[2], d[1], d[0], d[3], d[4], d[5],
				d[6], listD, listP);
		return vo;
	}
}
