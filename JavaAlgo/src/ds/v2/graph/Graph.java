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
public class Graph {
    // List of vertices for a Graph
    List<Node> vertices;
    
    Graph()
    {
        vertices= new ArrayList<Node>();
    }
    
    
    public void addVertex(Node n)
    {
        vertices.add(n);
    }
    // return all vertices for a graph
    public List<Node> getVertices()
    {
        return vertices;
    }
    
}
