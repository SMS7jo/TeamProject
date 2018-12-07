package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener
{
	JLabel mainLabel;
	JButton regBor, regBook, displayForLoan, displayOnLoan, lendBook, returnBook;

	public MainPanel()
	{
		this.setLayout(null);

		this.setSize(600, 500);
		mainLabel = new JLabel("Library System");
		mainLabel.setLocation(180, 40);
		mainLabel.setSize(400, 50);
		mainLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		this.add(mainLabel);

		regBor = new JButton("Register Borrower");
		regBook = new JButton("Register Book");
		displayForLoan = new JButton("Display Books For Loan");
		displayOnLoan = new JButton("Display Books On Loan");
		lendBook = new JButton("Lend Book");
		returnBook = new JButton("Return Book");

		JButton[] buttons = { regBor, regBook, displayForLoan, displayOnLoan, lendBook, returnBook };

		for (int i = 0; i < buttons.length; i++)
		{
			buttons[i].setLocation(200, 50 * (i + 2));
			buttons[i].setSize(200, 50);
			buttons[i].addActionListener(this);
			this.add(buttons[i]);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == regBor)
		{
			RegBorFrame rBorF = new RegBorFrame();
		} else if (e.getSource() == regBook)
		{
			RegBookFrame rBookF = new RegBookFrame();
		} else if (e.getSource() == displayForLoan)
		{
			DisplayForLoanFrame dflf = new DisplayForLoanFrame();
		} else if (e.getSource() == displayOnLoan)
		{
			DisplayOnLoanFrame dolf = new DisplayOnLoanFrame();
		} else if (e.getSource() == lendBook)
		{
			LendBookFrame dolf = new LendBookFrame();
		} else if (e.getSource() == returnBook)
		{
			ReturnBookFrame rbf = new ReturnBookFrame();
		}
	}
}
