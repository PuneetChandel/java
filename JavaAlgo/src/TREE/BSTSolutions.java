package TREE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import java.util.Queue;

public class BSTSolutions {

    static int count;
    static int res;
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode(8);
        bst.insertNode(4);
        bst.insertNode(10);
        bst.insertNode(3);
        bst.insertNode(6);
        bst.insertNode(9);
        bst.insertNode(12);

        ///
        Node tree = new Node(8);
        BinarySearchTree.insertNodeNew(4, tree);
        BinarySearchTree.insertNodeNew(10, tree);
        BinarySearchTree.insertNodeNew(3, tree);
        BinarySearchTree.insertNodeNew(6, tree);
        BinarySearchTree.insertNodeNew(9, tree);
        BinarySearchTree.insertNodeNew(12, tree);
        
        Node bt = new Node(1);
        Node btfirst = new Node(2);
        Node btsec = new Node(2); 
        bt.left=btfirst;
        bt.right=btsec;
        Node btfirst1 = new Node(3);
        Node btsec1 = new Node(4); 
        btfirst.left=btfirst1;
        btfirst.right=btsec1;
        
        //Node btfirst2 = new Node(4);
        Node btsec2 = new Node(3); 
        
        //btsec.left=btfirst2;
        btsec.right=btsec2;
        
        
        //BinarySearchTree.insertNodeNew(22, tree);
        //BinarySearchTree.insertNodeNew(5, tree);
        //  BinarySearchTree.insertNodeNew(2, tree);
        //    BinarySearchTree.insertNodeNew(1, tree);
        //      BinarySearchTree.insertNodeNew(0, tree);
        //   bst.inOrder(bst.root);
        //   System.out.println(" In Order 1 : ");
        //   BinarySearchTree.inOrder(tree);
        //   System.out.println("");
      
        System.out.println(" Is symmetric  : " + isSymmetricRec(bt.left, bt.right));
          
        
        System.out.println(" Min depth of tree  : " + minDepthTree(tree));

        System.out.println(" maxPathSum of tree  : " + maxPathSum(tree));
        
        
        
        System.out.println(" In Order  : ");

        List<Integer> result = inOrderTraversal(tree);

        for (Integer a : result) {
            System.out.print(" " + a + "  ");
        }


        System.out.println("");
        
        
        // bst.preOrder(bst.root);
        System.out.println("");
        //System.out.println("Pre Order :  Test");
        //BinarySearchTree.preOrder(tree);

        allNodeswithSum(tree,18);
        
        System.out.println("count "  + count1);
        
        System.out.println("Pre Order :  ");
        result = preOrderTraversal(tree);

        for (Integer a : result) 
            System.out.print(" " + a + "  ");
        
        System.out.println("");
        System.out.println("Post Order :  ");
        //result = postOrderTraversal(tree);
            PostOrderRec(tree);
        //for (Integer a : result) {
        //    System.out.print(" " + a + "  ");
        //}

        
        System.out.println("");

        // bst.postOrder(bst.root);
        //                System.out.println("");
        //   BinarySearchTree.postOrder(tree);
        //   System.out.println("");
        //   result = postOrderTraversal(tree);
        //for(Integer a: result)
        //    System.out.print(" "+ a+ "  ");
        // System.out.println("");
        // bst.postOrder(bst.root);
        //                System.out.println("");
        System.out.println(" Level Order ");
        result = levelOrderTraversal(tree);

        for (Integer a : result) 
            System.out.print(" " + a + "  ");
        

         System.out.print(" Right Side view  : ");
         
        for(Integer x : rightSideView(tree))
            System.out.print(" " + x + "  ");
                
        //System.out.println("");
        //System.out.println(" Invert BST ");
        //Node root = invertTree(tree);

        //result = levelOrderTraversal(tree);
        
        //for (Integer a : result) 
         //   System.out.print(" " + a + "  ");
        
        
        //System.out.println(" Level Order 2");
        //BinarySearchTree.BFSorLevelOrder(tree);
        //bst.deleteNode(10);
        //bst.display(bst.root);
        //int a[] = {1,2,3,4,5,6,7,8};
        //Node root= minBST(a,0,a.length-1);
        System.out.println("------------------------");
        System.out.println(" heightOfTree : " + heightTree(tree) + " heightOfTree " + heightOfTree(tree) +
                "  Height  " + heightOfTree2(tree));

