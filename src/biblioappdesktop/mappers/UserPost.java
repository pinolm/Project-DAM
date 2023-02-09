/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.mappers;


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
public class UserPost {

    private String nomUsuari;
    private String nom;
    private String email;
    private String contrasenya;
    private String cognoms;
    private String telefon;
    private List<String> rols;

}
