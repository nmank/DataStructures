/**
A class to test the Stack.
@author Nathan Mankovich
*/
public class tStack{
	
	/**
		Main method to make a stack and test its functions.
		@param args the input arguments in an array of strings (not used)
	*/
	
	public static void main (String[] args) {
		
		//instantiate a doubly linked list as testList
		Stack<String> testList = new Stack<String>();
		
		if (testList.CheckIfEmpty()) {
			System.out.println("The list is empty.");
		}
		
		System.out.println("push (in order): luke, bob, nate, jack, joe, colin");
		
		//push
		testList.push("luke");
		
		//push
		testList.push("bob");
		
		//push
		testList.push("nate");
		
		//push
		testList.push("jack");
		
		//push
		testList.push("joe");
		
		//push
		testList.push("colin");
		
		//get string at the top
		System.out.println("peek at the top " + testList.peek());
		
		//get length
		System.out.println("the length is " + testList.GetSize());
		
		//push carl
		System.out.println("pushed carl");
		testList.push("carl");
		
		//get string at the top
		System.out.println("peek at the top " + testList.peek());
		
		//get length
		System.out.println("the length is " + testList.GetSize());
		
		//remove first
		System.out.println("pop: " + testList.pop());
		
		//get length
		System.out.println("the length is " + testList.GetSize());
		
		//get string at the top
		System.out.println("peek at the top " + testList.peek());
			
		//remove first
		System.out.println("popped: " + testList.pop());
		
		//get length
		System.out.println("the length is" + testList.GetSize());
		
		
		if (testList.CheckIfEmpty() == false) {
			System.out.println("The array is not empty");
		}
		
		while (testList.CheckIfEmpty() == false) {
			System.out.println("popped: " + testList.pop());
		}
	}
}