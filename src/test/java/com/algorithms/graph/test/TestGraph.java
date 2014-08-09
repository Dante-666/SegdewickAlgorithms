package com.algorithms.graph.test;

import com.algorithms.datastructures.graph.Graph;
import com.algorithms.graph.ConnectedComponents;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestGraph {

    private Graph<String> testGraph;
	
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

			Reporter.log(testGraph.toString());// .toString();

			/*
			 * BufferedReader reader = new BufferedReader( new
			 * InputStreamReader(in)); String line = null; while ((line =
			 * reader.readLine()) != null) System.out.println(line);
			 */

		} catch (IOException x) {
			System.err.println(x);
		}
	}

    @Test(groups = "Test-Graphs")
    public void testConnectedComponents(){

        ConnectedComponents testCC = new ConnectedComponents(testGraph);

        Assert.assertEquals(testCC.isConnected("0", "0"), true);
        Assert.assertEquals(testCC.isConnected("0", "1"), true);
        Assert.assertEquals(testCC.isConnected("0", "2"), true);
        Assert.assertEquals(testCC.isConnected("0", "6"), true);
        Assert.assertEquals(testCC.isConnected("0", "5"), true);
        Assert.assertEquals(testCC.isConnected("0", "3"), true);
        Assert.assertEquals(testCC.isConnected("0", "4"), true);

        Assert.assertEquals(testCC.isConnected("5", "5"), true);
        Assert.assertEquals(testCC.isConnected("5", "0"), true);
        Assert.assertEquals(testCC.isConnected("5", "1"), true);
        Assert.assertEquals(testCC.isConnected("5", "2"), true);
        Assert.assertEquals(testCC.isConnected("5", "6"), true);
        Assert.assertEquals(testCC.isConnected("5", "3"), true);
        Assert.assertEquals(testCC.isConnected("5", "4"), true);

        Assert.assertEquals(testCC.isConnected("3", "3"), true);
        Assert.assertEquals(testCC.isConnected("3", "0"), true);
        Assert.assertEquals(testCC.isConnected("3", "1"), true);
        Assert.assertEquals(testCC.isConnected("3", "2"), true);
        Assert.assertEquals(testCC.isConnected("3", "5"), true);
        Assert.assertEquals(testCC.isConnected("3", "6"), true);
        Assert.assertEquals(testCC.isConnected("3", "4"), true);

        Assert.assertEquals(testCC.isConnected("4", "4"), true);
        Assert.assertEquals(testCC.isConnected("4", "0"), true);
        Assert.assertEquals(testCC.isConnected("4", "1"), true);
        Assert.assertEquals(testCC.isConnected("4", "2"), true);
        Assert.assertEquals(testCC.isConnected("4", "3"), true);
        Assert.assertEquals(testCC.isConnected("4", "6"), true);
        Assert.assertEquals(testCC.isConnected("4", "5"), true);

        Assert.assertEquals(testCC.isConnected("9", "9"), true);
        Assert.assertEquals(testCC.isConnected("9", "10"), true);
        Assert.assertEquals(testCC.isConnected("9", "11"), true);

        Assert.assertEquals(testCC.isConnected("7", "8"), true);

        Assert.assertEquals(testCC.isConnected("6", "8"), false);

        Assert.assertEquals(testCC.isConnected("9", "7"), false);

        Assert.assertEquals(testCC.isConnected("12", "5"), false);

        Assert.assertEquals(testCC.count(), 3);

    }
}
