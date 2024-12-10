package domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String Nombre;
	private String Edad;
	private String Correoelectronico;
	private String Contraseña;
	private List <Reserva> reservas;
	
	public Cliente(String nombre, String edad, String correoelectronico, String contraseña,
			List<Reserva> reservas) {
		super();
		Nombre = nombre;
		Edad = edad;
		Correoelectronico = correoelectronico;
		Contraseña = contraseña;
		this.reservas = new ArrayList<>();
	}
	
	public Cliente(String nombre, String edadnum, String correoelectronico, String contraseña) {
		Nombre = nombre;
		Edad = edadnum;
		Correoelectronico = correoelectronico;
		Contraseña = contraseña;
	}
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEdad() {
		return Edad;
	}

	public void setEdad(String edad) {
		Edad = edad;
	}

	public String getCorreoelectronico() {
		return Correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		Correoelectronico = correoelectronico;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	//metodo para agregar reservas a la lista de reservas 
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
}
