package ds.singlylinkedlists;

import ds.singlylinkedlists.SinglyLinkedlist;

public class App {

	 public static void main(String[] args) {
		SinglyLinkedlist sl= new SinglyLinkedlist();
		//sl.insertFirst(10);
		sl.addNode(20);
		sl.addNode(30);
		sl.addNode(40);
		sl.addFirst(1);
		System.out.println("length"+ sl.listLength());
		sl.displayList();
		sl.deleteFirst();
		System.out.println("length"+ sl.listLength());
		sl.addLast(100);
		sl.displayList();
		
		System.out.println("----------------------");
		
		
		
	}
}
