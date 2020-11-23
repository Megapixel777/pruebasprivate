
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasUsuario extends Conexion {
    
    public boolean registrar(Usuario usu)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión
        
        String sql = "INSERT INTO usuarios (nombre, password, tipo, estado) VALUES (?, ?, ?, ?)";
        
        try
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getPassword());
            ps.setDouble(3, usu.getTipo());
            ps.setInt(4, usu.getEstado());
            ps.execute();
            return true;
    
            
        } catch (SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        
        }
    }
    
    
    public boolean modificar(Usuario usu)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión
        
            String sql = "UPDATE usuarios SET nombre=?, password=?, tipo=?, estado=? WHERE id=?";
        
        try
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            ps.setString(2, usu.getPassword());
            ps.setInt(3, usu.getTipo());
            ps.setInt(4, usu.getEstado());
            ps.setInt(5, usu.getId());
            ps.execute();
            return true;
    
            
        } catch (SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        
        }
    }
    
    public boolean eliminar(Usuario usu)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión
        
            String sql = "DELETE FROM usuarios WHERE id=?";
        
        try
        {
            ps=con.prepareStatement(sql);
            ps.setInt(1, usu.getId());
            ps.execute();
            return true;
    
            
        } catch (SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        
        }
    }
    public boolean buscar(Usuario usu)
    {
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con = getConexion();
        // Lo llamamos directamente ya que hereda conexión
        
            String sql = "SELECT * FROM usuarios WHERE nombre=?";
        
        try
        {
            ps=con.prepareStatement(sql);
            ps.setString(1, usu.getNombre());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                usu.setId(Integer.parseInt(rs.getString("id")));
                usu.setNombre(rs.getString("nombre"));
                usu.setPassword(rs.getString("password"));
                usu.setTipo(Integer.parseInt(rs.getString("tipo")));
                usu.setEstado(Integer.parseInt(rs.getString("estado")));
                return true;
                
            }
            return false;         
        } catch (SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        
        }
    }
}
