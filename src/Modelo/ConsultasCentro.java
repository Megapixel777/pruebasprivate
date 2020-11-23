package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasCentro extends Conexion {

    public boolean registrar(Centro cen) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión

        String sql = "INSERT INTO centros (id_administrador, nombre, max_procesamiento, max_cola) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cen.getId_administrador());
            ps.setString(2, cen.getNombre());
            ps.setFloat(3, cen.getMax_procesamiento());
            ps.setInt(4, cen.getMax_cola());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean modificar(Centro cen) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión

        String sql = "UPDATE centros SET id_administrador=?, nombre=?, max_procesamiento=?, max_cola=? WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cen.getId_administrador());
            ps.setString(2, cen.getNombre());
            ps.setFloat(3, cen.getMax_procesamiento());
            ps.setInt(4, cen.getMax_cola());
            ps.setInt(5, cen.getId());
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean eliminar(Centro cen) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión

        String sql = "DELETE FROM centros WHERE id=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cen.getId());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }

    public boolean buscar(Centro cen) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión

        String sql = "SELECT * FROM centros WHERE nombre=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cen.getNombre());
            rs = ps.executeQuery();

            if (rs.next()) {
                cen.setId(Integer.parseInt(rs.getString("id")));
                cen.setId_administrador(Integer.parseInt(rs.getString("id_administrador")));
                cen.setNombre(rs.getString("nombre"));
                cen.setMax_procesamiento(rs.getFloat("max_procesamiento"));
                cen.setMax_cola(rs.getInt("max_cola"));

                return true;

            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }
    }
}
