package com.company;

import java.util.Scanner;

/**
 *Esta clase sirve para sacar los numeros primos desde el uno hasta el numero indicado.
 * @author David Balaguer
 *
 */
public class Main {

    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el numero para la criba de Erastótenes:");
        int dato = teclado.nextInt();

        int[] vector = new int[dato];

        System.out.println("\nVector inicial hasta :"+dato);

        impirmirVectorInicial(vector);

        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);


        imprimirVectorFinal(vector);
    }
    /*
    En esta método se imprime el vector inicial con todos los numeros desde el uno hasta el numero indicado
    anteriormente
     */
    private static void impirmirVectorInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print( i + 1 + "\t" );
        }
    }
    /*
    En este método se imprime el vector el cual contiene todos los números primos que había en el vector inicial
     */
    private static void imprimirVectorFinal(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i]+"\t");
        }
    }

    /**
     * En este metodo se generan los numeros primos del 1 a el valor maximo indicado en el parametro max.
     * @param max Este es el valor maximo hasta el cual se van a generar todos los numeros primos.
     * @return Este metodo devuelve un vector con todos los numeros primos.
     */
    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];

            // Inicializar el array
            for (i = 0; i < dim; i++) {
                esPrimo[i] = true;
            }

            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;

            // Criba
            for (i = 2; i < Math.sqrt(dim) + 1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    for (j=2*i; j<dim; j+=i)
                        esPrimo[j] = false;
                }
            }

            // ¿Cuántos primos hay?
            int cuenta = 0;
            for (i=0; i<dim; i++) {
                if (esPrimo[i]) {
                    cuenta++;
                }
            }

            // Rellenar el vector de números primos
            int[] primos = new int[cuenta];
            for (i=0, j=0; i<dim; i++) {
                if (esPrimo[i])
                    primos[j++] = i;
            }
            return primos;
        } else { // max < 2
            // Devolver vector vacío
            return new int[0];

        }
    }
}