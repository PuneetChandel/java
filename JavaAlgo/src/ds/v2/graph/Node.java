/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.v2.graph;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pune7087
 */
public class Node {
    private String vertex;
    // adjacency List of all Nodes adjacent to a node
    private List<Node> adjacent;
    // to flag if node is visited
    boolean visited=false;
    
    public Node(String vertex)
    {
        this.vertex=vertex;
        adjacent = new ArrayList<Node>();
      
    }
    
    public void addAdjacent(Node n)
    {
        adjacent.add(n);
    }
    
    // return adjacent list for a Node
    public List<Node> getAdjacent() {
        return adjacent;
    }
    // data for a Node/vertex
    public String getVertex() {
        return vertex;
    }
    
}
