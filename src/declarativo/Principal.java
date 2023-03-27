package declarativo;

import declarativo.menus.MenuPrincipal;
import declarativo.modelos.PAE;
import declarativo.modelos.Colegio;
import declarativo.modelos.Proveedor;
import declarativo.modelos.Producto;
import declarativo.modelos.Entrega;

public class Principal {
    public static void main(String[] args) {
        PAE pae = new PAE();
        pae.agregarColegio(new Colegio("IE Jose", "10", 2));
        pae.agregarColegio(new Colegio("IE Divino Niño", "20", 50));
        pae.agregarColegio(new Colegio("IE La Presentación", "30", 40));
        pae.agregarProveedor(new Proveedor("1", "Colanta", "32424323"));
        pae.agregarProveedor(new Proveedor("2", "Alpina", "324243223"));
        pae.agregarProveedor(new Proveedor("3", "Fruber", "325444323"));
        pae.aumentarPresupuesto(50000000);
        new MenuPrincipal(pae);
    }
}

