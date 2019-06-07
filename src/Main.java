import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		Graph g = new Graph();

		for (int i = 0; i < args.length; i++) {

			if (args[i].equals("-i") && Arrays.asList(args).contains("-n")) {

				g.initGraph(args[i + 1]);
				g.print();
				break;
			}

			if (args[i].equals("-i")) {

				g.initGraph(args[i + 1]);
				g.print();
			}

			if (args[i].equals("-n")) {

				g.initGraph(Integer.parseInt(args[1]));
				g.print();
			}
		} // for
		fullBFS(g.getAdjMatrix());
	}// main

	public static List<Integer> BFS(boolean[][] adjMatrix, int source, List<Integer> visited) {
	
		int i, j;
		int numVertices = adjMatrix.length;
		Queue<Integer> queue = new LinkedList<>();
		visited.add(source);
		queue.add(source);
		System.out.println(source);
		while (!queue.isEmpty()) {

			i = queue.peek();
			queue.poll();
			for (j = 0; j < numVertices; j++) {
				if (!visited.contains(j) && adjMatrix[i][j]) {
					// mark vertex as visited
					visited.add(j);
					// push vertex into queue
					queue.add(j);
					// print the vertex as result
					System.out.println(j);
				}
			}
		}
		System.out.println();
		return visited;
	}//BFS
	
	public static List<Integer> differenceSets(List<Integer> l1, List<Integer> l2){
		
		List<Integer> difference = new ArrayList<Integer>();
		for(int i : l1) {
			
			if(!l2.contains(i)) {
				
				difference.add(i);
			}
		}
		return difference;
	}
	
	public static void fullBFS(boolean[][] adjMatrix) {
		
		List<Integer> visited = new ArrayList<Integer>();
		List<Integer> difference = new ArrayList<Integer>();
		List<Integer> vertices = new ArrayList<Integer>();
		int numVertices = adjMatrix.length;
		for(int i = 0; i < numVertices; i++) {
			
			vertices.add(i);
		}
		difference = vertices;
		while(!difference.isEmpty()) {
			int currentVertice = difference.get(0);
			//add current to visited
			visited = BFS(adjMatrix, currentVertice, visited);
			difference = differenceSets(vertices, visited);
		}
	}
}