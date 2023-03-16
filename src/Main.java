
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Colegio> colegios = new ArrayList<>();
        colegios.add(new Colegio("I.E Jose", 2176, 100));
        colegios.add(new Colegio("I.E Divino", 2135, 500));
        colegios.add(new Colegio("I.E La presentacion", 1456, 450));

        List<Proveedor> proveedores = new ArrayList<>();
        proveedores.add(new Proveedor("Jose", "32424323"));
        proveedores.add(new Proveedor("Paulo", "324243223"));
        proveedores.add(new Proveedor("Dybala", "325444323"));

        while (true) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Ingrese que quieres hacer");
            System.out.println("1. Registar nuevo colegio: ");
            System.out.println("2. Registar proovedor");
            System.out.println("3. Ver estudiantes de genero femenino");
            System.out.println("4. Ver personas de forma imperactiva");
            System.out.println("5. Ver personas de forma declarativa");
            int opcion = entrada.nextInt();

            if (opcion == 1) {

                Colegio.Registrar_Col(colegios);

            }
            if (opcion == 2) {

                Proveedor.Registrar_Prov(proveedores);
            }
            if (opcion == 3) {


            }
            if (opcion == 4) {


            }
            if (opcion == 5) {


            }
        }
    }
}
