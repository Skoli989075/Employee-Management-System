package Third;
import Seven.RemoveEmployee;
import java.awt.Image;
import javax.swing.*;
import Four.AddEmployee;
import Five.ViewEmployee;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener
{
	
	JButton view,add,update,remove;
	public Home()
	{
		setLayout(null);
		
		ImageIcon i1=new ImageIcon("src/icons/home.jpg");
		Image i2=i1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
		JLabel image=new JLabel(new ImageIcon(i2));
		image.setBounds(0,0,1120,630);
		add(image);
		
		JLabel heading=new JLabel("Employee Management System");
		heading .setBounds(650,20,400,40);
		heading.setFont(new Font("serif",Font.BOLD,25));
		image.add(heading);
		
	    add=new JButton("Add Employee");
		add.setBounds(650, 80, 150, 40);
		image.add(add);
		add.addActionListener(this);
		
	    view=new JButton("Viwe Employees");
		view.setBounds(820, 80, 150, 40);
		image.add(view);
		view.addActionListener(this);
		
	    update=new JButton("Update Employee");
		update.setBounds(650, 140, 150, 40);
		image.add(update);
		update.addActionListener(this);
		
	    remove=new JButton("Remove Employee");
		remove.setBounds(820, 140, 150, 40);
		image.add(remove);
		remove.addActionListener(this);
		
		setSize(1120,630);
		setLocation(250,100);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == add)
		{
			setVisible(false);
			new AddEmployee();
		}
		else if(ae.getSource()== view)
		{
			setVisible(false);
			new ViewEmployee();
		}
		else if(ae.getSource()== update)
		{
			setVisible(false);
			new ViewEmployee();
		}
		else if(ae.getSource()==remove)
		{
			setVisible(false);
			new RemoveEmployee();
		}
	}
  public static void main(String[]args)
  {
	  new Home();
  }
}
