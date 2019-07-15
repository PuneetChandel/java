package ds.ds.stack;

/**
 *
 * @author pune7087
 */
public class StackUsingArray<E> {
    int maxSize;
    E[] stackarr;
    int top;
    int size;
    
    StackUsingArray(int maxSize)
    {
        stackarr = (E[])new Object[maxSize];
        this.top=0;
        this.size=0;
        this.maxSize=maxSize;
    }
    
    public E pop()
    {
        if(size==0)
        return null;
        else
        {
            size--;
            int temp=top;
            top--;
            return stackarr[temp];
        }
    }
    
    public boolean push(E data)
    {
        if(!isFull())
        {
            top++;
            size++;
            stackarr[top]=data;
            return true;
        }
       return false;
            
            
    }
    
    public boolean isFull()
    {
        return (size==maxSize);
    }
    
    
}
