package com.algorithms.sorting;

import org.apache.commons.collections4.map.HashedMap;

import java.util.Map;

/**
 * Works for fixed length strings.
 * <p/>
 * TODO: make it work only for strings and convert T to string somehow.
 *
 * @author Dante-666
 * @version 1.0
 */
public class LSDRadixSort<T extends Comparable<T>> extends Sort<T> {

    private Map<Character, Integer> keyMap;
    private int[] count;
    private int radix;
    private int width;

    /**
     * The only constructor that initializes the array.
     *
     * @param array The array to be sorted
     */
    public LSDRadixSort(T[] array) {
        super(array);
        radix = 36;
        keyMap = new HashedMap<>(radix);
        count = new int[radix + 1];
        width = 3;

        initKeyMap();
    }

    private void initKeyMap() {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length(); i++) {
            keyMap.put(alphabet.charAt(i), i);
        }
    }

    @Override
    public void sortArray() {

        this.arrayAccess = 0;
        this.comparisions = 0;

        T[] auxArray = array.clone();

        for (int d = width - 1; d >= 0; d--) {

            count = new int[radix + 1];

            for (T item : array) {
                count[keyMap.get(item) + 1]++;
            }

            for (int i = 0; i < radix; i++) {
                count[i + 1] += count[i];
            }

            for (T item : array) {
                auxArray[count[keyMap.get(item)]++] = item;
            }

            array = auxArray;
        }

    }
}
