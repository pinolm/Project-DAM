/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.UserUpdate;
import biblioappdesktop.response.UserUpdateResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class Window_ADMIN_USERS_updateUser extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelidusuari;
    public JLabel labelnomusuari;
    public JLabel labelnom;
    public JLabel labelemail;
    public JLabel labelcontrasenya;
    public JLabel labelcognoms;
    public JLabel labeltelefon;
    public JTextField textidusuari;
    public JTextField textnomusuari;
    public JTextField textnom;
    public JTextField textemail;
    public JTextField textcontrasenya;
    public JTextField textcognoms;
    public JTextField texttelefon;
    public JButton botomodificarusuari;
    public JButton botonetejacamps;
    public JLabel imageusuari;
    
    String tken;
    
    public Window_ADMIN_USERS_updateUser() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Modificar usuari");
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
        panel.setBounds(0, 0, 500, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Modificar usuari");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);   
        
        labelidusuari = new JLabel();
        labelidusuari .setText("Id de l'usuari:");
        labelidusuari .setBounds(60, 50, 200, 100);
        labelidusuari .setForeground(Color.BLACK);
        labelidusuari .setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidusuari);
        
        labelnomusuari = new JLabel();
        labelnomusuari.setText("Nom d'usuari:");
        labelnomusuari.setBounds(60, 90, 200, 100);
        labelnomusuari.setForeground(Color.BLACK);
        labelnomusuari.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnomusuari);
        
        labelnom = new JLabel();
        labelnom.setText("Nom:");
        labelnom.setBounds(60, 130, 200, 100);
        labelnom.setForeground(Color.BLACK);
        labelnom.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnom);
        
        labelemail = new JLabel();
        labelemail.setText("Email:");
        labelemail.setBounds(60, 170, 200, 100);
        labelemail.setForeground(Color.BLACK);
        labelemail.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelemail);
        
        labelcontrasenya = new JLabel();
        labelcontrasenya.setText("Contrasenya:");
        labelcontrasenya.setBounds(60, 210, 200, 100);
        labelcontrasenya.setForeground(Color.BLACK);
        labelcontrasenya.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelcontrasenya);
        
        labelcognoms = new JLabel();
        labelcognoms.setText("Cognoms:");
        labelcognoms.setBounds(60, 250, 200, 100);
        labelcognoms.setForeground(Color.BLACK);
        labelcognoms.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelcognoms);
        
        labeltelefon = new JLabel();
        labeltelefon.setText("Telf:");
        labeltelefon.setBounds(60, 290, 200, 100);
        labeltelefon.setForeground(Color.BLACK);
        labeltelefon.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltelefon);
        
        imageusuari = new JLabel();
        imageusuari.setBounds(380, 10, 280, 280);
        imageusuari.setIcon(new ImageIcon("src/biblioappdesktop/img/userphoto.png"));
        panel.add(imageusuari);
        
    }
    
    private void setTextField() {
        textidusuari = new JTextField();
        textidusuari.setBounds(160, 80, 140, 25);
        textidusuari.setText("");
        textidusuari.setToolTipText("Ha d'introduir el ID de l'usuari");
        panel.add(textidusuari);
        
        textnomusuari = new JTextField();
        textnomusuari.setBounds(160, 120, 140, 25);
        textnomusuari.setText("");
        textnomusuari.setToolTipText("Ha d'introduir el nom d'usuari");
        panel.add(textnomusuari);
        
        textnom = new JTextField();
        textnom.setBounds(160, 160, 140, 25);
        textnom.setText("");
        textnom.setToolTipText("Ha d'introduir el nom de la personsa");
        panel.add(textnom);
             
        textemail = new JTextField();
        textemail.setBounds(160, 200, 140, 25);
        textemail.setText("");
        textemail.setToolTipText("Ha d'introduir el email");
        panel.add(textemail);
        
        textcontrasenya = new JTextField();
        textcontrasenya.setBounds(160, 240, 140, 25);
        textcontrasenya.setText("");
        textcontrasenya.setToolTipText("Ha d'introduir la contrasenya");
        panel.add(textcontrasenya);
        
        textcognoms = new JTextField();
        textcognoms.setBounds(160, 280, 140, 25);
        textcognoms.setText("");
        textcognoms.setToolTipText("Ha d'introduir el cognom");
        panel.add(textcognoms);
        
        texttelefon = new JTextField();
        texttelefon.setBounds(160, 320, 140, 25);
        texttelefon.setText("");
        texttelefon.setToolTipText("Ha d'introduir el telf");
        panel.add(texttelefon);

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonUpdateUser() {
        botomodificarusuari = new JButton();
        botomodificarusuari.setBounds(60, 400, 130, 40);
        botomodificarusuari.setForeground(Color.black);
        botomodificarusuari.setText("MODIFICAR");
        botomodificarusuari.setOpaque(true);
        botomodificarusuari.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botomodificarusuari.setBackground(Color.WHITE);
        botomodificarusuari.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botomodificarusuari);
        
        botomodificarusuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                int idusuari = Integer.parseInt(textidusuari.getText());
   
                String ID = textidusuari.getText();
                
                UserUpdate updateuser = new UserUpdate();
                
		updateuser.setNomUsuari(textnomusuari.getText());
                updateuser.setNom(textnom.getText());
                updateuser.setEmail(textemail.getText());
                updateuser.setContrasenya(textcontrasenya.getText());
                updateuser.setCognoms(textcognoms.getText());
                updateuser.setTelefon(texttelefon.getText());
                   
		tken = app.getToken();		
	              
		String usr =  ApiConnector.updateUser(tken, ID, updateuser);
            }    
        });       
    }
    
    /**
     *  Clear all jTextFields
     */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 400, 130, 40);
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
                textidusuari.setText("");
                textnomusuari.setText("");
                textnom.setText("");
                textemail.setText("");
                textcontrasenya.setText("");
                textcognoms.setText("");
                texttelefon.setText("");
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
        setButtonUpdateUser();
        setButtonclean();
    }
    
}
