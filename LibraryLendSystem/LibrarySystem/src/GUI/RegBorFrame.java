package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import process.Library;

public class RegBorFrame extends JFrame
{
	static JLabel result;
	public RegBorFrame()
	{
		this.setTitle("Register Borrower");

		JTextField jtf = new JTextField("Enter Name Here");
		jtf.setBounds(30, 50, 200, 30);
		jtf.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				jtf.setText("");
			}
		});
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (jtf.getText().equals("Enter Name Here") || jtf.getText().equals(""))
				{
					result.setText("Type In");
					jtf.setText("Enter Name Here");
				} else
				{

					Library.registerOneBorrower(jtf.getText());
					jtf.setText("Enter Name Here");
				}
			}
		});
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				cancel();
			}
		});

		confirmBtn.setSize(80, 50);
		cancelBtn.setSize(80, 50);

		confirmBtn.setLocation(40, 100);
		cancelBtn.setLocation(120, 100);
		
		result = new JLabel("");
		result.setSize(300, 50);
		result.setLocation(30, 160);

		this.add(result);
		this.add(confirmBtn);
		this.add(cancelBtn);
		this.add(jtf);
		this.setSize(400, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

	public void cancel()
	{
		this.dispose();
	}
	
	public static JLabel getResult() {
		return result;
	}
}
