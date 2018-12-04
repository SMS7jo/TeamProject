//Borrower Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
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
		if (this.name.equals(name))
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
		if (this.name == name)
		{
			if (this.checkBorrower() == true)
			{
				return this;
			} else
			{
				System.out.println("�̹� å�� �뿩��");
				return null;
			}
		}
		return null;
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
