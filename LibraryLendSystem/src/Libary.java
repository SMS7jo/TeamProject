<<<<<<< HEAD

=======
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
//Library Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
//20181201

<<<<<<< HEAD
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
=======
import java.util.HashSet;
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Libary
{
	private String name;
	private static HashSet<Borrower> borrowers = new HashSet<Borrower>();
<<<<<<< HEAD
	private static TreeSet<Book> books = new TreeSet<Book>();
=======
	private static TreeSet<Book> books = new TreeSet<Book>(	);
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
	private static TreeSet<Lend> lends = new TreeSet<Lend>();

	public static void main(String[] args)
	{
		int selection = 0;
		Scanner s = new Scanner(System.in);
		while (selection != 7)
		{
			System.out.println("1��: ����� ��� \n2��: å ��� \n3��: �뿩 ������ å ȭ�� ��� ");
			System.out.println("4��: �뿩 ���� å ȭ�� ��� \n5��: å �뿩 \n6��: å �ݳ� \n7��: �ý��� ����");
			System.out.print("����: ");
<<<<<<< HEAD
			try
			{
				selection = s.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.println("������ �Է��ϼ���.");
				selection = 0;
			}

			s.nextLine();
			switch (selection)
			{
			case 1:
				String name;
				System.out.println("����� ������� �̸��� �Է��Ͻÿ�: ");
				name = s.nextLine();
=======
			selection = s.nextInt();
			switch (selection) {
			case 1:
				String name;
				System.out.println("����� ������� �̸��� �Է��Ͻÿ�: ");
				name = s.next();
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
				registerOneBorrower(name);
				break;
			case 2:
				String title, author;
<<<<<<< HEAD

				System.out.println("����� å�� ������ �Է��Ͻÿ�: ");
				title = s.nextLine();
				System.out.println("����� å�� ���ڸ� �Է��Ͻÿ�: ");
				author = s.nextLine();
=======
				System.out.println("����� å�� ������ �Է��Ͻÿ�: ");
				title = s.next();
				s.nextLine();
				System.out.println("����� å�� ���ڸ� �Է��Ͻÿ�: ");
				author = s.next();
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
				registerOneBook(title, author);
				break;
			case 3:
				displayBookForLoan();
				break;
			case 4:
				displayBookOnLoan();
				break;
			case 5:
				String borrowerName;
				int catalogueNumber;
				System.out.println("������� �̸��� �Է��Ͻÿ�: ");
				borrowerName = s.next();
				System.out.print("å�� īŻ�α� �ѹ��� �Է��Ͻÿ�: ");
<<<<<<< HEAD
				while (true)
				{
					try
					{
						catalogueNumber = s.nextInt();
						break;
					} catch (InputMismatchException e)
					{
						System.out.println("������ �Է��ϼ���.");
					}
				}
=======
				catalogueNumber = s.nextInt();
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
				lendOneBook(borrowerName, catalogueNumber);
				break;
			case 6:
				System.out.println("�ݳ��� å�� īŻ�α� �ѹ��� �Է��Ͻÿ�: ");
<<<<<<< HEAD
				while (true)
				{
					try
					{
						catalogueNumber = s.nextInt();
						break;
					} catch (InputMismatchException e)
					{
						System.out.println("������ �Է��ϼ���.");
					}
				}
=======
				catalogueNumber = s.nextInt();
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
				returnOneBook(catalogueNumber);
				break;
			case 7:
				s.close();
				break;
			}
<<<<<<< HEAD
			System.out.print("���͸� ��������.");
			s.nextLine();
		}

=======
		}
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
	}

	public static void registerOneBorrower(String name)
	{
		boolean available = true;
		Iterator<Borrower> itr = borrowers.iterator();
		while (itr.hasNext())
		{
			Borrower b = itr.next();
			available = b.checkName(name);
			if (available == false)
			{
				break;
			}
		}
		if (available == true)
		{
			Borrower b = new Borrower(name);
			borrowers.add(b);
			System.out.println("���������� ����ڸ� ����Ͽ����ϴ�.");
		} else
		{
			System.out.println("�̹� ���� �̸����� ����ڰ� ��� �Ǿ� �ֽ��ϴ�.");
		}
	}

	public static void registerOneBook(String title, String author)
	{
		Book book = new Book(title, author);
		books.add(book);
		System.out.println("���������� å�� ����Ͽ����ϴ�.");
	}

	public static void displayBookForLoan()
	{
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext())
		{
			Book book = itr.next();
			if (book.getLend() == null)
			{
				book.display();
			}
		}
	}

	public static void displayBookOnLoan()
	{
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext())
		{
			Book book = itr.next();
			if (book.getLend() != null)
			{
				book.display();
			}
		}
	}

	public static void lendOneBook(String borrowerName, int catalogueNumber)
	{
		Iterator<Borrower> itr = borrowers.iterator();
		Borrower borrower = null;
		while (itr.hasNext())
		{
<<<<<<< HEAD
			borrower = itr.next().searchBorrower(borrowerName);
			if (borrower != null)
			{
				break;
			}
		}
		if (borrower == null)
		{
			System.out.println("�������� �ʴ� ����� �̸��Դϴ�.");
		}
		Iterator<Book> itr2 = books.iterator();
		
		Book book = null;
		while (itr2.hasNext())
		{
			book = itr2.next().searchBook(catalogueNumber);
			if (book != null)
=======
			borrower = itr.next();
			borrower = borrower.searchBorrower(borrowerName);
			if(borrower != null) {
				break;
			}else if(itr.hasNext() == false){
				System.out.println("���� ������Դϴ�.");
			}
		}
		Iterator<Book> itr2 = books.iterator();
		Book book = null;
		boolean bookCheck = false;
		while (itr2.hasNext())
		{
			book = itr2.next();
			bookCheck = book.checkBook(catalogueNumber);
			if (bookCheck == true)
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
			{
				break;
			}
		}
<<<<<<< HEAD
		if (book == null)
		{
			System.out.println("�������� �ʴ� å ��ȣ�Դϴ�.");
		}
		if ((book != null) && (borrower != null))
		{
			boolean borrowerCheck = borrower.checkBorrower();
			boolean bookCheck = book.checkBook();
			if ((borrowerCheck == true) & (bookCheck == true))
			{
				Lend lend = new Lend(borrower, book);
				System.out.println("å�� ���������� �뿩�Ǿ����ϴ�.");
			} else
			{

				if (borrowerCheck == false)
				{
					System.out.println("�� ����ڴ� å�� �뿩�� �� �����ϴ�.");
				}
				if (bookCheck == false)
				{
					System.out.println("�̹� �뿩 �� å�Դϴ�.");
				}
			}

		}

=======
		if (bookCheck == true && borrower != null)
		{
			Lend lend = new Lend(borrower, book);
			lends.add(lend);
			System.out.println("å�� ���������� �뿩����ϴ�.");
		} else
		{
			System.out.println("�뿩�� �����Ͽ����ϴ�.");
		}
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
	}

	public static void returnOneBook(int catalogueNumber)
	{
		Iterator<Book> itr = books.iterator();
<<<<<<< HEAD
		Book book = null;
		while (itr.hasNext())
		{
			book = itr.next().searchBook(catalogueNumber);
			if (book != null)
			{
				break;
			}
		}
		if (book == null)
		{
			System.out.println("�������� �ʴ� å ��ȣ�Դϴ�.");
		} else
		{
			boolean returnResult = book.returnBook();
			if (returnResult == true)
			{
				System.out.println("���������� �ݳ��� �����Ͽ����ϴ�.");
			} else
			{
				System.out.println("���� ���� å�� �ƴմϴ�.");
			}
=======
		boolean result = false;
		while (itr.hasNext())
		{
			Book book = itr.next();
			if (book.getCatalogueNumber() == catalogueNumber)
			{
				if (book.getLend() == null)
				{
					System.out.println("�뿩���� å�� �ƴմϴ�.");
					break;
				} else
				{
					result = true;
					book.detachLend();
					System.out.println("å�� �ݳ� �Ǿ����ϴ�.");
					break;
				}
			}
		}
		if (result == false)
		{
			System.out.println("å �ݳ��� �����Ͽ����ϴ�.");
>>>>>>> 0c300114a3f4291fb35c566ad6c0be2282d27154
		}
	}
}
