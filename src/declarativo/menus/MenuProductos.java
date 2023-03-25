package declarativo.menus;

import declarativo.modelos.Producto;
import declarativo.modelos.Proveedor;

import java.util.LinkedList;

public class MenuProductos extends Menu {
    public  MenuProductos(LinkedList<Producto> productos, LinkedList<Proveedor> proveedores, float presupuesto){
        boolean continuar = true;
        while (continuar){
            mostrarOpciones("MENU PRINCIPAL","MENU DE PRODUCTOS","Ver productos","Agregar producto","Eliminar producto","Ver productos a punto de agotarse","Realizar pedido de producto");
            int opcion = leerOpcion(5);
            switch (opcion){
                case 1 ->{verIterable(productos);}
                case 2 ->{
                    if(proveedores.size() ==0){
                        System.out.println("No existen proveedores disponibles, agregue un proveedor antes de ingresar un producto.");
                        break;
                    }
                    String nombre = obtenerEntradaTexto("Ingrese nombre del producto\n: ");
                    float precio = obtenerEntradaFloat("Ingrese precio del producto por unidad\n: ");
                    int cantidad = obtenerEntradaInt("Ingrese la cantidad del producto que desea agregar\n:");
                    System.out.println("Selecione el proveedor del producto");
                    int selecion = selecionarItem(proveedores);
                    productos.add(new Producto(nombre,precio,cantidad,proveedores.get(selecion)));
                    System.out.println("Producto agregado satisfactoriamente");
                }
                case 3->{
                    System.out.println("Selecione el producto que desea eliminar: ");
                    int selecion = selecionarItem(productos);
                    if (selecion == -1 ){
                        break;
                    }
                    productos.remove(selecion);
                }
                case 4->{
                    System.out.println("Productos a punto de agotarse");
                    productos.stream().filter(producto->producto.cantidad < 10).forEach(producto -> System.out.printf(">[%d]: %s",productos.indexOf(producto),producto.toString()));
                }
                case 5->{
                    float valor = 0;
                    mostrarOpciones("MENU DE PRODUCTOS","MENU DE PEDIDO"," Realizar pedido de todos los productos a punto de agotarse","Realizar pedido de un solo producto");
                    int opcionPedido = leerOpcion(2);
                    switch (opcionPedido){
                        case 1->{
                            productos.stream().filter(producto -> producto.cantidad < 10).forEach(producto -> pedidoProducto(producto,presupuesto));
                        }
                        case 2->{
                            System.out.println("Selecione el producto al cual realizar el pedido");
                            int selecion = selecionarItem(productos);
                            if(selecion == -1){
                                break;
                            }
                            pedidoProducto(productos.get(selecion),presupuesto);

                        }
                    }
                }
            }
            continuar = confirmarContinuar();
        }
    }
    public  void pedidoProducto(Producto producto,float presupuesto){
        int cantidad = obtenerEntradaInt("Ingrese la cantidad para el producto %s que desea agregar\n:".formatted(producto.toString()));
        boolean seguirPedido = true;
        while (presupuesto - cantidad*producto.precio < 0 && seguirPedido){
            System.out.println("Pedido supera el presupuesto, no es posible agregar esa cantidad del producto");
            System.out.printf("Presupuesto actual: %f",presupuesto);
            seguirPedido = confirmarContinuar();
            if (seguirPedido){
                cantidad = obtenerEntradaInt("Ingrese una cantidad nueva para el producto %s que desea agregar\n:".formatted(producto.toString()));
            }
            else {
                cantidad = 0;
            }
        }
        producto.cantidad += cantidad;
        presupuesto-= cantidad*producto.precio;
    }
}
