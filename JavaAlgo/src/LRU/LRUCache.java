package LRU;

/**
 *
 * @author pune7087
 */

/**
 *
 * @author pune7087
 */
import java.util.HashMap;

class LRUCache
{
    public static void main(String args[])
    {
        LRUCache1 cache = new LRUCache1(2);
        cache.put(1, 1);
        cache.put(2, 2);
        
        System.out.println(" GET 1: " + cache.get(1));
       
        cache.put(3, 3);
       
         System.out.println(" GET : " + cache.get(2));
        cache.put(4, 4);
        
         System.out.println(" GET : " + cache.get(1));
         System.out.println(" GET : " + cache.get(3));
         System.out.println(" GET : " + cache.get(4));
    }
}


class LRUCache1 {

       HashMap<Integer, Node>  map;
        int capacity;
        Node head;
        Node tail;
     
    public LRUCache1(int capacity) {
            this.capacity=capacity;
            map= new HashMap();
    }
        
        
        
    public int get(int key) {
        
        if(map.containsKey(key))
        {
        Node n =map.get(key); 
        int val=n.data;
        remove(n);
        setHead(n);
        return val;
        }
        else
            return -1;
        
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            Node n = map.get(key);
            n.data=value;
            remove(n);
            setHead(n);
        }
       else
       {
            if(map.size()>=capacity)
            {
                map.remove(tail.key);
                remove(tail);
            }
           
            Node n = new Node(key,value);
            setHead(n);
            map.put(key,n);
            
        }
    }
    
    public void remove(Node n)
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
        
    
    public void setHead(Node n)
    {
        if(head!=null)
          head.prev=n;
      
            n.next=head;
            n.prev=null;
            head=n;
        
        if(tail==null)
            tail=head;
    }
    
  
}

class Node
{
    Node prev;
    Node next;
    int data;
    int key;
    
    public Node(int key, int data)
    {
       
        this.key=key;
        this.data= data;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
