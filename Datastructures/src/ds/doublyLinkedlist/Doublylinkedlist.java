package ds.doublyLinkedlist;

public class Doublylinkedlist {
	Node first;
	Node last;
	
	public Doublylinkedlist() {
		first=null;
		last=null;
	}
	
	
	public Node deleteFirst()
	{
		Node temp =first;

		if (isEmpty())
		{
			System.out.println(" List is empty");
			return null;
		}	
		
		if (first.next !=null)
		      first.next.previous=null;
		else
			last=null;
		first=temp.next;  
		return temp;
	}
	
	
	public Node deleteLast()
	{
		
		if (isEmpty())
		{
			System.out.println("List is empty");
			return null;
		}
	
		Node temp=last;
		
		if (last.previous!=null)
			last.previous.next=null;
		else
			first=null;
		last=temp.previous;
		
		return temp;
		
	}
	
	
	public void addFirst(int data)
	{
		
		Node newNode= new Node(data);
		
		if (isEmpty())
		{
			last=newNode;
		}	
		else
		{  // Need to link previous first and make the new node as first
		   newNode.next=first;
		   first.previous=newNode;
		}
		
		first=newNode; // common for both
		
	}
	
	
	public void insertAfter(int key, int data)
	{
		Node n= first;
		int flag=0;
		while(n != null)
		{
			if(n.data==key)
			{
			flag=1;
			break;
			}
			else
			n=n.next;
		}
		
		if (flag==1)
		{	
		Node newNode= new Node(data);
		if(n!=last)
		{
		newNode.next=n.next;
		newNode.previous=n;
		n.next.previous=newNode;
		n.next=newNode;
		}
		else
		{
			newNode.previous=n;
			n.next=newNode;
			last=newNode;
		}
		}
		else
		{
			System.out.println("Data value not found in list");
		}
	}
	
	
	public void deleteKey(int key)
	{
		Node n= first;
		int flag=0;
		while(n != null)
		{
			if(n.data==key)
			{
			flag=1;
			break;
			}
			else
			n=n.next;
		}
		
		if (flag==1)
		{
			if (n==first && n==last)
			{
				first=null;
				last=null;
			}
			else if(n==first && n!=last)
			{
				first=n.next;
				n.next.previous=null;
			}
			else if(n!=first && n==last)
			{
				last=n.previous;
				n.previous.next=null;
			}
			else
			{
				n.previous.next=n.next;
				n.next.previous=n.previous;
			}
		}
		
	}
	
	

	
	
	public void addLast(int data)
	{
		Node newNode= new Node(data);
		
		if (isEmpty())
		{
			first=newNode;
		}
		else
		{  // Need to link previous last and make the new node as last
		    last.next=newNode;
		    newNode.previous=last; 
		}
		last=newNode;// valid for both
	}
	
	
	public boolean isEmpty()
	{
		return(first==null);
	}
	
	public int listLength()
	{
		int count=0;
		Node n = first;
		
		while(n!=null)
		{
			count++;
			n=n.next;
		}
		return count;
	}
	
	public void displayList()
	{
		Node n =first;
		while(n!=null)
		{
			n.displayNode();
			n=n.next;
		}
	}
	
	public void displayListReverse()
	{
		Node n =last;
		while(n!=null)
		{
			n.displayNode();
			n=n.previous;
		}
	}
	
		
}
