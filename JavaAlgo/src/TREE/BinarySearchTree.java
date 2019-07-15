package TREE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
public class BinarySearchTree {
	Node root;

	BinarySearchTree()
	{
		root=null;
	}
		

        public static Node minBST(int a[], int start, int end)
        {
            if(end<start)
                return null;
            
            int mid = (start+end)/2;
            
            Node root= new Node(a[mid]);
            root.left=minBST(a,start,mid-1);
            root.right=minBST(a,mid+1,end);

            return root;
        }
 

	public static void inOrder(Node node)
        {
            if(node!=null)
            {
                inOrder(node.left);
                System.out.print(" "+ node.data+ "  ");
                inOrder(node.right);
            }
        }
        
        public static void preOrder(Node node)
        {
            if(node!=null)
            {
                System.out.print(" "+ node.data+ "  ");
                preOrder(node.left);
                preOrder(node.right);
            }
        }
         
        public static void postOrder(Node node)
        {
            if(node!=null)
            {
                postOrder(node.left);
                postOrder(node.right);
                System.out.print(" "+ node.data+ "  ");
                
            }
        }
          
        
       public static void BFSorLevelOrder(Node root)
       {
           Queue<Node> q = new LinkedList<Node>();
           
           if(root!=null)
               q.add(root);
           
           while(!q.isEmpty())
           {
               Node temp=q.poll();
               
               System.out.print(" "+ temp.data + "  " );
               
               if(temp.left!=null)
                    q.add(temp.left);
               if(temp.right!=null)
                    q.add(temp.right);
           }
               
       }
       
    	public static void insertNodeNew(int data, Node root)
	{
		if(root == null)
		{
			root = new Node(data);
			return;
		}
		
		Node currNode=root;
		Node parent=null;
			
		while(currNode!=null)
			{
				parent=currNode;
				if (data>currNode.data)
				{
					currNode=currNode.right;
					if(currNode==null)
					{
						parent.right=new Node(data);
						return;
					}	
				}
				else
				{
					currNode=currNode.left;
					if(currNode==null)
					{
						parent.left=new Node(data);
						return;
					}
				}
			}			
		
	}
          
       
	public void insertNode(int data)
	{
		if(root == null)
		{
			root = new Node(data);
			return;
		}
		
		Node currNode=root;
		Node parent=null;
			
		while(currNode!=null)
			{
				parent=currNode;
				if (data>currNode.data)
				{
					currNode=currNode.right;
					if(currNode==null)
					{
						parent.right=new Node(data);
						return;
					}	
				}
				else
				{
					currNode=currNode.left;
					if(currNode==null)
					{
						parent.left=new Node(data);
						return;
					}
				}
			}			
		
	}
	
        
       
	public boolean searchNode(int data)
	{
	
		Node currNode=root;
		
		while(currNode!=null)
			{
				if (data>currNode.data)
					currNode=currNode.right;
				else if(data<currNode.data)
					currNode=currNode.left;	
				else
					return true;
			}			
		return false;
	}
	
	public void display(Node root)
	{
		if(root!=null)
		{
			display(root.left);
			System.out.println(" " + root.data);
			display(root.right);
		}
	}
	
	// search where the data is
	// if leaf node, remove the node
	// if has one children, re-parent the only child to node's parent
	// if has 2 or more children, find the successor and re-parent
	
	public boolean deleteNode(int data)
	{
		Node node=root;
		Node parent=null;
		
                boolean isRight=false;
                
                
		// search for Node and find out if its right node or left of parent
		
		while(node.data!=data)
		{
			parent=node;
			if(node.data<data)
			{
				node=node.right;
				isRight=true;
			}
                            else if(node.data>data)
			{
				isRight=false;
				node=node.left;
			}
			
		}
		
		System.out.println("node:"+ node.data);
		System.out.println("parent : "+ parent.data);
		System.out.println("isRight : "+isRight);
		
		// Leaf Node
		if (node.left==null && node.right==null)
		{
			if(node==root)
			{
				root=null;
				return false;
			}
			
			if(isRight)
				parent.right=null;
			else
				parent.left=null;
					
		}
		// left child
		else if(node.right==null && node.left!=null)
		{
			if(isRight)
			{
				parent.right=node.left;
				node.left=null;
			}
			else
			{
				parent.left=node.left;
				node.left=null;

			}
		}
		// right child	
		else if(node.right!=null && node.left==null)
		{
			if(isRight)
			{
				parent.right=node.right;
				node.right=null;
			}
			else
			{
				parent.left=node.right;
				node.right=null;
			}
		}
		else if(node.right!=null && node.left!=null)
		{
			Node succ= getSuccessor(node);
                        
                        Node succ2= getSuccessor(node);
                        
                        
			System.out.println("Successor : "+succ.data);
                        System.out.println("Successor2 : "+succ2.data);
                        
                        
			if(isRight==true)
				parent.right=succ;
			else
				parent.left=succ;
			succ.left=node.left;
		}
		
		System.out.println("==== after delete =========== ");
		System.out.println("parent left: "+ parent.left.data);
		System.out.println("parent right: "+ parent.right.data);

		
		return true;
		
	}
	
	public Node getSuccessor(Node node)
	{
		Node succ=null;
		Node succParent=null;
                
                Node currNode=node.right;
                        
		System.out.println("Find successor");
		
		while(currNode!=null)
		{
			succParent=succ;
			succ=currNode;
			currNode=currNode.left;
		}

		// after this we will find the leftmost node or the smallest node in right subtree
		// with this if we replace the deleted node all nodes on left of deleted will be smaller then node and 
		// all nodes on right of node are greater than the deleted node.
		
		// Basically we are finding the Next greater element than the one we have to delete
                // so the next greated will be on right side and leftmost.
                
		
                // But the successor can have a right child and that should be re-parented to parents left
                // as it will be smaller than the parent as its on left child
		
                
		if(succ.right!=null)
		{
			succParent.left=succ.right; //
			succ.right=node.right; 
		}
		return succ;
	}
	
	
     
           
        public void deleteNode2(int data)
	{
		Node node=root;
		Node parent=null;
		
                boolean isRightChild=false;
                
                
	
		while(node.data!=data)
		{
			parent=node;
			if(node.data<data)
			{
				node=node.right;
				isRightChild=true;
			}
                        else if(node.data>data)
			{
                            node=node.left;
			    isRightChild=false;
				
			}
		}
                
                //leaf
                if(node.left==null && node.right==null)
                {
                    if(isRightChild)
                        parent.right=null;
                    else
                        parent.left=null;
                }
                else if(node.left!=null && node.right==null)
                {
                    
                    if(isRightChild)
                        parent.right=node.left;
                     else
                        parent.left=node.left;
                
                     node.left=null;
                }
                 else if(node.left==null && node.right!=null)
                {
                    
                    if(isRightChild)
                        parent.right=node.right;
                     else
                        parent.left=node.right;
                
                     node.right=null;
                }
                else
                 {
                     Node succ = getSuccessor(node);
                
                     if(isRightChild)
                        parent.right=succ;
                     else
                        parent.left=succ;
                
                     succ.left=node.left;
                     node.right=node.right;
                 }
                
        }
        
        public Node getSuccessor2(Node n)
        {
            Node succ= n.right;
            Node parent = n;
            
            while(succ.left!=null)
            {
                parent= succ;
                succ=succ.left;
            }
            
            if(succ.right!=null)
                parent.left=succ.right;
            
            
            return succ;
            
            
        }
     
}
