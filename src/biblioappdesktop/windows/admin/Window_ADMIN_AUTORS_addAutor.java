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
import com.toedter.calendar.JDateChooser;
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
public class Window_ADMIN_AUTORS_addAutor extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel imageautor;
    public JLabel labeltitol;
    public JLabel labelnomautor;
    public JTextField textnomautor;
    public JButton botoafegirautor;
    public JButton botonetejacamps;
    
    String tken;

    public Window_ADMIN_AUTORS_addAutor() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Alta Autor");
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
        panel.setBounds(0, 0, 700, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Afegir nou autor");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelnomautor = new JLabel();
        labelnomautor.setText("Nom del autor:");
        labelnomautor.setBounds(60, 50, 200, 100);
        labelnomautor.setForeground(Color.BLACK);
        labelnomautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelnomautor);

        
        imageautor = new JLabel();
        imageautor.setBounds(450, 5, 140, 140);
        imageautor.setIcon(new ImageIcon("src/biblioappdesktop/img/editor.png"));
        panel.add(imageautor);
    }
    
    private void setTextField() {
        textnomautor = new JTextField();
        textnomautor.setBounds(180, 80, 140, 25);
        textnomautor.setText("");
        textnomautor.setToolTipText("Ha d'introduir el nom de l'autor");
        panel.add(textnomautor);
               
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAddbook() {
        botoafegirautor = new JButton();
        botoafegirautor.setBounds(60, 220, 130, 40);
        botoafegirautor.setForeground(Color.black);
        botoafegirautor.setText("AFEGIR");
        botoafegirautor.setOpaque(true);
        botoafegirautor.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoafegirautor.setBackground(Color.WHITE);;
        botoafegirautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoafegirautor);

        botoafegirautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                Autor addautor = new Autor();
                
                addautor.setNom(textnomautor.getText());

                tken = app.getToken();

                Missatge msg = ApiConnector.addAutor(tken, addautor);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "L'autor s'ha afegit correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "L'autor no s'ha pogut afegir");
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
        setButtonAddbook();
        setButtonclean();
    }
}
