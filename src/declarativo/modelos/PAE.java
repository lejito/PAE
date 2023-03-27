package declarativo.modelos;

import java.util.LinkedList;

public class PAE {
    public LinkedList<Colegio> colegios = new LinkedList<>();
    public LinkedList<Proveedor> proveedores = new LinkedList<>();
    public LinkedList<Producto> productos = new LinkedList<>();
    public LinkedList<Entrega> entregas = new LinkedList<>();
    public float presupuesto = 0;

    public void agregarColegio(Colegio colegio) { colegios.add(colegio); }
    public void eliminarColegio(int index) { colegios.remove(index); }
    public void agregarProveedor(Proveedor proveedor) { proveedores.add(proveedor); }
    public void eliminarProveedor(int index) { proveedores.remove(index); }
    public void agregarProducto(Producto producto) { productos.add(producto); }
    public void eliminarProducto(int index) { productos.remove(index); }
    public void agregarEntrega(Entrega entrega) { entregas.add(entrega); }
    public void eliminarEntrega(int index) { entregas.remove(index); }
    public void aumentarPresupuesto(float monto) { presupuesto += monto; }
    public void reducirPresupuesto(float monto) { presupuesto -= monto; }
}