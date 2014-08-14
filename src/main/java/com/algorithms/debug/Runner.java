package com.algorithms.debug;

import com.algorithms.datastructures.trees.BinarySearchTree;
import com.algorithms.datastructures.trees.RedBlackTree;
import com.algorithms.exceptions.DuplicateKeyException;
import com.algorithms.exceptions.EmptyCollectionException;
import com.algorithms.exceptions.KeyNotFoundException;
import com.algorithms.sorting.ShuffleArray;

/**
 * Created by dante on 8/9/14.
 */
public class Runner {
    public static void main(String[] args) throws DuplicateKeyException, KeyNotFoundException, EmptyCollectionException {

        /*

        Digraph<String> testGraph;

        testGraph = new Digraph<>(3, 3);
        testGraph.addEdge("1", "2");
        testGraph.addEdge("2", "3");
        testGraph.addEdge("3", "1");


        System.out.println(new TopologicalSort(testGraph));
        */

        BinarySearchTree<Integer, Character> btree = new RedBlackTree<>();
        Integer[] testInt = ShuffleArray.knuthShuffleNoDuplicatesInt(20);

        for(int i=0; i<20;i++) {
            btree.put(testInt[i], 'a');
        }

        btree.search(1);

        //btree.delete(btree.root.getKey());

        /**
        for(int i=0; i<19;i++) {
            btree.deleteMin();
            btree.printTree();
            //System.out.println(i);
        }
         **/

        btree.printTree();

    }
}