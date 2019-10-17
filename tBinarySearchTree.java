/**
A class that tests BinarySearchTree.
@author Nathan Mankovich
*/

public class tBinarySearchTree {
	
	/**
		Main method to make a linked list and test its functions.
		@param args the input arguments in an array of strings (not used)
	*/
	
	public static void main (String[] args) {
		
		//instantiate a binary search tree as testTree
		BinarySearchTree<String> testTree = new BinarySearchTree<String>();
		
		//check if empty
		if (testTree.CheckIfEmpty()) {
			System.out.println("The tree is empty.");
		}
		
		//get the height of the tree
		System.out.println("the height is " + testTree.GetHeight());
		
		//get if tree contains joe
		if (testTree.Contains("joe")) {
			System.out.println("the tree contains joe");
		}
		else {
			System.out.println("the tree does not contain joe");
		}
		
		//is the tree balanced
		if (testTree.IsBalanced()) {
			System.out.println("the tree is balanced");
		}
		else {
			System.out.println("the tree is not balanced");
		}
		
		//insert
		testTree.Insert("luke");
		System.out.println("insert luke");
		
		//insert
		testTree.Insert("bob");
		System.out.println("insert bob");
		
		//insert
		testTree.Insert("nate");
		System.out.println("insert nate");
		
		//insert
		testTree.Insert("karen");
		System.out.println("insert karen");
		
		//is the tree balanced
		if (testTree.IsBalanced()) {
			System.out.println("the tree is balanced");
		}
		else {
			System.out.println("the tree is not balanced");
		}
		
		//insert
		testTree.Insert("frank");
		System.out.println("insert frank");
		
		//insert
		testTree.Insert("joe");
		System.out.println("insert joe");

		//insert
		testTree.Insert("colin");
		System.out.println("insert colin");
		
		//get size
		System.out.println("the size is " + testTree.GetSize());
		
		//get root
		System.out.println("the root is" + testTree.GetRoot());
		
		//print in order
		System.out.println("the elements in order: \n");
		Queue<String> p1Q = new Queue<String>();
		p1Q = testTree.TravTreeIn();
		while (p1Q.GetSize() != 0) {
			System.out.println(p1Q.Dequeue());
		}
		
		//print pre order
		System.out.println("the elements pre order: \n");
		Queue<String> p2Q = new Queue<String>();
		p2Q = testTree.TravTreePre();
		while (p2Q.GetSize() != 0) {
			System.out.println(p2Q.Dequeue());
		}
		
		//print post order
		System.out.println("the elements post order: \n");
		Queue<String> p3Q = new Queue<String>();
		p3Q = testTree.TravTreePost();
		while (p3Q.GetSize() != 0) {
			System.out.println(p3Q.Dequeue());
		}
		
		//print level order
		System.out.println("the elements level order: \n");
		Queue<String> p4Q = new Queue<String>();
		p4Q = testTree.TravTreeLevel();
		while (p4Q.GetSize() != 0) {
			System.out.println(p4Q.Dequeue());
		}
		
		//get if tree contains joe
		if (testTree.Contains("joe")) {
			System.out.println("the tree contains joe");
		}
		else {
			System.out.println("the tree does not contain joe");
		}
		
		//get the height of the tree
		System.out.println("the height is " + testTree.GetHeight());
		
		//is the tree balanced
		if (testTree.IsBalanced()) {
			System.out.println("the tree is balanced");
		}
		else {
			System.out.println("the tree is not balanced");
		}
		
		//remove nate
		testTree.Remove("nate");
		System.out.println("nate has been removed");
		
		//print in order
		System.out.println("the elements in order: \n");
		Queue<String> p5Q = new Queue<String>();
		p5Q = testTree.TravTreeIn();
		while (p5Q.GetSize() != 0) {
			System.out.println(p5Q.Dequeue());
		}
		
		//get size
		System.out.println("the size is " + testTree.GetSize());
		
		if (testTree.CheckIfEmpty()) {
			System.out.println("The tree is empty.");
		}
		else {
			System.out.println("the tree is not empty");
		}
	}
}