/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.v2.graph;
import java.util.ArrayList;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author pune7087
 */
public class GraphSolutions {
    

       /**
        a->B,f
        *b->c
        * c->d,e

        **/

    
    public static void main(String[] args)
    {
         Graph g = new Graph();
        
         Node[] temp = new Node[6];
        
        temp[0] = new Node("a");
        temp[1] = new Node("b");
        temp[2] = new Node("c");
        temp[3] = new Node("d");
        temp[4] = new Node("e");
        temp[5] = new Node("f");
        
        for(Node n :temp )
            g.addVertex(n);
        
        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[5]);
        temp[1].addAdjacent(temp[2]);
        temp[2].addAdjacent(temp[3]);
        temp[2].addAdjacent(temp[4]);  
        
       //System.out.println("Route check : "+ findRoute(temp[1], temp[5]));
       traverseBFS(temp[0]);
    }
    
    // BFS uses LinkList 
    public static void traverseBFS(Node start)
    {
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        
      while(!q.isEmpty())
      {
            Node temp=q.poll();
            
            if(!temp.visited)
            {
                System.out.println(" "+temp.getVertex());
                temp.visited=true;
            }
            
            List<Node> adj=temp.getAdjacent();
            for(Node n : adj)
                q.add(n);
      } 
    }
    
    // find Route using BFS
    public static boolean findRoute(Node start, Node end)
    {
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(start);
        
      while(!q.isEmpty())
      {
            Node temp=q.poll();
            
            if(!temp.visited)
            {
                if(temp==end)
                    return true;
                temp.visited=true;
            }
            
            List<Node> adj=temp.getAdjacent();
            for(Node n : adj)
                q.add(n);
      }
      return false;
    }
   
    

      
    // DFS uses recursion
    public static void traverseDFS(Node start)
    {
           if(!start.visited)
                System.out.println(" "+start.getVertex());
           
           start.visited=true;
           
           for(Node n : start.getAdjacent())
               traverseDFS(n);
    }
  
    
    
   
  
      
    

  
}
