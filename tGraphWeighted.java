public class tGraphWeighted {
	
	public static void main(String[] args) {
		
		GraphWeighted<Integer> G = new GraphWeighted<Integer>(10);
		
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
		G.addEdge(1,3,5);
		G.addEdge(5,1,10);
		G.addEdge(5,4,13);
		G.addEdge(4,7,1);
		G.addEdge(4,8,5);
		G.addEdge(4,0,3);
		G.addEdge(3,2,2);
		G.addEdge(5,6,4);
		
		System.out.println("depth traverse");
		G.depthTrav(1);
		for (int i = 0; i < 10; i++) {
			System.out.println(G.dNextNode());
		}
		
		System.out.println("breadth traverse");
		G.breadthTrav(1);
		for (int i = 0; i < 10; i++) {
			System.out.println(G.bNextNode());
		}
		
	}
	
}