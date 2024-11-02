package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	
	private JPanel panelBotones;
	
	public VentanaInicioSesion() {
		setTitle("Ventana Inicio Sesión");
		setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        //layout:
        setLayout(new BorderLayout());
        
        //panel botones:
        panelBotones = new JPanel();
        
        add(panelBotones, BorderLayout.CENTER);
        
        JLabel lblNombreClte = new JLabel("Nombre: ");
        JTextField nombreClte = new JTextField(10);
        
        JLabel lblEdadClte = new JLabel("Edad: ");
        JRadioButton edadMenor7 = new JRadioButton("Menor de 7");
        JRadioButton edadMenor18 = new JRadioButton("Entre 7 y 18");
        JRadioButton edadMenor60 = new JRadioButton("Entre 18 y 60");
        JRadioButton edadMas60 = new JRadioButton("Mayor de 60"); 
        
        JLabel lblCorreoClte = new JLabel("Correo electrónico: ");
        JTextField correoClte = new JTextField(20);
        
        JLabel lblContraClte = new JLabel("Contraseña: ");
        JTextField contrasenyaClte = new JTextField(15);
        
        panelBotones.add(lblNombreClte);
        panelBotones.add(nombreClte);
        
        panelBotones.add(lblEdadClte);
        panelBotones.add(edadMenor7);
        panelBotones.add(edadMenor18);
        panelBotones.add(edadMenor60);
        panelBotones.add(edadMas60);
        
        panelBotones.add(lblCorreoClte);
        panelBotones.add(correoClte);
        
        panelBotones.add(lblContraClte);
        panelBotones.add(contrasenyaClte);
        
        
	}

}
