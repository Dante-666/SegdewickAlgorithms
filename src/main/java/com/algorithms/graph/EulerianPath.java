package com.algorithms.graph;

import com.algorithms.datastructures.graph.Graph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.Map;
import java.util.Stack;

/**
 * Eulerian Paths are of two types, one is a trail and the other is a cycle.
 * Trails may have even vertices with odd degrees. For Cycles, the vertices
 * must have even degrees. Assumes that all the vertices are connected.
 *
 * @author Dante-666
 * @version 1.0
 */
public class EulerianPath {
    private Map<Object, Boolean> marked;
    private boolean hasPath;
    private Stack<Object> path;

    public EulerianPath(Graph<?> G) {
        this.hasPath = false;
        this.marked = new ListOrderedMap<>();

        int count = 0;

        for (Object x : G.getAllVertices()) if (G.getDegree(x) % 2 != 0) count++;

        if (count == 0)
            //Use Hierholzer
            this.hasPath = false;
        else if (count == 2)
            //Use Fleury
            this.hasPath = true;

        this.path = new Stack<>();

        Iterable<?> x = G.getAllVertices();

        dfs(G, x.iterator().next(), null);


/*        for (Object x : G.getAllVertices()) {

            if (!this.marked.get(x)) {
                this.path = new Stack<>();
                dfs(G, x, null);
            }
        }*/
    }

/*    public EulerianPath(Digraph<?> G){
        this.hasPath = false;
        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) this.marked.put(x, false);

        for (Object x : G.getAllVertices()) {

            if (!this.marked.get(x)) {
                //this.cycle = new Stack<>();
                //dfs(G, x);
            }
        }
    }*/

    private void dfs(Graph<?> G, Object v, Object w) {
        this.marked.put(v, true);
        this.path.add(v);

        System.out.println(path);

        for (Object temp : G.getAdjacentVertices(v)) {
            if (temp.equals(w)) continue;
            if (path.contains(temp)) {
                break;
            }
            if (!marked.get(temp)) dfs(G, temp, v);
        }
    }

    public String toString() {
        if (this.hasPath)
            return path.toString();
        else
            return "Graph doesn't have an Eulerian path.";
    }

}
