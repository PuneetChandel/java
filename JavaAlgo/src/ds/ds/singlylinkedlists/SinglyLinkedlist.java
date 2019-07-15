package ds.ds.singlylinkedlists;
import java.util.HashMap;
import java.util.Stack;


public class SinglyLinkedlist {

	protected Node head=null;
	
	
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
	
        public boolean deleteNode(int data)
        {
            Node temp= head;
            if(head.data == data)
            {
                head=head.next;
                return true;
            }   
            while(temp.next!=null)
            {
                if(temp.next.data == data)
                {
                    temp.next= temp.next.next;
                    return true;
                }
                temp=temp.next;
            }
            return false;
            
        }

        public void removeDuplicateMap()
        {
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            Node temp=head;
            Node prev=head;
            while(temp!=null)
            {    
                if(map.containsKey(temp.data))
                    prev.next= temp.next; // delete node but dont move previous
                    
                else // add to Map and Move previous
                {
                    map.put(temp.data, temp.data);
                    prev=temp;
                }
                    
                temp=temp.next;
            }
        }
        
       public void removeDuplicate()
        {
            
            Node temp=head;
            Node x = null;
            
            while(temp!=null)
            {    
                x=temp;
                
                while(x.next!=null)
                {
                    if(x.next.data==temp.data)
                        x.next=x.next.next;
                    else
                  x = x.next;
                    
                }
               temp=temp.next;                 
            }
        }
           
         public int findFromLast(Node node,int k)
        {
            if(node == null)
                return 0;
          
            int idx = findFromLast(node.next,k)+1;
            if(idx==k)
                System.out.println("kth data - "+ node.data);
            return idx;
        }
         
     
        public void findFromLast2(int k)
        {
           Node p1 = head;
           Node p2 = head;
           
           for(int i=0;i<k;i++)
           {
              if(p1.next!=null)
                p1=p1.next;
           }
          
           while(p1.next !=null)
           {
               p1=p1.next;
               p2=p2.next;
           }
          
           System.out.println("kth data :" + p2.data);
        }
        
        public SinglyLinkedlist partition(int data)
        {
            SinglyLinkedlist less=new SinglyLinkedlist();
            SinglyLinkedlist more= new SinglyLinkedlist();

            Node temp=head;
            
            while(temp!=null)
            {
                if(temp.data<data)
                {
                    less.addNode(temp.data);
                    
                }
                    else
                    more.addNode(temp.data);
                temp=temp.next;
            }
            temp=less.head;
            while(temp.next!=null)
                temp=temp.next;
            
            temp.next=more.head;
            
            return less;
        }
        
        
    
           
             
        public Node reverseList()
        {
            Node temp=head;
            Node newNode=null;
            Node newHead=null;
            
            while(temp!=null)
            {
                newNode=new Node(temp.data);
                newNode.next=newHead;
                newHead=newNode;
                temp=temp.next;
                
            }
            return newHead;
        }
        
        
      

        public static boolean isequal(Node head1, Node head2)
        {
            if(head1==null || head2==null)
                return false;
                       
            while(head1 !=null || head2!=null)
            {
                if(!(head1.data == head2.data))
                    return false;
                    
                head1=head1.next;
                head2=head2.next;
            }
            return true;
        }

        public boolean isPlaindromSlowFast()
        {
            Node fast=head;
            Node slow=head;
            Stack<Integer> mystack= new Stack<Integer>();

            
            while(fast!=null && fast.next!=null )
            {
                mystack.push(slow.data);
                fast=fast.next.next;
                slow=slow.next;
                
                   
            }
            
            // This is odd list and the middle one is not in Stack so move the slow
            if(fast !=null)
                slow=slow.next;
                
            
            int stackdata=0;
            while(slow!=null)
            {
                stackdata=mystack.pop().intValue();
                if(!(stackdata==slow.data))
                    return false;
                slow=slow.next;
            }
            
            return true;
        }

        public static Node checkIntersectionMap(Node head1, Node head2)
        {
            HashMap<Node,Integer> hm= new HashMap<Node,Integer>();
            while(head1 !=null)
            {
                hm.put(head1, head1.data);
                head1=head1.next;
            }
            
            while(head2 !=null)
            {
                if(hm.containsKey(head2))
                    return head2;
                head2=head2.next;
            }
            
            return null;
        }

        
        public static Node checkIntersection(Node head1, Node head2)
        {
            int len1=0; int len2=0;
            Node temp1=head1;
            Node temp2=head2;
            
             if(head1 == null || head2==null)
                return null;
             

            // length and last of first List
            while(temp1.next!=null)
            {
                len1++;
                temp1=temp1.next;
            }
            // length and last of first List
            while(temp2.next!=null)
            {
                len2++;
                temp2=temp2.next;
            }
            // as we didnt added the last node
            len1++;
            len2++;
            
            // The last node should be same
            if(temp1!=temp2)
                return null;
            
            int lendiff = Math.abs(len1-len2);
            
            temp1=head1;
            temp2=head2;
            
            // traverse the longer list with the difference so we can traverse together and compare for intersection
            if(len1>len2)
            {
                for(int i=0; i< lendiff;i++)
                    temp1=temp1.next;
            }
            else
            {
                for(int i=0; i< lendiff;i++)
                    temp2=temp2.next;
            }
            
            while(temp1!=null)
            {
                if(temp1==temp2)
                    return temp1;
                temp1=temp1.next;
                temp2=temp2.next;
            }
            
                    
            return null;
        }

        public Node checkLoop()
        {
            Node slow=head;
            Node fast=head;
            
            //find collision
            while(fast!=null && fast.next!=null)
            {
                if(slow==fast)
                    break;
                slow=slow.next;
                fast=fast.next.next;
            }
            
            slow=head;
            while(slow!=fast)
            {
               slow=slow.next;
               fast=fast.next;
            }
            return slow;
        }
}
