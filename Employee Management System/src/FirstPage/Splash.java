package FirstPage;
import javax.swing.*;
import secondPage.Login;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Splash extends JFrame implements ActionListener
{
	Splash()
	{
		setLayout(null);
		JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
		add(heading);
		heading.setBounds(80,30,1200,60);
		heading.setFont(new Font("serif",Font.PLAIN,60));
		heading.setForeground(Color.RED);
		
	
		setSize(1170,650);
		setLocation(200,50);
		setVisible(true);
		setBackground(Color.WHITE);
		
		
		ImageIcon i1=new ImageIcon("src/icons/front.jpg");
		Image i2=i1.getImage().getScaledInstance(1100, 500,Image.SCALE_DEFAULT);
		JLabel image=new JLabel(new ImageIcon(i2));
		image.setBounds(50,100,1050,500);
		add(image);
		
		JButton clickhere =new JButton("CLICK HERE TO CONTINUE");
		clickhere.setBounds(400,400,300,70);
		clickhere.setBackground(Color.BLACK);
		clickhere.setForeground(Color.WHITE);
		image.add(clickhere);
		clickhere.addActionListener(this);
		
		while(true)
		{
			heading.setVisible(false);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e) {}
			
			heading.setVisible(true);
			try
			{
				Thread.sleep(500);
			}
			catch(Exception e) {}
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
		new Login();
	}
	public static void main(String[]args)
	{
		Splash splash=new Splash();
	}
}
