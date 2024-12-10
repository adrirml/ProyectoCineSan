package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Cliente;
import domain.Reserva;

public class BDCliente {
	private static BDCliente instance;

    private BDCliente() { }

    public static synchronized BDCliente get() {
        if (instance == null) instance = new BDCliente();
        return instance;
    }

    public Cliente[] obtenerTodasLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión
        	String url = "jdbc:mysql://localhost:3306/CineSan";
            String user = "CineSan";
            String password = "Contraseña";

            conn = DriverManager.getConnection(url, user, password);
            
            // Crear una declaración
            stmt = conn.createStatement();

            // Ejecutar la consulta
            String sql = "SELECT * FROM clientes";
            rs = stmt.executeQuery(sql);

            // Procesar el ResultSet
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String edad = rs.getString("edad");
                String correoElectronico = rs.getString("correoelectronico");
                String contraseña = rs.getString("contraseña");
                
                Reserva[] reservasArray = BDReserva.obtenerReservas(nombre); 
                List<Reserva> reservas = new ArrayList<>();
                if (reservasArray != null) {
                    for (Reserva reserva : reservasArray) {
                        reservas.add(reserva);
                    }                
                

                Cliente cliente = new Cliente(nombre, edad, correoElectronico, contraseña, reservas);
                clientes.add(cliente);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        
        return clientes.toArray(new Cliente[0]);
    }

    public void guardarTodosLosClientes(Cliente[] clientes) {
    	String url = "jdbc:mysql://localhost:3306/CineSan";
        String user = "CineSan";
        String password = "Contraseña";

        String comprobarSiClienteYaExiste = "SELECT 1 FROM clientes WHERE nombre = ?";
        String actualizarCliente = "UPDATE clientes SET apellido = ?, edad = ?, correoelectronico = ?, contraseña = ? WHERE nombre = ?";
        String agregarNuevaCliente = "INSERT INTO clientes (nombre, apellido , edad, correoelectronico, contraseña) VALUES (?, ?, ?, ?, ?)";
        String eliminarClientesObsoletas = "DELETE FROM clientes WHERE nombre NOT IN (%s)";
        String insertarReserva = "INSERT INTO reservas (pelicula, detalles) VALUES (?, ?)";
        String eliminarReservasCliente = "DELETE FROM reservas WHERE pelicula = ?";

        Connection conn = null;
        PreparedStatement stmtCheck = null;
        PreparedStatement stmtUpdate = null;
        PreparedStatement stmtInsert = null;
        PreparedStatement stmtDelete = null;

        try {
            // Establecer la conexión
            conn = DriverManager.getConnection(url, user, password);
            // Deshabilitar auto-commit para manejar transacciones manualmente
            conn.setAutoCommit(false);

            // Preparar las sentencias
            stmtCheck = conn.prepareStatement(comprobarSiClienteYaExiste);
            stmtUpdate = conn.prepareStatement(actualizarCliente);
            stmtInsert = conn.prepareStatement(agregarNuevaCliente);
            stmtDelete = conn.prepareStatement(eliminarReservasCliente);


            Set<String> nombresdados = new HashSet<>();

            for (Cliente cliente: clientes) {
            	nombresdados.add(cliente.getNombre());

                // Verificar si el cliente ya existe
                stmtCheck.setString(1, cliente.getNombre());
                try (ResultSet rs = stmtCheck.executeQuery()) {
                    if (rs.next()) {
                        // EXISTE -> proceder a actualizar
                    	stmtInsert.setString(1, cliente.getNombre());
                        stmtInsert.setString(2, cliente.getEdad());
                        stmtInsert.setString(3, cliente.getCorreoelectronico());
                        stmtInsert.setString(4, cliente.getContraseña());
                        stmtInsert.executeUpdate();

                        // Eliminar reservas existentes del cliente
                        stmtDelete.setString(1, cliente.getNombre());
                        stmtDelete.executeUpdate();
                        

                        stmtUpdate.executeUpdate();
                    } else {
                        // NO EXISTE -> proceder a insertar
                        stmtInsert.setString(1, cliente.getNombre());
                        stmtInsert.setString(2, cliente.getEdad());
                        stmtInsert.setString(3, cliente.getCorreoelectronico());
                        stmtInsert.setString(4, cliente.getContraseña());
                        stmtInsert.executeUpdate();


                    }
                    // Insertar reservas del cliente
                    for (Reserva reserva : cliente.getReservas()) {
                    	stmtInsert.setString(1, cliente.getNombre()); 
                    	stmtInsert.setString(2, reserva.getHorario()); 
                    	stmtInsert.setString(3, reserva.getPalommitas()); 
                    	stmtInsert.setString(4, reserva.getBebidas()); 
                    	stmtInsert.setBoolean(5, reserva.getChuches()); 
                    	stmtInsert.setBoolean(6, reserva.getAlzadores()); 
                    	stmtInsert.setDouble(7, reserva.getPrecio()); 

                    	stmtInsert.executeUpdate();
                    }
                }
            }

            if (!nombresdados.isEmpty()) {
                StringBuilder placeholders = new StringBuilder();
                for (int i = 0; i < nombresdados.size(); i++) {
                    placeholders.append("?");
                    if (i < nombresdados.size() - 1) {
                        placeholders.append(", ");
                    }
                }

                String sqlDelete = String.format(eliminarClientesObsoletas, placeholders);
                stmtDelete = conn.prepareStatement(sqlDelete);

                int index = 1;
                for (String titulo : nombresdados) {
                    stmtDelete.setString(index++, titulo);
                }

                stmtDelete.executeUpdate();
            } else {
                String sqlDeleteAll = "DELETE FROM clientes";
                stmtDelete = conn.prepareStatement(sqlDeleteAll);
                stmtDelete.executeUpdate();
            }

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transacción revertida debido a un error.");
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                    System.out.println("Error al realizar el rollback.");
                }
            }
        } finally {
            // Cerrar recursos
            try {
                if (stmtDelete != null) stmtDelete.close();
                if (stmtInsert != null) stmtInsert.close();
                if (stmtUpdate != null) stmtUpdate.close();
                if (stmtCheck != null) stmtCheck.close();
                if (conn != null) conn.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
                System.out.println("Error al cerrar los recursos.");
            }
        }
    }


}
