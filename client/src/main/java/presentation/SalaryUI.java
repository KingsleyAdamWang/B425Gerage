package presentation;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SalaryUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private final String[] labelName = { "中转单号", "出发地", "到达日期", "到达状态",
			"包含订单编号" };
	private final String[] typeName = { "完整", "损坏", "丢失" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String>[] box;
	private JButton submitBtn;
	private JButton returnBtn;
}
