package declarativo.menus;

import declarativo.modelos.PAE;

public class MenuPrincipal extends Menu {
    public MenuPrincipal(PAE pae) {
        String[] opciones = new String[]{
                "ADMINISTRAR COLEGIOS",
                "ADMINISTRAR PROVEEDORES",
                "ADMINISTRAR PRODUCTOS",
                "ADMINISTRAR ENTREGAS",
                "VER PRESUPUESTO",
                "AGREGAR MONTO AL PRESUPUESTO",
                "SALIR DEL PROGRAMA"
        };
        while (true) {
            mostrarOpciones(titulo, "- MENU PRINCIPAL -", opciones);
            int opcion = obtenerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> {
                    new MenuColegios(pae);
                }
                case 2 -> {
                    new MenuProveedores(pae);
                }
                case 3 -> {
                    new MenuProductos(pae);
                }
                case 4 -> {
                    new MenuEntregas(pae);
                }
                case 5 -> {
                    System.out.printf("- El presupuesto actual es: $%f%n", pae.presupuesto);
                }
                case 6 -> {
                    pae.presupuesto += obtenerEntradaFloat("Ingrese el monto a agregar en el presupuesto:");
                }
                case 7 -> {
                    System.out.println("[!] Saliendo del programa...");
                    System.exit(0);
                }
            }
        }
    }
}