package com.algorithms.graph;

import com.algorithms.datastructures.graph.Graph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.Map;

/**
 * Uses Depth First Search internally to maintain the data structure.
 */
public class ConnectedComponents {

    private int initId;
    private Map<Object, Integer> id;
    private Map<Object, Boolean> marked;

    public ConnectedComponents(Graph<?> G) {

        this.initId = 0;

        this.id = new ListOrderedMap<>();

        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) {
            this.marked.put(x, false);
        }

        for (Object x : marked.keySet()) {

            if (!this.marked.get(x)) {
                dfs(G, x);
                this.initId++;
            }
        }

    }

    private void dfs(Graph<?> G, Object v) {
        this.marked.put(v, true);
        this.id.put(v, initId);
        for (Object temp : G.getAdjacentVertices(v)) {
            if (!marked.get(temp)) {
                dfs(G, temp);
            }
        }

    }

    public boolean isConnected(Object v, Object w) {
        return this.id.get(v).equals(this.id.get(w));
    }

    public int count() {
        return this.initId;
    }

    @SuppressWarnings("unused")
    public int componentId(Object v) {
        return this.id.get(v);
    }

    public String toString() {
        return this.id.toString();
    }


}
