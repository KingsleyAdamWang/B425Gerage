package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import client.ClientInitException;
import client.Main;
import vo.InstitutionVO;
import vo.UserVO;
import businessLogic.adminBL.AdminController;

public class AdminUserUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private AdminController ac;
	private List<UserVO> list;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private String searchKey;
	private int searchType;

	public AdminUserUI() throws ClientInitException {
		this.ac = new AdminController();
		// this.initComponents();
		// this.initList();
		// this.validate();
	}

	public AdminUserUI(String s, int i) throws ClientInitException {
		this.ac = new AdminController();
		this.searchKey = s;
		this.searchType = i;
		this.initList();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "员工编号(登录账号)", "员工姓名", "账户密码", "员工职位", "所属机构编号" };
		Vector<String> vColumns = new Vector<String>();
		for (int i = 0; i < 5; i++) {
			vColumns.add(info[i]);
		}
		vData = getShowList();
		table = new JTable(vData, vColumns) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBorder(BorderFactory.createEtchedBorder());
		table.setRowHeight(35);
		table.setRowSelectionAllowed(true);
		table.setBounds(50, 50, 700, 385);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setAutoscrolls(false);
		scrollPane.setBounds(50, 50, 700, 385);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);

		funcButton = new JButton[5];
		final String[] title = { "修改密码", "返回" };
		for (int i = 0; i < 2; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(200 + 250 * i, 450, 100, 30);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1) {
							JOptionPane.showMessageDialog(null, "请选择一个员工", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						UserVO vo = list.get(index);
						String tmp = (String) JOptionPane.showInputDialog(null,
								"请输入新的密码：\n", "title",
								JOptionPane.PLAIN_MESSAGE, null, null,
								vo.getPassword());
						if (tmp == null) {
							// JOptionPane.showMessageDialog(null, "请输入密码", "",
							// JOptionPane.ERROR_MESSAGE);
							return;
						}
						// System.out.println(tmp);
						try {
							tmp = ac.modify(vo.getIdentityID(), tmp);
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (tmp != null) {
							JOptionPane.showMessageDialog(null, tmp, "",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "修改成功", "",
									JOptionPane.INFORMATION_MESSAGE);
						}
						reInitList();
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							Main.frame.setView(new AdminSearchUI(),"账户密码管理");
						} catch (ClientInitException e1) {
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

	private void initList() {
		if (this.searchType == 1) {
			list = ac.getUserListByInsID(this.searchKey);
		} else {
			list = ac.search(this.searchKey);
		}
		vData = getShowList();
		// table.validate();
		// scrollPane.getViewport().removeAll();
		// scrollPane.getViewport().add(table);
		// this.initComponents();
		this.repaint();
	}

	private void reInitList() {
		if (this.searchType == 1) {
			list = ac.getUserListByInsID(this.searchKey);
		} else {
			list = ac.search(this.searchKey);
		}
		vData.clear();

		for (UserVO vo : list) {
			vData.add(toVector(vo));
		}

		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}

	private Vector<Vector<String>> getShowList() {
		Vector<Vector<String>> v = new Vector<Vector<String>>();
		int n = list.size();
		for (int i = 0; i < n; i++) {
			Vector<String> tmp = new Vector<String>();
			UserVO vo = list.get(i);
			tmp.add(vo.getIdentityID());
			tmp.add(vo.getName());
			tmp.add(vo.getPassword());
			tmp.add(vo.getWork().getPositionString());
			tmp.add(vo.getInstitutionID());
			v.add(tmp);
			// System.out.println(vo.getName());
		}
		return v;
	}

	private Vector<String> toVector(UserVO vo) {
		Vector<String> tmp = new Vector<String>();
		tmp.add(vo.getIdentityID());
		tmp.add(vo.getName());
		tmp.add(vo.getPassword());
		tmp.add(vo.getWork().getPositionString());
		tmp.add(vo.getInstitutionID());
		return tmp;
	}
}
