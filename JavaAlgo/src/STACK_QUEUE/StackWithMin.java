/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STACK_QUEUE;
import java.util.Stack;
/**
 *
 * @author pune7087
 */
public class StackWithMin{
    
    NodeWithMin top=null;
    
    public void push(int data)
    {
        NodeWithMin temp=null;
        if(top==null){
            temp= new NodeWithMin(data,data);
            top=temp;
        }
        else
        {
            temp=new NodeWithMin(data, Math.min(data,top.min));// min is saved at each level for vlues below that level
            temp.next=top;
            top=temp;
        }
            
    }
    
    
    public int min()
    {
        if(top==null)
            throw new NullPointerException("Stack is empty");  
        
        return top.min;
    }
    
    public NodeWithMin peek()
    {
        if(top==null)
            throw new NullPointerException("Stack is empty");  
        
        return top;
    }
    
    
    
}

class NodeWithMin
{
    int data;
    int min;
    NodeWithMin next;
    
    NodeWithMin(int data, int min)
    {
        this.data=data;
        this.min=min;
        next=null;
    }
}