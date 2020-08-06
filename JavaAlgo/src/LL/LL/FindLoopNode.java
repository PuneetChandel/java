package LL;

/**
 *
 * @author pune7087
 */
public class FindLoopNode {
    
      public Node detectCycle(Node head) {
        
        if(head==null || head.next==null)
            return null;
        
        boolean loopExist = false;
        
        Node slow= head;
        Node fast= head;

        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow= slow.next;
            if(fast==slow)
            {
                loopExist=true;
                break;
            }
        }
        
        if (!loopExist) 
           return null; 
        
        slow=head;
        while(slow != fast)
        {
            fast=fast.next;
            slow= slow.next;
            
        }
            
        return slow;
    }
}
