package ds.stack;

public class Stack {

	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char j)
	{
	
		if (isFull())
			System.out.println("No more elements can be placed in the stack");
		else
			top++;
			stackArray[top]=j;
	}
	
	public char pop()
	{
		int temp=top;
		if( isEmpty())
		{
		 System.out.println("stack is empty");
		 return 'x';
		}
		else
		{
		top--;
		return stackArray[temp];
		}
	}
	
	public char peek()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public boolean isFull()
	{
		return (top==maxSize-1);
	}
	
	
	
	
}
