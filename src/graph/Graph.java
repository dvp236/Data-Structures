package graph;

import bag.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Graph(int V) {
		if ( V < 0 ) throw new IllegalArgumentException("Number of Vertices must be positive");
		
		this.V = V;
		this.E = 0;
		//initialize array of bags
		adj = (Bag<Integer>[]) new Bag[V];
		for ( int v = 0; v < V; v++ ) {
			//initialize bag for each one
			adj[v] = new Bag<Integer>();
		}
		
	}
	
	//read from input
	public Graph(In in) {
		this.V = in.readInt();
		adj = (Bag<Integer>[])new Bag[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
		
		int totalEdges = in.readInt();
		for(int e = 0; e < totalEdges; e++) {
			int v = in.readInt();
			int u = in.readInt();
			validateVertex(v);
			validateVertex(u);
			addEdge(v, u); 
		}
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	private void validateVertex(int v) {
		if ( v < 0 || v > V-1) 
			throw new IllegalArgumentException("Vertex not between 0 and V");	
	}
	
	public void addEdge(int v, int u) {
		validateVertex(v);
		validateVertex(u);
		E++;
		adj[v].add(u);
		adj[u].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges \n");
		for(int v = 0; v < V; v++) {
			sb.append(v + " : ");
			for(int u: adj[v]) {
				sb.append(u + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
		 
	}
	
	public static void main(String[] args) {
		System.out.println("graph example");
		
		Graph G = new Graph(10);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		G.addEdge(2, 4);
		G.addEdge(2, 5);
		
		System.out.println(G.toString());
		
		//System.out.println(G.V());
		System.out.println("degree of vertex 2: " +G.degree(2));
		
	}

}
