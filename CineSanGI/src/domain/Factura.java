package domain;

import java.time.LocalDate;
import java.util.Date;

public class Factura {
	
	private String nombreCliente;
	private LocalDate fecha;
	
	
	
	public Factura(String nombreCliente, LocalDate fecha) {
		super();
		this.nombreCliente = nombreCliente;
		this.fecha = fecha;
	}



	public String getNombre() {
		return nombreCliente;
	}



	public void setNombre(String nombre) {
		this.nombreCliente = nombre;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nombre: "+ nombreCliente + "; fecha: " + fecha;
	}
	
	

}
