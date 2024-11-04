package clases;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class VentanaComprarEntradas extends JFrame{

	private static final long serialVersionUID = 1L;
	private ArrayList<Pelicula> peliculas;
	public JButton salir;
	public JPanel panelSur;
	public JButton volveratras; 
	
	public VentanaComprarEntradas() {

	    // Inicializar la lista de peliculas
	    inicializarPeliculas();

	    //Paneles
	    JPanel panelSur = new JPanel();
	    JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    JLabel labelPelis = new JLabel("PELICULAS");
	  	JPanel panelbotones = new JPanel(); 
	  	
	  	//Inicializar el boton de salir 
	    JButton salir = new JButton("Salir");
	    

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
		
        Map<Integer, List<Integer>> horariosPorDia = new HashMap<>();
        Random random = new Random();
        int totalDias = 30; 
        int diasDisponibles = 10;
        int horaMinima = 17; 
        int horaMaxima = 23;

        // Generar 10 días aleatorios
        Set<Integer> diasAleatorios = new HashSet<>();
        while (diasAleatorios.size() < diasDisponibles) {
            int diaAleatorio = random.nextInt(totalDias) + 1; // Genera entre 1 y 30
            diasAleatorios.add(diaAleatorio);
        }

        //horarios aleatorios para cada día
        for (int dia : diasAleatorios) {
            int cantidadHoras = random.nextInt(4) + 2; // Entre 2 y 6 horarios por día
            Set<Integer> horasDia = new HashSet<>();

            // horas unicas para cada día
            while (horasDia.size() < cantidadHoras) {
                int horaAleatoria = random.nextInt(horaMaxima - horaMinima + 1) + horaMinima;
                horasDia.add(horaAleatoria);
            }
            horariosPorDia.put(dia, new ArrayList<>(horasDia));
        }
		//Seleccionar -> Seleccionar la Hora en un nuevo Panel(Sí se pulsa)
        HorarioPelícula horarioPelicula = new HorarioPelícula(pelicula, horariosPorDia);

         //Mostrar la ventana de selección de horario
        JButton botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(e -> {
			VentanaSeleccionarHorario2 ventanahorario = new VentanaSeleccionarHorario2(horarioPelicula);
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


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

