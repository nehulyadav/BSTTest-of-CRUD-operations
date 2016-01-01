
/*  Author: Nehul Yadav
 *  Unique id: yadavn
 */

public class BinarySearchTree {

	class Node {
		private int data;
		private Node left;
		private Node right;

		/* The programming code below defines the constructor for the respective class.*/

		public Node(int data) {
			setData(data);
			setLeft(null);
			setRight(null);
		}
		/* Defining the getters and setters*/	
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

	}
	private Node root;

	public BinarySearchTree() {
		root = null;

	}

	public boolean isEmpty() {
		return root == null;
	} 

	public void insert(int data) {
		root = insertElement(root, data);
	}

	public Node delete(int data) {
		return root = deleteElement(root, data);
	}

	public boolean contains(int data) {
		return containsElement(root, data);
	}

	public void print() {
		printAll(root);
	}

	/* Printing the contents of the tree in preorder, postorder, and inorder traversal. */
	private void printAll(Node root) {
		if(root != null) {

			printAll(root.getLeft());
			System.out.printf("%d\t", root.getData());
			printAll(root.getRight());
		}
	}
	/*  The maximum function is programmed to implement the maximum value of the right node of the root. */
	private Node max(Node root) {
		if (root.right == null) {
			return root;
		}

		return max(root.right);
	}
	/*  The minimum function is programmed to implement the minimum value of the left node of the root.
	 *  This function is implemented in the else if statement in the deleteElement() method.
	 *  The output is tested and is running correctly. */

	private Node min(Node root) {
		if (root.left == null) {
			return root;
		}

		return min(root.left);
	}

	/*Insertion: allows a user to insert a single integer into the tree.*/

	private Node insertElement (Node root, int data) {
		if (root == null) {
			return new Node (data);

		} else if (data < root.getData()) {
			root.setLeft(insertElement(root.getLeft(), data));
			return root;
		} else {
			root.setRight(insertElement(root.getRight(), data));
			return root;
		} 
	} 

	/*Contains: allows a user to check if an integer belongs to the tree. */

	private boolean containsElement (Node root, int data) {
		if(root == null) {
			return false;

		}
		/*Boolean Condition check for if an integer is present in the tree or not, as programmed. */

		else if (root.getData() ==  data) {
			return true;
		}

		else if (root.getData() >  data) {
			return containsElement (root.getLeft(), data);

		}
		else {
			return containsElement (root.getRight(), data);
		}
	}

	/*Delete: allows a user to delete a single integer from the tree. */

	private Node deleteElement (Node root, int data) {
		//If the binary tree is empty, this syntax returns the the root itself.
		if (root == null) {
			return root;
		}

		if (data < root.getData()) {
			root.setLeft(deleteElement (root.getLeft(), data));
			return root;
		}

		else if (data > root.getData()) {
			root.setRight(deleteElement (root.getRight(), data));
			return root;
		}

		else {
			// If the parent, the root, does not have the two left and right children, then this statement is implemented.
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			}
			if (root.getLeft() == null) {
				return root.getRight();
			}
			if (root.getRight() == null) {
				return root.getLeft();
			}

			/* Finding the minimum in the right node of the root. */
			Node m = min(root.right);
			root.data = m.data;

			root.right = deleteElement(root.right, m.data);

			return root;
		}
	}



}


