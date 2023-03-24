package declarativo.menus;

import declarativo.modelos.Colegio;
import declarativo.modelos.Entrega;
import declarativo.modelos.Producto;
import declarativo.modelos.Proveedor;

import java.util.LinkedList;

public class MenuPrincipal extends Menu{
    public MenuPrincipal(LinkedList<Colegio> colegios , LinkedList<Entrega> entregas , LinkedList<Producto> productos , LinkedList<Proveedor> proveedores){
        boolean continuar = true;
        while (continuar){
            mostrarOpciones("MENU DE OPCIONES","MENU PRINCIPAL","Administar colegios","Administar proveedores","Administar productos","Administar entregas");
            int opcion = leerOpcion(4);
            switch (opcion){
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
            }
            continuar = confirmarContinuar();
        }
    }
}
