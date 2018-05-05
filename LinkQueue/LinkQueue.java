package LinkQueue;
public class LinkQueue<T> implements IQueue<T>
{
	private Node front;
	private Node rear;
	public LinkQueue()
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
		int length=0;
		Node p=front;
		while(p!=null)
		{
			p=p.getNext();
			length++;
		}
		return length;
	}
	@Override
	public void QueueAppend(T x){
		Node p=new Node(x);
		if(front==null)
		{
			front=p;
			rear=front;
		}
		else
		{
			rear.setNext(p);
			rear=p;
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
	private Node nextNode=null;
	public Node()
	{
		
	}
	public Node(T data)
	{
		this.data=data;
	}
	public Node(T data,Node nextNode)
	{
		this.data=data;
		this.nextNode=nextNode;
	}
	public T getData()
	{
		return data;
	}
	public void setData(T data)
	{
		this.data=data;
	}
	public Node getNext()
	{
		return nextNode;
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
	void QueueAppend(T x );
	Node QueueDelete()throws Exception;
	Node QueueGet()throws Exception;
	void QueueDisplay();
}