/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.login;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class Window_LOGIN_ALL extends JFrame {
    
    //Elements visuals que conté el Frame
    public JPanel panell;
    public JLabel labelusuari;
    public JLabel labelcontrasenya;
    public JLabel labelnomapp;
    public JLabel labelversion;
    public JButton botoaccedir;
    public JTextField textfieldnomusuari;
    public JPasswordField passwordfieldusuari;
    
    public Window_LOGIN_ALL(){
        setWindow();
        iniciarComponents();   
    }
    
    private void setWindow(){
        this.setSize(460, 400);
        this.setTitle("BiblioApp - Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);             
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/libro-abierto.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        
    }
    
    private void setPanel(){
       panell = new JPanel();     
       panell.setBackground(Color.lightGray);
       panell.setBounds(0, 0, 500, 600);
       panell.setLayout(null);
       this.getContentPane().add(panell);
              
       ImageIcon usericon = new ImageIcon("src/biblioappdesktop/img/user.png");
       JLabel imguser = new JLabel();
       imguser.setIcon(usericon);
       imguser.setBounds(30, 100, 100, 100);
       panell.add(imguser);
             
       ImageIcon passicon = new ImageIcon("src/biblioappdesktop/img/key.png");
       JLabel imgpass = new JLabel();
       imgpass.setIcon(passicon);
       imgpass.setBounds(30, 200, 100, 100);
       panell.add(imgpass);
    }
    
    private void setLabels(){
        
       labelnomapp = new JLabel();
       labelnomapp.setText("Panell d'autenticació");
       labelnomapp.setBounds(70, 0, 180, 100);
       labelnomapp.setForeground(Color.BLACK);
       labelnomapp.setFont(new Font("Calibri", Font.PLAIN, 20));
       panell.add(labelnomapp);
       
       labelusuari = new JLabel();
       labelusuari.setText("USUARI");
       labelusuari.setToolTipText("Ha d'introduir el nom d'usuari");
       labelusuari.setBounds(70, 60, 120, 100);
       labelusuari.setForeground(Color.BLACK);
       labelusuari.setFont(new Font("Calibri", Font.PLAIN, 16));
       panell.add(labelusuari);
       
       labelcontrasenya = new JLabel();
       labelcontrasenya.setText("CONTRASENYA");
       labelcontrasenya.setToolTipText("Ha d'introduir la contrasenya");
       labelcontrasenya.setBounds(70, 160, 120, 100);
       labelcontrasenya.setForeground(Color.BLACK);
       labelcontrasenya.setFont(new Font("Calibri", Font.PLAIN, 16));
       panell.add(labelcontrasenya);
             
       labelversion = new JLabel();
       labelversion.setText("Versió 1.0");
       labelversion.setBounds(300, 315, 100, 50);
       labelversion.setForeground(Color.BLACK);
       labelversion.setFont(new Font("Calibri", Font.PLAIN, 17));
       panell.add(labelversion);
    }
    
    private void setButton(){
        botoaccedir = new JButton();
        botoaccedir.setBounds(70, 300, 150, 50);
        botoaccedir.setForeground(Color.black);
        botoaccedir.setText("ACCEDIR");
        botoaccedir.setOpaque(true);
        botoaccedir.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoaccedir.setBackground(Color.GRAY);
        botoaccedir.setFont(new Font("Calibri", Font.PLAIN, 16));
        panell.add(botoaccedir);              
    }
    
    private void setTextField(){
        textfieldnomusuari = new JTextField();
        textfieldnomusuari.setBounds(70, 135, 250, 30);
        textfieldnomusuari.setText("");
        panell.add(textfieldnomusuari);       
    }
    
    private void setPasswordField(){
        passwordfieldusuari = new JPasswordField();
        passwordfieldusuari.setBounds(70, 235, 250, 30);
        passwordfieldusuari.setText("");
        panell.add(passwordfieldusuari);
    }
    
    private void iniciarComponents(){
        setPanel();
        setLabels();
        setButton();
        setTextField();
        setPasswordField();
    }
    
    
}
