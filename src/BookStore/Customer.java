package BookStore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Customer extends User{
	public Customer()
	{
		super();
	}
	public Customer(BookList<Books> aList)
	{
		super(aList);
	}
	
	//the specific method to transaction
public boolean transaction(Books aBook)
{
	try
	{
	int newStock;
	if(searchBookByISBN(aBook)!=-1)
	{
		String line;
		int pos;
		pos=searchBookByISBN(aBook);
		if(list.getElement(pos).getStock()==1)
			list.delete(pos);
		else 
		{
		newStock = list.getElement(pos).getStock()-1;
		list.getElement(pos).setStock(newStock);
		}	
		BufferedWriter outfile = new BufferedWriter (new FileWriter("book.txt"));
		for(int i =0; i<list.getIndex();i++)
		{
			line=list.getElement(i).getTitle()+","+list.getElement(i).getName().getFirst()+","+
					list.getElement(i).getName().getMiddle()+","+list.getElement(i).getName().getLast()+","+
					list.getElement(i).getPublishedDate()+","+list.getElement(i).getPrice()+","+
					list.getElement(i).getISBN()+","+list.getElement(i).getStock()+"\n";
			outfile.write(line);
		}
		outfile.close();
		return true;
	}
	else
	return false;
	}
	catch(IOException e)
	{
		System.out.println(e.getMessage());
		return false;
	}
}
//toString method to implement the abstract method in super class
public String toString()
		{
			return list.toString();
		}
}
