import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        PAE pae= new PAE();

        while (true) {

            Scanner entrada = new Scanner(System.in);
            System.out.println("------------------------ PAE ------------------------");
            System.out.println("1. Registar nuevo colegio: ");
            System.out.println("2. Registar proovedor");
            System.out.println("3. Ver informacion de un colegio: ");
            System.out.println("4. Ver informacion de un proveedor: ");
            System.out.println("5. Editar datos del provedor ");
            System.out.println("6. Eliminar proveedor ");
            System.out.println("7. Agregar producto");
            System.out.println("8. Eliminar producto ");
            System.out.println("9. Ver todos los productos");
            System.out.println("10. Ver productos a punto de agotarse ");
            System.out.println("11. Realizar pedido de producto ");
            System.out.println("12. Realizar entrega a colegio ");
            System.out.println("13. Ver historial de entregas");
            System.out.println("14. Agregar dinero al presupuesto ");
            System.out.println("15. Ver presupuesto ");
            System.out.println("16. Salir ");
            System.out.print("Ingrese el numero de la operacion que desea realizar: ");
            int opcion = entrada.nextInt();

            if (opcion == 1) {
                System.out.println("\n------------------------------------------------");
                Colegio.Registrar_Col(pae.colegios);
                System.out.println("\n Colegio registrado correctamente \n");
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 2) {
                System.out.println("------------------------------------------------\n");
                Proveedor.Registrar_Prov(pae.proveedores);
                System.out.println("\n Proveedor registrado correctamente \n");
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 3) {
                System.out.println("------------------------------------------------\n");
                Colegio.Ver_Informacion_Col(pae.colegios);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 4) {
                System.out.println("------------------------------------------------\n");
                Proveedor.Ver_Informacion_Prov(pae.proveedores);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 5) {
                System.out.println("------------------------------------------------\n");
                Proveedor.Editar_Prov(pae.proveedores);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 6) {
                System.out.println("------------------------------------------------\n");
                Proveedor.Eliminar_Prov(pae.proveedores);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 7) {
                System.out.println("\n------------------------------------------------");
                Producto.Registrar_Pro(pae.productos);
                System.out.println("\n Producto registrado correctamente \n");
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 8) {
                System.out.println("\n------------------------------------------------");
                Producto.eliminar_Pro(pae.productos);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 9) {
                System.out.println("\n------------------------------------------------");
                Producto.Ver_Productos(pae.productos);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 10) {
                System.out.println("\n------------------------------------------------");
                Producto.Productos_Agotados(pae.productos);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 11) {
                System.out.println("\n------------------------------------------------");
                Producto.Realizar_pedido(pae);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 12) {
                System.out.println("\n------------------------------------------------");
                Entrega.Generar_Entrega(pae);
                System.out.println("\n Entrega registrada correctamente \n");
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 13) {
                System.out.println("\n------------------------------------------------");
                Entrega.historialEntregas(pae.entregas);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 14) {
                System.out.println("\n------------------------------------------------");
                pae.incrementarPresupuesto();
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 15) {
                System.out.println("\n------------------------------------------------");
                System.out.println("El presupuesto del PAE es: "+pae.presupuesto);
                System.out.println("------------------------------------------------\n");
            }
            if (opcion == 16){
                System.out.println(" Chao :) ");
                System.out.println("------------------------------------------------\n");
                break;
            }
            if (opcion < 1  && opcion>16){
                System.out.println("\n Ingrese una opcion valida \n");
            }
        }
    }
}
