package SeqCQueue;
public class SeqCQueue<T> implements IQueue<T>
{
	private T []data;
	private int front;
	private int rear;
	private int count;
	public SeqCQueue(int MaxSize)
	{
		data=(T[])new Object[MaxSize];
		front=0;
		rear=0;
		count=0;
	}
	@Override
	public boolean isEmpty()
	{
		if(count==0) return true;
		return false;
	}
	@Override
	public void QueueAppend(T x) throws Exception {
		if(count==data.length) throw new Exception("Queue is full!");
		data[rear]=x;
		rear=(rear+1)%data.length;
		count++;
	}
	@Override
	public T QueueDelete() throws Exception{
		if(count==0) throw new Exception("Queue is empty!");
		T temp=data[front];
		front=(front+1)%data.length;
		count--;
		return temp;
	}
	@Override
	public T QueueGet() throws Exception{
		if(count==0) throw new Exception("Queue is empty!");
		return data[front];
	}
	@Override
	public void QueueDisplay()
	{
		for(int i=front;i!=rear;i=(i+1)%data.length)
		{
			System.out.print(data[i]+"\t");
		}
		System.out.println();
	}
}
interface IQueue<T>
{
	boolean isEmpty();
	void QueueAppend(T x )throws Exception;
	T QueueDelete()throws Exception;
	T QueueGet()throws Exception;
	void QueueDisplay();
}
