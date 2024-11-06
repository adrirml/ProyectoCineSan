package clases;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaExtras extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unlikely-arg-type")
	public VentanaExtras() {
		
		setTitle("Comprar Extras Cine");
		setSize(600,800);
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
        
        String[] tiposPalomitas = {"Sin palomitas","Palomitas Pequeñas","Palomitas Medianas","Palomitas Grandes"};
        JComboBox palomitas = new JComboBox<>(tiposPalomitas);
        
        panel.add(palomitas);
        
        
        //combobox de las bebidas 
        JLabel labelBebidas = new JLabel("Bebidas: ");
        panel.add(labelBebidas);
        
        String[] tiposBebidas = {"Sin bebida","Bebida Pequeña","Bebida Mediana","Bebida Grande"};
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
        
        //se utilizan checkbox para poder elegir ambos a la vez 
        
        
        //carrito 
        
        JLabel carrito = new JLabel("Carrito: ");
        panel.add(carrito);
        JTextArea carritotext = new JTextArea();
        
        JScrollPane scroll = new JScrollPane(carritotext);
        panel.add(scroll);
        
        
        //Botones 
        JButton añadir = new JButton("Añadir");
        JButton finalizarCompra = new JButton("Finalizar compra");
        
        //panel para los botones y añadirlos
        JPanel panelbotones = new JPanel();
        panelbotones.add(añadir);
        panelbotones.add(finalizarCompra);
        
        
        //añadir el panel de los botones a la ventana     
        add(panelbotones , BorderLayout.SOUTH);
      
        
        
        //listeners de las acciones de los botones añadir y finalizar compra   
        
        añadir.addActionListener(e -> {
        	
        	ArrayList<String> compras = new ArrayList<String>();
        	
        	//añadir los productos al text area del carrito
        	
        	String palomitaString = (String) palomitas.getSelectedItem();
        	if(!palomitaString.equals("Sin palomitas")) {
        		compras.add(palomitaString);
        	}
        	
        	
        	String bebidaString = (String) bebidas.getSelectedItem();
        	
        	if(!bebidaString.equals("Sin bebida")) {
        		compras.add(bebidaString);
        	}
        	
        	if (chuchesCheck.isSelected()) {
        		compras.add("Chuches ----------- precio:2€");	
        	}
        	
        	if(asientos.isSelected()) {
        		compras.add("Alzador niño ----------- precio:1€");
        	}
        	
        	//añadir los precios al text area del carrito
        	for( String compra : compras) {
        		

            	//Precio para las palomitas 
        		
        		if(compra.equals(palomitaString)) {
        			
        			double precioPalomitas = 0.0;
        			
        			if(palomitaString.equals("Palomitas Pequeñas")) {
                		precioPalomitas = 1.0;
                	}
        			else if(palomitaString.equals("Palomitas Medianas")) {
                		precioPalomitas= 1.5;
                	}
        			else if(palomitaString.equals("Palomitas Grandes")) {
                		precioPalomitas = 2.0;
                	}
        			
        			carritotext.append(compra +"----------- precio:" + precioPalomitas + "€" + "\n");
        			
        		}
        		
        		//Precio de las bebidas
        		
        		else if(compra.equals(bebidaString)) {
        			
        			double precioBebidas = 0.0;
        			
        			if(bebidaString.equals("Bebida Pequeña")) {
                		precioBebidas = 1.5;
                	}
        			else if(bebidaString.equals("Bebida Mediana")) {
                		precioBebidas= 2.0;
                	}
        			else if(bebidaString.equals("Bebida Grande")) {
                		precioBebidas = 2.5;
                	}
        			carritotext.append(compra +"----------- precio:" + precioBebidas + "€" + "\n");
        		}
        		if(compra.equals("Chuches ----------- precio:2€")) {
        			carritotext.append(compra + "\n");
        		}
        		if(compra.equals("Alzador niño ----------- precio:1€")) {
        			carritotext.append(compra + "\n");
        		}
        		
        	
        	} 	
        });
        
        finalizarCompra.addActionListener(e -> {
        	int resultado = JOptionPane.showConfirmDialog(null, "¿Deseas finalizar la compra?","Confirmacion",JOptionPane.OK_CANCEL_OPTION);
        	
        	
        	if(resultado == JOptionPane.OK_OPTION) {
        		VentanaPago ventanapago = new VentanaPago();
        		ventanapago.setVisible(true);
        		dispose();  //se cierra la ventana actual 
        		
        	}
        	
        	carritotext.setText(""); //vaciar lo escrito en el carrito 
        	
        	
        });
        

    
               
}
	
	
}