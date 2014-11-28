package com.algorithms.sorting;

import org.apache.commons.collections4.map.HashedMap;

import java.util.Map;

/**
 * Beats the nlogn bound and this is stable also.
 * TODO //only lowercase and numbers now.
 * Works for special cases when the radix of the data is known.
 *
 * @author Dante-666
 * @version 1.0
 */
public class KeyIndexedCounting<T extends Comparable<T>> extends Sort<T> {

    private Map<Character, Integer> keyMap;
    private int[] count;
    private int radix = 36;

    /**
     * The only constructor that initializes the array.
     *
     * @param array The array to be sorted
     */
    public KeyIndexedCounting(T[] array) {
/*        if(array[0] instanceof String) {
            check if the type T is a string or char, otherwise fail it.
        }*/
        super(array);
        keyMap = new HashedMap<>(radix);
        count = new int[radix + 1];

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
