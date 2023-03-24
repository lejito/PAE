package declarativo.modelos;

import java.time.LocalDateTime;

public class Entrega {
    public final LocalDateTime fecha;
    public final Colegio colegio;
    public Entrega(LocalDateTime fecha, Colegio colegio) {
        this.fecha = fecha;
        this.colegio = colegio;
    }
    @Override
    public String toString(){
        return "Fecha: %s\nColegio: %s".formatted(fecha.toString(),colegio);
    }
}
