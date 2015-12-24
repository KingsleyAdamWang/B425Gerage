package presentation.DeliverymanUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.DeliverymanVo.ReceiveVO;
import businessLogic.deliveryBL.ReceiveController;
import enumSet.ReceiptsState;

public class ReceiveModifyUI extends JPanel {
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
	private ReceiveVO vo;

	public ReceiveModifyUI(ReceiveVO vo) throws RemoteException {
		this.vo = vo;
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
		field[3].setText(DateUtil.dateToString());

		submitBtn = new JButton("保存修改");
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

		field[0].setText(vo.id);
		field[1].setText(vo.name);
		field[2].setText(vo.telNum);
		field[3].setText(vo.d);
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

	public static void main(String[] args) throws RemoteException {
		f = new MainFrame();
		ReceiveUI view = new ReceiveUI();
		f.setView(view);
	}
}