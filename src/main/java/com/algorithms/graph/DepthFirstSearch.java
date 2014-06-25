package com.algorithms.graph;

public class DepthFirstSearch {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public DepthFirstSearch(Graph G, int s) {
		this.marked = new boolean[G.V()];
		this.edgeTo = new int[G.V()];
		this.s = s;

		dfs(G, this.s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (Integer temp : G.getAdjacentVertices(v)) {
			if (!marked[temp]) {
				dfs(G, temp);
				edgeTo[temp] = v;
			}
		}

	}
}
