package Budgetcontroller.Model;

public class expenses
{
	private String Expensetype;
	private int Expenseamount;
	private String Expensedate;
	
	public expenses()
	{
		Expensetype = "Grocerry";
		Expenseamount = 3000;;
		Expensedate = "13/07/2023";
	}

	public expenses(String Expensetype, int Expenseamount, String Expensedate)
	{
		this.Expensetype = Expensetype;
		this.Expenseamount = Expenseamount;
		this.Expensedate = Expensedate;
	}

	public void setExpensetype(String Expensetype)
	{
		this.Expensetype = Expensetype;
	}
	
	public void setExpenseamount(int Expenseamount)
	{
		this.Expenseamount = Expenseamount;
	}
	
	public void setExpensedate(String Expensedate)
	{
		this.Expensedate = Expensedate;
	}
	
	public String getExpensetype()
	{
		return Expensetype;
	}	
	
	public int getExpenseamount()	
	{
		return Expenseamount;
	}
	
	public String getExpensedate() 
	{
		return Expensedate;
	}
	
}