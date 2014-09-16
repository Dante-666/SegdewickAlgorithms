package com.algorithms.debug;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.graph.Cycles;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**Test
 *
 * Created by sinsi02 on 9/10/2014.
 */
public class Runner {
    public static void main(String[] args) throws IOException {

        Digraph<Integer> dg;

        Path file = Paths.get("src/main/resources/Graphs", "testCyclic.txt");

        try {
            InputStream in = Files.newInputStream(file);

            dg = new Digraph<>(in);

            Cycles bp = new Cycles(dg);

            System.out.println(bp);

        } catch (IOException x) {
            System.err.println(x);
        }

/*        //dg.addVertex(-1);
        dg.addVertex(0);
        dg.addVertex(1);
        dg.addVertex(2);
        dg.addVertex(3);
        //dg.addVertex(4);
        //dg.addVertex(5);

        //dg.addEdge(4,5);
        //dg.addEdge(4,3);
        dg.addEdge(3,0);
        dg.addEdge(1,3);
        dg.addEdge(3,2);
        //dg.addEdge(2,0);
        //dg.addEdge(1,2);
        //dg.addEdge(0,1);*/

        //System.out.println(dg);

    }
}
