package com.algorithms.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.apache.commons.collections4.map.ListOrderedMap;

import com.algorithms.datastructures.graph.Graph;

public class BreadthFirstSearch {

	private Map<Object, Object> edgeTo;
	private Map<Object, Integer> distTo;
	private Map<Object, Boolean> marked;

	public BreadthFirstSearch(Graph<?> G, Object s) {

		this.edgeTo = new ListOrderedMap<Object, Object>();

		this.distTo = new ListOrderedMap<Object, Integer>();

		this.marked = new ListOrderedMap<Object, Boolean>();
		for (Object x : G.getAllVertices()) {
			this.marked.put(x, false);
		}

		bfs(G, s);
	}

	private void bfs(Graph<?> G, Object s) {

		Queue<Object> q = new LinkedList<Object>();

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
}
