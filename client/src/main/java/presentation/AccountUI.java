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

import vo.AccountVO;
import businessLogic.financeBL.AccountController;

public class AccountUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private AccountController ac;
	private JButton[] funcButton;
	private JTable table;
	private Vector<AccountVO> vData;
//	String name;
//	String id;
//	boolean ready = false;

	public AccountUI() throws RemoteException {
		this.ac = new AccountController();
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "用户名", "账号", "余额" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 3; i++) {
			vColumns.add(info[i]);
		}
		vData = new Vector<AccountVO>();

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
		final String[] title = { "新增", "删除", "修改", "查询", "返回" };
		for (int i = 0; i < 5; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(50 + 150 * i, 450, 100, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							addAccount();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							deleteAccount();
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
						updateAccount();
					}
				});
				break;
			case 3:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						searchAccount();
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
		List<AccountVO> list = ac.getAccounts();
		for (AccountVO vo : list) {
			vData.add(vo);
		}
		this.repaint();
	}

	protected void initList(List<AccountVO> list) {
		vData.clear();
		for (AccountVO vo : list) {
			vData.add(vo);
		}
		this.repaint();
	}

	private void addAccount() throws RemoteException {
		new AccountDialog(this, "add");
		return;
	}

	private void deleteAccount() throws RemoteException {
		int index = table.getSelectedRow();
		if (index == -1||(vData.isEmpty()&&index==0)) {
			JOptionPane.showMessageDialog(null, "请选择一个账户", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定删除此账户吗?", "",
				JOptionPane.YES_NO_OPTION);
		if (n != 0)
			return;
		ac.deleteAccount(vData.get(index));
		initList();
		return;
	}

	private void searchAccount() {
		AccountDialog dialog = new AccountDialog(this, "search");
		return;
	}

	private void updateAccount() {
		int index = table.getSelectedRow();
		if (index == -1||(vData.isEmpty()&&index==0)) {
			JOptionPane.showMessageDialog(null, "请选择一个账户", "",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		AccountDialog dialog = new AccountDialog(this, "update", vData.get(index));
		return;
	}

	public AccountController getController() {
		return this.ac;
	}
	
	public static void main(String[] args) {
		f = new MainFrame();
		AccountUI view;
		try {
			view = new AccountUI();
			f.setView(view);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class AccountDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private String opr;
	private String name;
	private String id;
	AccountUI ui;
	AccountVO vo;

	private JButton okBtn;
	private JButton returnBtn;
	private JTextField nameField;
	private JTextField idField;
	private JLabel nameLabel;
	private JLabel idLabel;

	public AccountDialog() {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		initComponents();
	}

	public AccountDialog(AccountUI ui, String opr) {
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);

		this.ui = ui;
		this.opr = opr;
		initComponents();
	}

	public AccountDialog(AccountUI ui, String opr, AccountVO vo) {
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
		if (opr.equals("search")) {
			nameLabel = new JLabel("关键字:");
			nameLabel.setBounds(25, 45, 50, 15);
			nameField = new JTextField();
			nameField.setBounds(100, 40, 175, 25);
			this.getContentPane().add(nameLabel);
			this.getContentPane().add(nameField);
		} else {
			nameLabel = new JLabel("账户名:");
			nameLabel.setBounds(25, 25, 50, 15);
			idLabel = new JLabel("账号:");
			idLabel.setBounds(25, 75, 50, 15);
			nameField = new JTextField();
			nameField.setBounds(100, 20, 175, 25);
			idField = new JTextField();
			idField.setBounds(100, 70, 175, 25);
			if (opr.equals("update")) {
				nameField.setText(vo.getName());
				idField.setText(vo.getAccountID());
				idField.setEditable(false);
			}
			this.getContentPane().add(nameLabel);
			this.getContentPane().add(idLabel);
			this.getContentPane().add(nameField);
			this.getContentPane().add(idField);
		}

		okBtn = new JButton("确定");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (opr.equals("add")) {
					try {
						String result = ui.getController().addAccount(
								getName(), getID());
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
					try {
						String result = ui.getController().modifyAccount(vo,
								getName());
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
				if (opr.equals("search")) {
					List<AccountVO> list = ui.getController().searchAccount(
							getName());
					ui.initList(list);
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
		name = nameField.getText();
		return this.name;
	}

	public String getID() {
		id = idField.getText();
		return this.id;
	}
}
