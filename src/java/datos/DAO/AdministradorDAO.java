/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201
 */
public class AdministradorDAO implements DAOInterface<Administrador>{

    @Override
    public boolean save(Administrador entity) {
    String sql="";
         boolean exito = false;
        
                 
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getNumerodedocumento())==null) 
            {    
             statement=
                    c.prepareStatement("insert into Administrador values(?,?,?,?,?,?)");
            
                statement.setString(1, entity.getLogin());
                statement.setString(2, entity.getClave());
                statement.setString(3, entity.getNumerodedocumento());
                statement.setString(4, entity.getNombres());
                statement.setString(5, entity.getApellido1());
                statement.setString(6, entity.getApellido2());
            }
            else
            {
                statement=c.prepareStatement("update  administrador set Login=?, Clave=?,Numerodedocumento=?,nombres=?,apellido1=?,apellido2=? where numero_documento=?");
                statement.setString(1, entity.getLogin());
                statement.setString(2, entity.getClave());
                statement.setString(3, entity.getNumerodedocumento());
                statement.setString(4, entity.getNombres());
                statement.setString(5, entity.getApellido1());
                statement.setString(6, entity.getApellido2());
            }   statement.setString(7, entity.getNumerodedocumento());
            
            exito = statement.execute();
            
            exito=true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        
        return exito;
    }

    @Override
    public void delete(Administrador entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrador findById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Administrador> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public static void main(String args[])
{
    Administrador a=new Administrador();
    a.setLogin("frkid");
    a.setClave("123");
    a.setNumerodedocumento("1020805229");
    a.setNombres("jhonatan  ");
    a.setApellido1("montenegro");
    a.setApellido2("vargas");
}
    
}
