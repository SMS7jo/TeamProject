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

public class ReturnBookFrame extends JFrame
{
	static JTextArea result = new JTextArea("Result Pane");

	public ReturnBookFrame()
	{
		this.setTitle("Lend Book");
		
		Label label = new Label("Catalogue Number:");
		label.setSize(120, 30);
		label.setLocation(10, 60);

		NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		longFormat.setGroupingUsed(false);
		numberFormatter.setAllowsInvalid(false);
		JFormattedTextField jtf = new JFormattedTextField(numberFormatter);
		jtf.setText("Enter Catalogue Number Here");
		jtf.setBounds(130, 60, 100, 30);

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
				if (jtf.getText().equals(""))
				{
					result.setText("Type In");
				} else
				{
					result.setText("");
					Library.returnOneBook(Integer.parseInt(jtf.getText()));
					jtf.setText("Enter Catalogue Number Here");
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

		confirmBtn.setLocation(40, 110);
		cancelBtn.setLocation(120, 110);

		result.setSize(200, 100);
		result.setLocation(250, 60);

		this.add(result);
		this.add(confirmBtn);
		this.add(cancelBtn);
		this.add(label);
		this.add(jtf);
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
