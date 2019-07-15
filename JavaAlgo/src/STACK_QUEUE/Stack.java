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
public class Stack {
    Node top=null;

    public Node pop()
    {
        if(top == null)
            return null;
        Node temp=top;
        top=top.next;
        return temp;
    }
    
   public void push(int data)
    {
        Node temp=new Node(data);
        temp.next=top;
        top=temp;
    }
     
  public int peek()
    {
        if(top==null)
            throw new NullPointerException("Stack is empty");  
        
        return top.data;
    }
  
  public boolean isEmpty()
    {
        return top==null;
    }
  
  public void sortStack()
  {
      Stack s2 = new Stack();
      Node temp;
      Node temp2;
      
      while(!this.isEmpty())
      {
          temp=this.pop();
          
          if(s2.isEmpty())
              s2.push(temp.data);
          else
          {
          while(s2.peek()> temp.data && !(s2.isEmpty()))
          {
            temp2 = s2.pop();
            this.push(temp2.data);
          }
          s2.push(temp.data);
          }
      }
  }
  
}
