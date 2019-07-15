package ds.ds.singlylinkedlists;

import ds.ds.singlylinkedlists.SinglyLinkedlist;

public class App {

    public static void main(String[] args) {
        SinglyLinkedlist sl = new SinglyLinkedlist();
        //sl.insertFirst(10);
        sl.addNode(1);
        sl.addNode(2);
        sl.addNode(3);
        sl.addNode(4);
        //sl.addNode(4);
        sl.addNode(3);
        sl.addNode(2);
        sl.addNode(1);

                
        //System.out.println("length" + sl.listLength());
        //sl.displayList();
        //sl.deleteFirst();
        //System.out.println("length"+ sl.listLength());
        //sl.displayList();

        //System.out.println("----------------------");
        //sl.removeDuplicate();
        //sl.displayList();
           //int k = sl.findFromLast(sl.head, 3);
           //System.out.println(": "+ k);
    
           //sl.findFromLast2(2);
          // sl=sl.partition(6);
         // Node newHead= sl.reverseList();
         //SinglyLinkedlist rev= new SinglyLinkedlist();
         //rev.head=newHead;
         //rev.displayList();
          
          //System.out.println("List are equal : "+ SinglyLinkedlist.isequal(sl.head,rev.head));
         
           //System.out.println("List is palindrom equal : "+ sl.isPlaindromSlowFast());
    
        SinglyLinkedlist sl1 = new SinglyLinkedlist();
        //sl.insertFirst(10);
        sl1.addNode(1);
        sl1.addNode(2);
        sl1.addNode(3);
        sl1.addNode(4);
        
        
        SinglyLinkedlist sl2 = new SinglyLinkedlist();
        sl2.addNode(11);
        sl2.addNode(21);
        sl2.addNode(31);
        sl2.addNode(41);
        
        Node temp=sl1.head;
        while(temp.next!=null)
            temp=temp.next;
        
        Node n = new Node(101);
        temp.next=n;
        
        temp=sl2.head;
        while(temp.next!=null)
            temp=temp.next;
        
        temp.next=n;
        
         sl1.addNode(101);
         sl1.addNode(102);
         sl1.addNode(103); 
          sl1.addNode(104);
        sl1.displayList();
        System.out.println("----------------------");
        sl2.displayList();
        
        Node m = SinglyLinkedlist.checkIntersection(sl1.head, sl2.head);
        System.out.println("Intersection at : "+ m.data + " ref : "+ m);
    }
}
