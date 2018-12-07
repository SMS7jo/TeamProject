//Borrower 클래스
//2017315007 윤성웅 2017315036 이찬희 2017330014 안태현 2017315057 호리우치 히로야
//20181201

public class Borrower
{
	private String name;
	private Lend attachedLend = null;

	public Borrower(String name)
	{
		this.name = name;
	}

	public void detachLend()
	{
		this.attachedLend = null;
	}

	public void attachLend(Lend lend)
	{
		this.attachedLend = lend;
	}

	public boolean checkName(String name)
	{
		if (this.name.equals((String) name))
		{
			return false;
		}
		return true;
	}

	public String getName()
	{
		return this.name;
	}

	public Borrower searchBorrower(String name)
	{
		if (this.name.equals((String) name))
		{
			return this;
		} else
		{
			return null;
		}
	}

	public boolean checkBorrower()
	{
		if (this.attachedLend == null)
		{
			return true;
		} else
		{
			return false;
		}
	}
}
