/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morealgo;


public class PalindromPermutation {
 
    public static void main(String args[])
    {
        PalindromPermutation sa= new PalindromPermutation();
        System.out.println(" Check Palindrom in permutation :: " + sa.checkpalinpermutation("abccbaxxcceeeeq  xx"));
    }
    
    private boolean checkpalinpermutation(String s)
    {
        int freqarr[]= createfreqTable(s);
        return  checkMaxOneOddfreq(freqarr);
    }
    
    private int[] createfreqTable(String s)
    {
        // size of array equals to alphabets count
        int freqtab[]= new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
        int a = Character.getNumericValue('a');    
        int z = Character.getNumericValue('z');
    
        int val=0;
        for(char x: s.toCharArray())
        {
            val = Character.getNumericValue(x);
            if(val >= a && val<=z )
                freqtab[val-a]++;
        }
        
        return freqtab;
    }
    private boolean checkMaxOneOddfreq(int freqtab[])
    {
        boolean oddFreq = false;
        
        for(int frq:freqtab)
        {
            if(frq %2 ==1)
            {
                if(oddFreq) // already found one odd
                    return false;
            oddFreq=true;
            }
            
        }
        return true; // only one odd or no odd
    }
            
    
}
