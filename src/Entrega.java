import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Entrega {

    public final LocalDateTime fecha;
    public final String nit_colegio;
    public Entrega(LocalDateTime fecha, String nitColegio) {
        this.fecha = fecha;
        nit_colegio = nitColegio;
    }

    public static void Generar_Entrega(PAE pae){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nit del colegio: ");
        String nit = entrada.nextLine();
        int cupos = Colegio.CuposColegio(pae.colegios,nit);
        if (Producto.VerificarInventario(pae.productos,cupos) == 0){
            System.out.println("No hay producto suficientes para el colegio con el nit: "+nit);
        }
        if (Producto.VerificarInventario(pae.productos,cupos) == 1){
            Producto.DisminuirProductos(pae.productos,cupos);
            pae.entregas.add(new Entrega(LocalDateTime.now(),nit));
        }
    }
    public static void historialEntregas(List<Entrega> entregas){
        for(Entrega entrega: entregas){
            System.out.println(entrega);
        }
    }
    @Override
    public String toString(){
        return "Fecha: "+this.fecha+"\nColegio: "+this.nit_colegio;
    }

}
