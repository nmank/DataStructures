/**
This is a class that creates a directed, un-weighted graph data structure of elements of generic type E extends graph.
@author Nathan Mankovich
*/
public class GraphDirected <E extends Comparable<E>> extends Graph <E> {
	
	private Queue<Integer> mpsIndex;
	
	/**
	This method initializes a directed graph.
	@param _maxSize is the declared size of the directed graph
	*/
	public GraphDirected(int _maxSize) {
		super(_maxSize);
	}
	
	/**
	This adds an edge to the graph.
	@param elementA the element that the edge connects from 
	@param elementB the element that the edge connects to
	*/
	public boolean addEdge (E elementA, E elementB) {
		if (size == 0) {
			return false;
		}
		int indexA = -1;
		int indexB = -1;
		for (int i = 0; i < size; i++) {
			E currElement = data[i];
			if (currElement.equals(elementA)) {
				indexA = i;
			}
			else if (currElement.equals(elementB)) {
				indexB = i;
			}
		}
		if (indexA == -1 || indexB == -1) {
			return false;
		}
		edges[indexA][indexB] = 1;
		return true;
	}
	
	public int minPath (E elementA, E elementB) {
		int indexA = -1;
		int indexB = -1;
		for (int i = 0; i < size; i++) {
			if (data[i].equals(elementA)) {
				indexA = i;
			}
			if (data[i].equals(elementB)) {
				indexB = i;
			}
		}
		if (indexA == -1 || indexB == -1) {
			return 0;
		}
		else if (edges[indexA][indexB] == -1 && edges[indexB][indexA] == -1) {
			boolean foundA = false;
			boolean foundB = false;
			path = new Queue<Integer>();
			this.breadthTrav();
			int tempIndex = bfsIndex.Dequeue();
			while (!foundA && !foundB) {
				if (tempIndex == indexA) {
					foundA = true;
					path.Enqueue(tempIndex);
				}
				else if (tempIndex == indexB) {
					foundB = true;
					path.Enqueue(tempIndex);
				}
				if (foundA && edges[path.LookAtFirst()][tempIndex] != -1) {
					path.Enqueue(tempIndex);
				}
				if (foundB && edges[path.LookAtFirst()][tempIndex] != -1) {
					path.Enqueue(tempIndex);
				}
				tempIndex = bfsIndex.Dequeue();
			}
			return path.GetSize();
		}
		else {
			return 0;
		}
	}
	
	public E minNextNode() {
		return data[path.Dequeue()];
	}
}