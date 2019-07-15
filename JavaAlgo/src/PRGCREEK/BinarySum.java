package PRGCREEK;

/**
 *
 * @author pune7087
 * For example, a = "11", b = "1", the return is "100".
 */
public class BinarySum {
    
    public static void main(String args[])
    {
        String a="111";
        String b = "1111";
        
        StringBuilder sb = new StringBuilder();
       
        int i =a.length()-1;
        int j = b.length()-1;
        int carry=0;
        int sum =0;
        int va=0;
        int vb=0;
        while(i>=0 || j>=0)
        {
            sum=sum+carry;
            
            if(i>=0)
            {
                va=a.charAt(i)=='0'? 0 :1;
                sum=sum+va;
            }
            if(j>=0)
            {
               vb=b.charAt(j)=='0'? 0 :1;
               sum=sum+vb;
            }
            
            if(sum>=2)
            {
                sb.append(sum-2);
                carry=1;
                sum=0;
            }
            else
            {
                sb.append(0);
                carry=0;
                sum=0;
            }
            i--;
            j--;
        }
        sb.append(carry);
        System.out.println((sb.reverse().toString()));
        
    }
}
