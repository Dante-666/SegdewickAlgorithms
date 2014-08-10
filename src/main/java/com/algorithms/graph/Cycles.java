package com.algorithms.graph;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.datastructures.graph.Graph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.Map;
import java.util.Stack;

/**
 * Works for only the first cycle and leaves the rest, improve this to implement
 * multiple and all cycles in the graph.
 *
 * Created by dante on 8/10/14.
 * @version 1.0
 */
public class Cycles {

    private Map<Object, Boolean> marked;
    private Stack<Object> cycle;

    public Cycles(Graph<?> G){

    }

    public Cycles(Digraph<?> G){

        this.cycle=new Stack<>();

        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) {
            this.marked.put(x, false);
        }

        for (Object x : G.getAllVertices()) {
            if(!this.marked.get(x))
                dfs(G, x);
        }
    }

    private void dfs(Digraph<?> G, Object v) {
        this.marked.put(v, true);
        for (Object temp : G.getAdjacentVertices(v)) {
            //if(this.cycle.)
            this.cycle.push(temp);
            if (!marked.get(temp)) {
                dfs(G, temp);
            }
        }
    }
}
