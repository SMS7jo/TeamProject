package process;

import java.util.Vector;

//Borrower Ŭ����
//2017315007 ������ 2017315036 ������ 2017330014 ������ 2017315057 ȣ����ġ ���ξ�
//20181201

public class Borrower
{
	private String name;
	private Vector<Lend> attachedLend = new Vector<Lend>();

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
		this.attachedLend.add(lend);
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
		if (this.attachedLend.size() < 10)
		{
			return true;
		} else
		{
			return false;
		}
	}
}
