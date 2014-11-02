package BookStore;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import javax.swing.*;
public class GUIInterface extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//declare the elements in the GUI
	private JPanel p1;
	private JPanel p2 ;
	private JPanel p3 ;
	private JPanel p4 ;
	private JButton aButton_p1;
	static JButton bButton_p1;
	static JButton cButton_p1;
	private JButton aButton_p2;
	private JButton bButton_p2;
	private JButton cButton_p2;
	private JButton aButton_p3;
	private JButton bButton_p3;
	private JButton cButton_p3;
	private JButton dButton_p3;
	static JTextArea aText_p4;
	private int flag=0;
public GUIInterface ()
{
	 setTitle("BookStore Application--Author Yang-yang Xie");
	 setSize(600,600);
	 setLayout(null);
	 setLocation(200,100);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 setResizable(false);
	 
	 p1 = new JPanel();
	 p1.setBounds(10,10,580,60);
	 p1.setLayout(new FlowLayout(FlowLayout.CENTER,70,2));
	 p1.setBorder(BorderFactory.createTitledBorder("Select your identity"));
	 aButton_p1 = new JButton("Customer");
	 bButton_p1 = new JButton("Administor");
	 cButton_p1 = new JButton("Admin Login");
	 bButton_p1.setVisible(false);
	 p1.add(aButton_p1);
	 p1.add(bButton_p1);
	 p1.add(cButton_p1);
	 
	 p2 = new JPanel();
	 p2.setBounds(10,80,580,60);
	 p2.setLayout(new FlowLayout(FlowLayout.CENTER,40,2));
	 p2.setBorder(BorderFactory.createTitledBorder("Customer"));
	 aButton_p2 = new JButton("Search");
	 bButton_p2 = new JButton("Sort");
	 cButton_p2 = new JButton("Transaction");

	 p2.add(aButton_p2);
	 p2.add(bButton_p2);
	 p2.add(cButton_p2);
	
	 p3 = new JPanel();
	 p3.setBounds(10,150,580,60);
	 p3.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
	 p3.setBorder(BorderFactory.createTitledBorder("Administor"));
	 aButton_p3 = new JButton("Search");
	// aButton_p3.setSize(100, 60);
	 bButton_p3 = new JButton("Sort");
	// bButton_p3.setSize(100, 60);
	 cButton_p3 = new JButton("Add");
	// cButton_p3.setSize(100, 60);
	 dButton_p3 = new JButton("Delete");
	 dButton_p3.setSize(100, 60);
	 p3.add(aButton_p3);
	 p3.add(bButton_p3);
	 p3.add(cButton_p3);
	 p3.add(dButton_p3);
 
	 p4 = new JPanel();
	 p4.setBounds(10,220,580,350);
	 p4.setLayout(new FlowLayout(FlowLayout.CENTER));
	 p4.setBorder(BorderFactory.createTitledBorder("Result"));
	 aText_p4 = new JTextArea(18,50);
	
	// aText_p4.setLineWrap(true);
	 JScrollPane scroll = new JScrollPane(aText_p4);
	   scroll.setHorizontalScrollBarPolicy( 
	    		 JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	     scroll.setVerticalScrollBarPolicy( 
	    		 JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	
	 aText_p4.setText("What the fuck!!!");
	 aText_p4.setEditable(false);
	 aText_p4.setBackground(Color.white);
	 p4.add(scroll);

	 
	 setButtonEvent();
	 buttonEnable(flag);
	 add(p1);
	 add(p2);
	 add(p3);
	 add(p4);
}

//select the status
public void buttonEnable(int flag)
{
	if(flag==0)
	{
		setPanelEnable_2(false);
		setPanelEnable_3(false);
	}
	 else if(flag==1)
	 {
		 setPanelEnable_2(true);
		 setPanelEnable_3(false);	 
	 }
	else if(flag==2)
	{
		setPanelEnable_3(true);
		setPanelEnable_2(false);	 
	}
}
public void setPanelEnable_2(boolean flag)
{
	p2.setEnabled(flag);
	aButton_p2.setEnabled(flag);
	bButton_p2.setEnabled(flag);
	cButton_p2.setEnabled(flag);
}
public void setPanelEnable_3(boolean flag)
{
	p3.setEnabled(flag);
	aButton_p3.setEnabled(flag);
	bButton_p3.setEnabled(flag);
	cButton_p3.setEnabled(flag);
	dButton_p3.setEnabled(flag);
}

public void setButtonEvent()
{
	 aButton_p1.setActionCommand("customer");
	 aButton_p1.addActionListener(this);
	 bButton_p1.setActionCommand("administor");
	 bButton_p1.addActionListener(this);
	 cButton_p1.setActionCommand("login");
	 cButton_p1.addActionListener(this);
	 aButton_p2.setActionCommand("search");
	 aButton_p2.addActionListener(this);
	 aButton_p3.setActionCommand("search");
	 aButton_p3.addActionListener(this);
	 bButton_p2.setActionCommand("sort");
	 bButton_p2.addActionListener(this);
	 bButton_p3.setActionCommand("sort");
	 bButton_p3.addActionListener(this);
	 cButton_p2.setActionCommand("transaction");
	 cButton_p2.addActionListener(this);
	 cButton_p3.setActionCommand("add");
	 cButton_p3.addActionListener(this);
	 dButton_p3.setActionCommand("delete");
	 dButton_p3.addActionListener(this);
	 
}

@Override
public void actionPerformed(ActionEvent e) {
	String name = e.getActionCommand();
	switch(name)
	{
	case "login":
	{
		Login_GUI aLoginFrame = new Login_GUI();
		aLoginFrame.setVisible(true);
		break;
	}
	case "search":
		{
			Search_GUI aSearchFrame = new Search_GUI();
			aSearchFrame.setVisible(true);
			break;
		}

	case "customer":
		{
			flag=1;
			buttonEnable(flag);
			break;
		}
	case "administor":
	{
		flag=2;
		buttonEnable(flag);
		break;
	}
	case "sort":
	{
		Sort_GUI aSortFrame = new Sort_GUI();
		aSortFrame.setVisible(true);
		break;
	}
	case "transaction":
	{
		Transaction_GUI aTransactionFrame = new Transaction_GUI();
		aTransactionFrame.setVisible(true);
		break;
	}
	case "delete":
	{
		Delete_GUI aDeleteFrame = new Delete_GUI();
		aDeleteFrame.setVisible(true);
		break;
	}
	case "add":
	{
		Add_GUI aAddFrame = new Add_GUI();
		aAddFrame.setVisible(true);
		break;
	}
	default:
	{
		aText_p4.setText("ERROR");
	}
	}
}

}

