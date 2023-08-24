import Budgetcontroller.View.*;
import Budgetcontroller.Controller.*;
import Budgetcontroller.Model.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;	

public class MainClass extends Frame implements ActionListener
{
	public static void main(String ...q)
	{
			MainClass m= new MainClass();
	}
	
	MenuBar Bar;
	Menu Imenu,Emenu,Fmenu;
	MenuItem menu[];
	Font f;
	Image img;
	int i;
	
	public MainClass()
	{
		setTitle("Monthly Budget Managment");
		setSize(900,700);
		setLocation(500,200);
		setBackground(Color.BLACK);
		f = new Font("Arial", Font.BOLD, 17); 
		Toolkit tObj = Toolkit.getDefaultToolkit();
		img = tObj.getImage("D://Amaan//Amaan2.jpg");
		
		Cursor Cobj = tObj.createCustomCursor(img, new Point(25,25),"MyCursor");		
		setCursor(Frame.HAND_CURSOR);
		setIconImage(img);
		
		Bar = new MenuBar();
		Imenu = new Menu("Income");
		Emenu = new Menu("Eexpenses");
		Fmenu = new Menu("Final Budget");
		f = new Font("Arial", Font.BOLD, 17);
		setFont(f);
		Imenu.setFont(new Font("sans-serif",Font.BOLD, 18));
		Emenu.setFont(new Font("sans-serif",Font.BOLD, 18));
		Fmenu.setFont(new Font("sans-serif",Font.BOLD, 18));
		
		menu = new MenuItem[12];
		
		menu[0]= new MenuItem("Add income");
		menu[1]= new MenuItem("Show income");
		menu[2] = new MenuItem("Delete Income");
		menu[3] = new MenuItem("Search Income");

		
		menu[4] = new MenuItem("Add Expenses");
		menu[5] = new MenuItem("Show Expenses");
		menu[6] = new MenuItem("Delete Expenses");
		menu[7] = new MenuItem("Search Expenses");


		menu[8] = new MenuItem("Add Final Budget");
		menu[9] = new MenuItem("Show Final Budget");
		menu[10] = new MenuItem("Delete Final Budget");
		menu[11] = new MenuItem("Search Final Budget");

		
		Imenu.add(menu[0]);		Imenu.add(menu[1]);		Imenu.add(menu[2]);		Imenu.add(menu[3]);	
		Emenu.add(menu[4]);		Emenu.add(menu[5]);		Emenu.add(menu[6]);		Emenu.add(menu[7]);
		Fmenu.add(menu[8]);		Fmenu.add(menu[9]);		Fmenu.add(menu[10]);	Fmenu.add(menu[11]);
		
		Bar.add(Imenu);
		Bar.add(Emenu);
		Bar.add(Fmenu);
		
		setMenuBar(Bar);
		
		menu[0].addActionListener(this);
		menu[1].addActionListener(this);
		menu[2].addActionListener(this);
		menu[3].addActionListener(this);
		menu[4].addActionListener(this);
		menu[5].addActionListener(this);
		menu[6].addActionListener(this);
		menu[7].addActionListener(this);
		menu[8].addActionListener(this);
		menu[9].addActionListener(this);
		menu[10].addActionListener(this);
		menu[11].addActionListener(this);
		
		addWindowListener(new MyWin());
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent AObj)
	{
		
		if(AObj.getSource()==menu[0])
		{				
			income i = new income();
			incomecontroller ic = new incomecontroller();
			
		}
		else if(AObj.getSource()==menu[1])
		{	
			new incomeview();
		}
		
		else if(AObj.getSource()==menu[2])
		{			
			new incomeDelete();
		}
		
		else if(AObj.getSource()==menu[3])
		{			
			new Searchincome();
		}
		
		else if(AObj.getSource()==menu[4])
		{			
			new expensescontroller();
		}
		
		else if(AObj.getSource()==menu[5])
		{			
			new expensesview();
		}
		
		else if(AObj.getSource()==menu[6])
		{			
			new expensesDelete();
		}
		
		else if(AObj.getSource()==menu[7])
		{			
			new expenseSearch();
		}
		
		else if(AObj.getSource()==menu[8])
		{			
			new finalbudgetcontroller();
		}
		
		else if(AObj.getSource()==menu[9])
		{			
			new finalbudgetview();
		}
		
		else if(AObj.getSource()==menu[10])
		{			
			new finalbudgetDelete();
		}
		
		else if(AObj.getSource()==menu[11])
		{			
			new Searchfinalbudget();
		}
	}
	
		public void paint(Graphics Gobj)
		{
			Gobj.drawImage(img,0,0,900,800,this);
		}
}		

class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent wObj)
	{		System.exit(0);			}
}
	