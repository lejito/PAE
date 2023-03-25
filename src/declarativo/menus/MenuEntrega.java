package declarativo.menus;

import declarativo.modelos.Colegio;
import declarativo.modelos.Entrega;
import declarativo.modelos.Producto;

import java.util.LinkedList;

public class MenuEntrega extends Menu{
    public MenuEntrega(LinkedList<Producto> productos, LinkedList<Colegio> colegios, LinkedList<Entrega> entregas,float presupuesto){
        boolean continuar = true;
        while (continuar){
            mostrarOpciones("MENU PRINCIPAL","MENU DE ENTREGAS","Ver historial de entregas","Realizar entrega a colegio");
            int opcion = leerOpcion(2);
            switch (opcion){
                case 1 ->{verIterable(entregas);}
                case 2 ->{
                    System.out.println("Selecione colegio al cual realizar la entrega");
                    int selecion = selecionarItem(entregas);
                    if (selecion == -1){
                        System.out.println("No hay colegios disponibles para realizar una entrega.");
                        break;
                    }
                    Colegio colegioSelecionado = colegios.get(selecion);
                    boolean entregaPosible = verificarInventarioDisponible(productos,colegioSelecionado.cupos);
                    if (!entregaPosible){
                        System.out.printf("No hay producto suficientes para el colegio %s",colegioSelecionado);
                        break;
                    }
                    productos.forEach(producto -> producto.cantidad-=colegioSelecionado.cupos);
                    entregas.add(new Entrega(colegioSelecionado));

                }
            }
            continuar = confirmarContinuar();
        }
    }
    private boolean verificarInventarioDisponible(LinkedList<Producto> productos,int cantidad){
        return productos.stream().anyMatch(producto -> producto.cantidad < cantidad);
    }
}
