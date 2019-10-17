/**
A class that tests MaxHeap.
@author Nathan Mankovich
*/
public class tMaxHeap {
	
	/**
	The main method that instantiates a maxheap and tests its operations.
	@param args is an array of input strings from the command line. 
	*/
	public static void main(String[] args) {
		
		//instantiate MaxHeap at size 10
		MaxHeap<Integer> mH = new MaxHeap<Integer>(10);
		
		//input lots of elements
		System.out.println("Added elements: 1, 3, 6, 14, 13, 12, 100, 15, 3, 10");
		mH.Add(1);
		mH.Add(3);
		mH.Add(6);
		mH.Add(14);
		mH.Add(13);
		mH.Add(12);
		mH.Add(100);
		mH.Add(15);
		mH.Add(3);
		mH.Add(10);
		
		//print the max elements
		System.out.println("the max element is " + mH.GetMax());
		
		//remove the max
		System.out.println("the removed max element is " + mH.RemoveMax());
		
		//print the max elements
		System.out.println("the new max element is " + mH.GetMax());
		
		//add one more
		System.out.println("Added 16");
		mH.Add(16);
		
		//print the max elements
		System.out.println("the new max element is " + mH.GetMax());
		
		//add one more
		//System.out.println("trying to add 17");
		//mH.Add(17);
	}
}