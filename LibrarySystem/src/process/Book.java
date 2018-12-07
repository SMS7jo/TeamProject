package process;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import GUI.DisplayForLoanFrame;
import GUI.DisplayOnLoanFrame;

//Book Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
//20181201

public class Book implements Comparable<Book>
{
	private int catalogueNumber;
	private String title;
	private String author;
	private Lend attachedLend = null;
	private static int targetNumber = 0;

	public void displayForLoan()
	{
		DisplayForLoanFrame.setTa("Title: " + title + "/ Author: " + author + " / Catalogue Number: " + catalogueNumber);
	}

	public void displayOnLoan()
	{
		Calendar lendDate = this.attachedLend.getLendDate();
		Date date1 = new Date(lendDate.getTimeInMillis());
		Calendar returnDate = this.attachedLend.getReturnDate();
		Date date2 = new Date(returnDate.getTimeInMillis());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		DisplayOnLoanFrame.setTa("Title: " + title + "/ Author: " + author + " / Catalogue Number: " + catalogueNumber 
				+ " / Borrower: " + this.attachedLend.getBorrower().getName() 
				+ " / Lend Date: " + sdf.format(date1) 
				+ " / Return Date: " + sdf.format(date2));
	}

	public boolean checkBook()
	{
		if (attachedLend == null)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public void attachLend(Lend lend)
	{
		this.attachedLend = lend;
	}

	public void detachLend()
	{
		this.attachedLend = null;
	}

	public Book(String title, String author)
	{
		this.title = title;
		this.author = author;
		this.setCatalogueNumber();
	}

	public void setCatalogueNumber()
	{
		this.catalogueNumber = targetNumber++;
	}

	public Lend getAttachedLend()
	{
		return this.attachedLend;
	}

	public int getCatalogueNumber()
	{
		return this.catalogueNumber;
	}

	public boolean returnBook()
	{
		if (this.attachedLend == null)
		{
			return false;
		} else
		{
			this.attachedLend.detach();
			return true;
		}
	}

	public Book searchBook(int catalogueNumber)
	{
		if (this.catalogueNumber == catalogueNumber)
		{
			return this;
		} else
		{
			return null;
		}
	}

	@Override
	public int compareTo(Book book)
	{
		return (this.catalogueNumber < book.catalogueNumber ? -1
				: (this.catalogueNumber == book.catalogueNumber ? 0 : 1));
	}
}