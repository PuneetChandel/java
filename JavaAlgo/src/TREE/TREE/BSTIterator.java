package TREE;

/**
 *
 * @author pune7087
 */
import java.util.*;


class BSTIterator {

    Queue<Integer> q;
    
  
    
    public static void main(String[] args)
    {
      
        
        Node tree = new Node(8);
        BinarySearchTree.insertNodeNew(4, tree);
        BinarySearchTree.insertNodeNew(10, tree);
        BinarySearchTree.insertNodeNew(3, tree);
        BinarySearchTree.insertNodeNew(6, tree);
        BinarySearchTree.insertNodeNew(9, tree);
        BinarySearchTree.insertNodeNew(12, tree);
        
        //BSTSolutions.inOrderRec(tree);
        BSTIterator bt = new BSTIterator(tree);
        System.out.println(bt.hasNext());
        System.out.println(bt.next());
        System.out.println(bt.hasNext());
        System.out.println(bt.next());
        
          
    }
    
    public BSTIterator(Node root) {
     
        q = new LinkedList();
        BSTInOrder(root);
    }
    
   public void BSTInOrder(Node root)
    {
        if(root!=null)
        {
            BSTInOrder(root.left);
              q.offer(root.data);
            BSTInOrder(root.right);
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        if(!q.isEmpty())
            return q.poll();
        else
            return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

