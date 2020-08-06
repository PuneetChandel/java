package LL;

/**
 *
 * @author pune7087
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
import java.util.Stack;


public class LinkList {
 
    public static void display(Node n)
    {
        while(n!=null)
        {
            System.out.print(" "+ n.data + " -> ");
            n=n.next;
        }
    }

    public static boolean isPalindrom(Node root)
    {
        Node slow=root;
        Node fast=root;
        Stack<Integer> s = new Stack<>();

        while(fast!=null && fast.next!=null)
        {
            s.push(slow.data);
            slow = slow.next;
            fast=fast.next.next;
        }
        
        // odd list and we dont have middle in stack
        if(fast!=null)
            slow=slow.next;
        
        while(slow!=null)
        {
            if(slow.data!=s.pop())
            {
               return false;
            }
            slow=slow.next;
        }
        
        return true;
    }
            
            
            
      public Node removeNthFromEnd(Node head, int n) {
     
        if(head==null)
            return null;
        
        if(head.next==null && n ==1)
            return null;
        
     Node slow = head;
     Node fast = head;
     int k=1;
     Node prev=head;   
        while(k<=n)
        {   k++;
            fast=fast.next;
        }
        
        while(fast!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        
        if(slow==head)
           head=head.next; 
        else
           prev.next=slow.next;
        
        return head;
    }
      
    public static void deleteFromEnd(Node root, int k)
    {
        Node slow=new Node();
        Node fast= new Node();
        slow.next=root;
        fast.next=root;
        int i=0;
        
        while(i<k)
        {
           fast=fast.next;
           i++;
        }
        // we reached last, meaning we need to delete the first Node
        if(fast==null)
        {
            root=root.next;
            return;
        }
            
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        Node temp=slow.next.next;
        slow.next=temp;
        
    }
    public static Node reverseLL(Node start)
    {
        if(start==null && start.next==null)
            return start;
        
        
        Node p1=start;
        Node p2= start.next;
        
        // end of LL
        start.next=null;
        
        while(p2!=null)
        {
            Node temp=p2.next;     
            p2.next=p1;
            p1=p2;

            
            if(temp!=null)
                p2=temp;
            else
                return p2;
        }
        
        return p2;
    }
    
    
    
    public static Node reverseLLfromPosition(Node root, int start, int end)
    {
        if(root==null || root.next==null)
            return root;
        
        int k =0;
        
        Node first = new Node();
        Node second = new Node();
        
        Node pre=null;
        Node p = root;
        
        // find start and end nodes and store them
        while(p!=null && k<=end)
        {
            k++;
            
            if(k==start-1)
                pre=p;
            
            if(k==start)
                first.next=p;
            
            if(k==end)
                second.next=p.next;
            
            p=p.next;
        }
        
       
        Node p1= first.next;
        Node p2= p1.next;
        
        // link first to last.next this is how it will be after reverse
        p1.next=second.next;
        
        k=start;
        
        while(p2!=null && k<end)// k<end to ot reverse after k
        {
            k++;
            Node temp=p2.next;
            p2.next=p1;
            p1=p2;
            p2=temp;
            
        }
        
        if(pre!=null)
           pre.next=p1;
        else
            return p1;
        
        return root;
        
    }
    
        public static Node reverseBetween(Node head, int m, int n) {
        
        if(head==null || head.next==null)
            return head;
        
        Node dummy = new Node(0);
        dummy.next=head;
        Node prev=dummy;

        Node curr= head;
        
        int i=1;
        
        while(i<m)
        {   prev=curr;
            curr=curr.next;
            i++;
        }
        
        
        Node p1= prev;
        
        while(i<=n)
        {
            Node temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            i++;
        }
        
        p1.next.next=curr;
        p1.next=prev;
        
        return dummy.next;
    }
        
    
    public static Node removeElements(Node root,int data)
    {
        if(root==null)
            return null;
        
        if(root.data==data && root.next!=null)
            return root.next;
        else if(root.data==data && root.next==null)
            return null;
            
            
        
        Node prev= root;
        Node curr = root.next;
        
        while(curr!=null)
        {
            if(curr.data==data)
                prev.next=curr.next;
            else
                prev=curr;
           
            curr=curr.next;
        }
        
        return root;
    }
    
    public static Node swapPair(Node root)
    {
        if(root==null || root.next==null)
            return root;
        
        Node start = new Node();
        start.next=root;
        
        Node p1=root;
        Node p2=root.next;
        
        Node pre=start;
        
        
        while(p1!=null && p2!=null)
        {
            pre.next=p2;
            
            pre=p1;
            
            
            Node temp= p2.next;
    
            p2.next=p1;
            p1.next=temp;
            
            p1=p1.next;
            
            if(temp!=null)
                p2=temp.next;
        }
        
        return start.next;
                
                
    }
    
    public static Node addLinkListNumbers(Node first, Node second)
    {
        Node result=null;
        Node lastnode=null;
        
        int sum=0;
        int carry=0;
        while(first!=null || second!=null)
        {
            sum= carry;
            
            if(first!=null)
            {
                sum=sum+first.data;
                first=first.next;
            }
            if(second!=null)
            {
                sum=sum+second.data;
                second=second.next;
            }
            if(sum>=10)
            {
                carry=1;
                sum=sum-10;
            }
            else
                carry=0;
            
            if(result==null)
            {
                result=new Node(sum);
                lastnode=result;
            }
             else
            {
                Node temp=new Node(sum);
                lastnode.next=temp;
                lastnode=temp;
            }

        }
        
        // for last Carry
        if(carry>0)
        {
            Node temp=new Node(carry);
                lastnode.next=temp;
                lastnode=temp;
        }
            
        
        return result;
    }
    
    public static void reorderLinkList(Node first)
    {
        Node head=first;
        Node slow=first;
        Node fast= first;
        // find mid
        while(fast!=null && fast.next!=null & fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        
        Node second=slow.next;
        // to create two list
        slow.next=null;
        
        // reverse the second list
        second = reverse(second);
        
        //merge the 2 list
        Node p1 = head;
        Node p2= second;
        
        Node temp1=null;
        Node temp2=null;
        
        while(p2!=null)
        {
            temp1=p1.next;
            temp2=p2.next;
            
            p1.next=p2;
            p2.next=temp1;
            
            p1=temp1;
            p2=temp2;
   
        }
        
        
    }

    public boolean hasCycle(Node node)
    {
        Node slow= node;
        Node fast= node;
        
        while(fast!=null && fast.next!=null)
        {
            fast= fast.next.next;
            slow = slow.next;
            if(fast==slow)
                return true;
        }
        return false;
    }
        
    public static Node reverse(Node head)
    {
        Node prev= head;
        Node curr = head.next;
        Node temp= null;
        
        if (head == null || head.next == null) {
			return head;
		}
        
        
        // need to have reference for three nodes, Prev -> curr-> temp
        while(curr!=null)
        {
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            
        }
        head.next=null;
        return prev;
    }
    
    public static Node mergeSortedList(Node first, Node second)
    {
        Node head = new Node(0);
        Node p=head;
        
        while(first!=null && second !=null)
        {
            if(first.data<=second.data)
            {
                p.next=first;
                first=first.next;
                        
            }
            else
            {
                p.next=second;
                second=second.next;
            }

           p=p.next;
        }
        
        // no need to loop, just attach the remaining list
         if(first!=null)
                p.next=first;
         
        if(second!=null)
                p.next=second;

        
        return head.next;
    }

    
    public static RandomNode copyRandomLL(RandomNode head)
    {
        if(head==null || head.next==null)
            return head;
        
        RandomNode node = head;
        
        // Merge duplicate Nodes
        while(node!=null)
        {
           RandomNode copy= new RandomNode(node.data);
           copy.next=node.next;
           node.next=copy;
           node=copy.next;
        }
        
        // copy Random
        node = head;
        while(node!=null)
        {
            if(node.random!=null)
            {
              node.next.random=node.random.next;
            }
            node=node.next.next;
        }
        
        // separate list
        node=head;
        RandomNode newHead=head.next;
        
        while(node!=null)
        {
            RandomNode temp = node.next;
            node.next=temp.next;
            if(temp.next!=null)
            temp.next=node.next.next;
            
            node=node.next;
            
        }
        
        return newHead;
    }
    
    public static Node removeDupSortedList2(Node head)
    {
        if(head==null || head.next==null)
            return head;
        
        Node pre=head;
        Node curr=head.next;
        
        while(curr!=null)
        {
            if(pre.data==curr.data)
            {
                pre.next=curr.next;
                curr=curr.next;
            }
            else
            {
                pre=pre.next;
                curr=curr.next;
            }
            
          }
        
        return head;
    }
    
     public static Node removeDupSortedList(Node head)
    {
        if(head==null || head.next==null)
            return head;
        
       Node curr = head;
       
       while(curr!=null)
       {
           Node temp=curr;
           
           while(temp!=null && temp.data==curr.data)
               temp=temp.next;
           
           curr.next=temp;
           curr=curr.next;
           
       }
        return head;
    }
     
   public static Node delDupSortedList(Node head)
    {
       if(head==null || head.next==null)
            return head;
    
       Node temp=new Node();
       temp.next=head;
       
       Node curr = head;
       Node prev= temp;
       
       while(curr!=null)
       {
           
           while(curr.next!=null && prev.next.data==curr.next.data)
           {
               curr=curr.next;
           }
           
           // if we get unique node
           if(prev.next==curr)
           {
               prev=prev.next;
           }
           else
           {
               // prev not move to next node as we need to delete 
               prev.next=curr.next;
               //curr = curr.next;
           }

           curr = curr.next;
       }
       /// if the head was not unique it would have been removed and 
       // the first unique value is assigned to tempHead.next via prev.next
        return temp.next;
    }
       
     
   public static Node partitionListLeet(Node head, int x)
   {
     Node tsmall=new Node();
     Node tbig = new Node();
     
     Node tshead=tsmall;
     Node tbhead=tbig;
     
     Node temp=head;
     
     while(temp!=null)
     {
         if(temp.data<x)
         {
               tsmall.next=temp;
               tsmall=tsmall.next;
         }
         else if(temp.data>=x)
         {
             tbig.next=temp;
             tbig=tbig.next;
         }
      temp=temp.next;
     }

     tbig.next=null;
     tsmall.next=tbhead.next;
     
     return tshead.next;
     
   }
   public static Node partitionList(Node head, int x)
   {
     Node tsmall=null;Node tshead=null;
     Node tbig = null; Node tbhead=null;
     Node tequal = null; Node tehead=null;
     
     Node temp=head;
     
     while(temp!=null)
     {
         if(temp.data<x)
         {
             if(tshead==null)
             {
                 tshead=temp;
                 tsmall=temp;
                 
             }
             else
             {
               tsmall.next=temp;
               tsmall=tsmall.next;
             }
         }
         else if(temp.data>x)
         {
                if(tbhead==null)
             {
                 tbhead=temp;
                 tbig=temp;
                 
             }
             else
                {
             tbig.next=temp;
             tbig=tbig.next;
                }
         }
         else
         {
             if(tehead==null)
             {
                 tehead=temp;
                 tequal=temp;
             }
             else
             {
             tequal.next=temp;
             tequal= tequal.next;
             }
         }
         
         temp=temp.next;
     }
     
     
     tbig.next=null;
     
     
     if(tshead==null)
     {
         if(tehead==null)
             return tbhead;
         else
         {
             tequal.next=tbhead;
             return tehead;
         }
             
     }
     
      if(tehead==null)
      {
          tsmall.next=tbhead;
           return tshead;
      }
     
      
     tsmall.next=tehead;
     tequal.next=tbhead;
     
     return tshead;
     
   }
   
   
    public static Node oddEvenList(Node head)
    {
        if(head==null || head.next==null)
            return head;
        
        Node p1= head;
        Node p2= head.next;
        
        Node evenHead = head.next;
        
        while(p1!=null && p2!=null && p2.next!=null)
        {
            p1.next= p2.next;
            // Move to next node
            p1=p1.next;
            
            p2.next= p1.next;
            p2=p2.next;
            
        }
        
        p1.next=evenHead;
        
        return head;
        
    }
    
    public static Node inersectionList(Node node1, Node node2)
    {
        if(node1==null || node2==null)
            return null;
        
        Node root1=node1;
        Node root2= node2;
        
        int len1= 0;
        int len2=0;
        
        while(node1!=null)
        {
            len1++;
            node1=node1.next;
        }
        
        while(node2!=null)
        {
            len2++;
            node2=node2.next;
        }
        
        int diff=0;
        if(len1>len2)
        {
            diff= len1-len2;
            
            while(diff>0)
            {
                root1=root1.next;
                diff--;
            }
            
        }
        else
         {
            diff= len2-len1;
            
            while(diff>0)
            {
                root2=root2.next;
                diff--;
            }
            
        }   
        
        
        while(root1!=null && root2!=null)
        {
            if(root1==root2)
                return root1;
            
            root1= root1.next;
            root2=root2.next;
               
        }
        
        return null;
    }
    
    
 
    
}

class RandomNode
{
    int data;
    RandomNode next;
    RandomNode random;
    
    RandomNode(int data)
    {
        this.data=data;
        next=null;
        random=null;
    }
    
    public static RandomNode copyNode(RandomNode n1)
    {
        RandomNode n2= new RandomNode(n1.data);
        n2.next=n1.next;
        n2.random=n2.random;
        return n2;
    }
}