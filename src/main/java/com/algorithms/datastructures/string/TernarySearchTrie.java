package com.algorithms.datastructures.string;

import com.algorithms.exceptions.KeyNotFoundException;

import java.util.LinkedList;
import java.util.Queue;

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

    @Override
    public Iterable<String> keys() {
        Queue<String> queue = new LinkedList<>();
        collect(this.root, "", queue);
        return queue;
    }

    @Override
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new LinkedList<>();
        try {
            Node node = find(this.root, prefix);
            collect(node, prefix, queue);
            return queue;
        } catch (KeyNotFoundException e) {
            return queue;
        }
    }

    @Override
    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new LinkedList<>();
        String newPattern = pattern.replace(".", "");

        int[] position = new int[pattern.length() - newPattern.length()];
        int j = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == '.') {
                position[j++] = i;
            }
        }

        keysThatMatch(this.root, newPattern, "", 0, position, queue);

        return queue;
    }

    private void keysThatMatch(Node node, String pattern, String string, int index, int[] position, Queue<String> queue) {
        if (node == null || index > pattern.length() + position.length - 1) return;

        if (node.value != null && index == pattern.length() + position.length - 1) {
            StringBuilder check = new StringBuilder(string + node.ch);

            for (int i = 0; i < position.length; i++) {
                check.deleteCharAt(position[i] - i);
            }
            if (new String(check).equals(pattern))
                queue.add(string + node.ch);
        }

        keysThatMatch(node.left, pattern, string, index, position, queue);
        keysThatMatch(node.middle, pattern, string + node.ch, index + 1, position, queue);
        keysThatMatch(node.right, pattern, string, index, position, queue);

    }


    @Override
    public String longestPrefixOf(String prefix) {
        StringBuilder result = new StringBuilder();
        longestPrefixOf(this.root, prefix, result, 0);
        return new String(result);
    }

    private void longestPrefixOf(Node node, String prefix, StringBuilder result, int index) {

        if(node == null) return;

        Character ch;

        ch = prefix.charAt(index);

        int cmp = ch.compareTo(node.ch);

        if (cmp > 0) longestPrefixOf(node.right, prefix, result, index);
        else if (cmp < 0) longestPrefixOf(node.left, prefix, result, index);
        else longestPrefixOf(node.middle, prefix, result.append(ch), index + 1);

    }

    private void collect(Node node, String string, Queue<String> queue) {
        if (node == null) return;

        if (node.value != null) queue.add(string + node.ch);

        collect(node.left, string, queue);
        collect(node.middle, string + node.ch, queue);
        collect(node.right, string, queue);

    }

    private Node find(Node node, String string) throws KeyNotFoundException {
        int index = 0;
        while (index < string.length()) {

            if (node == null) throw new KeyNotFoundException();

            int cmp = node.ch.compareTo(string.charAt(index));

            if (cmp < 0) node = node.right;
            else if (cmp > 0) node = node.left;
            else {
                node = node.middle;
                index++;
            }

        }
        return node;
    }

}
