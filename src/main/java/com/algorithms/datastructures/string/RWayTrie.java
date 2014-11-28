package com.algorithms.datastructures.string;

import com.algorithms.exceptions.KeyNotFoundException;
import org.apache.commons.collections4.map.HashedMap;

import java.lang.reflect.Array;
import java.util.Map;

/**
 * TODO : Delete more efficiently by passing the Iterator
 *
 * @author Dante-666
 * @version 1.0
 */
public class RWayTrie<Value> implements Trie<Value> {

    private Map<Character, Integer> keyMap;
    private int radix = 36; // for lowercase and numerals, check method initKeyMap
    private Node root;

    private class Node {
        private Node[] children;
        private Value value;
        private int numChildren;

        @SuppressWarnings("unchecked")
        private Node() {
            this.children = (Node[]) Array.newInstance(Node.class, radix);
            this.value = null;
            this.numChildren = 0;
        }

    }

    public RWayTrie() {
        this.keyMap = new HashedMap<>(this.radix);
        initKeyMap();
        this.root = new Node();
    }

    private void initKeyMap() {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) keyMap.put(alphabet.charAt(i), i);
    }

    @Override
    public void put(String key, Value value) {

        char[] array = key.toCharArray();
        Node node = this.root;

        for (char ch : array) {
            int childIndex = this.keyMap.get(ch);
            if (node.children[childIndex] == null) {
                node.children[childIndex] = new Node();
                node.numChildren++;
            }
            node = node.children[childIndex];
        }

        node.value = value;

    }

    @Override
    public Value get(String key) throws KeyNotFoundException {
        char[] array = key.toCharArray();
        Node node = this.root;

        for (char ch : array) {
            int childIndex = this.keyMap.get(ch);
            if (node.children[childIndex] == null) throw new KeyNotFoundException();
            else node = node.children[childIndex];
        }
        return node.value == null ? null : node.value;
    }

    @Override
    public void delete(String key) throws KeyNotFoundException {
        char[] array = key.toCharArray();
        Node node = this.root;

        delete(node, array, 0);
    }

    private void delete(Node node, char[] array, int index) throws KeyNotFoundException {
        int childIndex = this.keyMap.get(array[index]);
        if (node == null || node.children[childIndex] == null) throw new KeyNotFoundException();
        else node = node.children[childIndex];

        if (index == array.length - 1) {
            if (node.value == null) throw new KeyNotFoundException();
            else node.value = null;
            return;
        }
        delete(node, array, index + 1);

        childIndex = this.keyMap.get(array[index + 1]);

        if (deletable(node.children[childIndex])) {
            node.children[childIndex] = null;
            node.numChildren--;
        }

    }

    private boolean deletable(Node node) {
        return node.numChildren == 0 && node.value == null;
    }

}