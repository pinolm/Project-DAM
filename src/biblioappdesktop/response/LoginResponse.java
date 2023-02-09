/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.response;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class LoginResponse implements Serializable{
    
   String token;
   String bearer;
   String nomUsuari;
   Collection authorities;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public Collection getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection authorities) {
        this.authorities = authorities;
    }
   
   
    
}
