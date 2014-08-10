package com.algorithms.debug;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.graph.TopologicalSort;

/**
 * Created by dante on 8/9/14.
 */
public class Runner {
    public static void main(String[] args) {

        Digraph<String> testGraph;

        testGraph = new Digraph<>(3, 3);
        testGraph.addEdge("1", "2");
        testGraph.addEdge("2", "3");
        testGraph.addEdge("3", "1");


        System.out.println(new TopologicalSort(testGraph));


    }
}