package PriorityQueue;
public class PriorityQueue<T> implements IQueue<T>
{
	private Node front;
	private Node rear;
	public PriorityQueue()
	{
		front=null;
		rear=null;
	}
	@Override
	public boolean isEmpty() {
		if(front==null) return true;
		return false;
	}
	@Override
	public int QueueLength() {
		Node p=front;
		int length=0;
		while(p!=null)
		{
			p=p.getNext();
			length++;
		}
		return length;
	}
	@Override
	public void QueueAppend(T x,int Xpriority) {
		Node p=new Node(x,Xpriority);
		if(front==null){
			front=p;
			rear=p;
		}
		else {
			Node a=front;
			Node b=front;
			while(b!=null)
			{
				if(Xpriority<=b.getPriority()) break;
				a=b;
				b=b.getNext();
			}
			if(b==null)
			{
				rear.setNext(p);
				rear=p;
			}
			else if(b==front)
			{
				p.setNext(front);
				front=p;
			}
			else
			{
				p.setNext(b);
				a.setNext(p);
			}
		}
	}
	@Override
	public Node QueueDelete() throws Exception {
		if(front==null) throw new Exception("Queue is empty!");
		Node temp=front;
		front=front.getNext();
		return temp;
	}
	@Override
	public Node QueueGet() throws Exception {
		if(front==null) throw new Exception("Queue is empty!");
		return front;
	}
	@Override
	public void QueueDisplay() {
		Node p=front;
		while(p!=null)
		{
			System.out.print(p.getData()+"\t");
			p=p.getNext();
		}
		System.out.println();
	}
	
}
class Node<T>
{
	private T data;
	private int priority;
	private Node nextNode=null;
	public Node()
	{
		
	}
	public Node(T data)
	{
		this.data=data;
	}
	public Node(T data,int priority)
	{
		this.data=data;
		this.priority=priority;
	}
	public Node(T data,int priority,Node nextNode)
	{
		this(data,priority);
		this.nextNode=nextNode;
	}
	public T getData()
	{
		return data;
	}
	public int getPriority()
	{
		return priority;
	}
	public Node getNext()
	{
		return nextNode;
	}
	public void setData(T data)
	{
		this.data=data;
	}
	public void setPriority(int priority)
	{
		this.priority=priority;
	}
	public void setNext(Node nextNode)
	{
		this.nextNode=nextNode;
	}
}
interface IQueue<T>
{
	boolean isEmpty();
	int QueueLength();
	void QueueAppend(T x,int Xpriority);
	Node QueueDelete()throws Exception;
	Node QueueGet()throws Exception;
	void QueueDisplay();
}
