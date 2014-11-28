package com.algorithms.datastructures.string;

import com.algorithms.exceptions.KeyNotFoundException;

/**
 * @author Dante-666
 * @version 1.0
 */
public interface Trie<Value> {
    public void put(String key, Value value);

    public Value get(String key) throws KeyNotFoundException;

    public void delete(String key) throws KeyNotFoundException;
}
