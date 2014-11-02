package BookStore;
/*
 *  My name is Yangyang xie
 * My student ID is A20305798
 * cs201
 * 11102013;
 * 
 * This the program of lab 10;
 */
//this is the object of an array
public class BookList<T> {
	final int Max_SIZE=100;
	//GenericList_yyx<Employee>
	private int index;//next empty slot
	private int pointer=0;
	private T[] objArray;
	@SuppressWarnings("unchecked")
	public BookList()//default constructor
	{
		objArray = (T[]) new Object[Max_SIZE];
		index = 0;
		pointer = 0;
	}
	@SuppressWarnings("unchecked")
	public BookList(int size) //non-default constructor
	{
	objArray = (T[]) new Object[size];
		index = 0;
		pointer =0;
	}
	public int getLength()
	//returns the length of the array
	{
		return objArray.length;
	}
	public T[] getArray()
	//return a copy of the array
	{
		T[] objArray1 = objArray;
		return objArray1;
	}
	public void setArray(T[] anArray)
	//assign anArray to this array
	{
		for(int i=0;i<objArray.length;i++)
		objArray[i]=anArray[i];
	}
	
	public int getIndex()
	//returns the index
	{
		return index;
	}
	public int getPointer()
	//return the pointer
	{
		return pointer;
	}
	public void setIndex(int anIndex)
	//assigns a new value to the index
	{
		index = anIndex;
	}
	public T getElement(int pos)
	//returns the element of the array at pos
	{
		return objArray[pos];
	}
	public void setElement(T anObj, int pos)
	//assigns an object to array at pos
	{
		objArray[pos]=anObj;
	}
	public boolean deleteObj(T dele)
	//delete the object in the array
	{
		int flag = isThere(dele);
		if(flag==-1)
			return false;
		else		
		{
			for(int i=flag;i<=index-2;i++)
			{
				objArray[i]=objArray[i+1];
			}
			objArray[index-1]=null;
			index--;
			return true;
		}
	}
	public String toString()
	//iterates through the array and concatenates each element’s toString() into a string that is returned	
	{
		String feedback="";
		for(int i = 0; i<index;i++)
			feedback+=objArray[i].toString();
		return 
			feedback;
	}
	//store an element in the array
	public void add(T anObj)
	// stores aStr in the  next empty slot in the array & increments the next empty slot variable
	{
		objArray[index]=anObj;
		index++;
	}
	public void resetPointer()//reset the pointer
	{
		pointer = 0;
	}

	public void delete(int pos)//delete the elements in array
	{
		for(int i=pos;i<=index-2;i++)
		{
			objArray[i]=objArray[i+1];
		}
		objArray[index-1]=null;
		index--;
		
	}
	public int isThere(T target)//judge whether the object is actually in the array
	{
		for(int i =0; i<index;i++ )
		{
			if(objArray[i].equals(target))
				return i;
		}
		return -1;
	}
	public boolean isFull()  //judge whether the array is full
	{
		if(index == objArray.length)
			return true;
		else
			return false;
	}
	public boolean isEmpty()//judge whether the array is empty
	{
		if(index == 0)
			return true;
		else
			return false;
	}
	public void clear()//clear all the data in the array
	{
		for(int i =0; i<objArray.length;i++)
		{
			objArray[i]=null;
		}
		index=0;
	}
	public T getNext()//get the next element
	{
		if(pointer <index)
		return objArray[pointer++];
		else
			return null;
	}
	public boolean hasNext()//whether has the value in next slot
	{
		if(objArray[pointer]==null&&pointer == index-1)
			return false;
		else 
			return true;
	}
	public void trim()////remove excess capacity so that capacity matches size
	{
		@SuppressWarnings("unchecked")
		T[] trim = (T[])new Object[index];
		for(int i =0;i<index; i++)
			trim[i] = objArray[i];
		objArray =trim;
	}
	public boolean insert(int pos , T ins)
	{
		if(pos>=index||isFull())
			return false;
		else
		{
			for(int i = index; i>pos;i--)
			{
				objArray[i]=objArray[i-1];
			}
		objArray[pos]=ins;
		index++;
		return true;
		}
	}
	public void moreCapcity()//allocate more memory by instantiating a new larger array and copying all data to it then assigning new array to old array
	{
		int capcity = objArray.length+10;
		if(isFull())
		{
			@SuppressWarnings("unchecked")
			T[] more = (T[]) new Object[capcity];
			for(int i =0;i<index; i++)
				more[i] = objArray[i];
			objArray=more;
		}
	}
	
	

}
