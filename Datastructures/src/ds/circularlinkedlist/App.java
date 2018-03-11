package ds.circularlinkedlist;

public class App {

	 public static void main(String[] args) {
			
		CircularLinkedlist sl2= new CircularLinkedlist();
		sl2.addNode(1);
		sl2.addNode(2);
		sl2.addNode(3);
		sl2.addLast(100);
		sl2.addFirst(0);
		sl2.addFirst(99999);
		sl2.addLast(89898);
		
		sl2.displayList();
		
		
	}
}
