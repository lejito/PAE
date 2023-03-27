package declarativo.menus;

import declarativo.modelos.PAE;
import declarativo.modelos.Proveedor;

public class MenuProveedores extends Menu {
    public MenuProveedores(PAE pae) {
        while (true) {
            String[] opciones = new String[]{"Ver proveedores", "Registrar proveedor","Salir al menú principal"};
            mostrarOpciones(titulo, "- ADMINISTRAR PROVEEDORES -", opciones);
            int opcion = obtenerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> {
                    System.out.println("- LISTA DE PROVEEDORES -");
                    verIterable(pae.proveedores);
                }
                case 2 -> {
                    pae.agregarProveedor(new Proveedor(
                            obtenerEntradaTexto("Ingresa el ID del proveedor:"),
                            obtenerEntradaTexto("Ingresa el nombre del proveedor:"),
                            obtenerEntradaTexto("Ingresa el número de teléfono del proveedor:")
                    ));
                    System.out.println("[✔] Proveedor agregado correctamente.");
                }
                case 3 -> {
                    System.out.println("[!] Saliendo al menú principal...");
                    return;
                }
            }
        }
    }
}
