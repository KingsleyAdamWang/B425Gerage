package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.DateUtil;
import vo.EntryVO;
import businessLogic.inventoryBL.EntryController;
import enumSet.InventoryArea;
import enumSet.ReceiptsState;

public class EntryUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private EntryController ec;
	private final String[] labelName = { "快递单号", "入库日期", "目的地", "分区", "排号",
			"架号", "位号" };
	private final String[] area = { "汽车分区", "火车分区", "飞机分区", "自动分区" };
	private JLabel[] label;
	private JTextField[] field;
	private JComboBox<String> box;
	private JButton submitBtn;
	private JButton returnBtn;

	public EntryUI() {
		ec=new EntryController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[7];
		field = new JTextField[7];
		box = new JComboBox<String>(area);
		for (int i = 0; i < 7; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 70 + 50 * i, 100, 20);
			this.add(label[i]);
			if (i != 3) {
				field[i] = new JTextField();
				field[i].setBounds(305, 70 + 50 * i, 250, 30);
				this.add(field[i]);
			} else if (i == 3) {
				box.setBounds(305, 70 + 50 * i, 250, 30);
				this.add(box);
			}
		}

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

	private boolean hasEmpty() {
		for (int i = 0; i < 7; i++) {
			if (i != 3) {
				if (field[i].getText().equals(""))
					return true;
			}
		}
		return false;
	}

	private EntryVO getEntryVO() {
		int row = Integer.parseInt(field[4].getText());
		int shelf = Integer.parseInt(field[5].getText());
		int place = Integer.parseInt(field[6].getText());
		return new EntryVO(ReceiptsState.getReceiptsState("未审批"), MainFrame
				.getUser().getIdentityID(), field[0].getText(), MainFrame
				.getUser().getInstitutionID(), DateUtil.stringToDate(field[1]
				.getText()), field[2].getText(), row, shelf, place,
				InventoryArea.getInventoryArea(area[box.getSelectedIndex()]));
	}

	public static void main(String[] args) {
		f = new MainFrame();
		EntryUI view = new EntryUI();
		f.setView(view);
	}
}
