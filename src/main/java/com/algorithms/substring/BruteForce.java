package com.algorithms.substring;

/**
 * @author Dante-666
 * @version 1.0
 */
public class BruteForce implements SubstringSearch {

    public int search(String text, String pattern) {
        int M = text.length();
        int N = pattern.length();

        for (int i = 0; i < M - N; i++) {
            int j;
            for (j = 0; j < N; i++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            if (j == N) return i;
        }
        return N;
    }
}
