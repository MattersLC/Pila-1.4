package Pila1_4;

import java.util.*;

public class Pila1_4 {
    
    public static Scanner sc = new Scanner (System.in);
    public static int tope=0, opc, pos, aux;
    public static char pilas[] = new char[26];
    public static char delete, add, letra='A';
    
    // Métodos 
    public static void isEmpty() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - -¡La pila vacía!- - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public static void isFull() {
        System.out.println("Total de elementos: "+tope);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
        System.out.println("- - - - - - -¡La pila llena!- - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
    }
    
    public static void menu() {
        // Mostramos el menú y pedimos el valor de 'opc' que nos indicará que 'case' realizar.
        System.out.println("*************** M E N Ú ***************");
        System.out.print("1 - Llenar pila.\n"
                       + "2 - Mostrar pila.\n"
                       + "3 - Ordenar pila.\n"
                       + "4 - Eliminar elementos de la pila.\n"
                       + "5 - Agregar elementos en la pila.\n"
                       + "6 - Salir.\n"
                       + "Tu respuesta: ");
        opc = sc.nextInt();
    }
    
    public static void llenar() {
        // Llenamos la pila con valores del abecedario aleatoriamente.
        int numero;
        // 'Set' y random se encargan de comprobar que no se repitan las letras generadas aleatoriamente.
        Set<Integer> random = new HashSet<>();
        System.out.println("\n- - - - - - -¡Llenando pila!- - - - - - -");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        for (int i=0; i<26; i++) {
            // 'comprobar' es la variable que uso para controlar el ciclo while
            boolean comprobar = false;
            if (tope<26) {
                while (!comprobar) {
                    // Genero un número random y lo convierto en letra.
                    numero = (int)(Math.random()*(91-65)+65);
                    // Comprobamos que no se repita, haciendo uso de 'contains()'
                    if (!random.contains(numero)) {
                        random.add(numero);
                        // Se rompe el ciclo while y continuamos iterando el ciclo for
                        comprobar = true;
                        letra = (char) numero;
                        pilas[tope] = letra;
                        letra++;
                        tope++;
                    }
                }
            }
        }
        System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -\n");
    } 
    
    public static void mostrar() {
        // Si 'tope' tiene un elemento o más, muestro la pila, sino, llamo a isEmpty();
        if (tope > 0){
            System.out.println("\nMostrando pila:\n");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
            for (int i=0; i<tope; i++) {
                System.out.print(pilas[i]+" ");
            }
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public static void ordenar() {
        // Si 'tope' tiene un elemento o más, ordeno la pila, sino, llamo a isEmpty();
        if (tope > 0) {
            // 'pos' y 'aux' son variables de ayuda para guardar datos.
            for (int i=0; i<tope; i++) {
                pos = i;
                aux = pilas[i];
                /* Si 'pos' es mayor a cero, y además si el número anterior es mayor que el número actual, intercambio sus 
                   valores. */
                while((pos>0) && (pilas[pos-1] > aux)) {
                    pilas[pos] = pilas[pos-1];
                    pos--;
                }
                pilas[pos] = (char)aux;
            }
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
            System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public static void eliminar() {
        // Si 'tope' tiene un elemento o más, elimino un elemento, sino, llamo a isEmpty();
        if (tope > 0) {
            tope--;
            System.out.println("Total de elementos: "+tope);
            System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
            System.out.println("- - - - - - - - -¡Listo!- - - - - - - - -");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -\n");
        } else {
            isEmpty();
        }
    }
    
    public static void agregar() {
        // Si 'tope' tiene un elemento o más y además tiene menos de 25 elementos
        // Agrego un elemento, sino, llamo a isEmpty(); o a isFull();
        if (tope > 0) {
            if (tope < 25){
                System.out.println("¿Qué letra te gustaría agregar?");
                add = sc.next().charAt(0);
                add = Character.toUpperCase(add);
                pilas[tope] = add;
                tope++;
            } else {
                isFull();
            }
        } else {
            isEmpty();
        }
    }
    
    // Main
    public static void main(String[] args) {
        
        do {
            menu();
            switch(opc) {
                case 1: // Llenar
                    llenar();
                break;
                case 2: // Mostrar
                    mostrar();
                break;
                case 3: // Ordenar
                    ordenar();
                break;
                case 4: // Eliminar
                    eliminar();
                break;
                case 5: // Agregar
                    agregar();
                break;
                case 6: // Bucle
                break;
                default:
                    System.out.println("No introduciste una opción válida...");
                break;
            }
        }while(opc != 6);
    }
}
