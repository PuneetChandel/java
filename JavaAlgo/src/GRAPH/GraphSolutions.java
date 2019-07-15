package GRAPH;

/**
 *
 * @author pune7087
 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GraphSolutions {
    
     public static void main(String[] args)
    {
         Graph g = new Graph();
        
         Node[] temp = new Node[7];
        
        temp[0] = new Node("a");
        temp[1] = new Node("b");
        temp[2] = new Node("c");
        temp[3] = new Node("d");
        temp[4] = new Node("e");
        temp[5] = new Node("f");
        
        for(Node n :temp )
            g.addVertex(n);
        
        temp[0].addAdjacentNode(temp[1]);
        temp[0].addAdjacentNode(temp[5]);
        temp[1].addAdjacentNode(temp[2]);
        temp[2].addAdjacentNode(temp[3]);
        temp[2].addAdjacentNode(temp[4]);  
       
        //System.out.println(" DFS  ");
        //DFS(temp[0]);
        System.out.println("");
        //System.out.println(" BFS  ");
        //BFS(temp[0]);
        System.out.println("");
        System.out.println(" FindPath (temp[1], temp[4])  "+ findPath(temp[1], temp[5]));
        
        
        Graph tg= new Graph();
        
        temp[0] = new Node("a");
        temp[1] = new Node("b");
        temp[2] = new Node("c");
        temp[3] = new Node("d");
        temp[4] = new Node("e");
        temp[5] = new Node("f");
        temp[6] = new Node("g");
        
        for(Node n :temp )
            tg.addVertex(n);
        
        temp[0].addAdjacentNode(temp[2]);
        temp[2].addAdjacentNode(temp[0]);
        temp[1].addAdjacentNode(temp[2]);
        temp[1].addAdjacentNode(temp[3]);
        temp[2].addAdjacentNode(temp[4]);
        temp[3].addAdjacentNode(temp[5]);
        temp[4].addAdjacentNode(temp[5]);
        temp[5].addAdjacentNode(temp[6]);  
        
        
         System.out.println("");
         System.out.println("TOPOLOGY SORT");
        Stack<Node> stack = topologySort(tg);
        
        while(!stack.isEmpty())
        {
            System.out.print(" "+ stack.pop().vertex + "  ");
        }
          
        
        
    }
     //https://www.youtube.com/watch?v=ddTC4Zovtbc
     public static Stack<Node> topologySort(Graph g)
     {
         // Set to track visited Nodes
         HashSet<Node> visited = new HashSet();
         // Nodes in sorted order
         Stack<Node> stack = new Stack();
         
         // GET ALL VERTICES AND FOR EACH VERTICES CALL THE SORT
         for(Node n : g.getVertices())
         {
             if(visited.contains(n))
                 continue;
            topsortUtil(n,stack,visited);
         }
         
         return stack;
     }
     
     public static void topsortUtil(Node n,Stack<Node> stack,HashSet<Node> visited)
     {
         visited.add(n);
         
         for(Node x : n.getAdjacentList())
         {
             if(visited.contains(x))
                 continue;
             // RECURSIVELY PUT EACH ADJACENT NODE TO STACK
             topsortUtil(x,stack,visited);
         }
         // stack will have all in bottom to top as recursive call will add from bottom
         stack.push(n);
         
     }
     
     public static void DFS(Node root)
     {
         if(root== null)
             return;
         
         System.out.print("  " + root.vertex + " : " );
         root.isVisited=true;
         
         for(Node n : root.getAdjacentList())
         {
             if(!n.isVisited)
               DFS(n);
         }              
     }
     
     
     public static List<String> createIten(String[][] tickets)
     {
         HashMap<String,PriorityQueue> map = new HashMap();
         //PriorityQueue<String> q = new PriorityQueue();
         LinkedList<String> result= new LinkedList<String>();
         
         for(String[] ticket: tickets)
         {
             if(!map.containsKey(ticket[0]))
             {
                 // if doesnt exist in map/graph create a new PQ and add
                 PriorityQueue<String> q = new PriorityQueue();
                 q.add(ticket[1]);
                 map.put(ticket[0], q);
             }
             else
                 // if already exist add to the same starting Point
                 map.get(ticket[0]).offer(ticket[1]);
         }
         
         sortIten("JFK",result,map);
         return result;
         
     }
     
       public List<String> findItinerary(List<List<String>> tickets) {
        
        HashMap<String,PriorityQueue<String>> iten = new HashMap<>();
        
        List<String> result = new ArrayList();
        
        for(List l : tickets)
        {
            
            if(!iten.containsKey(l.get(0)))
            {
                PriorityQueue<String> pq = new PriorityQueue();
                pq.offer((String)l.get(1));
                iten.put((String)l.get(0),pq);
            }
            else
            {
                PriorityQueue<String> pq = iten.get((String)l.get(0));
                pq.offer((String)l.get(1));
            }
        }
        
        Queue<String> q = new LinkedList();
        q.add("JFK");
        
        HashSet<String> visited = new HashSet();
        
        while(!q.isEmpty())
        {
            String temp = q.poll();
            result.add(temp);
            visited.add(temp);
            
            PriorityQueue<String> pq = iten.get(temp);
            for(int i=0; i< pq.size();i++)
            {
                String s = pq.poll();
                if(!visited.contains(s))
                    q.offer(s);
            }
            
        }
        
        return result;
    }
       
     public static void sortIten(String origin,LinkedList<String> result,HashMap<String,PriorityQueue> map)
     {
        PriorityQueue<String> q = map.get(origin);
        
        while(!q.isEmpty())
        {
            sortIten(q.poll(),result,map);
        }
        
        result.addFirst(origin);
        
     }
     
     
     public static void BFS(Node root)
     {
         Queue<Node> q = new LinkedList();
         
         if(root==null)
             return;
         
         q.add(root);
         
         while(!q.isEmpty())
         {
             Node n = q.poll();
             System.out.print("  " + n.vertex + " : " );
             n.isVisited=true;
             
             for(Node t : n.getAdjacentList())
             {
                 if(!t.isVisited)
                 q.add(t);
             }
             
         }
         
     }
     

     public static boolean findPath(Node start, Node end)
     {
         Queue<Node> q = new LinkedList();
         
         q.add(start);
         
         while(!q.isEmpty())
         {
             Node temp = q.poll();
             if(temp==end)
                 return true;
             
             temp.isVisited=true;
             
             for(Node n : temp.getAdjacentList())
             {
                 if(!n.isVisited)
                     q.add(n);
             }
             
         }
         
         return false;
     }

     public static Node cloneGraph(Node root)
     {
         if(root==null)
             return null;
         
         HashMap<Node,Node> map = new HashMap();
         Queue<Node> q = new LinkedList();
         
         q.add(root);
         map.put(root, new Node(root.vertex));
         
         while(!q.isEmpty())
         {
             Node temp = q.poll();
             
              for(Node adj : temp.getAdjacentList())
              {
                  if(!map.containsKey(adj))
                  {
                      map.put(adj, new Node(adj.vertex));
                      q.add(adj);
                  }
                  map.get(temp).getAdjacentList().add(map.get(adj));
              }
              
             
         }
         
         return map.get(root);
     }

//https://www.youtube.com/watch?v=ddTC4Zovtbc
     
}
