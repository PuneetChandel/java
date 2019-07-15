package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class StringToInteger {
    
    public static void main(String args[])
    {
        
        System.out.println(StringToInt("4032"));
    }
    
    public static int StringToInt(String s)
    {
        double sum =0;
        int i=0;
        boolean neg= false;
        
        if(s.charAt(0)=='+')
            i++;
        
        if(s.charAt(0)=='-')
        {
            neg=true;
            i++;
        }
        
        for(; i<s.length();i++)
        {
               sum = sum*10 +  s.charAt(i) - '0';
           
        }
        
        if(neg)
            sum = 0-sum;
        
        if(sum> Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(sum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return (int)sum;
    }
}
