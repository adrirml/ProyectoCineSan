package clases;

import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VentanaSeleccionHorario extends JFrame {

	private static final long serialVersionUID = 1L;

	public VentanaSeleccionHorario(String tituloPelicula) {
		setTitle("Compra de Entradas");
		setSize(600,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout());     

		
		JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelDiaHora = new JLabel("Seleccione Dia y Hora para:"+ tituloPelicula);
        labelDiaHora.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelTitulo.add(labelDiaHora);
        add(panelTitulo, BorderLayout.NORTH);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(4, 1)); //4 filas 1 columna
		
        
        JLabel etiquetaHora = new JLabel("Selecciona la Hora:");
        panelCentral.add(etiquetaHora);
		//SLIDER DE LA HORA
		JSlider sliderHora= new JSlider(JSlider.HORIZONTAL, 17 ,23,17);
		sliderHora.setMajorTickSpacing(1); //una marca por cada hora
		sliderHora.setPaintTicks(true); //para ver las marcas
		sliderHora.setPaintLabels(true); 
        panelCentral.add(sliderHora);
		
        
        JLabel etiquetaDia = new JLabel("Selecciona el Día: Lunes"); // Valor inicial
        panelCentral.add(etiquetaDia);
		//SLIDER DEL DIA
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        JSlider sliderDia = new JSlider(JSlider.HORIZONTAL, 1, 7, 1);
        sliderDia.setMajorTickSpacing(1);
        sliderDia.setPaintTicks(true);
        sliderDia.setPaintLabels(true);
        
        sliderDia.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int diaIndex = sliderDia.getValue() - 1;
                etiquetaDia.setText("Seleccione el Día: " + diasSemana[diaIndex]);
            }
        });
        
        panelCentral.add(sliderDia);

        
        add(panelCentral, BorderLayout.CENTER);
        
        JButton siguiente = new JButton("Siguiente");
        siguiente.addActionListener(e -> {
        	int horaSeleccionada = sliderHora.getValue();
        	int diaSeleccionado = sliderDia.getValue();
        	String diaSeleccionadoT = diasSemana[diaSeleccionado -1];
        	JOptionPane.showMessageDialog(this, "Has seleccionado: " + diaSeleccionadoT + " a las " + horaSeleccionada + ":00");
        });
        add(siguiente, BorderLayout.SOUTH);
		
	}
}	

