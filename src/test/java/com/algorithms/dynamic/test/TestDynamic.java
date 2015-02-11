package com.algorithms.dynamic.test;

import com.algorithms.dynamic.Fibonacci;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Dante-666
 * @version 1.0
 */
public class TestDynamic {

    @Test(groups = "Basic-DP", timeOut = 15000)
    public void testFibonacci() {
        Fibonacci fib = new Fibonacci(10000);

        Assert.assertEquals(5, fib.compute(90));

    }
}
