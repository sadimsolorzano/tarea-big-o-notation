package javaapplication1;

import java.time.Instant;
import java.util.Formatter;
import java.time.Duration;

public class Exponential {

public static void main(String[] args) {
    Instant starts = Instant.now();
    try {
        Exponential exponential = new Exponential();
        ExponentialExampleType exponentialExampleType = ExponentialExampleType.Fibonacci;
        switch (exponentialExampleType)
        {
            case Fibonacci:
            int n = 43; 
            for (int i = 1; i <= n; i++)
            {
                long fibonacci = exponential.Fibonacci(i);
                Formatter formatter = new Formatter().format("fibonacci %s %d", i, fibonacci);
                System.out.println(formatter.toString());
            } break;
        }
        Instant ends = Instant.now();
        System.out.println("Time elapsed:" + Duration.between(starts, ends).toMillis()/1000.0);	

        } catch (Exception e) {
        }        
}
	
public int Fibonacci(long n) throws Exception {
    if (n < 0)
    {
        throw new Exception("n can not be less than zero");
    }
    if (n <= 2)
    {
        return 1;
    }
    return Fibonacci(n - 1) + Fibonacci(n - 2);
}

}
