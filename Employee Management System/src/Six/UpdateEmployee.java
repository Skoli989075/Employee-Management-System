package Six;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.awt.*;
import Third.Home;
import Data.Conn;
import java.sql.*;

	public class UpdateEmployee extends JFrame implements ActionListener
	{
		JTextField tfeducation,tfsirname, tfsalary,tfphone,tfaddress,tfemail,tfdesignation,tfaadhar,lbldob;
		
		JLabel labelempid;
		JButton add;
		JButton back;
		JLabel lblempid;
		String empId;
		public UpdateEmployee(String empId)
		{
			this.empId=empId;
			setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel heading=new JLabel("Update Employee Detail");
			heading.setBounds(320, 30, 500, 50);
			heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
			add(heading);
			
			JLabel labelname=new JLabel("Name");
			labelname.setBounds(50,150,150,30);
			labelname.setFont(new Font("serif",Font.PLAIN,20));
			add(labelname);
			
		    JLabel lblname=new JLabel();
		    lblname.setBounds(200, 150, 150, 30);
			add(lblname);
			
			JLabel sirname=new JLabel("Sir Name");
			sirname.setBounds(400,150,150,30);
			sirname.setFont(new Font("serif",Font.PLAIN,20));
			add(sirname);
			
		    tfsirname=new JTextField();
		    tfsirname.setBounds(600, 150, 150, 30);
			add(tfsirname);
			
			JLabel labeldob=new JLabel("Date of Birth");
			labeldob.setBounds(50,200,150,30);
			labeldob.setFont(new Font("serif",Font.PLAIN,20));
			add(labeldob);
			
		    JLabel lbldob=new JLabel();
		    lbldob.setBounds(200, 200, 150, 30);
			add(lbldob);
			
			JLabel labelsalary=new JLabel("Salary");
			labelsalary.setBounds(400,200,150,30);
			labelsalary.setFont(new Font("serif",Font.PLAIN,20));
			add(labelsalary);
			
		    tfsalary=new JTextField();
			tfsalary.setBounds(600, 200, 150, 30);
			add(tfsalary);
			
			JLabel labeladdress=new JLabel("Address");
			labeladdress.setBounds(50,250,150,30);
			labeladdress.setFont(new Font("serif",Font.PLAIN,20));
			add(labeladdress);
			
		    tfaddress=new JTextField();
			tfaddress.setBounds(200, 250, 150, 30);
			add(tfaddress);
			
			JLabel labelphone=new JLabel("Phone");
			labelphone.setBounds(400,250,150,30);
		    labelphone.setFont(new Font("serif",Font.PLAIN,20));
			add( labelphone);
			
		    tfphone=new JTextField();
			tfphone.setBounds(600, 250, 150, 30);
			add(tfphone);
			
			JLabel labelemaile=new JLabel("Email");
			labelemaile.setBounds(50,300,150,30);
			labelemaile.setFont(new Font("serif",Font.PLAIN,20));
			add( labelemaile);
			
		    tfemail=new JTextField();
			tfemail.setBounds(200, 300, 150, 30);
			add(tfemail);
			
			JLabel labeleducation=new JLabel("Highest Education");
			labeleducation.setBounds(400,300,150,30);
			labeleducation.setFont(new Font("serif",Font.PLAIN,20));
			add( labeleducation);
			
			
			tfeducation=new JTextField();
			tfeducation.setBounds(600, 300, 150, 30);
			add(tfeducation);
			
			JLabel labeldesignation=new JLabel("Designation");
			labeldesignation.setBounds(50,350,150,30);
			labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
			add(labeldesignation);
			
		    tfdesignation=new JTextField();
			tfdesignation.setBounds(200, 350, 150, 30);
			add(tfdesignation);
			
			JLabel labelaadhar=new JLabel("Adhar Number");
			labelaadhar.setBounds(400,350,150,30);
			labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
			add(labelaadhar);
			
		    JLabel lblaadhar=new JLabel();
		    lblaadhar.setBounds(600, 350, 150, 30);
			add(lblaadhar);
			
		    labelempid=new JLabel("Employee id");
			labelempid.setBounds(50,400,150,30);
			labelempid.setFont(new Font("serif",Font.PLAIN,20));
			add(labelempid);
			
		    lblempid=new JLabel();
			lblempid.setBounds(200,400,150,30);
			lblempid.setFont(new Font("serif",Font.PLAIN,20));
			add(lblempid);
			
			try
			{
				Conn c=new Conn();
				String query="select * from employee where empId='"+empId+"'";
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					lblname.setText(rs.getString("name"));
					tfsirname.setText(rs.getString("sirname"));
					lbldob.setText(rs.getString("dob"));
					tfaddress.setText(rs.getString("address"));
					tfsalary.setText(rs.getString("salary"));
					tfphone.setText(rs.getString("phone"));
					tfemail.setText(rs.getString("email"));
					tfeducation.setText(rs.getString("education"));
					lblaadhar.setText(rs.getString("aadhar"));
					lblempid.setText(rs.getString("empId"));
				    tfdesignation.setText(rs.getString("designation"));
					
					
				}
			}
			catch(Exception re)
			{
				re.printStackTrace();
			}
			
		    add=new JButton("Add Datails");
			add.setBounds(250, 550, 150, 40);
			add.setBackground(Color.BLACK);
			add.setForeground(Color.WHITE);
			add.addActionListener(this);
			add(add);
			
		    back=new JButton("Back");
			back.setBounds(450, 550, 150, 40);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			add(back);
			
			setSize(900,700);
			setLocation(300,50);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent ae)
		{

		    if (ae.getSource() == add) 
		    {

		     
		        String sirname = tfsirname.getText();
		        String salary = tfsalary.getText();
		        String address = tfaddress.getText();
		        String phone = tfphone.getText();
		        String email = tfemail.getText();
		        String education=tfeducation.getText();
		        String designation = tfdesignation.getText();
		        

		        try 
		        {
		            Conn conn = new Conn();

		            String query ="update employee set Sirname='"+sirname+"', Salary='"+salary+"', Address='"+address+"', Phone='"+phone+"', Email='"+email+"', Education='"+education+"', Designation='"+designation+"' where empId='"+empId+"'";
		            int result = conn.s.executeUpdate(query);
		            JOptionPane.showMessageDialog(null, "Details update successfully");
		            
		            setVisible(false);
		            new Home();

		        }
		        catch (Exception e)
		        {
		            e.printStackTrace(); 
		        }
		    }
		    else
		    {
		    	setVisible(false);
		    	new Home();
		    }
		    		    	  	    
		}
		public static void main(String[]args)
		{
			new UpdateEmployee("");
		}
	}

		
		


