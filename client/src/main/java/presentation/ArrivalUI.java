package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import util.DateUtil;
import vo.ArrivalVO;
import businessLogic.businessHallBL.ArrivalController;
import client.ClientInitException;
import enumSet.ArrivalState;
import enumSet.ReceiptsState;

public class ArrivalUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private ArrivalController ac;
	private final String[] labelName = { "中转单号", "出发地", "到达日期", "到达状态",
			"包含订单编号" };
	private final String[] typeName = { "完整", "损坏", "丢失" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JButton submitBtn;
	private JButton returnBtn;
	private JList<String> jl;
	private JScrollPane sp;
	private Vector<String> vData;

	public ArrivalUI() throws RemoteException, ClientInitException {
		ac = new ArrivalController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[5];
		field = new JTextField[3];
		box = new JComboBox<String>(typeName);
		for (int i = 0; i < 5; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100, 20);
			this.add(label[i]);
			if (i < 3) {
				field[i] = new JTextField();
				field[i].setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(field[i]);
			} else if (i == 3) {
				box.setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250, 30);
				this.add(box);
			}
		}

		vData = new Vector<String>();
		jl = new JList<String>(vData);
		sp = new JScrollPane();
		sp.getViewport().add(jl);
		sp.setBounds(105, 120, 500, 300);
		this.add(sp);

		field[0].addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				setVData(field[0].getText());
				initList();
			}

		});

		submitBtn = new JButton("提交");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
		this.add(returnBtn);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void setVData(String id) {
		List<String> l = new ArrayList<String>();
		Vector<String> v = new Vector<String>();
		try {
			l = ac.search(id);
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
		for (int i = 0; i < 4; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	private ArrivalVO getArrivalVO() {
		return new ArrivalVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), DateUtil.stringToDate(field[2]
				.getText()), MainFrame.getUser().getInstitutionID(),
				field[0].getText(), field[1].getText(),
				ArrivalState.getArrivalState(typeName[box.getSelectedIndex()]));
	}

	private void initList() {
		jl.repaint();
		sp.repaint();
		this.repaint();
	}

	public static void main(String[] args) throws RemoteException,
			ClientInitException {
		f = new MainFrame();
		ArrivalUI view = new ArrivalUI();
		f.setView(view);
	}
}