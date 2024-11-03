package clases;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.ArrayList;


public class VentanaComprarEntradas extends JFrame{

	private static final long serialVersionUID = 1L;
	private ArrayList<Pelicula> peliculas;
	JButton salir;
	JPanel panelSur;
	public VentanaComprarEntradas() {
		setTitle("Compra de Entradas");
	    setSize(600, 700);
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    //layout:
	    setLayout(new BorderLayout());

	    inicializarPeliculas();
	    //Titulo de peliculas:
	    JPanel panelSur = new JPanel();
	    JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JLabel labelPelis = new JLabel("PELICULAS");
	    panelTitulo.add(labelPelis);
	    add(panelTitulo, BorderLayout.NORTH); 
	    JButton salir = new JButton("Salir");
	    

	  
	    //panel de botones para que salgan en columna 
	  	JPanel panelbotones = new JPanel(); 
	  	panelbotones.setLayout(new BoxLayout(panelbotones, BoxLayout.Y_AXIS));
	
	    for (Pelicula pelicula : peliculas) { 
	    	panelbotones.add(crearPanelPelicula(pelicula));
	    }
	    JScrollPane scrollPanel = new JScrollPane(panelbotones);
	    add(scrollPanel,BorderLayout.CENTER);
	    
	    panelSur.add(salir);
	  	//Inicializar los botones 
		
		salir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		

		this.getContentPane().add(panelSur,"South");
	}
	private void inicializarPeliculas() {
	    peliculas = new ArrayList<>();
	    peliculas.add(new Pelicula("El Viaje Imposible", "Sofia Mendoza", 2022, 12, "/images/el_viaje_imposible.png"));
	    peliculas.add(new Pelicula("Sombras de la Ciudad", "Carlos Duarte", 2021, 16, "/images/sombras_de_la_ciudad.png"));
	    peliculas.add(new Pelicula("Horizonte de Fuego", "Ana Torres", 2020, 18, "/images/horizonte_de_fuego.png"));
	    peliculas.add(new Pelicula("Ecos del Pasado", "Miguel Vargas", 2019, 13, "/images/ecos_del_pasado.png"));
	    peliculas.add(new Pelicula("Luz en la Oscuridad", "Laura Moreno", 2023, 15, "/images/luz_en_la_oscuridad.png"));
	    peliculas.add(new Pelicula("Misión al Desierto", "Daniel Suarez", 2022, 16, "/images/mision_al_desierto.png"));
	    peliculas.add(new Pelicula("La Última Frontera", "Isabel Ramírez", 2021, 18, "/images/la_ultima_frontera.png"));
	    peliculas.add(new Pelicula("Noche Eterna", "Jorge Beltrán", 2020, 12, "/images/noche_eterna.png"));
	    peliculas.add(new Pelicula("Tiempo de Cambios", "Carmen Ortega", 2023, 14, "/images/tiepocambios.png"));
	    peliculas.add(new Pelicula("Destino Perdido", "Ricardo Pérez", 2022, 17, "/images/destino_perdido.png"));
	}

	private JPanel crearPanelPelicula(Pelicula pelicula) {
		JPanel panelPelicula = new JPanel();
		panelPelicula.setLayout(new BorderLayout());
		panelPelicula.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	    
		
		//Logo
		JLabel labelLogo = new JLabel();
		labelLogo.setIcon(new ImageIcon(pelicula.getLogoPath()));
		panelPelicula.add(labelLogo, BorderLayout.WEST);
		
		//Informacion
		
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
		
		JLabel labelTitulo = new JLabel(pelicula.getTitulo());
		panelInfo.add(labelTitulo);
		
		JLabel labelDescripcion = new JLabel(pelicula.getDescription());
		panelInfo.add(labelDescripcion);
		
		JButton botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(e -> {
			VentanaSeleccionHorario ventanahorario = new VentanaSeleccionHorario(pelicula.getTitulo());
			ventanahorario.setVisible(true);
		});
		panelInfo.add(botonSeleccionar);
		panelPelicula.add(panelInfo, BorderLayout.CENTER);
		
		return panelPelicula;
	}
	
	public static void main(String[] args) {
		VentanaComprarEntradas ventana = new VentanaComprarEntradas();
		ventana.setVisible(true);
	}
		
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

