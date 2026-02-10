package secondPage;
import Data.Conn;
import Third.Home;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	JTextField tfusername,tfpassword;

	public Login()
	{
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblusername=new JLabel("username");
		lblusername.setBounds(40,20,100,30);
		add(lblusername);
		
		tfusername=new JTextField();
		tfusername.setBounds(150,20,150,30);
		add(tfusername);
		
		JLabel lblpassword=new JLabel("password");
		lblpassword.setBounds(40,70,100,30);
		add(lblpassword);
		
		tfpassword=new JTextField();
		tfpassword.setBounds(150,70,150,30);
		add(tfpassword);
		
		JButton login =new JButton("LOGIN");
		login.setBounds(150,140,150,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		ImageIcon i1=new ImageIcon("src/icons/second.jpg");
		Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
		JLabel image=new JLabel(new ImageIcon(i2));
		image.setBounds(350,0,200,200);
		add(image);
		
		setSize(600,300);
		setLocation(400,200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			String username=tfusername.getText();
			String password=tfpassword.getText();
			
			Conn c= new Conn();
			
			String query="Select * from login where username='"+username+"' and password='"+password+"'";
			ResultSet rs=c.s.executeQuery(query);
			if(rs.next())
			{
				setVisible(false);
				new Home();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalide username and passwoed");
				setVisible(false);
			}
		}
		catch(Exception p) 
		{
			p.printStackTrace();
		}
	}
	
	public static void main(String[]args)
	{
		new Login();
	}
	
		
	
}
