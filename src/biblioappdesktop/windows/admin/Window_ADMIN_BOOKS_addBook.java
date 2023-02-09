/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AddBook;
import biblioappdesktop.mappers.Missatge;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class Window_ADMIN_BOOKS_addBook extends JFrame {
    
    App app = new App();

    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labeltitolllibre;
    public JLabel labelisbn;
    public JLabel labeldatapublicacio;
    public JLabel labelcopies;
    public JLabel labeldescripcio;
    public JLabel labelIdAutor;
    public JLabel labelIdCategoria;
    public JTextField texttitol;
    public JTextField textdatapublicacio;
    public JTextField textcopies;
    public JTextField textIDAutor;
    public JTextField textIDCategoria;
    public JTextField textisbn;
    public JTextField textdescripcio;
    public JButton botoafegirllibre;
    public JLabel imagellibre;
    public JButton botonetejacamps;
    private JDateChooser jdatechooser1;
    public JButton btnintroduirdata;
    
    String tken;

    public Window_ADMIN_BOOKS_addBook() {
        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Alta llibre");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/libro-abierto.png");
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
        labeltitol.setText("Afegir nou llibre");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labeltitolllibre = new JLabel();
        labeltitolllibre.setText("Títol:");
        labeltitolllibre.setBounds(60, 50, 200, 100);
        labeltitolllibre.setForeground(Color.BLACK);
        labeltitolllibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltitolllibre);

        labelisbn = new JLabel();
        labelisbn.setText("ISBN:");
        labelisbn.setBounds(60, 90, 200, 100);
        labelisbn.setForeground(Color.BLACK);
        labelisbn.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelisbn);
        
        labeldatapublicacio = new JLabel();
        labeldatapublicacio.setText("Data publicació:");
        labeldatapublicacio.setBounds(60, 130, 200, 100);
        labeldatapublicacio.setForeground(Color.BLACK);
        labeldatapublicacio.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldatapublicacio);
        
        labelcopies = new JLabel();
        labelcopies.setText("Copies disponibles:");
        labelcopies.setBounds(60, 170, 200, 100);
        labelcopies.setForeground(Color.BLACK);
        labelcopies.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelcopies);
        
        labeldescripcio = new JLabel();
        labeldescripcio.setText("Descripció:");
        labeldescripcio.setBounds(60, 210, 200, 100);
        labeldescripcio.setForeground(Color.BLACK);
        labeldescripcio.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldescripcio);
        
        labelIdAutor = new JLabel();
        labelIdAutor.setText("ID Autor:");
        labelIdAutor.setBounds(60, 250, 200, 100);
        labelIdAutor.setForeground(Color.BLACK);
        labelIdAutor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIdAutor);
        
        labelIdCategoria = new JLabel();
        labelIdCategoria.setText("ID Categoria:");
        labelIdCategoria.setBounds(60, 290, 200, 100);
        labelIdCategoria.setForeground(Color.BLACK);
        labelIdCategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIdCategoria);
        
        jdatechooser1 = new JDateChooser();
        jdatechooser1.setBounds(380, 160, 100, 25);
        jdatechooser1.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser1);
        
        imagellibre = new JLabel();
        imagellibre.setBounds(450, 5, 140, 140);
        imagellibre.setIcon(new ImageIcon("src/biblioappdesktop/img/bookphoto.png"));
        panel.add(imagellibre);
    }

    private void setTextField() {
        texttitol = new JTextField();
        texttitol.setBounds(220, 80, 140, 25);
        texttitol.setText("");
        texttitol.setToolTipText("Ha d'introduir el títol del llibre");
        panel.add(texttitol);
        
        textisbn = new JTextField();
        textisbn.setBounds(220, 120, 140, 25);
        textisbn.setText("");
        textisbn.setToolTipText("Ha d'introduir el ISBN");
        panel.add(textisbn);

        textdatapublicacio = new JTextField();
        textdatapublicacio.setBounds(220, 160, 140, 25);
        textdatapublicacio.setText("");
        textdatapublicacio.setToolTipText("Ha d'introduir la data de publicació");
        panel.add(textdatapublicacio);
        
        textcopies = new JTextField();
        textcopies.setBounds(220, 200, 140, 25);
        textcopies.setText("");
        textcopies.setToolTipText("Ha d'introduir les copies disponibles");
        panel.add(textcopies);
        
        textdescripcio = new JTextField();
        textdescripcio.setBounds(220, 240, 140, 25);
        textdescripcio.setText("");
        textdescripcio.setToolTipText("Ha d'introduir una descripció");
        panel.add(textdescripcio);
        
        textIDAutor = new JTextField();
        textIDAutor.setBounds(220, 280, 140, 25);
        textIDAutor.setText("");
        textIDAutor.setToolTipText("Ha d'introduir el ID de l'autor");
        panel.add(textIDAutor);
        
        textIDCategoria = new JTextField();
        textIDCategoria.setBounds(220, 320, 140, 25);
        textIDCategoria.setText("");
        textIDCategoria.setToolTipText("Ha d'introduir el ID de la categoria");
        panel.add(textIDCategoria);
        
        
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAddbook() {
        botoafegirllibre = new JButton();
        botoafegirllibre.setBounds(60, 380, 130, 40);
        botoafegirllibre.setForeground(Color.black);
        botoafegirllibre.setText("AFEGIR");
        botoafegirllibre.setOpaque(true);
        botoafegirllibre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoafegirllibre.setBackground(Color.WHITE);;
        botoafegirllibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoafegirllibre);

        botoafegirllibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                AddBook addllibre = new AddBook();
                
                addllibre.setTitulLlibre(texttitol.getText());
                addllibre.setDataPublicacio(textdatapublicacio.getText());
                addllibre.setCopiesDisponibles(Integer.parseInt(textcopies.getText()));
                addllibre.setIsbn(textisbn.getText());
                addllibre.setDescripcio(textdescripcio.getText());
                addllibre.setIdAutor(Integer.parseInt(textIDAutor.getText()));
                addllibre.setIdCategoria(Integer.parseInt(textIDCategoria.getText()));

                tken = app.getToken();

                Missatge msg = ApiConnector.addBook(tken, addllibre);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "El llibre s'ha afegit correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "El llibre no s'ha pogut afegir");
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

                texttitol.setText("");
                textdatapublicacio.setText("");
                textcopies.setText("");
                textisbn.setText("");
                textdescripcio.setText("");
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setbuttonDate() {
        btnintroduirdata = new JButton();
        btnintroduirdata.setBounds(510, 160, 120, 25);
        btnintroduirdata.setForeground(Color.black);
        btnintroduirdata.setBackground(Color.WHITE);
        btnintroduirdata.setText("Establir data");
        btnintroduirdata.setBackground(Color.GRAY);
        btnintroduirdata.setToolTipText("Estableix la data");
        panel.add(btnintroduirdata);

        btnintroduirdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                 textdatapublicacio.setText(df.format(jdatechooser1.getDate()));

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
        setbuttonDate();
    }

}
