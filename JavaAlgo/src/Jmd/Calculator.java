import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class Calculator {

    public static void main(String[] args) {

            System.out.println(calculate("3+6/2+8"));
    }

    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>() ;
        Stack<Character> opStack = new Stack<>() ;

        String op="+-*/()";
        Map<Character,Integer> order = new HashMap<>();
        order.put(')',-1);
        order.put('+',0);order.put('-',0);
        order.put('*',1);order.put('/',1);
        order.put('(',2);
        int sign =1;
        s= s+"+"; // need to trigger the last calculation
        char[] str = s.toCharArray();
        int i=0;

        while(i<str.length)
        {
            if(str[i]=='-' && (i==0 || str[i-1]=='('))
            {
                sign=-1; i++;
            }
            if(Character.isDigit(str[i]))
            {
                int num=0;
                while(i<str.length && Character.isDigit(str[i]))
                {
                    num = num*10 + Character.getNumericValue(str[i]);
                    i++;
                }
                numStack.push(num*sign);
                sign=1;
            }
            else if(op.indexOf(str[i])!=-1)
            {
                while(!opStack.isEmpty() && order.get(opStack.peek()) >= order.get(str[i]) && opStack.peek()!='(')
                {
                    char opr = opStack.pop();
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    numStack.push(getRes(num2,num1,opr));
                }
                if(str[i]==')')
                    opStack.pop();
                else
                    opStack.push(str[i]);

                i++;
            }
            else
                i++;
        }

        return numStack.pop();
    }

    private static int getRes(int a, int b, char c)
    {
        switch(c)
        {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }

        return Integer.MIN_VALUE;
    }
}