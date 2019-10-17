public class tGraph {
	
	public static void main(String[] args) {
		
		Graph<Integer> G = new Graph<Integer>(10);
		
		G.addNode(1);
		G.addNode(3);
		G.addNode(4);
		G.addNode(8);
		G.addNode(10);
		G.addNode(2);
		G.addNode(5);
		G.addNode(6);
		G.addNode(7);
		G.addNode(9);
		
		G.addEdge(9,5, 1);
		G.addEdge(9,2,15);
		G.addEdge(9,1,3);
		G.addEdge(1,9,4);
		G.addEdge(1,3,5);
		G.addEdge(5,1,10);
		G.addEdge(1,5,12);
		G.addEdge(5,4,13);
		G.addEdge(4,7,1);
		G.addEdge(4,8,5);
		G.addEdge(8,4,3);
		G.addEdge(4,0,3);
		G.addEdge(3,2,2);
		G.addEdge(5,6,4);
		
		
		//G.removeEdge(3,6);
		
		//G.removeNode(6);
		
		System.out.println("depth traverse");
		G.depthTrav(2);
		for (int i = 0; i < 9; i++) {
			System.out.println(G.dNextNode());
		}
		
		System.out.println("breadth traverse");
		G.breadthTrav(2);
		for (int i = 0; i < 10; i++) {
			System.out.println(G.bNextNode());
		}
		
		System.out.println("highest valued path");
		G.optimalTrav(1);
		System.out.println(G.oNextNode());
		System.out.println(G.oNextNode());
		System.out.println(G.oNextNode());
		System.out.println(G.oNextNode());
	}
	
}