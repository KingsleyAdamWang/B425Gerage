package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import util.Storage;
import vo.InstitutionVO;
import vo.InventoryVO;
import businessLogic.manageBL.InstitutionController;
import businessLogic.manageBL.StaffController;
import enumSet.InsType;

public class InstManageUI extends JPanel {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private InstitutionController ic;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;

	public InstManageUI() throws RemoteException {
		this.ic = new InstitutionController();
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "机构编号", "机构名称", "地点", "机构类型" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 4; i++) {
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

		funcButton = new JButton[5];
		final String[] title = { "新增机构", "删除机构", "修改信息", "人员管理", "返回" };
		for (int i = 0; i < 5; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(50 + 150 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addInst();
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							deleteInst();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 2:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						updateInst();
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个机构", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							f.setView(new StaffManageUI(toVO(vData.get(index))));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 4:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	protected InstitutionController getInsController() {
		return this.ic;
	}

	protected void initList() {
		vData.clear();

		for (InstitutionVO vo : ic.show()) {
			vData.add(toVector(vo));
		}
		this.repaint();
	}

	private void addInst() {
		Object[] options = { "营业厅", "中转中心" };
		int m = JOptionPane.showOptionDialog(null, "请选择机构类型", "",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, options[0]);
		InstManageDialog dialog;
		if (m != -1)
			dialog = new InstManageDialog(this, "add", m);
		return;
	}

	private void deleteInst() throws RemoteException {
		int index = table.getSelectedRow();
		if (index == -1 || (vData.isEmpty() && index == 0)) {
			JOptionPane.showMessageDialog(null, "请选择一个机构", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定删除此机构吗?", "",
				JOptionPane.YES_NO_OPTION);
		if (n != 0)
			return;
		ic.deleteIns(toVO(vData.get(index)));
		initList();
		return;
	}

	private void updateInst() {
		int index = table.getSelectedRow();
		if (index == -1 || (vData.isEmpty() && index == 0)) {
			JOptionPane.showMessageDialog(null, "请选择一个机构", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		InstManageDialog dialog = new InstManageDialog(this, "update",
				toVO(vData.get(index)));
		return;
	}

	public static void main(String[] args) throws RemoteException {
		f = new MainFrame();
		InstManageUI view = new InstManageUI();
		f.setView(view);
	}

	public InstitutionController getController() {
		return this.ic;
	}

	private Vector<String> toVector(InstitutionVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.getInstitutionID());
		str.add(vo.getName());
		str.add(vo.getCity());
		str.add(vo.getType().getInsTypeString());
		return str;
	}

	private InstitutionVO toVO(Vector<String> str) {
		InstitutionVO vo = new InstitutionVO(str.get(0), str.get(2),
				str.get(1), InsType.getInsType(str.get(3)));
		return vo;
	}
}

class InstManageDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private String opr = "";
	private String type = "";
	InstManageUI ui;
	InstitutionVO vo;

	private JButton okBtn;
	private JButton returnBtn;
	private JTextField nameField;
	private JTextField idField;
	private JTextField addrField;
	private JLabel nameLabel;
	private JLabel idLabel;
	private JLabel addrLabel;

	private JTextField[] invenField;

	public InstManageDialog() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		initComponents();
	}

	public InstManageDialog(InstManageUI ui, String opr) {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		this.ui = ui;
		this.opr = opr;
		initComponents();
	}

	public InstManageDialog(InstManageUI ui, String opr, int m) {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		if (m == 1)
			this.setSize(550, 320);
		else
			this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		this.ui = ui;
		this.opr = opr;
		if (m == 0)
			type = "营业厅";
		else if (m == 1)
			type = "中转中心";
		initComponents();
	}

	public InstManageDialog(InstManageUI ui, String opr, InstitutionVO vo) {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		if (vo.getType().getInsTypeString().equals("中转中心")) {
			this.type = "中转中心";
			this.setSize(550, 320);
			this.setLocationRelativeTo(null);
		}
		this.ui = ui;
		this.opr = opr;
		this.vo = vo;
		initComponents();
	}

	private void initComponents() {
		if (!type.equals("中转中心")) {
			idLabel = new JLabel("机构编号:");
			idLabel.setBounds(25, 15, 55, 15);
			nameLabel = new JLabel("机构名称:");
			nameLabel.setBounds(25, 45, 55, 15);
			addrLabel = new JLabel("机构地点:");
			addrLabel.setBounds(25, 75, 55, 15);
			idField = new JTextField();
			idField.setBounds(100, 10, 175, 25);
			nameField = new JTextField();
			nameField.setBounds(100, 40, 175, 25);
			addrField = new JTextField();
			addrField.setBounds(100, 70, 175, 25);

			this.getContentPane().add(nameLabel);
			this.getContentPane().add(idLabel);
			this.getContentPane().add(nameField);
			this.getContentPane().add(idField);
			this.getContentPane().add(addrLabel);
			this.getContentPane().add(addrField);
			okBtn = new JButton("确定");
			okBtn.setBounds(50, 120, 75, 30);
			this.getContentPane().add(okBtn);
			returnBtn = new JButton("返回");
			returnBtn.setBounds(175, 120, 75, 30);
			this.getContentPane().add(returnBtn);
		} else {
			idLabel = new JLabel("机构编号:");
			idLabel.setBounds(20, 15, 55, 15);
			nameLabel = new JLabel("机构名称:");
			nameLabel.setBounds(280, 15, 55, 15);
			addrLabel = new JLabel("机构地点:");
			addrLabel.setBounds(20, 45, 55, 15);
			idField = new JTextField();
			idField.setBounds(80, 10, 175, 25);
			nameField = new JTextField();
			nameField.setBounds(340, 10, 175, 25);
			addrField = new JTextField();
			addrField.setBounds(80, 40, 175, 25);
			this.getContentPane().add(nameLabel);
			this.getContentPane().add(idLabel);
			this.getContentPane().add(nameField);
			this.getContentPane().add(idField);
			this.getContentPane().add(addrLabel);
			this.getContentPane().add(addrField);

			okBtn = new JButton("确定");
			okBtn.setBounds(150, 250, 75, 30);
			this.getContentPane().add(okBtn);
			returnBtn = new JButton("返回");
			returnBtn.setBounds(325, 250, 75, 30);
			this.getContentPane().add(returnBtn);

			JLabel[] titleLabel = new JLabel[4];
			String[] title = { "航运区", "铁运区", "汽运区", "机动区" };
			for (int i = 0; i < 4; i++) {
				titleLabel[i] = new JLabel(title[i]);
				titleLabel[i].setBounds(20 + 130 * i, 80, 50, 20);
				this.getContentPane().add(titleLabel[i]);
			}

			invenField = new JTextField[12];
			JLabel[] label = new JLabel[12];
			String[] name = { "排数", "架数", "位数" };
			for (int i = 0; i < 12; i++) {
				label[i] = new JLabel(name[i % 3] + ":");
				label[i].setBounds(40 + 130 * (i / 3), 100 + 50 * (i % 3), 50,
						20);
				invenField[i] = new JTextField();
				invenField[i].setBounds(80 + 130 * (i / 3), 100 + 50 * (i % 3),
						50, 20);
				this.getContentPane().add(label[i]);
				this.getContentPane().add(invenField[i]);
			}

			JSeparator[] js = new JSeparator[3];
			for (int i = 0; i < 3; i++) {
				js[i] = new JSeparator(JSeparator.VERTICAL);
				js[i].setBounds(140 + 130 * i, 80, 5, 150);
				this.getContentPane().add(js[i]);
			}

			if (opr.equals("update")) {
				InventoryVO tmp;
				try {
					tmp = ui.getInsController().searchInventory(
							vo.getInstitutionID());
					invenField[0].setText(tmp.getPlane().getRow() + "");
					invenField[1].setText(tmp.getPlane().getShelf() + "");
					invenField[2].setText(tmp.getPlane().getPlace() + "");
					invenField[3].setText(tmp.getTrain().getRow() + "");
					invenField[4].setText(tmp.getTrain().getShelf() + "");
					invenField[5].setText(tmp.getTrain().getPlace() + "");
					invenField[6].setText(tmp.getCar().getRow() + "");
					invenField[7].setText(tmp.getCar().getShelf() + "");
					invenField[8].setText(tmp.getCar().getPlace() + "");
					invenField[9].setText(tmp.getAuto().getRow() + "");
					invenField[10].setText(tmp.getAuto().getShelf() + "");
					invenField[11].setText(tmp.getAuto().getPlace() + "");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		if (opr.equals("update")) {
			nameField.setText(vo.getName());
			idField.setText(vo.getInstitutionID());
			addrField.setText(vo.getCity());
			idField.setEditable(false);
			addrField.setEditable(false);
		}

		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (opr.equals("add")) {
					String result;
					try {
						result = ui.getController()
								.addIns(new InstitutionVO(getInstID(),
										getInstCity(), getInstName(), InsType
												.getInsType(type)));
						if (result != null) {
							JOptionPane.showMessageDialog(null, result, "",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "添加成功", "",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ui.initList();
				}
				if (opr.equals("update")) {
					if (type != "中转中心") {
						String result;
						try {
							result = ui.getController().modify(
									vo.getInstitutionID(), getName());
							if (result != null) {
								JOptionPane.showMessageDialog(null, result, "",
										JOptionPane.ERROR_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "修改成功", "",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						String result;
						try {
							result = ui.getController().modify(
									vo.getInstitutionID(), getName());
							if (result != null) {
								JOptionPane.showMessageDialog(null, result, "",
										JOptionPane.ERROR_MESSAGE);
							} else {
								result = ui.getController().modify(
										vo.getInstitutionID(), getInven());
								if (result != null) {
									JOptionPane.showMessageDialog(null, result,
											"", JOptionPane.ERROR_MESSAGE);
								} else {
									JOptionPane
											.showMessageDialog(
													null,
													"修改成功",
													"",
													JOptionPane.INFORMATION_MESSAGE);
								}
							}
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					ui.initList();
				}
				setVisible(false);
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	private String getInstName() {
		return nameField.getText();
	}

	private String getInstID() {
		return idField.getText();
	}

	private String getInstCity() {
		return addrField.getText();
	}

	private InventoryVO getInven() {
		int[] tmp = new int[12];
		for (int i = 0; i < 12; i++) {
			tmp[i] = Integer.parseInt(invenField[i].getText());
		}
		Storage plane = new Storage(tmp[0], tmp[1], tmp[2]);
		Storage train = new Storage(tmp[3], tmp[4], tmp[5]);
		Storage car = new Storage(tmp[6], tmp[7], tmp[8]);
		Storage auto = new Storage(tmp[9], tmp[10], tmp[11]);
		return new InventoryVO(vo.getInstitutionID(), plane, train, car, auto);
	}
}
