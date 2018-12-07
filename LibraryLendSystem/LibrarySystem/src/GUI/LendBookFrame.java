package GUI;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import process.Library;

public class LendBookFrame extends JFrame
{
	static JTextArea result = new JTextArea("Result Pane");

	public LendBookFrame()
	{
		this.setTitle("Lend Book");
		
		Label label = new Label("Catalogue Number:");
		label.setSize(120, 30);
		label.setLocation(10, 100);

		JTextField jtf1 = new JTextField("Enter Name Here");
		jtf1.setBounds(30, 50, 200, 30);
		jtf1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				jtf1.setText("");
			}
		});
		NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		longFormat.setGroupingUsed(false);
		numberFormatter.setAllowsInvalid(false);
		JFormattedTextField jtf2 = new JFormattedTextField(numberFormatter);
		jtf2.setText("Enter Catalogue Number Here");
		jtf2.setBounds(130, 100, 100, 30);

		JButton confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (jtf1.getText().equals("Enter Name Here") ||
						jtf1.getText().equals("") || jtf2.getText().equals(""))
				{
					result.setText("Type In");
					jtf1.setText("Enter Name Here");
				} else
				{
					result.setText("");
					Library.lendOneBook(jtf1.getText(), Integer.parseInt(jtf2.getText()));
					jtf1.setText("Enter Name Here");
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

		result.setSize(200, 100);
		result.setLocation(250, 60);

		this.add(result);
		this.add(confirmBtn);
		this.add(cancelBtn);
		this.add(label);
		this.add(jtf1);
		this.add(jtf2);
		this.setSize(500, 280);
		this.setLayout(null);
		this.setVisible(true);
	}

	public void cancel()
	{
		this.dispose();
	}

	public static void setResult(String text)
	{
		String str = result.getText() + "\n" + text;
		result.setText(str);
	}
}
