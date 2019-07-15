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
public class TowerHopper {
    
    public static void main(String[] args) {
        int a[]={1,2,2,0,2,0};
        System.out.print(isHoppable(a));
        
    }
    
    public static boolean isHoppable(int a[])
    {
        int nextTower=0;
        int k=0;
        for(int i=0;i<a.length;)
        {
            
            if(nextTower > a.length-1)
                return true;
            if(nextTower==i)
                return false;
            i=nextTower;
        }
        return false;
    }
    
    public static int findnextStep(int a[],int i)
    {
        int k = a[i];
        if(a[i]<=0)
            return 0;
        if(a[k+i]>0)
            return k+i;
       
        return findnextStep(a,i-1);
    }
}
