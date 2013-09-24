/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilo
 */
public  class Conexion {
   // static private String url="jdbc:mysql://";
    static private String url="jdbc:postgresql://";
    static private String host="localhost";
    static private String clave="root";
    //static private String usuario="root";
    static private String usuario="postgres";
    static private String db="documentos";
    private static Connection conexion=null;
    public static Connection getConexion()
    {
        
        try {
            
            conexion =
       DriverManager.getConnection(url+host+"/"+db,usuario,clave);
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }
            
    public static void main(String args[])
    {
        if(Conexion.getConexion()!=null)
        {
            System.out.println("conexión establecida");
        }
        else
        {
           System.out.println("No se pudo establecer conexión"); 
        }   
            
    }
}
