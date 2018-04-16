package bst;
public class BinarySearchTree {
	Node root;

	BinarySearchTree()
	{
		root=null;
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
		
		System.out.println("Inside Delete Node");
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
			
			if(isRight==true)
				parent.right=null;
			else
				parent.left=null;
					
		}
		// left child
		else if(node.right==null && node.left!=null)
		{
			if(isRight==true)
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
			if(isRight==true)
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
			System.out.println("Successor : "+succ.data);
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
		Node currNode=node.right;
		Node succParent=null;
		
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
		// but the successor can have a right child and that should be re-parented to successor left
		
		
		
		if(succ.right!=null)
		{
			succParent.left=succ.right; //
			succ.right=node.right; // link right node of deleted node to succ.right
		}
		return succ;
	}
	
	
	
}
