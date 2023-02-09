/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AddBook;
import biblioappdesktop.mappers.Autor;
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
public class Window_ADMIN_AUTORS_updateAutor extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelnomautor;
    public JTextField textnomautor;
    public JLabel imageautor;
    public JLabel labelID;
    public JTextField textID;
    public JButton botomodificarautor;
    public JButton botonetejacamps;
    
    String tken;
    
    public Window_ADMIN_AUTORS_updateAutor() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Modificar autor");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/editor24.png");
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
        labeltitol.setText("Modificar autor");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);
        
        labelID = new JLabel();
        labelID.setText("ID de l'autor:");
        labelID.setBounds(60, 50, 200, 100);
        labelID.setForeground(Color.BLACK);
        labelID.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelID);

        labelnomautor = new JLabel();
        labelnomautor.setText("Nom del autor:");
        labelnomautor.setBounds(60, 100, 200, 100);
        labelnomautor.setForeground(Color.BLACK);
        labelnomautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnomautor);
      
        imageautor = new JLabel();
        imageautor.setBounds(450, 5, 140, 140);
        imageautor.setIcon(new ImageIcon("src/biblioappdesktop/img/editor.png"));
        panel.add(imageautor);
    }
     
    private void setTextField() {
        textID = new JTextField();
        textID.setBounds(180, 80, 140, 25);
        textID.setText("");
        textID.setToolTipText("Ha d'introduir el ID");
        panel.add(textID);
        
        textnomautor = new JTextField();
        textnomautor.setBounds(180, 130, 140, 25);
        textnomautor.setText("");
        textnomautor.setToolTipText("Ha d'introduir el nom de l'autor que vol modificar");
        panel.add(textnomautor);
               
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonUpdateBook() {
        botomodificarautor = new JButton();
        botomodificarautor.setBounds(60, 220, 130, 40);
        botomodificarautor.setForeground(Color.black);
        botomodificarautor.setText("MODIFICAR");
        botomodificarautor.setOpaque(true);
        botomodificarautor.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botomodificarautor.setBackground(Color.WHITE);
        botomodificarautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botomodificarautor);

        botomodificarautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Autor updateautor= new Autor();
                
                updateautor.setNom(textnomautor.getText());
                
                String ID = textID.getText();

                tken = app.getToken();

                Missatge msg = ApiConnector.updateAutor(tken, ID, updateautor);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "L'autor s'ha actualitzat correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "L'autor no s'ha pogut actualitzar");
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
                textnomautor.setText("");
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
        setButtonUpdateBook();
        setButtonclean();
    }
    
}
