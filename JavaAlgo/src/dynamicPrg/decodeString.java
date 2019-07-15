/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;

/**
 *
 * @author pune7087
 * 
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 ...
 * a b c d e f g h h i j   k  l m
 * 
 * 12 -> ab,k : 2
 * 123 -> abc,kb, au : 3
 */
public class decodeString {
    
    public static void main(String[] args) {
        String data= "123456";
        System.out.println(nways(data,data.length()));
    }
    
    public static int nways(String s , int k)
    {
        int result =0;

        
        if(k==0)
            return 1;
        
        if(s.charAt(s.length()-k)=='0')
            return 0;
        
        result = nways(s,k-1 );
                
        if(k>=2 && Integer.parseInt(s.substring(s.length()-k, s.length()-k+2))<=26)
                {
                    result += nways(s,k-2);
                }
        
        return result;
    }
}
