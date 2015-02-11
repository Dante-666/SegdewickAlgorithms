package com.algorithms.graph;

import com.algorithms.datastructures.graph.Digraph;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.set.ListOrderedSet;

import java.util.Map;
import java.util.Set;

/**
 * @author Dante-666
 * @version 1.0
 */
public class ReachableVertices {
    private Map<Object, Boolean> marked;
    private Set<Object> reachable;

    public ReachableVertices(Digraph<?> G, Object v) {
        this.marked = new ListOrderedMap<>();
        this.reachable = new ListOrderedSet<>();

        for (Object x : G.getAllVertices()) {
            this.marked.put(x, false);
        }
        dfs(G, v);
    }

    public ReachableVertices(Digraph<?> G, Iterable<Object> v) {
        this.marked = new ListOrderedMap<>();
        this.reachable = new ListOrderedSet<>();

        for (Object x : G.getAllVertices()) this.marked.put(x, false);

        for (Object x : v) {
            try {
                if (!marked.get(x)) dfs(G, x);
            } catch (NullPointerException e) {
                this.reachable.add(x);
            }
        }
        //System.out.println(this.marked.get(x));//if (!marked.get(x)) dfs(G, x);

    }

    public Set<Object> getReachable() {
        return this.reachable;
    }

    private void dfs(Digraph<?> G, Object v) {

        this.marked.put(v, true);
        this.reachable.add(v);

        for (Object temp : G.getAdjacentVertices(v)) {
            if (!marked.get(temp)) {
                dfs(G, temp);
            }
        }
    }
}
