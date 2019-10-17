/**
A class that makes a Stack from data of generic type E by extending the LinkedList class.
@param E generic input element data type
@author Nathan Mankovich
*/
public class Stack<E> extends LinkedList<E>{
	
	//instantiate a linked list
	private LinkedList<E> linkList = new LinkedList<E>();
	
	/**
	This pushes an element on the top of the stack using the AddToFront method from LinkedList.
	@param element is an element of type E that is pushed on the top of the stack
	*/
	public void push(E element) {
		linkList.AddToFront(element);
	}

	/**
	This pops an element off the top of the stack using the RemoveFirst method from LinkedList.
	@return linkList.RemoveFirst() the first element in the stack that has been removed
	*/
	public E pop() {
		return (E) linkList.RemoveFirst();
	}
	
	/**
	This uses the GetFirst method from LinkedList to return the first element in the stack.
	@return linkList.GetFirst() is the first element in the stack
	*/
	public E peek() {
		return (E) linkList.GetFirst();
	}
	
	/**
	This uses the CheckIfEmpty method from linked list to check if the stack is empty.
	@return linkList.CheckIfEmpty() is a boolean that is true if the stack is empty
	*/
	public boolean CheckIfEmpty() {
		return linkList.CheckIfEmpty();
	}

	/**
	This uses the GetLength method from linked list to get the size of the stack.
	@return linkList.CetLength() is the size of the stack as an integer
	*/
	public int GetSize() {
		return linkList.GetLength();
	}
}