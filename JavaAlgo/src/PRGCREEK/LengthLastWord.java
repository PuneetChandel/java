package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class LengthLastWord {
    
    
    public static void main(String args[])
    {
        String s = "Find length for last wordin";
        
        String[] s1= s.split(" ");
        System.out.println(s1[s1.length-1].length());
        
        int count =0;
        for(int i=s.length()-1;i>0;i--)
        {
            char a = s.charAt(i);
            if((a >= 'a' && a <='z') ||(a >='A' && a <='Z') )
                count++;
            else
                break;
        }
        
        System.out.println(count);
        
    }
}
