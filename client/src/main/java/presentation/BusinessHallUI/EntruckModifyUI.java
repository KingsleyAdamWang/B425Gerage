package presentation.BusinessHallUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.BussinessHallVo.EntruckVO;
import businessLogic.businessHallBL.EntruckController;
import businessLogic.manageBL.ApproveController;
import client.ClientInitException;
import client.Main;
import enumSet.ReceiptsState;

public class EntruckModifyUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private EntruckController ec;
	private final String[] labelName = { "机构编号", "汽运编号", "车辆代号", "装车日期", "目的地",
			"运费", "监装员", "押运员" };
	private JLabel[] label;
	private JTextField[] field;
	private JTextField idField;
	private JList<String> list;
	private JScrollPane sp;
	private JButton addIDBtn;
	private JButton delIDBtn;
	private JButton fareBtn;
	private JButton submitBtn;
	private JButton returnBtn;
	private Vector<String> vData;
	private EntruckVO vo;

	public EntruckModifyUI(EntruckVO vo) throws RemoteException,
			ClientInitException {
		this.vo = vo;
		ec = new EntruckController();
		this.initComponents();
		this.validate();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		vData = new Vector<String>();
		label = new JLabel[8];
		field = new JTextField[8];
		for (int i = 0; i < 8; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 30 + 40 * (i / 2), 100, 20);
			this.add(label[i]);
			field[i] = new JTextField();
			field[i].setBounds(105 + 400 * (i % 2), 30 + 40 * (i / 2), 250, 30);
			this.add(field[i]);
		}

		// JSeparator js = new JSeparator();
		// js.setBounds(0, 180, 800, 10);
		// this.add(js);

		JLabel listLabel = new JLabel("订单号:");
		listLabel.setBounds(20, 190, 100, 20);
		this.add(listLabel);

		idField = new JTextField();
		idField.setBounds(105, 190, 250, 30);
		this.add(idField);

		addIDBtn = new JButton("添加货物");
		delIDBtn = new JButton("删除货物");
		fareBtn = new JButton("获取运费");
		addIDBtn.setBounds(400, 190, 80, 30);
		delIDBtn.setBounds(500, 190, 80, 30);
		fareBtn.setBounds(600, 190, 80, 30);
		this.add(addIDBtn);
		this.add(delIDBtn);
		this.add(fareBtn);

		list = new JList<String>(vData);
		// list.setBounds(20, 180, 600, 300);
		sp = new JScrollPane();
		sp.setBounds(100, 240, 600, 250);
		sp.getViewport().add(list);
		this.add(sp);

		submitBtn = new JButton("保存修改");
		returnBtn = new JButton("返回");
		submitBtn.setBounds(250, 520, 80, 30);
		returnBtn.setBounds(450, 520, 80, 30);
		this.add(submitBtn);
		this.add(returnBtn);

		addIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入货物订单号", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					vData.add(id);
					initList();
					return;
				}
			}
		});

		delIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "请选择一个货物", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					vData.remove(index);
					initList();
					return;
				}
			}
		});

		fareBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setFare();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					new ApproveController().modifyEntruck(getVO());
					JOptionPane.showMessageDialog(null, "修改成功", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.frame.setView(new EntruckApproveUI());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		field[0].setText(MainFrame.getUser().getIdentityID());
		field[0].setEditable(false);
		field[3].setText(DateUtil.dateToString());

		field[1].setText(vo.qyID);
		field[2].setText(vo.truckID);
		field[3].setText(vo.d);
		field[4].setText(vo.destination);
		field[5].setText(vo.fare + "");
		field[6].setText(vo.checkName);
		field[7].setText(vo.deliverMan);
	}

	private void initList() {
		list = new JList<String>(vData);
		sp.getViewport().add(list);
		list.repaint();
		sp.repaint();
	}

	private void setFare() throws RemoteException {
		List<String> sendList = new ArrayList<String>();
		for (int i = 0; i < vData.size(); i++) {
			sendList.add(vData.get(i));
		}
		double d = ec.getFare(sendList);
		field[5].setText(d + "");
	}

	private EntruckVO getVO() {
		String date = field[3].getText();
		String qyID = field[1].getText();
		String destination = field[4].getText();
		String truckID = field[2].getText();
		String checkName = field[6].getText();
		String deliverMan = field[7].getText();
		String fare = field[5].getText();
		List<String> idList = new ArrayList<String>();
		for (int i = 0; i < vData.size(); i++) {
			idList.add(vData.get(i));
		}
		return new EntruckVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), date, qyID, destination, truckID,
				checkName, deliverMan, idList, Double.parseDouble(fare));
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 6; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}
}
