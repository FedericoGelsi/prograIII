package com.uade.prograIII.tpo.ejercitacion;

public class Factorial {
    public int factorial(int n){
        if (n<0){
            throw new IllegalArgumentException("Input number must be positive");
        }
        if (n == 1){
            return 1;
        }
        return factorial(n-1) * n;
    }
}
