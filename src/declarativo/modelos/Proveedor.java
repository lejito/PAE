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
    public  String toString(){
        return "Nombre proveedor: %s\nId: %s\nTelefono: %s\nEstado: %s".formatted(nombre,id,telefono,estado);
    }
}
