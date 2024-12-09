package gui;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import domain.Cliente;
import domain.Reserva;

public class VentanaCarrito extends JFrame {
	
	public VentanaCarrito(Cliente cliente){
		
		setTitle("Tu carrito");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Entradas");
		model.addColumn("Palomitas");
		model.addColumn("Bebidas");
		model.addColumn("Chuches");
		model.addColumn("Alzadores Para niños");
		
		
		
		for (Reserva reserva : cliente.getReservas()) {
			model.addRow(new Object[] {
					reserva.getPelicula(),
	                reserva.getHorario(),
	                reserva.getAsientos(),
	                reserva.getPalommitas(),
	                reserva.getBebidas(),
	                reserva.getChuches(),
	                reserva.getAlzadores(),
	                String.format("%.2f€", reserva.getPrecio())});
		}
		
		JTable table = new JTable(model); 
		
		JButton salir = new JButton("Salir");
		add(salir,BorderLayout.SOUTH);
		
		salir.addActionListener(e -> {
			VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
			ventanaprincipal.setVisible(true);
			this.dispose(); //se cierra esta ventana
		});
		
		
		add(new JScrollPane(table));
		setVisible(true);
		
	}
}
