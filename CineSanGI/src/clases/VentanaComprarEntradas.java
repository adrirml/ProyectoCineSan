package clases;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Image;
import java.net.URL;

public class VentanaComprarEntradas extends JFrame{

	private static final long serialVersionUID = 1L;
	private ArrayList<Pelicula> peliculas;
	public JButton salir;
	public JPanel panelSur;
	
	public VentanaComprarEntradas() {

	    //Inicializar la lista de peliculas
	    inicializarPeliculas();
	    //Paneles
	    JPanel panelSur = new JPanel();
	    JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JLabel labelPelis = new JLabel("PELICULAS");
	  	JPanel panelbotones = new JPanel();
	    JButton salir = new JButton("Salir");
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
		
		//Posición
		this.getContentPane().add(panelSur,"South");
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
			VentanaSeleccionarHorario2 ventanahorario = new VentanaSeleccionarHorario2();
			ventanahorario.setVisible(true);
		});
        
        //JButton botonSeleccionar = new JButton("Seleccionar");
		//botonSeleccionar.addActionListener(e -> {
			//VentanaSeleccionHorario ventanahorario = new VentanaSeleccionHorario(pelicula.getTitulo());
			//ventanahorario.setVisible(true);
		//});

		panelPelicula.add(labelLogo, BorderLayout.WEST);
		panelInfo.add(botonSeleccionar);
		panelInfo.add(labelTitulo);
		panelInfo.add(labelDescripcion);

		panelPelicula.add(panelInfo, BorderLayout.CENTER);
		
		return panelPelicula;
	}
	
	public static void main(String[] args) {
		VentanaComprarEntradas ventana = new VentanaComprarEntradas();
		ventana.setVisible(true);
	}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

