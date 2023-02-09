/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.user;

import biblioappdesktop.windows.admin.Window_ADMIN_BOOKS;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Cristian
 */
public class Window_MAIN_user extends JFrame{
    
    Window_USER_books framebookuser = new Window_USER_books();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JButton btnbooks;
    public JButton btnprestec;
    public JButton btndevolucions;
    public JButton btnajustaments;
    public JLabel labeltitol;   
    public JLabel labellibre;
    public JLabel labelprestecs;
    public JLabel labeldevolucions;
    public JLabel labelconfiguracio;
    
    public Window_MAIN_user(){
        iniciarComponents();
    }
    
    private void setWindow(){
        this.setSize(600, 630);
        this.setTitle("BiblioApp - Usuari");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);   
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/book-main.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
    }
    
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
                framebookuser.setVisible(true);
            }
        });
        
        
    }
    
    private void setButtonprestec(){
        btnprestec = new JButton();
        btnprestec.setBounds(60, 350, 120, 120);
        btnprestec.setForeground(Color.black);
        btnprestec.setBackground(Color.WHITE);
        btnprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/pedir-prestado.png")); 
        btnprestec.setBackground(Color.GRAY);
        btnprestec.setToolTipText("Permet gestionar els préstecs");
        panel.add(btnprestec);
    }

    private void setButtondevolucio(){
        btndevolucions = new JButton();
        btndevolucions.setBounds(230, 130, 120, 120); 
        btndevolucions.setForeground(Color.black);
        btndevolucions.setBackground(Color.WHITE);
        btndevolucions.setIcon(new ImageIcon("src/biblioappdesktop/img/devolucion.png")); 
        btndevolucions.setBackground(Color.GRAY);
        btndevolucions.setToolTipText("Permet gestionar les devolucions");
        panel.add(btndevolucions);
    }
    
    private void setButtonajustaments(){
        btnajustaments = new JButton();
        btnajustaments.setBounds(230, 350, 120, 120);
        btnajustaments.setForeground(Color.black);
        btnajustaments.setBackground(Color.WHITE);
        btnajustaments.setIcon(new ImageIcon("src/biblioappdesktop/img/configuraciones.png"));
        btnajustaments.setBackground(Color.GRAY);
        btnajustaments.setToolTipText("Permet configurar");
        panel.add(btnajustaments);
    }
    
    private void setlabels(){
        labeltitol = new JLabel();
        labeltitol.setText("Panell d'usuari");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labeltitol);
        
        labellibre = new JLabel();
        labellibre.setText("Catàleg");
        labellibre.setBounds(60, 65, 200, 100);
        labellibre.setForeground(Color.BLACK);
        labellibre.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(labellibre);
        
    }
    
    
    private void iniciarComponents(){      
        setWindow();
        setPanel();
        setButtonbook();
        setButtonprestec();
        setButtondevolucio();
        setButtonajustaments();
        setlabels();
    }
    
}
