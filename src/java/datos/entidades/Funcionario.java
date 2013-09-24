/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

/**
 *
 * @author camilo
 */
public class Funcionario {
    private String numeroDocumento;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String clave;

    public Funcionario(String numeroDocumento, String nombres, String apellido1, String apellido2, String clave) {
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.clave = clave;
    }
    public Funcionario()
    {
        
    }

    @Override
    public String toString() {
        return "Funcionario{" + "numeroDocumento=" + numeroDocumento + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", clave=" + clave + '}';
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
