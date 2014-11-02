package BookStore;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static BookList<Books> array;
	static final String TITLE = "\t\tWelcome to Our BookStore!!!\n\t\t                  Booklist\n\t          Authors:          Yang-yang Xie           Xiao-ang Zhang\n*************************************************"
			+ "*************************************************************\nPublishedDate\tPrice\tStock\tISBNNum\n**"
			+ "**************************************************************************************************"
			+ "**********\n";
	public static void readDataFromDoc()
	{
		try
		{
			//instantiate the file and some necessary variables
			Scanner file = new Scanner(new FileReader("book.txt"));	
			String line="";
			//instantiate the generic list
			
		//read the elements from the file
			while(file.hasNext())
			{
				line=file.nextLine();
				String[] split=line.split(",");
				//instantiate the name
				Name aName= new Name(split[1],split[2],split[3]);
				Books aBook = new Books(split[0],aName,Integer.parseInt(split[4]),Double.parseDouble(split[5]),split[6],Integer.parseInt(split[7]));
				array.add(aBook);
				
			}
			file.close();
		}
		catch(IOException e )
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	public static void display()
	{
		
		GUIInterface.aText_p4.setText(TITLE+array.toString());
	}
	public static void main(String [] args)
	{
		GUIInterface aFrame = new GUIInterface();
		aFrame.setVisible(true);
		array= new BookList<Books>(50);
		readDataFromDoc();
		 display();
	}
	
	
}
