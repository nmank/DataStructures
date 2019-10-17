/**
This is a class that creates an un-directed, un-weighted graph data structure of elements of generic type E extends graph.
@author Nathan Mankovich
*/
public class GraphBasic <E extends Comparable<E>> extends Graph <E>  {
	
	private E[] nodArray;
	private int minNNCounter;
	
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
	
	public void minPath (int indexA, int indexB) {
		boolean[] markedM = new boolean[size];
		int[] distance = new int[size];
		
		LinkedList<Integer>[] parentNodes = new LinkedList[size];
		Queue<Integer> mptQueue = new Queue<Integer>();
		for (int i = 0; i < size; i++) {
			markedM[i] = false;
			parentNodes[i] = new LinkedList<Integer>();
		}
		
		int index = indexA;
		markedM[index] = true;
		mptQueue.Enqueue(index);
		distance[index] = 0;
		parentNodes[index].AddToFront(-1);
		
		while (index != indexB) {
			for (int i = 0; i < size; i++) {
				if (edges[index][i] != -1 && !markedM[i]) {
					markedM[i] = true;
					mptQueue.Enqueue(i);			
				}
			}
			
			
			int parentNode = index;
			int prevDist = distance[index];
			index = mptQueue.Dequeue();
			System.out.println(parentNode);
			parentNodes[index].AddToBack(parentNode);
			
			for (int i = 0; i < size; i++) {
				if (edges[index][i] != -1) {
					if (distance[i] <= prevDist && distance[i] >= 0) {
						prevDist = distance[i];
					}
				}
			}
			distance[index] = prevDist+1;
			
		}
		
		for (int i = 0; i < size; i++) {
			while (!parentNodes[i].CheckIfEmpty()) {
				System.out.print(parentNodes[i].RemoveFirst());
			}
			System.out.println(" ---- ");
		}
		
		//int pts = 0;
		//for (int i = 0; i < size; i++) {
		//	if (distance[i] == distance[indexB]) {
		//		pts = pts++;
		//	}
		//}
		
		//this.breadthTrav(data[indexA]);
		
		//Stack<Integer> mPath = new Stack<Integer>();
		//boolean[] mkd = new boolean[size];
		//for (int i = 0; i < size; i++) {
		//	mkd[i] = false;
		//}
		//boolean lastIn = false;
		//mPath.push(bfsIndex.Dequeue());
		//while (bfs) {
		//	int cLoc = bfsIndex.Dequeue();
		//	if (edges[mPath.peek()][cLoc] != -1) {
		//		mPath.push(cLoc);
		//	}
		//	else {
		//		mPath.pop();
		//	}
		//}
		
		//while(!mPath.CheckIfEmpty()) {
		//	System.out.println(mPath.pop());
		//}
	}
}