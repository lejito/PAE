package declarativo.modelos;

public class Colegio {
    public final String nit;
    public final String nombre;
    public final int cupos;
    public EstadoColegio estado;

    public Colegio(String nombre, String nit, int cupos) {
        this.nombre = nombre;
        this.nit = nit;
        this.cupos = cupos;
        this.estado = EstadoColegio.PENDIENTE;
    }

    @Override
    public String toString() {
        return "Colegio{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cupos=" + cupos +
                ", estado=" + estado +
                '}';
    }
}
