package presentation.InventoryUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.InventoryVo.ShipmentVO;
import vo.ManageVo.InstitutionVO;
import businessLogic.inventoryBL.ShipmentController;
import client.Main;
import enumSet.ReceiptsState;

public class ShipmentUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private ShipmentController sc;
	private final String[] labelName = { "机构编号", "中转单编号", "快递单号", "目的地",
			"出库日期", "运输类型" };
	private final String[] type = { "汽车", "火车", "飞机" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JComboBox<String> destination;
	private JButton submitBtn;
	private JButton returnBtn;

	public ShipmentUI() throws RemoteException {
		sc = new ShipmentController();
		this.initComponents();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() throws RemoteException {
		this.setLayout(null);

		label = new JLabel[6];
		field = new JTextField[5];
		box = new JComboBox<String>(type);
		List<InstitutionVO> cityList = sc.getInstitutionList(MainFrame
				.getUser().getIdentityID());
		// List<InstitutionVO> cityList = sc.getInstitutionList("020010");
		String[] cities = new String[cityList.size()];
		for (int i = 0; i < cityList.size(); i++) {
			cities[i] = cityList.get(i).getName();
		}
		destination = new JComboBox<String>(cities);
		for (int i = 0; i < 6; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 80 + 50 * i, 100, 20);
			this.add(label[i]);
			if (i != 5 && i != 3) {
				field[i] = new JTextField();
				field[i].setBounds(305, 80 + 50 * i, 250, 30);
				this.add(field[i]);
			} else if (i == 5) {
				box.setBounds(305, 80 + 50 * i, 250, 30);
				this.add(box);
			} else if (i == 3) {
				destination.setBounds(305, 80 + 50 * i, 250, 30);
				this.add(destination);
			}
		}
		field[4].setText(DateUtil.dateToString());

		submitBtn = new JButton("提交");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					String result = sc.add(getVO());
					if (result != null) {
						JOptionPane.showMessageDialog(null, result, "",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "提交成功", "",
								JOptionPane.INFORMATION_MESSAGE);
						Main.frame.setView(new ShipmentUI(), "填写出库单");
					}
				} catch (RemoteException e1) {
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

	private ShipmentVO getVO() {
		ShipmentVO vo;
		String id = field[2].getText();
		Date date = DateUtil.stringToDate(field[4].getText());
		String institutionID = field[0].getText();
		String des = destination.getItemAt(destination.getSelectedIndex());
		String type = box.getItemAt(box.getSelectedIndex());
		String transferID = field[1].getText();
		vo = new ShipmentVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), id, date, institutionID, des, type,
				transferID);
		return vo;
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 6; i++) {
			if (i != 5 && i != 3) {
				if (field[i].getText().equals(""))
					return true;
			}
		}
		return false;
	}
}
