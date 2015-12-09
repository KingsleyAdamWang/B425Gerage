package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CashRegisterUI extends JPanel {
	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private static final long serialVersionUID = 1L;

	private final String[] labelName = { "收款人", "收款金额", "收款日期", "", "单据编号" };
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

	public CashRegisterUI() {
		this.initComponents();
		this.validate();
	}

	private void initComponents() {
		this.setLayout(null);

		vData = new Vector<String>();
		label = new JLabel[5];
		field = new JTextField[3];
		for (int i = 0; i < 5; i++) {
			label[i] = new JLabel(labelName[i] + ":");
			label[i].setBounds(20 + 400 * (i % 2), 40 + 40 * (i / 2), 100, 20);
			this.add(label[i]);
			if (i < 3) {
				field[i] = new JTextField();
				field[i].setBounds(105 + 400 * (i % 2), 40 + 40 * (i / 2), 250,
						30);
				this.add(field[i]);
			}
		}

		idField = new JTextField();
		idField.setBounds(105, 120, 250, 30);
		this.add(idField);

		addIDBtn = new JButton("添加单据");
		delIDBtn = new JButton("删除单据");
		addIDBtn.setBounds(400, 120, 80, 30);
		delIDBtn.setBounds(500, 120, 80, 30);
		this.add(addIDBtn);
		this.add(delIDBtn);

		list = new JList<String>(vData);
		// list.setBounds(20, 180, 600, 300);
		sp = new JScrollPane();
		sp.setBounds(100, 160, 600, 300);
		sp.getViewport().add(list);
		this.add(sp);

		submitBtn = new JButton("提交");
		returnBtn = new JButton("返回");
		submitBtn.setBounds(250, 500, 80, 30);
		returnBtn.setBounds(450, 500, 80, 30);
		this.add(submitBtn);
		this.add(returnBtn);

		addIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		delIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	private boolean hasEmpty(){
		for(int i=0;i<3;i++){
			if(field[i].getText().equals("")){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		f = new MainFrame();
		CashRegisterUI view = new CashRegisterUI();
		f.setView(view);
	}
}
