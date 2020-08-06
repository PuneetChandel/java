package BACKTRACK;

/**
 *
 * @author pune7087
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParanthesis {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(2);

        for(String s: list)
            System.out.println(s);

    }
    
    public boolean isValid(String str)
    {
        int count =0;
        
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i)=='(')
                count++;
           
            if(str.charAt(i)==')')
                count--;
            
            if(count<0)
                return false;
          }
        
        return count==0?true:false;
    }

        public static List<String> generateParenthesis(int n) {

            List<String> result = new ArrayList<>();

            generateParenthesis(result,"",n, 0,0);
            return result;
        }

        static void generateParenthesis(List<String> result,String curr,  int n , int open , int close)
        {
            if(curr.length()==2*n && open == n && close ==n)
            {
                result.add(curr);
                return;
            }

            if(open<n)
                generateParenthesis(result,curr+"(",n, open+1,close);
            if(close<open)
                generateParenthesis(result,curr+")",n, open,close+1);

        }


}

