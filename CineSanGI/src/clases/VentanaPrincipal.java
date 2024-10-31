package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ImageCapabilities;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;



public class VentanaPrincipal extends JFrame{
	
	private JPanel panelLogo;	//logo y titulo
	private JPanel panelBotones;	//boton comprar entradas, iniciar sesion, comprar extras
	
	private JButton botonEntradas;

	public VentanaPrincipal() {
	        setTitle("Gestión de CineSan");
	        setSize(800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //PANEL LOGO:
	        panelLogo.setLayout(new FlowLayout());
	        //añadir imagen...
	        URL url = VentanaPrincipal.class.getResource("images/nombre.png");
	        //ImageIcon icono = new ImageIcon();
	        
	        JLabel lblImagen = new JLabel();
	        //añadir titulo cine:
	        JLabel labelTitulo = new JLabel("BIENVENIDO A CINESAN");
	        labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
	        panelLogo.add(labelTitulo);
	        
	        //inicializamos componentes:
	        botonEntradas = new JButton("Comprar entradas");
	        
	        
	        //layout:
	        setLayout(new BorderLayout());
	        
	        JPanel panelBotones = new JPanel();
	        panelBotones.add(botonEntradas);
	        add(panelBotones, BorderLayout.CENTER);
	        
	        //COMPRAR ENTRADAS:
	        botonEntradas.addActionListener(e ->{
	        	
	        	 VentanaComprarEntradas ventanaCompra = new VentanaComprarEntradas();
		         ventanaCompra.setVisible(true);
	        	
	     
	        });
	        
	        
	        
	        
	        
	 }
}
