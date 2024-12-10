package gui;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import domain.Pelicula;

import javax.swing.*;
import java.util.ArrayList;
import java.net.URL;
import domain.Reserva;
import domain.Cliente;

public class VentanaComprarEntradas extends JFrame{

	private Cliente cliente;
	 
	private static final long serialVersionUID = 1L;
	private ArrayList<Pelicula> peliculas;
	public JButton salir;
	public JPanel panelSur;
	public JButton volveratras; 
	
	
	public VentanaComprarEntradas(Cliente cliente) {
		
		this.cliente = cliente; 
	    //Inicializar la lista de peliculas
	    inicializarPeliculas();
	    //Paneles
	    JPanel panelSur = new JPanel();
	    JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JLabel labelPelis = new JLabel("PELICULAS");

	  	JPanel panelbotones = new JPanel(); 
	  	
	  	//Inicializar el boton de salir 
	    JButton salir = new JButton("Salir");
	    
	    JTextField filtroTitulo = new JTextField(15);
	    JTextField filtroAnyo = new JTextField(4);
	    JTextField filtroEdad = new JTextField(3);
	    JButton botonBuscar = new JButton("Buscar");
	    JPanel panelBusqueda = new JPanel();
	    
	    
	    panelBusqueda.setLayout(new FlowLayout());
	    panelBusqueda.add(new JLabel("Titulo:"));
	    panelBusqueda.add(filtroTitulo);
	    panelBusqueda.add(new JLabel("Año:"));
	    panelBusqueda.add(filtroAnyo);
	    panelBusqueda.add(new JLabel("Edad Minima:"));
	    panelBusqueda.add(filtroEdad);
	    panelBusqueda.add(botonBuscar);

	    
	    

		//Inicializar el boton de volver atras y añadirlo al panel sur 
		volveratras = new JButton("Anterior");
		panelSur.add(volveratras); 
		
		//Action listener del boton de volver a la pagina anterior 
		volveratras.addActionListener(e -> {
			VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
			ventanaprincipal.setVisible(true);
			this.dispose(); //se cierra esta ventana
		});
		
		//Accion de cerrar la ventana al volver atras 
		
		
	  	//Confi Layout
		setTitle("Compra de Entradas");
	    setSize(600, 700);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    setLayout(new BorderLayout());
	    panelTitulo.add(labelPelis);
	    add(panelTitulo, BorderLayout.NORTH); 
	    //panel de botones para que salgan en una columna
	  	panelbotones.setLayout(new BoxLayout(panelbotones, BoxLayout.Y_AXIS));
	  	//Asignar las peliculas
	    for (Pelicula pelicula : peliculas) { 
	    	panelbotones.add(crearPanelPelicula(pelicula));
	    }
	    //Panel para desplazarse
	    JScrollPane scrollPanel = new JScrollPane(panelbotones);
	    add(scrollPanel,BorderLayout.CENTER);
	    //Acción Salir
	    panelSur.add(salir);	
	 
		salir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelSur.add(panelBusqueda);
	    botonBuscar.addActionListener(e-> {
	    	String titulo = filtroTitulo.getText().trim();
	    	int anyo = filtroAnyo.getText().isEmpty() ? 0 : Integer.parseInt(filtroAnyo.getText()) ;
	    	int edad_min = filtroEdad.getText().isEmpty() ? 0 : Integer.parseInt(filtroEdad.getText());
	    	
	    	Pelicula encontrada = buscarPelicula(peliculas,titulo,anyo,edad_min,0);
	    	
	    	if (encontrada != null) {
	    		JOptionPane.showMessageDialog(this, "Película encontrada: \n" + encontrada.getTitulo() );
	    	}else {
	    		JOptionPane.showMessageDialog(this, "Película no encontrada");
	    	}
	    	
	    });
		
		//Posición
		this.getContentPane().add(panelSur,"South");
		
		

		
		
				
		
	}
	
	
	private Pelicula buscarPelicula(ArrayList<Pelicula> peliculas, String titulo, int año, int edad_min, int index) {
		if (index >= peliculas.size()){
			return null;
		}
		Pelicula peliculaActual = peliculas.get(index);
		
		
		if (peliculaActual.getTitulo().equalsIgnoreCase(titulo) && (año <= 0 || peliculaActual.getAnyoEstreno() == año) && (edad_min <= 0 || peliculaActual.getEdadRecomendada() <= edad_min)) {
			return peliculaActual;
		}
		return buscarPelicula(peliculas,titulo,año,edad_min, index +1);
	}	
	//Array de Películas
	private void inicializarPeliculas() {
	    peliculas = new ArrayList<>();
	    peliculas.add(new Pelicula("Misión Imposible 3", "J. J. Abrams", 2006, 12, "/images/mision.png"));
	    peliculas.add(new Pelicula("Inception", "Christopher Nolan", 2010, 13, "/images/inception.png"));
	    peliculas.add(new Pelicula("Parasite", "Bong Joon-ho", 2019, 16, "/images/parasite.png"));
	    peliculas.add(new Pelicula("Joker", "Todd Phillips", 2019, 18, "/images/joker.png"));
	    peliculas.add(new Pelicula("The Social Network", "David Fincher", 2010, 12, "/images/tsnetwork.png"));
	    peliculas.add(new Pelicula("Interstellar", "Christopher Nolan", 2014, 12, "/images/interstellar.png"));
	    peliculas.add(new Pelicula("The Grand Budapest Hotel", "Wes Anderson", 2014, 14, "/images/TheBudapestHotel.png"));
	    peliculas.add(new Pelicula("Whiplash", "Damien Chazelle", 2014, 15, "/images/whiplash.png"));
	    peliculas.add(new Pelicula("La La Land", "Damien Chazelle", 2016, 13, "/images/land.png"));
	    peliculas.add(new Pelicula("Mad Max: Fury Road", "George Miller", 2015, 16, "/images/max.png"));
	}
	
