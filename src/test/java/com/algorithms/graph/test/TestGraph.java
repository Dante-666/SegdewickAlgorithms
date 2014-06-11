package com.algorithms.graph.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.nio.file.FileSystem;
//import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.algorithms.graph.Graph;

import org.testng.annotations.Test;

@Test(groups = "Test-Graphs")
public class TestGraph {

	public void testGraphInputStreamConstruction() {
		//Path file = FileSystems.getDefault().getPath("/src/main/resources", "testGraph.txt"); //"testGraph.txt";
		
		Graph testGraph;
		
		Path file=Paths.get("src/main/resources/Graphs", "testGraph.txt");
		
		try {
			InputStream in = Files.newInputStream(file);
			
			testGraph=new Graph(in);
			
			System.out.println(testGraph);//.toString();
			
/*			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null)
				System.out.println(line);*/

		} catch (IOException x) {
			System.err.println(x);
		}
	}
}
