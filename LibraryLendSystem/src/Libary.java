
//Library Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
//20181201

import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Libary
{
	private String name;
	private static HashSet<Borrower> borrowers = new HashSet<Borrower>();
	private static TreeSet<Book> books = new TreeSet<Book>();
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
				registerOneBorrower(name);
				break;
			case 2:
				String title, author;

				System.out.println("����� å�� ������ �Է��Ͻÿ�: ");
				title = s.nextLine();
				System.out.println("����� å�� ���ڸ� �Է��Ͻÿ�: ");
				author = s.nextLine();
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
				while (true)
				{
					try
					{
						catalogueNumber = s.nextInt();
						s.nextLine();
						break;
					} catch (InputMismatchException e)
					{
						System.out.println("������ �Է��ϼ���.");
						s.next();
					}
				}
				
				lendOneBook(borrowerName, catalogueNumber);
				break;
			case 6:
				System.out.println("�ݳ��� å�� īŻ�α� �ѹ��� �Է��Ͻÿ�: ");
				while (true)
				{
					try
					{
						catalogueNumber = s.nextInt();
						s.nextLine();
						break;
					} catch (InputMismatchException e)
					{
						System.out.println("������ �Է��ϼ���.");
						s.next();
					}
				}
				returnOneBook(catalogueNumber);
				break;
			case 7:
				s.close();
				break;
			}
			if(selection > 7 || selection < 0){
				System.out.println("1���� 7������ ���� ����ּ���.");
			}
			System.out.print("���͸� ��������.");
			s.nextLine();
		}

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
			{
				break;
			}
		}
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

	}

	public static void returnOneBook(int catalogueNumber)
	{
		Iterator<Book> itr = books.iterator();
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
		}
	}
}
