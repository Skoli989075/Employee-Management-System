package Five;
import javax.swing.*;
import Six.UpdateEmployee;
import java.awt.*;
import Data.Conn;
import Third.Home;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class ViewEmployee extends JFrame implements ActionListener

{
	JTable table;
	Choice cemployeeid;
	JButton search,print,update,back;
	public ViewEmployee()
	{
		setLayout(null);
		setBackground(Color.WHITE);
		
		JLabel searchlbl=new JLabel("Search by Employee id");
		searchlbl.setBounds(20,20,150,20);
		add(searchlbl);
		
		cemployeeid=new Choice();
		cemployeeid.setBounds(180, 20, 150, 20);
		add(cemployeeid);
		
		try
		{
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from employee");
			
			while(rs.next()) {
				cemployeeid.add(rs.getString("empId"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		table=new JTable();
		
		try
		{
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception ep)
		{
			ep.printStackTrace();
		}
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,100,900,600);
		add(jsp);
		
		search=new JButton("serach");
		search.setBounds(20,70,80,20);
		add(search);
		search.addActionListener(this);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		add(print);
		print.addActionListener(this);
		
		update=new JButton("Update");
		update.setBounds(220,70,80,20);
		add(update);
		update.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(320,70,90,20);
		add(back);
		back.addActionListener(this);
		
		setSize(900,700);   
		setLocation(300,100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == search) {
			String query="select * from employee where empId= '"+cemployeeid.getSelectedItem()+"'";
			try
			{
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception ek)
			{
				ek.printStackTrace();
			}
		}else if(ae.getSource() == print) {
			try
			{
			  table.print();
			}
			catch(Exception es)
			{
				es.printStackTrace();
			}
		}else if(ae.getSource() == update) {
			setVisible(false);
			new UpdateEmployee(cemployeeid.getSelectedItem());
		}else {
			setVisible(false);
			new Home();
		}
	}
  public static void main(String[]args)
  {
	  new ViewEmployee();
  }
}
