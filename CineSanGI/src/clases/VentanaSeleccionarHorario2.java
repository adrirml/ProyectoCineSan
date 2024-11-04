package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;

public class VentanaSeleccionarHorario2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel etiquetaHora;
    private int diaSeleccionado;
    private Map<Integer, List<Integer>> horariosPorDia;
    private JButton salir;
    
    public VentanaSeleccionarHorario2() {
        generarHorariosAleatorios();
        
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelDias = new JPanel(new GridLayout(5, 7, 5, 5)); //Cuadrícula de 5 filas x 7 columnas para 30 días
        JPanel panelCentral = new JPanel(new BorderLayout());
        JLabel labelDiaHora = new JLabel("Seleccione Día y Hora para: ");
        etiquetaHora = new JLabel("Seleccione el Día:");
        JButton siguiente = new JButton("Siguiente");
        salir = new JButton("Salir");
        JPanel panelSur = new JPanel();
        setTitle("Compra de Entradas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        panelTitulo.add(labelDiaHora);
        add(panelTitulo, BorderLayout.NORTH);
        
        for (int dia=1; dia <= 30; dia++) {
        	JButton botonDia = new JButton(String.valueOf(dia));
        	final int diaActual = dia;
        	
        	if (horariosPorDia.containsKey(dia)) {
        		botonDia.setEnabled(true);
        		botonDia.setBackground(Color.GREEN);
        		botonDia.addActionListener(e -> {
        			diaSeleccionado = diaActual;
        			mostrarHorasDisponibles(diaActual);
        		});
        	}else {
        		botonDia.setEnabled(true);
        	}
        	panelDias.add(botonDia);
        }
        
        panelCentral.add(panelDias, BorderLayout.CENTER);
        panelCentral.add(etiquetaHora, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);
        
        panelSur.add(siguiente);
        siguiente.addActionListener(e -> {
        	JOptionPane.showMessageDialog(this, "Gracias por seleccionar el día");
        });
        panelSur.add(salir);
        salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
        });
        add(panelSur,BorderLayout.SOUTH);
    }
    
    private void mostrarHorasDisponibles(int diaSleccionado) {
    	List<Integer> horasDisponibles = horariosPorDia.getOrDefault(diaSeleccionado, Collections.emptyList());
    	if (horasDisponibles.isEmpty()) {
    		etiquetaHora.setText("No hay horas Disponibles");
    		return;
    	}
    	String horasTexto= horasDisponibles.toString();
    	etiquetaHora.setText(horasTexto);
    }
    
    private void generarHorariosAleatorios(){
    	horariosPorDia = new HashMap<>();
    	Random random = new Random();
    	
    	int totalDias = 30;
    	int diasDisponibles =10;
    	int horaMin = 17;
    	int horaMax = 23;
    	
    	Set<Integer> diasAleatorios = new HashSet<>();
    	while (diasAleatorios.size() < diasDisponibles) {
    		int diaAleatorio = random.nextInt(totalDias) +1;
    		diasAleatorios.add(diaAleatorio);
    	}
    	for (int dia : diasAleatorios) {
    		int cantidadHoras = random.nextInt(4) +2;
    		Set<Integer> horasDia = new HashSet<>();
    		while (horasDia.size() < cantidadHoras) {
    			int horaAleatoria = random.nextInt(horaMax -horaMin +1) + horaMin;
    			horasDia.add(horaAleatoria);
    		}
    		horariosPorDia.put(dia,new ArrayList<>(horasDia));
    	}
    }
}