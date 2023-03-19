
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        while (true) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Ingrese que quieres hacer");
            System.out.println("1. Registar nuevo colegio: ");
            System.out.println("2. Registar proovedor");
            System.out.println("3. Ver informacion de un colegio: ");
            System.out.println("4. Ver informacion de un proveedor: ");
            System.out.println("5. Editar datos del provedor ");
            int opcion = entrada.nextInt();

            PAE pae= new PAE();

            if (opcion == 1) {

                Colegio.Registrar_Col(pae.colegios);

            }
            if (opcion == 2) {

                Proveedor.Registrar_Prov(pae.proveedores);
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
        }
    }
}
