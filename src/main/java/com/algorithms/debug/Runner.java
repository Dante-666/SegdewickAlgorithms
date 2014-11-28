package com.algorithms.debug;

import com.algorithms.datastructures.string.TernarySearchTrie;
import com.algorithms.exceptions.KeyNotFoundException;

import java.io.IOException;

/**
 * Test
 * <p/>
 * Created by sinsi02 on 9/10/2014.
 */
public class Runner {
    public static void main(String[] args) throws IOException, KeyNotFoundException {

        TernarySearchTrie<Integer> r = new TernarySearchTrie<>();

        r.put("hello", 1);
        r.put("hxe", 2);
        r.put("hxc", 3);
        r.put("hxcd", 5);
        r.put("kiran", 7);

        r.delete("hello");
        r.delete("hxc");
        r.delete("hxe");
        r.delete("hxcd");
        r.delete("kiran");

        //System.out.println(r.get("h"));
        //System.out.println(r.get("hello"));
        //System.out.println(r.get("hxcd"));
        //System.out.println(r.get("hxc"));
        //System.out.println(r.get("hxe"));
        //System.out.println(r.get("kiran"));
        //System.out.println(r.get("ki"));

    }
}
