package presentation.BusinessHallUI;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.BussinessHallVo.ArrivalVO;
import businessLogic.businessHallBL.ArrivalController;
import client.ClientInitException;
import client.Main;
import enumSet.ArrivalState;
import enumSet.ReceiptsState;

public class ArrivalModifyUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private ArrivalController ac;
	private final String[] labelName = { "中转单/装车单号", "出发地", "到达日期", "到达状态",
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
	private ArrivalVO vo;

	public ArrivalModifyUI(ArrivalVO vo) throws RemoteException,
			ClientInitException {
		this.vo = vo;
		ac = new ArrivalController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() throws RemoteException {
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
				field[i].setBounds(120 + 380 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(field[i]);
			} else if (i == 3) {
				box.setBounds(100 + 400 * (i % 2), 40 + 40 * (i / 2), 250, 30);
				this.add(box);
			}
		}
		field[1].setText(ac.getInstitutionName());
		field[2].setText(DateUtil.dateToString());

		vData = new Vector<String>();
		jl = new JList<String>(vData);
		sp = new JScrollPane();
		sp.getViewport().add(jl);
		sp.setBounds(120, 120, 500, 300);
		this.add(sp);

		field[0].addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				setVData(field[0].getText());
				initList();
			}

		});

		submitBtn = new JButton("保存修改");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
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
					result = ac.add(getVO());
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

		field[0].setText(vo.getTransferId());
		field[1].setText(vo.getDeparture());
		field[2].setText(vo.getDate());
		setVData(field[0].getText());
		initList();
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

	private ArrivalVO getVO() {
		// String tmp =
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