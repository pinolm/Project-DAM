/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.request;

import java.io.Serializable;

/**
 *
 * @author Cristian
 */
public class LoginRequest implements Serializable {
    
    private String nomUsuari;
    private String contrasenya;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.nomUsuari = username;
        this.contrasenya = password;
    }

    public String getUsername() {
        return nomUsuari;
    }

    public void setUsername(String username) {
        this.nomUsuari = username;
    }

    public String getPassword() {
        return contrasenya;
    }

    public void setPassword(String password) {
        this.contrasenya = password;
    }
    
}
