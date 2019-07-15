package Design;

/**
 *
 * @author pune7087
 */
import java.util.*;
public class TinyURL {
    
     Map<String, String> map = new HashMap<String,String>();
     static final String TINYURL = "http:/tinyURL/"; 
     
     String set = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
     Random r = new Random();
     
     String key = genKey();
     
     public String genKey()
     {
         StringBuffer sb = new StringBuffer();
         // lets consider till 6 length . That will give 6^62
         
         for(int i=0; i< 6; i++)
         {
             int k = r.nextInt(62);
             sb.append(set.charAt(k));
         }
         return sb.toString();
     }
     
      public String encode(String longUrl) {
          
          while(map.containsKey(key))
              key = genKey();
          
          map.put(key, longUrl);
          return TINYURL+key;

      }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace(TINYURL, ""));
    }
    
    public static void main(String args[])
    {
       TinyURL t1= new TinyURL();
       String shortUrl = t1.encode("www.yahoo.com/puneet/gdfgsgg");
       System.out.println(shortUrl);
       
       System.out.println(t1.decode(shortUrl));
       
    }
}
