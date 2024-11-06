package clases;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaExtras extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaExtras() {
		setTitle("Comprar Extras Cine");
		setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        //layout:
        setLayout(new BorderLayout());
        
        //Panel principal 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2,10,10));
        add(panel , BorderLayout.CENTER);
        //combobox para las palomitas 
     
        JLabel labelpalomitas = new JLabel("Palomitas: ");
        panel.add(labelpalomitas);
        String[] tiposPalomitas = {"Sin palomitas","pequeñas","medianas","grandes"};
        JComboBox palomitas = new JComboBox<>(tiposPalomitas);
        panel.add(palomitas);
        
        
        //combobox de las bebidas
        
        JLabel labelBebidas = new JLabel("Bebidas: ");
        panel.add(labelBebidas);
        String[] tiposBebidas = {"Sin bebida","pequeña","mediana","grande"};
        JComboBox bebidas = new JComboBox<>(tiposBebidas);
        panel.add(bebidas);
        
        //checkbox chuches 
        
        JLabel chuches = new JLabel("Chuches: ");
        panel.add(chuches);
        
        JCheckBox chuchesCheck = new JCheckBox("Añadir chuches: ");
        panel.add(chuchesCheck);
        
        
        //checkBox de los alzadores de niños 
        JLabel alzador = new JLabel("Alzadores para niños: ");
        panel.add(alzador);
        
        JCheckBox asientos = new JCheckBox("Añadir alzador: ");
        panel.add(asientos);
        
        
        
        //carrito 
        
        JLabel carrito = new JLabel("Carrito: ");
        panel.add(carrito);
        JTextArea carritotext = new JTextArea(5,20);
        
        JScrollPane scroll = new JScrollPane(carritotext);
        panel.add(scroll);
        
        
        //Botones 
        JButton añadir = new JButton("Añadir: ");
        JButton finalizarCompra = new JButton("Finalizar compra: ");
        
        
        //listeners de las acciones de los botones añadir y finalizar compra 
        
        añadir.addActionListener(e -> {
        	//funcion añadir 
        	añadirAlCarrito();
        	
        });
        
        finalizarCompra.addActionListener(e -> {
        	JOptionPane.showMessageDialog(null,"finalizar compra: ");
        	carritotext.setText(""); //vaciarlo 
        	
        });
        
        
        //panel para los botones y añadirlos
        JPanel panelbotones = new JPanel();
        panelbotones.add(añadir);
        panelbotones.add(finalizarCompra);
        
        //añadir el panel de los botones a la ventana 
        
        add(panelbotones , BorderLayout.SOUTH);
               
}
	
	//metodo para añadir al carrito 
	
	private void añadirAlCarrito() {
		
	}
}