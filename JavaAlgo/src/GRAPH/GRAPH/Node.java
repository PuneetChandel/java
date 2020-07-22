package GRAPH;

/**
 *
 * @author pune7087
 */

import java.util.List;
import java.util.ArrayList;

public class Node {

    String vertex; // data
    List<Node> adjacent;
    boolean isVisited= false;
    
    Node(String vertex)
    {
        this.vertex=vertex;
        adjacent= new ArrayList();
    }
    
    
    public List<Node> getAdjacentList()
    {
        return adjacent;
    }
    
    public void addAdjacentNode(Node n)
    {
        adjacent.add(n);
    }
    
}
