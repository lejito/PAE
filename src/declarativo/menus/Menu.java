package declarativo.menus;
import java.util.LinkedList;
import java.util.Scanner;
public  abstract class Menu {
    final public Scanner scanner = new Scanner(System.in);

    public boolean confirmarContinuar() {
        int op = obtenerEntradaInt("[!] ¿Desea continuar? Presione 1 para continuar o 0 para salir: ");
        return op > 0;
    }

    public int leerOpcion(int cantidadOpciones) {
        int opcion = 0;
        boolean valorIncorrecto = true;
        while (valorIncorrecto) {
            opcion = obtenerEntradaInt(":");

            if (opcion <= 0 || opcion > cantidadOpciones) {
                System.out.println("Opción ingresada no válida, ingrese nuevamente una opción correcta.");
            }
            else {
                valorIncorrecto = false;
            }
        }
        return opcion;
    }
    public float obtenerEntradaFloat(String text){
        try{
            System.out.println(text);
            float entrada = scanner.nextFloat();
            return entrada;
        }
        catch (Exception e){
            System.out.println("Error el valor ingresado no corresponde a un numerico flotante\nIngrese un valor adecuado nuevamente\n:");
            return obtenerEntradaFloat(text);
        }
    }
    public int obtenerEntradaInt(String text){
        String entradaUsuario = "";
        boolean valorIncorrecto = true;
        while (valorIncorrecto){
            System.out.print("> ");
            System.out.println(text);
            entradaUsuario = scanner.nextLine();
            if (!validarEntradaInt(entradaUsuario)) {
                System.out.println("Valor ingresado debe ser un número entero, ingrese nuevamente un valor correcto.");
            }
            else  {
                valorIncorrecto = false;
            }
        }
        return Integer.parseInt(entradaUsuario);
    }

    private boolean validarEntradaInt(String entrada){
        return entrada.matches("\\d+");
    }

    public String obtenerEntradaTexto(String pregunta){
        System.out.println(pregunta);
        System.out.print("> ");
        return scanner.nextLine();
    }
    public String obtenerEntradaTexto(){
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void verIterable(LinkedList<?> lista){
        if(lista.size() == 0) {
            System.out.println("***Lista vacía***");
        } else {
            lista.forEach(item-> System.out.printf("[%d] %s%n",lista.indexOf(item)+1,item));
        }
    }
    public int selecionarItem(LinkedList<?> lista){
        if( lista.size() == 0){
            System.out.println("***Lista vacía***");
            return -1;
        }
        verIterable(lista);
        int selecion = obtenerEntradaInt("Ingrese numero del elemento que desea selecionar\n: ");
        while (selecion < 0 || selecion > lista.size()-1){
            selecion =  obtenerEntradaInt("Numero ingresado no corresponde a una opcion valida ingrese un valor adecuado\n: ");
        }
        return  selecion;
    }
    public void mostrarOpciones(String titulo,String cabecera, String ...opciones){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(titulo);
        sb.append("\n");
        sb.append(cabecera);
        sb.append("\n");
        int numeroOpcion= 1;

        for(String opcion:opciones){
            sb.append("[%d] %s  \n".formatted(numeroOpcion,opcion));
            numeroOpcion++;
        }
        System.out.println(sb);
    }
}
