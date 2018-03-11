package ds.stack;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack s = new Stack(10);
		s.push('a');
		s.push('b');
		s.push('c');
		
		
		while( !s.isEmpty())
			System.out.println("POP "+ s.pop());
		
		reverse("Puneet");
		
	}
	
	public static void reverse(String st)
	{
		Stack strStack = new Stack(st.length());	
		for(int i=0;i<st.length();i++)
			strStack.push(st.charAt(i));
		
		while(! strStack.isEmpty())
			System.out.println(strStack.pop());
	}

}
