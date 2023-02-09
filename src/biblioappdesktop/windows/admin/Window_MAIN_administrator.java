/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.windows.admin.Window_ADMIN_BOOKS;
import biblioappdesktop.windows.admin.Window_ADMIN_USERS;
import biblioappdesktop.windows.login.Window_LOGIN_ALL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cristian
 */
public class Window_MAIN_administrator extends JFrame{
    
    Window_ADMIN_USERS usersframe = new Window_ADMIN_USERS();
    Window_ADMIN_BOOKS booksframe = new Window_ADMIN_BOOKS();
    Window_LOGIN_ALL lgn = new Window_LOGIN_ALL();
    Window_ADMIN_CONFIG config = new Window_ADMIN_CONFIG();
    Window_ADMIN_PRESTECS prestecs = new Window_ADMIN_PRESTECS();
    Window_ADMIN_AUTORS autors = new Window_ADMIN_AUTORS();
    Window_ADMIN_CATEGORIES categoria = new Window_ADMIN_CATEGORIES();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JButton btnbooks;
    public JButton btnusers;
    public JButton btnautors;
    public JButton btnprestec;
    public JButton btnajustaments;
    public JButton btncategoria;
    public JLabel labeltitol;
    public JLabel labellibre;
    public JLabel labelusuaris;
    public JLabel labellectors;
    public JLabel labelprestecs;
    public JLabel labeldevolucions;
    public JLabel labelconfiguracio;
    
    
    public Window_MAIN_administrator(){
        
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow(){
        this.setSize(700, 600);
        this.setTitle(" BiblioApp - Administrador");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);     
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/book-main.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        
    }
    
    /**
    * This method set the panel in frame
    */
    private void setPanel(){
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 500, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setButtonbook() {
        btnbooks = new JButton();
        btnbooks.setBounds(60, 130, 120, 120);
        btnbooks.setForeground(Color.black);
        btnbooks.setBackground(Color.WHITE);    
        btnbooks.setIcon(new ImageIcon("src/biblioappdesktop/img/pila-de-libros.png"));
        btnbooks.setBackground(Color.GRAY);              
        btnbooks.setToolTipText("Permet gestionar els llibres");
        panel.add(btnbooks);

        btnbooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                booksframe.setVisible(true);
            }
        });
    }
    
    private void setButtonusers() {
        btnusers = new JButton();
        btnusers.setBounds(230, 130, 120, 120);
        btnusers.setForeground(Color.black);
        btnusers.setBackground(Color.WHITE);
        //btnusers.setText("Usuaris");             
        btnusers.setIcon(new ImageIcon("src/biblioappdesktop/img/add-user.png"));
        btnusers.setBackground(Color.GRAY);

        btnusers.setToolTipText("Permet gestionar els usuaris de la aplicació");
        panel.add(btnusers);

        btnusers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                usersframe.setVisible(true);
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAutors(){
        btnautors = new JButton();
        btnautors.setBounds(400, 130, 120, 120);
        btnautors.setForeground(Color.black);
        btnautors.setBackground(Color.WHITE);
        btnautors.setIcon(new ImageIcon("src/biblioappdesktop/img/escritor.png"));  
        btnautors.setBackground(Color.GRAY);
        btnautors.setToolTipText("Permet gestionar els autors");
        panel.add(btnautors);   
        
        btnautors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                autors.setVisible(true);
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonprestec(){
        btnprestec = new JButton();
        btnprestec.setBounds(60, 350, 120, 120);
        btnprestec.setForeground(Color.black);
        btnprestec.setBackground(Color.WHITE);
        btnprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/pedir-prestado.png")); 
        btnprestec.setBackground(Color.GRAY);
        btnprestec.setToolTipText("Permet gestionar els préstecs");
        panel.add(btnprestec);
        
        
        btnprestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                prestecs.setVisible(true);
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonCategories() {
        btncategoria = new JButton();
        btncategoria.setBounds(230, 350, 120, 120);
        btncategoria.setForeground(Color.black);
        btncategoria.setBackground(Color.WHITE);
        btncategoria.setIcon(new ImageIcon("src/biblioappdesktop/img/categoria.png"));
        btncategoria.setBackground(Color.GRAY);
        btncategoria.setToolTipText("Permet gestionar les categories");
        panel.add(btncategoria);

        btncategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                categoria.setVisible(true);
            }
        });
    }
     
    /**
    * This method set the specific button for panel
    */
    private void setButtonajustaments(){
        btnajustaments = new JButton();
        btnajustaments.setBounds(400, 350, 120, 120);
        btnajustaments.setForeground(Color.black);
        btnajustaments.setBackground(Color.WHITE);
        btnajustaments.setIcon(new ImageIcon("src/biblioappdesktop/img/configuraciones.png")); 
        btnajustaments.setBackground(Color.GRAY);
        btnajustaments.setToolTipText("Permet configurar");
        panel.add(btnajustaments);
        
        btnajustaments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                config.setVisible(true);
            }
        });
    }
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Panell d'administrador");
        labeltitol.setBounds(60, 0, 280, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 30));
        panel.add(labeltitol);
          
        labellibre = new JLabel();
        labellibre.setText("Llibres");
        labellibre.setBounds(60, 65, 200, 100);
        labellibre.setForeground(Color.BLACK);
        labellibre.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labellibre);
        
        labelusuaris = new JLabel();
        labelusuaris.setText("Usuaris");
        labelusuaris.setBounds(230, 65, 200, 100);
        labelusuaris.setForeground(Color.BLACK);
        labelusuaris.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labelusuaris);
        
        labellectors = new JLabel();
        labellectors.setText("Autors");
        labellectors.setBounds(400, 65, 200, 100);
        labellectors.setForeground(Color.BLACK);
        labellectors.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labellectors);
        
        labelprestecs = new JLabel();
        labelprestecs.setText("Préstecs");
        labelprestecs.setBounds(60, 285, 200, 100);
        labelprestecs.setForeground(Color.BLACK);
        labelprestecs.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labelprestecs);
        
        labeldevolucions = new JLabel();
        labeldevolucions.setText("Categories");
        labeldevolucions.setBounds(230, 285, 200, 100);
        labeldevolucions.setForeground(Color.BLACK);
        labeldevolucions.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labeldevolucions);
        
        labelconfiguracio = new JLabel();
        labelconfiguracio.setText("Configuració");
        labelconfiguracio.setBounds(400, 285, 200, 100);
        labelconfiguracio.setForeground(Color.BLACK);
        labelconfiguracio.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labelconfiguracio);
        
    }
        
    /**
    * This method initialize all methods 
    */ 
    private void iniciarComponents() {
        setWindow();
        setPanel();
        setButtonbook();
        setButtonusers();
        setButtonAutors();
        setButtonprestec();
        setButtonCategories();
        setButtonajustaments();
        setlabels();
    }
}
