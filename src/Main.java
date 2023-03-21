
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PAE pae= new PAE();


        while (true) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Ingrese que quieres hacer ");
            System.out.println("1. Registar nuevo colegio ");
            System.out.println("2. Registar proovedor ");
            System.out.println("3. Ver informacion de un colegio: ");
            System.out.println("4. Ver informacion de un proveedor: ");
            System.out.println("5. Editar datos de un proveedor ");
            System.out.println("6. Editar datos de un colegio ");
            System.out.println("7. Eliminar proveedor ");
            System.out.println("8. Eliminar colegio ");
            System.out.println("9. Salir ");
            int opcion = entrada.nextInt();



            if (opcion == 1) {

                pae.cupos_disponibles = Colegio.Registrar_Col(pae.colegios, pae.cupos_disponibles);
                System.out.println(pae.colegios);
            }
            if (opcion == 2) {

                Proveedor.Registrar_Prov(pae.proveedores);
                System.out.println(pae.proveedores);
            }
            if (opcion == 3) {

                Colegio.Ver_Informacion_Col(pae.colegios);
            }
            if (opcion == 4) {

                Proveedor.Ver_Informacion_Prov(pae.proveedores);
            }
            if (opcion == 5) {

                Proveedor.Editar_Prov(pae.proveedores);
            }
            if (opcion == 6) {

                pae.cupos_disponibles = Colegio.Editar_Col(pae.colegios, pae.cupos_disponibles);
                System.out.println(pae.cupos_disponibles);

            }
            if (opcion == 7) {

                Proveedor.Eliminar_Prov(pae.proveedores);
                System.out.println(pae.proveedores);


            }
            if (opcion == 8) {

                pae.cupos_disponibles = Colegio.Eliminar_Col(pae.colegios, pae.cupos_disponibles);
                System.out.println(pae.colegios);
                System.out.println(pae.cupos_disponibles);

            }
            if (opcion == 9) {

                break;

            }
        }
    }
}
