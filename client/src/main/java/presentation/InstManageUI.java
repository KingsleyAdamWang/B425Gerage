package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import enumSet.InsType;
import vo.AccountVO;
import vo.InstitutionVO;
import businessLogic.financeBL.AccountController;
import businessLogic.manageBL.InstitutionController;

public class InstManageUI extends JPanel {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private InstitutionController ic;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	int a;

	public InstManageUI() throws RemoteException {
		this.ic = new InstitutionController();
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "机构编号", "机构名称", "地点" };
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
		System.out.println(m);
		InstManageDialog dialog = new InstManageDialog(this, "add");
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
		// try {
		ic.deleteIns(toVO(vData.get(index)));
		// } catch (RemoteException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
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
	private String opr;
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

	public InstManageDialog(InstManageUI ui, String opr, InstitutionVO vo) {
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
		if (opr.equals("update")) {
			nameField.setText(vo.getName());
			idField.setText(vo.getInstitutionID());
			addrField.setText(vo.getCity());
		}
		this.getContentPane().add(nameLabel);
		this.getContentPane().add(idLabel);
		this.getContentPane().add(nameField);
		this.getContentPane().add(idField);
		this.getContentPane().add(addrLabel);
		this.getContentPane().add(addrField);

		okBtn = new JButton("确定");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (opr.equals("add")) {
					String result;
					try {
						result = ui.getController()
								.addIns(new InstitutionVO(getID(), getCity(),
										getName()));
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
					ui.initList();
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

	public String getName() {
		return nameField.getText();
	}

	public String getID() {
		return idField.getText();
	}

	public String getCity() {
		return addrField.getText();
	}
}
