/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camilo
 */
public class FuncionarioDAO implements DAOInterface<Funcionario>{

    @Override
    public boolean save(Funcionario entity) {
        String sql="";
         boolean exito = false;
        
           
        
        
       
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getNumeroDocumento())==null) 
            {    
             statement=
                    c.prepareStatement("insert into funcionario values(?,?,?,?,?)");
            
            statement.setString(1, entity.getNumeroDocumento());
            statement.setString(2, entity.getNombres());
            statement.setString(3, entity.getApellido1());
            statement.setString(4, entity.getApellido2());
            statement.setString(5, entity.getClave());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  funcionario set numero_documento=?, nombres=?,apellido1=?,apellido2=?,clave=? where numero_documento=?");
                  statement.setString(1, entity.getNumeroDocumento());
            statement.setString(2, entity.getNombres());
            statement.setString(3, entity.getApellido1());
            statement.setString(4, entity.getApellido2());
            statement.setString(5, entity.getClave());
            statement.setString(6, entity.getNumeroDocumento());
            }    
            
            exito = statement.execute();
            
            exito=true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        
        return exito;
    }

    @Override
    public void delete(Funcionario entity) {
            
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from funcionario where numero_documento=?");
            
            statement.setString(1, entity.getNumeroDocumento());
           
            
            statement.execute();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        
        
    }

   
    public Funcionario findById(Object id) {
            Funcionario entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select numero_documento, nombres,apellido1,apellido2, clave from funcionario where numero_documento=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                entity = new Funcionario();
                 entity.setNumeroDocumento(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setClave(results.getString(5));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;
    }

    @Override
    public ArrayList<Funcionario> findAll() {
        ArrayList<Funcionario> entities = new ArrayList<Funcionario>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select numero_documento, nombres,apellido1,apellido2, clave from funcionario"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 Funcionario entity = new Funcionario();
                 entity.setNumeroDocumento(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setClave(results.getString(5));
                 entities.add(entity);
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entities;
        
    }

    
}
