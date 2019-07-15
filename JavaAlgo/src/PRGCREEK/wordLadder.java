package PRGCREEK;

/**
 *
 * @author pune7087
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
* 
 */

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

class WordNode{
    String word;
    int numSteps;
 
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
public class wordLadder {
    
    
    public static void main(String args[])
    {
        List<String> wordset= new ArrayList();
        wordset.add("hot");
        wordset.add("dot");
        wordset.add("dog");
        wordset.add("lot");
        wordset.add("log");
        //wordset.add("cog");
        
        
        String start = "hit";
        String end = "cog";
        wordLadder obj = new wordLadder();
        System.out.print(obj.ladderLength("hit", "cog", wordset));
    }
    
   public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        HashSet<String> dict = new HashSet(wordList);  
        if(!dict.contains(endWord)) return 0;
      
        Queue<WordNode> q = new LinkedList();
        q.add(new WordNode(beginWord,1));
      
        while(!q.isEmpty())
        {
            
            WordNode n = q.poll();
            
            String tempStr = n.word;
            
            if(tempStr.equals(endWord)) return n.numSteps;
            
            char[] charArr =tempStr.toCharArray();
            
            for(int i=0; i<charArr.length; i++)
            {
                
                for(char c='a'; c<='z'; c++ )
                {
                    char temp= charArr[i];
                    
                    if(charArr[i]!=c)
                        charArr[i]=c;
                    
                    String newWord = new String(charArr);
                    
                    if(dict.contains(newWord))
                    {
                        q.add(new WordNode(newWord,n.numSteps+1));
                        dict.remove(newWord);
                    }
                    charArr[i]= temp; // replace the char back after every check to return to original
                }
               
            }
            
        }
      
      return 0;
  
    }
    
    

    
}
