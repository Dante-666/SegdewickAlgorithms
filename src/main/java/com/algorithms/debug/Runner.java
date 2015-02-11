package com.algorithms.debug;

import com.algorithms.substring.RegEx;

import java.io.IOException;

/**
 * Test
 * <p/>
 * Created by sinsi02 on 9/10/2014.
 */
public class Runner {
    public static void main(String[] args) throws IOException {

        RegEx reg = new RegEx("aabd", "((a*b|ac)d)");

        System.out.print(reg.matched("aabdxxsaaacdaaabdadaacaaadxacd"));
        //System.out.print(kmp.search("aababc", "ababc"));

    }
}
