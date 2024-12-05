package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


public class VentanaExtras extends JFrame {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unlikely-arg-type")
	public VentanaExtras() {
		//Carga de fotos
		URL palomitasURL = getClass().getResource("/images/palomitas.png");
        URL bebidaURL = getClass().getResource("/images/bebida.png"); // 
        URL chuchesURL = getClass().getResource("/images/chuches.png"); 
        URL alzadorURL = getClass().getResource("/images/alzador.png"); 
        
        ImageIcon iconoPal = new ImageIcon(palomitasURL);
        ImageIcon iconoBe = new ImageIcon(bebidaURL);
        ImageIcon iconoChu = new ImageIcon(chuchesURL);
        ImageIcon iconoAlz = new ImageIcon(alzadorURL);
 
		
		
        //Redimensionar las imagenes
        
        Image imagenPal = iconoPal.getImage();
        Image Palred = imagenPal.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconPalred = new ImageIcon(Palred);
        
        Image imagenBe = iconoBe.getImage();
        Image Bered = imagenBe.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconBered = new ImageIcon(Bered);
        
        Image imagenCh = iconoChu.getImage();
        Image Chred = imagenCh.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconChred = new ImageIcon(Chred);
        
        Image imagenAlz = iconoAlz.getImage();
        Image Alred = imagenAlz.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon iconAlred = new ImageIcon(Alred);
        
        
		setTitle("Comprar Extras Cine");
		setSize(600,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        //layout:
        setLayout(new BorderLayout(10,10));
        
 
        //Panel principal 
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,3,10,10));
        add(panel , BorderLayout.CENTER);
        
        
        //combobox para las palomitas 
        JLabel labelPalomitasImg = new JLabel();
        labelPalomitasImg.setIcon(iconPalred);
        JLabel labelpalomitas = new JLabel("Palomitas: ");
        
        String[] tiposPalomitas = {"Sin palomitas","Palomitas Pequeñas","Palomitas Medianas","Palomitas Grandes"};
        JComboBox palomitas = new JComboBox<>(tiposPalomitas);
        
        panel.add(labelPalomitasImg);
        panel.add(labelpalomitas);
        panel.add(palomitas);
        
        
        //combobox de las bebidas 
        
        JLabel labelBebidasImg = new JLabel();
        labelBebidasImg.setIcon(iconBered);

        JLabel labelBebidas = new JLabel("Bebidas: ");
        
        String[] tiposBebidas = {"Sin bebida","Bebida Pequeña","Bebida Mediana","Bebida Grande"};
        JComboBox bebidas = new JComboBox<>(tiposBebidas);
        
        panel.add(labelBebidasImg);
        panel.add(labelBebidas);
        panel.add(bebidas);
        
        //checkbox chuches      
        
        JLabel labelChuchesImg = new JLabel();
        labelChuchesImg.setIcon(iconChred);

        JLabel chuches = new JLabel("Chuches: ");
        
        JCheckBox chuchesCheck = new JCheckBox("Añadir chuches: ");
        panel.add(labelChuchesImg);
        panel.add(chuches);
        panel.add(chuchesCheck);
        
        
        //checkBox de los alzadores de niños 
        
        JLabel labelAlzadoresImg = new JLabel();
        labelAlzadoresImg.setIcon(iconAlred);

        JLabel alzador = new JLabel("Alzadores para niños: ");
        
        JCheckBox asientos = new JCheckBox("Añadir alzador: ");
        
        panel.add(labelAlzadoresImg);
        panel.add(alzador);
        panel.add(asientos);
        
        //se utilizan checkbox para poder elegir ambos a la vez 
        
        
        //carrito 
        
        JLabel carrito = new JLabel("Carrito: ");
        panel.add(carrito, BorderLayout.NORTH);
        
        /*
        JTextArea carritotext = new JTextArea();
        carritotext.setEditable(false);	//desde el carrito no se puede editar
        */
        DefaultListModel<String> modeloCarrito = new DefaultListModel<String>();
        JList<String> listaCarrito = new JList<String>(modeloCarrito);
        
        
        
        JScrollPane scroll = new JScrollPane(listaCarrito);
        panel.add(scroll, BorderLayout.WEST);
        
        
        
        
        //Botones 
        JButton añadir = new JButton("Añadir");
        JButton finalizarCompra = new JButton("Finalizar compra");
        JButton eliminarProducto = new JButton("Eliminar"); //para borrar del carrito el producto seleccionado
        
        //panel para los botones y añadirlos
        JPanel panelbotones = new JPanel();
        panelbotones.add(añadir);
        panelbotones.add(finalizarCompra);
        panelbotones.add(eliminarProducto);
        
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
        			
        			//carritotext.append(compra +"----------- precio:" + precioPalomitas + "€" + "\n");
        			modeloCarrito.addElement(compra +"----------- precio:" + precioPalomitas + "€" + "\n");
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
        			//carritotext.append(compra +"----------- precio:" + precioBebidas + "€" + "\n");
        			modeloCarrito.addElement(compra +"----------- precio:" + precioBebidas + "€" + "\n");
        		}
        		if(compra.equals("Chuches ----------- precio:2€")) {
        			//carritotext.append(compra + "\n");
        			modeloCarrito.addElement(compra + "\n");
        		}
        		if(compra.equals("Alzador niño ----------- precio:1€")) {
        			//carritotext.append(compra + "\n");
        			modeloCarrito.addElement(compra + "\n");
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
        	
        	//carritotext.setText(""); //vaciar lo escrito en el carrito 
        	modeloCarrito.clear();
        	
        });
        
        eliminarProducto.addActionListener(e -> {
        	
        	int productoEliminar = listaCarrito.getSelectedIndex();
        	
        	if(modeloCarrito.size() == 0) {
        		JOptionPane.showMessageDialog(this, "No hay ningún producto en el carrito aún." + "\n" + "Añada los productos que desea comprar en el carrito");
        	}else if(productoEliminar != -1) {
        		modeloCarrito.remove(productoEliminar);
        	}else {
        		JOptionPane.showMessageDialog(this, "Por favor seleccione el producto que quiere eliminar del carrito");
        	}
        });

    
               
}
	
	
}