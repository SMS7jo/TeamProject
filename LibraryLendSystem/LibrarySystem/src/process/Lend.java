package process;
//Lend 클래스
//2017315007 윤성웅 2017315036 이찬희 2017330014 안태현 2017315057 호리우치 히로야
//20181201

import java.util.Calendar;
import java.util.Date;

public class Lend implements Comparable<Lend>
{
	private Book borrowedBook;
	private Borrower borrower;
	private Calendar lendDate = Calendar.getInstance();
	private Calendar returnDate = Calendar.getInstance();
	private int keyNumber;
	private static int targetNumber = 0;

	public Lend(Borrower b, Book book)
	{
		this.borrower = b;
		this.borrowedBook = book;

		b.attachLend(this);
		book.attachLend(this);
		
		returnDate.add(Calendar.DAY_OF_MONTH, 10);
	}

	public void setKeyNumber()
	{
		keyNumber = targetNumber++;
	}

	public Book getBorrowedBook()
	{
		return borrowedBook;
	}

	public Borrower getBorrower()
	{
		return borrower;
	}

	public void detach()
	{
		this.borrowedBook.detachLend();
		this.borrower.detachLend();
	}
	
	public Calendar getLendDate() {
		return this.lendDate;
	}
	public Calendar getReturnDate() {
		return this.returnDate;
	}

	@Override
	public int compareTo(Lend lend)
	{
		return (this.keyNumber < lend.keyNumber ? -1 : (this.keyNumber == lend.keyNumber ? 0 : 1));
	}
}
