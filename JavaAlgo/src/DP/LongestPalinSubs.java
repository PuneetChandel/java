package DP;

/**
 *
 * @author pune7087
 */
public class LongestPalinSubs {
    
   public static void main(String args[])
   {
       System.out.print(longestPalindrome("ababcb"));
   }
    
    public static String longestPalindrome(String s) {
       
         if(s==null || s.length()<=1)
        return s;
         
        boolean[][] dp= new boolean[s.length()][s.length()];

        String longPalin= new String(s.substring(0,1));
        
        // This is because each char is palin of itself (0,0) (1,1) 
        for(int i=0; i<dp.length;i++)
            dp[i][i]= true;
        
        // for length 2 strings and if they are same they are palin
        for(int i=0; i< dp.length-1;i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1]=true;
                
                if(longPalin.length()<2)
                    longPalin=s.substring(i,i+2);
             }
        }
        
        // check everything for length >2 . w start from 2 as 0-1 is alredy checked in previous loop
        for(int l=2;l<s.length();l++)
        {
            for(int i=0; i<s.length()-l;i++)
            {
                int j = l+i;
                
                if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1]))
                {
                    dp[i][j]= true;
                    String temp=s.substring(i,j+1);
                    
                    if(longPalin.length()< temp.length())
                        longPalin=temp;
                }
            }
            
        }
        
        return longPalin;
    }
    
    public static String longestPalindrome2(String s) {
    if(s==null || s.length()<=1)
        return s;
 
    int len = s.length();
    //int maxLen = 1;
    boolean [][] dp = new boolean[len][len];
 
    String longest = new String(s.substring(0,1));;
    
    for(int l=0; l<len; l++){
    
        for(int i=0; i<len-l; i++){
        
            int j = i+l;
            
            /*
            True options
            1. single char char = char and j-i<=2
            2. 2 char where char[i]=char[j] j-i <=2
            3. 2 or more and out char are equals + dp[i+1][j-1]== true
            */
           
            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
            
                dp[i][j]=true;
 
                String temp=s.substring(i,j+1);
                
                if(longest.length()< temp.length())
                        longest=temp;
                    
                /*if(j-i+1>maxLen){
                   maxLen = j-i+1; 
                   longest = s.substring(i, j+1);
                }*/
            }
        }
    }
 
    return longest;
}
    

   
    
}
