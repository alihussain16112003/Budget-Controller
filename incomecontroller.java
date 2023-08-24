package Budgetcontroller.Controller;
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

public class incomecontroller extends JFrame implements ActionListener
{
	Scanner sc = new Scanner(System.in);
	JPanel p;
	JLabel L1,L2,L3;
	JTextField T1,T2,T3;
	Button Add,Cancel;
	int q=0,n=0;
	boolean x = false, y = false , z= false;
	String a1="",s3="";
	int s=0,s1=0,s2=0;
	static LocalDate dt = LocalDate.now();
	public incomecontroller()
	{
		setLocation(630,300);
		setSize(600,500);
		
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(Color.GREEN);
		
		JLabel title = new JLabel("Add Income");
		title.setBounds(140,20,220,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		L1 = new JLabel("Members Count");
		L1.setBounds(100,80,120,20);
		L1.setFont(new Font("Arial",Font.PLAIN,15));
		
		T1 = new JTextField();
		T1.setBounds(240,80,200,20);
		p.add(L1); 		p.add(T1);
		
		L2 = new JLabel("Income Total");
		L2.setBounds(100,120,100,20);
		L2.setFont(new Font("Arial",Font.PLAIN,15));
		
		T2 = new JTextField();
		T2.setBounds(240,120,200,20);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Date");
		L3.setBounds(100,160,120,20);
		L3.setFont(new Font("Arial",Font.PLAIN,15));
		
		T3 = new JTextField();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		T3.setText(formatter.format(dt));
		T3.setBounds(240,160,200,20);
		p.add(L3); 		p.add(T3);
		
		Add= new Button("Add");
		Add.setBounds(100,350,90,20);
		Add.setFont(new Font("Arial",Font.PLAIN,15));
		Cancel = new Button("Cancel");
		Cancel.setBounds(200,350,90,20);
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
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && T3.getText().length()!=0){
			
			int  a2=0, d=0;
			
				if(!T1.getText().equals(""))
				{
						s = Integer.parseInt(T1.getText());
						x=true;
				}
				if(!T2.getText().equals(" "))
				{	
					s1 = Integer.parseInt(T2.getText());
					y=true;
				}	
				
				if(!T3.getText().equals(""))
				{
					a1 = T3.getText();
					z=true;
					
				}
				
				
				
				if(x==true && y==true && z==true)
				{
					income I = new income();
					addincome(I);
					T1.setText("");
					T2.setText("");
					T3.setText("");
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
			T1.requestFocus();
			dispose();
		}
		
		
						
	
	}
	
	public void addincome(income Iobj)
	{
				
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection cObj = DriverManager.getConnection("jdbc:mysql://localhost/budget","root"," ");
			Statement stObj = cObj.createStatement();
			String inputQry = "insert into income(MemberCount,TotalIncome,Date) values(";
			inputQry += "" + s +",";
			inputQry += "" + s1 + ",";
			inputQry += "'" + a1 + "')";
			stObj.executeUpdate(inputQry);
			System.out.print("\n\nQry is : " + inputQry);
			
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