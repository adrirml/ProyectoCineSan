package clases;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public class HorarioPelícula {
	private Pelicula pelicula;
	private Map<Integer, List<Integer>> horariosPorDia;
	
	public HorarioPelícula(Pelicula pelicula, Map<Integer, List<Integer>> horariosPorDia) {
		this.pelicula = pelicula;
		this.horariosPorDia = horariosPorDia;
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	
	public List<Integer> getHorariosPorDia(int dia) {
		return horariosPorDia.getOrDefault(dia, Collections.emptyList());
	}
    public Map<Integer, List<Integer>> getHorariosPorDia() {
        return horariosPorDia;
    }
}
