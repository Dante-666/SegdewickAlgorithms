package com.algorithms.graph;

import com.algorithms.datastructures.graph.Digraph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.Map;
import java.util.Stack;

/**
 * Check for cycles and report if not DAG.
 * Created by dante on 8/10/14.
 * @version 1.0
 */
public class TopologicalSort {

    private Map<Object, Boolean> marked;
    private Stack<Object> reversePost;

    public TopologicalSort(Digraph<?> G){

        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) {
            this.marked.put(x, false);
        }

        this.reversePost = new Stack<>();

        for (Object x : G.getAllVertices()) {
            if(!this.marked.get(x))
                dfs(G, x);
        }

    }

    private void dfs(Digraph<?> G, Object v) {

        this.marked.put(v, true);

        for (Object temp : G.getAdjacentVertices(v)) {
            if (!marked.get(temp)) {
                dfs(G, temp);
            }
        }
        reversePost.push(v);
    }

    public String toString(){
        return reversePost.toString();
    }
}
