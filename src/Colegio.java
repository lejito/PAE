import java.util.List;
import java.util.Scanner;

public class Colegio {
    public final String nombre;
    public final Integer dni;

    public final Integer cupos;


    public Colegio(String nombre, Integer dni, Integer cupos) {
        this.nombre = nombre;
        this.dni = dni;
        this.cupos = cupos;
    }
     //Metodo donde se registra los colegios
    public static void Registrar_Col(List<Colegio> colegios) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del colegio: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el dni del colegio: ");
        int dni = entrada.nextInt();
        System.out.println("Ingrese el numero de cupos que desea recibir: ");
        int cupos = entrada.nextInt();

        Colegio new_colegio= new Colegio(nombre,dni,cupos);

        colegios.add(new_colegio);

    }
}

