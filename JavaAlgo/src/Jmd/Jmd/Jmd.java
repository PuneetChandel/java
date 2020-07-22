package Jmd;

/**
 *
 * @author pune7087
 */
import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Stack;
import java.util.Collections;
import java.util.Vector;
public class Jmd {

    public static void main(String args[])
    {
        List<Integer> a = new ArrayList();
        a.add(4);
        a.add(8);
        a.add(6);
        a.add(12);


        int x = minimumTime2(4,a );
        System.out.print(x);
        Vector<String> v = new Vector<>();
        v.add("hello");
        v.add("new");
        v.add("kite");

        for(int i=0; i<v.size();i++)
            System.out.print(v.get(i) + " ");

        Iterator it = v.iterator();
        while(it.hasNext())
        {
            System.out.print((String)it.next() + " ");
        }
         calculate("(1+(4+5+2)-3)+(6+8)");
    }

    public static int calculate(String s) {

        Stack<Character> stack = new Stack<>();
        s= s.replaceAll(" ",""); // remove all white spaces

        for(int i=0; i<s.length(); i++)
            stack.push(s.charAt(i));

        int result=0;

        Stack<Character> tempstack = new Stack<>();


        while(!stack.isEmpty())
        {

            Character c = stack.pop();

            if(c==')')
            {
                while(stack.peek()!='(')
                    tempstack.push(stack.pop());
            }
            else if(c=='(')
            {
                int tempsum=0;
                while(!tempstack.isEmpty())
                {
                    Character t = tempstack.pop();
                    if(Character.isDigit(t))
                        tempsum=tempsum+Character.getNumericValue(t);
                    else if(t=='+')

                        tempsum= tempsum + Character.getNumericValue(tempstack.pop());
                    else
                        tempsum= tempsum - Character.getNumericValue(tempstack.pop());
                }

                stack.push((char)(tempsum));

            }
            else
            {
                if(Character.isDigit(c))
                    result=result+Character.getNumericValue(c);
                else if(c=='+')
                {
                    result= result + Character.getNumericValue(stack.pop());
                }
                else
                {
                    result= result - Character.getNumericValue(stack.pop());

                }
            }
        }
        return result;
    }



    static int minimumTime2(int numOfSubFiles, List<Integer> files)
    {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Integer file: files)
            pq.add(file);


        int sum=0;
        while(!pq.isEmpty())
        {
            if(pq.size()>=2)
            {
                int a = pq.poll();
                int b = pq.poll();
                sum=sum+a+b;
                if(!pq.isEmpty())
                    pq.add(a+b);

            }
            else
                sum= sum+pq.poll();

        }

        return sum;
        // WRITE YOUR CODE HERE
    }

    static int minimumTime(int numOfSubFiles, List<Integer> files)
    {

        Collections.sort(files);

        Stack<Integer> stack = new Stack<>();
        for(int i =files.size()-1; i>=0; i--)
            stack.push(files.get(i));


        int sum=0;
        while(!stack.isEmpty())
        {
            if(stack.size()>=2)
            {
                int a = stack.pop();
                int b = stack.pop();
                sum=sum+a+b;
                if(!stack.isEmpty())
                {
                    stack.push(a+b);
                    if(stack.size()>1)
                    {
                        Stack temp = sortStack(stack);
                        stack = temp;
                    }
                }
            }
            else
                sum= sum+stack.pop();

        }

        return sum;
        // WRITE YOUR CODE HERE
    }

    static Stack<Integer> sortStack(Stack<Integer> input)
    {
        Stack<Integer> tempStack = new Stack<Integer>();

        while(!input.isEmpty())
        {
            int tmp = input.pop();
            while(!tempStack.isEmpty() && tempStack.peek() < tmp)
            {
                input.push(tempStack.pop());
            }
            tempStack.push(tmp);
        }
        return tempStack;
    }


    static void test()
    {
        String s = "jhsagjahfjaf";
        char[] c = s.toCharArray();

        boolean[][] palin = new boolean[s.length()][];

        String longPalin="";
        for(int i=0; i<c.length;i++)
        {
            palin[i][i]=true;
        }

        for(int i=0; i<c.length-1;i++)
        {
            if(c[i]==c[i+1])
                palin[i][i+1]=true;
            if(longPalin.length()<2)
                longPalin=s.substring(i,i+2);
        }

        for(int l=2; l<c.length;l++)
        {
            for(int i=0; i< c.length-l; i++)
            {
                int j = i+l;

                if(c[i]==c[j] && palin[i+1][j-1]==true)
                {
                    palin[i][j]=true;
                    String temp = s.substring(i,j+1);
                    if(temp.length()>longPalin.length())
                        longPalin=temp;
                }

            }

        }

    }

}
