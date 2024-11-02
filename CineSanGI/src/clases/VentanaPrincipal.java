package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
	        setSize(900, 500);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
	        
	        
	        //crear el panel donde va el titulo y la imagen 
	        panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        
	        
	        
	        //cargar la imagen
	        JLabel labelImagen = new JLabel();
	        URL url = VentanaPrincipal.class.getResource("/images/logo.png");
	        ImageIcon icono = new ImageIcon(url);
	        
	        //cambiar el tamaño de la imagen 
	        Image imagen = icono.getImage();
	        Image imagenredimensionada = imagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	        ImageIcon iconoredimensionado = new ImageIcon(imagenredimensionada);
	        labelImagen.setIcon(iconoredimensionado);
	        
	        //añadir la imagen al panel
	        panelTitulo.add(labelImagen);
	    
	        //crear titulo cine:
	        JLabel labelTitulo = new JLabel("BIENVENIDO A CINESAN");
	        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
	        
	        //añadir el titulo al panel
	        panelTitulo.add(labelTitulo);
	        
	        
	        //añadir el panel 
	        add(panelTitulo, BorderLayout.NORTH);
	        
	        
	        
	        
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
