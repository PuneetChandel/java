/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;
import java.util.HashSet;
/**
 *
 * @author pune7087
 */
public class findfirstrecurringChar {
    
    public static void main(String[] args) {
        String s = "abcadb";
        HashSet h= new HashSet();
        
        for(int i=0;i<s.length();i++)
        {
            if(h.contains(s.charAt(i)))
            {
                System.out.println(s.charAt(i));
                break;
            }
            else
                h.add(s.charAt(i));
        }   
        
    }
    
}
