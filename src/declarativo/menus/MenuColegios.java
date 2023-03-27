package declarativo.menus;

import declarativo.modelos.PAE;
import declarativo.modelos.Colegio;

public class MenuColegios extends Menu {
    public MenuColegios(PAE pae) {
        while (true) {
            String[] opciones = new String[]{"Ver colegios", "Registrar colegio","Salir al menú principal"};
            mostrarOpciones(titulo, "- ADMINISTRAR COLEGIOS -", opciones);
            int opcion = obtenerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> {
                    System.out.println("- LISTA DE COLEGIOS -");
                    verIterable(pae.colegios);
                }
                case 2 -> {
                    pae.agregarColegio(new Colegio(
                            obtenerEntradaTexto("Ingresa el nombre del colegio:"),
                            obtenerEntradaTexto("Ingresa el NIT del colegio:"),
                            obtenerEntradaInt("Ingresa los cupos del colegio:")
                    ));
                    System.out.println("[✔] Colegio agregado correctamente.");
                }
                case 3 -> {
                    System.out.println("[!] Saliendo al menú principal...");
                    return;
                }
            }
        }
    }
}