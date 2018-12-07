package process;

//Library 클래스
//2017315007 윤성웅 2017315036 이찬희 2017330014 안태현 2017315057 호리우치 히로야
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
//			System.out.println("1번: 사용자 등록 \n2번: 책 등록 \n3번: 대여 가능한 책 화면 출력 ");
//			System.out.println("4번: 대여 중인 책 화면 출력 \n5번: 책 대여 \n6번: 책 반납 \n7번: 시스템 종료");
//			System.out.print("선택: ");
//			try
//			{
//				selection = s.nextInt();
//			} catch (InputMismatchException e)
//			{
//				System.out.println("정수를 입력하세요.");
//				selection = 0;
//			}
//
//			s.nextLine();
//			switch (selection)
//			{
//			case 1:
//				String name;
//				System.out.println("등록할 사용자의 이름을 입력하시오: ");
//				name = s.nextLine();
//				registerOneBorrower(name);
//				break;
//			case 2:
//				String title, author;
//
//				System.out.println("등록할 책의 제목을 입력하시오: ");
//				title = s.nextLine();
//				System.out.println("등록할 책의 저자를 입력하시오: ");
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
//				System.out.println("사용자의 이름을 입력하시오: ");
//				borrowerName = s.next();
//				System.out.print("책의 카탈로그 넘버를 입력하시오: ");
//				while (true)
//				{
//					if(s.hasNextInt()) {
//						catalogueNumber = s.nextInt();
//						break;
//					}else {
//						System.out.println("오류");
//						s.next();
//					}
//				}
//				lendOneBook(borrowerName, catalogueNumber);
//				break;
//			case 6:
//				System.out.println("반납할 책의 카탈로그 넘버를 입력하시오: ");
//				while (true)
//				{
//					try
//					{
//						catalogueNumber = s.nextInt();
//						break;
//					} catch (InputMismatchException e)
//					{
//						System.out.println("정수를 입력하세요.");
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
//			System.out.print("엔터를 누르세요.");
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
			RegBorFrame.getResult().setText(("성공적으로 사용자를 등록하였습니다."));
		} else
		{
			RegBorFrame.getResult().setText(("이미 같은 이름으로 사용자가 등록 되어 있습니다."));
		}
	}

	public static void registerOneBook(String title, String author)
	{
		Book book = new Book(title, author);
		books.add(book);
		RegBookFrame.getResult().setText("성공적으로 책을 등록하였습니다.");
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
			LendBookFrame.setResult("존재하지 않는 사용자 이름입니다.");
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
			LendBookFrame.setResult("존재하지 않는 책 번호입니다.");
		}
		if ((book != null) && (borrower != null))
		{
			boolean borrowerCheck = borrower.checkBorrower();
			boolean bookCheck = book.checkBook();
			if ((borrowerCheck == true) & (bookCheck == true))
			{
				Lend lend = new Lend(borrower, book);
				LendBookFrame.setResult("책이 성공적으로 대여되었습니다.");
			} else
			{

				if (borrowerCheck == false)
				{
					LendBookFrame.setResult("대출 가능 책 갯수를 초과하였습니다.");
				}
				if (bookCheck == false)
				{
					LendBookFrame.setResult("이미 대여 된 책입니다.");
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
			ReturnBookFrame.setResult("존재하지 않는 책 번호입니다.");
		} else
		{
			boolean returnResult = book.returnBook();
			if (returnResult == true)
			{
				ReturnBookFrame.setResult("성공적으로 반납에 성공하였습니다.");
			} else
			{
				ReturnBookFrame.setResult("대출 중인 책이 아닙니다.");
			}
		}
	}
}
