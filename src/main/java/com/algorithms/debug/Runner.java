package com.algorithms.debug;

import com.algorithms.datastructures.trees.BinarySearchTree;
import com.algorithms.datastructures.trees.RandomBST;
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

        BinarySearchTree<Integer, Character> btree = new RandomBST<>();
        //Integer[] testInt = ShuffleArray.knuthShuffleNoDuplicatesInt(20);

        for(int i=0; i<2000000;i++) {
            btree.put(i, 'a');
        }
        
        /*
        btree.put('a','a');
        btree.put('b','a');
        btree.put('c','a');
        //btree.printTree();
        btree.put('d','a');
        btree.put('e','a');
        btree.put('f','a');
        //btree.printTree();
        btree.put('g','a');
        btree.put('h','a');
        btree.put('i','a');
        //btree.printTree();
        btree.put('j','a');
        btree.put('k','a');
        btree.put('l','a');
        //btree.printTree();
        btree.put('r','a');
        btree.put('m','a');
        btree.put('n','a');
        //btree.printTree();
        btree.put('o','a');
        btree.put('p','a');
        btree.put('q','a');
        btree.printTree();*/
        
        //btree.printTree();
        
        Integer count=0;
        
		for (Integer i = -2000000; i < 0; i++) {
			try {
				btree.delete(i);
			} catch (KeyNotFoundException e) {
				count++;
			}
		}
        
        System.out.print(count);
        //btree.delete(16);
        
        //btree.printTree();

        //btree.search(1);

        //btree.delete(btree.root.getKey());
/*
        for(int i=19; i>-1;i--) {
            btree.delete(i);
            btree.printTree();
            //System.out.println(i);
        }*/
        
        System.out.println("Success");

        //btree.printTree();

    }
}