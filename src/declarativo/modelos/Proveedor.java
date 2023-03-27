package declarativo.modelos;

public class Proveedor {
    public final String id;
    public final String nombre;
    public  String telefono;
    public final EstadoProveedor estado;

    public Proveedor(String id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = EstadoProveedor.ATRASADO;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", estado=" + estado +
                '}';
    }
}
