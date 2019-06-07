import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Graph {
	
	private int numVertices;
	private boolean adjMatrix[][];
	
	public void initGraph(int numVertices) {
		
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
		
		for(int i = 0; i < numVertices; i++) {
			
			for(int j = 0; j < numVertices; j++) {
				
				adjMatrix[i][j] = false;
			}
		}
		
		for(int i = 0; i < numVertices; i++) {
			
			for(int j = 0; j < numVertices; j++) {
				
				if(getRandomBoolean()) {
					
					addEdge(i, j);
				}
			}
		}
	}
	
	public void initGraph(String filename) {
		
		try {
			
			Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
			String firstLine = reader.nextLine();
			int numVertices = Integer.parseInt(firstLine);
			this.numVertices = numVertices;
			adjMatrix = new boolean[numVertices][numVertices];
			while(reader.hasNextLine()) {
				
				for(int i = 0; i < numVertices; i++) {
					
					String[] line = reader.nextLine().trim().split(" ");
					for(int j = 0; j < numVertices; j++) {
						
						if(line[j].equals("1")) {
							
							line[j] = "true";
						}
						else {
							
							line[j] = "false";
						}
						adjMatrix[i][j] = Boolean.parseBoolean(line[j]);
					}
				}
			}
			reader.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	public boolean getRandomBoolean() {
		
		return Math.random() < 0.5;
	}
	
	public boolean[][] getAdjMatrix(){
		
		return adjMatrix;
	}
	
	public void addEdge(int i, int j) {
		
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}
	
	public boolean isEdge(int i, int j) {
		
		return adjMatrix[i][j];
	}
	
	public void print() {
		
		for(int i = 0; i < numVertices; i++) {
			
			for(int j = 0; j < numVertices; j++) {
				
				System.out.print(adjMatrix[i][j] + " ");
			}
			
			System.out.println();
		}
	}
}
