import java.util.List;
import java.util.Scanner;

public class Colegio {
    public final String nit;
    public String nombre;
    public String cupos;
    public Estado_col estado;


    public Colegio(String nombre, String nit, String cupos) {
        this.nombre = nombre;
        this.nit = nit;
        this.cupos = cupos;
        this.estado = Estado_col.Recibidont;
    }

    //Metodo donde se registra los colegios
    public static double Registrar_Col(List<Colegio> colegios, double cuposs) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese nombre del colegio: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el nit del colegio: ");
        String nit = entrada.nextLine();
        System.out.println("Ingrese el numero de cupos que desea recibir: ");
        String cupos = entrada.nextLine();
        cuposs = cuposs - Integer.parseInt(cupos);

        Colegio new_colegio = new Colegio(nombre, nit, cupos);
        colegios.add(new_colegio);

        return cuposs;
    }

    public static void Ver_Informacion_Col(List<Colegio> colegios) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nit del colegio: ");
        String nit = entrada.nextLine();
        for (Colegio nt : colegios) {
            if ((nt.nit.equals(nit))) {
                System.out.println("Los datos del colegio son: ");
                System.out.println("nit: " + nt.nit);
                System.out.println("nombre: " + nt.nombre);
                System.out.println("cupos: " + nt.cupos);
                System.out.println("Estado: " + nt.estado);
            }
        }
    }

    public static double Editar_Col(List<Colegio> colegios, double cuposs) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nit del colegio: ");
        String nitt = entrada.nextLine();
        int cont = 0;
        for (Colegio i : colegios) {
            if (i.nit.equals(nitt)) {
                cont++;
                System.out.println("Ingrese el nuevo nombre: ");
                String n_nombre = entrada.nextLine();
                i.nombre = n_nombre;
                System.out.println("Ingrese la nueva cantidad de cupos: ");
                String n_cupos = entrada.nextLine();
                cuposs = cuposs + Integer.parseInt(i.cupos) - Integer.parseInt(n_cupos) ;
                i.cupos = n_cupos;

            }
        }

        if (cont == 0) {
            System.out.println("No existe un colegio con este nit: " + nitt);
        } else {
            System.out.println("Información actualizada correctamente");

        }
        return cuposs;
    }

    public static double Eliminar_Col(List<Colegio> colegios, double cuposs) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nit del colegio que desea eliminar: ");
        String nit = entrada.nextLine();
        int cont = 0;

        for (Colegio c : colegios) {
            if (c.nit.equals(nit)) {
                cont++;
                cuposs = cuposs + Integer.parseInt(c.cupos);
                System.out.println(cuposs);
                colegios.remove(c);
                break;

            }
        }

        if (cont == 0) {

            System.out.println("No existe un colegio con este nit: " + nit);

        } else {

            System.out.println("Colegio eliminado correctamente");

        }
        return cuposs;
    }

    enum Estado_col {
        Recibido, Recibidont
    }

}
