package ds.ds.stack;

/**
 *
 * @author pune7087
 */
public class Stack2 {
    Node top;
    
    public void push(Node n)
    {
        if(top==null)
        {
            top=n;
        }
        else
        {
        n.next=top;
        top=n;
        }
    }
    
    public Node pop()
    {
        if(top!=null)
        {
            Node temp=top;
            top=top.next;
            return temp;
        }
        return null;
    }
    
    public Node peek()
    {
        if(top==null)
            return null;
        else
            return top;
        
    }
    
}
