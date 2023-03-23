import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PAE {


    public List<Colegio> colegios;
    public List<Proveedor> proveedores;
    public List<Producto> productos;
    public List<Entrega> entregas;
    public static double presupuesto;

    public PAE() {
        this.colegios= new ArrayList<>();
        colegios.add(new Colegio("I.E Jose", "2176", 2));
        colegios.add(new Colegio("I.E Divino", "2135", 50));
        colegios.add(new Colegio("I.E La presentacion", "1456", 40));

        ///Lista de proveedores
        this.proveedores= new ArrayList<>();
        proveedores.add(new Proveedor("1213123","Colanta", "32424323"));
        proveedores.add(new Proveedor("1213143","ALpina", "324243223"));
        proveedores.add(new Proveedor("1213212123","Fruber", "325444323"));

        this.productos = new ArrayList<>();
        productos.add(new Producto("Pan",2300,11,"1213123"));

        this.entregas= new ArrayList<>();

        this.presupuesto=50000000;
    }

    public void incrementarPresupuesto(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el valor del incremento en el presupuesto: ");
        double incremento = entrada.nextDouble();
        presupuesto = presupuesto + incremento;
    }

}
