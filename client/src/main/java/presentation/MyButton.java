package presentation;

import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyButton extends JButton {
	private Font font;
	private String str;

	public MyButton(int width, int height) {
		super();
		setSize(width, height);
		setMargin(new Insets(0, 0, 0, 0));// 设置边距
		setContentAreaFilled(false);// 不绘制按钮区域
		setBorderPainted(false);// 不绘制边框
		setIcon(new ImageIcon("2_1.png"));// 设置默认图片
		mySetRolloverIcon(new ImageIcon("2_2.png"));// 设置鼠标经过图片
		mySetPressedIcon(new ImageIcon("2_3.png"));// 设置鼠标按下图片
	}

	// public void setIcon(String file, JButton iconButton) {
	// ImageIcon icon = new ImageIcon(file);
	// Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
	// iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
	// icon = new ImageIcon(temp);
	// iconButton.setIcon(icon);
	// }

	public void mySetRolloverIcon(Icon rolloverIcon) {
		ImageIcon tempIcon = (ImageIcon) rolloverIcon;
		Image temp = tempIcon.getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), tempIcon.getImage().SCALE_DEFAULT);
		tempIcon = new ImageIcon(temp);
		setRolloverIcon(tempIcon);
	}

	public void mySetPressedIcon(Icon pressedIcon) {
		ImageIcon tempIcon = (ImageIcon) pressedIcon;
		Image temp = tempIcon.getImage().getScaledInstance(this.getWidth(),
				this.getHeight(), tempIcon.getImage().SCALE_DEFAULT);
		tempIcon = new ImageIcon(temp);
		setPressedIcon(tempIcon);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setSize(400, 300);
		MyButton button = new MyButton(50, 30);
		panel.add(button);
		button.setLocation(50, 50);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		// frame.getContentPane().add(new MyButton());
	}
}