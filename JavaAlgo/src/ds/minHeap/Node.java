/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.minHeap;

/**
 *
 * @author pune7087
 */
public class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
