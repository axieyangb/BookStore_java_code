package BookStore;
public abstract class User {
	protected BookList<Books> list;
public User()
{
	list =new BookList<Books> ();
}
public User(BookList<Books> aList)
{
	list =aList;
}

//sort the data by ISBN
public void sortBookByISBN()
{
	Books temp;
	boolean flag=false;
	int index=0;
	for(int i=0;i<list.getIndex()-1;i++)
	{
		flag=false;
		index=i;
		temp=list.getElement(i);
		for(int j=i+1;j<list.getIndex();j++)
		{
			if(temp.compareToISBN(list.getElement(j))>0)
			{	
			temp=list.getElement(j);
			index=j;
			flag=true;
			}
		}
		if(flag)
		{
			list.setElement(list.getElement(i),index);
			list.setElement(temp, i);
		}
		
	}
}

public void sortBookByAuthorName()
{
	Books temp;
	boolean flag=false;
	int index=0;
	for(int i=0;i<list.getIndex()-1;i++)
	{
		flag=false;
		index=i;
		temp=list.getElement(i);
		for(int j=i+1;j<list.getIndex();j++)
		{
			if(temp.compareToAuthorName(list.getElement(j))>0)
			{	
			temp=list.getElement(j);
			index=j;
			flag=true;
			}
		}
		if(flag)
		{
			list.setElement(list.getElement(i),index);
			list.setElement(temp, i);
		}
		
	}
}
public void sortBookByTitle()
{
	Books temp;
	boolean flag=false;
	int index=0;
	for(int i=0;i<list.getIndex()-1;i++)
	{
		flag=false;
		index=i;
		temp=list.getElement(i);
		for(int j=i+1;j<list.getIndex();j++)
		{
			if(temp.compareToTitle(list.getElement(j))>0)
			{	
			temp=list.getElement(j);
			index=j;
			flag=true;
			}
		}
		if(flag)
		{
			list.setElement(list.getElement(i),index);
			list.setElement(temp, i);
		}
		
	}
}
public void sortBookByPrice()
{
	Books temp;
	boolean flag=false;
	int index=0;
	for(int i=0;i<list.getIndex()-1;i++)
	{
		flag=false;
		index=i;
		temp=list.getElement(i);
		for(int j=i+1;j<list.getIndex();j++)
		{
			if(temp.compareToPrice(list.getElement(j))>0)
			{	
			temp=list.getElement(j);
			index=j;
			flag=true;
			}
		}
		if(flag)
		{
			list.setElement(list.getElement(i),index);
			list.setElement(temp, i);
		}
		
	}
}
public void sortBookByStock()
{
	Books temp;
	boolean flag=false;
	int index=0;
	for(int i=0;i<list.getIndex()-1;i++)
	{
		flag=false;
		index=i;
		temp=list.getElement(i);
		for(int j=i+1;j<list.getIndex();j++)
		{
			if(temp.compareToStock(list.getElement(j))>0)
			{	
			temp=list.getElement(j);
			index=j;
			flag=true;
			}
		}
		if(flag)
		{
			list.setElement(list.getElement(i),index);
			list.setElement(temp, i);
		}
		
	}
}
public void sortBookByPublishedDate()
{
	Books temp;
	boolean flag=false;
	int index=0;
	for(int i=0;i<list.getIndex()-1;i++)
	{
		flag=false;
		index=i;
		temp=list.getElement(i);
		for(int j=i+1;j<list.getIndex();j++)
		{
			if(temp.compareToPublishedDate(list.getElement(j))>0)
			{	
			temp=list.getElement(j);
			index=j;
			flag=true;
			}
		}
		if(flag)
		{
			list.setElement(list.getElement(i),index);
			list.setElement(temp, i);
		}
		
	}
}
public int searchBookByISBN(Books target)
{
	sortBookByISBN();
	int i=0;
	int j=list.getIndex()-1;
	while(i<=j)
	{
		
		if(list.getElement((i+j)/2).compareToISBN(target)==0)      //if it exactly was the middle element
			return (i+j)/2;
		else if(list.getElement((i+j)/2).compareToISBN(target)<0)
			i=(i+j)/2+1;
		else
			j=(i+j)/2-1;	
	}
	return -1;
}
public int searchBookByAuthorName(Books target)
{
	sortBookByAuthorName();
	int i=0;
	int j=list.getIndex()-1;
	while(i<=j)
	{
		
		if(list.getElement((i+j)/2).compareToAuthorName(target)==0)      //if it exactly was the middle element
			return (i+j)/2;
		else if(list.getElement((i+j)/2).compareToAuthorName(target)<0)
			i=(i+j)/2+1;
		else
			j=(i+j)/2-1;	
	}
	return -1;
}
public int searchBookByTitle(Books target)
{
	sortBookByTitle();
	int i=0;
	int j=list.getIndex()-1;
	while(i<=j)
	{
		
		if(list.getElement((i+j)/2).compareToTitle(target)==0)      //if it exactly was the middle element
			return (i+j)/2;
		else if(list.getElement((i+j)/2).compareToTitle(target)<0)
			i=(i+j)/2+1;
		else
			j=(i+j)/2-1;	
	}
	return -1;
}
public int searchBookByPrice(Books target)
{
	sortBookByPrice();
	int i=0;
	int j=list.getIndex()-1;
	while(i<=j)
	{
		
		if(list.getElement((i+j)/2).compareToPrice(target)==0)      //if it exactly was the middle element
			return (i+j)/2;
		else if(list.getElement((i+j)/2).compareToPrice(target)<0)
			i=(i+j)/2+1;
		else
			j=(i+j)/2-1;	
	}
	return -1;
}
public int searchBookByStock(Books target)
{
	sortBookByStock();
	int i=0;
	int j=list.getIndex()-1;
	while(i<=j)
	{
		
		if(list.getElement((i+j)/2).compareToStock(target)==0)      //if it exactly was the middle element
			return (i+j)/2;
		else if(list.getElement((i+j)/2).compareToStock(target)<0)
			i=(i+j)/2+1;
		else
			j=(i+j)/2-1;	
	}
	return -1;
}
public int searchBookByPublishedDate(Books target)
{
	sortBookByPublishedDate();
	int i=0;
	int j=list.getIndex()-1;
	while(i<=j)
	{
		
		if(list.getElement((i+j)/2).compareToPublishedDate(target)==0)      //if it exactly was the middle element
			return (i+j)/2;
		else if(list.getElement((i+j)/2).compareToPublishedDate(target)<0)
			i=(i+j)/2+1;
		else
			j=(i+j)/2-1;	
	}
	return -1;
}
public abstract String toString();
public BookList<Books> getList()
{
	return list;
}

}
