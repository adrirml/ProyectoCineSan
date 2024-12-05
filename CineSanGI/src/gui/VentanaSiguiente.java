package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSiguiente extends JFrame{
	
	
	private JButton pago; 
	private JButton añadirExtras;
	private JLabel mensaje; 
	
	
	//constructor
	public VentanaSiguiente() {
		
		setTitle("Ventana Siguiente");
		setSize(350,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	    setLayout(new BorderLayout());
		
	    //inicializar botones y mensaje
	    pago = new JButton("Pagar");
	    añadirExtras = new JButton("Añadir Extras");
	    mensaje = new JLabel();
	    
	    
	    //crear paneles
	    JPanel botones = new JPanel(new FlowLayout());
	    JPanel panelLabel = new JPanel(new FlowLayout());
	    
	    
	    //añadir botones al panel 
	    botones.add(pago);
	    botones.add(añadirExtras);
	    
	    //añadir mensaje a panel 
	    mensaje.setText("¿quieres seguir comprando extras o finalizar el pago?");
	    panelLabel.add(mensaje);
	    
	    
	    //Agregar panel  ventana
	    add(panelLabel , BorderLayout.NORTH);
	    add(botones, BorderLayout.CENTER);
	    
	    
	    //accion del boton pagar 
	    pago.addActionListener(e -> {
	    	VentanaPago ventanapago = new VentanaPago();
	    	ventanapago.setVisible(true);
	    	this.dispose();
	    	
	    });
	    
	    //accion del boton añadir extras 
	    añadirExtras.addActionListener(e -> {
	    	VentanaExtras ventanaextras = new VentanaExtras();
	    	ventanaextras.setVisible(true);
	    	this.dispose();
	    });
	    
	    
	}
	
	public static void main(String[] args) {
		VentanaSiguiente ventana = new VentanaSiguiente();
		ventana.setVisible(true);
	}
	
}
