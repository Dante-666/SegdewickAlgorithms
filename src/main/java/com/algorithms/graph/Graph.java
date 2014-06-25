package com.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * This is a local API for a basic graphs with which we can implement the
 * algorithms. It internally uses the Adjacency-list Representation to store
 * graph data in spite of the linked list and array representation since it is
 * the most favored one.
 * 
 * Currently, only Integers are supported but will extend this to support other
 * native objects.
 * 
 * Also this implements an undirected graph and thus has multiple edges. For the
 * sake of simplicity, the edges will be counted once.
 * 
 * Also the graph can be initialized only once with the current settings.
 * 
 * Design Pattern : Decouple the Graph datatype from the Graph Processing
 * algorithms. Pass the Graph to the routine and query it for information.
 * 
 * @author Dante
 * @version 1.0
 * 
 */
public class Graph {

	private final int V;
	private final int E;
	private Bag<Integer>[] adj;

	/**
	 * Constructs an empty graph with the number of vertices and edges passed
	 * in.
	 * 
	 * @param V
	 *            The number of Vertices
	 * @param E
	 *            The number of Edges
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V, int E) {
		this.V = V;
		this.E = E;
		adj = (Bag<Integer>[]) new HashBag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new HashBag<Integer>();
		}
	}

	/**
	 * Constructs a graph from an Input stream like a file. The file should have
	 * data arranged in this format given below.
	 * 
	 * <no. of vertices> \n <no. of edges> \n <relationship>
	 * 
	 * @param in
	 */
	@SuppressWarnings("unchecked")
	public Graph(InputStream in) throws IOException, NullPointerException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		String[] tempString = null;

		line = reader.readLine();
		this.V = Integer.parseInt(line);

		line = reader.readLine();
		this.E = Integer.parseInt(line);

		adj = (Bag<Integer>[]) new HashBag[this.V];
		for (int v = 0; v < V; v++) {
			adj[v] = new HashBag<Integer>();
		}

		while ((line = reader.readLine()) != null) {
			tempString = line.split(" ");
			addEdge(Integer.parseInt(tempString[0]),
					Integer.parseInt(tempString[1]));
			// System.out.println(line);
		}

	}

	/**
	 * Add an edge between the vertices v-w.
	 * 
	 * @param v
	 *            The number of the first vertex.
	 * @param w
	 *            The number of the second vertex.
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * Returns vertices adjacent to vertex v.
	 * 
	 * @param v
	 *            The number of the vertex.
	 * @return
	 */
	public Iterable<Integer> getAdjacentVertices(int v) {
		return adj[v];
	}

	/**
	 * Returns the number of Vertices.
	 * 
	 * @return
	 */
	public int V() {
		return this.V;
	}

	/**
	 * Returns the number of Edges.
	 * 
	 * @return
	 */
	public int E() {
		return this.E;
	}

	/**
	 * Overrides the toString method to return a string representation of the
	 * graph.
	 * 
	 * Shows double edges too.
	 * 
	 * @return
	 */
	public String toString() {
		String tempString = "";
		for (int v = 0; v < this.V; v++) {
			for (Integer w : this.getAdjacentVertices(v)) {
				tempString += v + "-" + w + "\n";
			}
		}
		return tempString;
	}

}
