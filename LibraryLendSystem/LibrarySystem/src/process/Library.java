package process;

//Library Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
//20181201

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import GUI.LendBookFrame;
import GUI.MainFrame;
import GUI.RegBookFrame;
import GUI.RegBorFrame;
import GUI.ReturnBookFrame;

public class Library
{
	private String name;
	private static HashSet<Borrower> borrowers = new HashSet<Borrower>();
	private static TreeSet<Book> books = new TreeSet<Book>();
	private static TreeSet<Lend> lends = new TreeSet<Lend>();
	static MainFrame mf;

	public static void main(String[] args)
	{
//		int selection = 0;
//		Scanner s = new Scanner(System.in);
//		while (selection != 7)
//		{
//			System.out.println("1��: ����� ��� \n2��: å ��� \n3��: �뿩 ������ å ȭ�� ��� ");
//			System.out.println("4��: �뿩 ���� å ȭ�� ��� \n5��: å �뿩 \n6��: å �ݳ� \n7��: �ý��� ����");
//			System.out.print("����: ");
//			try
//			{
//				selection = s.nextInt();
//			} catch (InputMismatchException e)
//			{
//				System.out.println("������ �Է��ϼ���.");
//				selection = 0;
//			}
//
//			s.nextLine();
//			switch (selection)
//			{
//			case 1:
//				String name;
//				System.out.println("����� ������� �̸��� �Է��Ͻÿ�: ");
//				name = s.nextLine();
//				registerOneBorrower(name);
//				break;
//			case 2:
//				String title, author;
//
//				System.out.println("����� å�� ������ �Է��Ͻÿ�: ");
//				title = s.nextLine();
//				System.out.println("����� å�� ���ڸ� �Է��Ͻÿ�: ");
//				author = s.nextLine();
//				registerOneBook(title, author);
//				break;
//			case 3:
//				displayBookForLoan();
//				break;
//			case 4:
//				displayBookOnLoan();
//				break;
//			case 5:
//				String borrowerName;
//				int catalogueNumber = -1;
//				System.out.println("������� �̸��� �Է��Ͻÿ�: ");
//				borrowerName = s.next();
//				System.out.print("å�� īŻ�α� �ѹ��� �Է��Ͻÿ�: ");
//				while (true)
//				{
//					if(s.hasNextInt()) {
//						catalogueNumber = s.nextInt();
//						break;
//					}else {
//						System.out.println("����");
//						s.next();
//					}
//				}
//				lendOneBook(borrowerName, catalogueNumber);
//				break;
//			case 6:
//				System.out.println("�ݳ��� å�� īŻ�α� �ѹ��� �Է��Ͻÿ�: ");
//				while (true)
//				{
//					try
//					{
//						catalogueNumber = s.nextInt();
//						break;
//					} catch (InputMismatchException e)
//					{
//						System.out.println("������ �Է��ϼ���.");
//						s.next();
//					}
//				}
//				returnOneBook(catalogueNumber);
//				break;
//			case 7:
//				s.close();
//				break;
//			}
//			s.nextLine();
//			System.out.print("���͸� ��������.");
//			
//		}
		mf = new MainFrame();
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
			RegBorFrame.getResult().setText(("���������� ����ڸ� ����Ͽ����ϴ�."));
		} else
		{
			RegBorFrame.getResult().setText(("�̹� ���� �̸����� ����ڰ� ��� �Ǿ� �ֽ��ϴ�."));
		}
	}

	public static void registerOneBook(String title, String author)
	{
		Book book = new Book(title, author);
		books.add(book);
		RegBookFrame.getResult().setText("���������� å�� ����Ͽ����ϴ�.");
	}

	public static void displayBookForLoan()
	{
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext())
		{
			Book book = itr.next();
			if (book.getAttachedLend() == null)
			{
				book.displayForLoan();
			}
		}
	}

	public static void displayBookOnLoan()
	{
		Iterator<Book> itr = books.iterator();
		while (itr.hasNext())
		{
			Book book = itr.next();
			if (book.getAttachedLend() != null)
			{
				book.displayOnLoan();
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
			LendBookFrame.setResult("�������� �ʴ� ����� �̸��Դϴ�.");
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
			LendBookFrame.setResult("�������� �ʴ� å ��ȣ�Դϴ�.");
		}
		if ((book != null) && (borrower != null))
		{
			boolean borrowerCheck = borrower.checkBorrower();
			boolean bookCheck = book.checkBook();
			if ((borrowerCheck == true) & (bookCheck == true))
			{
				Lend lend = new Lend(borrower, book);
				LendBookFrame.setResult("å�� ���������� �뿩�Ǿ����ϴ�.");
			} else
			{

				if (borrowerCheck == false)
				{
					LendBookFrame.setResult("���� ���� å ������ �ʰ��Ͽ����ϴ�.");
				}
				if (bookCheck == false)
				{
					LendBookFrame.setResult("�̹� �뿩 �� å�Դϴ�.");
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
			ReturnBookFrame.setResult("�������� �ʴ� å ��ȣ�Դϴ�.");
		} else
		{
			boolean returnResult = book.returnBook();
			if (returnResult == true)
			{
				ReturnBookFrame.setResult("���������� �ݳ��� �����Ͽ����ϴ�.");
			} else
			{
				ReturnBookFrame.setResult("���� ���� å�� �ƴմϴ�.");
			}
		}
	}
}