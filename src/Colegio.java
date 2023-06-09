import java.util.List;
import java.util.Scanner;

public class Colegio {
    public final String nit;
    public final String nombre;
    public final int cupos;
    public final Estado_col estado;


    public Colegio(String nombre, String nit, int cupos) {
        this.nombre = nombre;
        this.nit = nit;
        this.cupos = cupos;
        this.estado= Estado_col.Recibidont;
    }
     //Metodo donde se registra los colegios
    public static void Registrar_Col(List<Colegio> colegios) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del colegio: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el nit del colegio: ");
        String nit = entrada.nextLine();
        System.out.println("Ingrese el numero de cupos que desea recibir: ");
        int cupos = entrada.nextInt();

        Colegio new_colegio= new Colegio(nombre,nit,cupos);

        colegios.add(new_colegio);
    }

    public static void Ver_Informacion_Col(List<Colegio> colegios){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nit del colegio: ");
        String nit = entrada.nextLine();
        for (Colegio nt: colegios){
            if ((nt.nit.equals(nit))){
                System.out.println("Los datos del colegio son: ");
                System.out.println("nit: " + nt.nit);
                System.out.println("nombre: " + nt.nombre);
                System.out.println("cupos: " + nt.cupos);
                System.out.println("Estado: " + nt.estado);
            }
        }
    }
    public static int CuposColegio(List<Colegio> colegios,String nit){
        int cupos = 0;
        for (Colegio nt: colegios){
            if ((nt.nit.equals(nit))){
                cupos = nt.cupos;
            }
        }return cupos;
    }
    enum Estado_col{
        Recibido, Recibidont
    }


}
