package BookStore;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
















import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Search_GUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton r1_search;
	private JRadioButton r2_search;
	private JRadioButton r3_search;
	private JRadioButton r4_search;
	private JRadioButton r5_search;
	private JRadioButton r6_search;
	private JButton aButton_search;
	JTextField keyword_search ;
	Customer customer=new Customer(Main.array);
	
	public Search_GUI()
	{
		 setTitle("Search Your Book");
		 setSize(400,160);
		 setLayout(null);
		 setLocation(300,200);
		 setResizable(false);
		 
		 JPanel p1_search = new JPanel();
		 p1_search.setBounds(10,10,380,120);
		 p1_search.setLayout(new FlowLayout(FlowLayout.LEFT));
		 p1_search.setBorder(BorderFactory.createTitledBorder("Search by"));
		 r1_search = new JRadioButton("Title(String)");
		 r2_search = new JRadioButton("AuthorName(String)");
		 r3_search = new JRadioButton("Stock(int)");
		 r4_search = new JRadioButton("PublishedDate(int)");
		 r5_search = new JRadioButton("Price(double)");
		 r6_search = new JRadioButton("ISBN(String)");
		 aButton_search = new JButton("Search");
		 ButtonGroup group = new ButtonGroup ();
		 keyword_search = new JTextField(25);
		 keyword_search.setSize(30, 20);
		 setEvent();
		 group.add(r1_search);
		 group.add(r2_search);
		 group.add(r3_search);
		 group.add(r4_search);
		 group.add(r5_search);
		 group.add(r6_search);
		
		 p1_search.add(r1_search);
		 p1_search.add(r2_search);
		 p1_search.add(r3_search);
		 p1_search.add(r4_search);
		 p1_search.add(r5_search);
		 p1_search.add(r6_search);
		 p1_search.add(keyword_search);
		 p1_search.add(aButton_search);
		 add(p1_search);
		
	}
	
	
	public void setEvent()
	{
		aButton_search.addActionListener(this);
		aButton_search.setActionCommand("Search");
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();

		boolean flag=true;
		if(name=="Search")
		{
			Books aBook= new Books();
			//Title
			if(r1_search.isSelected())
			{
				int pos=-1;
				if(keyword_search.getText().equals(""))
					flag=false;
				else
				{
				aBook.setTitle(keyword_search.getText());
				pos=customer.searchBookByTitle(aBook);
				if(pos==-1)
				{
					GUIInterface.aText_p4.setText(Main.TITLE+"Sorry!! No book has been found");
				}
				else
					GUIInterface.aText_p4.setText(Main.TITLE+Main.array.getElement(pos).toString());
				}
			}
			//AuthorName
			else if(r2_search.isSelected())
			{
				int pos=-1;
				if(keyword_search.getText().equals(""))
					flag=false;
				else
				{
					String firstName="";
					String middleName="";
					String lastName="";
					
					String[] split =keyword_search.getText().split(" ");
					if(split.length==1)
					{
						firstName=split[0];
					}
					else if(split.length==2)
					{
						firstName=split[0];
						lastName=split[1];
					}
					else
					{
						firstName=split[0];
						middleName=split[1];
						lastName=split[2];
					}
					Name aName = new Name(firstName,middleName,lastName);
					aBook.setName(aName);
					pos=customer.searchBookByAuthorName(aBook);
					if(pos==-1)
					{
						GUIInterface.aText_p4.setText(Main.TITLE+"Sorry!! No book has been found");
					}
					else
						GUIInterface.aText_p4.setText(Main.TITLE+Main.array.getElement(pos).toString());
				}
			}
			
			//stock
			else if(r3_search.isSelected())
			{
				
				int pos=-1;
				if(keyword_search.getText().equals(""))
						flag=false;
				else
				{
					aBook.setStock(Integer.parseInt(keyword_search.getText()));
					pos=customer.searchBookByStock(aBook);
					if(pos==-1)
					{
						GUIInterface.aText_p4.setText(Main.TITLE+"Sorry!! No book has been found");
					}
					else
						GUIInterface.aText_p4.setText(Main.TITLE+Main.array.getElement(pos).toString());
				}
				
			}
			//publishedDate
			else if(r4_search.isSelected())
			{
				int pos=-1;
				if(keyword_search.getText().equals(""))
					flag=false;
				else
				{
					aBook.setPublishedDate(Integer.parseInt(keyword_search.getText()));
					pos=customer.searchBookByPublishedDate(aBook);
					if(pos==-1)
					{
						GUIInterface.aText_p4.setText(Main.TITLE+"Sorry!! No book has been found");
					}
					else
						GUIInterface.aText_p4.setText(Main.TITLE+Main.array.getElement(pos).toString());
				}
			}
			//Price
			else if(r5_search.isSelected())
			{
				int pos=-1;
				if(keyword_search.getText().equals(""))
					flag=false;
				else
				{
					aBook.setPrice(Double.parseDouble(keyword_search.getText()));
					pos=customer.searchBookByPrice(aBook);
					if(pos==-1)
					{
						GUIInterface.aText_p4.setText(Main.TITLE+"Sorry!! No book has been found");
					}
					else
						GUIInterface.aText_p4.setText(Main.TITLE+Main.array.getElement(pos).toString());
				}
			}
			//ISBN
			else if(r6_search.isSelected())
			{
				int pos=-1;
				if(keyword_search.getText().equals(""))
					flag=false;
				else
				{
					aBook.setISBN(keyword_search.getText());
					pos=customer.searchBookByISBN(aBook);
					if(pos==-1)
					{
						GUIInterface.aText_p4.setText(Main.TITLE+"Sorry!! No book has been found");
					}
					else
						GUIInterface.aText_p4.setText(Main.TITLE+Main.array.getElement(pos).toString());
				}
			}
			else 
				flag=false;
		}
		else 
			flag= false;
		if(keyword_search.getText().equals(""))
			flag=false;
		
		
		if(flag ==false)
		{
			JOptionPane.showMessageDialog(this,"The content should not be empty","Warning!",JOptionPane.ERROR_MESSAGE);
		}
	}


}
