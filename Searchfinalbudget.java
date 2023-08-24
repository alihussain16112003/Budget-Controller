package Budgetcontroller.Controller;
import Budgetcontroller.View.*;
import Budgetcontroller.Model.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class Searchfinalbudget extends JFrame implements ActionListener
{
	Button B2,B3,B;
	JLabel l1, l2;
	Choice ch;
	Frame j, j1;
	TextArea T;
	
	public Searchfinalbudget()
	{
		j = new Frame();
		j.setTitle("Search income");
		j.setLocation(630,350);
		j.setSize(500,300);	
		j.setBackground(Color.LIGHT_GRAY);
		
		JLabel title = new JLabel("Search Final Budget");
		title.setBounds(150,50,260,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		j.add(title);
        l1 = new JLabel("Income ID : ");
		l1.setBounds(150,130,100,30);
		l1.setFont(new Font("Arial",Font.BOLD,17));

        ch = new Choice();
		ch.setFont(new Font("Arial",Font.BOLD,17));
		ch.add("--None--");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/budget","root"," ");
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = sobj.executeQuery("select ID from finalbudget");
			while(rsobj.next()){
						ch.add(rsobj.getString(1));
					}
		}catch(Exception e){	e.printStackTrace();	}
		ch.setBounds(290,130,100,30);
		j.add(ch);
	
		B2 = new Button("Search");
		B2.setBackground(Color.DARK_GRAY);
		B2.setForeground(Color.WHITE);
		B2.setBounds(150,210,120,30);
		B2.setFont(new Font("Arial",Font.PLAIN,17));
		j.add(l1);
		j.add(ch);
		j.add(B2);	
		B2.addActionListener(this);
		j.setLayout(new BorderLayout());
		j.setVisible(true);
	}

	public void actionPerformed(ActionEvent AObj){

		if(AObj.getSource()==B2)
		{
			if(!ch.getSelectedItem().equals("--None--")){
				j.dispose();
				ShowSearch();
			}else			JOptionPane.showMessageDialog(null,"Plz Choose BookId");		
		}
		if(AObj.getSource()==B)
		{
			j1.dispose();
		}
	}
	
	public void ShowSearch()
	{
		JLabel L1, L2, L3, L4, L5, L6, L7, L8 ,L9;
		JLabel T1, T2, T3, T4, T5, T6, T7, T8 ,T9;
	
		j1 = new Frame();
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		
		j1.setTitle(" Final Budget Data Found ");
		j1.setLocation(600,150);
		j1.setSize(600,700);
		j1.setBackground(new Color(255,204,153));
		
		JLabel title = new JLabel("Search Fianl Budget");
		title.setBounds(180,70,260,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		j1.add(title);
		
		j1.setLayout(null);
        L1 = new JLabel("Final Budget ID : ");
		L1.setBounds(150,120,120,30);
		L1.setFont(new Font("Arial",Font.PLAIN,17));
      
        T1 = new JLabel();
		T1.setFont(f);
		T1.setBounds(290,120,200,30);
		j1.add(L1);		j1.add(T1); 		
		
		L2 = new JLabel("Member Count:");
		L2.setBounds(150,160,120,20);
		L2.setFont(new Font("Arial",Font.PLAIN,17));
		
		T2 = new JLabel();
		T2.setBounds(290,160,200,20);
		T2.setFont(f);
		j1.add(L2); 		j1.add(T2);
		
		L3 = new JLabel("Total Income :");
		L3.setBounds(150,200,120,20);
		L3.setFont(new Font("Arial",Font.PLAIN,17));
		
		T3 = new JLabel();
		T3.setBounds(290,200,200,20);
		T3.setFont(f);
		j1.add(L3); 		j1.add(T3);
		
		L4 = new JLabel("Income Date :");
		L4.setBounds(150,250,100,20);
		L4.setFont(new Font("Arial",Font.PLAIN,17));
		
		T4 = new JLabel();
		T4.setBounds(290,250,200,20);
		T4.setFont(f);
		j1.add(L4); 		j1.add(T4);
		
		L5 = new JLabel("Expense Type:");
		L5.setBounds(150,300,120,20);
		L5.setFont(new Font("Arial",Font.PLAIN,17));
		
		T5 = new JLabel();
		T5.setBounds(290,300,200,20);
		T5.setFont(f);
		j1.add(L5); 		j1.add(T5);
		
		L6 = new JLabel("Total Expenses :");
		L6.setBounds(150,350,120,20);
		L6.setFont(new Font("Arial",Font.PLAIN,17));
		
		T6 = new JLabel();
		T6.setBounds(290,350,200,20);
		T6.setFont(f);
		j1.add(L6); 		j1.add(T6);
		
		L7 = new JLabel("Expense Date:");
		L7.setBounds(150,400,100,20);
		L7.setFont(new Font("Arial",Font.PLAIN,17));
		
		T7 = new JLabel();
		T7.setBounds(290,400,200,20);
		T7.setFont(f);
		j1.add(L7); 		j1.add(T7);
		
		L8 = new JLabel("Saving Amount :");
		L8.setBounds(150,450,120,20);
		L8.setFont(new Font("Arial",Font.PLAIN,17));
		
		T8 = new JLabel();
		T8.setBounds(290,450,200,20);
		T8.setFont(f);
		j1.add(L8); 		j1.add(T8);
		
		L9 = new JLabel("Short Amount:");
		L9.setBounds(150,500,100,20);
		L9.setFont(new Font("Arial",Font.PLAIN,17));
		
		T9 = new JLabel();
		T9.setBounds(290,500,200,20);
		T9.setFont(f);
		j1.add(L9); 		j1.add(T9);
	
		B = new Button("CLOSE");
		B.setBackground(Color.DARK_GRAY);
		B.setForeground(Color.WHITE);
		B.setBounds(190,580,180,30);
		B.setFont(new Font("Arial",Font.PLAIN,17));
		j1.add(B);
		
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/budget","root"," ");
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = sobj.executeQuery(" select ID,MemberCount,TotalIncome,IncomeDate,ExpenseType,ExpenseAmount,ExpenseDate,SavingAmount,ShortAmount from finalbudget where ID= '"+ch.getSelectedItem()+"';");
				
					while(rsobj.next()){
						T1.setText(rsobj.getString("ID")); 
						T2.setText(rsobj.getString("MemberCount")); 
						T3.setText(rsobj.getString("TotalIncome")); 
						T4.setText(rsobj.getString("IncomeDate"));
						T5.setText(rsobj.getString("ExpenseType")); 
						T6.setText(rsobj.getString("ExpenseAmount")); 
						T7.setText(rsobj.getString("ExpenseDate"));
						T8.setText(rsobj.getString("SavingAmount")); 
						T9.setText(rsobj.getString("ShortAmount"));
						
					}
				}catch(Exception e){	e.printStackTrace();	}
			
		j1.setLayout(new BorderLayout());
		B.addActionListener(this);
		j1.setVisible(true);
	}
}