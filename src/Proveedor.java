import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Proveedor {
    public final String nombre;
    public final String telefono;




    public Proveedor(String nombre, String telefono ) {
        this.nombre = nombre;
        this.telefono = telefono;

    }

    //Metodo donde se registra los proveedores
    public static void Registrar_Prov(List<Proveedor> proveedores ) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del provedor: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el telefono del provedor: ");
        String telefono = entrada.nextLine();

        Proveedor new_prov= new Proveedor(nombre,telefono);

        proveedores.add(new_prov);

    }


}
