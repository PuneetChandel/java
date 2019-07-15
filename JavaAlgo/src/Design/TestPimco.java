package Design;

/**
 *
 * @author pune7087
 */
public class TestPimco {
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        System.out.println("Hello");
        System.out.println("Taehee");
        
        int[] houses = new int[] {3, 4, 15, 17, 18, 22, 23, 24};
        int power = 3; // right direction
        int numberOfTransmitters = findNumberOfTransmitters(houses, power);
        System.out.println(numberOfTransmitters);
        
        houses = new int[] {2, 4, 5, 6, 9, 11, 12};
        power = 2;
        numberOfTransmitters = findNumberOfTransmitters(houses, power);
        System.out.println(numberOfTransmitters);
        
        
    }
    
    public static int findNumberOfTransmitters(int[] a, int power)
    {
        if(a.length==0 || a==null)
           return 0;
      
        int count =0;
        
        int i=0;
        
        while(i<a.length-1)
        {
            int tempPower = power;
            
            while(i<a.length && tempPower>=0)
            {
                if(i<a.length-1 && (a[i]+ tempPower < a[i+1])) // Not in range
                {
                    count++;
                    i++;// increase count
                    break;
                }
                else // with in range
                {
                    if(i<a.length-1)
                    {
                      tempPower = tempPower-(a[i+1] - a[i]); // reducing the power 
                      i++;
                    }
                }
               
            }
            
            i++;
        }
         
         return count;   
            
    }
    
}

