package presentation.FinanceUI;

import java.awt.Graphics;
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

import presentation.MainFrame;
import vo.FinanceVo.AccountVO;
import businessLogic.financeBL.AccountController;
import client.ClientInitException;
import client.Main;

public class DefaultAccountUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private AccountController ac;
	private JButton[] funcButton;
	private JTable table;
	private Vector<Vector<String>> vData;
	private JScrollPane scrollPane;
	private List<AccountVO> list;

	public DefaultAccountUI() {
		try {
			ac = new AccountController();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ClientInitException e) {
			e.printStackTrace();
		}
		this.initComponents();
		this.initList();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		String[] info = { "用户名", "账号", "余额" };
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

		scrollPane = new JScrollPane();
		scrollPane.getViewport().add(table);
		scrollPane.setBounds(50, 50, 700, 385);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);

		funcButton = new JButton[4];
		final String[] title = { "设为默认账户", "返回" };
		for (int i = 0; i < 2; i++) {
			funcButton[i] = new JButton(title[i]);
			funcButton[i].setBounds(250 + 200 * i, 450, 110, 25);
			switch (i) {
			case 0:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int index = table.getSelectedRow();
						if (index == -1 || (vData.isEmpty() && index == 0)) {
							JOptionPane.showMessageDialog(null, "请选择一个账户", "",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						try {
							String result = ac.changeDefaultCard(list
									.get(index));
							if (result != null) {
								JOptionPane.showMessageDialog(null, result, "",
										JOptionPane.ERROR_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(null, "设置成功", "",
										JOptionPane.INFORMATION_MESSAGE);
								Main.frame.setView(new DefaultAccountUI(),
										"设置默认账户");
							}
						} catch (RemoteException e1) {
							e1.printStackTrace();
						}
					}
				});
				break;
			case 1:
				funcButton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Main.frame.returnToTop();
					}
				});
				break;
			}
			this.add(funcButton[i]);
		}
	}

	private Vector<String> toVector(AccountVO vo) {
		Vector<String> str = new Vector<String>();
		str.add(vo.getName());
		str.add(vo.getAccountID());
		str.add(vo.getBalance() + "");
		return str;
	}

	private void initList() {
		vData.clear();
		list = ac.getAccounts();

		for (AccountVO vo : list) {
			vData.add(toVector(vo));
		}
		scrollPane.getViewport().removeAll();
		scrollPane.getViewport().add(table);
		this.repaint();
	}
}
