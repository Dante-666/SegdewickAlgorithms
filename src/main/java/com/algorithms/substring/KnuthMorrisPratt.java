package com.algorithms.substring;

import org.apache.commons.collections4.set.ListOrderedSet;

/**
 * @author Dante-666
 * @version 1.0
 */
public class KnuthMorrisPratt implements SubstringSearch {
    @Override
    public int search(CharSequence text, String pattern) {

        int i, j, M = text.length(), N = pattern.length();
        int[][] dfa;

        ListOrderedSet<Character> chars = new ListOrderedSet<>();

        for (int k = 0; k < N; k++)
            if (!chars.contains(pattern.charAt(k))) chars.add(pattern.charAt(k));

        dfa = new int[chars.size()][N];

        dfa[0][0] = 1;

        for (int k = 1, x = 0; k < N; k++) {
            for (int l = 0; l < chars.size(); l++)
                    dfa[l][k] = dfa[l][x];
            dfa[chars.indexOf(pattern.charAt(k))][k] = k + 1;
            x = dfa[chars.indexOf(pattern.charAt(k))][x];
        }

        for (i = 0, j = 0; i < M && j < N; i++)
            try {
                j = dfa[chars.indexOf(text.charAt(i))][j];
            } catch (ArrayIndexOutOfBoundsException e){
                //continue;
            }
        if (j == N) return i - N;
        else return M;
    }
}
