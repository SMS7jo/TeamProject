//Lend Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
//20181201

<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
=======

>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
import java.util.Calendar;

public class Lend implements Comparable<Lend>
{
	private Book borrowedBook;
	private Borrower borrower;
	private Calendar lendDate = Calendar.getInstance();
	private int keyNumber;
	private static int targetNumber = 0;

	public Lend(Borrower b, Book book)
	{
		this.borrower = b;
		this.borrowedBook = book;

		b.attachLend(this);
		book.attachLend(this);
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

<<<<<<< HEAD
<<<<<<< HEAD
	public void detach()
	{
		this.borrowedBook.detachLend();
		this.borrower.detachLend();
	}

	@Override
	public int compareTo(Lend lend)
	{
		return (this.keyNumber < lend.keyNumber ? -1 : (this.keyNumber == lend.keyNumber ? 0 : 1));
=======
=======
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
	@Override
	public int compareTo(Lend lend)
	{
		return (this.keyNumber < lend.keyNumber ? -1 :
			(this.keyNumber == lend.keyNumber ? 0 : 1));
<<<<<<< HEAD
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
=======
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
	}
}
