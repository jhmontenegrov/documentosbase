/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.estado;
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
public class estadoDAO implements DAOInterface<estado>{

    @Override
    public boolean save(estado entity) {
        String sql="";
         boolean exito = false;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getId_estado())==null) 
            {    
             statement=
                    c.prepareStatement("insert into estado values(?,?)");
            
                statement.setInt(1, entity.getId_estado());
                statement.setString(2, entity.getNombre());
                
            }
            else
            {
                statement=c.prepareStatement("update  estado set id_estado=?, nombre=? where id_estado=?");
                statement.setInt(1, entity.getId_estado());
                statement.setString(2, entity.getNombre());
                statement.setInt(3, entity.getId_estado());
            
            exito = statement.execute();
            
            exito=true;
            c.close();
            }
            
        }
        catch (SQLException ex){
            Logger.getLogger(estadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        
        return exito;
    }

    @Override
    public void delete(estado entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public estado findById(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<estado> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String args[])
{
    estado a=new estado();
    a.setId_estado(1);
    a.setNombre("perdido");
    estado b=new estado();
    estadoDAO b=new estadoDAO(1,"");
    
}
}