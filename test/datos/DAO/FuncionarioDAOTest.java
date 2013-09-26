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
            Conexion.getConexion().createStatement().execute("delete from funcionario where numero_documento='123456'");  
            Conexion.getConexion().createStatement().execute("delete from funcionario where numero_documento='45123112'");
            Conexion.getConexion().createStatement().execute("insert funcionario values('45123112','Pedro','Rodriguez','Dominguez','3333')");
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
        Funcionario entity = new Funcionario("123456","Juan","Ramirez","Pérez","1234");
        FuncionarioDAO instance = new FuncionarioDAO();
        if(!instance.save(entity))
        {
            fail("No se insertó el registro en la base");  
        }    
        try {
            results = Conexion.getConexion().createStatement().executeQuery("select * from funcionario where numero_documento='123456'");
            
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
    
    @Test
    public void testDelete() {
        System.out.println("delete");
        Funcionario entity = null;
        FuncionarioDAO instance = new FuncionarioDAO();
        entity = instance.findById("45123112");
        instance.delete(entity);
        assertEquals("Eliminar registro",instance.findById("45123112"),null);    
  
    }
    
    /**
     * Test of findById method, of class FuncionarioDAO.
     */
    
    @Test
    public void testFindById() {
        System.out.println("findById");
        String id = "45123112";
        FuncionarioDAO instance = new FuncionarioDAO();
        Funcionario expResult = null;
        
        Funcionario result = instance.findById(id);
        if(result==null) fail("No se encontró el registro");
                else{
        assertEquals("No se devolvió el dato correcto", result.getNumeroDocumento(),id);
        assertEquals("No se devolvió el dato correcto", result.getNombres(),"Pedro");
        assertEquals("No se devolvió el dato correcto", result.getApellido1(),"Rodriguez");
        assertEquals("No se devolvió el dato correcto", result.getApellido2(),"Dominguez");
        assertEquals("No se devolvió el dato correcto", result.getClave(),"3333");
        
        }
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class FuncionarioDAO.
     */
    
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Funcionario f1,f2,f3;
          FuncionarioDAO instance = new FuncionarioDAO();
     
        f1 = new Funcionario("44444","Catalina","Guitierrez","Caro","2222");
        f2 = new Funcionario("44445","Miguel","López","Tamayo","2222");
        f3 = new Funcionario("44446","Roberto","García","Triana","5555");
            instance.delete(f1);
        instance.delete(f2);
        instance.delete(f3);
      
        instance.save(f1);
        instance.save(f2);
        instance.save(f3);
      
        ArrayList result = instance.findAll();
        
        assertEquals(result.contains(f1), true);
        assertEquals(result.contains(f2), true);
        assertEquals(result.contains(f3), true);
        instance.delete(f1);
        instance.delete(f2);
        instance.delete(f3);
      
    }
    @Test
    public void saveUpdate()
    {
        System.out.println("saveUpdate");
         String id = "45123112";
         FuncionarioDAO instance = new FuncionarioDAO();
         Funcionario entity = instance.findById(id);
         entity.setNombres("otros");
         instance.save(entity);
         Funcionario entity2 = instance.findById(id);
         assertEquals("otros", entity2.getNombres());
         
    }
    
}