        System.out.println("------------------------");

        /*   System.out.println( "Invert Tree "  );
                  invertTreeItr(tree);

                result = levelOrderTraversal(tree);
                
                for(Integer a: result)
                    System.out.print(" "+ a+ "  ");
         */
        System.out.println("kthSmallest Tree " + kthSmallest(tree, 2));
        
        //System.out.println("kthSmallest Tree using recursion " );
        kthSmallestRec(tree, 2);
        
        System.out.println("kthLargest Tree " + kthLargest(tree, 6));
        
          System.out.println("pathSum Tree : " + pathSum(tree, 18) + " haspathSum : " + haspathSum(tree,18));
        
          int a[]= {3,4,6,8,9,10,12};
          Node tree2=createTreeFromSortedArray(a,0,a.length-1);
          
            result = levelOrderTraversal(tree2);

        for (Integer x : result) {
            System.out.print(" " + x + "  ");
        }
        
    }

    
      public static Node getMergeTree(Node n1, Node n2)
     {
         if(n1==null)
             return n2;
         
         if(n2==null)
             return n1;
         
         
         n1.data=n1.data+n2.data;
         
         n1.left=getMergeTree(n1.left, n2.left);
         n1.right=getMergeTree(n1.right, n2.right);
             
         
         return n1;
     }
      
     public static void kthSmallestRec(Node root, int k)
     {
        
         if(root ==null)
             return;
         
         kthSmallestRec(root.left,k);
         count++;
         
         if(count==k)
         {
            System.out.println(" Kth smalest usng Recursion : "+root.data);
            return;
         }
         
         kthSmallestRec(root.right,k);
        
     }     
     
    public static int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        int i = 0;
        while (!stack.isEmpty()) {
            i++;
            Node temp = stack.pop();

            if (i == k) {
                return temp.data;
            }

            Node p = temp.right;
            while (p != null) {
                stack.add(p);
                p = p.left;
            }

        }

        return -1;
    }

    
     public static int kthLargest(Node root, int k) {
        Stack<Node> stack = new Stack();

        while (root != null) {
            stack.push(root);
            root = root.right;
        }

        int i = 0;
        while (!stack.isEmpty()) {
            i++;
            Node temp = stack.pop();

            if (i == k) {
                return temp.data;
            }

            Node p = temp.left;
            while (p != null) {
                stack.add(p);
                p = p.right;
            }

        }

        return -1;
    }
        

    
    static int sum =0;
     public static Node greaterTree(Node node)
        {
            if(node!=null)
            {
                greaterTree(node.right);
                sum= sum+ node.data; 
                node.data=sum;
                greaterTree(node.left);
            }
            return node;
        }
     

    public static void inOrderRec(Node node)
        {
            if(node!=null)
            {
                inOrderRec(node.left);
                System.out.print(" "+ node.data+ "  ");
                inOrderRec(node.right);
            }
        }
    
    
    public static void PostOrderRec(Node node)
        {
            if(node!=null)
            {
                PostOrderRec(node.left);
                PostOrderRec(node.right);
                 System.out.print(" "+ node.data+ "  ");
            }
        }
    
    static List<Integer> arr = new ArrayList();
    static int count1=0;
    
    //https://leetcode.com/submissions/detail/232982405/
    public static void allNodeswithSum(Node node, int k)
        {
            if(node!=null)
            {
                arr.add(node.data);
                allNodeswithSum(node.left,k);
                allNodeswithSum(node.right,k);
 
                //System.out.println(arr);
                int temp=0;
                for (int j = arr.size()-1; j >= 0; j--)  
                {
                    temp+=arr.get(j);
                    if(temp==k)
                        count1++;           
                }
                arr.remove(arr.size()-1);
            }
        }
    
    // stack
    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList();
        Stack<Node> stack = new Stack();

        if (root == null) {
            return null;
        }

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            result.add(temp.data);

            Node p = temp.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }

        return result;
    }
    // stack
    public static List<Integer> postOrderTraversal(Node root) {
        List<Integer> result = new ArrayList();
        Stack<Node> stack = new Stack();

        if (root == null) {
            return null;
        }

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            Node temp = stack.peek();

            if (temp.right == null) {
                temp = stack.pop(); /// peek and not poll as root will be processed last
                result.add(temp.data);
            } else {
                Node p = temp.right;
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                    temp.right = null;

                }
            }
        }

        return result;
    }
    // stack

    public static List<Integer> preOrderTraversal(Node root) {
        List<Integer> result = new ArrayList();
        Stack<Node> stack = new Stack();

        if (root == null) {
            return null;
        }

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            result.add(temp.data);
            // Add right first so it will be processed after left
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }

        return result;
    }

    // BFS or Level Order 
    // queue
    public static List<Integer> levelOrderTraversal(Node root) {
        List<Integer> result = new ArrayList();
        Queue<Node> queue = new LinkedList();

        if (root == null) {
            return null;
        }

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            result.add(temp.data);

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return result;
    }

     public List<List<Integer>> levelOrder(Node root) {
     
         List<List<Integer>> result = new ArrayList();
        
        if(root==null)
            return result;
        
        Queue<Node> q = new LinkedList();
        Queue<Integer> ql = new LinkedList();
        
        q.add(root);
        ql.add(1);
        
        while(!q.isEmpty())
        {
            
            Node temp = q.poll();
            int level = ql.poll();
            
            List<Integer> currList=null;
            if(result.size()<level)
            {
                currList= new ArrayList();
                result.add(currList);
            }
            else
                currList=result.get(level-1);
            
            currList.add(temp.data);
            
            if(temp.left!= null)
            {
                q.add(temp.left);
                ql.add(level+1);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                ql.add(level+1);
            }
        }
        
        return result; 
    }
       
    // Queue
    public static Node invertTreeItr(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

            Node n = temp.left;
            temp.left = temp.right;
            temp.right = n;

        }

        return root;
    }

    public static Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        Node n = root.left;
        root.left = root.right;
        root.right = n;

        return root;

    }

                
    public void ListOfLevels(Node root) {

        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

        LinkedList<Node> current = new LinkedList<Node>();// Link List for first Level

        if (root != null) {
            current.add(root); // Create first List with root
        }
        while (!current.isEmpty()) // Loop for all child Levels
        {
            result.add(current); //  adding the linklist for each level

            LinkedList<Node> temp = current; // to hold current Level 

            current = new LinkedList<Node>(); // for next level keep creating new List

            for (Node n : temp) {
                // Add to new List at each Level

                if (n.left != null) {
                    temp.add(n);
                }
                if (n.right != null) {
                    temp.add(n);
                }

            }
        }

    }

    public static Node minBST(int a[], int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        Node root = new Node(a[mid]);
        root.left = minBST(a, start, mid - 1);
        root.right = minBST(a, mid + 1, end);

        return root;
    }

    public boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int hieghtDiff = heightOfTree(root.left) - heightOfTree(root.right);

        if (Math.abs(hieghtDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }

        int ldepth = heightOfTree(root.left);
        int rdepth = heightOfTree(root.right);

        if (ldepth > rdepth) {
            return 1 + ldepth;
        } else {
            return 1 + rdepth;
        }

    }

   
    public static int heightTree(Node root) {

        if (root == null) {
            return 0;
        }

        int heightLeft = 1 + heightTree(root.left);
        int heightRight = 1 + heightTree(root.right);

        return (Math.max(heightLeft, heightRight));

    }
    
      public static int heightOfTree2(Node root)
     {
         if(root==null)
             return 0;
         
         int leftHeight= heightOfTree2(root.left);
         int rightHeight=heightOfTree2(root.right);
         
         return Math.max(leftHeight, rightHeight)+1;
         
     }
      

   

    // isBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
    public boolean IsBST(Node root, double min, double max) {
        if (root == null) {
            return true;
        }

        if (root.data >= max) {
            return false;
        }
        if (root.data <= min) {
            return false;
        }

        boolean isLeftBST = IsBST(root.left, min, root.data);
        boolean isRightBST = IsBST(root.right, root.data, max);
        if (!isLeftBST || !isRightBST) {
            return false;
        }

        return true;
    }

  
    //Given a binary tree and a sum, determine if the tree has a root-to-leaf 
    //path such that adding up all the values along the path equals the given sum.
    
    // BFS
    public static boolean pathSum(Node root, int sum)
    {
        Queue<Node> q = new LinkedList();
        Queue<Integer> qsum = new LinkedList();
        
        if(root==null)
            return false;
        
        q.add(root);
        qsum.add(root.data);
        
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            int tsum= qsum.poll();
            
            if(tsum==sum && temp.left==null && temp.right==null)
                return true;
            else
            {
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    qsum.add(tsum+temp.left.data);
                }
                 if(temp.right!=null)
                {
                    q.add(temp.right);
                    qsum.add(tsum+temp.right.data);
                }
            }
                 
        }
        return false;
    }
    
    
     public static int maxPathSum(Node root)
    {
        int maxSum = Integer.MIN_VALUE;
        
        Queue<Node> q = new LinkedList();
        Queue<Integer> qsum = new LinkedList();
        
        if(root==null)
            return 0;
        
        q.add(root);
        qsum.add(root.data);
        
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            int tsum= qsum.poll();
            
            if(temp.left==null && temp.right==null)
                maxSum = Math.max(tsum,maxSum);
            
            else
            {
                if(temp.left!=null)
                {
                    q.add(temp.left);
                    qsum.add(tsum+temp.left.data);
                }
                 if(temp.right!=null)
                {
                    q.add(temp.right);
                    qsum.add(tsum+temp.right.data);
                }
            }
                 
        }
        return maxSum;
    }
    
    public static int minDepthTree(Node root)
    {
        Queue<Node> q = new LinkedList();
        Queue<Integer> val = new LinkedList();
        
        if(root==null)
            return 0;
        
        q.add(root);
        val.add(1);
        
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            int count = val.poll();
            
            if(temp.left==null && temp.right==null)
                return count;
            
            if(temp.left!=null)
            {
                q.add(temp.left);
                val.add(count+1);
            }
            
            if(temp.right!=null)
            {
                q.add(temp.right);
                val.add(count+1);
            }
            
        }
        
        return 0;
        
    }
    
     public static boolean haspathSum(Node root, int sum)
     {
         if(root == null)
             return false;
         
         if(root.left==null && root.right==null && root.data==sum)
            return true;
         
         boolean leftsum= haspathSum(root.left, sum-root.data);
         boolean rightsum= haspathSum(root.right, sum-root.data);
         
         return leftsum || rightsum;
     }
   
     public static Node createTreeFromSortedArray(int []a, int min, int high)
     {
         if(min>high)
             return null;
         
         int mid = (min+high)/2;
         
         Node root=new Node(a[mid]);
         root.left=createTreeFromSortedArray(a,min,mid-1);
         root.right=createTreeFromSortedArray(a,mid+1,high);
         
         return root;
     }
     

      public static Node createTreeFromSortedLL(LLNode head, int min, int high)
     {
         if(min>high)
             return null;
         
         int mid = (min+high)/2;
         
         Node left = createTreeFromSortedLL(head,min,mid-1);
         
         Node root=new Node(head.data);
         
         head=head.next;
         
         Node right=createTreeFromSortedLL(head,mid+1,high);
         
         root.left=left;
         root.right=right;
         
         return root;
     }
     
      
         
 
               
      public static boolean isSymmetricRec(Node l, Node r)
      {
          if(l==null &&  r==null)
              return true;
          else if(l==null || r==null)
              return false;
          
          if(l.data!=r.data)
              return false;
         
          boolean sleft = isSymmetricRec(l.left, r.right);
          boolean sright = isSymmetricRec(l.right, r.left);
          
          if(!sleft || !sright)
              return false;
         return true;
      }
      
      public static List<Integer> rightSideView(Node root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
 
    if(root == null) return result;
 
    LinkedList<Node> queue = new LinkedList<Node>();
    queue.add(root);
 
    while(queue.size() > 0){
        //get size here
        int size = queue.size();
 
        for(int i=0; i<size; i++){
            Node top = queue.remove();
 
            //the first element in the queue (right-most of the tree)
            if(i==0){
                result.add(top.data);
            }
            //add right first
            if(top.right != null){
                queue.add(top.right);
            }
            //add left
            if(top.left != null){
                queue.add(top.left);
            }
        }
    }
 
    return result;
}
    

    
}

class LLNode
{
     int data;
    LLNode next;
    LLNode(int data)
    {
        this.data=data;
        next=null;
    }
}