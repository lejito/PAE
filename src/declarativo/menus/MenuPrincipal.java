package declarativo.menus;

import declarativo.modelos.Colegio;
import declarativo.modelos.Entrega;
import declarativo.modelos.Producto;
import declarativo.modelos.Proveedor;

import java.util.LinkedList;

public class MenuPrincipal extends Menu{
    float presupuestoPAE ;
    public MenuPrincipal(LinkedList<Colegio> colegios , LinkedList<Entrega> entregas , LinkedList<Producto> productos , LinkedList<Proveedor> proveedores,float presupuesto){
        boolean continuar = true;
        presupuestoPAE = presupuesto;
        while (continuar){
            mostrarOpciones("MENU DE OPCIONES","MENU PRINCIPAL","Administar colegios","Administar proveedores","Administar productos","Administar entregas","Agregar dinero al presupuesto","Ver presupuesto");
            int opcion = leerOpcion(6);
            switch (opcion){
                case 1 -> {}
                case 2 -> {}
                case 3 -> {MenuProductos menuProductos = new MenuProductos(productos,proveedores,presupuestoPAE);}
                case 4 -> {MenuEntrega menuEntrega = new MenuEntrega(productos,colegios,entregas,presupuestoPAE);}
                case 5-> {
                    presupuestoPAE += obtenerEntradaFloat("Ingrese la cantidad que desea agregar al presupuesto\n: ");
                }
                case 6 -> {
                    System.out.printf("El presupuesto actual es: %f $%n", presupuestoPAE);
                }
            }
            continuar = confirmarContinuar();
        }
    }
}
