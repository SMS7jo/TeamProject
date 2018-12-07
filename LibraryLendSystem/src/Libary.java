
//Library 클래스
//2017315007 윤성웅 2017315036 이찬희 2017330014 안태현 2017315057 호리우치 히로야
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
			System.out.println("1번: 사용자 등록 \n2번: 책 등록 \n3번: 대여 가능한 책 화면 출력 ");
			System.out.println("4번: 대여 중인 책 화면 출력 \n5번: 책 대여 \n6번: 책 반납 \n7번: 시스템 종료");
			System.out.print("선택: ");
			try
			{
				selection = s.nextInt();
			} catch (InputMismatchException e)
			{
				System.out.println("정수를 입력하세요.");
				selection = 0;
			}

			s.nextLine();
			switch (selection)
			{
			case 1:
				String name;
				System.out.println("등록할 사용자의 이름을 입력하시오: ");
				name = s.nextLine();
				registerOneBorrower(name);
				break;
			case 2:
				String title, author;

				System.out.println("등록할 책의 제목을 입력하시오: ");
				title = s.nextLine();
				System.out.println("등록할 책의 저자를 입력하시오: ");
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
				System.out.println("사용자의 이름을 입력하시오: ");
				borrowerName = s.next();
				System.out.print("책의 카탈로그 넘버를 입력하시오: ");
				while (true)
				{
					try
					{
						catalogueNumber = s.nextInt();
						s.nextLine();
						break;
					} catch (InputMismatchException e)
					{
						System.out.println("정수를 입력하세요.");
						s.next();
					}
				}
				
				lendOneBook(borrowerName, catalogueNumber);
				break;
			case 6:
				System.out.println("반납할 책의 카탈로그 넘버를 입력하시오: ");
				while (true)
				{
					try
					{
						catalogueNumber = s.nextInt();
						s.nextLine();
						break;
					} catch (InputMismatchException e)
					{
						System.out.println("정수를 입력하세요.");
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
				System.out.println("1부터 7사이의 값을 골라주세요.");
			}
			System.out.print("엔터를 누르세요.");
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
			System.out.println("성공적으로 사용자를 등록하였습니다.");
		} else
		{
			System.out.println("이미 같은 이름으로 사용자가 등록 되어 있습니다.");
		}
	}

	public static void registerOneBook(String title, String author)
	{
		Book book = new Book(title, author);
		books.add(book);
		System.out.println("성공적으로 책을 등록하였습니다.");
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
			System.out.println("존재하지 않는 사용자 이름입니다.");
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
			System.out.println("존재하지 않는 책 번호입니다.");
		}
		if ((book != null) && (borrower != null))
		{
			boolean borrowerCheck = borrower.checkBorrower();
			boolean bookCheck = book.checkBook();
			if ((borrowerCheck == true) & (bookCheck == true))
			{
				Lend lend = new Lend(borrower, book);
				System.out.println("책이 성공적으로 대여되었습니다.");
			} else
			{

				if (borrowerCheck == false)
				{
					System.out.println("이 사용자는 책을 대여할 수 없습니다.");
				}
				if (bookCheck == false)
				{
					System.out.println("이미 대여 된 책입니다.");
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
			System.out.println("존재하지 않는 책 번호입니다.");
		} else
		{
			boolean returnResult = book.returnBook();
			if (returnResult == true)
			{
				System.out.println("성공적으로 반납에 성공하였습니다.");
			} else
			{
				System.out.println("대출 중인 책이 아닙니다.");
			}
		}
	}
}
