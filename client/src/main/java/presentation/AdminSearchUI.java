package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import client.ClientInitException;
import client.Main;
import vo.InstitutionVO;
import businessLogic.adminBL.AdminController;

public class AdminSearchUI extends JPanel {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private ButtonGroup group;
	private JRadioButton insBtn;
	private JRadioButton keyBtn;
	private AdminController ac;
	private JList<String> insList;
	private JScrollPane sp;
	private JLabel insLabel;
	private JLabel keyLabel;
	private JTextField field;
	private JButton searchBtn;
	private JButton returnBtn;
	private List<InstitutionVO> list;

	public AdminSearchUI() throws ClientInitException {
		this.ac = new AdminController();
		this.initList();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		group = new ButtonGroup();
		insBtn = new JRadioButton("按机构查找");
		keyBtn = new JRadioButton("按关键字查找");
		insBtn.setBounds(200, 30, 150, 50);
		keyBtn.setBounds(450, 30, 150, 50);
		insBtn.setSelected(true);
		group.add(insBtn);
		group.add(keyBtn);
		this.add(insBtn);
		this.add(keyBtn);

		keyLabel = new JLabel("请输入编号、姓名或职位中的关键词：");
		keyLabel.setBounds(150, 100, 250, 50);
		this.add(keyLabel);
		field = new JTextField();
		field.setBounds(150, 150, 500, 30);
		this.add(field);
		keyLabel.setVisible(false);
		field.setVisible(false);

		insLabel = new JLabel("请选择目标机构：");
		insLabel.setBounds(150, 100, 250, 50);
		this.add(insLabel);
		insList = new JList<String>(this.getShowList());
		sp = new JScrollPane();
		sp.setBounds(150, 150, 500, 270);
		sp.getViewport().add(insList);
		this.add(sp);

		searchBtn = new JButton("查询");
		searchBtn.setBounds(200, 450, 100, 30);
		this.add(searchBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(450, 450, 100, 30);
		this.add(returnBtn);

		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminUserUI view;
				try {
					view = new AdminUserUI();
					if (insBtn.isSelected()) {
						view = new AdminUserUI(getInsID(),1);
					} else if (keyBtn.isSelected()) {
						view = new AdminUserUI(getKey(),2);
					}
					Main.frame.setView(view, "账户密码管理");
				} catch (ClientInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.setView(new AdminUI());
			}
		});

		insBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insLabel.setVisible(true);
				sp.setVisible(true);
				keyLabel.setVisible(false);
				field.setVisible(false);
				searchBtn.setBounds(200, 450, 100, 30);
				returnBtn.setBounds(450, 450, 100, 30);
			}
		});

		keyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insLabel.setVisible(false);
				sp.setVisible(false);
				keyLabel.setVisible(true);
				field.setVisible(true);
				searchBtn.setBounds(200, 450, 100, 30);
				returnBtn.setBounds(450, 450, 100, 30);
			}
		});
	}

	protected void initList() {
		list = ac.getInsList();
	}

	private String[] getShowList() {
		int n = list.size();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			InstitutionVO vo = list.get(i);
			str[i] = vo.getCity() + vo.getName();
		}
		return str;
	}

	private String getInsID() {
		int i = insList.getSelectedIndex();
		String str = list.get(i).getInstitutionID();
		return str;
	}

	private String getKey() {
		return field.getText();
	}

	public static void main(String[] args) throws ClientInitException {
		f = new MainFrame();
		f.setView(new AdminSearchUI());
	}
}
