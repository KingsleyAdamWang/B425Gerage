package presentation.BusinessHallUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import presentation.MainFrame;
import businessLogic.businessHallBL.EntruckController;
import client.ClientInitException;
import client.Main;
import util.DateUtil;
import vo.BussinessHallVo.EntruckVO;
import enumSet.ReceiptsState;

public class EntruckUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

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
	private List<String> instName;
	private JComboBox<String> box;

	public EntruckUI() throws RemoteException, ClientInitException {
		ec = new EntruckController();
		this.initComponents();
		this.validate();
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
			if (i != 4) {
				field[i] = new JTextField();
				field[i].setBounds(105 + 400 * (i % 2), 30 + 40 * (i / 2), 250,
						30);
				this.add(field[i]);
			} else {
				try {
					instName = ec.getInstitutionNames();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] tmp = new String[instName.size()];
				for (int j = 0; j < instName.size(); j++) {
					tmp[j] = instName.get(j);
				}
				box = new JComboBox<String>(tmp);
				box.setBounds(105 + 400 * (i % 2), 30 + 40 * (i / 2), 250, 30);
				this.add(box);
			}
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

		submitBtn = new JButton("提交");
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "装车单信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				String result = ec.submit(getVO());
				if (result != null) {
					JOptionPane.showMessageDialog(null, result, "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "提交成功", "",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});

		field[0].setText(MainFrame.getUser().getIdentityID());
		field[0].setEditable(false);
		field[3].setText(DateUtil.dateToString());
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
				checkName, deliverMan, idList, 0);
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 6; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws RemoteException,
			ClientInitException {
		f = new MainFrame();
		EntruckUI view = new EntruckUI();
		f.setView(view);
	}
}
