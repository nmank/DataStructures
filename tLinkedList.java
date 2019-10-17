/**
A class that tests LinkedList.
@author Nathan Mankovich
*/

public class tLinkedList {
	
	/**
		Main method to make a linked list and test its functions.
		@param args the input arguments in an array of strings (not used)
	*/
	
	public static void main (String[] args) {
		
		//instantiate a doubly linked list as testList
		LinkedList<String> testList = new LinkedList<String>();
		
		if (testList.CheckIfEmpty()) {
			System.out.println("The list is empty.");
		}
		
		//add to back
		testList.AddToBack("luke");
		System.out.println("luke added to the back of the list");
		
		//add to back
		testList.AddToBack("bob");
		System.out.println("bob added to the back of the list");
		
		//add to front
		testList.AddToFront("nate");
		System.out.println("nate added to the front of the list");
		
		//add after bob (object to add, who it is added after)
		testList.AddAfter("karen","luke");
		System.out.println("karen is added after luke");
		
		//add to back
		testList.AddToBack("joe");
		System.out.println("joe is added to the back of the list");

		//insert at position
		testList.InsertAtPosition("colin", 3);
		System.out.println("colin is inserted at position 3");
		
		//get length
		System.out.println("the length is " + testList.GetLength());
		
		//print the donors
		System.out.println("all the donors in order starting at location 0");
		int i = 0;
		while (i < testList.GetLength()) {
			System.out.println(testList.GetAtPosition(i));
			i++;
		}
		
		//remove first
		System.out.println("removed: " + testList.RemoveFirst() + " from the front of the list");
		
		//get first
		System.out.println("the first donor is " + testList.GetFirst());
			
		//remove last
		System.out.println("removed: " + testList.RemoveLast() + " from the back of the list");
		
		//get last
		System.out.println("the last donor is " + testList.GetLast());
		
		//remove (not working to remove first: null pointer exception)
		System.out.println(testList.RemoveCertain("bob") + " was removed");
		
		//get length
		System.out.println("the length is " + testList.GetLength());
		
		//print the donors
		System.out.println("all the donors in order starting at location 0");
		i = 0;
		while (i < testList.GetLength()) {
			System.out.println(testList.GetAtPosition(i));
			i++;
		}
		 
		//get first
		System.out.println("the first donor is " + testList.GetFirst());
		
		//get last
		System.out.println("the last donor is " + testList.GetLast());
		
		//get at position
		System.out.println("the donor at position 2 is " + testList.GetAtPosition(2));
		
		//get length
		System.out.println("the length is " + testList.GetLength());
		
		if (testList.CheckIfEmpty() == false) {
			System.out.println("The array is not empty");
		}
		
		if (testList.CheckIfContains("karen")) {
			System.out.println("karen is there");
		}
		
		if (testList.CheckIfContains("bob") == false) {
			System.out.println("Bob is not there");
		}
		
		//print the donors
		System.out.println("remove the donors from the back of the list");
		i = 0;
		while (testList.GetLength() != 0) {
			System.out.println(testList.RemoveLast());
			i++;
		}
		
		if (testList.CheckIfEmpty()) {
			System.out.println("The array is empty");
		}
	}
}