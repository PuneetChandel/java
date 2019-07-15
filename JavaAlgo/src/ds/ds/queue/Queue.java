package ds.queue;

public class Queue {
	private int maxSize;
	private int[] queueArray;
	private int front;
	private int end;
	
	public Queue(int maxSize)
	{
		this.maxSize=maxSize;
		queueArray = new int[maxSize];
		front=0;
		end=-1;
				
	}
	
	public void insert(int j)
	{
		if (end == maxSize-1)
		{
			end=-1;/// for circular queue
		}
		end++;
		queueArray[end]=j;
	}

	public int remove()
	{
		int temp=queueArray[front];
		front ++;
		if(front==maxSize)
			front=0; // set front to 0 if we removed everything from queue
		return temp;
	}
	
}


