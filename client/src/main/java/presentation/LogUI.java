package presentation;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import vo.LogVO;
import businessLogic.logBL.LogController;

public class LogUI extends JPanel {
	private static final long serialVersionUID = 1L;

	// 一会儿删↓
	static MainFrame f;
	// 一会儿删↑

	private LogController lc;
	private JButton searchButton;
	private JButton returnButton;
	private JTable table;
	private Vector<LogVO> vData;

	public LogUI() {
		this.lc = new LogController();
		this.initComponents();
		this.initList();
		this.validate();
	}

	private void initComponents() {

	}

	private void initList() {

	}
}
