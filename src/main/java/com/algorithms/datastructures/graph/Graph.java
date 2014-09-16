package com.algorithms.datastructures.graph;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.map.HashedMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * This is a local API for a basic graphs with which we can implement the
 * algorithms. It internally uses the Adjacency-list Representation to store
 * graph data in spite of the linked list and array representation since it is
 * the most favored one.
 * <p/>
 * Native Vertices supported. Can improve upon this
 * <p/>
 * Also this implements an undirected graph and thus has multiple edges. For the
 * sake of simplicity, the edges will be counted once.
 * <p/>
 * Also the graph can be initialized only once with the current settings.
 * <p/>
 * Design Pattern : Decouple the Graph datatype from the Graph Processing
 * algorithms. Pass the Graph to the routine and query it for information.
 *
 * @author Dante
 * @version 2.0
 */
public class Graph<Vertex> {

    private final int V;
    private final int E;
    private Map<Vertex, Bag<Vertex>> adjMap;

    /**
     * Constructs an empty graph with the number of vertices and edges passed
     * in.
     */

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;

        adjMap = new HashedMap<>();

    }

    /**
     * Constructs a graph from an Input stream like a file. The file should have
     * data arranged in this format given below.
     * <p/>
     * <no. of vertices> \n <no. of edges> \n <relationship>
     * <p/>
     * TODO : Cast the string into proper objects as you are reading the file.
     *
     * @param in The inputstream from which the graph will be constructed based
     *           on the relationship defined in the graph.
     */
    @SuppressWarnings("unchecked")
    public Graph(InputStream in) throws IOException, NullPointerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        String[] tempString;

        line = reader.readLine();
        this.V = Integer.parseInt(line);

        line = reader.readLine();
        this.E = Integer.parseInt(line);

        adjMap = new HashedMap<>();

        while ((line = reader.readLine()) != null) {
            tempString = line.split(" ");
            addEdge((Vertex) tempString[0], (Vertex) tempString[1]);
        }

    }

    public void addVertex(Vertex v) {
        adjMap.put(v, new HashBag<Vertex>());
    }

    /**
     * Add an edge between the vertices v-w.
     *
     * @param v The number of the first vertex.
     * @param w The number of the second vertex.
     */
    public void addEdge(Vertex v, Vertex w) {

        if (!adjMap.containsKey(v)) {
            adjMap.put(v, new HashBag<Vertex>());
        }
        if (!adjMap.containsKey(w)) {
            adjMap.put(w, new HashBag<Vertex>());
        }

        adjMap.get(v).add(w);
        adjMap.get(w).add(v);
    }

    /**
     * Returns the number of edges through a vertex.
     *
     * @param v The vertex
     * @return The degree of v.
     */
    public int getDegree(Object v) {
        return adjMap.get(v).size();
    }

    /**
     * Returns vertices adjacent to vertex v.
     *
     * @param v The number of the vertex.
     * @return The adjacent vertices list in an iterator.
     */
    public Iterable<Vertex> getAdjacentVertices(Object v) {
        return adjMap.get(v);
    }

    /**
     * Returns the vertex list.
     *
     * @return The entire Vertex list.
     */
    public Iterable<Vertex> getAllVertices() {
        return adjMap.keySet();
    }

    /**
     * @return Returns the number of Vertices.
     */
    public int V() {
        return this.V;
    }

    /**
     * @return Returns the number of Edges.
     */
    public int E() {
        return this.E;
    }

    /**
     * Overrides the toString method to return a string representation of the
     * graph.
     * <p/>
     * Shows double edges too.
     *
     * @return String representation of the graph.
     */
    public String toString() {
        String tempString = "";
        for (Vertex v : adjMap.keySet()) {
            for (Vertex w : this.getAdjacentVertices(v)) {
                tempString += v + "-" + w + "\n";
            }
        }
        return tempString;
    }

}
