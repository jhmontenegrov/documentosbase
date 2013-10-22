/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.administrador;
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
public class administradorDAO implements DAOInterface<administrador>{

    @Override
    public boolean save(administrador entity) {
    String sql="";
         boolean exito = false;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getNumerodedocumento())==null) 
            {    
             statement=
                    c.prepareStatement("insert into administrador values(?,?,?,?,?,?)");
            
                statement.setString(1, entity.getLogin());
                statement.setString(2, entity.getClave());
                statement.setString(3, entity.getNumerodedocumento());
                statement.setString(4, entity.getNombres());
                statement.setString(5, entity.getApellido1());
                statement.setString(6, entity.getApellido2());
            }
            else
            {
                statement=c.prepareStatement("update  administrador set Login=?, Clave=?,Numerodedocumento=?,nombres=?,apellido1=?,apellido2=? where numerodedocumento=?");
                statement.setString(1, entity.getLogin());
                statement.setString(2, entity.getClave());
                statement.setString(3, entity.getNumerodedocumento());
                statement.setString(4, entity.getNombres());
                statement.setString(5, entity.getApellido1());
                statement.setString(6, entity.getApellido2());
               statement.setString(7, entity.getNumerodedocumento());
            }
            exito = statement.execute();
            
            exito=true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(administradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            exito=false;
        }
        
        return exito;
    }
    @Override
    public void delete(administrador entity) {
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from administrador where Numerodocumento=?");
            
            statement.setString(1, entity.getNumerodedocumento());
            statement.execute();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(administradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    @Override
    public administrador findById(Object id) {
        administrador entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select Numero_documento,nombres,apellido1,apellido2, clave,login=? from administrador where Numero_documento=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =  statement.executeQuery();
            if(results.next())
            {
                entity = new administrador();
                 entity.setNumerodedocumento(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setClave(results.getString(5));
                 entity.setLogin(results.getString(6));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(administradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entity;
    }
    @Override
    public ArrayList<administrador> findAll() {
        ArrayList<administrador> entities = new ArrayList<administrador>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select Numerodedocumento, nombres,apellido1,apellido2, clave,login from administrador"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                 administrador entity = new administrador();
                 entity.setNumerodedocumento(results.getString(1));
                 entity.setNombres(results.getString(2));
                 entity.setApellido1(results.getString(3));
                 entity.setApellido2(results.getString(4));
                 entity.setClave(results.getString(5));
                 entity.setLogin(results.getString(6));
                 entities.add(entity);
            }    
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(administradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        return entities;
        
    }
    
public static void main(String args[]){
    administrador x = null;
    administrador a=new administrador();
    a.setLogin("frid");
    a.setClave("145");
    a.setNumerodedocumento("302");
    a.setNombres("jhosdfjn  ");
    a.setApellido1("monsdfenegro");
    a.setApellido2("vardfas");
    administradorDAO dao=new administradorDAO();
    //dao.save(a);
    x=dao.findById("102");
    if(x==null){
            System.out.println("Se encontró a nadie con ese documento");
        }
        else{
            System.out.println(x);
        }
    //dao.delete(a);
    }
}
