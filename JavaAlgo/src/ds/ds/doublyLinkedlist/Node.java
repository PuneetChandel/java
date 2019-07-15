package ds.ds.doublyLinkedlist;

public class Node {
	int data;
	Node next;
	Node previous;
	
	public Node(int data) {
		this.data=data;
		next=null;
		previous=null;
	}
	
	public void displayNode()
	{
		System.out.println("{ " + data + " }");
	}
}
