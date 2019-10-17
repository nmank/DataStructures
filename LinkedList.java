import java.util.NoSuchElementException;

/**
A public for a singly linked list of elements of type generic parameter E.
@author Nathan Mankovich
@param E generic input element data type
*/
public class LinkedList<E> {
	
	//name head, currNode and the list length
	private Node head;
	private Node currNode;
	private int length;
	
	/**
	This contains the initial conditions of the linked list.
	*/
	public LinkedList() {
		//empty list conditions
		head = null;
		length = 0;
	}
	
	/**
	This adds an element of type E to the front of the list.
	@param element the element to be added
	*/
	public void AddToFront(E element) {
		//create a new node
		Node newNode = new Node();
		//add data
		newNode.data = element;
		//pointer
		newNode.next = head;
		head = newNode;
		//add one to length
		length++;
	}
	
	/**
	This adds an element of type E to the back of the list.
	@param element the element to be added
	*/
	public void AddToBack(E element) {
		
		//list is empty
		if (head == null) {
			this.AddToFront(element);
		}
		//list is not empty
		else {
			//currNode points to the beginning of the list
			currNode = head;
			//go to the end of the list
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			//create a new node
			Node newNode = new Node();
			//fill it with data
			newNode.data = element;
			//set the last pointer to the newNode location
			currNode.next = newNode;
			length++;
		}
	}
	
	/**
	This adds an element of type E after an refElement of type E to the list.
	@param element the element to be added
	@param refElement the refElement that goes after the element in the list
	*/
	public void AddAfter (E element, E refElement) {
		//start at the beginning
		currNode = head;
		//go through the list
		while (currNode.next != null) {
			//if the node has the element
			if (currNode.data.equals(refElement)) {
				//create a new Node
				Node newNode = new Node();
				//fill it with data
				newNode.data = element;
				//insert the newNode after currNode
				newNode.next = currNode.next;
				currNode.next = newNode;
				//add to length
				length++;
				//exit the while loop
				return;
			}
			currNode = currNode.next;
		}
		Node lastNode = currNode.next;
		if (lastNode == null && lastNode.data.equals(refElement)) {
			this.AddToBack(element);
		}
	}
	
	/**
	This adds an element of type E at location position.
	@param element the element to be added
	@param position the position (first element is at position 0) in the linked list where the element is to be inserted
	@throws NoSuchElementException if there is nothing at the position
	*/
	public void InsertAtPosition (E element, int position) {
		if (0 <= position && position < this.GetLength()){
			//start at the beginning
			currNode = head;
			//add it to the front
			if (position == 0) {
				this.AddToFront(element);
				length++;
				return;
			}
			Node nextNode = currNode.next;
			//iterator
			int i = 1;
			while (nextNode.next != null) {
				if (position == i) {
					//newNode and fill it up
					Node newNode = new Node();
					newNode.data = element;
					//pointers
					newNode.next = nextNode;
					currNode.next = newNode;
					//exit the loop
					break;
				}
				//add one to the iterator
				i++;
				//point the nodes forward
				currNode = currNode.next;
				nextNode = currNode.next;
			}
			//if we are at the last element add it in that slot 
			//and push the other element up one
			if (nextNode.next == null) {
				//make a newNode
				Node newNode = new Node();
				//put data in it
				newNode.data = element;
				//pointers
				newNode.next = nextNode;
				currNode.next = newNode;
			}
			length++;
		}
		else {
			//in case there is nothing at the referenced spot
			throw new NoSuchElementException();
		}
	}
	
	/**
	This removes the first element in the list.
	@return removedData the data (type E) that has been removed from the list
	@throws NoSuchElementException if the list is empty
	*/
	public E RemoveFirst() {
		//in case there is nothing there
		if (head == null) {
			throw new NoSuchElementException();
		}
		else {
			//make a node the head
			currNode = head;
			E removedData = currNode.data;
			//make the head reference the node following the current node
			if (currNode.next == null) {
				head = null;
			}
			else {
				head = currNode.next;
			}
			//subtract one off the length
			length--;
			return removedData;
		}
	}
	
