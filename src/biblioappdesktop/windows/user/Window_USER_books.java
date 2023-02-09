/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.user;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class Window_USER_books extends JFrame {
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelid;
    public JLabel labeltitolllibre;
    public JTextField textid;
    public JTextField textitol;
    public JButton botoafegirllibre;
    
    public Window_USER_books(){
         iniciarComponents();
    }
    
    
    private void setWindow() {
        this.setSize(800, 600);
        this.setTitle("Usuari - llibres");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/libro-abierto.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
    }
    
    private void setPanel() {
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 500, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
   
 
    
    private void iniciarComponents() {
        setWindow();
        setPanel();
        
        
    }
    
}
