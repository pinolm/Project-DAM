/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;
import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.Missatge;
import biblioappdesktop.mappers.UserPost;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class Window_ADMIN_USERS_addUser extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelnom;
    public JLabel labelcognom;
    public JLabel labeltelf;
    public JLabel labelemail;
    public JLabel labelnomusuari;
    public JLabel labelcontrasenya;
    public JLabel labelrol;
    public JTextField textnom;
    public JTextField textcognom;
    public JTextField textnomusuari;
    public JTextField textcontrasenya;
    public JTextField texttelf;
    public JTextField textemail;
    public JTextField textrol;
    public JButton botoafegirusuari;
    public JLabel imageusuari;
    public JButton botonetejacamps;
    public JButton botonestablircheckbox;
    public JCheckBox checkbox1;
    public JCheckBox checkbox2;
    
    String tken;
   
    public Window_ADMIN_USERS_addUser() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Alta usuari");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/users.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
    }
    
    /**
    * This method set the panel in frame
    */
    private void setPanel() {
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 700, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Afegir nou usuari");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);   
        
        labelnom = new JLabel();
        labelnom.setText("Nom:");
        labelnom.setBounds(60, 50, 200, 100);
        labelnom.setForeground(Color.BLACK);
        labelnom.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnom);
        
        labelcognom = new JLabel();
        labelcognom.setText("Cognom:");
        labelcognom.setBounds(60, 90, 200, 100);
        labelcognom.setForeground(Color.BLACK);
        labelcognom.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelcognom);
        
        labelemail = new JLabel();
        labelemail.setText("Email:");
        labelemail.setBounds(60, 130, 200, 100);
        labelemail.setForeground(Color.BLACK);
        labelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelemail);
        
        labeltelf = new JLabel();
        labeltelf.setText("Telèfon:");
        labeltelf.setBounds(60, 170, 200, 100);
        labeltelf.setForeground(Color.BLACK);
        labeltelf.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltelf);
        
        labelnomusuari = new JLabel();
        labelnomusuari.setText("Nom d'usuari:");
        labelnomusuari.setBounds(60, 210, 200, 100);
        labelnomusuari.setForeground(Color.BLACK);
        labelnomusuari.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnomusuari);
        
        labelcontrasenya = new JLabel();
        labelcontrasenya.setText("Contrasenya:");
        labelcontrasenya.setBounds(60, 250, 200, 100);
        labelcontrasenya.setForeground(Color.BLACK);
        labelcontrasenya.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelcontrasenya);
        
        labelrol = new JLabel();
        labelrol.setText("Rol:");
        labelrol.setBounds(60, 290, 200, 100);
        labelrol.setForeground(Color.BLACK);
        labelrol.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelrol);
              
        imageusuari = new JLabel();
        imageusuari.setBounds(380, 10, 280, 280);
        imageusuari.setIcon(new ImageIcon("src/biblioappdesktop/img/userphoto.png"));
        panel.add(imageusuari); 
    }
    
    private void setTextField() {
        textnom = new JTextField();
        textnom.setBounds(180, 80, 140, 25);
        textnom.setText("");
        textnom.setToolTipText("Ha d'introduir el nom");
        panel.add(textnom);

        textcognom = new JTextField();
        textcognom.setBounds(180, 120, 140, 25);
        textcognom.setText("");
        textcognom.setToolTipText("Ha d'introduir el cognom");
        panel.add(textcognom);
        
        textemail = new JTextField();
        textemail.setBounds(180, 160, 140, 25);
        textemail.setText("");
        textemail.setToolTipText("Ha d'introduir el correu");
        panel.add(textemail);
        
        texttelf = new JTextField();
        texttelf.setBounds(180, 200, 140, 25);
        texttelf.setText("");
        texttelf.setToolTipText("Ha d'introduir el telèfon");
        panel.add(texttelf);
        
        textnomusuari = new JTextField();
        textnomusuari.setBounds(180, 240, 140, 25);
        textnomusuari.setText("");
        textnomusuari.setToolTipText("Ha d'introduir el nom d'usuari");
        panel.add(textnomusuari);
        
        textcontrasenya = new JTextField();
        textcontrasenya.setBounds(180, 280, 140, 25);
        textcontrasenya.setText("");
        textcontrasenya.setToolTipText("Ha d'introduir la contrasenya");
        panel.add(textcontrasenya);
        
        textrol = new JTextField();
        textrol.setBounds(180, 320, 140, 25);
        textrol.setText("");
        textrol.setToolTipText("Ha d'introduir el rol que tindrà");
        panel.add(textrol);
    }
    
    private void setcheckbox(){
        checkbox1 = new JCheckBox();
        checkbox1.setText("Administrador");
        checkbox1.setBounds(340, 320, 110, 25);
        panel.add(checkbox1);
        
        checkbox2 = new JCheckBox();
        checkbox2.setText("Usuari");
        checkbox2.setBounds(470, 320, 80, 25);
        panel.add(checkbox2);
    }
    
    /**
    * This method set the specific button for panel
    */
    private void btnestablircheckbox() {
        botonestablircheckbox = new JButton();
        botonestablircheckbox.setBounds(580, 320, 90, 25);
        botonestablircheckbox.setText("ESTABLIR");
        botonestablircheckbox.setBackground(Color.GRAY);
        panel.add(botonestablircheckbox);

        botonestablircheckbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                if (checkbox1.isSelected()) {
                    textrol.setText("ADMIN");
                }
                if (checkbox2.isSelected()) {
                    textrol.setText("USER");
                }            
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAddUser() {
        botoafegirusuari = new JButton();
        botoafegirusuari.setBounds(60, 380, 130, 40);
        botoafegirusuari.setForeground(Color.black);
        botoafegirusuari.setText("AFEGIR");
        botoafegirusuari.setOpaque(true);
        botoafegirusuari.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoafegirusuari.setBackground(Color.WHITE);
        botoafegirusuari.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoafegirusuari);

        List<String> rols = new ArrayList();

        botoafegirusuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                UserPost up = new UserPost();
                up.setNom(textnom.getText());
                up.setNomUsuari(textnomusuari.getText());
                up.setEmail(textemail.getText());
                up.setContrasenya(textcontrasenya.getText());
                up.setCognoms(textcognom.getText());
                up.setTelefon(texttelf.getText());
                
                String role = textrol.getText();

                rols.add(role);

                up.setRols(rols);
                tken = app.getToken();

                Missatge msg = ApiConnector.createUser(tken, up);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "L'usuari s'ha afegit correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "L'usuari no s'ha pogut afegir");
                }
            }
        });
    }
    
    /**
     *  Clear all jTextFields
     */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 380, 130, 40);
        botonetejacamps.setForeground(Color.black);
        botonetejacamps.setIcon(new ImageIcon("src/biblioappdesktop/img/eraser.png"));
        botonetejacamps.setOpaque(true);
        botonetejacamps.setToolTipText("Elimina el text de tots els camps");
        botonetejacamps.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botonetejacamps.setBackground(Color.WHITE);
        botonetejacamps.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botonetejacamps);

        botonetejacamps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                textnomusuari.setText("");
                textnom.setText("");
                textemail.setText("");
                textcontrasenya.setText("");
                textrol.setText("");
                textcognom.setText("");
                texttelf.setText("");
            }
        });
    }
    
    /**
    * This method initialize all methods 
    */ 
    private void iniciarComponents() {
        setWindow();
        setPanel();
        setlabels();
        setTextField();
        setButtonAddUser();
        setButtonclean();
        setcheckbox();
        btnestablircheckbox();
    }
    
}
