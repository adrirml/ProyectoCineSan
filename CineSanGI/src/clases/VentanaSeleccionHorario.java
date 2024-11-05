package clases;

import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaSeleccionHorario extends JFrame {
	 private JRadioButton hora1;
	 private JRadioButton hora2;
	 private JRadioButton hora3;
	 private JRadioButton hora4;

	 private JRadioButton diaLunes;
	 private JRadioButton diaMartes;
	 private JRadioButton diaMiercoles;
	 private JRadioButton diaJueves;
	 private JRadioButton diaViernes; 
	 private JRadioButton diaSabado;
	 private JRadioButton diaDomingo;

	public VentanaSeleccionHorario(String tituloPelicula) {
		setTitle("Compra de Entradas");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // PANEL DEL TÍTULO
        JPanel panelTitulo = new JPanel();
        JLabel labelDiaHora = new JLabel("Seleccione Día y Hora para: " + tituloPelicula);
        labelDiaHora.setFont(new Font("Tahoma", Font.BOLD, 17));
        panelTitulo.add(labelDiaHora);
        add(panelTitulo, BorderLayout.NORTH);

        // PANEL GENERAL
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new GridLayout(2, 1)); 

        // PANEL DIAS
        JPanel panelDias = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelDia = new JLabel("Día:");
        panelDias.add(labelDia);
        
        //botones
        diaLunes = new JRadioButton("Lunes");
        diaMartes = new JRadioButton("Martes");
        diaMiercoles = new JRadioButton("Miércoles");
        diaJueves = new JRadioButton("Jueves");
        diaViernes = new JRadioButton("Viernes");
        diaSabado = new JRadioButton("Sábado");
        diaDomingo = new JRadioButton("Domingo");

        ButtonGroup grupoDias = new ButtonGroup();
        grupoDias.add(diaLunes);
        grupoDias.add(diaMartes);
        grupoDias.add(diaMiercoles);
        grupoDias.add(diaJueves);
        grupoDias.add(diaViernes);
        grupoDias.add(diaSabado);
        grupoDias.add(diaDomingo);

        panelDias.add(diaLunes);
        panelDias.add(diaMartes);
        panelDias.add(diaMiercoles);
        panelDias.add(diaJueves);
        panelDias.add(diaViernes);
        panelDias.add(diaSabado);
        panelDias.add(diaDomingo);
        
        //añadir
        panelSeleccion.add(panelDias); 

        
        // PANEL HORARIOS
        JPanel panelHorarios = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelHorario = new JLabel("Horario:");
        panelHorarios.add(labelHorario);

        //botones
        hora1 = new JRadioButton("16:30");
        hora2 = new JRadioButton("18:00");
        hora3 = new JRadioButton("21:00");
        hora4 = new JRadioButton("22:30");

        ButtonGroup grupoHorarios = new ButtonGroup();
        grupoHorarios.add(hora1);
        grupoHorarios.add(hora2);
        grupoHorarios.add(hora3);
        grupoHorarios.add(hora4);

        panelHorarios.add(hora1);
        panelHorarios.add(hora2);
        panelHorarios.add(hora3);
        panelHorarios.add(hora4);

        panelSeleccion.add(panelHorarios); 
        
        add(panelSeleccion, BorderLayout.CENTER);

        // BOTÓN DE CONFIRMAR
        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(e -> mostrarSeleccion());
        add(confirmarButton, BorderLayout.SOUTH);
    }

	//MENSAJE
    private void mostrarSeleccion() {
        String diaSeleccionado = "No se ha seleccionado ningún día.";
        if (diaLunes.isSelected()) {
            diaSeleccionado = "Día seleccionado: Lunes";
        } else if (diaMartes.isSelected()) {
            diaSeleccionado = "Día seleccionado: Martes";
        } else if (diaMiercoles.isSelected()) {
            diaSeleccionado = "Día seleccionado: Miércoles";
        } else if (diaJueves.isSelected()) {
            diaSeleccionado = "Día seleccionado: Jueves";
        } else if (diaViernes.isSelected()) {
            diaSeleccionado = "Día seleccionado: Viernes";
        } else if (diaSabado.isSelected()) {
            diaSeleccionado = "Día seleccionado: Sábado";
        } else if (diaDomingo.isSelected()) {
            diaSeleccionado = "Día seleccionado: Domingo";
        }

        String horaSeleccionada = "No se ha seleccionado ninguna hora.";
        if (hora1.isSelected()) {
            horaSeleccionada = "Hora seleccionada: 16:30";
        } else if (hora2.isSelected()) {
            horaSeleccionada = "Hora seleccionada: 18:00";
        } else if (hora3.isSelected()) {
            horaSeleccionada = "Hora seleccionada: 21:00";
        }
        String mensaje = diaSeleccionado + "\n" + horaSeleccionada;
        JOptionPane.showMessageDialog(this, mensaje, "Selección de Horario", JOptionPane.INFORMATION_MESSAGE);
    }    

}

