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

public class Delete_GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField keyword_delete;
	private JButton aButton_delete;
	Administrator admin=new Administrator(Main.array);
	
	public Delete_GUI()
	{
		 setTitle("Delete Book");
		 setSize(400,110);
		 setLayout(null);
		 setLocation(300,200);
		 setResizable(false);
		 
		 JPanel p1_delete = new JPanel();
		 p1_delete.setBounds(10,10,380,60);
		 p1_delete.setLayout(new FlowLayout(FlowLayout.LEFT));
		 p1_delete.setBorder(BorderFactory.createTitledBorder("Delete by ISBN Number:"));
		 keyword_delete = new JTextField(25);
		 aButton_delete= new JButton("Delete");
		 setEvent();
		 p1_delete.add(keyword_delete);
		 p1_delete.add(aButton_delete);
		 add(p1_delete);
	}
	public void setEvent()
	{
		aButton_delete.addActionListener(this);
		aButton_delete.setActionCommand("Delete");
	}
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		if(name.equals("Delete"))
		{
			if(admin.deleteBook(keyword_delete.getText()))
			{
				JOptionPane.showMessageDialog(this,"Successful Deleted !!");
			}
			else
				JOptionPane.showMessageDialog(this,"Failure Deleted","ERROR!",JOptionPane.ERROR_MESSAGE);
			Main.display();
		}
	}
}
