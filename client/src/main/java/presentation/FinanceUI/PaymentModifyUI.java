package presentation.FinanceUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.FinanceVo.PaymentVO;
import businessLogic.financeBL.PaymentController;
import client.Main;
import enumSet.ReceiptsState;

public class PaymentModifyUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private PaymentController pc;
	private final String[] labelName = { "付款单号", "付款账号", "付款金额", "付款日期",
			"付款人姓名", "付款类型", "次数", "备注" };
	private final String[] type = { "工资", "运费", "租金", "其他" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JButton submitBtn;
	private JButton returnBtn;
	private PaymentVO vo;

	public PaymentModifyUI(PaymentVO vo) throws RemoteException {
		this.vo = vo;
		pc = new PaymentController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[8];
		field = new JTextField[8];
		box = new JComboBox<String>(type);
		for (int i = 0; i < 8; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 50 + 50 * i, 100, 20);
			this.add(label[i]);
			if (i != 5) {
				field[i] = new JTextField();
				field[i].setBounds(305, 50 + 50 * i, 250, 30);
				this.add(field[i]);
			} else if (i == 5) {
				box.setBounds(305, 50 + 50 * i, 250, 30);
				this.add(box);
			}
		}
		field[3].setText(DateUtil.dateToString());

		submitBtn = new JButton("保存修改");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pc.addPayment(getVO());
					JOptionPane.showMessageDialog(null, "提交成功", "",
							JOptionPane.INFORMATION_MESSAGE);
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

		field[0].setText(vo.payID);
		field[1].setText(vo.bankID);
		field[2].setText(vo.payment + "");
		field[3].setText(DateUtil.dateToString(vo.d));
		field[4].setText(vo.payName);
		field[6].setText(vo.times + "");
		field[7].setText(vo.comment);
	}

	private PaymentVO getVO() {
		PaymentVO vo;
		String userID = MainFrame.getUser().getIdentityID();
		String payID = field[0].getText();
		Date d = DateUtil.stringToDate(field[3].getText());
		double payment = Double.parseDouble(field[2].getText());
		String payName = field[4].getText();
		String bankID = field[1].getText();
		String type = (String) box.getSelectedItem();
		String comment = field[7].getText();
		int times = Integer.parseInt(field[6].getText());
		vo = new PaymentVO(ReceiptsState.getReceiptsState("未审批"), userID,
				payID, d, payment, payName, bankID, type, comment, times);
		return vo;
	}

	public static void main(String[] args) throws RemoteException {
		f = new MainFrame();
		PaymentUI view = new PaymentUI();
		f.setView(view);
	}
}
