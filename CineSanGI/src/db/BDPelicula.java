package db;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Pelicula;

public class BDPelicula {
    private static BDPelicula instance;

    private BDPelicula() { }

    public static synchronized BDPelicula get() {
        if (instance == null) instance = new BDPelicula();
        return instance;
    }

    public Pelicula[] obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establecer la conexión
            String url = "";
            String user = "";
            String password = "";

            conn = DriverManager.getConnection(url, user, password);
            

//            // Crear una declaración
//            stmt = conn.createStatement();
//
//            // Ejecutar la consulta
//            String sql = "SELECT * FROM peliculas";
//            rs = stmt.executeQuery(sql);

            // Procesar el ResultSet
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String director = rs.getString("director");
                int anyoEstreno = rs.getInt("anyoEstreno");
                int edadRecomendada = rs.getInt("edadRecomendada");
                String logoPath = rs.getString("logoPath");

                Pelicula pelicula = new Pelicula(titulo, director, anyoEstreno, edadRecomendada, logoPath);
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
//                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return peliculas.toArray(new Pelicula[0]);
    }

    public void guardarTodasLasPeliculas(Pelicula[] peliculas) {
        String url = "";
        String user = "";
        String password = "";

        String comprobarSiPeliculaYaExiste = "SELECT 1 FROM peliculas WHERE titulo = ?";
        String actualizarPelicula = "UPDATE peliculas SET director = ?, anyoEstreno = ?, edadRecomendada = ?, logoPath = ? WHERE titulo = ?";
        String agregarNuevaPelicula = "INSERT INTO peliculas (titulo, director, anyoEstreno, edadRecomendada, logoPath) VALUES (?, ?, ?, ?, ?)";
        String eliminarPeliculasObsoletas = "DELETE FROM peliculas WHERE id NOT IN (%s)";

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
            stmtCheck = conn.prepareStatement(comprobarSiPeliculaYaExiste);
            stmtUpdate = conn.prepareStatement(actualizarPelicula);
            stmtInsert = conn.prepareStatement(agregarNuevaPelicula);

            // Conjunto para almacenar todos los IDs proporcionados
            Set<String> titulosDados = new HashSet<>();

            for (Pelicula pelicula : peliculas) {
            	titulosDados.add(pelicula.getTitulo());

                // Verificar si la película ya existe
                stmtCheck.setString(1, pelicula.getTitulo());
                try (ResultSet rs = stmtCheck.executeQuery()) {
                    if (rs.next()) {
                        // EXISTE -> proceder a actualizar
                        stmtUpdate.setString(1, pelicula.getTitulo());
                        stmtUpdate.setString(2, pelicula.getDirector());
                        stmtUpdate.setInt(3, pelicula.getAnyoEstreno());
                        stmtUpdate.setInt(4, pelicula.getEdadRecomendada());
                        stmtUpdate.setString(5, pelicula.getLogoPath());

                        stmtUpdate.executeUpdate();
                    } else {
                        // NO EXISTE -> proceder a insertar
                        stmtInsert.setString(1, pelicula.getTitulo());
                        stmtInsert.setString(2, pelicula.getDirector());
                        stmtInsert.setInt(3, pelicula.getAnyoEstreno());
                        stmtInsert.setInt(4, pelicula.getEdadRecomendada());
                        stmtInsert.setString(5, pelicula.getLogoPath());

                        stmtInsert.executeUpdate();
                    }
                }
            }

            if (!titulosDados.isEmpty()) {
                StringBuilder placeholders = new StringBuilder();
                for (int i = 0; i < titulosDados.size(); i++) {
                    placeholders.append("?");
                    if (i < titulosDados.size() - 1) {
                        placeholders.append(", ");
                    }
                }

                String sqlDelete = String.format(eliminarPeliculasObsoletas, placeholders);
                stmtDelete = conn.prepareStatement(sqlDelete);

                int index = 1;
                for (String titulo : titulosDados) {
                    stmtDelete.setString(index++, titulo);
                }

                stmtDelete.executeUpdate();
            } else {
                // Si no hay Titulos proporcionados, eliminar todas las películas
                String sqlDeleteAll = "DELETE FROM peliculas";
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
