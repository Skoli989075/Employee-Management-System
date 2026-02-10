package Four;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import Third.Home;
import Data.Conn;
public class AddEmployee extends JFrame implements ActionListener
{
	JTextField tfname,tfsirname, tfsalary,tfphone,tfaddress,tfemail,tfdesignation,tfaadhar;
	JDateChooser dcdob;
	JComboBox cbeducation;
	JLabel labelempid;
	JButton add;
	JButton back;
	JLabel lblempid;
	//private static final Color Color = null;
	Random ran=new Random();
	int number=ran.nextInt(999999);
	public AddEmployee()
	{
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading=new JLabel("Add Employee Detail");
		heading.setBounds(320, 30, 500, 50);
		heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
		add(heading);
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50,150,150,30);
		labelname.setFont(new Font("serif",Font.PLAIN,20));
		add(labelname);
		
	    tfname=new JTextField();
		tfname.setBounds(200, 150, 150, 30);
		add(tfname);
		
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
		
	    dcdob=new JDateChooser();
		dcdob.setBounds(200, 200, 150, 30);
		add(dcdob);
		
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
		
		String courses[]= {"BE","BTech","BSc","MSc","BCA","MCA","MTech","BBA","MBA"};
		cbeducation=new JComboBox(courses);
		setBackground(Color.WHITE);
		cbeducation.setBounds(600, 300, 150, 30);
		add(cbeducation);
		
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
		
	    tfaadhar=new JTextField();
		tfaadhar.setBounds(600, 350, 150, 30);
		add(tfaadhar);
		
	    labelempid=new JLabel("Employee id");
		labelempid.setBounds(50,400,150,30);
		labelempid.setFont(new Font("serif",Font.PLAIN,20));
		add(labelempid);
		
	    lblempid=new JLabel(""+number);
		lblempid.setBounds(200,400,150,30);
		lblempid.setFont(new Font("serif",Font.PLAIN,20));
		add(lblempid);
		
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

	        String name = tfname.getText();
	        String sirname = tfsirname.getText();
            if(dcdob.getDate()==null) {
            	JOptionPane.showInternalMessageDialog(null,"please select date of birth");
            	return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dob = sdf.format(dcdob.getDate());
	        String salary = tfsalary.getText();
	        String address = tfaddress.getText();
	        String phone = tfphone.getText();
	        String email = tfemail.getText();
	        String education = (String) cbeducation.getSelectedItem();
	        String designation = tfdesignation.getText();
	        String aadhar = tfaadhar.getText();
	        String emid = lblempid.getText();

	        try 
	        {
	            Conn conn = new Conn();

	            String query =
	                "INSERT INTO employee " +
	                "(name, sirname, dob, salary, address, phone, email, education, designation, aadhar, empId) " +
	                "VALUES " +
	                "('" + name + "','" + sirname + "','" + dob + "','" + salary + "','" +
	                 address + "','" + phone + "','" + email + "','" + education + "','" +
	                 designation + "','" + aadhar + "','" + emid + "')";

	            int result = conn.s.executeUpdate(query);

	            JOptionPane.showMessageDialog(null, "Details added successfully");
	            System.out.println("Rows inserted: " + result);

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
		new AddEmployee();
	}
}

	
	