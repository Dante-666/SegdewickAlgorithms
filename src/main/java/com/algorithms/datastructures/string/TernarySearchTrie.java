package com.algorithms.datastructures.string;

import com.algorithms.exceptions.KeyNotFoundException;

/**
 * @author Dante-666
 * @version 1.0
 */
public class TernarySearchTrie<Value> implements Trie<Value> {

    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private Node middle;

        private Character ch;
        private Value value;

        private boolean isLeaf() {
            return this.left == null && this.right == null && this.middle == null;
        }

    }

    public TernarySearchTrie() {
        root = null;
    }

    @Override
    public void put(String key, Value value) {
        this.root = put(this.root, key, 0, value);
    }

    private Node put(Node node, String key, int index, Value value) {
        Character ch;

        if (index < key.length()) ch = key.charAt(index);
        else return null;

        if (node == null) {
            node = new Node();
            node.ch = ch;
            if (index == key.length() - 1) node.value = value;
            node.middle = put(node.middle, key, index + 1, value);
        } else {
            int cmp = ch.compareTo(node.ch);

            if (cmp > 0) node.right = put(node.right, key, index, value);
            else if (cmp < 0) node.left = put(node.left, key, index, value);
            else node.middle = put(node.middle, key, index + 1, value);
        }

        return node;
    }

    @Override
    public Value get(String key) throws KeyNotFoundException {
        return get(key, 0);

    }

    private Value get(String key, int index) throws KeyNotFoundException {
        Node node = this.root;
        Character ch;

        while (true) {
            if (node == null) throw new KeyNotFoundException();

            ch = key.charAt(index);

            int cmp = ch.compareTo(node.ch);

            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                index++;
                if (index == key.length()) {
                    --index;
                    break;
                } else node = node.middle;
            }
        }
        if (node.value == null) throw new KeyNotFoundException();
        else return node.value;
    }


    @Override
    public void delete(String key) throws KeyNotFoundException {
        Node node = this.root;

        delete(node, key, 0);
    }

    private Node delete(Node node, String key, int index) {

        if (node == null) return null;

        if (index == key.length()) return node;

        Character ch;

        ch = key.charAt(index);

        int cmp = ch.compareTo(node.ch);

        if (cmp > 0) node.right = delete(node.right, key, index);
        else if (cmp < 0) node.left = delete(node.left, key, index);
        else node.middle = delete(node.middle, key, index + 1);

        if (index == key.length() - 1 && match(node, ch)) node.value = null;

        if (node.isLeaf() && node.value == null) return null;
        else return node;

    }

    private boolean match(Node node, Character ch) {
        return node.value != null && node.ch.equals(ch);
    }

}
