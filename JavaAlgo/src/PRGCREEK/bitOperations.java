/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRGCREEK;

public class bitOperations {
    
    public static void main(String[] args) {
        int a = 8;int b = 2;
        System.out.println(" a :  " + Integer.toBinaryString(a));
        System.out.println(" b :  " + Integer.toBinaryString(b));
        
        System.out.println(" a & b : " + Integer.toBinaryString(a&b) + " Decimal val : "+ (a&b));
        System.out.println(" a | b : " + Integer.toBinaryString(a|b) + " Decimal val : "+ (a|b));
        System.out.println(" a ^ b : " + Integer.toBinaryString(a^b) + " Decimal val : "+ (a^b));
        
       
        a= 3;
        System.out.println(" a :  " + Integer.toBinaryString(a));
        System.out.println(" a <<2 : " + Integer.toBinaryString(a<<2) + " Decimal val : "+ (a<<2));
        System.out.println(" a >>1 : " + Integer.toBinaryString(a>>1) + " Decimal val : "+ (a>>1));
        //System.out.println(" ~a : " + Integer.toBinaryString(~a) + " Decimal val : "+ (~a));
        
        System.out.println(" a :  " + Integer.toBinaryString(a));
       //2’s complement of a binary number is 1 added to the 1’s complement of the binary number. 
       System.out.println(" ~a : " + Integer.toBinaryString(~a) + " Decimal val : "+ (~a));
        
       int n =4;
        System.out.println(" 1 <<n : " + " Decimal val : "+ (1<<n));
        
        
        int x=4;
        int y=2;
        
            System.out.println("Hamming distance : " + hammingDistance(x,y));  
           
            
            for(int i=0; i< 40;i++)
            {
                 System.out.println("  Binary for  "+ i + " : " + Integer.toBinaryString(i));
            }
    }
      public static int hammingDistance(int x, int y) {
        
          
        String s1 = Integer.toBinaryString(x^y);
      
        System.out.println("Integer.toBinaryString(x) : " + Integer.toBinaryString(x) + "Integer.toBinaryString(y) :"+ Integer.toBinaryString(y));  
        
        System.out.println("Hamming distance : " + s1);  
        
        int i=0;
        int count=0;
        while(i<s1.length())
        {
            if(s1.charAt(i)=='1')
            {
              count++;
            }
            
            i++;
        }
        
        
        return count;
        
    }
      
}
