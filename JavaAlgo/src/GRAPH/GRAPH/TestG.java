package GRAPH;

/**
 *
 * @author pune7087
 */
import java.util.LinkedList;
import java.util.List;

import java.util.Stack;
import java.util.Queue;
import java.util.Iterator;


public class TestG {
    int V;
    LinkedList<Integer>[] adj;
    
    TestG(int V)
    {
       this.V= V;
       adj= new LinkedList[V];
       
       for(int i=0; i< V; i++)
       {
           adj[i]=new LinkedList<Integer>();
       }
    }
    
    public void addEdge(int a, int b)
    {
        adj[a].add(b);
    }
    
    public List<Integer> BFS(int V)
    {
        List<Integer> result = new LinkedList();
        boolean[] visited = new boolean[this.V];
        
        Queue<Integer> q = new LinkedList();
        q.add(V);
        
        while(!q.isEmpty())
        {
            int vertex = q.poll();
            
            if(!visited[vertex])
              result.add(vertex);
            
            visited[vertex]= true;
            
            
            LinkedList<Integer> l = adj[vertex];
            Iterator it = l.iterator();
            
            while(it.hasNext())
            {
                int temp = (int)it.next();
                if(!visited[temp])
                  q.add(temp);
            }
        }
        return result;
    }
    
      public List<Integer> DFS(int V)
    {
        List<Integer> result = new LinkedList();
        boolean[] visited = new boolean[this.V];
        
        Stack<Integer> s = new Stack();
        s.push(V);
        
        while(!s.isEmpty())
        {
            int vertex = s.pop();
            
            if(!visited[vertex])
              result.add(vertex);
          
            visited[vertex]= true;            
            Iterator it = adj[vertex].iterator();
            
            while(it.hasNext())
            {
                int temp = (int)it.next();
                if(!visited[temp])
                  s.push(temp);
            }
        }
        return result;
    }
    
   
    public boolean isCycle(int v)
    {
        boolean[] visited = new boolean[this.V];
        boolean[] recStack = new boolean[this.V];
        
        return isCycleUtil(v,visited,recStack);                 
    }
    
    public boolean isCycleUtil(int v, boolean[] visited, boolean[] recStack)
    {
        
      //  if(recStack[v])
      //     return true;
    
   // if(visited[v])
    //       return false;
    
        recStack[v]= true;
        visited[v]= true;
        
        Iterator it = adj[v].iterator();
        
        while(it.hasNext())
        {
            int temp= (int)it.next();
            
            if(recStack[temp]==true)
                return true;
            
    
                if(isCycleUtil(temp,visited,recStack))
                   return true;
        }
        
        recStack[v]= false;
        return false;
    }
    
    
      
    public boolean findRoute(int a, int b)
    {
        boolean[] visited = new boolean[this.V];   
        Queue<Integer> q = new LinkedList();
        q.offer(a);
        
        while(!q.isEmpty())
        {
            int vertex = q.poll();
            if(vertex==b)
                return true;
            
            visited[vertex]=true;
            
            Iterator it = adj[vertex].iterator();
            while(it.hasNext())
            {
                int temp=(int)it.next();
                if(!visited[temp])
                  q.offer(temp);
            }
        
        }
        return false;
    }
         
       public List<Integer> DFSRec(int v)
    {
        List<Integer> result = new LinkedList();
        boolean[] visited = new boolean[this.V];
        
        DFSUtil(result,v,visited);
        return result;
    }    
    public List<Integer> DFSUtil(List<Integer> result,int v, boolean[] visited)
    {
        if(!visited[v])
            result.add(v);
        
        visited[v]= true;
        
        LinkedList<Integer> l = adj[v];
        Iterator it = l.iterator();
            
         while(it.hasNext())
            {
                int temp = (int)it.next();
                if(!visited[temp])
                  DFSUtil(result,temp,visited);
            }
         
         return result;
    }
    
     public static void main(String args[])
    {
        TestG g= new TestG(7);
        
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 5); 
        
        g.addEdge(1, 6); 
        g.addEdge(1, 5); 
        g.addEdge(2, 3); 
        g.addEdge(3, 4); 
        g.addEdge(6, 0); 
        
        for(int a : g.DFS(0))
            System.out.print(" " + a + " ");
           
         System.out.println("");
         System.out.println("  ");
         
        for(int a : g.BFS(0))
           System.out.print(" " + a + " ");
        
       System.out.println("  ");
       System.out.println("  ");
        
       System.out.println(" findRoute " + g.findRoute(0,4));   
      
       System.out.println(" isCycleUtil " + g.isCycle(0));   
       
        
    }
     
    
}
