/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.Autor;
import biblioappdesktop.mappers.Category;
import biblioappdesktop.mappers.Missatge;
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
public class Window_ADMIN_CATEGORIES_addCategory extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel imagecategoria;
    public JLabel labeltitol;
    public JLabel labelnomcategoria;
    public JTextField textnomcategoria;
    public JButton botoafegircategoria;
    public JButton botonetejacamps;
    
    String tken;
    
    public Window_ADMIN_CATEGORIES_addCategory() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Alta Categoria");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/category24.png");
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
        labeltitol.setText("Afegir nova categoria");
        labeltitol.setBounds(60, 0, 240, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelnomcategoria = new JLabel();
        labelnomcategoria.setText("Nom de la categoria:");
        labelnomcategoria.setBounds(60, 50, 200, 100);
        labelnomcategoria.setForeground(Color.BLACK);
        labelnomcategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnomcategoria);

        
        imagecategoria = new JLabel();
        imagecategoria.setBounds(450, 5, 140, 140);
        imagecategoria.setIcon(new ImageIcon("src/biblioappdesktop/img/categoria.png"));
        panel.add(imagecategoria);
    }
    
    private void setTextField() {
        textnomcategoria = new JTextField();
        textnomcategoria.setBounds(220, 80, 140, 25);
        textnomcategoria.setText("");
        textnomcategoria.setToolTipText("Ha d'introduir el nom de la categoria");
        panel.add(textnomcategoria);
               
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAddCategoria() {
        botoafegircategoria = new JButton();
        botoafegircategoria.setBounds(60, 220, 130, 40);
        botoafegircategoria.setForeground(Color.black);
        botoafegircategoria.setText("AFEGIR");
        botoafegircategoria.setOpaque(true);
        botoafegircategoria.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoafegircategoria.setBackground(Color.WHITE);;
        botoafegircategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoafegircategoria);

        botoafegircategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Category addcategory = new Category();
                
                addcategory.setNomCategoria(textnomcategoria.getText());

                tken = app.getToken();

                Missatge msg = ApiConnector.addCategoria(tken, addcategory);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "La categoria s'ha afegit correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "La categoria no s'ha pogut afegir");
                }
            }
        });
    }
    
    /**
     *  Clear all jTextFields
     */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 220, 130, 40);
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

                textnomcategoria.setText("");

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
        setButtonAddCategoria();
        setButtonclean();
    }
    
}
