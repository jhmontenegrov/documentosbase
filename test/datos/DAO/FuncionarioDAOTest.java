/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author camilo
 */
public class FuncionarioDAOTest {
    
    public FuncionarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
          try {
            Conexion.getConexion().createStatement().execute("delete from funcionario where numero_documento='45123112'");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        
        try {
            Conexion.getConexion().createStatement().execute("delete from funcionario where numero_documento='45123112'");
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Test of save method, of class FuncionarioDAO.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        ResultSet results;
        Funcionario entity = new Funcionario("45123112","Juan","Ramirez","Pérez","1234");
        FuncionarioDAO instance = new FuncionarioDAO();
        if(!instance.save(entity))
        {
            fail("No se insertó el registro en la base");  
        }    
        try {
            results = Conexion.getConexion().createStatement().executeQuery("select * from funcionario where numero_documento='45123112'");
            
                if(results.next()==false) 
                { System.out.println("    failed ");
                fail("No se insertó el registro en la base");
                }
                else
                {    
                assertEquals("dato insertado",results.getString("numero_documento"),entity.getNumeroDocumento());
                }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
       
        
      
    }

    /**
     * Test of delete method, of class FuncionarioDAO.
     */
    /*
    @Test
    public void testDelete() {
        System.out.println("delete");
        Funcionario entity = null;
        FuncionarioDAO instance = new FuncionarioDAO();
        instance.delete(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class FuncionarioDAO.
     */
    /*
    @Test
    public void testFindById() {
        System.out.println("findById");
        Object id = null;
        FuncionarioDAO instance = new FuncionarioDAO();
        Funcionario expResult = null;
        Funcionario result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class FuncionarioDAO.
     */
    /*
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        FuncionarioDAO instance = new FuncionarioDAO();
        ArrayList expResult = null;
        ArrayList result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    * */
}