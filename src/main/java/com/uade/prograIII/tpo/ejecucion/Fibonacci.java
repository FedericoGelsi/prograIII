package com.uade.prograIII.tpo.ejecucion;

public class Fibonacci {
    public int fibonacci(int n){
        if (n<0){
            throw new IllegalArgumentException("Input number must be positive");
        }
        if (n <= 1 ){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
