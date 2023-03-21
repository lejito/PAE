import java.util.ArrayList;
import java.util.List;

public class PAE {
    public List<Colegio> colegios;
    public List<Proveedor> proveedores;
    public double presupuesto;
    public double cupos_disponibles;

    public PAE() {
        this.colegios= new ArrayList<>();
        colegios.add(new Colegio("I.E Jose", "2176", "100"));
        colegios.add(new Colegio("I.E Divino", "2135", "500"));
        colegios.add(new Colegio("I.E La presentacion", "1456", "450"));

        ///Lista de proveedores
        this.proveedores= new ArrayList<>();
        proveedores.add(new Proveedor("1213123","Colanta", "32424323"));
        proveedores.add(new Proveedor("1213143","ALpina", "324243223"));
        proveedores.add(new Proveedor("1213212123","Fruber", "325444323"));

        this.presupuesto=50000000;

        this.cupos_disponibles = 10000;

    }

}
