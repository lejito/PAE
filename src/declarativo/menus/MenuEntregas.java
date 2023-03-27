package declarativo.menus;

import declarativo.modelos.PAE;
import declarativo.modelos.Colegio;
import declarativo.modelos.Entrega;

public class MenuEntregas extends Menu {
    public MenuEntregas(PAE pae) {
        while (true) {
            String[] opciones = new String[]{"Ver historial de entregas", "Realizar entrega a colegio", "Salir al menú principal"};
            mostrarOpciones(titulo, "- ADMINISTRAR PRODUCTOS -", opciones);
            int opcion = leerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> {
                    System.out.println("- HISTORIAL DE ENTREGAS -");
                    verIterable(pae.entregas);
                }
                case 2 -> {
                    if (pae.colegios.size() == 0) {
                        System.out.println("[!] Para realizar esta acción es necesario que hayan colegios registrados.");
                    } else {
                        Colegio colegio = pae.colegios.get(obtenerElemento("Elige el colegio para realizar la entrega:", pae.colegios));
                        if (pae.productos.stream().noneMatch(producto -> producto.cantidad < colegio.cupos)) {
                            System.out.printf("[!] No hay producto suficientes para el colegio '%s' con %d cupos.", colegio.nombre, colegio.cupos);
                            break;
                        }
                        pae.productos.forEach(producto -> producto.cantidad -= colegio.cupos);
                        pae.agregarEntrega(new Entrega(colegio));
                        System.out.println("[✔] Entrega agregada correctamente.");
                    }
                }
                case 3 -> {
                    System.out.println("[!] Saliendo al menú principal...");
                    return;
                }
            }
        }
    }
}