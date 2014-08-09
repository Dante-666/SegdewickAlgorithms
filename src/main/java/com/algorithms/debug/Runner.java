package com.algorithms.debug;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.graph.DepthFirstSearch;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dante on 8/9/14.
 */
public class Runner {
    public static void main(String[] args) {


        Digraph<String> testGraph;

        Path file = Paths.get("src/main/resources/Graphs", "testDigraph.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Digraph<>(in);

            //System.out.println(testGraph.getAllVertices());
            //System.out.println(testGraph.getAdjacentVertices("0"));

            DepthFirstSearch dfs=new DepthFirstSearch(testGraph, "3");

            System.out.println(dfs);


        } catch (IOException x) {
            System.err.println(x);
        }





    }
}