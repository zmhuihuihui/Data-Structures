package LinkList;
public class LinkList<T> implements List<T>
{
	private Node head;
	public LinkList()
	{
		head=new Node();
	}
	@Override
	public int ListLength() {
		int length=0;
		Node p=head.getNext();
		while(p!=null)
		{
			p=p.getNext();
			length++;
		}
		return length;
	}
	@Override
	public boolean isEmpty() {
		if(head.getNext()==null) return true;
		return false;
	}
	@Override
	public boolean ListInsert(int i,T x) throws Exception {
		int count=0;
		Node p=head;
		Node q=new Node(x);
		if(i<0||i> ListLength()+1) throw new Exception("i is illegal!");
		while(count!=i-1)
		{
			p=p.getNext();
			count++;
		}
		q.setNext(p.getNext());
		p.setNext(q);
		return true;
	}
	@Override
	public Node ListDelete(int i) throws Exception {
		int count=0;
		Node p=head;
		Node temp;
		if(i<0||i> ListLength()) throw new Exception("i is illegal!");
		while(count!=i-1)
		{
			p=p.getNext();
			count++;
		}
		temp=p.getNext();
		p.setNext(p.getNext().getNext());
		return temp;
	}
	@Override
	public Node ListGet(int i) throws Exception {
		int count=0;
		Node p=head;
		if(i<0||i> ListLength()) throw new Exception("i is illegal!");
		while(count!=i)
		{
			p=p.getNext();
			count++;
		}
		return p;
	}
	@Override
	public void ListDisplay() {
		int count=0;
		Node p=head;
		while(count!= ListLength())
		{
			p=p.getNext();
			count++;
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
interface List<T>
{
	int ListLength();
	boolean isEmpty();
	boolean ListInsert(int i,T x) throws Exception;
	Node ListDelete(int i) throws Exception;
	Node ListGet(int i) throws Exception;
	void ListDisplay();
}
