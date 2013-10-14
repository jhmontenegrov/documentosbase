/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

    
/**
 *
 * @author 201
 */
public class Administrador {
    private String login, clave, numerodedocumento, nombres, apellido1, apellido2;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNumerodedocumento() {
        return numerodedocumento;
    }

    public void setNumerodedocumento(String numerodedocumento) {
        this.numerodedocumento = numerodedocumento;
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
    


    @Override
    public String toString() {
        return "Administrador{" + "login=" + login + ", clave=" + clave + ", numerodedocumento=" + numerodedocumento + ", nombres=" + nombres + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + '}';
    }
        
    
}
