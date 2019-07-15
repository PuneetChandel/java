/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicPrg;
import java.util.*;

/**
 *
 * @author pune7087
 */
public class findsubArraywithSum {
    
    public static void main(String[] args) {
        int a[]={1,2,5,6,8,9};int sum=10;  
        
        System.out.print(findsubArrrec(a,sum,a.length-1));
        
    }
    public static void findsubArray(int a[], int sum)
    {
      ArrayList<ArrayList> res= new ArrayList<ArrayList>();
      ArrayList<Integer> alist = new ArrayList<Integer>();
      int maxflag =0;
      for(int i=0;i<a.length;i++)
      {
          int tempsum=a[i];
          alist=new ArrayList();
          alist.add(a[i]);
          for(int j=i+1;j<a.length;j++)  // int a[]={1,2,3,4,5,6,8,9,10};int sum=10;  
          {
              
              if(tempsum+a[j]<sum)
              {
                 tempsum=tempsum+a[j];
                  alist.add(a[j]);   
              }
              else if(tempsum+a[j]==sum)
              {
                  alist.add(a[j]); 
                  res.add(alist);
                  alist=new ArrayList();
                  tempsum=a[i];
                  alist.add(a[i]);
              }
              else
              {
                 tempsum=a[i]; 
              }
               
           }
                  
          }
      
      for(ArrayList a1 : res)
      {
          for(Object i : a1)
          {
              System.out.print(i + ":");
          }
          System.out.println("\n"+"************");
      }
          
      }
      
        
    //https://www.youtube.com/watch?v=nqlNzOcnCfs&t=708s
    public static int findsubArrrec(int a[], int sum, int idx)
    {
           if(sum==0) // we will also reach here when we find a mathcing sub array
             return 1;
           else if(sum<=0)
               return 0;
           else if(idx<0)
               return 0;
           else if(a[idx]>sum)
               return findsubArrrec(a,sum,idx-1);
           //if sum is less than the number , we cannot find using that number so ignore that number
           else
           {
               return findsubArrrec(a,sum-a[idx],idx-1) + findsubArrrec(a,sum,idx-1);
               // at every step we have option to include a number or exclude that from the set
               // if include the sum needs to be adjusted sum-a[idx] and move back
               // if exclude just move back
           }
           
    }
    
    }
    

