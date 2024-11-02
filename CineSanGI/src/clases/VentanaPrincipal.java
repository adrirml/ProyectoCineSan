package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;



public class VentanaPrincipal extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panelTitulo;	//logo y titulo
	private JPanel panelBotones;	//boton comprar entradas, iniciar sesion, comprar extras
	
	private JButton botonEntradas;
	private JButton botonIniciarSesion; 
	private JButton botonExtras; 
	
	
	public VentanaPrincipal() {
	        setTitle("Gestión de CineSan");
	        setSize(1300, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        
	        //layout:
	        setLayout(new BorderLayout());
	        
	        
	        //crear el panel donde va el titulo 
	        panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        
	        
	        //añadir titulo cine:
	        JLabel labelTitulo = new JLabel("BIENVENIDO A CINESAN");
	        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
	        panelTitulo.add(labelTitulo);
	        add(panelTitulo, BorderLayout.NORTH);
	        
	        
	        
	        //añadir imagen
	        JLabel labelImagen = new JLabel();
	        URL url = VentanaPrincipal.class.getResource("/images/logo.png");
	        ImageIcon icono = new ImageIcon(url);
	        labelImagen.setIcon(icono);
	        setLayout(new BorderLayout());
	        add(labelImagen,BorderLayout.WEST);
	        
	        
	        
	        JLabel lblImagen = new JLabel();
	       
	        //crear el panel de los botones donde van a ir los botones
	        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
	        
	        
	        //inicializamos componentes:
	        botonEntradas = new JButton("Comprar entradas");
	        botonIniciarSesion = new JButton("Iniciar Sesion");
	        botonExtras = new JButton("Extras");
	  
	        
	        botonEntradas.setSize(150,40);
	        botonIniciarSesion.setSize(150,40);
	        botonExtras.setSize(150,40);

	        //añadir los botones
	        panelBotones.add(botonEntradas);
	        panelBotones.add(botonIniciarSesion);
	        panelBotones.add(botonExtras);
	        add(panelBotones, BorderLayout.CENTER);
	        
	 
	        
	        //COMPRAR ENTRADAS:
	        botonEntradas.addActionListener(e ->{
	        	
	        	 VentanaComprarEntradas ventanaCompra = new VentanaComprarEntradas();
		         ventanaCompra.setVisible(true);
	        	
	     
	        });
	        
	        //INICIAR SESION
	        botonIniciarSesion.addActionListener(e ->{
	        	
	        	VentanaInicioSesion ventanaInicio = new VentanaInicioSesion();
	        	ventanaInicio.setVisible(true);
	        	
	        	});
	        
	        //EXTRAS
	        
	        botonExtras.addActionListener(e ->{
	        	
	        	VentanaExtras ventanaExtras = new VentanaExtras();
	        	ventanaExtras.setVisible(true);
	        });
	        
	        
	        
	 }
}
