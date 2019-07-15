/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;
/**
 *
 * @author pune7087
 */
public class MaxRepeatinChar {
     
    public static void main(String[] args) {
        String str = new String("AABCxxxyxxxDDBBBBEEEEEEAzzz");
        
        char temp= 'x';
        int tempcnt=0;
        
        char res='x';
        int rescnt=0;
        
        
        for(int i=0; i<str.length();i++)
        {
            if(str.charAt(i)==temp)
                tempcnt++;
         
            else
            {
                if(tempcnt>rescnt)
                {
                    rescnt=tempcnt;
                    res=temp;
                }
                temp=str.charAt(i);
                tempcnt=1;
            }            
            
        }
        
        System.out.print(res + ": " + rescnt + " ");

    }
}
