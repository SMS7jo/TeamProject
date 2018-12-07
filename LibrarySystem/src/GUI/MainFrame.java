package GUI;

import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	MainPanel mp;
	public MainFrame() {
		this.setSize(600, 500);
		this.setTitle("Library System");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container cp = this.getContentPane();
				
		mp = new MainPanel();
		cp.add(mp);
		
		this.setVisible(true);
	}
}
