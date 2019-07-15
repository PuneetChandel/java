package ds.ds.circularlinkedlist;

import ds.ds.singlylinkedlists.Node;


public class CircularLinkedlist {

	private Node head;
	private Node last;
	
	public CircularLinkedlist()
	{
		head=null;
		last=null;
	}
	
	public void addNode(int data)
	{
		if (head==null)
		{
					head=new Node(data);
					last=head;
		}
		else
		{
			Node newnode=new Node(data);
			last.next=newnode;
			last=newnode;
		}
	}
	
	
	public void addFirst(int data)
	{
		Node newNode = new Node(data);
		newNode.next=head;
		head=newNode;
		if(isEmpty())
		{
			last=head;
		}
	}

	public void addLast(int data)
	{
		Node newnode=new Node(data);
		last.next=newnode;
		last=newnode;
		if(isEmpty())
		{
			head=last;
		}
		
	}
	
	public Node deleteFirst()
	{
		Node temp = head;
		head = head.next;
		if(head ==null)
			last=null;
		return temp;
	}
	
	public void displayList()
	{
		Node n = head;
		while(n !=null)
		{
			n.displayNode();
			n = n.next;
			
		}
		
	}
	public int listLength()
	{
		int cnt=0;
		Node n = head;
		while(n !=null)
		{
			cnt++;
			n=n.next;
		}
		
		return cnt;
	}
	
	public boolean isEmpty()
	{
		return (head==null);
	}
	
}
