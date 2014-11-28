package com.algorithms.graph;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.datastructures.graph.Graph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * This program does a BFS on the graph.
 *
 * @author Dante-666
 * @version 1.0
 */

public class BreadthFirstSearch {

    private Map<Object, Object> edgeTo;
    private Map<Object, Integer> distTo;
    private Map<Object, Boolean> marked;

    public BreadthFirstSearch(Graph<?> G, Object s) {

        this.edgeTo = new ListOrderedMap<>();

        this.distTo = new ListOrderedMap<>();

        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) {
            this.marked.put(x, false);
        }

        bfs(G, s);
    }

    private void bfs(Graph<?> G, Object s) {

        Queue<Object> q = new LinkedList<>();

        int dist = 0;

        q.add(s);
        marked.put(s, true);

        while (!q.isEmpty()) {
            Object v = q.remove();
            dist++;

            for (Object temp : G.getAdjacentVertices(v)) {
                if (!marked.get(temp)) {
                    q.add(temp);
                    marked.put(temp, true);
                    edgeTo.put(temp, v);
                    distTo.put(temp, dist);
                }
            }
        }

    }

    public BreadthFirstSearch(Digraph<?> G, Object s) {

        this.edgeTo = new ListOrderedMap<>();

        this.distTo = new ListOrderedMap<>();

        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) {
            this.marked.put(x, false);
        }

        bfs(G, s);
    }

    private void bfs(Digraph<?> G, Object s) {

        Queue<Object> q = new LinkedList<>();

        int dist = 0;

        q.add(s);
        marked.put(s, true);

        while (!q.isEmpty()) {
            Object v = q.remove();
            dist++;

            for (Object temp : G.getAdjacentVertices(v)) {
                if (!marked.get(temp)) {
                    q.add(temp);
                    marked.put(temp, true);
                    edgeTo.put(temp, v);
                    distTo.put(temp, dist);
                }
            }
        }

    }

    public String toString() {
        return marked.toString() + "\n" + distTo.toString() + "\n" + edgeTo.toString() + "\n";
    }
}
