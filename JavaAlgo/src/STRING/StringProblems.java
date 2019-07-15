package STRING;

/**
 *
 * @author pune7087
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class StringProblems {
    
    public static void main(String args[])
    {
        String s="abcdcdc";
        
        System.out.println(LongestSubStrMostKDistinct(s));
        
        String []str= {"abc", "cab", "xyz", "pune", "zxy"};
        
        groupAnagrams(str);
        
                System.out.println("short palin : " + shortestPalindrome("aacecaaa"));

        System.out.println(reverseVowel("Puneet"));
        
       System.out.println(isAanagram("anagra", "gramana"));
       
       findAnagrams("cbaebabacd","abc");
        
    }
    
    public static int LongestSubStrNoRepetition(String s)
    {
        int result =1;
        HashSet<Character> set = new HashSet();

        int k=0;
        for(int i =0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(!set.contains(c))
            {
                set.add(c);
                result = Math.max(result, set.size());
            }
            else
            {
                // remove all chars from set till we reach to the char that got repeated to start new set.
                while(k<i)
                {
                    if(s.charAt(k)==c)
                    {
                        k++;
                        break;
                    }
                        
                    set.remove(s.charAt(k));
                    k++;
                }

            }
            
        }
        
        return result;
    }
    
    
    //Given a string, find the longest substring that contains only two unique characters. 
    //For example, given "abcbbbbcccbdddadacb", 
    //the longest substring that contains 2 unique character is "bcbbbbcccb".
    public static int LongestSubStrMostKDistinct(String s)
    {
        int result=1;
        //HashMap<Character,Integer> map= new HashMap();
        
        HashSet<Character> map= new HashSet();
       
        
        int k=0;
        int start=0;
        
        for(int i=0; i< s.length();i++)
        {
            char c= s.charAt(i);
      /*
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
*/
                map.add(c);
            
            if(map.size()>2)
            {
               result= Math.max(result,i-start);
               
               k = i-1;
               char x = s.charAt(i-1);
               while(k>=0)
               {
                  
                   k--;
                   start++;
                   if(s.charAt(k)!=x)
                   {
                       map.remove(s.charAt(k));
                       break;
                   }
                }
            }
        }
        
      result=Math.max(result,s.length()-start);
        
        return result;
        
    }
    
    public static void groupAnagrams(String strs[])
    {
        HashMap<String, ArrayList<String>> map= new HashMap();
        for(String s : strs)
        {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String sortStr=new String(a);
            
            if(map.containsKey(sortStr))
            {
                map.get(sortStr).add(s);
            }
            else
            {
                ArrayList<String> ar = new ArrayList();
                
                map.put(sortStr, ar);
                ar.add(s);
             }
            
           }
        
        for(Map.Entry<String, ArrayList<String>> m : map.entrySet())
        {
            int size = m.getValue().size();
            if(size>1)
            {
            for(int i=0; i< size;i++)
                System.out.println(m.getValue().get(i));
            }
           }
    }
    
       public static String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int j=s.length(); j>0; j--)
        {
            if(!isPalin(s.substring(0,j)))
                sb.append(s.charAt(j-1));
            else
                break;
        }
        
        return sb.toString();
    }
    
    public static boolean isPalin(String s)
    {
        int i=0;
        int j =s.length()-1;
        
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            
            i++;
            j--;
        }
        return true;
    }

    
    public static String reverseVowel(String s)
    {

       char[] c= s.toCharArray();
       
       int i=0;
       int j = c.length-1;
       
       while(i<j)
       {
           if(!isVowel(c[i]))
               i++;
           if(!isVowel(c[j]))
               j--;
           if(isVowel(c[i]) && isVowel(c[j]))
           {
               char temp = c[i];
               c[i]= c[j];
               c[j]= temp;
               i++;
               j--;
           }
           
       }
       
       return new String(c);
      
        
    }
    
    public static boolean isVowel(char c)
    {
        return (c =='a' || c =='e' || c =='i' || c =='o' || c =='u');
    }
    
    public static boolean isAanagram(String s1, String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        
        int[] a = new int[26];
        

        for(int i =0; i<s1.length();i++)
            a[s1.charAt(i)-'a']++;
        
        for(int i =0; i<s2.length();i++)
            a[s2.charAt(i)-'a']--;
      
        for(int x:a)
        {
            if(x!=0)
                return false;
        }
        
        return true;
        
    }
    
    
      public static void findAnagrams(String s, String p) {
        ArrayList<Integer> result= new ArrayList();
        
        if(s.length()==0 || s==null || p.length()==0 || p==null || s.length()< p.length())
            return ;
        
        int[] p_arr = new int[26];
        
        HashSet<Character> set= new HashSet();
        
        for(int i =0; i< p.length(); i++)
            set.add(p.charAt(i));
        
        
        for(int i=0; i< p.length(); i++)
            p_arr[p.charAt(i)-'a']++;
        
        
        
        for(int i=0; i<=s.length()-p.length(); i++)
        {
            char c= s.charAt(i);
            if(set.contains(c))
            {
                int[] s_arr= new int[26];
                String temp=s.substring(i,i+p.length());
                for(int j=0; j< temp.length(); j++)
                    s_arr[temp.charAt(j)-'a']++;
                
                if(isAnagramUtil(p_arr,s_arr))
                    result.add(i);
            }
        }
                    
       System.out.print(result);
    }
      
      public static boolean isAnagramUtil(int a[], int b[])
      {
          for(int i=0; i<a.length;i++)
          {
              if(a[i]!=b[i])
                  return false;
          }
          return true;
      }
      
    
}