	/**
	This removes the last element in the list.
	@return removedData the data (type E) that has been removed from the list
	@throws NoSuchElementException if the list is empty
	*/
	public E RemoveLast() {
		//check if the list is empty
		if (this.CheckIfEmpty()) {
			throw new NoSuchElementException();
		}
		else if (this.GetLength() == 1) {
			currNode = head;
			E removedData = currNode.data;
			head = null;
			length--;
			return removedData;
		}
		else {
			//start at the beginning
			currNode = head;
			//make a next node after the current nodes
			Node nextNode = currNode.next;	
			while (nextNode.next != null) {
				//progress the nodes down the list
				currNode = currNode.next;
				nextNode = currNode.next;
			}
			E removedData = nextNode.data;
			currNode.next = null;
			//decrement length
			length--;
			return removedData;
		}
		
	
	}
	
	/**
	This removes a certain element in the list.
	@param element this is the element to be removed
	@return removedData the data (type E) that has been removed from the list
	*/
	public E RemoveCertain(E element) {
		if (this.CheckIfEmpty()) {
			throw new NoSuchElementException();
		}
		//start at the beginning
		currNode = head;
		if (currNode.data == element) {
			E removedData = currNode.data;
			if (currNode.next == null) {
				head = null;
			}
			else {
				head = currNode.next;
			}
			length--;
			return removedData;
		}
		else {
			Node nextNode = currNode.next;
			while (nextNode.next != null) {
				if (nextNode.data == element) {
					E removedData = nextNode.data;
					currNode.next = nextNode.next;
					nextNode = null;
					length--;
					return removedData;
				}
				currNode = currNode.next;
				nextNode = currNode.next;
			}
			if (nextNode.next == null && nextNode.data == element) {
				E removedData = nextNode.data;
				currNode.next = nextNode.next;
				nextNode = null;
				length--;
				return removedData;
			}
			else {
				return null;
			}
		}
	}
	
	/**
	The returns the first element in the list.
	@return currNode.data this is the data (type E)from the first node
	@throws NoSuchElementException if the list is empty
	*/
	public E GetFirst() {
		if (this.CheckIfEmpty()) {
			return null;
		}
		else {
			currNode = head;
			return currNode.data;
		}
	}
	
	/**
	The returns the last element in the list.
	@return currNode.data this is the data (type E)from the last node
	*/
	public E GetLast() {
		if (this.CheckIfEmpty()) {
			return null;
		}
		else {
			currNode = head;
			while (currNode.next != null) {
				currNode = currNode.next;
			}
			return currNode.data;
		}
	}
	
	/**
	The returns the element at position from the list.
	@param position this is the position of the returned element
	@return currNode.data this is the data (type E)from node at position
	@return nodeNext.data this is the data (type E)from node at position
	@throws NoSuchElementException if the list is empty
	*/
	public E GetAtPosition(int position) {
		if (this.CheckIfEmpty()) {
			throw new NoSuchElementException();
		}
		else if (0 <= position && position < this.GetLength()) {
			//start at the beginning
			currNode = head;
			if (position == 0) {
				return currNode.data;
			}
			Node nextNode = currNode.next;
			//iterator
			int i = 1;
			while (nextNode.next != null) {
				if (position == i) {
					return nextNode.data;
				}
				i++;
				currNode = currNode.next;
				nextNode = currNode.next;
			}
			if (nextNode.next == null && position == i) {
				return nextNode.data;
			}
		}
		return null;
	}
	
	/**
	This returns the length of the list.
	@return length is the length of the list
	*/
	public int GetLength() {
		return length;
	}
	
	/**
	This checks if the list is empty by looking at the head of the list.
	@return isEmpty is a boolean that is true if the list is empty
	*/
	public boolean CheckIfEmpty() {
		boolean isEmpty = false;
		if (head == null) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	/**
	This checks if the list contains the input element.
	@param element is the element to be searched for in the list
	@return is a boolean that is true if the list contains the element
	*/
	public boolean CheckIfContains(E element) {
		boolean hasElement = false;
		if (head == null) {
			return hasElement;
		}
		else {
			currNode = head;
			while (currNode.next != null) {
				if (currNode.data == element) {
					hasElement = true;
					break;
				}
				currNode = currNode.next;
			}
			if (currNode.next == null && currNode.data == element) {
				hasElement = true;
			}
				return hasElement;
		}
	}
	
	/**
	This is an inner class for nodes.
	*/
	class Node {
		public E data;
		public Node next;
}
	
}

