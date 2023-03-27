package declarativo.modelos;

import java.util.Date;

public class Entrega {
    public final Date fecha;
    public final Colegio colegio;

    public Entrega(Colegio colegio) {
        this.fecha = new Date();
        this.colegio = colegio;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "fecha=" + fecha +
                ", colegio.nombre='" + colegio.nombre + '\'' +
                '}';
    }
}
