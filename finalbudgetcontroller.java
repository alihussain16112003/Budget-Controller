package Budgetcontroller.Controller;
import Budgetcontroller.Controller.*;
import Budgetcontroller.Model.*;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class finalbudgetcontroller extends JFrame implements ActionListener
{
	Scanner sc = new Scanner(System.in);
	int savings;
	int shortage;
	JPanel p;
	JLabel L1,L2,L3,L4,L5,L6,L7,L8;
	JTextField T1,T2,T3,T4,T5,T6,T7,T8;
	Button Add,Cancel;
	int q=0,n=0;
	boolean a=false,b=false,c=false,d=false,e=false,f=false,g=false,h=false;
	int icount=0, iamount=0, eamount=0,saving=0,shorte=0;
	String idate="",etype="",edate="";
	static LocalDate dt = LocalDate.now();
	public finalbudgetcontroller()
	{
		setLocation(630,300);
		setSize(600,500);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.GRAY);
		
		JLabel title = new JLabel("Add Final Budget");
		title.setBounds(140,20,220,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		L1 = new JLabel("Member Count");
		L1.setBounds(100,80,120,20);
		L1.setFont(new Font("Arial",Font.PLAIN,15));
		
		T1 = new JTextField();
		T1.setBounds(240,80,200,20);
		p.add(L1); 		p.add(T1);
		
		L2 = new JLabel("Income Amount");
		L2.setBounds(100,120,140,20);
		L2.setFont(new Font("Arial",Font.PLAIN,15));
		
		T2 = new JTextField();
		T2.setBounds(240,120,200,20);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Income Date");
		L3.setBounds(100,160,120,20);
		L3.setFont(new Font("Arial",Font.PLAIN,15));
		
		T3 = new JTextField();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		T3.setText(formatter.format(dt));
		T3.setBounds(240,160,200,20);
		p.add(L3); 		p.add(T3);
		
		L4 = new JLabel("Expenses Type");
		L4.setBounds(100,200,120,20);
		L4.setFont(new Font("Arial",Font.PLAIN,15));
		
		T4 = new JTextField();
		T4.setBounds(240,200,200,20);
		p.add(L4); 		p.add(T4);
		
		L5 = new JLabel("Expense Amount");
		L5.setBounds(100,240,140,20);
		L5.setFont(new Font("Arial",Font.PLAIN,15));
		
		T5 = new JTextField();
		T5.setBounds(240,240,200,20);
		p.add(L5); 		p.add(T5);
		
		L6 = new JLabel("Expense Date");
		L6.setBounds(100,280,120,20);
		L6.setFont(new Font("Arial",Font.PLAIN,15));
		
		T6 = new JTextField();
		T6.setBounds(240,280,200,20);
		p.add(L6); 		p.add(T6);
		
		// L7 = new JLabel("Saving Amount");
		// L7.setBounds(100,320,140,20);
		// L7.setFont(new Font("Arial",Font.PLAIN,15));
		
		// T7 = new JTextField();
		// T7.setBounds(240,320,200,20);
		// p.add(L7); 		p.add(T7);
		
		// L8 = new JLabel("Short Amount");
		// L8.setBounds(100,360,140,20);
		// L8.setFont(new Font("Arial",Font.PLAIN,15));
		
		// T8 = new JTextField();
		// T8.setBounds(240,360,200,20);
		// p.add(L8); 		p.add(T8);
		
		Add= new Button("Add");
		Add.setBounds(100,400,90,20);
		Add.setFont(new Font("Arial",Font.PLAIN,15));
		Cancel = new Button("Cancel");
		Cancel.setBounds(200,400,90,20);
		Cancel.setFont(new Font("Arial",Font.PLAIN,15));
		Add.setBackground(Color.BLACK);
		Add.setForeground(Color.WHITE);
		Cancel.setBackground(Color.BLACK);
		Cancel.setForeground(Color.WHITE);
		
		p.add(Add);		p.add(Cancel);		
		setLayout(new BorderLayout());
		Add.addActionListener(this);
		Cancel.addActionListener(this);
		add(p,"Center");
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent Aobj){
		
		if(Aobj.getSource()==Add)
		{
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && T3.getText().length()!=0 && T4.getText().length()!=0 && T5.getText().length()!=0 && T6.getText().length()!=0)
			{
			
				if(!T1.getText().equals(""))
				{
					icount = Integer.parseInt(T1.getText());
					a=true;
				}
				if(!T2.getText().equals(" "))
				{	
					iamount = Integer.parseInt(T2.getText());
					b=true;
				}	
				
				if(!T3.getText().equals(""))
				{
					idate = T3.getText();
					c=true;
				}
				
				if(!T4.getText().equals(""))
				{
					etype = T4.getText();
					d=true;
				}
				if(!T5.getText().equals(" "))
				{	
					eamount = Integer.parseInt(T5.getText());
					e=true;
				}	
				
				if(!T6.getText().equals(""))
				{
					edate = T6.getText();
					f=true;
				}
				
				
					if(iamount>eamount)
					{
						saving = iamount-eamount;
						// T7.setText(String.valueOf(saving));
					}	
				
					else if(eamount>iamount)
					{
						shorte = eamount-iamount;
					}	
				
				
				
				
				if(a==true && b==true && c==true && d==true && e==true && f==true)
				{
					finalbudget F = new finalbudget();
					addfinalbudget(F);
					T1.setText("");
					T2.setText("");
					T3.setText("");
					T4.setText("");
					T5.setText("");
					T6.setText("");
					// T7.setText("");
					// T8.setText("");
					T1.requestFocus();
					JOptionPane.showMessageDialog(null,"One Data Added Succesfully");
				}
			}else			JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
		
				
		}
		
		if(Aobj.getSource()==Cancel)
		{
			T1.setText("");
			T2.setText("");
			T3.setText("");
			T4.setText("");
			T5.setText("");
			T6.setText("");
			// T7.setText("");
			// T8.setText("");
			T1.requestFocus();
			dispose();
		}
	
	}
	public void addfinalbudget(finalbudget Fobj)
	{
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/budget","root"," ");
			Statement stObj = cObj.createStatement();
			
			String inputQry = "insert into finalbudget(MemberCount,TotalIncome,IncomeDate,ExpenseType,ExpenseAmount,ExpenseDate,SavingAmount,ShortAmount) values(";
			inputQry += "" + icount +",";
			inputQry += "" + iamount + ",";
			inputQry += "'" + idate + "',";
			inputQry += "'" + etype +"',";
			inputQry += "" + eamount + ",";
			inputQry += "'" + edate + "',";
			inputQry += "" + saving + ",";
			inputQry += "'" + shorte + "')";
			
			System.out.print("One Data Added Succesfully");
			System.out.print("\n\nQry is : " + inputQry);
			stObj.executeUpdate(inputQry);


			stObj.close();
			cObj.close();
		}
		catch(Exception iObj) { iObj.printStackTrace(); }
	}	
	
}
class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent wObj)
	{		System.exit(0);			}
}