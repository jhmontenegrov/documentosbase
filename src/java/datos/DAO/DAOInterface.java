/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import java.util.ArrayList;

/**
 *
 * @author camilo
 */
public interface DAOInterface<T> {
      
public boolean save(T entity); 
public void delete(T entity); 
public T findById(Object id); 
public ArrayList<T> findAll(); 

    
}
