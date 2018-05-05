package SeqStack;
public class SeqStack<T> implements IStack<T>
{
	private T []data;
	private int length;
	public SeqStack(int MaxSize)
	{
		data=(T[])new Object[MaxSize];
		length=0;
	}
	@Override
	public boolean isEmpty() {
		if(length==0) return true;
		return false;
	}
	@Override
	public void StackPush(T x) throws Exception{
		if(length>=data.length) throw new Exception("Stack is full!");
		data[length++]=x;
	}
	@Override
	public T StackPop() throws Exception{
		if(length<0) throw new Exception("Stack is empty!");
		length--;
		return data[length];
	}
	@Override
	public T StackTop() throws Exception{
		if(length<0) throw new Exception("Stack is empty");
		return data[length-1];
	}
	@Override
	public void StackDisplay() {
		for(int i=0;i<length;i++)
		{
			System.out.print(data[i]+"\t");
		}
		System.out.println();
	}
}
interface IStack<T>
{
	boolean isEmpty();
	void StackPush(T x)throws Exception;
	T StackPop()throws Exception;
	T StackTop()throws Exception;
	void StackDisplay();
}