/**
This is a class that creates an un-directed, weighted graph data structure of elements of generic type E extends graph.
@author Nathan Mankovich
*/
public class GraphWeighted <E extends Comparable<E>> extends Graph<E> {
	
	/**
	This method initializes the weighted undirected graph.
	@param _maxSize is the declared size of the directed graph
	*/
	public GraphWeighted(int _maxSize) {
		super(_maxSize);
	}
	
	/**
	This adds an edge to the graph.
	@param indexA an element that is connected to the edge
	@param indexB an element that is connected to the edge
	@param abWeight is the integer weight of the edge
	@return false if the graph is empty
	@return true if the edge was added
	*/
	public boolean addEdge (int indexA, int indexB, int abWeight) {
		if (size == 0) {
			return false;
		}
		edges[indexA][indexB] = abWeight;
		edges[indexB][indexA] = abWeight;
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
}