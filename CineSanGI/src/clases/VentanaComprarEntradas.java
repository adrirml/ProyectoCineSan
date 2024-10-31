package clases;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaComprarEntradas extends JFrame{

	
	    public VentanaComprarEntradas() {
	        setTitle("Compra de Entradas");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        
	        //layout:
	        setLayout(new FlowLayout());

	        //componentes:
	        JLabel labelPelis = new JLabel("Peliculas");
	        add(labelPelis);
	         
	        
	        JComboBox comboPelis = new JComboBox<Pelicula>();
	        add(comboPelis);
	    }
	
}
