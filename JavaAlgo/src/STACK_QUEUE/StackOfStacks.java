/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STACK_QUEUE;
import java.util.ArrayList;

/**
 *
 * @author pune7087
 */
public class StackOfStacks{
    ArrayList<MyStack> sos = new ArrayList<MyStack>();
    int cap;
    
    StackOfStacks(int c)
    {
        cap =c;
    }
    
    public void push(int data)
    {
        MyStack last=sos.get(sos.size()-1); // get last stack
        
          if(last.isFull())
          {
            last = new MyStack(cap);
            last.push(data);
            sos.add(last);
          }
          else // stack is not full
             last.push(data);
        
    }
    
    public Node pop()
    {
        MyStack last = sos.get(sos.size()-1); // get last stack
        Node n= last.pop();
        if(last.isEmpty())
            sos.remove(sos.size()-1);
        
        return n;
    }
}


class MyStack{
    
    Node top=null;
    int capacity;
    int size;
    
    MyStack(int capacity)
    {
        this.capacity=capacity;
    }
    
    public void push(int data)
    {
        Node temp=new Node(data);
        temp.next=top;
        top=temp;
        size++;
    }
    
    
    public Node pop()
    {
        if (top == null)
            return null;
        
         Node temp =top;
         top=top.next;
         size--;    
         return temp; 
        
        
    }
    
   
    public boolean isFull()
    {
        return size ==capacity;
    }
    
     public boolean isEmpty()
    {
        return size ==0;
    }
}
