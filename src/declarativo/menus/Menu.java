package declarativo.menus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Menu {
    public final Scanner scanner = new Scanner(System.in);
    public final String titulo = "=== PROGRAMA DE ALIMENTACIÓN ESCOLAR ===";

    public boolean confirmarContinuar() {
        int op = obtenerEntradaInt("[?] ¿Desea continuar? Presione 1 para continuar o 0 para salir: ");
        return op > 0;
    }

    public int leerOpcion(int cantidadOpciones) {
        int opcion = 0;
        boolean valorIncorrecto = true;
        while (valorIncorrecto) {
            opcion = obtenerEntradaInt(":");

            if (opcion <= 0 || opcion > cantidadOpciones) {
                System.out.println("[!] Opción ingresada no válida, ingrese nuevamente una opción correcta.");
            } else {
                valorIncorrecto = false;
            }
        }
        return opcion;
    }

    public int obtenerOpcion(int cantidadOpciones) {
        int opcion = 0;
        boolean valorIncorrecto = true;
        while (valorIncorrecto) {
            opcion = obtenerEntradaInt("Ingresa la opción a seleccionar:");
            if (opcion <= 0 || opcion > cantidadOpciones) {
                System.out.println("[!] El valor ingresado debe ser una opción válida. Inténtalo nuevamente.");
            } else {
                valorIncorrecto = false;
            }
        }
        return opcion;
    }

    public int obtenerEntradaInt(String texto) {
        String entradaUsuario = "";
        boolean valorIncorrecto = true;
        while (valorIncorrecto) {
            entradaUsuario = obtenerEntradaTexto(texto);
            if (!entradaUsuario.matches("\\d+")) {
                System.out.println("[!] El valor ingresado debe ser un número entero. Inténtalo nuevamente.");
            } else {
                valorIncorrecto = false;
            }
        }
        return Integer.parseInt(entradaUsuario);
    }

    public float obtenerEntradaFloat(String texto) {
        String entradaUsuario = "";
        boolean valorIncorrecto = true;
        while (valorIncorrecto) {
            entradaUsuario = obtenerEntradaTexto(texto);
            if (!(entradaUsuario.matches("\\d+") || entradaUsuario.matches("\\d+\\.\\d+"))) {
                System.out.println("[!] El valor ingresado debe ser un número decimal. Inténtalo nuevamente.");
            } else {
                valorIncorrecto = false;
            }
        }
        return Float.parseFloat(entradaUsuario);
    }

    public String obtenerEntradaTexto(String texto) {
        System.out.println(texto);
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void verIterable(LinkedList<?> lista) {
        if (lista.size() == 0) {
            System.out.println("***Lista vacía***");
        } else {
            lista.forEach(item -> System.out.printf("[%d] %s%n", lista.indexOf(item) + 1, item.toString()));
        }
    }

    public int selecionarItem(LinkedList<?> lista) {
        if (lista.size() == 0) {
            System.out.println("[!] No existen elementos en la lista.");
            return -1;
        } else {
            int opcion = 0;
            while (true) {
                opcion = obtenerEntradaInt("Ingresa el índice del elemento a seleccionar:");
                if (opcion <= 0 || opcion > lista.size()) {
                    System.out.println("[!] El valor ingresado debe ser un índice válido. Inténtalo nuevamente.");
                } else {
                    return opcion;
                }
            }
        }
    }

    public int obtenerElemento(String texto, LinkedList<?> lista) {
        System.out.println(texto);
        verIterable(lista);
        if (lista.size() == 0) {
            return -1;
        } else {
            int opcion = 0;
            while (true) {
                opcion = obtenerEntradaInt("Ingresa el índice del elemento a seleccionar:");
                if (opcion <= 0 || opcion > lista.size()) {
                    System.out.println("[!] El valor ingresado debe ser un índice válido. Inténtalo nuevamente.");
                } else {
                    return opcion - 1;
                }
            }
        }
    }

    public void mostrarOpciones(String titulo, String cabecera, String... opciones) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(titulo);
        sb.append("\n");
        sb.append(cabecera);
        sb.append("\n");
        Arrays.stream(opciones).forEach(opcion ->
                sb.append("[%d] %s\n".formatted(Arrays.stream(opciones).toList().indexOf(opcion) + 1, opcion))
        );
        System.out.println(sb);
    }
}