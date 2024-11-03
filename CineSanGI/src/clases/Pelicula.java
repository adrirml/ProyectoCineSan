package clases;

public class Pelicula {
	
	private String titulo;
	private String director;
	private int anyoEstreno;
	private int edadRecomendada;
	private String logoPath;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getAnyoEstreno() {
		return anyoEstreno;
	}
	public void setAnyoEstreno(int anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}
	public int getEdadRecomendada() {
		return edadRecomendada;
	}
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	public String getLogoPath( ) {
		return logoPath;
	}
	
	public void setLogoPath( String logoPath) {
		this.logoPath = logoPath;
	}
	
	public String getDescription() {
		return String.format("%s (%d)\nDirigida por: %s\nEdad Recomendada: %d+",
                titulo, anyoEstreno, director, edadRecomendada);
	}
	public Pelicula(String titulo, String director, int anyoEstreno, int edadRecomendada,String logoPath) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.anyoEstreno = anyoEstreno;
		this.edadRecomendada = edadRecomendada;
		this.logoPath = logoPath;
	}

	

}
