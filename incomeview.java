package Budgetcontroller.View;
import Budgetcontroller.Controller.*;
import Budgetcontroller.Model.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane.*;


public class incomeview extends JFrame implements ActionListener
{	

	Button B;
	JPanel P;
	JTable j;
	Choice ch;

	public incomeview()
	{
		setTitle("Show All Income");
		setSize(800,600);
		setLocation(600,300);
		setBackground(Color.BLACK);			
			
		try
		{
			P = new JPanel();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/budget","root"," ");
			
			Statement sobj = Cobj.createStatement();
			ResultSet rsobj = null;
			rsobj = sobj.executeQuery("Select * from income");
			ResultSetMetaData rsmd = rsobj.getMetaData();
			
			Font font = new Font("Arial",Font.BOLD,25);
			
			
			j=new JTable();
			DefaultTableModel model = (DefaultTableModel)j.getModel();
			
			int cols = rsmd.getColumnCount();
			String colName[] = new String[cols];
			
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
				
			model.setColumnIdentifiers(colName);
			j.setFont(new Font("Arial",Font.PLAIN,15));	
			String id,icount,iamount,idate;
				
			while(rsobj.next()){
				id = String.valueOf(rsobj.getInt(1));
				icount = String.valueOf(rsobj.getInt(2));
				iamount = String.valueOf(rsobj.getInt(3));
				idate = rsobj.getString(4);
	
				String[] row = {id,icount,iamount,idate};
				model.addRow(row);
			}	

			JTableHeader tableHeader = j.getTableHeader();
			tableHeader.setFont(font);
			Cobj.close();
			sobj.close();
			
		}
		catch(Exception e){		e.printStackTrace();		}
			B = new Button("CLOSE");
			B.setBackground(Color.DARK_GRAY);
			B.setForeground(Color.WHITE);
			B.setBounds(300,300,150,30);
			P.add(B);
			B.addActionListener(this);
			setLayout(new BorderLayout());
			add(P,"South");
			setVisible(true);
			add(new JScrollPane(j));
	}
	
	public void actionPerformed(ActionEvent AObj)
	{
		if(AObj.getSource()==B)
		{
			dispose();
		}
	}
}



		
	
	