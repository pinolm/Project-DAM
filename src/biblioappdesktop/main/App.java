/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.main;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.windows.admin.Window_ADMIN_USERS;
import biblioappdesktop.windows.login.Window_LOGIN_ALL;
import biblioappdesktop.windows.admin.Window_MAIN_administrator;
import biblioappdesktop.windows.user.Window_MAIN_user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

/**
 *
 * @author Cristian
 */
public class App {
    
    public static String token;
    
    public String tkn;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Window_LOGIN_ALL loginFrame = new Window_LOGIN_ALL();
        loginFrame.setVisible(true);

        
        loginFrame.botoaccedir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String username = loginFrame.textfieldnomusuari.getText();
                String password = loginFrame.passwordfieldusuari.getText();

                token = ApiConnector.authenticate(username, password);
                              
                //Amaga finestra de login en cas de que la variable token no sigui buida
                if (!token.isEmpty()) {
                    loginFrame.setVisible(false);
                }

            }
            
        });
        
    }

    
    public  String getToken() {
        return token;
    }

    public  void setToken(String token) {
        App.token = token;
    }
    

    public String getTkn() {
        return tkn;
    }

    public void setTkn(String tkn) {
        this.tkn = tkn;
    }

  
    
    

    
    
    
    
}
