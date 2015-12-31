package presentation.BusinessHallUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
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
import vo.DeliverymanVo.SendVO;
import vo.FinanceVo.IncomeVO;
import businessLogic.businessHallBL.CashRegisterController;
import client.Main;
import enumSet.ReceiptsState;

public class CashRegisterUI extends JPanel {
	private static final long serialVersionUID = 1L;

	private final String[] labelName = { "快递员编号", "收款金额", "收款日期" };
	private JLabel[] label;
	private JTextField[] field;
	private JList<String> list;
	private JScrollPane sp;
	private JButton sendBtn;
	private JButton submitBtn;
	private JButton returnBtn;
	private Vector<String> vData;
	private List<String> idList;
	private List<SendVO> voList;
	private CashRegisterController cc;
	private double income;

	public CashRegisterUI() throws RemoteException {
		cc = new CashRegisterController();
		this.initComponents();
		this.validate();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		vData = new Vector<String>();
		label = new JLabel[3];
		field = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100, 20);
			this.add(label[i]);
			field[i] = new JTextField();
			field[i].setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250, 30);
			this.add(field[i]);
		}

		label[1].setBounds(20, 450, 100, 20);
		field[1].setBounds(105, 445, 250, 30);
		field[2].setText(DateUtil.dateToString());

		sendBtn = new JButton("获取单据");
		sendBtn.setBounds(400, 80, 80, 30);
		this.add(sendBtn);

		list = new JList<String>(vData);
		// list.setBounds(20, 180, 600, 300);
		sp = new JScrollPane();
		sp.setBounds(100, 120, 600, 300);
		sp.getViewport().add(list);
		this.add(sp);

		submitBtn = new JButton("提交");
		returnBtn = new JButton("返回");
		submitBtn.setBounds(250, 500, 80, 30);
		returnBtn.setBounds(450, 500, 80, 30);
		this.add(submitBtn);
		this.add(returnBtn);

		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					voList = cc.getSendByStaffID(
							DateUtil.stringToDate(field[2].getText()),
							field[0].getText());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				initList();
				setList();
				try {
					income = cc.getAmmounts(voList);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				field[1].setText(income + "");
			}
		});

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (hasEmpty()) {
						JOptionPane.showMessageDialog(null, "信息未填写完整", "",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					String result = cc.add(getVO());
					if (result != null) {
						JOptionPane.showMessageDialog(null, result, "",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "提交成功", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.returnToTop();
			}
		});
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 3; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private void setList() {
		list = new JList<String>(vData);
		sp.getViewport().add(list);
		list.repaint();
		sp.repaint();
	}

	private void initList() {
		vData = new Vector<String>();
		idList = new ArrayList<String>();
		for (int i = 0; i < voList.size(); i++) {
			String s = "";
			SendVO vo = voList.get(i);
			s += vo.id;
			s += "\t";
			s += "\t";
			s += "\t";
			s += vo.fare;
			vData.add(s);
			idList.add(vo.id);
		}
	}

	private IncomeVO getVO() {
		String id = field[0].getText();
		Date d = DateUtil.stringToDate(field[2].getText());
		return new IncomeVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), MainFrame.getUser()
				.getInstitutionID(), d, income, id, idList);
	}
}
