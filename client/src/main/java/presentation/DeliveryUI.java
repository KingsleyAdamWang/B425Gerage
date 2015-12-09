package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.DateUtil;
import vo.DeliveryVO;
import businessLogic.businessHallBL.DeliveryController;
import enumSet.ReceiptsState;

public class DeliveryUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private DeliveryController dc;
	private final String[] labelName = { "快递单号", "派送员", "到达日期", "到达状态" };
	private final String[] typeName = { "完整", "损坏", "丢失" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JButton submitBtn;
	private JButton returnBtn;

	public DeliveryUI() throws RemoteException {
		dc = new DeliveryController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[4];
		field = new JTextField[3];
		box = new JComboBox<String>(typeName);
		for (int i = 0; i < 4; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100, 20);
			this.add(label[i]);
			if (i < 3) {
				field[i] = new JTextField();
				field[i].setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(field[i]);
			} else {
				box.setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250, 30);
				this.add(box);
			}
		}

		submitBtn = new JButton("提交");
		returnBtn = new JButton("返回");
		submitBtn.setBounds(250, 520, 80, 30);
		returnBtn.setBounds(450, 520, 80, 30);
		this.add(submitBtn);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 3; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private DeliveryVO getDeliveryVO() {
		return new DeliveryVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), DateUtil.stringToDate(field[2]
				.getText()), field[0].getText(), field[1].getText());
	}

	public static void main(String[] args) throws RemoteException {
		f = new MainFrame();
		DeliveryUI view = new DeliveryUI();
		f.setView(view);
	}
}
