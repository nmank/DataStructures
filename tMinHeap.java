/**
A class that tests MinHeap.
@author Nathan Mankovich
*/
public class tMinHeap {
	
	/**
	The main method that instantiates a minheap and tests its operations.
	@param args is an array of input strings from the command line. 
	*/
	public static void main(String[] args) {
		
		//instantiate MaxHeap at size 10
		MinHeap<Integer> mH = new MinHeap<Integer>(10);
		
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
		
		//print the min elements
		System.out.println("the min element is " + mH.GetMin());
		
		//remove the min
		System.out.println("the removed min element is " + mH.RemoveMin());
		
		//print the min elements
		System.out.println("the new min element is " + mH.GetMin());
		
		//add one more
		System.out.println("Added 16");
		mH.Add(16);
		
		//print the min elements
		System.out.println("the new min element is " + mH.GetMin());
		
		//add one more
		//System.out.println("trying to add 17");
		//mH.Add(17);
	}
}