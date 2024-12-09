package domain;

public class Entrada {
	 private String pelicula;
	 private String horario;
	 private String asiento;
	 private double precio;

	 public Entrada(String pelicula, String horario, String asiento, double precio) {
		  this.pelicula = pelicula;
	      this.horario = horario;
	      this.asiento = asiento;
	      this.precio = precio;
	    }

	    // Getters y setters
	  public String getPelicula() { 
		  return pelicula; 
		  }
	  public void setPelicula(String pelicula) { 
		  this.pelicula = pelicula;
		  }

	  public String getHorario() {
		  return horario;
		  }
	  public void setHorario(String horario) {
		  this.horario = horario; 
		  }

	    public String getAsiento() { 
	    	return asiento;
	    	}
	    public void setAsiento(String asiento) { 
	    	this.asiento = asiento; 
	    	}

	    public double getPrecio() {
	    	return precio; 
	    	}
	    public void setPrecio(double precio) {
	    	this.precio = precio; 
	    	}	
}
