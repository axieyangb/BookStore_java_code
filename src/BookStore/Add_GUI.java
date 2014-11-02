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
import javax.swing.JTextField;

public class Add_GUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textF1_add;
	private JTextField textF2_add;
	private JTextField textF3_add;
	private JTextField textF4_add;
	private JTextField textF5_add;
	private JTextField textF6_add;
	private JTextField textF7_add;
	private JTextField textF8_add;
	private JButton aButton_add;
	JTextField keyword_search ;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	Administrator admin=new Administrator(Main.array);
	
	public Add_GUI()
	{
		 setTitle("Add a New Book");
		 setSize(400,270);
		 setLayout(null);
		 setLocation(300,200);
		 setResizable(false);
		 
		 JPanel p1_add = new JPanel();
		 p1_add.setBounds(10,10,380,220);
		 p1_add.setLayout(new FlowLayout(FlowLayout.LEFT));
		 p1_add.setBorder(BorderFactory.createTitledBorder("Add a new Book"));
		 label1 = new JLabel("Title:");
		 textF1_add = new  JTextField(25);
		 label2 = new JLabel("AuthorName:");
		 textF2_add = new  JTextField(7);
		 textF3_add = new  JTextField(7);
		 textF4_add= new  JTextField(7);
		 label3 = new JLabel("PublishedDate:");
		 textF5_add = new  JTextField(24);
		 label4 = new JLabel("Price:");
		 textF6_add = new  JTextField(29);
		 label5 = new JLabel("ISBN:");
		 textF7_add = new  JTextField(28);
		 label6 = new JLabel("Stock:");
		 textF8_add = new  JTextField(25);
		 aButton_add = new JButton("Add");
		 
		 setEvent();
		 p1_add.add(label1);
		 p1_add.add(textF1_add);
		 p1_add.add(label2);
		 p1_add.add(textF2_add);
		 p1_add.add(textF3_add);
		 p1_add.add(textF4_add);
		 p1_add.add(label3);
		 p1_add.add(textF5_add);
		 p1_add.add(label4);
		 p1_add.add(textF6_add);
		 p1_add.add(label5);
		 p1_add.add(textF7_add);
		 p1_add.add(label6);
		 p1_add.add(textF8_add);
		 p1_add.add(aButton_add);
		 add(p1_add);
		
	}
	public void setEvent()
	{
		aButton_add.addActionListener(this);
		aButton_add.setActionCommand("Add");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if(name.equals("Add"))
		{
			Books aBook;
			String title=textF1_add.getText();
			Name aName= new Name(textF2_add.getText(),textF3_add.getText(),textF4_add.getText());
			int publishedDate=Integer.parseInt(textF5_add.getText());
			double price=Double.parseDouble(textF6_add.getText());
			String ISBN=textF7_add.getText();
			int stock=Integer.parseInt(textF8_add.getText());
			aBook=new Books(title,aName,publishedDate,price,ISBN,stock);
			if(admin.addBook(aBook))
				JOptionPane.showMessageDialog(this,"Successful Added!!");
			else
				JOptionPane.showMessageDialog(this,"Failure Added!","ERROR!",JOptionPane.ERROR_MESSAGE);
			Main.display();

		}
		
	}
	
}
