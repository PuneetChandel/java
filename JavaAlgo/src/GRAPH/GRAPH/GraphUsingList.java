package GRAPH;

/**
 *
 * @author pune7087
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import java.util.*;

public class GraphUsingList {
    
    int V;// count of vertices
    LinkedList<Integer> adj[];
    
    GraphUsingList(int v)
    {
        V=v;
        adj= new LinkedList[V];
        
        // initialize adjacency List
        for(int i=0; i<V;i++)
        {
            adj[i]= new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int v1, int v2)
    {
        adj[v1].add(v2);
    }
    
    // queue
    public List<Integer> BFS(int v)
    {
       Queue<Integer> q = new LinkedList();
       // false by default in java) 
       boolean[] visited = new boolean[V];
       List<Integer> result= new ArrayList();
       
       
       q.add(v);
       
       while(!q.isEmpty())
       {
           int vertex=q.poll();
           
            if(!visited[vertex])
              result.add(vertex);

           visited[vertex]= true;
           Iterator it = adj[vertex].iterator();
           while(it.hasNext())
           {
               vertex=(int)it.next();
               if(!visited[vertex])
                    q.add(vertex);
           }
           
       }
       return result;
       
    }
    
    public Stack<Integer> topSort(int v)
    {
       boolean[] visited = new boolean[V];
       Stack<Integer> stack = new Stack();
       
       // we need loop as there might be nodes not reachable
       for(int i=0; i< V; i++)
       {
           if(!visited[i])
           topSortUtil(i,stack,visited);
       }
           
       return stack;
    }

      
    public void topSortUtil(int v,Stack stack, boolean[] visited)
    {
        visited[v]= true;
        
        Iterator it = adj[v].iterator();
        while(it.hasNext())
        {
            int vert= (int)it.next();
            if(!visited[vert])
                topSortUtil(vert,stack,visited);
            
        }
        
        stack.push(v);

    }
    
    public boolean isCyclic()
    {
        boolean visited[]= new boolean[V];
        boolean recStack[]= new boolean[V];
        
       for(int i=0; i< V; i++)
       {
           if (findCycleUtil(i,visited,recStack))
               return true;
       }
          
       return false;
        
    }
    
    public boolean findCycleUtil(int v, boolean visited[], boolean recStack[])
    {
        
        if(recStack[v])
            return true;
        
          if(visited[v])
            return false;
          
        recStack[v]= true;
        visited[v]= true;
        
        Iterator it = adj[v].iterator();
        
        while(it.hasNext())
        {
            int vert= (int) it.next();
            if(findCycleUtil(vert,visited,recStack))
                return true;
            
        }
        
        recStack[v]=false;
        
        return false;
    }
    
    public List<Integer> DFSUtil(int v, boolean[] visited,List<Integer> result)
    {
        result.add(v);
        visited[v]=true;
        Iterator it = adj[v].iterator();
        while(it.hasNext())
        {
            int vert=(int)it.next();
            if(!visited[vert])
                DFSUtil(vert,visited,result);
        }
        
        return result;
    }
    
    // recursion
     public List<Integer> DFS(int v)
    {
    
       // false by default in java) 
       boolean[] visited = new boolean[V];
       List<Integer> result= new ArrayList();
       
       result = DFSUtil(v,visited,result);
       return result;
       
    }
     
       public List<Integer> DFSItr(int V)
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
       
    public boolean findRoute(int v, int end)
    {
       Queue<Integer> q = new LinkedList();
       // false by default in java) 
       boolean[] visited = new boolean[V];
    
       
       q.add(v);
       
       while(!q.isEmpty())
       {
           int vertex=q.poll();
            if(vertex==end)
                return true;
            
            visited[vertex]= true;
           
           Iterator it = adj[vertex].iterator();
           while(it.hasNext())
           {
               vertex=(int)it.next();
               if(!visited[vertex])
                    q.add(vertex);
           }
           
       }
       return false;
       
    }
    
    public static void main(String args[])
    {
        GraphUsingList g= new GraphUsingList(7);
        
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(0, 5); 
        
        g.addEdge(1, 6); 
        g.addEdge(1, 5); 
        g.addEdge(2, 3); 
         g.addEdge(2, 6); 
        g.addEdge(3, 4); 
        
        System.out.println(" BFS ");
        for(int a : g.BFS(0))
            System.out.print(" " + a + " ");
         System.out.print(" ------ ");
        System.out.println(" ------ ");
         
        System.out.println(" Find route ");
        System.out.println(g.findRoute(0, 5));
        
        System.out.println(" DFS ");
        
        for(int a : g.DFS(0))
            System.out.print(" " + a + " ");
            System.out.println(" ------ ");
        Stack<Integer> s = g.topSort(0);
        System.out.println(" Top Sort ");
        while(!s.isEmpty())
        {
            System.out.print(" " + s.pop() + " ");
        }
        
         GraphUsingList graph= new GraphUsingList(7);
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        //graph.addEdge(3, 3); 
        
           System.out.println(" Check cycle ");
        System.out.println(graph.isCyclic());
        
         System.out.println(countComponents(2,new int[][]{{1,0}}));
        
    }
    

     public static int countComponents(int n, int[][] edges) {
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        
        for(int[] list : edges)
        {
            if(!map.containsKey(list[0]))
            {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(list[1]);
                map.put(list[0],a);
            }
            else
                map.get(list[0]).add(list[1]);
        }
        
        boolean[] visited = new boolean[n];
        int count =0;
        for(int i=0; i<n;i++)
        {
            if(!visited[i])
            {   count++;
                traverse(map,i,visited);
            }
        }
        
        return count;
        
    }
    
    public static void traverse(HashMap<Integer,ArrayList<Integer>> map, int v, boolean[] visited)
    {
            visited[v]= true;
        
        if(map.containsKey(v))
        {
            Iterator it = map.get(v).iterator();
            
            while(it.hasNext())
            {
                int temp = (int)it.next();
                if(!visited[temp])
                  traverse(map,temp,visited);
            }
        }
        
    }
}
