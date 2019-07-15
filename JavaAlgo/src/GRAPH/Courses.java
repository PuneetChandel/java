package GRAPH;

/**
 *
 * @author pune7087
 */
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    if(prerequisites == null)
        return false;
 
    if(numCourses == 0 || prerequisites.length == 0)
        return true;
 
    //track visited courses
    boolean[] visit = new boolean[numCourses];
    boolean[] recStack = new boolean[numCourses];
 
    // use the map to store what courses depend on a course 
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        
    for(int[] a: prerequisites){
        
        if(map.containsKey(a[0])){
            map.get(a[0]).add(a[1]);
        }
        else
        {
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(a[1]);
            map.put(a[0], l);
        }
    }
 
    for(int i=0; i<numCourses; i++){
        if(canFinishDFS(map, visit,recStack, i))
            return false;
    }
 
    return true;
}
 
 // we are just checking the cycle
private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, boolean[] visit,boolean[] recStack, int i){
    
    if(recStack[i])  return true; // we reached same node in recursion that means cycle
    if(visit[i]) return false; // just to keep trying next and skip this

    visit[i]=true; // mark as -1 and check if we reach same during recursion
    recStack[i]= true;
    
    if(map.containsKey(i)){
        for(int j: map.get(i)){
            if(canFinishDFS(map, visit,recStack, j)) 
                return true;
        }
    }

    recStack[i]= false; 
    return false;
}
    
}
