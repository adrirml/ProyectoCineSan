package domain;

import java.util.ArrayList;

public class Reserva {
	
	private String Pelicula;
	private String Horario;
	private ArrayList<String> asientos;
	private String palomitas;
	private String bebidas;
	private Boolean chuches;
	private Boolean alzadores;
	private double precio;
	
	public Reserva(String pelicula, String horario, ArrayList<String> asientos, String palommitas, String bebidas,
			Boolean chuches, Boolean alzadores, double precio) {
		super();
		Pelicula = pelicula;
		Horario = horario;
		this.asientos = asientos;
		this.palomitas = palommitas;
		this.bebidas = bebidas;
		this.chuches = chuches;
		this.alzadores = alzadores;
		this.precio = precio;
	}
	public String getPelicula() {
		return Pelicula;
	}
	public void setPelicula(String pelicula) {
		Pelicula = pelicula;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	public ArrayList<String> getAsientos() {
		return asientos;
	}
	public void setAsientos(ArrayList<String> asientos) {
		this.asientos = asientos;
	}
	public String getPalommitas() {
		return palomitas;
	}
	public void setPalommitas(String palommitas) {
		this.palomitas = palommitas;
	}
	public String getBebidas() {
		return bebidas;
	}
	public void setBebidas(String bebidas) {
		this.bebidas = bebidas;
	}
	public Boolean getChuches() {
		return chuches;
	}
	public void setChuches(Boolean chuches) {
		this.chuches = chuches;
	}
	public Boolean getAlzadores() {
		return alzadores;
	}
	public void setAlzadores(Boolean alzadores) {
		this.alzadores = alzadores;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	 
	
	
	
	
	
	
}
