package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class LongestCommonPrefix {
    
    public static void main(String args[])
    {
        String[] strs1 = {"dog","racecar","car"};
        String[] strs2 = {"flower","flow","flight"};
        String [] strs={"acc","aaa","aaba"};
        System.out.print(longestCommonPrefix(strs));
    }

    
     public static String longestCommonPrefix(String[] strs) {
     
        int min =Integer.MAX_VALUE;
        int minidx=0;
     
        if(strs==null || strs.length==0)
            return "";
        for(int i=0; i< strs.length; i++)
        {
            if(strs[i].length()<min)
            {
                min=strs[i].length();
                minidx=i;    
            }
        }
        
        String pre= strs[minidx];
        int preLen=pre.length();
        
        for(int i=0; i< strs.length; i++)
        { 
          int k=0;
         
         if(i!=minidx)
         {
            while(k<preLen) 
            {
                if(strs[i].charAt(k)!=pre.charAt(k))
                    break;
                k++;
            }
         
        if(k==0)
            return "";
             
         if(k<preLen)
             pre=pre.substring(0,k);
         preLen=pre.length();
         }  
        }
           
        return pre;
    }
     
}
