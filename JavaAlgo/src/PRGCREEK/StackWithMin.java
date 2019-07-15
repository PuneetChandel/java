package PRGCREEK;

/**
 *
 * @author pune7087
 */
import java.util.Stack;

class MinStackNode
{
    int data;
    int min;
    
    MinStackNode(int data, int min)
    {
        this.data=data;
        this.min=min;
    }
}
public class StackWithMin extends Stack<MinStackNode> {
    
    public void push(int data)
    {
         int min = Math.min(data, getMin());
         super.push(new MinStackNode(data, min));
    
    }
    
    public  MinStackNode pop()
    {
        return super.pop();
    }
    
    public int getMin()
    {
        if(this.isEmpty())
            return Integer.MAX_VALUE;
        else
           return peek().min;
    }
}

class StackWithMin2 extends Stack<Integer>
{
    Stack<Integer> minStack;
    
    public void push(int data)
    {
         if(data<getMin())
             minStack.push(data);
         
         super.push(data);
    
    }
    
    public int getMin()
    {
        if(minStack.isEmpty())
            return Integer.MAX_VALUE;
        else
           return minStack.peek();
    }
    
    public Integer pop()
    {
        int data = super.pop();
        if(data==getMin())
            minStack.pop();
        return data;
    }
    
}
