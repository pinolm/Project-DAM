/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.response;

import java.util.List;

/**
 *
 * @author Cristian
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserUpdateResponse {
    
    private int idUsuari;
    private String nomUsuari;
    private String contrasenya;
    private String email;
    private String nom;
    private String cognoms;
    private String telefon;
    private List<String> rols;
    
}
