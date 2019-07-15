package LL;

/**
 *
 * @author pune7087
 */
public class TestLL {
    public static void main(String args[])
    {
        Node first= new Node(2);
        Node second = new Node(8);
        Node third = new Node(5);
        first.next=second;
        second.next=third;

        Node first1= new Node(5);
        Node second1 = new Node(6);
        Node third1 = new Node(4);
        first1.next=second1;
        second1.next=third1;

        // Add 2 LL
        //Node n= LinkList.addLinkListNumbers(first, first1);
        //LinkList.display(n);
        
        //Reverse
        //Node n = LinkList.reverse(first);
        //LinkList.display(n);
       
        Node first2= new Node(1);
        Node second2 = new Node(2);
        Node third2 = new Node(3);
        Node fourth2 = new Node(4);
        Node fifth2 = new Node(5);
        Node sixth2 = new Node(6);
        
        first2.next=second2;
        second2.next=third2;
        third2.next=fourth2;
        fourth2.next=fifth2;
        fifth2.next=sixth2;
       
        //Node head=LinkList.removeDupSortedList2(first2);
        
        //Node head=LinkList.partitionListLeet(first2,3);
        
        //Node head=
                
        LinkList.reverseBetween(first2,2,5);
        
        //LinkList.deleteFromEnd(first2,6);
                
        LinkList.display(first2);
        
        
    }
    
       public static Node reverseList(Node root)
    {
        
        if(root==null || root.next==null)
            return root;
        
        Node prev=root;
        Node curr= root;
        
        while(curr.next!=null)
        {
            curr=curr.next;
            curr.next=prev;
            prev=prev.next;
        }
        
        return root;
    }
    
}
