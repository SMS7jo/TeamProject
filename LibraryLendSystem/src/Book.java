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

	public void display()
	{
		System.out.println("Title: " + title + "/ Author: " + author + " / Catalogue Number: " + catalogueNumber);
	}

	public boolean checkBook(int catalogueNumber)
	{
		if (this.attachedLend != null)
		{
			return false;
		} else if (this.catalogueNumber != catalogueNumber)
		{
			return false;
		}
		return true;
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

	public Lend getLend()
	{
		return this.attachedLend;
	}

	public int getCatalogueNumber()
	{
		return this.catalogueNumber;
	}

	@Override
	public int compareTo(Book book)
	{
		return (this.catalogueNumber < book.catalogueNumber ? -1
				: (this.catalogueNumber == book.catalogueNumber ? 0 : 1));
	}
}