package GUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import process.Library;

public class DisplayForLoanFrame extends JFrame
{
	static JTextArea ta;
	public DisplayForLoanFrame()
	{
		ta = new JTextArea();
		JScrollPane sp = new JScrollPane(ta);
		sp.setBounds(30, 30, 500, 500);
		
		ta.setFont(new Font("Serif", Font.PLAIN, 18));
		ta.setEditable(false);
		
		Library.displayBookForLoan();
		
		this.add(sp);
		
		this.setSize(600, 600);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public static void setTa(String text) {
		String str = ta.getText() + "\n" + text;
		ta.setText(str);
	}
}
