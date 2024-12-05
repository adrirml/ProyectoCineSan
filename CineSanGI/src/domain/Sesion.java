package domain;

import java.util.HashMap;
import java.util.Map;

public class Sesion {
	
    private String dia;
    private String hora;
    private Map<Integer, Boolean> asientos;
    private String titulopelicula;

    public Sesion(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
        this.asientos = new HashMap<>();
        for (int i = 1; i <= 110; i++) {
            asientos.put(i, false);
        }
    }

    //comprueba si asiento ocupado o no 
    public boolean isAsientoOcupado(int num) {
        return asientos.get(num);
    }

    //reserva el asiento , pone el asiento como ocupado
    public void reservarAsiento(int num) {
        asientos.put(num, true);
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }
}
