package declarativo.modelos;

public class Producto {
    public final String nombre;
    public float precio;
    public int cantidad;
    public Proveedor proveedor;

    public Producto(String nombre, float precio, int cantidad, Proveedor proveedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=$" + precio +
                ", cantidad=" + cantidad +
                ", proveedor.nombre='" + proveedor.nombre + '\'' +
                '}';
    }
}
