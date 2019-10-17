/**
This is a class that creates an un-directed, un-weighted graph data structure of elements of generic type E extends graph.
@author Nathan Mankovich
*/
public class GraphBasic <E extends Comparable<E>> extends Graph <E>  {
	
	private Integer[] mptIndex;
	private int indexA;
	private int indexB;
	
	/**
	This method initializes the basic graph.
	@param _maxSize is the declared size of the directed graph
	*/
	public GraphBasic(int _maxSize) {
		super(_maxSize);
	}
	
	/**
	This adds an un-directed edge to the graph that connects elementA and elementB.
	@param indexA an element that is connected to the edge 
	@param indexB an element that is connected to the edge 
	*/
	public boolean addEdge (int indexA, int indexB) {
		if (size == 0) {
			return false;
		}
		edges[indexA][indexB] = 1;
		edges[indexB][indexA] = 1;
		return true;
	}
	
	/**
	This method removes an edge from the graph.
	@param indexA the node that the edge points from
	@param indexB is the node that the edge points to
	@return false if the graph is empty
	@return true if the edge is removed
	*/
	public boolean removeEdge (int indexA, int indexB) {
		if (size == 0) {
			return false;
		}
		edges[indexA][indexB] = -1;
		edges[indexB][indexA] = -1;
		return true;
	}
	
	/**
	This method finds the shortest path between two nodes in the graph.
	@param indexA the index of the starting node
	@param indexB the index of the ending node
	*/
	public void minPath (int indexA, int indexB) {
		boolean[] markedM = new boolean[size];
		mptIndex = new Integer[size];
		Queue<Integer> mptQueue = new Queue<Integer>();
		for (int i = 0; i < size; i++) {
			markedM[i] = false;
		}
		int index = indexA;
		markedM[index] = true;
		mptIndex[index] = null;
		mptQueue.Enqueue(index);
		mptIndex = this.mp(markedM, index, indexB, mptIndex, mptQueue);
	}
	
	/**
	This method traverses the graph breadth first using recursion.
	@param markedM a boolean array that marks visited nodes in the traversal as true
	@param index is the current index of the visited nodes in the graph
	@param indexB is the index of the last node in the traversal
	@param mptIndex is a queue of indexes that stores visited nodes
	@param mptQueue is a queue that stores the indexes of the items that have been visited, but may need to be visited again
	@return mptIndex queue of the indexes of the elements in breadth first order.
	*/
	private Integer[] mp(boolean[] markedM, int index, int indexB, Integer[] mptIndex, Queue<Integer> mptQueue) {
		if (dfsIndex.GetSize() <= size) {
			for (int i = 0; i < size; i++) {
				if (edges[index][i] != -1 && !markedM[i]) {
					markedM[i] = true;
					mptIndex[i] = index;
					mptQueue.Enqueue(i);
					mp(markedM, index, indexB, mptIndex, mptQueue);				
				}
			}
			if (mptQueue.GetSize() > 0) {
				index = mptQueue.Dequeue();
				mp(markedM, index, indexB, mptIndex, mptQueue);
			}
		}
		return mptIndex;
	}
	
	/**
	This method uses the mptIndex to return the element in the graph at the next index in the travered nodes queue.
	@param indexA is the starting index
	@param indexB is the ending index
	@return thePath is an array of node indeces for the traversal from indexA to indexB
	*/
	public int[] mNextNode(int indexA, int indexB) {
		//for (int i =0; i < size; i++) {
			//System.out.println(mptIndex[i]);
			//System.out.println("___");
		//}
		Stack<Integer> sRet = new Stack<Integer>();
		System.out.println(indexB);
		sRet.push(indexB);
		while (sRet.peek() != indexA) {
			sRet.push(mptIndex[sRet.peek()]);
		}
		
		int[] thePath = new int[sRet.GetSize()];
		for (int i = 0; i < thePath.length; i++) {
			thePath[i] = sRet.pop();
		}
		return thePath;
	}
}