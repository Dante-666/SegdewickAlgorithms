package com.algorithms.substring;

import com.algorithms.datastructures.graph.Digraph;
import com.algorithms.graph.ReachableVertices;
import org.apache.commons.collections4.set.ListOrderedSet;

import java.util.Set;
import java.util.Stack;

/**
 * @author Dante-666
 * @version 1.0
 */
public class RegEx {
    private Pattern pattern;
    private boolean matches;

    public RegEx(CharSequence text, String pattern) {
        this.pattern = Pattern.compile(pattern);
        this.matches = this.pattern.matches(text);
    }

    public boolean matches() {
        return this.matches;
    }

    public boolean matches(CharSequence text) {
        return this.matches = this.pattern.matches(text);
    }

    public Set<String> matched(CharSequence text) {
        return this.pattern.matcher(text);
    }

}

class Pattern {
    private final String pattern;
    private Digraph<Integer> automata;

    private Pattern(String pattern) {
        this.pattern = pattern;
        this.automata = new Digraph<>(pattern.length() + 1, 0);
        computeAutomata();
    }

    public static Pattern compile(String pattern) {
        return new Pattern(pattern);
    }

    private void computeAutomata() {
        Stack<Integer> stack = new Stack<>();
        char[] chars = this.pattern.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int lp = i;

            switch (chars[i]) {
                case '(':
                    stack.push(i);
                    break;
                case '|':
                    stack.push(i);
                    break;
                case ')':
                    int or = stack.pop();
                    if (chars[or] == '|') {
                        lp = stack.pop();
                        automata.addEdge(lp, or + 1);
                        automata.addEdge(or, i);
                    } else lp = or;

            }

            if (i < chars.length - 1 && chars[i + 1] == '*') {
                automata.addEdge(lp, i + 1);
                automata.addEdge(i + 1, lp);
            }

            if (chars[i] == '(' || chars[i] == '*' || chars[i] == ')')
                if (i == chars.length - 1) automata.addEdge(i, null);
                else automata.addEdge(i, i + 1);
        }
        System.out.println(this.automata);
    }

    public boolean matches(CharSequence text) {
        boolean match = false;
        Set<Object> reachable = new ReachableVertices(this.automata, 0).getReachable();

        for (int i = 0; i < text.length(); i++) {
            Set<Object> next = new ListOrderedSet<>();
            int index = this.pattern.indexOf(text.charAt(i));

            while (reachable.contains(index)) {
                next.add(index + 1);
                reachable.remove(index);
                index = this.pattern.indexOf(text.charAt(i), index + 1);
                if (index < 0) break;
            }

            reachable = new ReachableVertices(this.automata, next).getReachable();
            System.out.println(reachable.toString());
            if (reachable.contains(null)) {
                match = true;
                reachable = new ReachableVertices(this.automata, 0).getReachable();
            }
        }
        return match;
    }

    public ListOrderedSet<String> matcher(CharSequence text) {
        ListOrderedSet<String> strings = new ListOrderedSet<>();
        Set<Object> reachable = new ReachableVertices(this.automata, 0).getReachable();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            Set<Object> next = new ListOrderedSet<>();
            int index = this.pattern.indexOf(text.charAt(i));

            System.out.println(reachable + "--" + text.charAt(i));

            while (reachable.contains(index)) {
                next.add(index + 1);
                reachable.remove(index);
                index = this.pattern.indexOf(text.charAt(i), index + 1);
                if (index < 0) break;
            }

            if (!next.isEmpty()) {
                reachable = new ReachableVertices(this.automata, next).getReachable();
                temp.append(text.charAt(i));
                if (reachable.contains(null)) {
                    strings.add(new String(temp));
                    temp = new StringBuilder();
                    reachable = new ReachableVertices(this.automata, 0).getReachable();
                    System.out.println("Match");
                }
            } else reachable = new ReachableVertices(this.automata, 0).getReachable();


        }
        return strings;
    }

    public String pattern() {
        return this.pattern;
    }

}
