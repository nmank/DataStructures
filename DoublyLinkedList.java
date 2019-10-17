import java.util.NoSuchElementException;

/**
A public for a doubly linked list of elements of type generic parameter E.
@author Nathan Mankovich
@param E generic input element data type
*/
public class DoublyLinkedList<E> {
	
	//name head, tail, currNode and the list length
	private Node head;
	private Node tail;
	private Node currNode;
	private int length;
	
	/**
	This contains the initial conditions of the linked list.
	*/
	public DoublyLinkedList() {
		//empty list conditions
		head = null;
		tail = null;
		length = 0;
	}
	
	/**
	This adds an element of type E to the front of the list.
	@param element the element to be added
	*/
	public void AddToFront(E element) {
		//if the length is zero point head and tail to the newNode
		if (this.GetLength() == 0) {
			Node newNode = new Node();
			newNode.data = element; 
			head = newNode;
			tail = newNode;
		}
		//if there is one element or more
		else {
			Node newNode = new Node();
			newNode.data = element;
			currNode = head;
			newNode.next = currNode;
			head = newNode;
			currNode.prev = newNode;
		}
		length++;
	}
	
	/**
	This adds an element of type E to the back of the list.
	@param element the element to be added
	*/
	public void AddToBack(E element) {
		//if the length is zero point head and tail to the newNode
		if (this.GetLength() == 0) {
			Node newNode = new Node();
			newNode.data = element; 
			head = newNode;
			tail = newNode;
		}
		//if there is one element or more
		else {
			Node newNode = new Node();
			currNode = tail;
			newNode.data = element;
			newNode.prev = currNode;
			tail = newNode;
			currNode.next = newNode;	
		}
		length++;
	}
	
	/**
	This adds an element of type E after an refElement of type E to the list.
	@param element the element to be added
	@param refElement the refElement that goes after the element in the list
	*/
	public void AddAfter (E element, E refElement) {
		//if the length is zero point head and tail to the newNode
		if (this.GetLength() == 0) {
			Node newNode = new Node();
			newNode.data = element; 
			head = newNode;
			tail = newNode;
			length++;
		}
		else {
			//start at the beginning
			currNode = head;
			while (currNode.next != null) {
				if (currNode.data.equals(refElement)) {
					//newNode and fill it up
					Node newNode = new Node();
					newNode.data = element;
					//pointers
					Node nextNode = currNode.next;
					newNode.next = currNode.next;
					currNode.next = newNode;
					newNode.prev = currNode;
					nextNode.prev = newNode;
					length++;
					return;
				}
				currNode = currNode.next;
			}
			Node lastNode = currNode.next;
			if (lastNode == null && lastNode.data.equals(refElement)) {
				this.AddToBack(element);
			}
			length++;
		}
	}
	
	/**
	This adds an element of type E at location position.
	@param element the element to be added
	@param position the position (first element is at position 0) in the linked list where the element is to be inserted
	@throws NoSuchElementException if there is nothing at the position
	*/
	public void InsertAtPosition (E element, int position) {
		//if the position is in the first half step forward
		if (0 <= position && position*2 <= this.GetLength()){
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
			while (i*2 <= this.GetLength()) {
				if (position == i) {
					//newNode and fill it up
					Node newNode = new Node();
					newNode.data = element;
					//pointers
					newNode.next = currNode.next;
					currNode.next = newNode;
					newNode.prev = currNode;
					nextNode.prev = newNode;
					//exit the loop
					break;
				}
				//add one to the iterator
				i++;
				//point the nodes foreward
				currNode = currNode.next;
				nextNode = currNode.next;
			}
			//if we are at the last element add it in that slot 
			//and push the other element up one
			if (position == i++) {
				//make a newNode
				Node newNode = new Node();
				//put data in it
				newNode.data = element;
				//pointers
				newNode.next = nextNode;
				currNode.next = newNode;
				newNode.prev = currNode;
				nextNode.prev = newNode;
			}
			length++;
		}
		//if the position is in the last half step backward
		else if (this.GetLength() < position*2 && position < this.GetLength()) {
			//add it to the front
			if (position == this.GetLength()-1) {
				this.AddToBack(element);
				length++;
				return;
			}
			//start at the beginning
			currNode = tail;
			Node prevNode = currNode.prev;
			//iterator
			int i = this.GetLength()-1;
			while (i*2 > this.GetLength()) {
				if (position == i) {
					//newNode and fill it up
					Node newNode = new Node();
					newNode.data = element;
					//pointers
					newNode.next = prevNode.next;
					prevNode.next = newNode;
					newNode.prev = prevNode;
					currNode.prev = newNode;
					//increase the length
					length++;
					//exit the loop
					break;
				}
				//add one to the iterator
				i--;
				//point the nodes foreward
				currNode = currNode.prev;
				prevNode = currNode.prev;
			}
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
			if (this.GetLength() == 1) {
				//may be wrong
				head = null;
				tail = null;
			}
			else {
				//point the head to the new first node
				head = currNode.next;
				currNode = head;
				//point the prev pointer first node to null
				currNode.prev = null;
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
		//in case there is nothing there
		if (head == null) {
			throw new NoSuchElementException();
		}
		else {
			//make a node the head
			currNode = tail;
			E removedData = currNode.data;
			//make the head reference the node following the current node
			if (this.GetLength() == 1) {
				//may be wrong
				head = null;
				tail = null;
			}
			else {
				//point the head to the new first node
				tail = currNode.prev;
				currNode = tail;
				currNode.next = null;
			}
			//subtract one off the length
			length--;
			return removedData;
		}
	}
	
	/**
	This removes a certain element in the list.
	@param element this is the element to be removed
	@return removedData the data (type E) that has been removed from the list
	@throws NoSuchElementException if the list is empty
	*/
	public E RemoveCertain(E element) {
		if (this.CheckIfEmpty()) {
			throw new NoSuchElementException();
		}
		//start at the beginning
		currNode = head;
		if (currNode.data == element) {
			E removedData = currNode.data;
			if (this.GetLength() == 1) {
				head = null;
				tail = null;
			}
			else {
				head = currNode.next;
				currNode.prev = null;
			}
			length--;
			return removedData;
		}
		else {
			Node nextNode = currNode.next;
			while (nextNode.next != null) {
				if (nextNode.data == element) {
					Node snextNode = nextNode.next;
					E removedData = nextNode.data;
					currNode.next = nextNode.next;
					snextNode.prev = currNode;
					nextNode = null;
					length--;
					return removedData;
				}
				currNode = currNode.next;
				nextNode = currNode.next;
			}
			if (nextNode.next == null && nextNode.data == element) {
				return this.RemoveLast();
			}
			else {
				return null;
			}
		}
	}
	
	/**
	The returns the first element in the list.
	@return currNode.data this is the data (type E)from the first node
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
			currNode = tail;
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
			if (nextNode.next == null) {
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
		public Node prev;
}
	
}

