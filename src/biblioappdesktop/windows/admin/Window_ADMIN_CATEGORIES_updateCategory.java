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
public class Window_ADMIN_CATEGORIES_updateCategory extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelnomautor;
    public JTextField textnomcategoria;
    public JLabel imageautor;
    public JLabel labelID;
    public JTextField textID;
    public JButton botomodificarcategoria;
    public JButton botonetejacamps;
    
    String tken;
    
    public Window_ADMIN_CATEGORIES_updateCategory() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Modificar categoria");
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
        panel.setBounds(0, 0, 500, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Modificar categoria");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);
        
        labelID = new JLabel();
        labelID.setText("ID:");
        labelID.setBounds(60, 50, 200, 100);
        labelID.setForeground(Color.BLACK);
        labelID.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelID);

        labelnomautor = new JLabel();
        labelnomautor.setText("Nom de la categoria:");
        labelnomautor.setBounds(60, 100, 200, 100);
        labelnomautor.setForeground(Color.BLACK);
        labelnomautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnomautor);
      
        imageautor = new JLabel();
        imageautor.setBounds(450, 5, 140, 140);
        imageautor.setIcon(new ImageIcon("src/biblioappdesktop/img/categoria.png"));
        panel.add(imageautor);
    }
    
    private void setTextField() {
        textID = new JTextField();
        textID.setBounds(220, 80, 140, 25);
        textID.setText("");
        textID.setToolTipText("Ha d'introduir el ID");
        panel.add(textID);
        
        textnomcategoria = new JTextField();
        textnomcategoria.setBounds(220, 130, 140, 25);
        textnomcategoria.setText("");
        textnomcategoria.setToolTipText("Ha d'introduir el nom de la categoria que vol modificar");
        panel.add(textnomcategoria);              
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonUpdateCategory() {
        botomodificarcategoria = new JButton();
        botomodificarcategoria.setBounds(60, 220, 130, 40);
        botomodificarcategoria.setForeground(Color.black);
        botomodificarcategoria.setText("MODIFICAR");
        botomodificarcategoria.setOpaque(true);
        botomodificarcategoria.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botomodificarcategoria.setBackground(Color.WHITE);
        botomodificarcategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botomodificarcategoria);

        botomodificarcategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Category updatecategory= new Category();
                
                updatecategory.setNomCategoria(textnomcategoria.getText());
                
                String ID = textID.getText();

                tken = app.getToken();

                Missatge msg = ApiConnector.updateCategoria(tken, ID, updatecategory);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "La categoria s'ha actualitzat correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "La categoria no s'ha pogut actualitzar");
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
                textID.setText("");
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
        setButtonUpdateCategory();
        setButtonclean();
    }
    
}
