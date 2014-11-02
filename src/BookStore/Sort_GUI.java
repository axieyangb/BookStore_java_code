package BookStore;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Sort_GUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton r1_sort;
	private JRadioButton r2_sort;
	private JRadioButton r3_sort;
	private JRadioButton r4_sort;
	private JRadioButton r5_sort;
	private JRadioButton r6_sort;
	private JButton aButton_sort;
	Customer customer=new Customer(Main.array);
	
	public Sort_GUI()
	{
		 setTitle("Sort Your BookList");
		 setSize(400,160);
		 setLayout(null);
		 setLocation(300,200);
		 setResizable(false);
		 
		 JPanel p1_sort = new JPanel();
		 p1_sort.setBounds(10,10,380,120);
		 p1_sort.setLayout(new FlowLayout(FlowLayout.LEFT));
		 p1_sort.setBorder(BorderFactory.createTitledBorder("Sort by"));
		 r1_sort = new JRadioButton("Title(String)");
		 r2_sort = new JRadioButton("AuthorName(String)");
		 r3_sort = new JRadioButton("Stock(int)");
		 r4_sort = new JRadioButton("PublishedDate(int)");
		 r5_sort = new JRadioButton("Price(double)");
		 r6_sort = new JRadioButton("ISBN(String)");
		 aButton_sort = new JButton("Sort");
		 ButtonGroup group = new ButtonGroup ();
		 setEvent();
		 group.add(r1_sort);
		 group.add(r2_sort);
		 group.add(r3_sort);
		 group.add(r4_sort);
		 group.add(r5_sort);
		 group.add(r6_sort);
		
		 p1_sort.add(r1_sort);
		 p1_sort.add(r2_sort);
		 p1_sort.add(r3_sort);
		 p1_sort.add(r4_sort);
		 p1_sort.add(r5_sort);
		 p1_sort.add(r6_sort);
		 p1_sort.add(aButton_sort);
		 add(p1_sort);
	}
	public void setEvent()
	{
		aButton_sort.addActionListener(this);
		aButton_sort.setActionCommand("Sort");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if(name=="Sort")
		{
			//title 
			if(r1_sort.isSelected())
			{
				customer.sortBookByTitle();
				GUIInterface.aText_p4.setText(Main.TITLE+Main.array.toString());
			}
			//authorName
			else if(r2_sort.isSelected())
			{
				customer.sortBookByAuthorName();
				GUIInterface.aText_p4.setText(Main.TITLE+Main.array.toString());
			}
			//Stock
			else if(r3_sort.isSelected())
			{
				customer.sortBookByStock();
				GUIInterface.aText_p4.setText(Main.TITLE+Main.array.toString());
			}
			//publishedDate
			else if(r4_sort.isSelected())
			{
				customer.sortBookByPublishedDate();
				GUIInterface.aText_p4.setText(Main.TITLE+Main.array.toString());
			}
			//price
			else if(r5_sort.isSelected())
			{
				customer.sortBookByPrice();
				GUIInterface.aText_p4.setText(Main.TITLE+Main.array.toString());
			}
			//ISBN
			else if(r6_sort.isSelected())
			{
				customer.sortBookByISBN();
				GUIInterface.aText_p4.setText(Main.TITLE+Main.array.toString());
			}
		}
	}
}
