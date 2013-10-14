/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import datos.DAO.FuncionarioDAO;
import datos.configuracion.Conexion;
import datos.entidades.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author camilo
 */
@WebServlet(name = "CFuncionario", urlPatterns = {"/CFuncionario"})
public class CFuncionario extends HttpServlet {
    private RequestDispatcher dispatcher;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        String accion = request.getParameter("a");
        try {
            if(Conexion.getConexion()==null)
                out.print("no se pudo establecer conexión");
            else
            {
                FuncionarioDAO fdao = new FuncionarioDAO();
                if (accion.equals("crear")){
                dispatcher= request.getRequestDispatcher("WEB-INF/funcionario/funcionariof.jsp");
                dispatcher.forward(request, response);
                }
                if (accion.equals("guardar")){
                    String nombre=request.getParameter("nombre");
                    String apellido1=request.getParameter("Apellido1");
                    String apellido2=request.getParameter("Apellido2");
                    String documento=request.getParameter("documento");
                    String clave=request.getParameter("clave");
                    Funcionario f=new Funcionario(nombre,apellido1,apellido2,documento,clave);
                    fdao.save(f);
                }
                if (accion.equals("Mostrartodos")){
                    ArrayList<Funcionario> funcionarios;
                    funcionarios =  fdao.findAll();
                    for(int i=0;i<funcionarios.size();i++)
                    {
                        out.println(funcionarios.get(i).getNombres()+" "+funcionarios.get(i).getApellido1());
                        out.println("<br>");
                    }
                    for(Funcionario f:funcionarios)
                    {
                    out.println(f.getNombres()+" "+f.getApellido1());
                    out.println("<br>");
                    }
                }
                if (accion.equals("borrar")){
                    String nombre=request.getParameter("nombre");
                    String apellido1=request.getParameter("Apellido1");
                    String apellido2=request.getParameter("Apellido2");
                    String documento=request.getParameter("documento");
                    String clave=request.getParameter("clave");
                    Funcionario f=new Funcionario(nombre,apellido1,apellido2,documento,clave);
                    fdao.delete(f);
                }
                /*
                Funcionario f = new Funcionario("123456789","Verónica","Reyes","Barrero","2223");
                
                fdao.save(f);
                 */
                /*
                Funcionario f = fdao.findById("123456789");
                if(f==null)
                {
                    out.print("No se encontró a ningún empleado con ese documento");
                    
                }   
                else
                {
                    out.println(f.getNombres());
                    out.println(f.getApellido1());
                    out.println(f.getApellido2());
                }    
                fdao.delete(f);
                 */
                                
                
            }
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
