package ds.ds.singlylinkedlists;

public class Node {

		public int data;
		public Node next;
		
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
		
		public void displayNode(){
			System.out.println("{" + data + "}");
		}
}
