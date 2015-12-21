package presentation.ManageUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.MainFrame;
import client.Main;
import vo.InstitutionVO;
import vo.UserVO;
import businessLogic.manageBL.StaffController;
import enumSet.Position;

public class StaffManageUI extends JPanel {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private StaffController sc;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private InstitutionVO instVO;

	public StaffManageUI(InstitutionVO instVO) throws RemoteException {
		this.sc = new StaffController();
		this.instVO = instVO;
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "编号", "姓名", "职位" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 3; i++) {
			vColumns.add(info[i]);
		}
		vData = new Vector<Vector<String>>();

		table = new JTable(vData, vColumns) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setRowHeight(35);
		table.setRowSelectionAllowed(true);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(50, 50, 700, 385);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);

		funcButton = new JButton[4];
		final String[] title = { "新增人员", "删除人员", "修改信息", "返回" };
		for (int i = 0; i < 4; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(50 + 200 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addStaff();
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteStaff();
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateStaff();
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new InstManageUI(), "人员机构管理");
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	protected void initList() {
		vData.clear();
		List<UserVO> list;
		try {
			list = sc.getUsersOfIns(instVO.getInstitutionID());
			for (UserVO vo : list) {
				vData.add(toVector(vo));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
	}

	private Vector<String> toVector(UserVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.getIdentityID());
		str.add(vo.getName());
		str.add(vo.getWork().getPositionString());
		str.add(vo.getPassword());
		str.add(vo.getInstitutionID());
		return str;
	}

	private UserVO toVO(Vector<String> str) {
		UserVO vo = new UserVO(str.get(1), str.get(3), str.get(0), str.get(4),
				Position.getPosition(str.get(2)));
		return vo;
	}

	private void addStaff() {
		StaffDialog dialog = new StaffDialog(this, "add");
		return;
	}

	private void deleteStaff() {
		int index = table.getSelectedRow();
		if (index == -1 || (vData.isEmpty() && index == 0)) {
			JOptionPane.showMessageDialog(null, "请选择一个员工", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定删除此员工吗?", "",
				JOptionPane.YES_NO_OPTION);
		if (n != 0)
			return;
		try {
			sc.deleteUser(toVO(vData.get(index)).getIdentityID());
			initList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	private void updateStaff() {
		int index = table.getSelectedRow();
		if (index == -1 || (vData.isEmpty() && index == 0)) {
			JOptionPane.showMessageDialog(null, "请选择一个员工", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		StaffDialog dialog = new StaffDialog(this, "update",
				toVO(vData.get(index)));
		return;
	}

	protected String getInsType() {
		return instVO.getType().getInsTypeString();
	}

	protected InstitutionVO getInsVO() {
		return instVO;
	}

	protected StaffController getController() {
		return this.sc;
	}

}

class StaffDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private String opr;
	private String name;
	private String id;
	StaffManageUI ui;
	UserVO vo;

	private JButton okBtn;
	private JButton returnBtn;
	private JTextField nameField;
	private JTextField idField;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel jobLabel;
	private JComboBox jobBox;
	private Vector<String> v;

	public StaffDialog() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		initComponents();
	}

	public StaffDialog(StaffManageUI ui, String opr) {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		this.ui = ui;
		this.opr = opr;
		initComponents();
	}

	public StaffDialog(StaffManageUI ui, String opr, UserVO vo) {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		this.ui = ui;
		this.opr = opr;
		this.vo = vo;
		initComponents();
	}

	private void initComponents() {
		nameLabel = new JLabel("姓名:");
		nameLabel.setBounds(25, 15, 50, 15);
		idLabel = new JLabel("编号:");
		idLabel.setBounds(25, 45, 50, 15);
		jobLabel = new JLabel("职位:");
		jobLabel.setBounds(25, 75, 50, 15);
		nameField = new JTextField();
		nameField.setBounds(90, 10, 185, 25);
		idField = new JTextField();
		idField.setBounds(90, 40, 185, 25);
		idField.setText(ui.getInsVO().getInstitutionID());
		v = new Vector<String>();
		if (ui.getInsType().equals("营业厅")) {
			v.add("快递员");
			v.add("营业厅业务人员");
		} else if (ui.getInsType().equals("中转中心")) {
			v.add("中转中心业务人员");
			v.add("中转中心仓库管理员");
		} else if (ui.getInsType().equals("管理层机构")) {
			v.add("财务人员（低）");
			v.add("财务人员（高）");
			v.add("总经理");
		}
		jobBox = new JComboBox<String>(v);
		jobBox.setBounds(90, 70, 150, 25);
		if (opr.equals("update")) {
			nameField.setText(vo.getName());
			idField.setText(vo.getIdentityID());
			idField.setEditable(false);
		}
		this.getContentPane().add(nameLabel);
		this.getContentPane().add(idLabel);
		this.getContentPane().add(jobLabel);
		this.getContentPane().add(nameField);
		this.getContentPane().add(idField);
		this.getContentPane().add(jobBox);

		okBtn = new JButton("确定");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (opr.equals("add")) {
					if (getUserName().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入员工姓名", "",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (getUserID().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入员工编号", "",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					UserVO user = new UserVO(getUserName(), null, getUserID(),
							ui.getInsVO().getInstitutionID(), getPosition());
					try {
						String result = ui.getController().addUser(getUserID(),
								user);
						if (result != null) {
							JOptionPane.showMessageDialog(null, result, "",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "添加成功", "",
									JOptionPane.INFORMATION_MESSAGE);
						}
						ui.initList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (opr.equals("update")) {
					if (getUserName().equals("")) {
						JOptionPane.showMessageDialog(null, "请输入员工姓名", "",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					UserVO user = new UserVO(getUserName(), null, getUserID(),
							ui.getInsVO().getInstitutionID(), getPosition());
					try {
						String result = ui.getController().updateUser(
								vo.getIdentityID(), user);
						if (result != null) {
							JOptionPane.showMessageDialog(null, result, "",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "修改成功", "",
									JOptionPane.INFORMATION_MESSAGE);
						}
						ui.initList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				setVisible(false);
			}
		});
		okBtn.setBounds(50, 120, 75, 30);
		this.getContentPane().add(okBtn);

		returnBtn = new JButton("返回");
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		returnBtn.setBounds(175, 120, 75, 30);
		this.getContentPane().add(returnBtn);

	}

	private String getUserName() {
		name = nameField.getText();
		return this.name;
	}

	private String getUserID() {
		id = idField.getText();
		return this.id;
	}

	private Position getPosition() {
		int i = jobBox.getSelectedIndex();
		Position p = Position.getPosition(v.get(i));
		return p;
	}
}
