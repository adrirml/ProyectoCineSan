package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;

public class VentanaInicioSesion extends JFrame {
	
	private JPanel panelBotones;
	JButton siguiente;
	JButton salir;
	private JPanel panelSur;
	private JPanel panelNorte;
	
	
	JLabel etiquetaCabecera;
	public VentanaInicioSesion() {
		setTitle("Ventana Inicio Sesión");
		setSize(400,450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        //layout:
        setLayout(new BorderLayout());
        
        //panel botones:
        panelNorte = new JPanel();
        etiquetaCabecera = new JLabel("POR FAVOR, RELLENE LOS DATOS DE SU CUENTA");
        panelBotones = new JPanel();
        siguiente = new JButton("Siguiente");
        salir = new JButton("Salir");
        panelSur = new JPanel();
        

        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10,10, 10,10));
        panelBotones.setBackground(Color.LIGHT_GRAY);
        add(panelBotones, BorderLayout.CENTER);
        
        
        JPanel panelNombreClte = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblNombre = new JLabel("Nombre: ");
        JTextField nombreClte = new JTextField(10);
        panelBotones.add(lblNombre);
        panelBotones.add(nombreClte);
        
        
        JPanel panelEdad = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblEdadClte = new JLabel("Edad: ");
        JRadioButton edadMenor7 = new JRadioButton("Menor de 7");
        JRadioButton edadMenor18 = new JRadioButton("Entre 7 y 18");
        JRadioButton edadMenor60 = new JRadioButton("Entre 18 y 60");
        JRadioButton edadMas60 = new JRadioButton("Mayor de 60"); 
        panelBotones.add(lblEdadClte);
        panelBotones.add(edadMenor7);
        panelBotones.add(edadMenor18);
        panelBotones.add(edadMenor60);
        panelBotones.add(edadMas60);
        
        JPanel panelCorreo = new JPanel( new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblCorreoClte = new JLabel("Correo electrónico: ");
        JTextField correoClte = new JTextField(20);
        panelBotones.add(lblCorreoClte);
        panelBotones.add(correoClte);
        
        
        JPanel panelContra = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JLabel lblContraClte = new JLabel("Contraseña: ");
        JPasswordField contrasenyaClte = new JPasswordField(15);
        panelBotones.add(lblContraClte);
        panelBotones.add(contrasenyaClte);

        panelNorte.add(etiquetaCabecera);
        panelBotones.add(panelNombreClte);
        panelBotones.add(panelEdad);
        panelBotones.add(panelCorreo);
        panelBotones.add(panelContra);
        panelSur.add(siguiente);
        panelSur.add(salir);
        
		salir.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        this.getContentPane().add(panelNorte,"North");
        this.getContentPane().add(panelBotones,"Center");
        this.getContentPane().add(panelSur,"South");
        
	}

}
