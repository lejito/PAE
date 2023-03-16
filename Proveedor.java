import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Proveedor {
    public final String id;
    public final String nombre;
    public final String telefono;
    public final Estado_prov estado;




    public Proveedor(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = Estado_prov.Atrasado;
    }

    //Metodo donde se registra los proveedores
    public static void Registrar_Prov(List<Proveedor> proveedores ) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id del provedor: ");
        String id = entrada.nextLine();
        System.out.println("Ingrese nombre del provedor: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el telefono del provedor: ");
        String telefono = entrada.nextLine();

        Proveedor new_prov= new Proveedor(id,nombre,telefono);
        proveedores.add(new_prov);

    }
    public static void Ver_Informacion_Prov(List<Proveedor> proveedores){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el id del proveedor: ");
        String nit = entrada.nextLine();
        for (Proveedor nt: proveedores){
            if (nit.equals(nt.id)){
                System.out.println("Los datos del proveedor son: ");
                System.out.println("id: " + nt.id);
                System.out.println("nombre: " + nt.nombre);
                System.out.println("telefono: " + nt.telefono);
                System.out.println("Estado: " + nt.estado);
            }
        }
    }

    enum Estado_prov{
        Entregado, Atrasado
    }

}

