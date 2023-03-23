import java.util.List;
import java.util.Scanner;

public class Producto {
    public final String nombre;
    public double precio;
    public int cantidad;
    public String idProveedor;


    public Producto(String nombre,double precio,int cantidad,String idProveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idProveedor = idProveedor;
    }
    public static void Registrar_Pro(List<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del producto: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el precio del producto por kilo: ");
        double precio = entrada.nextDouble();
        System.out.println("Ingrese el número de unidades: ");
        int cantidad = entrada.nextInt();
        System.out.println("Ingrese id del proveedor relacionado: ");
        String proveedor = entrada.next();

        Producto new_pro= new Producto(nombre,precio,cantidad,proveedor);

        productos.add(new_pro);
    }
    public static void eliminar_Pro(List<Producto> productos  ) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea eliminar: ");
        String nombre = entrada.nextLine();
        int cont=0;
        for(Producto producto:productos){
            if (producto.nombre.equals(nombre)){
                cont++;
                productos.remove(producto);
                break;

            }
        }

        if (cont==0){
            System.out.println(" \nNo existe un producto con este nombre: "+ nombre+"\n");
        }
        else{
            System.out.println("\n Producto eliminado correctamente \n");

        }

    }
    public static void Ver_Productos(List<Producto> productos){
        for(Producto pro: productos){
            System.out.println(pro);
        }
    }
    public static void Productos_Agotados(List<Producto> productos){
        for(Producto pro: productos){
            if(pro.cantidad<10){
                System.out.println(pro);
            }
        }
    }
    public static void DisminuirProductos(List<Producto>productos,int cupos){
        for(Producto pro: productos){
            pro.cantidad = pro.cantidad - cupos;
        }
    }

    public static int VerificarInventario(List<Producto> productos,int cupos){
        for(Producto pro: productos){
            if(pro.cantidad<cupos){
                return 0;
            }
        }
        return 1;
    }

    public static void Realizar_pedido(PAE pae){
        Scanner entrada = new Scanner(System.in);
        double precio = 0;
        System.out.println("Opciones:");
        System.out.println("1. Realizar pedido de todos los productos a punto de agotarse");
        System.out.println("2. Realizar pedido de un solo producto ");
        System.out.print("Ingrese seleccion: ");
        int op = entrada.nextInt();
        if (op == 1){
            System.out.print("Ingrese el numero de kilos para cada producto: ");
            int k = entrada.nextInt();
            for(Producto pro: pae.productos){
                if(pro.cantidad<10){
                    precio = precio + (pro.precio * k);
                    pro.cantidad = pro.cantidad + k;
                }
            }
            System.out.println("El valor total de todos los pedidos es: "+precio);
            pae.presupuesto = pae.presupuesto - precio;
        }
        if (op == 2){
            System.out.println("Ingrese el nombre del producto que desea abastecer: ");
            String nombre = entrada.nextLine();
            int cont=0;
            for(Producto producto:pae.productos){
                if (producto.nombre.equals(nombre)){
                    System.out.print("Ingrese el numero de kilos para cada producto: ");
                    int k = entrada.nextInt();
                    precio = producto.precio*k;
                    pae.presupuesto = pae.presupuesto - precio;
                    cont++;
                    break;
                }
            }

            if (cont==0){
                System.out.println(" \nNo existe un producto con este nombre: "+ nombre+"\n");
            }
            else{

                System.out.println("El valor total de todos los pedidos es: "+precio);
            }
        }
    }

    @Override
    public String toString(){
        return "Nombre: "+this.nombre+"\nPrecio por kilo: "+this.precio+"\nCantidad de kilos: "+this.cantidad+"\nId proveedor: "+this.idProveedor;
    }

}
