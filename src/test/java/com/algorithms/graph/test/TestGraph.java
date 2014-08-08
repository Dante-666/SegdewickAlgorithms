package com.algorithms.graph.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.algorithms.datastructures.graph.Graph;

import org.testng.Reporter;
import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;

@Test(groups = "Test-Graphs")
public class TestGraph {
	
	public TestGraph() {
		//System.out.println("Running Graph Tests...");
	}
	
	//@BeforeTest(value = "Sorting")
	public void testGraphInputStreamConstruction() {
		// Path file = FileSystems.getDefault().getPath("/src/main/resources",
		// "testGraph.txt"); //"testGraph.txt";

		Graph<String> testGraph;

		Path file = Paths.get("src/main/resources/Graphs", "testGraph.txt");

		try {
			InputStream in = Files.newInputStream(file);

			testGraph = new Graph<String>(in);

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
}
