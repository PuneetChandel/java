/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;

/**
 *
 * @author pune7087
 * [3,4,2,1] +1 -> [3,4,2,2]
 * [3,4,2,9] +1 -> [3,4,3,0]
 */
public class add1toarraywithInt {
    
    public static void main(String[] args) {
        int a[]={8,9,4,9};
        add1(a);
      
     }
    
    public static void add1(int a[])
    {
          int sum = 0;
          int carry =1;
          int j =a.length-1;
          for(;j>=0;j-- )
          {
              sum=a[j]+carry;
              carry=sum/10;
              
              if(sum>=10)
                  a[j]=0;
              else
              {
                  a[j]=sum;break;
              }       
          }
          
          
        int newarr[]= new int[a.length+1];
        if(carry==1)// for edge case 9999
        {
            
            newarr[0]=1;
            for(int k =1; k<=a.length;k++)
            {
                newarr[k]=a[k-1];
            }
  
                
        }
           
     
        for(int k :a)
        {
            System.out.println(k);
        }
    }
}
