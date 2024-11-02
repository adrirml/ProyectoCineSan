package clases;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class VentanaComprarEntradas extends JFrame{

	
	    public VentanaComprarEntradas() {
	        setTitle("Compra de Entradas");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	        
	        //layout:
	        setLayout(new BorderLayout());

	        //Titulo de peliculas:
	        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        JLabel labelPelis = new JLabel("PELICULAS");
	        labelPelis.setFont(new Font("Tahoma", Font.BOLD, 30));
	        panelTitulo.add(labelPelis);
	        add(panelTitulo, BorderLayout.NORTH); 
	        
	        //panel de botones para que salgan en columna 
	        JPanel panelbotones = new JPanel();
	        panelbotones.setLayout(new BoxLayout(panelbotones, BoxLayout.Y_AXIS));
	      
	        //Inicializar los botones 
	        JButton pelicula1 = new JButton("Pelicula 1");
	        JButton pelicula2 = new JButton("Pelicula 2");
	        JButton pelicula3 = new JButton("Pelicula 3");
	        
	        //añadir los botones y el panel de los botones
	        panelbotones.add(pelicula1);
	        panelbotones.add(pelicula2);
	        panelbotones.add(pelicula3);
	        
	        add(panelbotones, BorderLayout.CENTER);
	        
	        //PELICULA 1:
	        
	        pelicula1.addActionListener(e -> VentanaSeleccionHorario ("Pelicula 1"));
	        pelicula2.addActionListener(e -> VentanSeleccionHorario ("Pelicula 2"));
	        pelicula3.addActionListener(e -> VentanSeleccionHorario ("Pelicula 3"));

	        
	        
	         
	        
	    }
	   
	
}


/*
public class VentanaSeleccionHorario extends JFrame{
	
	public Ventana SeleccionHorario(string tituloPelicula) {
		setTitle("Seleccione Dia y Hora para:"+ titulopelicula);
		setSize(400,300);
		setLayout(new GridLayout(5,1));
		
		//SLIDER DE LA HORA
		JSilder sliderHora= new JSlider(JSlider.Horizontal, 17 ,23,30);
		sliderHora.setMajorTickSpacing(1); //una marca por cada hora
		sliderHora.setPaintTicks(true); //para ver las marcas
		sliderHora.setPaintLabels(true); 
		add(new JLabel("Selecciona la Hora:"));
		add(sliderHora);
		
		//SLIDER DEL DIA
		JSlider sliderDia = new JSlider(JSlider.HORIZONTAL, 1, 7, 1); // hacer q ponga (lunes, martes miercoles..)
		sliderDia.setMajorTickSpacing(1);
		sliderDia.setPaintTicks(true);
		sliderDia.setPaintLabels(true);
		add(new JLabel("Selecciona el Día:"));
		add(sliderDia);
		
		
//		JButton siguiente =new JButton ("Siguiente");
//		siguiente.addActionListener(e->{
//			
//		})
//		add(siguiente)
//lo siguiente seria la seleccion de butaca
				
		
	}
	
		
}
*/