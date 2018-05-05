package LinkStack;
public class LinkStack<T> implements IStack<T>
{
	private Node head;
	public LinkStack()
	{
		head=new Node();
	}

	@Override
	public boolean isEmpty() {
		Node p=head;
		if(p.getNext()==null) return true;
		return false;
	}
	@Override
	public int StackLength() {
		int length=0;
		Node p=head;
		while(p.getNext()!=null)
		{
			p=p.getNext();
			length++;
		}
		return length;
	}
	@Override
	public void StackPush(T x){
		Node p=head;
		Node q=new Node(x);
		while(p.getNext()!=null)
		{
			p=p.getNext();
		}
		p.setNext(q);	
	}

	@Override
	public Node StackPop() throws Exception {
		if(StackLength()==0) throw new Exception("Stack is empty!");
		Node p=head;
		while(p.getNext().getNext()!=null)
		{
			p=p.getNext();
		}
		Node temp=p.getNext();
		p.setNext(null);
		return temp;
	}

	@Override
	public Node StackTop() throws Exception {
		if(StackLength()==0) throw new Exception("Stack is empty!");
		Node p=head;
		while(p.getNext()!=null)
		{
			p=p.getNext();
		}
		return p;
	}

	@Override
	public void StackDisplay() {
		Node p=head;
		while(p.getNext()!=null)
		{
			p=p.getNext();
			System.out.print(p.getData()+"\t");
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
	public Node getNext()
	{
		return nextNode;
	}
	public void setData(T data)
	{
		this.data=data;
	}
	public void setNext(Node nextNode)
	{
		this.nextNode=nextNode;
	}
}
interface IStack<T>
{
	boolean isEmpty();
	int StackLength();
	void StackPush(T x);
	Node StackPop()throws Exception;
	Node StackTop()throws Exception;
	void StackDisplay();
}