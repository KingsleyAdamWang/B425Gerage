package presentation.FinanceUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.Main;
import businessLogic.financeBL.FormController;

public class ProfitFormUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private FormController fc;
	private final String[] labelName = { "总收入", "总支出", "总利润" };
	private JLabel[] label;
	private JTextField[] field;
	private JButton exportBtn;
	private JButton returnBtn;

	public ProfitFormUI() {
		fc = new FormController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[3];
		field = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 70 + 50 * i, 100, 20);
			this.add(label[i]);
			field[i] = new JTextField();
			field[i].setBounds(305, 70 + 50 * i, 250, 30);
			this.add(field[i]);
		}

		exportBtn = new JButton("导出报表");
		exportBtn.setBounds(150, 930, 100, 30);
		this.add(exportBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(550, 930, 100, 30);
		this.add(returnBtn);
		exportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.exportCostForm();
				JOptionPane.showMessageDialog(null, "已导出到桌面");
			}
		});
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});

		fc.getIncomes();
		fc.getPayments();
		double totalI = fc.getTotalIncome();
		double totalP = fc.getTotalPay();
		field[0].setText(totalI + "");
		field[1].setText(totalP + "");
		field[2].setText(totalI - totalP + "");
	}
}
