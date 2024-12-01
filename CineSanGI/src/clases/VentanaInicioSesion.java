package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicioSesion extends JFrame {

    private JTextField usuario;
    private JPasswordField contra;

    public VentanaInicioSesion() {
    	
    	
       
        setTitle("Inicio de Sesión");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 

       //inicializar los componentes del usuario
        
       
        JLabel usuarioLabel = new JLabel("Usuario:");
        usuario = new JTextField(10);
       
        
        //Inicializar los componentes de la contraseña
        JLabel contraLabel = new JLabel("Contraseña:");
        contra = new JPasswordField(10);

        
        
        // Botón de inicio de sesión
        JButton loginButton = new JButton("Iniciar Sesión");
        JButton anteriorButton = new JButton("Anterior");
        anteriorButton.addActionListener(e -> {
			VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
			ventanaprincipal.setVisible(true);
			this.dispose(); //se cierra esta ventana
		});
        loginButton.addActionListener(e -> {
        	
        });
     
        
        
        //Paneles 
        JPanel componentesUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        JPanel componentesContra = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));

        JPanel panelBoton = new JPanel();
        
        //Añadir componentes a los paneles
        componentesUsuario.add(usuarioLabel);
        componentesUsuario.add(usuario);
        
        componentesContra.add(contraLabel);
        componentesContra.add(contra);
        
        panelBoton.add(anteriorButton);
        panelBoton.add(loginButton);
        
        
        //añadir los paneles a la ventana
        add(componentesUsuario , BorderLayout.NORTH);
        add(componentesContra , BorderLayout.CENTER);
        add(panelBoton , BorderLayout.SOUTH);
        
        
    }

    public static void main(String[] args) {
        
        	VentanaInicioSesion ventana = new VentanaInicioSesion();
            ventana.setVisible(true);
        
    }
}