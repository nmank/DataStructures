

/**
A public class for a max heap of elements of type generic parameter E.
@author Nathan Mankovich
@param E generic input element data type
*/
public class MaxHeap<E extends Comparable<E>> {
	
	private int maxSize;
	private int size;
	private E[] itms;
	
	/**
	The max heap conditions as it would instantiated in a class.
	@param _maxSize the user input size
	*/
	public MaxHeap(int _maxSize) {
		size = 0;
		maxSize = _maxSize;
		itms = (E[]) new Comparable[maxSize];
	}
	
	/**
	Calculates the index of the left child element of in the itms array.
	@param old is the index of the parent element
	@return 2*old+1 is the index of the child element
	*/
	private int  ChildIndex(int old) {
		return 2*old+1;
	}
	
	/**
	Calculates the index of the parent element of in the itms array.
	@param old is the index of the child element
	@return (old-1)/2 is the index of the parent element
	*/
	private int ParentIndex(int old) {
		return (old-1)/2;
	}
	
	/**
	Returns the maximum item in the maxheap.
	@return itms[0].toString() (data type E)is the first element in the itms array which is the greatest element in the heap
	*/
	public E GetMax() {
		return itms[0]
		;
	}
	
	/**
	Removes the maximum item in the maxheap.
	@return oldMax is the removed old maximum element in the heap of data type E
	*/
	public E RemoveMax() {
		E oldMax = itms[0];
		itms[0] = itms[size-1];
		size--;
		SiftDown();
		return oldMax;
	}
	
	/**
	Adds a new element to the maxheap.
	@param element is the element to be input into the maxheap.
	*/
	public void Add(E element) {
		size++;
		if (size > maxSize) {
			throw new NullPointerException();
		}
		itms[size-1] = element;
		SiftUp();
	}
	
	/**
	Sifts an element from the bottom (last element in itms) of the heap to its correct place in the heap.
	*/
	private void SiftUp() {
		int k = size - 1;
		boolean done = false;
		while (k > 0 && !done) {
			int p = ParentIndex(k);
			E element = itms[k];
			E parent = itms[p];
			
			if (element.compareTo(parent) > 0) {
				itms[k] = parent;
				itms[p] = element;
				k = p;
			}
			else {
				done = true;
			}
		}
	}
	
	/**
	Sifts an element from the top (first element in itms) of the heap to its correct place in the heap.
	*/
	private void SiftDown() {
		int k = 0;
		int l = ChildIndex(k);
		boolean done = false;
		while (l < size && !done) {
			int max = l;
			int r = l + 1;
			if (r < size) {
				if (itms[r].compareTo(itms[l]) > 0) {
					max++;
				}
			}
			if (itms[k].compareTo(itms[max]) < 0 ) {
				E element = itms[k];
				E child = itms[max];
				itms[k] = child;
				itms[max] = element;
				k = max;
				l = ChildIndex(k);
			}
			else {
				done = true;
			}
		}
	}
}

