package BookStore;
public class Name {
private String last;
private String first;
private String middle;
public Name()
{
	last="";
	first="";
	middle="";
}
public Name(String first1,String middle1,String last1)
{
	setLast(last1);
	setFirst(first1);
	setMiddle(middle1);
}
public void setLast(String last1)
{
	last = last1;
}
public void setFirst(String first1)
{
	first = first1;
}
public void setMiddle(String middle1)
{
	middle=middle1;
}
public String getLast()
{
	return last;
}
public String getFirst()
{
	return first;
}
public String getMiddle()
{
	return middle;
}
public String toString()
{
	return first+" "+middle+" "+last;
}
//compare method , last name is the prime compared key word
public int compareTo(Name aName) {
	if(first.compareTo(aName.getFirst())<0)
		return -1;
	else if(first.compareTo(aName.getFirst())==0)
		return 0;
	else
		return 1;
}
//equals method
public boolean equals(Name aName)
{
	if(last.equals(aName.getLast())&&first.equals(aName.getFirst())&&middle.equals(aName.getMiddle()))
		return true;
	else
		return false;
}
}
