package com.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.algorithms.datastructures.graph.Graph;

public class BreadthFirstSearch {

	private int[] edgeTo;
	private int[] distTo;
	private boolean[] marked;

	public BreadthFirstSearch(Graph G, int s) {
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		marked = new boolean[G.V()];

		bfs(G, s);
	}

	private void bfs(Graph G, int s) {

		Queue<Integer> q = new LinkedList<Integer>();
		int dist = 0;

		q.add(s);
		marked[s] = true;

		while (!q.isEmpty()) {
			int v = q.remove();
			dist++;

			for (int temp : G.getAdjacentVertices(v)) {
				if (!marked[temp]) {
					q.add(temp);
					marked[temp] = true;
					edgeTo[temp] = v;
					distTo[temp] = dist;
				}
			}
		}

	}
}
