package declarativo.menus;

import declarativo.modelos.PAE;
import declarativo.modelos.Producto;

import java.util.LinkedList;

public class MenuProductos extends Menu {
    public MenuProductos(PAE pae) {
        while (true) {
            String[] opciones = new String[]{
                    "Ver productos", "Agregar producto", "Eliminar producto",
                    "Ver productos a punto de agotarse", "Realizar pedido", "Salir al menú principal"
            };
            mostrarOpciones(titulo, "- ADMINISTRAR PRODUCTOS -", opciones);
            int opcion = obtenerOpcion(opciones.length);
            switch (opcion) {
                case 1 -> {
                    System.out.println("- LISTA DE PRODUCTOS -");
                    verIterable(pae.productos);
                }
                case 2 -> {
                    if (pae.proveedores.size() == 0) {
                        System.out.println("[!] Para realizar esta acción es necesario que hayan proveedores registrados.");
                    } else {
                        pae.agregarProducto(new Producto(
                                obtenerEntradaTexto("Ingresa el nombre del producto:"),
                                obtenerEntradaFloat("Ingresa el precio unitario del producto:"),
                                obtenerEntradaInt("Ingresa la cantidad del producto:"),
                                pae.proveedores.get(obtenerElemento("Elige el proveedor del producto:", pae.proveedores))
                        ));
                        System.out.println("[✔] Producto agregado correctamente.");
                    }
                }
                case 3 -> {
                    if (hayProductos(pae.productos)) {
                        int index = obtenerElemento("Elige el producto a eliminar:", pae.productos);
                        pae.eliminarProducto(index);
                        System.out.println("[✔] Producto eliminado correctamente.");
                    }
                }
                case 4 -> {
                    if (hayProductos(pae.productos)) {
                        System.out.println("- LISTA DE PRODUCTOS A PUNTO DE AGOTARSE -");
                        verIterable(productosAPuntoDeAgotarse(pae.productos));
                    }
                }
                case 5 -> {
                    if (hayProductos(pae.productos)) {
                        String[] opcionesPedido = new String[]{
                                "Realizar pedido de un solo producto",
                                "Realizar pedido de todos los productos a punto de agotarse",
                        };
                        mostrarOpciones("- ADMINISTRAR PRODUCTOS -", "- REALIZAR PEDIDO -", opcionesPedido);
                        int opcionPedido = obtenerOpcion(opcionesPedido.length);
                        switch (opcionPedido) {
                            case 1 -> {
                                if (hayProductos(pae.productos)) {
                                    realizarPedido(pae.productos.get(obtenerElemento("Elige el producto para realizar el pedido:", pae.productos)), pae);
                                }
                            }
                            case 2 ->
                                    productosAPuntoDeAgotarse(pae.productos).forEach(producto -> realizarPedido(producto, pae));
                        }
                    }
                }
                case 6 -> {
                    System.out.println("[!] Saliendo al menú principal...");
                    return;
                }
            }
        }
    }

    public boolean hayProductos(LinkedList<Producto> productos) {
        if (productos.size() == 0) {
            System.out.println("[!] Para realizar esta acción es necesario que hayan productos registrados.");
            return false;
        } else {
            return true;
        }
    }

    public LinkedList<Producto> productosAPuntoDeAgotarse(LinkedList<Producto> productos) {
        LinkedList<Producto> productosAPuntoDeAgotarse = new LinkedList<>();
        productos.forEach(producto -> {
            if (producto.cantidad < 10) {
                productosAPuntoDeAgotarse.add(producto);
            }
        });
        return productosAPuntoDeAgotarse;
    }

    public void realizarPedido(Producto producto, PAE pae) {
        int cantidad = 0;
        float costo = 0;
        while (true) {
            System.out.printf("- Presupuesto actual: $%f%n", pae.presupuesto);
            cantidad = obtenerEntradaInt(("Ingrese la cantidad a aumentar para el producto '%s' " +
                    "con precio unitario de $%f y cantidad actual de %d unidades:").formatted(producto.nombre, producto.precio, producto.cantidad));
            costo = producto.precio * cantidad;
            if (costo > pae.presupuesto) {
                System.out.println("[!] El costo del pedido supera el presupuesto. Disminuya la cantidad.");
            } else {
                producto.cantidad += cantidad;
                pae.presupuesto -= cantidad * producto.precio;
                System.out.println("[✔] Pedido del producto '" + producto.nombre + "' realizado correctamente.");
                return;
            }
        }
    }
}