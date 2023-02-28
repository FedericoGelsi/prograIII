package com.uade.prograIII.tpo.ejercitacion;

import java.util.List;

public class DivideAndConquer {

    public boolean esOrdenadoAlfabeticamente(List<Character> arr, int origen, int destino ){
        if (origen < 0 || destino < 0){
            throw new IllegalArgumentException("Input number must be positive");
        }
        if (origen == destino){
            return true;
        }
        if (arr.get(origen) > arr.get(destino)){
            return false;
        } else {
            int medio = (origen + destino) / 2;
            return esOrdenadoAlfabeticamente(arr, origen, medio) && esOrdenadoAlfabeticamente(arr, medio+1, destino);
        }
    }

    public boolean existeEn(List<Integer> arr, int origen, int destino, Integer x ){
        if (origen < 0 || destino < 0){
            throw new IllegalArgumentException("Input number must be positive");
        }
        if (destino == origen+1){
            return arr.get(origen).equals(x) || arr.get(destino).equals(x);
        }
        else {
            int medio = (origen + destino) / 2;
            return existeEn(arr, origen, medio, x) || existeEn(arr, medio+1, destino, x);
        }
    }

    public long potenciaDeDos( long a, long n){
        if (n == 2){
            return a*a;
        }
        else {
            return potenciaDeDos(a, n/2) * potenciaDeDos(a, n/2);
        }
    }
}
