/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
             statement=c.prepareStatement("insert into estado values(?,?)");
             statement.setInt(1, entity.getId_estado());
             statement.setString(2, entity.getNombre());
                
            }
            else
            {
                statement=c.prepareStatement("update  estado set id_estado=?, nombre=? where id_estado=?");
                statement.setInt(1, entity.getId_estado());
                statement.setString(2, entity.getNombre());
                statement.setInt(3, entity.getId_estado());
            }
            exito = statement.execute();
            
            exito=true;
            c.close();
            
            
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
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=c.prepareStatement("delete from estado where id_estado=?");
            statement.setInt(1, entity.getId_estado());
            statement.execute();
            c.close();
           
        } 
        catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    @Override
    public estado findById(Object id) {
        estado entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select numero_documento, nombres,apellido1,apellido2, clave from funcionario where numero_documento=?"
                    );
            statement.setInt(1,(int)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                 entity = new estado();
                 entity.setId_estado(results.getInt(1));
                 entity.setNombre(results.getString(2));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;
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
        estadoDAO dao=new estadoDAO();
        //dao.save(a);
        //dao.delete(a);
        dao.findById(a);
    }
}