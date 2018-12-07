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

public class RegBookFrame extends JFrame
{
	static JLabel result;

	public RegBookFrame()
	{
		this.setTitle("Register Book");

		JTextField jtf1 = new JTextField("Enter Title Here");
		jtf1.setBounds(30, 50, 200, 30);
		jtf1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				jtf1.setText("");
			}
		});
		JTextField jtf2 = new JTextField("Enter Author Here");
		jtf2.setBounds(30, 100, 200, 30);
		jtf2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				jtf2.setText("");
			}
		});
		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (jtf1.getText().equals("Enter Title Here") || jtf2.getText().equals("Enter Author Here") || 
						jtf1.getText().equals("") || jtf2.getText().equals(""))
				{
					result.setText("Type In");
					jtf1.setText("Enter Title Here");
					jtf2.setText("Enter Author Here");
				} else
				{

					Library.registerOneBook(jtf1.getText(), jtf2.getText());
					jtf1.setText("Enter Title Here");
					jtf2.setText("Enter Author Here");
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

		confirmBtn.setLocation(40, 150);
		cancelBtn.setLocation(120, 150);

		result = new JLabel("");
		result.setSize(300, 50);
		result.setLocation(30, 200);

		this.add(result);
		this.add(confirmBtn);
		this.add(cancelBtn);
		this.add(jtf1);
		this.add(jtf2);
		this.setSize(400, 300);
		this.setLayout(null);
		this.setVisible(true);
	}

	public void cancel()
	{
		this.dispose();
	}

	public static JLabel getResult()
	{
		return result;
	}
}
