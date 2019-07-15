/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STACK_QUEUE;

/**
 *
 * @author pune7087
 */
public class Queue {
    
    Node first=null;
    Node last=null;
    
    public void add(int data)
    {
        Node temp = new Node(data);
        
        if(last != null)
        {
            last.next=temp;
            last=temp;
        }
        if(first==null)
        {
          last=temp;
          first=last;
        }
    }
    
    public Node remove()
    {
      
       if(first == null)
           return null;
       
       Node temp=first;
       first = first.next;
       if(first==null)
           last=null;
       return temp;
    }
    
    
}
