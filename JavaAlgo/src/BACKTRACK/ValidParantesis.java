package BACKTRACK;

/**
 *
 * @author pune7087
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;


public class ValidParantesis {
    
public static void main(String args[])
       {
           System.out.print(removeInvalidParenthesis("()(()"));
           
           
       }

public static boolean isValid(String s)
{
    int count =0;
    for(int i=0; i<s.length();i++)
    {
        
        if(s.charAt(i)=='(')
            count++;
        if(s.charAt(i)==')')
            count--;
 
        if(count<0)
            return false;
        
        
    }
 
    if (count==0)
        return true;
    else
        return false;
}
     
public static ArrayList<String> removeInvalidParenthesis(String str)
{
    ArrayList<String> result = new ArrayList();
    
    HashSet<String> visited = new HashSet();
    Queue<String> q = new LinkedList();
    q.add(str);
    visited.add(str);
    
    
    boolean levelIsValid=false;
    
    
    while(!q.isEmpty())
    {
        String temp=q.poll();
        
        if(isValid(temp))
        {
            result.add(temp);
            levelIsValid=true;
        }
        
        if(levelIsValid) // this is important otherwise for valid sttring it will still keep checking the substrings for eligibility when the parent is already valid.
            continue;
        
        for(int i=0; i<temp.length();i++)
        {
            if(temp.charAt(i)!='(' && temp.charAt(i)!=')')
                continue;
            
            String pre=temp.substring(0,i);
            String post=temp.substring(i+1);
            
            // check by removing 1 char at a time
            String temp1=pre+post;
            
            if(!visited.contains(temp1))
            {
                 q.add(temp1);
                 visited.add(temp1);
            }
            
        }
        
    }
    
    return result;
}



    
}
