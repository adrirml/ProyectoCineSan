package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class ListaFactura {
	
	private static List<Factura> facturas = new ArrayList<Factura>();
	

	public static void agregarFactura (String nombreCliente) {
		Factura factura = new Factura(nombreCliente, LocalDate.now());
		facturas.add(factura);
	}
	
	public static List<Factura> getFacturas() {
        return facturas;
    }

    public static void mostrarFacturas() {
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }
}


