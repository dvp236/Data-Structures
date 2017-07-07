package graph;

import bag.Bag;

public class Graph {
	private final int V;
	private int E;
	private Bag<Integer>[] adj;
	
	public Graph(int V) {
		if ( V < 0 ) throw new IllegalArgumentException("Number of Vertices must be positive");
		
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for ( int v = 0; v < V; v++ ) {
			adj[v] = new Bag<Integer>();
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
		 StringBuilder s = new StringBuilder();
	        s.append(V + " vertices, " + E + " edges \n");
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (int w : adj[v]) {
	                s.append(w + " ");
	            }
	            s.append("\n");
	        }
	        return s.toString();
	}
	

}
