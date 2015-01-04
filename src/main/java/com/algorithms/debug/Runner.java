package com.algorithms.debug;

import com.algorithms.datastructures.string.TernarySearchTrie;
import com.algorithms.exceptions.KeyNotFoundException;
import com.algorithms.substring.KnuthMorrisPratt;

import java.io.IOException;

/**
 * Test
 * <p/>
 * Created by sinsi02 on 9/10/2014.
 */
public class Runner {
    public static void main(String[] args) throws IOException, KeyNotFoundException {

        TernarySearchTrie<Integer> r = new TernarySearchTrie<>();

        KnuthMorrisPratt kmp = new KnuthMorrisPratt();

        System.out.print(kmp.search("aaabbbaababbabbaaabbbaababcaaaaabbabbabaaacc", "ababc"));
        //System.out.print(kmp.search("aababc", "ababc"));

    }
}
