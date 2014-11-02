package BookStore;

public class Books{
	//declare some attributions of the books
private String ISBN;
private String title;
private Name authorName;
private int stock;
private int publishedDate;
private double price;
//default constructor
public Books()
{
	ISBN="";
	title="";
	authorName= new Name();
	stock=0;
	publishedDate=0;
	price=0;
}
//non-default constructor
public Books(String aTitle,Name aName,int date,double bookPrice,String ISBNum,int stockNum)
{
	ISBN=ISBNum;
	title=aTitle;
	authorName= aName;
	stock=stockNum;
	publishedDate=date;
	price=bookPrice;
}
//mutator method
public void setISBN(String ISBNum)
{
	ISBN = ISBNum;
}
public void setTitle(String aTitle)
{
	title=aTitle;
}
public void setName(Name aName)
{
	authorName= aName;
}
public void setStock(int stockNum)
{
	stock=stockNum;
}
public void setPublishedDate(int date)
{
	publishedDate=date;
}
public void setPrice(double bookPrice)
{
	price=bookPrice;
}
//accessor methods
public String getISBN()
{
	return ISBN;
}
public String getTitle()
{
	return title;
}
public Name getName()
{
	return authorName;
}
public int getStock()
{
	return stock;
}
public int getPublishedDate()
{
	return publishedDate;
}
public double getPrice()
{
	return price;
}

//compareTo() methods 
public int compareToISBN(Books aBook)
{
	if(ISBN.compareTo(aBook.getISBN())<0)
		return -1;
	else if(ISBN.compareTo(aBook.getISBN())==0)
		return 0;
	else
		return 1;
}
public int compareToTitle(Books aBook)
{
	if(title.compareTo(aBook.getTitle())<0)
		return -1;
	else if(title.compareTo(aBook.getTitle())==0)
		return 0;
	else
		return 1;
}
public int compareToAuthorName(Books aBook)
{
	if(authorName.compareTo(aBook.getName())<0)
		return -1;
	else if(authorName.compareTo(aBook.getName())==0)
		return 0;
	else
		return 1;
}
public int compareToStock(Books aBook)
{
if(stock<aBook.getStock())
		return -1;
	else if(stock==aBook.getStock())
		return 0;
	else
		return 1;
}
public int compareToPublishedDate(Books aBook)
{
if(publishedDate<aBook.getPublishedDate())
		return -1;
	else if(publishedDate==aBook.getPublishedDate())
		return 0;
	else
		return 1;
}
public int compareToPrice(Books aBook)
{
if(price-aBook.getPrice()<-0.01)
		return -1;
	else if(Math.abs(price-aBook.getPrice())<0.01)
		return 0;
	else
		return 1;
}
public boolean equals(Books aBook)
{
	return equalsIBSN(aBook);
}
//equals methods
public boolean equalsIBSN(Books aBook)
{
	if(ISBN.equals(aBook.getISBN()))
		return true;
	else
		return false;
}
public boolean equalsTitle(Books aBook)
{
	if(title.equals(aBook.getTitle()))
		return true;
	else
		return false;
}
public boolean equalsAuthorName(Books aBook)
{
	if(authorName.equals(aBook.getName()))
		return true;
	else
		return false;
}
public boolean equalsStock(Books aBook)
{
if(stock==aBook.getStock())
		return true;
	else
		return false;
}
public boolean equalsPublishedDate(Books aBook)
{
if(publishedDate==aBook.getPublishedDate())
		return true;
	else
		return false;
}
public boolean equalsPrice(Books aBook)
{

	if(Math.abs(price-aBook.getPrice())<0.01)
		return true;
	else
		return false;
}
//to string method to show the result
public String toString()
{
	return "Title:\t"+getTitle()+"\nAuthor:\t"+getName().toString()+"\n"+getPublishedDate()/100+"/"+getPublishedDate()%100+"\t$"
+getPrice()+"\t"+getStock()+"\t"+getISBN()+"\n\n";
}
}
