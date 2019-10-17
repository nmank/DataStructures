/**
A class to test the Queue.
@author Nathan Mankovich
*/
public class tQueue {
	
	/**
		Main method to make a queue and test its functions.
		@param args the input arguments in an array of strings (not used)
	*/
	
	public static void main (String[] args) {
		
		//instantiate a doubly linked list as testList
		Queue<String> testList = new Queue<String>();
		
		if (testList.CheckIfEmpty()) {
			System.out.println("The list is empty.");
		}
		
		System.out.println("enqueueing (in order): luke, bob, nate, jack, joe, colin");
		
		//add to top
		testList.Enqueue("luke");
		
		//add to top
		testList.Enqueue("bob");
		
		//add to top
		testList.Enqueue("nate");
		
		//add to top
		testList.Enqueue("jack");
		
		//add to top
		testList.Enqueue("joe");
		
		//insert to top
		testList.Enqueue("colin");
		
		//get string at the top
		System.out.println("look at the top " + testList.LookAtFirst());
		
		//get length
		System.out.println("the length is " + testList.GetSize());
		
		//enqueue carl
		System.out.println("enqueued carl");
		testList.Enqueue("carl");
		
		//get string at the top
		System.out.println("look at the top " + testList.LookAtFirst());
		
		//get length
		System.out.println("the length is " + testList.GetSize());
		
		//remove first
		System.out.println("dequeue: " + testList.Dequeue());
		
		//get length
		System.out.println("the length is " + testList.GetSize());
		
		//get string at the top
		System.out.println("look at the top " + testList.LookAtFirst());
			
		//remove first
		System.out.println("dequeue: " + testList.Dequeue());
		
		//get length
		System.out.println("the length is" + testList.GetSize());
		
		
		if (testList.CheckIfEmpty() == false) {
			System.out.println("The array is not empty");
		}
		
		while (testList.CheckIfEmpty() == false) {
			System.out.println("dequeue: " + testList.Dequeue());
		}
	}
}