	//Un panel para cada pelicula
	private JPanel crearPanelPelicula(Pelicula pelicula) {
		JPanel panelPelicula = new JPanel();
		panelPelicula.setLayout(new BorderLayout());
		panelPelicula.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	    
		//Logo de la Película
		JLabel labelLogo = new JLabel();
		URL url =  VentanaPrincipal.class.getResource(pelicula.getLogoPath());
		if (url != null) {
			ImageIcon icono = new ImageIcon(url);
			Image imagen = icono.getImage();
			Image imagenDimension = imagen.getScaledInstance(150,200, Image.SCALE_SMOOTH);
			ImageIcon iconoDimension = new ImageIcon(imagenDimension);
			labelLogo.setIcon(iconoDimension);
		}
		
		//Infromación de la Película
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		//Titulo
		JLabel labelTitulo = new JLabel(pelicula.getTitulo());
		labelTitulo.setFont(new Font(labelTitulo.getFont().getName(), Font.BOLD, 18));
		//Descripción
		JLabel labelDescripcion = new JLabel(pelicula.getDescription());
        //Mostrar la ventana de selección de horario
        JButton botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(e -> {
			VentanaSeleccionHorario ventanahorario = new VentanaSeleccionHorario(pelicula.getTitulo());
			ventanahorario.setVisible(true);
			//TODO 
			//en vez de añadir una reserva a mano hay que hacer 
			//que sea dependiendo de lo escogido y usuario
            Reserva reserva = new Reserva("pelicula","16.00",null,"1 palomitas","1 bebida",true,false,15.0);
            cliente.agregarReserva(reserva);
			this.dispose();
		});

		panelPelicula.add(labelLogo, BorderLayout.WEST);
		panelInfo.add(botonSeleccionar);
		panelInfo.add(labelTitulo);
		panelInfo.add(labelDescripcion);

		panelPelicula.add(panelInfo, BorderLayout.CENTER);
		
		return panelPelicula;
	
		
		
		
	}
	
	public static void main(String[] args) {
		//TODO 
		Cliente cliente = new Cliente("Nombre","30","email@ejemplo.com" ,"contraseña",null);
		VentanaComprarEntradas ventana = new VentanaComprarEntradas(cliente);
		ventana.setVisible(true);
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

