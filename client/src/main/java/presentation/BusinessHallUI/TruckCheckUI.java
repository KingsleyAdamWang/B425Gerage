package presentation.BusinessHallUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.MainFrame;
import util.DateUtil;
import vo.BussinessHallVo.TruckVO;
import client.Main;

public class TruckCheckUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private final String[] labelName = { "机构编号", "车辆编号", "车牌号", "开始服役时间",
			"服役年限" };
	private JLabel[] label;
	private JTextField[] field;
	private JButton submitBtn;
	private JButton returnBtn;
	private TruckVO vo;

	public TruckCheckUI(TruckVO vo) {
		this.vo = vo;
		this.initComponents();
		this.validate();
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(MainFrame.background.getImage(), 0, 0, this);
	}

	private void initComponents() {
		this.setLayout(null);

		label = new JLabel[5];
		field = new JTextField[5];
		for (int i = 0; i < 5; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(220, 70 + 50 * i, 100, 20);
			this.add(label[i]);
			field[i] = new JTextField();
			field[i].setBounds(305, 70 + 50 * i, 250, 30);
			field[i].setEditable(false);
			this.add(field[i]);
		}
		field[0].setText(MainFrame.getUser().getIdentityID());
		field[1].setText(vo.truckID);
		field[2].setText(vo.truckNumber);
		field[3].setText(DateUtil.dateToString(vo.startTime));
		int year = DateUtil.stringToDate(field[3].getText()).getYear();
		field[4].setText(new Date().getYear() - year + "");

		submitBtn = new JButton("添加");
		submitBtn.setBounds(200, 350, 100, 30);
		this.add(submitBtn);
		returnBtn = new JButton("返回");
		returnBtn.setBounds(500, 350, 100, 30);
		this.add(returnBtn);

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.frame.setView(new TruckUI(), "车辆信息管理");
			}
		});
	}

	private TruckVO getVO() {
		return new TruckVO(field[0].getText(), field[1].getText(),
				field[2].getText(), DateUtil.stringToDate(field[3].getText()));
	}
}
