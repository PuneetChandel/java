package ds.doublyLinkedlist;

public class App {

	public static void main(String[] args) {
		Doublylinkedlist dl= new Doublylinkedlist();
		
		dl.addFirst(80);
		dl.addFirst(50);
		dl.addLast(100);
		dl.addFirst(40);
		dl.addLast(110);
		dl.addLast(120);
		
		System.out.println("Length " + dl.listLength());
		
	
		dl.insertAfter(120,125);
		
		dl.insertAfter(100,105);
		
		dl.insertAfter(105,115);
		
		dl.displayList();
		
		//System.out.println("Reeverse");
		//dl.displayListReverse();
			dl.deleteKey(1);
		System.out.println("after deleting");
		dl.displayList();
		
	}
}
