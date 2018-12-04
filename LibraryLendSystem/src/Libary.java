//Library 클래스
//2017315007 윤성웅 2017315036 이찬희 2017330014 안태현 2017315057 호리우치 히로야
//20181201

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Libary
{
	private String name;
	private static HashSet<Borrower> borrowers = new HashSet<Borrower>();
	private static TreeSet<Book> books = new TreeSet<Book>(	);
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
			selection = s.nextInt();
			switch (selection) {
			case 1:
				String name;
				System.out.println("등록할 사용자의 이름을 입력하시오: ");
				name = s.next();
				registerOneBorrower(name);
				break;
			case 2:
				String title, author;
				System.out.println("등록할 책의 제목을 입력하시오: ");
				title = s.next();
				s.nextLine();
				System.out.println("등록할 책의 저자를 입력하시오: ");
				author = s.next();
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
				catalogueNumber = s.nextInt();
				lendOneBook(borrowerName, catalogueNumber);
				break;
			case 6:
				System.out.println("반납할 책의 카탈로그 넘버를 입력하시오: ");
				catalogueNumber = s.nextInt();
				returnOneBook(catalogueNumber);
				break;
			case 7:
				s.close();
				break;
			}
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
			borrower = itr.next();
			borrower = borrower.searchBorrower(borrowerName);
			if(borrower != null) {
				break;
			}else if(itr.hasNext() == false){
				System.out.println("없는 사용자입니다.");
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
			{
				break;
			}
		}
		if (bookCheck == true && borrower != null)
		{
			Lend lend = new Lend(borrower, book);
			lends.add(lend);
			System.out.println("책이 정상적으로 대여됬습니다.");
		} else
		{
			System.out.println("대여에 실패하였습니다.");
		}
	}

	public static void returnOneBook(int catalogueNumber)
	{
		Iterator<Book> itr = books.iterator();
		boolean result = false;
		while (itr.hasNext())
		{
			Book book = itr.next();
			if (book.getCatalogueNumber() == catalogueNumber)
			{
				if (book.getLend() == null)
				{
					System.out.println("대여중인 책이 아닙니다.");
					break;
				} else
				{
					result = true;
					book.detachLend();
					System.out.println("책이 반납 되었습니다.");
					break;
				}
			}
		}
		if (result == false)
		{
			System.out.println("책 반납에 실패하였습니다.");
		}
	}
}
