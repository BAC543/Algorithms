import java.util.*;

public class Dijkstra {

	//private Set <Integer> settled;
	
	
	
	// Dijkstra's algorithm to find shortest path from source vertex s to all other nodes in a weighted graph G
		
	public static int[] dijkstra(WeightedGraph G, int s) {

		int[] dist = new int[G.size()]; // dist[v]: the estimated shortest distance between the source vertex s and v

		int[] pred = new int[G.size()]; // pred[v]: the preceding node of v on the shorest path from s to v

		boolean[] ST = new boolean[G.size()]; 
		// ST[]: shortest path tree rooted at the source vertex s
		// ST[v] is true if v has been added to the shorest path tree rooted at s, false otherwise
		// The tree is empty initially, therefore all false initially
		
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE; // set to infinity initially
		}
		
		dist[s] = 0; // the shortest distance between source vertex s and s itself must be 0
		
		/*		
		Complete the method here to find the shorest path from s to every other vertex in the graph
		Return the array pred[]
		Hint: Follow the pseudocode of Dijkstra's algorithm in the slides
		*/
		
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		
		minQ.add(s);
		
		while(!minQ.isEmpty())
		{
			//finds the min vertex
			int newMin = minQ.remove();
			
			//Visited
			ST[newMin] = true;
			
			//Loops through each vertex
			for(int count = 0; count <G.size(); count++)
				{
					// previous distance value  > Weight of edge
					// checks if the vertex has been visited
					// finds if the two vertexes are edges
					if(dist[count] > dist[newMin] + G.getWeight(newMin, count)  && !ST[count] && G.isEdge(newMin, count))
					{
						dist[count] = dist[newMin] +dist[newMin] + G.getWeight(newMin, count );
						pred[count] = newMin;
						//pushes the neighboring vertexes onto the Queue 
						minQ.add(count);
					}//if
				}//for
		}//while
		

		return pred; // Return the preceding node array
	}

	private static int minVertex(int[] dist, boolean[] ST) {
		// find a vertex v that has NOT been added to the shortest path tree ST, and has the minimum estimated distance d[v]
		int x = Integer.MAX_VALUE;
		int v = -1; // graph not connected, or all vertices have been added to the shortest path tree
		
		for (int i = 0; i < dist.length; i++) {
			// examine nodes one by one
			if (!ST[i] && dist[i] < x) { 
				// vertex i has NOT been added to the shorest path tree yet, and has a smaller estimated distance to s
				v = i;
				x = dist[i];
			}
		}
		
		return v; 
	}

	public static void printPath(WeightedGraph G, int[] pred, int s, int e) {
		// print the shortest path from s to e
		java.util.ArrayList path = new java.util.ArrayList();
		int x = e;
		while (x != s) {
			// read nodes on the path from s to e one by one backwards, starting from the destination vertex e
			path.add(0, G.getLabel(x));
			// add the node to the front of the path/list
			x = pred[x];
			// read its preceding node on the path
		}
		path.add(0, G.getLabel(s));
		// add the source vertex s to the front of the list/path
		System.out.println(path);
	}

}//Dijkstra