package declarativo;

import declarativo.menus.MenuPrincipal;
import declarativo.modelos.Colegio;
import declarativo.modelos.Entrega;
import declarativo.modelos.Producto;
import declarativo.modelos.Proveedor;

import java.util.LinkedList;


public class Principal {
    public static void main(String[] args) {
        LinkedList<Colegio> colegios = new LinkedList<>();
        colegios.add(new Colegio("I.E Jose", "2176", 2));
        colegios.add(new Colegio("I.E Divino", "2135", 50));
        colegios.add(new Colegio("I.E La presentacion", "1456", 40));
        LinkedList<Entrega> entregas = new LinkedList<>();
        LinkedList<Proveedor> proveedores = new LinkedList<>();
        proveedores.add(new Proveedor("1213123","Colanta", "32424323"));
        proveedores.add(new Proveedor("1213143","ALpina", "324243223"));
        proveedores.add(new Proveedor("1213212123","Fruber", "325444323"));
        LinkedList<Producto> productos = new LinkedList<>();
        float presupuesto = 50000000;
        new MenuPrincipal(colegios,entregas,productos,proveedores,presupuesto);
    }
}

