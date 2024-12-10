package clases;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Cliente;
import domain.Reserva;

public class BDReserva {
	private static BDReserva instance;

    private BDReserva() { }

    public static synchronized BDReserva get() {
        if (instance == null) instance = new BDReserva();
        return instance;
    }

    public static Reserva[] obtenerReservas(String nombre) {
        List<Reserva> reservas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión
            String url = "";
            String user = "";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            
           

            // Crear una declaración
            stmt = conn.prepareStatement("SELECT * FROM reservas where nombre=?");
            stmt.setString(1, nombre);
            rs= stmt.executeQuery();
    

            // Procesar el ResultSet
            while (rs.next()) {
                String pelicula = rs.getString("pelicula");
                String horario = rs.getString("horario");
                String palomitas = rs.getString("palomitas");
                String bebidas = rs.getString("bebidas");
                Boolean chuches = rs.getBoolean("chuches");
                Boolean alzadores = rs.getBoolean("alzadores");
                Double precio = rs.getDouble("precio");


                Reserva reserva = new Reserva(pelicula, horario, null, palomitas, bebidas, chuches, alzadores, precio);
                reservas.add(reserva);
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

        return reservas.toArray(new Reserva[0]);
    }


    public void guardarTodasLasReservas(Reserva[] reserva) {
        String url = "";
        String user = "";
        String password = "";

        String comprobarSiReservaYaExiste = "SELECT 1 FROM reservas WHERE pelicula = ?";
        String actualizarReserva = "UPDATE clientes SET horario = ?, palomitas = ?, bebidas = ?, chuches = ? , alzadores = ?, precio = ? WHERE pelicula = ?";
        String agregarNuevaReserva = "INSERT INTO reservas (pelicula, horario, palomitas, bebidas, chuches, alzadores, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String eliminarReservaObsoletas = "DELETE FROM reservas WHERE pelicula NOT IN (%s)";

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
            stmtCheck = conn.prepareStatement(comprobarSiReservaYaExiste);
            stmtUpdate = conn.prepareStatement(actualizarReserva);
            stmtInsert = conn.prepareStatement(agregarNuevaReserva);

            // Conjunto para almacenar todos los IDs proporcionados
            Set<String> nombresdados = new HashSet<>();

            for (Reserva reserva: reservas) {
            	nombresdados.add(reserva.getPelicula());

                // Verificar si la película ya existe
                stmtCheck.setString(1, reserva.getPelicula());
                try (ResultSet rs = stmtCheck.executeQuery()) {
                    if (rs.next()) {
                        // EXISTE -> proceder a actualizar
                        stmtUpdate.setString(1, reserva.getPelicula());
                        stmtUpdate.setString(2, reserva.getHorario());
                        stmtUpdate.setString(3, reserva.getPalommitas());
                        stmtUpdate.setString(4, reserva.getBebidas());
                        stmtUpdate.setBoolean(5, reserva.getChuches());
                        stmtUpdate.setBoolean(6, reserva.getAlzadores());
                        stmtUpdate.setDouble(7, reserva.getPrecio());


                        

                        stmtUpdate.executeUpdate();
                    } else {
                        // NO EXISTE -> proceder a insertar
                    	stmtUpdate.setString(1, reserva.getPelicula());
                        stmtUpdate.setString(2, reserva.getHorario());
                        stmtUpdate.setString(3, reserva.getPalommitas());
                        stmtUpdate.setString(4, reserva.getBebidas());
                        stmtUpdate.setBoolean(5, reserva.getChuches());
                        stmtUpdate.setBoolean(6, reserva.getAlzadores());
                        stmtUpdate.setDouble(7, reserva.getPrecio());

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

                String sqlDelete = String.format(eliminarReservaObsoletas, placeholders);
                stmtDelete = conn.prepareStatement(sqlDelete);

                int index = 1;
                for (String titulo : nombresdados) {
                    stmtDelete.setString(index++, titulo);
                }

                stmtDelete.executeUpdate();
            } else {
                String sqlDeleteAll = "DELETE FROM reservas";
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
