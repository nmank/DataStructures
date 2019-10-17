/**
A public class for a binary search tree of elements of type generic parameter E.
@author Nathan Mankovich
@param E generic input element data type
*/
public class BinarySearchTree<E extends Comparable<E>> {
	
	private int size;
	private int leftHeight;
	private int rightHeight;
	private Node root;
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	/**
	This returns the data at the root node.
	@return root.data is the data of the root Node (generic type E).
	*/
	public E GetRoot() {
		return root.data;
	}
	
	/**
	This checks if the tree contains the input element by using loops to traverse the tree.
	@param element is the element that is being searched for
	@return found a boolean that is false if the element is not found and true if it is found.
	*/
	public boolean Contains (E element) {
		//find the node that contains the element
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int comp = toBeRemoved.data.compareTo(element);
			if (comp == 0) {
				found = true;
			}
			else {
				parent = toBeRemoved;
				if (comp > 0) {
					toBeRemoved = toBeRemoved.left;
				}
				else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}
		return found;
	}
	
	/**
	This inserts an element of type E into the tree either by calling the recursive method InsertNode or inserting the element at the root.
	@param element the element to be insert.
	*/
	public void Insert (E element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
		}
		else {
			root.InsertNode(newNode);
		}
		size++;
	}

	/**
	This removes the node with data field that is the element from the tree.
	@param element is the element to be removed
	*/	
	public void Remove (E element){
		
		//find the node that contains the element
		Node toBeRemoved = root;
		//initialize parent
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			int comp = toBeRemoved.data.compareTo(element);
			if (comp == 0) {
				found = true;
			}
			else {
				parent = toBeRemoved;
				if (comp > 0) {
					toBeRemoved = toBeRemoved.left;
				}
				else {
					toBeRemoved = toBeRemoved.right;
				}
			}
		}
		if (!found) {
			return;
		}
		//toBeRemoved and parent has element in data
		
		//putting the parents of toBeRemoved in the correct locations using pointers
		if (root.left == null || toBeRemoved.right == null) {
			Node newChild;
			if (toBeRemoved.left == null) {
				newChild = toBeRemoved.right;
			}
			else {
				newChild = toBeRemoved.left;
			}
			if (parent == null) {
				root = newChild;
			}
			else if (parent.left == null) {
				parent.left = newChild;
			}
			else {
				parent.right = newChild;
			}
			size--;
			return;
		}
		
		//putting the children of toBeRemoved in the correct locations
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.right;
		//move everything right, left... of toBeRemoved up one
		while (smallest.left != null) {
			smallestParent = smallest;
			smallest = smallest.left;
		}
		toBeRemoved.data = smallest.data;
		if (smallestParent == toBeRemoved) {
			smallestParent.right = smallest.right;
		}
		else {
			smallestParent.left = smallest.right;
		}
		size--;
	}
	
	/**
	This checks if the tree is empty by looking at the root of the tree.
	@return empty is a boolean that is true if the tree is empty
	*/
	public boolean CheckIfEmpty () {
		boolean empty = false;
		if (root == null) {
			empty = true;
		}
		return empty;
	}
	
	/**
	Returns the size of the tree.
	@return size is the number of elements in the tree
	*/
	public int GetSize () {
		return size;
	}
	
	/**
	Gets the height of the tree as the largest number of edges by calling the getHeightNode method.
	@return 0 is the height of the tree when it is empty
	@return getHeightNode(root) the height from the getHeightNode method
	*/
	public int GetHeight () {
		if (root == null) {
			return 0;
		}
		else {
		    return GetHeightNode(root);
		}
	}
	
	/**
	Uses recursion to find the maximum height of the tree (height is the number of edges).
	@param newNode is the input Node for each recursive call
	@return -1 if the node you are looking at is null
	@return Math.max(GetHeightNode(newNode.left), GetHeightNode(newNode.right))+1 to get the maximum height of the subtree with the newNode as the parent
	*/
	public int GetHeightNode(Node newNode) {
		if (newNode == null) {
			return -1;
		}
		else {
			return Math.max(GetHeightNode(newNode.left), GetHeightNode(newNode.right))+1;
		}
	}
	
	/**
	Determines if the tree is balanced by getting the maximum and minimum heights of the tree in number of edges by calling the getHeightNode and getMinHeightNode method.
	@return true if the tree is empty
	@return true if the max and min heights are off by one or the same
	@return false if the heights differ by more than 1
	*/
	public boolean IsBalanced () {
		if (root == null) {return true;}
		int maxHeight = GetHeightNode(root);
		int minHeight = GetMinHeightNode(root);
		if (maxHeight == minHeight+1 || maxHeight+1 == minHeight || maxHeight == minHeight) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	Uses recursion to find the minimum height of the tree (height is the number of edges).
	@param newNode is the input Node for each recursive call
	@return -1 if the node you are looking at is null
	@return mMath.min(GetHeightNode(newNode.left), GetHeightNode(newNode.right))+1 to get the minimum height of the subtree with the newNode as the parent
	*/
	private int GetMinHeightNode (Node newNode) {
		if (newNode == null) {
			return -1;
		}
		else {
			return Math.min(GetHeightNode(newNode.left), GetHeightNode(newNode.right))+1;
		}
	}
	
	/**
	Calls the TravTreeInNode method to traverse the tree in order.
	@return null if the tree is empty
	@return TravTreeNodeIn(root, inOrderQ) a queue of strings of the elements of the binary search tree in order
	*/
	public Queue<E> TravTreeIn () {
		if (root == null) {
			return null;
		}
		Queue<E> inOrderQ = new Queue<E>();
		return TravTreeNodeIn(root, inOrderQ);
	}
	
	/**
	This traverses the the tree in order using recursion and prints out the objects using the toString method.
	@param newNode is the input Node
	@param inQ is a queue of strings that holds the elements of the tree in order
	@retun inQ is a queue of strings that holds the elements of the tree in order
	*/
	private Queue<E> TravTreeNodeIn(Node newNode, Queue<E> inQ) {
		if (newNode.left != null) {
			TravTreeNodeIn(newNode.left, inQ);
		}
		inQ.Enqueue(newNode.data);
		if (newNode.right != null) {
			TravTreeNodeIn(newNode.right, inQ);
		}
		return inQ;
	}
	
	/**
	Does a level traversal of the tree and returns a queue of strings of the elements of the tree in level order.
	@return null if the tree is empty
	@return levelQ is a queue of strings of the elements of the binary search tree in level order
	*/
	public Queue<E> TravTreeLevel () {
		if (root == null) {
			return null;
		}
		Queue<Node> visNodeQ = new Queue<Node>();
		Queue<E> levelQ = new Queue<E>();
		visNodeQ.Enqueue(root);
		while (visNodeQ.GetSize() != 0) {
			Node newNode = visNodeQ.Dequeue();
			if (newNode.left != null) {
				visNodeQ.Enqueue(newNode.left);
			}
			if (newNode.right != null) {
				visNodeQ.Enqueue(newNode.right);
			}
			levelQ.Enqueue(newNode.data);
		}
		return levelQ;
	}
	
	/**
	Calls the TravTreePreNode method to traverse the tree in pre order.
	@return null if the tree is empty
	@return TravTreeNodePre(root) is a queue of strings of the elements of the binary search tree in pre order
	*/
	public Queue<E> TravTreePre () {
		if (root == null) {
			return null;
		}
		Queue<E> preOrderQ = new Queue<E>();
		return TravTreeNodePre(root, preOrderQ);
	}
	
	/**
	This traverses the the tree pre order using recursion and prints out the objects using the toString method.
	@param newNode is the input Node
	@param preQ is the queue of strings to store the elements of the tree in pre order
	@retun preQ is the elements in strings of the tree in pre-order
	*/
	private Queue<E> TravTreeNodePre(Node newNode, Queue<E> preQ) {
		preQ.Enqueue(newNode.data);
		if (newNode.left != null) {
			TravTreeNodePre(newNode.left, preQ);
		}
		if (newNode.right != null) {
			TravTreeNodePre(newNode.right, preQ);
		}
		return preQ;
	}	
	
	/**
	Calls the TravTreePostNode method to traverse the tree in post order.
	@return null if the tree is empty
	@return TravTreeNodePost(root, postOrderQ) is a queue of strings of the elements of the binary search tree in post order
	*/
	public Queue<E> TravTreePost () {
		if (root == null) {
			return null;
		}
		Queue<E> postOrderQ = new Queue<E>();
		return TravTreeNodePost(root, postOrderQ);
	}
	
	/**
	This traverses the the tree post order using recursion and prints out the objects using the toString method.
	@param newNode is the input Node
	@param postQ is the queue of strings to store the elements of the tree in post order
	@retun postQ is the elements in strings of the tree in post-order
	*/
	private Queue<E> TravTreeNodePost(Node newNode, Queue<E> postQ) {
		if (newNode.left != null) {
			TravTreeNodePost(newNode.left, postQ);
		}
		if (newNode.right != null) {
			TravTreeNodePost(newNode.right, postQ);
		}
		postQ.Enqueue(newNode.data);
		return postQ;
	}			
	
	/**
	A class for a node with fields for left pointer, right pointer and data.
	*/
	class Node{
		public E data;
		public Node left;
		public Node right;
		
		/**
		This inserts a Node into the tree either by recursion and a compareTo method.
		@param newNode the Node to be input into the program.
		*/
		public void InsertNode (Node newNode){
			int comp = newNode.data.compareTo(data);
			//NO DUPLICATE NAMES
			if (comp < 0) {
				if (left == null) { 
				left = newNode; 
				}
				else { 
				left.InsertNode(newNode); 
				}
			}
			else if (comp > 0) {
				if (right == null) { 
				right = newNode; 
				}
				else { 
				right.InsertNode(newNode); 
				}
			}
		}
	}
}