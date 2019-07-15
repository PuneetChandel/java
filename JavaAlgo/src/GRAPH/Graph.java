package GRAPH;

/**
 *
 * @author pune7087
 */

import java.util.List;
import java.util.ArrayList;

public class Graph {
    List<Node> vertices;
    
    Graph()
    {
        vertices= new ArrayList();
    }
    
    public List<Node> getVertices()
    {
        return vertices;
    }
    
    public void addVertex(Node n)
    {
        vertices.add(n);
        
    }
    
}
