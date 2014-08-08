package com.algorithms.graph;

import java.util.Map;

import org.apache.commons.collections4.map.ListOrderedMap;

import com.algorithms.datastructures.graph.Graph;

/**
 * Depth First Search, recursive algorithm, works by visiting each adjacent edge
 * and marking them as it goes. 
 * 
 * @author sinsi02
 * @version 2.0
 */

public class DepthFirstSearch {

	private Map<Object, Boolean> marked;
	private Map<Object, Object> edgeTo;
	private final Object v;

	public DepthFirstSearch(Graph<?> G, Object v) {

		this.marked = new ListOrderedMap<Object, Boolean>();
		for (Object x : G.getAllVertices()) {
			this.marked.put(x, false);
		}

		this.edgeTo = new ListOrderedMap<Object, Object>();

		this.v = v;

		dfs(G, this.v);
	}

	private void dfs(Graph<?> G, Object v) {
		this.marked.put(v, true);
		for (Object temp : G.getAdjacentVertices(v)) {
			if (!marked.get(temp)) {
				dfs(G, temp);
				edgeTo.put(temp, v);
			}
		}

	}

	public String toString() {
		return marked.toString() + "\n" + edgeTo.toString() + "\n"
				+ v.toString();
	}
}
