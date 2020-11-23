package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    public static final String base = "viu21giin-pro";
    public static final String url = "jdbc:mysql://viu21giin-pro.cljklmoiofvy.us-east-1.rds.amazonaws.com:3306/" + base;
    public static final String username = "admin";
    public static final String password = "Abracadabr4";
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {

            System.out.println(e);
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
