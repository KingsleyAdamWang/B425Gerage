package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import vo.EntruckVO;
import enumSet.ReceiptsState;

public class EntruckUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private final String[] labelName = { "汽运编号", "车辆代号", "目的地", "装车时间", "监装员",
			"押运员" };
	private JLabel[] label;
	private JTextField[] field;
	private JTextField idField;
	private JList<String> list;
	private JScrollPane sp;
	private JButton addIDBtn;
	private JButton delIDBtn;
	private JButton submitBtn;
	private JButton returnBtn;
	private Vector<String> vData;

	public EntruckUI() {
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		vData = new Vector<String>();
		label = new JLabel[6];
		field = new JTextField[6];
		for (int i = 0; i < 6; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100, 20);
			field[i] = new JTextField();
			field[i].setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250, 30);
			this.add(label[i]);
			this.add(field[i]);
		}

		// JSeparator js = new JSeparator();
		// js.setBounds(0, 180, 800, 10);
		// this.add(js);

		JLabel listLabel = new JLabel("订单号：");
		listLabel.setBounds(20, 160, 100, 20);
		this.add(listLabel);

		idField = new JTextField();
		idField.setBounds(105, 160, 250, 30);
		this.add(idField);

		addIDBtn = new JButton("添加货物");
		delIDBtn = new JButton("删除货物");
		addIDBtn.setBounds(400, 160, 80, 30);
		delIDBtn.setBounds(500, 160, 80, 30);
		this.add(addIDBtn);
		this.add(delIDBtn);

		list = new JList<String>(vData);
		// list.setBounds(20, 180, 600, 300);
		sp = new JScrollPane();
		sp.setBounds(100, 200, 600, 300);
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

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hasEmpty()) {
					JOptionPane.showMessageDialog(null, "装车单信息未填写完整", "",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void initList() {

	}

	private EntruckVO getVO() {
		String date = field[3].getText();
		String qyID = field[0].getText();
		String destination = field[2].getText();
		String truckID = field[1].getText();
		String checkName = field[4].getText();
		String deliverMan = field[5].getText();
		List<String> idList = new ArrayList<String>();
		for (int i = 0; i < vData.size(); i++) {
			idList.add(vData.get(i));
		}
		return new EntruckVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), date, qyID, destination, truckID,
				checkName, deliverMan,idList,0);
	}

	private boolean hasEmpty() {
		for (int i = 0; i < 6; i++) {
			if (field[i].getText().equals(""))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		f = new MainFrame();
		EntruckUI view = new EntruckUI();
		f.setView(view);
	}
}