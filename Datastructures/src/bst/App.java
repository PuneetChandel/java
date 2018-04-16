package bst;

public class App {
	
	public static void main(String[] args) {
		BinarySearchTree bt= new BinarySearchTree();
		bt.insertNode(40);
		bt.insertNode(25);
		bt.insertNode(80);
		bt.insertNode(50);
		bt.insertNode(90);
		bt.insertNode(20);
		bt.insertNode(30);
		bt.insertNode(15);
		bt.insertNode(28);
		bt.insertNode(35);
		
		bt.display(bt.root);
		
		bt.deleteNode(30);
		
		bt.display(bt.root);
		
	}

}
