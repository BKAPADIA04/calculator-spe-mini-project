package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator {

    public double squareRoot(int x) {
        return Math.sqrt(x);
    }

    public long factorial(int x) {
        long result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public double naturalLog(int x) {
        return Math.log(x); // ln(x)
    }

    public double powerFunction(int x, int b) {
        return Math.pow(x, b);
    }




}