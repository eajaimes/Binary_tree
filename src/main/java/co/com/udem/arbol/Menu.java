package co.com.udem.arbol;

import java.util.Scanner;
import java.util.List;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgramaArbol arbol = null;
        boolean exit = false;
        while (!exit) {
            System.out.println("-----------------------------------");
            System.out.println("Bienvenido al programa de Árboles");
            System.out.println("-----------------------------------");
            System.out.println("Seleccione una opción:");
            System.out.println("-----------------------------------");
            System.out.println("-1: Ingresar nodos infinitos");
            System.out.println("-----------------------------------");
            System.out.println("0: Crear un árbol vacío");
            System.out.println("-----------------------------------------------------");
            System.out.println("Cualquier número positivo: Crear árbol con nodos");
            System.out.println("-----------------------------------------------------");
            System.out.println("X: Salir del programa");
            System.out.println("-----------------------------------");

            System.out.print("Seleccione la opción que desea: ");
            String input = scanner.nextLine().trim();
            switch (input.toUpperCase()) {
                case "X":
                    exit = true;
                    break;
                case "-1":
                    arbol = new ProgramaArbol();
                    crear_arbol_inf(arbol, scanner);
                    break;
                case "0":
                    System.out.println("Se creó un árbol vacío");
                    arbol = new ProgramaArbol();
                    break;
                default:
                    try {
                        int cantidad = Integer.parseInt(input);
                        arbol = new ProgramaArbol();
                        arbol_cant_nodos(cantidad, arbol, scanner);
                    } catch (NumberFormatException e) {
                        System.out.println("Error, esta opción no está disponible, ingrese algo válido.");
                    }
            }
            if (arbol != null && !exit) {
                menu_opc(arbol, scanner);
            }
        }
        scanner.close();
    }

    private static void crear_arbol_inf(ProgramaArbol arbol, Scanner scanner) {
        while (true) {
            System.out.print("Ingresa el valor que deseas para el nodo, si quieres salir presiona (x): ");
            String valorNodo = scanner.nextLine().trim();
            if (valorNodo.equalsIgnoreCase("X")) {
                break;
            }
            try {
                int valor = Integer.parseInt(valorNodo);
                arbol.insertar(valor);
            } catch (NumberFormatException e) {
                System.out.println("Error, debes ingresar un número o X para salir.");
            }
        }
    }

    private static void arbol_cant_nodos(int cantidad, ProgramaArbol arbol, Scanner scanner) {
        int i = 0;
        while (i < cantidad) {
            try {
                System.out.print("Ingrese el valor del nodo " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    int valorNodo = scanner.nextInt();
                    arbol.insertar(valorNodo);
                    i++;
                } else {
                    System.out.println("Error, debes ingresar un número.");
                    scanner.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error, debes ingresar un número.");
            }
        }
    }

    private static void menu_opc(ProgramaArbol arbol, Scanner scanner) {
        System.out.println("Menu opc");

        System.out.println("-- Recorrido PostOrder del árbol ingresado anteriormente --");
        arbol.recPostOrden();
        System.out.println();

        System.out.println("-- Recorrido PreOrder del árbol ingresado anteriormente --");
        arbol.recPreOrden();
        System.out.println();

        System.out.println("--Recorrido InOrder del árbol ingresado anteriormente. --");
        arbol.recEnOrden();
        System.out.println();

        int cantidadHojas = arbol.cont_h();
        System.out.println("Numero de Hojas : " + cantidadHojas);

        int altura = arbol.altura();
        System.out.println("Altura : " + altura);

        boolean esCompleto = arbol.esCompleto();
        System.out.println("Decir si es completo o no: " + (esCompleto ? "Si es completo!" : "No es completo :("));

        int cantidadNodos = arbol.contarNodos();
        System.out.println("Número de nodos: " + cantidadNodos);
        System.out.println();
        scanner.nextLine();

        // Nueva funcionalidad, buscar numero dentro de los nodos y ver si existe o no.
        System.out.print("Se han agregado las funcionalidades de búsqueda de nodos (Si or No): ");
        String respuesta = scanner.nextLine().trim();

        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("Ingrese el valor del nodo inicial: ");
            int valorNodoInicio = scanner.nextInt();
            System.out.print("Ingrese el valor del nodo final: ");
            int valorNodoFin = scanner.nextInt();
            scanner.nextLine();


            System.out.print("Ingrese el valor del nodo a buscar: ");
            int valorBuscar = scanner.nextInt();
            scanner.nextLine();

            boolean encontrado = arbol.buscar(valorBuscar);
            System.out.println("El valor " + valorBuscar + (encontrado ? " se encuentra" : " no se encuentra") + " en el árbol.");
        } else if (respuesta.equalsIgnoreCase("No")) {
            System.out.println("Saliendo de las funcionalidades agregadas.");
        } else {
            System.out.println("Opción no reconocida. Saliendo.");
        }
    }
}


