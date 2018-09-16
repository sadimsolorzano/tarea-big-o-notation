package javaapplication1;

import java.util.Collections;
import java.util.Formatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Logarithmic {

public static void main(String[] args) {
    Logarithmic logarithmic = new Logarithmic();
    LogarithmicExampleType quadraticExampleType = LogarithmicExampleType.BinarySearch;
    switch (quadraticExampleType)
    {
        case BinarySearch:
            ArrayList<Integer> numberList = new ArrayList<Integer>();
            Collections.addAll(numberList, 1, 3, 3, 7, 10, 11, 16, 17, 20, 21, 25, 26, 30, 32, 34 , 35);
            int needle = 26;
            int min = 0;
            Integer position = logarithmic.BinarySearch(numberList, needle, min, numberList.size() - 1);
            position = position ==null? -1:position;
            Formatter formatter = new Formatter().format("Position: %s", position);
            System.out.println(formatter.toString());
            break;
    }
}

public Integer BinarySearch(ArrayList<Integer> numberList, int needle, int min, int max) {
    int midpoint = (max + min) / 2;
    if (numberList.size() > 0 && numberList.get(midpoint) == needle)
    {
        return midpoint;
    }
    if (min >= max)
    {
        return null;
    }
    if (numberList.get(midpoint) > needle)
    {
        return BinarySearch(numberList, needle, min, midpoint - 1);
    }
    return BinarySearch(numberList, needle, midpoint + 1, max);
}
}
