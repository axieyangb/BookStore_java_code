package BookStore;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_GUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textF1_login;
	private JTextField textF2_login;
	JLabel label1;
	JLabel label2;	
	JButton aButton_login;
	boolean flag=false;
	public Login_GUI()
	{
		 setTitle("Please Login");
		 setSize(400,270);
		 setLayout(null);
		 setLocation(300,200);
		 setResizable(false);
		 
		 JPanel p1_login = new JPanel();
		 p1_login.setBounds(10,10,380,220);
		 p1_login.setLayout(new FlowLayout(FlowLayout.LEFT));
		 p1_login.setBorder(BorderFactory.createTitledBorder("Login"));
		 label1 = new JLabel("UserName:");
		 textF1_login = new  JTextField(25);
		 textF1_login.setText("yyx");
		 label2 = new JLabel("Password:");
		 textF2_login = new   JPasswordField(25);
		 aButton_login = new JButton("Login");
		 JLabel lab1=new JLabel ("Please skim the code to find the password and userName");
		 setEvent();
		 p1_login.add(label1);
		 p1_login.add(textF1_login);
		 p1_login.add(label2);
		 p1_login.add(textF2_login);
		 p1_login.add(aButton_login);
		 p1_login.add(lab1);
		 add(p1_login);
	}
	public void setEvent()
	{
		aButton_login.addActionListener(this);
		aButton_login.setActionCommand("Login");
	}
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		if(name.equals("Login"))
		{
			if(textF1_login.getText().equalsIgnoreCase("cs201")&&textF2_login.getText().equalsIgnoreCase("cs201"))
			{
				JOptionPane.showMessageDialog(this,"Succeed login!");
				GUIInterface.bButton_p1.setVisible(true);
				GUIInterface.cButton_p1.setVisible(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Failure Login!--you idiot!","ERROR!",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}

