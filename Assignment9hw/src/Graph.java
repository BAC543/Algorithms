
import java.util.Random;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
	
	private int[][] edges; // adjacency matrix
	private Object[] labels;

	public Graph(int n) {
		// n: size of nodes
		// weighted graph
		edges = new int[n][n];
		// edges[i][j] saves the weight of edge i->j, assume weight > 0
		// for unweighted graph 
		// set edges[i][j] to 1 if there exists an edge i->j
		// set edges[i][j] to 0 otherwise
		labels = new Object[n];
	}
	
	public void setLabel(int vertex, Object label) {
		//vertex: vertex index, label: vertex name
		labels[vertex] = label;
		
	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}


	public int size() {
		return edges.length;
	}


	public void addEdge(int source, int target, int w) {
		//w for weight
		edges[source][target] = w;
		edges[target][source] = w;// undirected graph
	}
	
	public void addEdgeD (int source, int target, int w)
	{
		edges[source][target] = w; //directed graph
	}//addEdgeD

	public boolean isEdge(int source, int target) {
		//if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target) {
		edges[source][target] = 0;
		edges[target][source] = 0;// undirected graph
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		// find neighbors of a given vertex
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public void print() {
		for (int j = 0; j < edges.length; j++) {
			//System.out.print(labels[j] + ": ");
			for (int i = 0; i < edges[j].length; i++) {
				if (edges[j][i] > 0)
					System.out.println(labels[j] + " -> "+ labels[i] + ":" + edges[j][i] + " ");
			}
			System.out.println();
		}
	}

	
	public int getUnvisitedNeighbor(int vertex, boolean[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1

		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] == false)
				return i;
		}
		return -1;
	}

	
	public void dfs() {// DFS using stack
		
		int n = edges.length;
		boolean visited[] = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			visited[i]= false;// Reset the visited matrix 
		}
		
		//Pick the starting node randomly
		Random rand = new Random();
		int randNum = rand.nextInt(n);
		
		Stack<Integer> theStack = new Stack();
		
		//Visit the starting node
		visited[randNum]= true; 
		System.out.println("Visited: "+ labels[randNum]);
		theStack.push(randNum);
 
		while (!theStack.isEmpty()) {
			int neighbor = getUnvisitedNeighbor(theStack.peek(),visited);
			if (neighbor == -1) {
				// all neighbors are visited
				// pop the top vertex out
				theStack.pop();
			} else {
				// if there exists at least one unvisited neighbor
				visited[neighbor] = true;
				System.out.println("Visited: "+ labels[neighbor]);
				theStack.push(neighbor);
			}
		}
 		

	}
	
	
	public void bfs() 
	{// BFS
	// Complete this method to traverse a graph using BFS
	// Start BFS from a randomly selected node in the graph
	// Note: Follow the pseudocode of BFS() in slides. 
	// Note: You may want to read existing methods such as DFS() in the Graph class to learn how to code on a graph.
	//Pick the starting node randomly
		
	Random rand = new Random();
		
	int n = edges.length;
	int randNum = rand.nextInt(n);
		
	boolean visited[] = new boolean[n];
	for (int i = 0; i < n; i++) 
			visited[i]= false;// Reset the visited matrix 
	
	Queue <Integer> theQueue = new LinkedList ();
	
	//Visit the starting node
	visited[randNum]= true; 
	System.out.println("Visited: "+ labels[randNum]);
	theQueue.add(randNum);
	try
	{
		while(!theQueue.isEmpty())
		{
			
			int neighbor = getUnvisitedNeighbor(theQueue.peek(),visited);
			if (neighbor == -1) 
			{
				// all neighbors are visited
				// pop the top vertex out
				theQueue.remove();
			}//if
			else
			{
				// if there exists at least one unvisited neighbor
				visited[neighbor] = true;
				System.out.println("Visited: "+ labels[neighbor]);
				theQueue.add(neighbor);	
			}//else
		}//while
	}//try
	catch(NullPointerException e )
	{
		System.out.println("Null pointer excep");
	}//catch

	}//bfs
	

	
	
	

	public static void main(String args[]) 
	{
		
		// An example to create a graph using the Graph class
		final Graph t = new Graph(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge(0, 1, 1);
		t.addEdge(0, 5, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);
		t.print();
		t.dfs();
		// Test BFS
		t.bfs();
		// Complete the main method to create an ajacency list for the graph in Assignment 9 Problem 10 
		// and print its adjacency list, then call bfs() on the graph you create
		// Note: You may want to read the existing adjacency matrix edges[][] in the Graph class to learn how to represent a graph. The adjacency list would be very similar. 
		
		final Graph g = new Graph(6);
		g.setLabel(0, "0");
		g.setLabel(1, "1");
		g.setLabel(2, "2");
		g.setLabel(3, "3");
		g.setLabel(4, "4");
		g.setLabel(5, "5");
		g.addEdgeD(0, 1, 1);
		g.addEdgeD(0, 2, 1);
		g.addEdgeD(1, 2, 1);
		g.addEdgeD(1, 3, 1);
		g.addEdgeD(2, 3, 1);
		g.addEdgeD(3, 4, 1);
		g.addEdgeD(4, 5, 1);
		g.print();
		g.bfs();
		
	}//main

}//Graph
