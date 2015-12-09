package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enumSet.ReceiptsState;
import vo.ReceiveVO;
import businessLogic.deliveryBL.ReceiveController;

public class ReceiveUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private ReceiveController rc;
	private final String[] labelName = { "快递单号", "收件人姓名", "收件人电话", "收件日期" };
	private JLabel[] label;
	private JTextField[] field;
	private JButton submitBtn;
	private JButton returnBtn;

	public ReceiveUI() {
		rc = new ReceiveController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[4];
		field = new JTextField[4];
		for (int i = 0; i < 4; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 100 + 50 * i, 100, 20);
			this.add(label[i]);
			field[i] = new JTextField();
			field[i].setBounds(305, 100 + 50 * i, 250, 30);
			this.add(field[i]);
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

	private boolean hasEmpty() {
		for (int i = 0; i < 4; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private ReceiveVO getReceiveVO() {
		return new ReceiveVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), field[0].getText(),
				field[1].getText(), field[2].getText(), field[3].getText());
	}

	public static void main(String[] args) {
		f = new MainFrame();
		ReceiveUI view = new ReceiveUI();
		f.setView(view);
	}
}
