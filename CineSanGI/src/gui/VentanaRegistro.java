package gui;

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

public class VentanaRegistro extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//atributos
	private JPanel panelBotones;
	private JButton siguiente;
	private JButton salir;
	private JButton anterior;
	private JPanel panelSur;
	private JPanel panelNorte;
	private JLabel etiquetaCabecera;
	
	private JTextField nombreClte;
	private String edad;
	private JRadioButton edadMenor7;
	private JRadioButton edadMenor18;
	private JRadioButton edadMenor60;
	private JRadioButton edadMas60;
	private JTextField correoClte;
	
	// constructor
	public VentanaRegistro() {
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
        anterior = new JButton("Anterior");
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
        nombreClte = new JTextField(10);
        
        // Panel para la edad
        JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblEdadClte = new JLabel("Edad: ");
        edadMenor7 = new JRadioButton("Menor de 7");
        edadMenor18 = new JRadioButton("Entre 7 y 18");
        edadMenor60 = new JRadioButton("Entre 18 y 60");
        edadMas60 = new JRadioButton("Mayor de 60");
        
        // Meter los Radio Button en un ButtonGroup para que solo puedas seleccionar una opcion
        ButtonGroup grupoEdad = new ButtonGroup();
        grupoEdad.add(edadMenor7);
        grupoEdad.add(edadMenor18);
        grupoEdad.add(edadMenor60);
        grupoEdad.add(edadMas60);

        // Panel para el correo
        JPanel panelCorreo = new JPanel( new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblCorreoClte = new JLabel("Correo electrónico: ");
        correoClte = new JTextField(20);
        
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
        panelSur.add(anterior);
        panelSur.add(siguiente);
        panelSur.add(salir);
        
        
        // Acción del botón salir
		salir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		//Botón siguiente:
		siguiente.addActionListener(e -> { 
		mostrarMensaje();
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		this.dispose();
		
		});
		
		//Posición
        this.getContentPane().add(panelNorte,"North");
        this.getContentPane().add(panelBotones,"Center");
        this.getContentPane().add(panelSur,"South");
        
        
        //Botón anterior:
        anterior.addActionListener(e -> {
        	VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
			ventanaprincipal.setVisible(true);
			this.dispose(); //se cierra esta ventana
		});
        
        
        
      
	}
	//mensaje comprobar datos introducidos:
	 private void mostrarMensaje() {
		 
  	   String nombre = nombreClte.getText();
  	   if(nombreClte.getText().isEmpty()) {
  		   nombre = "Por favor introduzca su nombre";
  	   }
  	   
  	   String edad = "Por favor seleccione su rango de edad";
  	   if (edadMenor7.isSelected()) {
  		   edad = "Menor de 7 años";
  	   }else if(edadMenor18.isSelected()) {
  		   edad = "Entre 7 y 18 años";
  	   }else if(edadMenor60.isSelected()) {
  		   edad = "Entre 18 y 60 años";
  	   }else if(edadMas60.isSelected()) {
  		   edad = "Más de 60 años";
  	   }
  	   
  	   String correo = correoClte.getText();
  	   if(correoClte.getText().isEmpty()) {
  		   correo = "Por favor introduzca su correo";
  	   }
  	   
  	   String mensaje = nombre + "\n" + edad + "\n" + correo;
  	   JOptionPane.showMessageDialog(this, mensaje, "Compruebe sus datos", JOptionPane.INFORMATION_MESSAGE);
     }
	 
}
