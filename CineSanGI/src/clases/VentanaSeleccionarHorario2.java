package clases;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class VentanaSeleccionarHorario2 extends JFrame {
    private static final long serialVersionUID = 1L;
    private JSlider sliderHora;
    private JLabel etiquetaHora;
    private int diaSeleccionado;
    public VentanaSeleccionarHorario2(HorarioPelícula horarioPelicula) {
        Pelicula pelicula = horarioPelicula.getPelicula();
        Map<Integer, List<Integer>> horariosPorDia = horarioPelicula.getHorariosPorDia();
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelDias = new JPanel(new GridLayout(5, 7, 5, 5)); //Cuadrícula de 5 filas x 7 columnas para 30 días
        JPanel panelCentral = new JPanel(new BorderLayout());
        JLabel labelDiaHora = new JLabel("Seleccione Día y Hora para: " + pelicula.getTitulo());
        etiquetaHora = new JLabel("Selecciona la Hora:");
        etiquetaHora = new JLabel("Selecciona la Hora:");
        JButton siguiente = new JButton("Siguiente");
        
        setTitle("Compra de Entradas - " + pelicula.getTitulo());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        panelTitulo.add(labelDiaHora);
        add(panelTitulo, BorderLayout.NORTH);
        // Configuración del slider de hora
        sliderHora = new JSlider(JSlider.HORIZONTAL, 17, 23, 17); 
        sliderHora.setMajorTickSpacing(1);
        sliderHora.setPaintTicks(true);
        sliderHora.setPaintLabels(true);
        sliderHora.setEnabled(false);
        //tabla de días

        for (int dia = 1; dia <= 30; dia++) {
            JButton botonDia = new JButton(String.valueOf(dia));
            final int diaActual =dia;
            if (horariosPorDia.containsKey(dia)){
                botonDia.setEnabled(true);
                botonDia.setBackground(Color.GREEN);
                botonDia.addActionListener(e -> {
                    diaSeleccionado = diaActual; 
                    actualizarHorasDisponibles(horarioPelicula,diaActual);
                });
            }else {
                botonDia.setEnabled(false);
            }
            panelDias.add(botonDia);
        }
        //panel de días y slider de horas
        panelCentral.add(panelDias,BorderLayout.CENTER);
        panelCentral.add(etiquetaHora,BorderLayout.NORTH);
        panelCentral.add(sliderHora,BorderLayout.SOUTH);

        add(panelCentral, BorderLayout.CENTER);

        // Botón de "Siguiente"
        siguiente.addActionListener(e -> JOptionPane.showMessageDialog(this,"Has seleccionado el día:" + diaSeleccionado + " a las " + sliderHora.getValue()  + ":00"));
        add(siguiente, BorderLayout.SOUTH);
    }

    private void actualizarHorasDisponibles(HorarioPelícula horarioPelicula,int diaSeleccionado) {
        List<Integer> horasDisponibles = horarioPelicula.getHorariosPorDia(diaSeleccionado);
        if (horasDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this,"No hay horarios disponibles para este día.");
            sliderHora.setEnabled(false); 
            return;
        }
        int minHora = horasDisponibles.get(0);
        int maxHora = horasDisponibles.get(0);
        
        //mínimo y máximo de la lista
        for (int hora : horasDisponibles) {
            if (hora < minHora) {
                minHora = hora;
            }
            if (hora > maxHora) {
                maxHora = hora;
            }
        }
        sliderHora.setMinimum(minHora);
        sliderHora.setMaximum(maxHora);
        sliderHora.setEnabled(true);
        etiquetaHora.setText("Horas disponibles para el día " + diaSeleccionado + ":");
    }
}