package LL;

/**
 *
 * @author pune7087
 */
import java.util.HashMap;
public class LRU {
    
    HashMap<Integer,LRUNode> map;
    LRUNode head;
    LRUNode tail;
    int cap;
    
    LRU(int cap)
    {
        this.cap=cap;
        this.map = new HashMap();
    }
    
    // remove the node and add it to head. as we are keepign recently use on begining
    public int get(int key)
    {
        if(!map.containsKey(key))
            return -1;
        
            LRUNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.data;
            
    }
    
    // add at begining and if size> cap remove tail
    public void put(int key, int data)
    {
        if(map.containsKey(key))
        {
            LRUNode n = map.get(key);
            n.data=data;
            remove(n);
            setHead(n);
        }
        else 
        {
            if(map.size()>=cap)
            {
                 remove(tail);
                 map.remove(tail.key);
            }
            
            LRUNode n = new LRUNode(key,data);
            map.put(key, n);
            setHead(n);
        }
        
    }
    
    public void remove(LRUNode n)
    {
        if(n.prev!=null)
              n.prev.next=n.next;
        else // removing head
            head=n.next;
        
        if(n.next!=null)
            n.next.prev=n.prev;
        else // removing tail
            tail=n.prev;   
    }
    
    public void setHead(LRUNode n)
    {
        if(head!=null)
        {
            head.prev=n;
        } 
        n.next=head;
        n.prev=null;
        head=n;
        
        if(tail==null)
            tail=head;
    }
    
    
}

class LRUNode
{
    int data;
    int key;
    LRUNode next;
    LRUNode prev;
    
    LRUNode(int data, int key)
    {
        this.data=data;
        this.key=key;
        
    }
 }
