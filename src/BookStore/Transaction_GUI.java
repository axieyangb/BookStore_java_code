package BookStore;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Transaction_GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField keyword_transaction;
	private JButton aButton_transaction;
	Customer customer=new Customer(Main.array);
	
	public Transaction_GUI()
	{
		 setTitle("Buy Book");
		 setSize(400,130);
		 setLayout(null);
		 setLocation(300,200);
		 setResizable(false);
		 
		 JPanel p1_transaction = new JPanel();
		 p1_transaction.setBounds(10,10,380,90);
		 p1_transaction.setLayout(new FlowLayout(FlowLayout.LEFT));
		 p1_transaction.setBorder(BorderFactory.createTitledBorder("Buy a book with ISBN"));
		 keyword_transaction = new JTextField(25);
		 aButton_transaction= new JButton("Transaction");
		 setEvent();
		 p1_transaction.add(keyword_transaction);
		 p1_transaction.add(aButton_transaction);
		 add(p1_transaction);
	}
	public void setEvent()
	{
		aButton_transaction.addActionListener(this);
		aButton_transaction.setActionCommand("Transaction");
	}
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		Books aBook = new Books();
		aBook.setISBN(keyword_transaction.getText());
		
		if(name.equals("Transaction"))
		{
			if(customer.transaction(aBook))
			{
				JOptionPane.showMessageDialog(this,"Successful Transaction !!");
			}
			else
				JOptionPane.showMessageDialog(this,"Failure Transaction ","ERROR!",JOptionPane.ERROR_MESSAGE);
			Main.display();
		}
	}
}
