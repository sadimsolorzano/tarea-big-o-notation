package javaapplication1;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.time.Duration;
import java.time.Instant;

public class Lineal {
long[] fibonacciCache = null;

public static void main(String[] args) {
	
    try {
        Instant starts = Instant.now();
        Lineal lineal = new Lineal();
        LinealExampleType linealExampleType = LinealExampleType.Fibonacci;
        int nFibonacciCache = 8;
        lineal.fibonacciCache = new long[nFibonacciCache + 1];
        switch (linealExampleType)
        {
            case Loop:
                int n = 50;
                lineal.Loop(n); break;
            case ContainsNeedle:
                List<Integer> numberList = new ArrayList<Integer>();
                int needle = 76;
                boolean found = lineal.ContainsNeedle(needle, numberList);
                Formatter formatter = new Formatter().format("Number %s %s", needle, found);
                System.out.println(formatter.toString()); break;
            case Factorial:
                int nFactorial = 10;
                long factorial = lineal.Factorial(nFactorial);
                formatter = new Formatter().format("Factorial of %s equal to %s", nFactorial, factorial);
                System.out.println(formatter.toString()); break;
            case Fibonacci:
                int nFibonacci = 80;
                for (int i = 1; i <= nFibonacci; i++)
                {
                    long fibonacci = lineal.Fibonacci(i);
                    formatter = new Formatter().format("fibonacci %s = %s", i, fibonacci);
                    System.out.println(formatter.toString());
                } break;
            case FibonacciCache:
                for (int i = 1; i <= nFibonacciCache; i++)
                {
                    long fibonacci = lineal.FibonacciCache(i);
                    formatter = new Formatter().format("fibonacci %s = %s", i, fibonacci);
                    System.out.println(formatter.toString());
                } break;
        }
        Instant ends = Instant.now();
        System.out.println("Time elapsed:" + Duration.between(starts, ends).toMillis()/1000.0);
    } catch (Exception e) {
    }
}
	
public void Loop(long n) {
    int counter = 1;
    while (counter <= n)
    {
        System.out.println(counter);
        counter++;
    }
}

public boolean ContainsNeedle(int needle, List<Integer> numberList) {
    for(Integer item : numberList) {
            if(item == needle) {
                    return true;
            }
    }
    return false;
}

public long Factorial(int n) {
    if (n == 1)
    {
        return 1;
    }
    return n * Factorial(n - 1);
}

public long Fibonacci(long n) throws Exception
{
    if (n < 0)
    {
        throw new Exception("n can not be less than zero");
    }
    if (n <= 2)
    {
        return 1;
    }
    long fibonacci = 0;
    long previous = 1;
    long penultimate = 0;
    for (int i = 1; i <= n; i++)
    {
        penultimate = fibonacci;
        fibonacci = previous + fibonacci;
        previous = penultimate;
    }
    return fibonacci;
}

public long FibonacciCache(long n) throws Exception {
    if (n < 0)
    {
        throw new Exception("n can not be less than zero");
    }
    if (n <= 2)
    {
        fibonacciCache[(int) n] = 1;
    }
    if (fibonacciCache[(int) n] == 0)
    {
        fibonacciCache[(int) n] = FibonacciCache(n - 1) + FibonacciCache(n - 2);
    }
    return fibonacciCache[(int) n];
}
}
