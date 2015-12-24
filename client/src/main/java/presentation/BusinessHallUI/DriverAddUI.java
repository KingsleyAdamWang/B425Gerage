package presentation.BusinessHallUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.DateFormatter;

import presentation.MainFrame;
import util.DateUtil;
import vo.BussinessHallVo.DriverVO;
import businessLogic.businessHallBL.DriverController;
import client.Main;
import enumSet.Sex;

public class DriverAddUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;
	private DriverController dc;
	private final String[] labelName = { "机构编号", "司机编号", "司机姓名", "出生日期",
			"身份证号", "手机号码", "性别", "行驶证期限" };
	private JLabel[] label;
	private JTextField[] field;
	private JButton submitBtn;
	private JButton returnBtn;
	private ButtonGroup group;
	private JRadioButton male;
	private JRadioButton female;

	public DriverAddUI() {
		dc = new DriverController();
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[8];
		field = new JTextField[8];
		for (int i = 0; i < 8; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 40 + 45 * i, 100, 20);
			this.add(label[i]);
			if (i != 6) {
				if (i == 3 || i == 7) {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					DateFormatter df = new DateFormatter(format);
					field[i] = new JFormattedTextField(df);
				} else {
					field[i] = new JTextField();
				}
				field[i].setBounds(305, 40 + 45 * i, 250, 30);
				this.add(field[i]);
			}
		}
		field[0].setText(MainFrame.getUser().getIdentityID());
		field[0].setEditable(false);
		field[3].setText("1970-01-01");
		field[7].setText("2020-01-01");

		submitBtn = new JButton("提交");
		submitBtn.setBounds(200, 450, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 450, 100, 30);
		this.add(returnBtn);

		group = new ButtonGroup();
		male = new JRadioButton("男");
		female = new JRadioButton("女");
		male.setBounds(305, 295, 50, 50);
		female.setBounds(365, 295, 50, 50);
		male.setSelected(true);
		group.add(male);
		group.add(female);
		this.add(male);
		this.add(female);

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = dc.addDriver(getVO());
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
				Main.frame.setView(new DriverAddUI(), "司机信息管理");
			}
		});
	}

	private DriverVO getVO() {
		String id = field[1].getText();
		String name = field[2].getText();
		String IDnumber = field[4].getText();
		Date birth = DateUtil.stringToDate(field[3].getText());
		Sex sex = male.isSelected() ? Sex.getSex("男") : Sex.getSex("女");
		String telNumber = field[5].getText();
		String institutionID = field[0].getText();
		Date driveLicence = DateUtil.stringToDate(field[7].getText());
		return new DriverVO(id, name, IDnumber, birth, sex, telNumber,
				institutionID, driveLicence);
	}

	public static void main(String[] args) {
		f = new MainFrame();
		DriverAddUI view = new DriverAddUI();
		f.setView(view);
	}
}
