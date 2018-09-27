/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package mx.edu.ipn.cecyt9.edusite.utils;
 
/**
 *
 * @author Ciriaco
 */
import java.sql.*;
 
public class Conexion {
 
    private Connection conexion=null;
    private String servidor="";
    private String database="LABIII";
    private String usuario="root";
    private String password="n0m3l0";
    private String url="localhost:8080";
 
    public Conexion(String servidor, String database, String usuario, String password){
        try {
 
            this.servidor = servidor;
            this.database = database;
 
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            url="jdbc:mysql://"+servidor+"/"+database;
            conexion=DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
 
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
 
    public Connection getConexion(){
        return conexion;
    }
 
    public Connection cerrarConexion(){
        try {
            conexion.close();
             System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }
}