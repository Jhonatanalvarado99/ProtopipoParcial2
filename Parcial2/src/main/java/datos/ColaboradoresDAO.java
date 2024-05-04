/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.Colaboradores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kenph
 */
public class ColaboradoresDAO {
   
    private static final String SQL_SELECT = "SELECT id_colab, nombre_colab, apellido_colab, direccion_colab, telefono_colab FROM colaboradores";
    private static final String SQL_INSERT = "INSERT INTO colaboradores(id_colab, nombre_colab, apellido_colab, direccion_colab, telefono_colab ) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE colaboradores SET nombre_colab=?, apellido_colab=?, direccion_colab=?, telefono_paci=?  WHERE id_colab= ?";
    private static final String SQL_DELETE = "DELETE FROM colaboradores WHERE id_colab=?";
    private static final String SQL_QUERY = "SELECT id_colab, nombre_colab, apellido_colab, direccion_colab, telefono_colab FROM colaboradores WHERE id_colab = ?";

    public List<Colaboradores> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Colaboradores colaborador = null;
        List<Colaboradores> colaboradores = new ArrayList<Colaboradores>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("id_colab");
                String nombre = rs.getString("nombre_colab");
                String apellido = rs.getString("apellido_colab");
                String direccion = rs.getString("direccion_colab");
                String telefono = rs.getString("telefono_colab");
                
                
                colaborador = new Colaboradores();
                colaborador.setId_colab(codigo);
                colaborador.setNombre_colab(nombre);
                colaborador.setApellido_colab(apellido);
                colaborador.setDireccion_colab(direccion);
                colaborador.setTelefono_colab(telefono);
                
                colaboradores.add(colaborador);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return colaboradores;
    }

    public int insert(Colaboradores colaborador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, colaborador.getId_colab());
            stmt.setString(2, colaborador.getNombre_colab());
            stmt.setString(3, colaborador.getApellido_colab());
            stmt.setString(5, colaborador.getDireccion_colab());
            stmt.setString(6, colaborador.getTelefono_colab());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Colaboradores colaborador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, colaborador.getNombre_colab());
            stmt.setString(2, colaborador.getApellido_colab());
            stmt.setString(4, colaborador.getDireccion_colab());
            stmt.setString(5, colaborador.getTelefono_colab());
            stmt.setString(7, colaborador.getId_colab());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Colaboradores colaborador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, colaborador.getId_colab());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Colaboradores query(Colaboradores colaborador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, colaborador.getId_colab());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("id_colab");
                String nombre = rs.getString("nombre_colab");
                String apellido = rs.getString("apellido_colab");
                String direccion = rs.getString("direccion_colab");
                String telefono = rs.getString("telefono_colab");
                
                colaborador = new Colaboradores();
                colaborador.setId_colab(codigo);
                colaborador.setNombre_colab(nombre);
                colaborador.setApellido_colab(apellido);
                colaborador.setDireccion_colab(direccion);
                colaborador.setTelefono_colab(telefono);
        
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return colaborador;
    }
        
}
