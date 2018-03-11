package ds.singlylinkedlists;

public class SinglyLinkedlist {

	private Node head=null;
	
	
	public void addNode(int data)
	{
		if (head==null)
					head=new Node(data);
		
		else
		{
			Node currNode=head;
			while(currNode.next !=null)
				currNode=currNode.next;
			
			currNode.next= new Node(data);
		}
	}
	
	
	public void addFirst(int data)
	{
		Node newNode = new Node(data);
		newNode.next=head;
		head=newNode;
	}

	public void addLast(int data)
	{
		Node last = head;
		
		while(last.next !=null)
			last= last.next;
		
		last.next=new Node(data);
		
		
		
	}
	
	public Node deleteFirst()
	{
		Node temp = head;
		head = head.next;
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
