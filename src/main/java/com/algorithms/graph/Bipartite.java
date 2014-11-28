package com.algorithms.graph;

import com.algorithms.datastructures.graph.Graph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.Map;

/**
 * This program tells if a graph is bipartite or not.
 *
 * @author Dante-666
 * @version 1.0
 */

public class Bipartite {

    private Map<Object, Boolean> marked;
    private Map<Object, Boolean> color;

    private boolean isBipartite;

    public Bipartite(Graph<?> g) {

        this.marked = new ListOrderedMap<>();
        this.color = new ListOrderedMap<>();

        this.isBipartite = true;

        for (Object x : g.getAllVertices()) {
            this.marked.put(x, false);
            this.color.put(x, false);
        }

        for (Object x : g.getAllVertices()) {
            if (!this.marked.get(x) && this.isBipartite)
                dfs(g, x, true);
        }

    }

    private void dfs(Graph<?> g, Object v, boolean alt) {
        this.marked.put(v, true);
        //System.out.println(v);
        //System.out.println(this);

        for (Object temp : g.getAdjacentVertices(v)) {
            if (!marked.get(temp)) {
                this.color.put(temp, alt);
                dfs(g, temp, !alt);
            }

            if (!isBipartite)
                break;

            if (this.color.get(temp) != alt) {
                isBipartite = false;
                break;
            }

            /*System.out.println(v+"->"+temp);
            System.out.println(this.color);
            System.out.println("alt=" +alt);*/
        }

    }

    public boolean isBipartite() {
        return isBipartite;
    }

    public String toString() {
        return this.marked.toString() + "\n" +
                this.color.toString() + "\n" +
                this.isBipartite;
    }
}
