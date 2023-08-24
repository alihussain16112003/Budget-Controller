package Budgetcontroller.Model;

 public class income
{
	private int membercount;
	private int totalamount;
	private String incomedate;
	
	public income()
	{
		membercount = 5;
		totalamount = 40000;
		incomedate = "01/07/2023";
	}
	
	public income(int membercount , int totalamount , String incomedate)
	{
		this.membercount = membercount;
		this.totalamount = totalamount;
		this.incomedate  = incomedate;
	}
	
	public void setdate(String incomedate)
	{
		this.incomedate = incomedate;
	}
	
	public void setmembercount(int membercount)
	{
		this.membercount = membercount;
	}
	
	public void settotalamount(int totalamount)
	{
		this.totalamount = totalamount;
	}
	
	public String getincomedate()
	{
		return incomedate;
	}	
	
	public int getmembercount()	
	{
		return membercount;
	}
	
	public int gettotalamount() 
	{
		return totalamount;
	}
}