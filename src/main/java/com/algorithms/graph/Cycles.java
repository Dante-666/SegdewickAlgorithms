package com.algorithms.graph;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.datastructures.graph.Graph;
import org.apache.commons.collections4.map.ListOrderedMap;

import java.util.Map;
import java.util.Stack;

/**
 * Detects if there is a cycle present in the graph and returns the first detected cycle.
 * Modify this to return all cycles too.
 * <p/>
 * TODO: Digraph contains unnecessary values in the graph. Test Graph for the same.
 *
 * @author Dante-666
 * @version 1.0
 */
public class Cycles {

    private Map<Object, Boolean> marked;
    private boolean isCyclic;
    private Stack<Object> cycle;

    public Cycles(Graph<?> G) {

        this.isCyclic = false;
        this.marked = new ListOrderedMap<>();

        for (Object x : G.getAllVertices()) this.marked.put(x, false);

        for (Object x : G.getAllVertices()) {
            if (!isCyclic && !this.marked.get(x)) {
                this.cycle = new Stack<>();
                dfs(G, x, null);
            }
        }

    }

    public Cycles(Digraph<?> G) {

        this.marked = new ListOrderedMap<>();
        this.isCyclic = false;

        for (Object x : G.getAllVertices()) this.marked.put(x, false);


        for (Object x : G.getAllVertices()) {
            if (!isCyclic && !this.marked.get(x)) {
                this.cycle = new Stack<>();
                dfs(G, x, false);
            }
        }
    }

    private void dfs(Graph<?> G, Object v, Object w) {

        this.marked.put(v, true);

        if (G.getDegree(v) == 1) return;
        else cycle.add(v);

        for (Object temp : G.getAdjacentVertices(v)) {

            if (temp.equals(w)) continue;

            if (isCyclic) break;

            if (cycle.contains(temp)) {
                isCyclic = true;
                break;
            }

            if (!marked.get(temp)) dfs(G, temp, v);

        }

    }

    private void dfs(Digraph<?> G, Object v, boolean deadPath) {
        this.marked.put(v, true);
        cycle.add(v);
        for (Object temp : G.getAdjacentVertices(v)) {

            if (G.getOutDegree(temp) == 0) {
                this.marked.put(temp, true);
                deadPath = true;
                continue;
            }

            if (isCyclic) break;

            if (cycle.contains(temp)) {
                isCyclic = true;
                break;
            }

            if (!marked.get(temp)) dfs(G, temp, deadPath);
        }
    }

    public boolean isCyclic() {
        return isCyclic;
    }

    public String toString() {
        if (isCyclic)
            return cycle + "\n" + true;
        else
            return "false";
    }
}
