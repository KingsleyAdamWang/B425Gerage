package presentation.IntermediateUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
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
import util.DateUtil;
import vo.IntermediateVo.TransferVO;
import businessLogic.intermediateBL.TransferController;
import client.ClientInitException;
import client.Main;
import enumSet.ReceiptsState;
import enumSet.TransportType;

public class TransferModifyUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private TransferController tc;
	private final String[] labelName = { "中转单号", "到达日期", "起始城市", "目标城市",
			"运输类型", "运费", "检装员", "押运员", "包含订单编号" };
	private final String[] typeName = { "汽车", "火车", "飞机" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JComboBox<String> depBox;
	private JComboBox<String> desBox;
	private JButton submitBtn;
	private JButton returnBtn;
	private JList<String> jl;
	private JScrollPane sp;
	private Vector<String> vData;
	private List<String> list;
	private TransferVO vo;

	public TransferModifyUI(TransferVO vo) throws RemoteException {
		this.vo = vo;
		tc = new TransferController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() throws RemoteException {
		this.setLayout(null);

		label = new JLabel[9];
		field = new JTextField[8];
		box = new JComboBox<String>(typeName);
		List<String> cityList = tc.getCities();
		String[] cities = new String[cityList.size()];
		for (int i = 0; i < cityList.size(); i++) {
			cities[i] = cityList.get(i);
		}
		depBox = new JComboBox<String>(cities);
		desBox = new JComboBox<String>(cities);
		for (int i = 0; i < 9; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100, 20);
			this.add(label[i]);
			if (i != 2 && i != 3 && i != 4 && i != 8) {
				field[i] = new JTextField();
				field[i].setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(field[i]);
			} else if (i == 4) {
				box.setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250, 30);
				this.add(box);
			} else if (i == 3) {
				desBox.setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(desBox);
			} else if (i == 2) {
				depBox.setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(depBox);
			}
		}

		vData = new Vector<String>();
		jl = new JList<String>(vData);
		sp = new JScrollPane();
		sp.getViewport().add(jl);
		sp.setBounds(105, 200, 500, 300);
		this.add(sp);

		box.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int index = box.getSelectedIndex();
				if (index == 0)
					label[7].setText("押运员");
				if (index == 1)
					label[7].setText("车厢号");
				if (index == 2)
					label[7].setText("货柜号");
			}

		});

		field[0].addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				setVData(field[0].getText());
				initList();
			}

		});

		submitBtn = new JButton("保存修改");
		submitBtn.setBounds(200, 520, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 520, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "尚未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				String result;
				try {
					result = tc.add(getVO());
					if (result != null) {
						JOptionPane.showMessageDialog(null, result, "",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "提交成功", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});

		field[0].setText(vo.transferID);
		field[1].setText(DateUtil.dateToString(vo.d));
		field[5].setText(vo.fare + "");
		field[6].setText(vo.name);
		field[7].setText(vo.temp);
	}

	private void setVData(String id) {
		List<String> l = new ArrayList<String>();
		Vector<String> v = new Vector<String>();
		try {
			l = tc.getList(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException ex) {
			return;
		}
		for (int i = 0; i < l.size(); i++) {
			v.add(l.get(i));
		}
		vData = v;
		return;
	}

	private boolean hasEmpty() {
		if (field[0].getText().equals(""))
			return true;
		if (field[1].getText().equals(""))
			return true;
		for (int i = 5; i < 9; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private TransferVO getVO() {
		Date d = DateUtil.stringToDate(field[1].getText());
		String institutionID = MainFrame.getUser().getInstitutionID();
		String transferID = field[0].getText();
		double fare = Double.parseDouble(field[5].getText());
		TransportType type = TransportType.getTransportType((String) box
				.getSelectedItem());
		String name = field[6].getText();
		String temp = field[7].getText();
		String departure = (String) depBox.getSelectedItem();
		String destination = (String) desBox.getSelectedItem();
		TransferVO vo = new TransferVO(ReceiptsState.getReceiptsState("未审批"),
				MainFrame.getUser().getIdentityID(), d, institutionID,
				transferID, departure, destination, list, fare, type, name,
				temp);
		return vo;
	}

	private void initList() {
		jl.repaint();
		sp.repaint();
		this.repaint();
	}

	public static void main(String[] args) throws RemoteException,
			ClientInitException {
		f = new MainFrame();
		TransferUI view = new TransferUI();
		f.setView(view);
	}
}
