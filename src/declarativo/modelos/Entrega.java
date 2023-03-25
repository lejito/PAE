package declarativo.modelos;

import java.time.LocalDateTime;
import java.util.Date;

public class Entrega {
    public final Date fecha;
    public final Colegio colegio;
    public Entrega( Colegio colegio) {
        this.fecha = new Date();
        this.colegio = colegio;
    }
    @Override
    public String toString(){
        return "Fecha: %s\nColegio: %s".formatted(fecha.toString(),colegio);
    }
}
