/**
This is a class that creates a directed, weighted graph data structure of elements of generic type E.
@author Nathan Mankovich
*/
public class Graph <E extends Comparable<E>> {
	
	//various public variables used in extensions of Graph
	public int edges[][];
	public int size;
	public int maxSize;
	public E[] data;
	public Queue<Integer> bfsIndex;
	public Queue<Integer> dfsIndex;
	
	/**
	This method initializes a graph.
	@param _maxSize is the declared size of the graph
	*/
	public Graph(int _maxSize) {
		maxSize = _maxSize;
		size = 0;
		data = (E[]) new Comparable[maxSize];
		edges = new int[maxSize][maxSize];
	}
	
	/**
	This adds a Node to the graph and sets the edges for that node at -1.
	@param element is the element to be added
	*/
	public void addNode (E element) {
		data[size] = element;
		for (int i = 0; i <= size; i++) {
			edges[i][size] = -1;
			edges[size][i] = -1;
		}
		size++;
	}
	
	/**
	This adds an edge to the graph.
	@param indexA the int that the edge connects from 
	@param indexB the int that the edge connects to
	@param abWeight is the integer weight for the edge that points from indexA to indexB
	@return false if the graph is empty
	@return true if the edge has been added
	*/
	public boolean addEdge (int indexA, int indexB, int abWeight) {
		if (size == 0) {
			return false;
		}
		edges[indexA][indexB] = abWeight;
		return true;
	}
	
	/**
	This method removes a Node from the graph.
	@param index the node to be removed
	@return false if the graph is empty
	@return true if the node is removed
	@return false if the node is not removed
	*/
	public boolean removeNode (int index) {
		if (size == 0) {
			return false;
		}
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (index == i) {
				j = i;
				while (j < size - 1) {
					data[j] = data[j+1];
					for (int k = 0; k < size - 1; k ++) {
						edges[j][k] = edges[j+1][k];
						edges[k][j] = edges[k][j+1];
					}
					j++;
				}
				data[j] = null;
				for (int k = 0; k < size; k ++) {
						edges[j][k] = -1;
						edges[k][j] = -1;
				}
				size--;
				return true;
			}
		}
		return false;
	}
	
	/**
	This method removes an edge from the graph.
	@param elementA the node that the edge points from
	@param elementB is the node that the edge points to
	@return false if the graph is empty
	@return true if the edge is removed
	*/
	public boolean removeEdge (int indexA, int indexB) {
		if (size == 0) {
			return false;
		}
		edges[indexA][indexB] = -1;
		return true;
	}
	
	/**
	This method initializes a breadth traversal by calling bft.
	@param element the first node in the traversal
	*/
	public void breadthTrav (E element) {
		boolean[] markedB = new boolean[size];
		bfsIndex = new Queue<Integer>();
		Queue<Integer> bfsQueue = new Queue<Integer>();
		for (int i = 0; i < size; i++) {
			markedB[i] = false;
		}
		int index = 0;
		while (data[index] != element) {
			index++;
		}
		markedB[index] = true;
		bfsIndex.Enqueue(index);
		bfsQueue.Enqueue(index);
		bfsIndex = this.bft(markedB, index, bfsIndex, bfsQueue);
	}
	
	/**
	This method traverses the graph breadth first using recursion.
	@param markedB a boolean array that marks visited nodes in the traversal as true
	@param index is the current index of the visited nodes in the graph
	@param bfsIndex is a queue of indexes that stores visited nodes
	@param bfsQueue is a queue that stores the indexes of the items that have been visited, but may need to be visited again
	@return bfsIndex queue of the indexes of the elements in breadth first order.
	*/
	private Queue<Integer> bft(boolean[] markedB,int index, Queue<Integer> bfsIndex, Queue<Integer> bfsQueue) {
		if (dfsIndex.GetSize() <= size) {
			for (int i = 0; i < size; i++) {
				if (edges[index][i] != -1 && !markedB[i]) {
					markedB[i] = true;
					bfsIndex.Enqueue(i);
					bfsQueue.Enqueue(i);
					bft(markedB, index, bfsIndex, bfsQueue);				
				}
			}
			if (bfsQueue.GetSize() > 0) {
				index = bfsQueue.Dequeue();
				bft(markedB, index, bfsIndex, bfsQueue);
			}
		}
		return bfsIndex;
	}
	
	/**
	This method uses the bfsIndex to return the element in the graph at the next index in the breadth first queue.
	@return data[bfsIndex.Dequeue()] e the element at the next index in the bfsIndex queue
	*/
	public E bNextNode() {
		return data[bfsIndex.Dequeue()];
	}
	
	/**
	This method initializes a depth traversal by calling dft.
	*/
	public void depthTrav (E element) {
		boolean[] markedD = new boolean[size];
		dfsIndex = new Queue<Integer>();
		Stack<Integer> dfsStack = new Stack<Integer>();
		for (int i = 0; i < size; i++) {
			markedD[i] = false;
		}
		int index = 0;
		while (data[index] != element) {
			index++;
		}
		markedD[index] = true;
		dfsIndex.Enqueue(index);
		dfsStack.push(index);
		dfsIndex = this.dft(markedD, index, dfsIndex, dfsStack);
	}
	
	/**
	This method traverses the graph depth first using recursion.
	@param markedD a boolean array that marks visited nodes in the traversal as true
	@param index is the current index of the visited nodes in the graph
	@param dfsIndex is a queue of indexes that stores visited nodes
	@param dfsStack is a stack that stores the indexes of the items that have been visited, but may need to be visited again
	@return dfsIndex queue of the indexes of the elements in depth first order.
	*/	
	private Queue<Integer> dft (boolean[] markedD, int index, Queue<Integer> dfsIndex, Stack<Integer> dfsStack) {
		if (dfsIndex.GetSize() <= size) {
			for (int i = 0; i < size; i++) {
				if (edges[index][i] != -1 && !markedD[i]) {
					index = i;
					markedD[index] = true;
					dfsIndex.Enqueue(index);
					dfsStack.push(index);
					dft(markedD, index, dfsIndex, dfsStack);				
				}
			}
			if (dfsStack.GetSize() > 0) {
				index = dfsStack.pop();
				dft(markedD, index, dfsIndex, dfsStack);
			}
		}
		return dfsIndex;
	}

	/**
	This method uses the dfsIndex to return the element in the graph at the next index in the depth first queue.
	@return data[dfsIndex.Dequeue()] e the element at the next index in the dfsIndex queue
	*/
	public E dNextNode() {
		return data[dfsIndex.Dequeue()];
	}
}