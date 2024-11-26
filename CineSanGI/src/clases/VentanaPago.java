package clases;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	private JPanel panelImagen;
	private JPanel panelBotones;
	
	public VentanaPago() {
		setTitle("Pago");
		setSize(950,500);
		setLayout(new BorderLayout());
		
	//panel principal (panel datos):
		panelDatos = new JPanel(new BorderLayout());
		panelDatos.setBorder(new EmptyBorder(50, 20, 50, 20));
		
	//panel imagen (izquierda):
		panelImagen = new JPanel(new BorderLayout());
		panelImagen.setBorder(new EmptyBorder(10, 20, 20, 10));
		URL url = getClass().getResource("/images/pago.png");
		ImageIcon iconoPago = new ImageIcon(url);
		JLabel lblImagen = new JLabel(iconoPago);
		
		panelImagen.add(lblImagen, BorderLayout.CENTER);
		
		add(panelImagen, BorderLayout.WEST);
		
		
	//panel superior:
		panel1 = new JPanel(new GridLayout(3,2,10,10));
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
		JTextField txtNombre = new JTextField();
		JLabel lblNumTarjeta = new JLabel("Número de la tarjeta de crédito: ");
		lblNumTarjeta.setFont(new Font("Arial", Font.BOLD, 18));
		JTextField txtNumTarjeta = new JTextField();
		JLabel lblValidez = new JLabel("Validez: ");
		lblValidez.setFont(new Font("Arial", Font.BOLD, 18));
		
		txtNombre.setPreferredSize(new Dimension(250,25));
		txtNumTarjeta.setPreferredSize(new Dimension(250,25));
		
		panel1.add(lblNombre);
		panel1.add(txtNombre);
		panel1.add(lblNumTarjeta);
		panel1.add(txtNumTarjeta);
		panel1.add(lblValidez);
		
		
	//panel inferior:		
		panelValidez = new JPanel(new GridLayout(3,2,10,10));	//3 filas 2 columnas
		panelValidez.setBorder(new EmptyBorder(10, 0, 10, 30));
		
		
		JLabel lblMes = new JLabel("MES: ");
		lblMes.setFont(new Font("Arial", Font.BOLD, 15));
		String[] meses = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
		JComboBox<String> comboMes = new JComboBox<>(meses);
		comboMes.setPreferredSize(new Dimension(120, 10));
		
		
		JLabel lblAnyo = new JLabel("AÑO: ");
		lblAnyo.setFont(new Font("Arial", Font.BOLD, 15));
		String[] anyos = { "2024","2025", "2026","2027","2028", "2029", "2030", "2031", "2032", "2033"};
		JComboBox<String> comboAnyo= new JComboBox<>(anyos);
		//comboAnyo.setPreferredSize(new Dimension(150,30));
		
		JLabel lblCVV = new JLabel("CVV: ");
		lblCVV.setFont(new Font("Arial", Font.BOLD, 15));
		JTextField txtCVV = new JTextField();
		txtCVV.setFont(new Font("Arial", Font.PLAIN, 18));
		txtCVV.setPreferredSize(new Dimension(100,25));
		
		panelValidez.add(lblMes);
		panelValidez.add(comboMes);
		panelValidez.add(lblAnyo);
		panelValidez.add(comboAnyo);
		panelValidez.add(lblCVV);
		panelValidez.add(txtCVV);
		
		//añadimos los paneles al principal (datos):
		panelDatos.add(panel1, BorderLayout.NORTH);
		panelDatos.add(panelValidez, BorderLayout.CENTER);
		
		
		//panel botones:
		panelBotones = new JPanel();
		JButton botonConfirmar = new JButton("CONFIRMAR");
		JButton botonCancelar = new JButton("CANCELAR");
		JButton botonAtras = new JButton("ATRÁS");
		
		panelBotones.add(botonAtras);
		panelBotones.add(botonConfirmar);
		panelBotones.add(botonCancelar);
		
		
		//BOTÓN ATRÁS:
				botonAtras.addActionListener(e -> {
						
			        	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			        	ventanaPrincipal.setVisible(true);
						this.dispose(); //se cierra esta ventana
					});
				
		
		
		//añadimos paneles a la ventana:
		add(panelDatos, BorderLayout.EAST);
		add(panelBotones, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		VentanaPago ventana = new VentanaPago();
		ventana.setVisible(true);
	}
}
