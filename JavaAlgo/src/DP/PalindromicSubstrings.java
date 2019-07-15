package DP;

/**
 *
 * @author pune7087
 */
public class PalindromicSubstrings {
        public int countSubstrings(String s) {
        
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count=0;
        
        for(int i=0; i<dp.length; i++)
        {
            dp[i][i]= true;
            count++;
        }

        for(int i=0; i<dp.length-1; i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]= true;
                count++;
            }
        }
        
        for(int l=2; l< s.length();l++)
        {
            for(int i=0; i<s.length()-l;i++)
            {
                int j=l+i;
                
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
                {
                    dp[i][j]=true;
                    count++;
                }
                
            }
            
        }
        
        return count;

        
        
    }
}
