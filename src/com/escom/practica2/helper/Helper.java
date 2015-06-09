package com.escom.practica2.helper;

import java.util.ArrayList;

public class Helper {

    private int valorInicial;
    private int valorFinal;
    private ArrayList listaNumero;

    public Helper() {
    }

    public Helper(int valorInicial, int valorFinal) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        listaNumero = new ArrayList();
    }

    private int numeroAleatorio() {
        return (int) (Math.random() * (valorFinal - valorInicial + 1) + valorInicial);
    }

    public int generar() {
        if (listaNumero.size() < (valorFinal - valorInicial) + 1) {
            //Aun no se han generado todos los numeros
            int numero = numeroAleatorio();//genero un numero
            if (listaNumero.isEmpty()) {//si la lista esta vacia
                listaNumero.add(numero);
                return numero;
            } else {//si no esta vacia
                if (listaNumero.contains(numero)) {//Si el numero que generé esta contenido en la lista
                    return generar();//recursivamente lo mando a generar otra vez
                } else {//Si no esta contenido en la lista
                    listaNumero.add(numero);
                    return numero;
                }
            }
        } else {// ya se generaron todos los numeros
            return -1;
        }
    }

    public Integer[] llenarArreglo() {
        Helper na = new Helper(0, 3);
        Integer datos[] = new Integer[4];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = na.generar();
        }
        return datos;
    }

//    public static void main(String[] args) {
//
//        Helper help = new Helper();
//        Integer datos[] = help.llenarArreglo();
//        
//        for(int i=0 ; i< datos.length;i++){
//            System.out.println(datos[i]);
//        
//        }
//    }
}
