package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShipmentUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private final String[] labelName = { "机构编号", "中转单编号", "快递单号", "目的地",
			"出库日期", "运输类型" };
	private final String[] type = { "汽车", "火车", "飞机" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JButton submitBtn;
	private JButton returnBtn;

	public ShipmentUI() {
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[6];
		field = new JTextField[5];
		box = new JComboBox<String>(type);
		for (int i = 0; i < 6; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 80 + 50 * i, 100, 20);
			this.add(label[i]);
			if (i < 5) {
				field[i] = new JTextField();
				field[i].setBounds(305, 80 + 50 * i, 250,
						30);
				this.add(field[i]);
			} else {
				box.setBounds(305, 80 + 50 * i, 250, 30);
				this.add(box);
			}
		}
		
		submitBtn = new JButton("提交");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	public static void main(String[] args) {
		f = new MainFrame();
		ShipmentUI view = new ShipmentUI();
		f.setView(view);
	}
}
