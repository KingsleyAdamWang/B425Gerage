package presentation.ManageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.Salary;
import vo.SalaryVO;
import businessLogic.manageBL.SalaryController;
import client.ClientInitException;
import client.Main;
import enumSet.Position;

public class SalaryUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private SalaryController sc;
	private final String[] position = { "快递员", "营业厅业务人员", "中转中心业务人员",
			"中转中心仓库管理员", "财务人员（高）", "财务人员（低）", "总经理", "管理员" };
	private JLabel[] label;
	private JLabel[] label2;
	private JTextField[] field;
	private JButton submitBtn;
	private JButton returnBtn;

	public SalaryUI() throws RemoteException {
		sc = new SalaryController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[8];
		field = new JTextField[8];
		label2 = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			label[i] = new JLabel(position[i] + ":");
			label[i].setBounds(250, 50 * (i + 1), 150, 20);
			label2[i] = new JLabel("元/月");
			label2[i].setBounds(490, 50 * (i + 1), 150, 20);
			field[i] = new JTextField();
			field[i].setBounds(385, 50 * (i + 1), 100, 30);
			this.add(label[i]);
			this.add(label2[i]);
			this.add(field[i]);
		}
		try {
			this.setInfo();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		submitBtn = new JButton("确定");
		submitBtn.setBounds(200, 470, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 470, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = sc.modify(getVO());
					if (s == null) {
						JOptionPane.showMessageDialog(null, "修改成功", "",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, s, "",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});
	}

	private void setInfo() throws RemoteException {
		SalaryVO vo = sc.getSalary();
		List<Salary> list = vo.salaryList;
		if (list.size() == 8) {
			for (int i = 0; i < 8; i++)
				field[i].setText(list.get(i).getSalary() + "");
		}
	}

	private SalaryVO getVO() throws RemoteException {
		List<Salary> list = new ArrayList<Salary>();
		for (int i = 0; i < 8; i++) {
			try {
				list.add(new Salary(Position.getPosition(position[i]), Double
						.parseDouble(field[i].getText())));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "输入信息格式有误", "",
						JOptionPane.ERROR_MESSAGE);
				return sc.getSalary();
			}
		}
		return new SalaryVO(list);
	}

	public static void main(String[] args) throws RemoteException,
			ClientInitException {
		f = new MainFrame();
		SalaryUI view = new SalaryUI();
		f.setView(view);
	}
}
