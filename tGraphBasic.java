public class tGraphBasic {
	
	public static void main(String[] args) {
		
		GraphBasic<Integer> G = new GraphBasic<Integer>(10);
		
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
		
		G.addEdge(9,5);
		G.addEdge(9,2);
		G.addEdge(9,1);
		G.addEdge(1,3);
		G.addEdge(5,1);
		G.addEdge(5,4);
		G.addEdge(4,7);
		G.addEdge(4,8);
		G.addEdge(4,0);
		G.addEdge(3,2);
		G.addEdge(5,6);
		
		System.out.println("depth traverse");
		G.depthTrav(1);
		for (int i = 0; i < 10; i++) {
			System.out.println(G.dNextNode());
		}
		
		System.out.println("breadth traverse");
		G.breadthTrav(3);
		for (int i = 0; i < 10; i++) {
			System.out.println(G.bNextNode());
		}
		
		//System.out.println("min path: "+ G.minPath(1,4));
		G.minPath(1,4);
		int[] path = G.mNextNode(1,4);
		
		for (int i = 0; i < path.length; i++) {
			System.out.println(path[i]);
		}
		
	}
	
}