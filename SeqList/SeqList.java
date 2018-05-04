package SeqList;
public class SeqList<T> implements List<T>
{

	private T []data;
	private int length;
	public SeqList(int ListMaxSize)
	{
		data=(T[])new Object[ListMaxSize];
		length=0;
	}
	@Override
	public int ListLength()       
	{
		return length;
	}
	@Override
	public boolean isEmpty()
	{
		if(length==0) return true;
		else return false;
	}
	@Override
	public boolean ListInsert(int i,T x) throws Exception
	{
		if(i<0||i>length) throw new Exception("i is illegal!");
		else if(length==data.length) throw new Exception("SeqList is full!");
		else 
		{
			for(int j=length;j>i;j--)
			{
				data[j]=data[j-1];
			}
			data[i]=x;
			length++;
			return true;
		}
	}
	@Override
	public T ListDelete(int i) throws Exception
	{
		if(i<0||i>length-1) throw new Exception("i is illegal!");
		else if(length==0) throw new Exception("SeqList is empty!");
		else
		{
			T temp=data[i];
			for(int j=i;j<length-1;j++)
			{
				data[j]=data[j+1];
			}
			length--;
			return temp;
		}
	}
	@Override
	public T ListGet(int i) throws Exception
	{
		if(i<0||i>length-1) throw new Exception("i is illegal!");
		return data[i];
	}
	@Override
	public void Listdisplay()
	{
		for (int i=0;i<length;i++)
			System.out.print(data[i]+"\t");
		System.out.println("\n");
	}
}
interface List<T>
{
	int ListLength();
	boolean isEmpty();
	boolean ListInsert(int i,T x) throws Exception;
	T ListDelete(int i) throws Exception;
	T ListGet(int i) throws Exception;
	void Listdisplay();
}
