package clases;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPago extends JFrame {
	
	private JPanel panelDatos;
	private JPanel panel1;
	private JPanel panelValidez;
	
	public VentanaPago() {
		setTitle("Pago");
		setSize(900,500);
		setLayout(new BorderLayout());
		
		
		//layout panelDatos , panel1 y panelValidez:
		panelDatos = new JPanel(new BorderLayout());
		panelDatos.setBorder(new EmptyBorder(100, 30, 30, 200));
		panel1 = new JPanel(new GridLayout(3,2));	
		panelValidez = new JPanel(new FlowLayout());
		
		
		//etiquetas:
		JLabel lblNombre = new JLabel("Nombre: ");
		JTextField txtNombre = new JTextField("Introduzca el nombre de la tarjeta ");
		JLabel lblNumTarjeta = new JLabel("Número de la tarjeta de crédito: ");
		JTextField txtNumTarjeta = new JTextField("Introduzca el número de la tarjeta: ");
		
		panel1.add(lblNombre);
		panel1.add(txtNombre);
		panel1.add(lblNumTarjeta);
		panel1.add(txtNumTarjeta);
		
		JLabel lblValidez = new JLabel("Validez: ");
				
		panel1.add(lblValidez);
		
		JComboBox<String> comboMes= new JComboBox<String>();
		comboMes.insertItemAt("MES", 0);
		comboMes.setPreferredSize(new Dimension(150,30));
		JComboBox<String> comboAnyo= new JComboBox<String>();
		comboAnyo.insertItemAt("AÑO", 0);
		comboAnyo.setPreferredSize(new Dimension(150,30));
		JTextField txtCVV = new JTextField("CVV");
		txtCVV.setFont(new Font("Arial", Font.PLAIN, 20));
		
		panelValidez.add(comboMes);
		panelValidez.add(comboAnyo);
		panelValidez.add(txtCVV);
		
		panelDatos.add(panel1, BorderLayout.NORTH);
		panelDatos.add(panelValidez);
		add(panelDatos, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		VentanaPago ventana = new VentanaPago();
		ventana.setVisible(true);
	}
}
