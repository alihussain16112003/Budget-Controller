package Budgetcontroller.Model;
import Budgetcontroller.Controller.*;
import Budgetcontroller.Model.*;

public class finalbudget
{
	private income Monthlyincome;
	private expenses Monthlyexpenses;
	private int Savingamount;
	private int Shortamount;
	
	public finalbudget()
	{
		Monthlyincome = new income();
		Monthlyexpenses = new expenses();
		Savingamount = Monthlyincome.gettotalamount() - Monthlyexpenses.getExpenseamount();
		Shortamount = Monthlyincome.gettotalamount() - Monthlyexpenses.getExpenseamount();
	}
	
	public finalbudget(income Monthlyincome , expenses Monthlyexpenses , int Savingamount , int Shortamount)
	{
		this.Monthlyincome = Monthlyincome;
		this.Monthlyexpenses = Monthlyexpenses;
		this.Savingamount =Savingamount;
		this.Shortamount = Shortamount;
	}
	
		public void setMonthlyincome(income Monthlyincome)
	{
		this.Monthlyincome = Monthlyincome;
	}
	
	public void setMonthlyexpenses(expenses Monthlyexpenses)
	{
		this.Monthlyexpenses = Monthlyexpenses;
	}
	
	public void setSavingamount(int Savingamount)
	{
		this.Savingamount =Monthlyincome.gettotalamount() - Monthlyexpenses.getExpenseamount(); 
	}
	
	public void setShortamount(int Shortamount)
	{
		this.Shortamount =  Monthlyincome.gettotalamount() - Monthlyexpenses.getExpenseamount();
	}
	
	public income getMonthlyincome()
	{
		return Monthlyincome;
	}	
	
	public expenses getMonthlyexpenses()	
	{
		return Monthlyexpenses;
	}
	
	public int getSavingamount() 
	{
		return Savingamount;
	}
	
	
	public int getShortamount() 
	{
		return Shortamount;
	}
	
}