package clases;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
        
        add(panelSeleccion, BorderLayout.NORTH);

        // BOTÓN DE CONFIRMAR
        JButton confirmarButton = new JButton("Confirmar");
        confirmarButton.addActionListener(e -> mostrarSeleccion());
        add(confirmarButton, BorderLayout.SOUTH);
        
        
      //panel de la sala para meter el esquema de los asientos 
		
        	JPanel salacine = new JPanel();
      		salacine.setLayout(new BorderLayout(10,10));

      		// panel donde se va indicar donde esta la pantalla
      		
      		JPanel pantallaPanel = new JPanel();
      		pantallaPanel.setLayout(new BorderLayout());
      		pantallaPanel.setBackground(Color.BLACK);
      		
      		JTextField pantalla = new JTextField("PANTALLA");
            pantalla.setEditable(false);    
            pantalla.setHorizontalAlignment(JTextField.CENTER);
            pantalla.setFont(new Font("Arial", Font.PLAIN, 24)); // Formato de la fuente
            pantalla.setForeground(Color.WHITE);
      		pantalla.setBackground(Color.GRAY);
      		
      		//Añadimos la pantalla al panel de la salacine
      		pantallaPanel.add(pantalla, BorderLayout.CENTER);
      		
      		salacine.add(pantallaPanel, BorderLayout.NORTH);
      		
      		//creamos el panel donde vamos a colocar los asientos
      		JPanel panelAsientos = new JPanel();
      		panelAsientos.setBackground(Color.DARK_GRAY);
      		panelAsientos.setLayout(new GridLayout(11,10));
      		
      		
      		
      		ArrayList<Integer> nums = new ArrayList<>();
      		for (int i =  1; i <=110 ; i ++) {
      			nums.add(i);
      		}
      		
      		//crear los 40 botones de asientos
      		for( Integer num : nums) {
      			JButton boton = new JButton(String.valueOf(num));
      			boton.setBackground(Color.GREEN);
      			boton.setPreferredSize(new Dimension(20,20));
      			boton.setFont(new Font("Arial",Font.BOLD,12));
      			
      			
      			boton.addActionListener(e -> {
      				if(boton.getBackground() == Color.GREEN) {        //clickar para ocupar asiento
      					boton.setBackground(Color.RED);
      				}else {
      					boton.setBackground(Color.GREEN);				// si lo vuelves a clickar se queda libre
      				}
      				
      				
      			});
      			
      			panelAsientos.add(boton);
      			
      		}
      		//Añadir en panel de asientos al panel salacine y luego añadir este a la ventana 
      		
      		 salacine.add(panelAsientos, BorderLayout.CENTER);
      		
     		 getContentPane().add(salacine, BorderLayout.CENTER);
      		 
      		 
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

