package com.algorithms.dynamic;

/**
 * @author Dante-666
 * @version 1.0
 */
public class Fibonacci {
    long fib[];

    public Fibonacci(int n) {
        fib = new long[n + 1];
        fib[0] = fib[1] = 1;
    }

    public long compute(int n) {
        if (n == 0 || n == 1) return 1;

        if (fib[n] != 0) return fib[n];

        return compute(n - 1) + compute(n - 2);
    }
}
