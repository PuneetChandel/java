package PRGCREEK;

/**
 *
 * @author pune7087
 */
public class reverseWordsinString {
    
    public static void main(String args[])
    {
        String s = "the sky is blue";
        //usingSplit(s);
        
        char[] str= s.toCharArray();
        usingreverse(str);
        
        for(char a : str)
            System.out.print(a);
    }
         
    
   static void usingreverse(char[] str)
   {
       int start=0;
       for(int i=0; i<str.length;i++)
       {
           if(str[i]==' ')
           {
               revereseString(str,start,i-1);
               start=i+1;
           }
       }
       // reverse last word
       revereseString(str,start,str.length-1);
       
       // reverese whole
       revereseString(str,0,str.length-1);
       
   }
   
   static void revereseString(char[] str, int left, int right )
   {
       
       while(left<right)
       {
           char temp=str[left];
           str[left]= str[right];
           str[right]=temp;
           left++;
           right--;
       }
       
   }
   
   
   static void usingSplit(String s)
   {
         String[] words = s.split(" ");
   
        StringBuffer sb = new StringBuffer();

        for(int i=words.length-1; i>=0;i--)
        {
            sb.append(words[i]);
            sb.append(" ");
        }
        System.out.print(sb);
   }
}
