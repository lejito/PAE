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
        LinkedList<Entrega> entregas = new LinkedList<>();
        LinkedList<Producto> productos = new LinkedList<>();
        LinkedList<Proveedor> proveedores = new LinkedList<>();
        new MenuPrincipal(colegios,entregas,productos,proveedores);
    }
}

