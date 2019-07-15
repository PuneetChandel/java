package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class ValidPalindrome {
    
    public static void main(String []args)
    {
        String s ="Red rum, sir, is murders";
        
        // replace  all non alpha chars 
        String k =s.replaceAll("[^a-zA-Z0-9]", "");
        boolean isPalin= true;
        
        for(int i=0,j=k.length()-1; i<j;i++,j--)
        {
            if(k.charAt(i)!=k.charAt(j))
            {
                isPalin=false;
                break;
            }
                
        }
        
        if(isPalin)
        System.out.println("Palindrom");
        else
        System.out.println("Not a palindrom");
    }
    
}
