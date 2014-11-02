package BookStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Administrator extends User{
	public Administrator()
	{
		super();
	}
	public Administrator(BookList<Books> aList)
	{	
			super(aList);
	}
	/*
	public int deleteBook(Books aBook)
	{
		int num=0;
		int pos;
		int pos_ISBN;
		int pos_AuthorName;
		int pos_Title;
		int pos_Price;
		int pos_Stock;
		int pos_PublishedDate;
		do{
			pos=-1;
				pos_ISBN=searchBookByISBN(aBook);
				pos_AuthorName=searchBookByAuthorName(aBook);
				pos_Title=searchBookByTitle(aBook);
				pos_Price=searchBookByPrice(aBook);
				pos_Stock=searchBookByStock(aBook);
				pos_PublishedDate=searchBookByPublishedDate(aBook);		
				if(pos_ISBN!=-1)
				{
					pos=pos_ISBN;
				}
				if(pos_AuthorName!=-1)
				{
					pos=pos_AuthorName;
				}
				else if(pos_Title!=-1)
				{
					pos=pos_Title;
				}
				else if(pos_Price!=-1)
				{
					pos=pos_Price;
				}
				else if(pos_Stock!=-1)
				{
					pos=pos_Stock;
				}
				else if(pos_PublishedDate!=-1)
				{
					pos=pos_PublishedDate;
				}
				else
					pos = -1;
				if(pos!=-1)
				{
					list.delete(pos);
					num++;
				}
		}while(pos!=-1);
		return num;
	}
	*/
	public boolean addBook(Books aBook)
	{
		try
		{
			FileWriter outfile = new FileWriter(new File("book.txt"), true);
			String line=aBook.getTitle()+","+aBook.getName().getFirst()+","+
					aBook.getName().getMiddle()+","+aBook.getName().getLast()+","+
					aBook.getPublishedDate()+","+aBook.getPrice()+","+
					aBook.getISBN()+","+aBook.getStock()+"\n";
			outfile.write(line);
		 outfile.close();
		 list.add(aBook);
		 return true;
		}
		catch(IOException e )
		{

			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean deleteBook(String ISBN)
	{
		try{
		int pos=-1;
		Books aBook = new Books();
		aBook.setISBN(ISBN);
		pos=searchBookByISBN(aBook);
		if(pos!=-1)
		{
			list.delete(pos);
			String line;
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
		catch(IOException e )
		{
			System.out.println(e.getMessage());
			return false;
		}
			
	}
	
public String toString()
{
	return list.toString();
}
}
