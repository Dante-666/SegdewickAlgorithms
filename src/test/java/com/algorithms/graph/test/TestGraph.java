package com.algorithms.graph.test;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.datastructures.graph.Graph;
import com.algorithms.graph.Bipartite;
import com.algorithms.graph.ConnectedComponents;
import com.algorithms.graph.Cycles;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestGraph {

    private Graph<String> testGraph;
    private Digraph<String> testDigraph;

    public TestGraph() {
        //System.out.println("Running Graph Tests...");
    }

    @BeforeTest
    @Test(groups = "Test-Graphs")
    //@BeforeTest(value = "Sorting")
    public void testGraphInputStreamConstruction() {
        // Path file = FileSystems.getDefault().getPath("/src/main/resources",
        // "testGraph.txt"); //"testGraph.txt";

        Path file = Paths.get("src/main/resources/Graphs", "testGraph.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Graph<>(in);

        } catch (IOException x) {
            System.err.println(x);
        }
    }

    @Test(groups = "Test-Graphs")
    public void testConnectedComponents() {

        Path file = Paths.get("src/main/resources/Graphs", "testGraph.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Graph<>(in);

        } catch (IOException x) {
            System.err.println(x);
        }

        ConnectedComponents testCC = new ConnectedComponents(testGraph);


        Assert.assertEquals(testCC.isConnected("0", "2"), true);
        Assert.assertEquals(testCC.isConnected("0", "6"), true);
        Assert.assertEquals(testCC.isConnected("3", "5"), true);
        Assert.assertEquals(testCC.isConnected("4", "0"), true);
        Assert.assertEquals(testCC.isConnected("4", "2"), true);
        Assert.assertEquals(testCC.isConnected("9", "11"), true);
        Assert.assertEquals(testCC.isConnected("7", "8"), true);

        Assert.assertEquals(testCC.isConnected("6", "8"), false);
        Assert.assertEquals(testCC.isConnected("9", "7"), false);
        Assert.assertEquals(testCC.isConnected("12", "5"), false);

        Assert.assertEquals(testCC.count(), 3);

    }

    @Test(groups = "Test-Graphs")
    public void testIsBipartite() {
        Path file = Paths.get("src/main/resources/Graphs", "testBipartite.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Graph<>(in);

            //Reporter.log(testGraph.toString());// .toString();

            Bipartite bp = new Bipartite(testGraph);

            Assert.assertEquals(bp.isBipartite(), true);

        } catch (IOException x) {
            System.err.println(x);
        }
    }

    @Test(groups = "Test-Graphs")
    public void testNotBipartite() {
        Path file = Paths.get("src/main/resources/Graphs", "testNotBipartite.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Graph<>(in);

            //Reporter.log(testGraph.toString());

            Bipartite bp = new Bipartite(testGraph);

            Assert.assertEquals(bp.isBipartite(), false);

        } catch (IOException x) {
            System.err.println(x);
        }
    }

    @Test(groups = "Test-Graphs")
    public void testNotCyclic() {
        Path file = Paths.get("src/main/resources/Graphs", "testNotCyclic.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Graph<>(in);

            in = Files.newInputStream(file);

            testDigraph = new Digraph<>(in);

            Cycles bp = new Cycles(testGraph);

            Assert.assertEquals(bp.isCyclic(), false);

            bp = new Cycles(testDigraph);

            Assert.assertEquals(bp.isCyclic(), false);

        } catch (IOException x) {
            System.err.println(x);
        }
    }

    @Test(groups = "Test-Graphs")
    public void testCyclic() {
        Path file = Paths.get("src/main/resources/Graphs", "testCyclic.txt");

        try {
            InputStream in = Files.newInputStream(file);

            testGraph = new Graph<>(in);

            in = Files.newInputStream(file);

            testDigraph = new Digraph<>(in);

            Cycles bp = new Cycles(testGraph);

            Assert.assertEquals(bp.isCyclic(), true);

            bp = new Cycles(testDigraph);

            Assert.assertEquals(bp.isCyclic(), true);

        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
