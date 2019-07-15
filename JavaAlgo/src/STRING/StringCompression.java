/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STRING;

public class StringCompression {
    
    public static void main(String[] args){
        System.out.println(new StringCompression().checkpattern("abfjjjjf"));
    }
    
    private String checkpattern(String s1)
    {
        char chrarr[]= s1.toCharArray();
        boolean str_rep= false;
        int cnt =1;
        StringBuilder s2= new StringBuilder();
   
        for(int i=0; i<chrarr.length-1; i++)
        {
            if(chrarr[i]==chrarr[i+1] )
            {
                str_rep=true;
                cnt++;
            }
            else
            {
                s2.append(chrarr[i]+ ""+cnt);
                cnt=1;
            }
            if(i==chrarr.length-2)
                s2.append(chrarr[i]+ ""+cnt);
        }
        if(str_rep==false)
            return s1;
        else
           return s2.toString();
        
    }
}
