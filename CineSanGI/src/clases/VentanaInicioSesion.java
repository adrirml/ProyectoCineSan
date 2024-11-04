package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class VentanaInicioSesion extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//atributos
	private JPanel panelBotones;
	private JButton siguiente;
	private JButton salir;
	private JPanel panelSur;
	private JPanel panelNorte;
	private JLabel etiquetaCabecera;
	
	// constructor
	public VentanaInicioSesion() {
        // Configuración de la ventana
		setTitle("Ventana Inicio Sesión");
		setSize(400,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout());
        // Creación de los paneles
        panelNorte = new JPanel();
        panelBotones = new JPanel();
        panelSur = new JPanel();
        // Inicialización de componentes
        etiquetaCabecera = new JLabel("POR FAVOR, RELLENE LOS DATOS DE SU CUENTA");
        siguiente = new JButton("Siguiente");
        salir = new JButton("Salir");
        // Configuración del panel de botones
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10,10, 10,10));
        panelBotones.setBackground(Color.LIGHT_GRAY);
        add(panelBotones, BorderLayout.CENTER);
        // Panel para el nombre
        JPanel panelNombreClte = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblNombre = new JLabel("Nombre: ");
        JTextField nombreClte = new JTextField(10);
        // Panel para la edad
        JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblEdadClte = new JLabel("Edad: ");
        JRadioButton edadMenor7 = new JRadioButton("Menor de 7");
        JRadioButton edadMenor18 = new JRadioButton("Entre 7 y 18");
        JRadioButton edadMenor60 = new JRadioButton("Entre 18 y 60");
        JRadioButton edadMas60 = new JRadioButton("Mayor de 60"); 
        // Panel para el correo
        JPanel panelCorreo = new JPanel( new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblCorreoClte = new JLabel("Correo electrónico: ");
        JTextField correoClte = new JTextField(20);
        // Panel para la contraseña
        JPanel panelContra = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblContra = new JLabel("Contraseña: ");
        JPasswordField contrasenya = new JPasswordField(15);
        //Añadir paneles de entrada de datos al panel de botones
        panelBotones.add(panelNombreClte);
        panelBotones.add(panelEdad);
        panelBotones.add(panelCorreo);
        panelBotones.add(panelContra);
        // Añadir etiqueta de cabecera al panel norte
        panelNorte.add(etiquetaCabecera);
        //Añadir componentes de entrada de datos al panel de botones
        panelBotones.add(lblNombre);
        panelBotones.add(nombreClte);
        panelBotones.add(lblEdadClte);
        panelBotones.add(edadMenor7);
        panelBotones.add(edadMenor18);
        panelBotones.add(edadMenor60);
        panelBotones.add(edadMas60);
        panelBotones.add(lblCorreoClte);
        panelBotones.add(correoClte);
        panelBotones.add(lblContra);
        panelBotones.add(contrasenya);
        panelBotones.add(panelNombreClte);
        panelBotones.add(panelEdad);
        panelBotones.add(panelCorreo);
        panelBotones.add(panelContra);
        // Añadir botones de acción al panel sur
        panelSur.add(siguiente);
        panelSur.add(salir);
        // Acción del botón salir
		salir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//Posición
        this.getContentPane().add(panelNorte,"North");
        this.getContentPane().add(panelBotones,"Center");
        this.getContentPane().add(panelSur,"South");
        
	}

}
