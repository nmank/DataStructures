/**
A class that makes a Queue from data of generic type E by extending the LinkedList class.
@param E generic input element data type
@author Nathan Mankovich
*/
public class Queue<E> extends LinkedList<E> {
	
	private LinkedList<E> linkList = new LinkedList<E>();
	
	/**
	This enqueues an element at the back of the queue using the AddToFront method from LinkedList.
	@param element is an element of type E that is pushed on the top of the queue
	*/
	public void Enqueue (E element) {
		linkList.AddToFront(element);
	}

	/**
	This dequeues an element at the front of the queue using the RemoveLast method from LinkedList.
	@return linkList.RemoveLast() the last element in the queue that has been removed
	*/	
	public E Dequeue () {
		return (E) linkList.RemoveLast();
	}
	
	/**
	This uses the GetLast method from LinkedList to return the first element in the queue.
	@return linkList.GetLast() is the first element in the queue
	*/
	public E LookAtFirst () {
		return (E) linkList.GetLast();
	}
	
	/**
	This uses the CheckIfEmpty method from linked list to check if the queue is empty.
	@return linkList.CheckIfEmpty() is a boolean that is true if the queue is empty
	*/
	public boolean CheckIfEmpty () {
		return linkList.CheckIfEmpty();
	}
	
	/**
	This uses the GetLength method from linked list to get the size of the queue.
	@return linkList.CetLength() is the size of the queue as an integer
	*/
	public int GetSize() {
		return linkList.GetLength();
	}
}