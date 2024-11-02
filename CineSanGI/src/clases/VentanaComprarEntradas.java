package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaComprarEntradas extends JFrame{

	
	    public VentanaComprarEntradas() {
	        setTitle("Compra de Entradas");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        
	        //layout:
	        setLayout(new BorderLayout());

	        //Titulo de peliculas:
	        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        JLabel labelPelis = new JLabel("PELICULAS");
	        labelPelis.setFont(new Font("Tahoma", Font.BOLD, 30));
	        panelTitulo.add(labelPelis);
	        add(panelTitulo, BorderLayout.NORTH); 
	        
	        //panel de botones para que salgan en columna 
	        JPanel panelbotones = new JPanel();
	        panelbotones.setLayout(new BoxLayout(panelbotones, BoxLayout.Y_AXIS));
	      
	        //Inicializar los botones 
	        JButton pelicula1 = new JButton("Pelicula 1");
	        JButton pelicula2 = new JButton("Pelicula 2");
	        JButton pelicula3 = new JButton("Pelicula 3");
	        
	        //añadir los botones y el panel de los botones
	        panelbotones.add(pelicula1);
	        panelbotones.add(pelicula2);
	        panelbotones.add(pelicula3);
	        
	        add(panelbotones, BorderLayout.CENTER);
	        
	        
	  
	        
	        pelicula1.addActionListener(e -> {
	        	VentanaSeleccionHorario ventanahorario = new VentanaSeleccionHorario(pelicula.get(titulo));
	        	ventanahorario.setVisible(true);
	        });
	        
	        pelicula2.addActionListener(e -> {
	        	VentanaSeleccionHorario ventanahorario =new VentanaSeleccionHorario(pelicula.get(titulo));
	        	ventanahorario.setVisible(true);
        	});
	        
	        pelicula3.addActionListener(e -> {
	        	VentanaSeleccionHorario ventanahorario =new VentanaSeleccionHorario(pelicula.get(titulo));
	        	ventanahorario.setVisible(true);
        	});
	        
	        
	        
	         
	        
	    }
	   
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
