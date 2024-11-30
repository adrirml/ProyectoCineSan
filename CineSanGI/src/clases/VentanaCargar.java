package clases;


import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;


public class VentanaCargar extends JFrame{
	
	
	public VentanaCargar() {
		
		
		setTitle("Procesando el pago...");
		setSize(400,200);
		//setLayout(new GridLayout());
		
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.setBorder(new EmptyBorder(50, 20, 50, 20));
		
		add(panel);
		
		//panel barra:
		JPanel panelBarra = new JPanel(new GridLayout());
		
		// creamos la barra de 0 a 100
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new java.awt.Dimension(300, 20));
        

        // añadimos la barra a la ventana
        panelBarra.add(progressBar);
        panel.add(panelBarra);
        
        JLabel texto = new JLabel("Procesando el pago, por favor espere. ");
        panel.add(texto);

		
		Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                
                for (int i = 0; i <= 100 & !Thread.interrupted(); i++) {
                   
                    // actualizamos la barra de progreso con el % 
                    int progress = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setValue((int) (progress));
                        }
                    });
                    
                    try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						break;
					}
                }
                
                SwingUtilities.invokeLater(()->{
                	JOptionPane.showMessageDialog(VentanaCargar.this, "Pago realizado con éxito", "Pago finalizado", JOptionPane.INFORMATION_MESSAGE);
                	
                	//cuando acaba, vuelve a la ventana principal y se cierra esta ventana:
                	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                    ventanaPrincipal.setVisible(true); 
                    dispose();
                });
            }
            
		});
		 t.start();
		 
	}

}
