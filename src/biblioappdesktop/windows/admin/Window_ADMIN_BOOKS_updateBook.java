/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AddBook;
import biblioappdesktop.mappers.BookUpdate;
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
public class Window_ADMIN_BOOKS_updateBook extends JFrame {
    
    App app = new App();
    
    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labeltitolllibre;
    public JLabel labeldata;
    public JLabel labelcopies;
    public JLabel labelIDLlibre;
    public JLabel labelIDAutor;
    public JLabel labelIDCategoria;
    public JTextField texttitol;
    public JTextField textdata;
    public JTextField textcopies;
    public JTextField textIDLlibre;
    public JTextField textIDAutor;
    public JTextField textIDCategoria;
    public JButton botomodificarllibre;
    public JButton botonetejacamps;
    public JLabel imagellibre;
    private JDateChooser jdatechooser1;
    public JButton btnintroduirdata;
    
    String tken;
    
    public Window_ADMIN_BOOKS_updateBook() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Modificar llibre");
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
        panel.setBounds(0, 0, 500, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Modificar llibre");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labeltitolllibre = new JLabel();
        labeltitolllibre.setText("Títol llibre:");
        labeltitolllibre.setBounds(60, 50, 200, 100);
        labeltitolllibre.setForeground(Color.BLACK);
        labeltitolllibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltitolllibre);

        labeldata = new JLabel();
        labeldata.setText("Data publicació:");
        labeldata.setBounds(60, 90, 200, 100);
        labeldata.setForeground(Color.BLACK);
        labeldata.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldata);
        
        labelcopies = new JLabel();
        labelcopies.setText("Copies disponibles:");
        labelcopies.setBounds(60, 130, 200, 100);
        labelcopies.setForeground(Color.BLACK);
        labelcopies.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelcopies);
        
        labelIDAutor = new JLabel();
        labelIDAutor.setText("ID Autor:");
        labelIDAutor.setBounds(60, 170, 200, 100);
        labelIDAutor.setForeground(Color.BLACK);
        labelIDAutor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIDAutor);
        
        labelIDCategoria = new JLabel();
        labelIDCategoria.setText("ID Categoria:");
        labelIDCategoria.setBounds(60, 210, 200, 100);
        labelIDCategoria.setForeground(Color.BLACK);
        labelIDCategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIDCategoria);

        labelIDLlibre = new JLabel();
        labelIDLlibre.setText("ID Llibre:");
        labelIDLlibre.setBounds(60, 250, 200, 100);
        labelIDLlibre.setForeground(Color.BLACK);
        labelIDLlibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIDLlibre);
        
        jdatechooser1 = new JDateChooser();
        jdatechooser1.setBounds(360, 120, 100, 25);
        jdatechooser1.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser1);
        
        imagellibre = new JLabel();
        imagellibre.setBounds(450, 100, 280, 280);
        imagellibre.setIcon(new ImageIcon("src/biblioappdesktop/img/bookphoto.png"));
        panel.add(imagellibre);
    }
    
    private void setTextField() {
        texttitol = new JTextField();
        texttitol.setBounds(200, 80, 140, 25);
        texttitol.setText("");
        texttitol.setToolTipText("Ha d'introduir el títol del llibre");
        panel.add(texttitol);

        textdata = new JTextField();
        textdata.setBounds(200, 120, 140, 25);
        textdata.setText("");
        textdata.setToolTipText("Ha d'introduir la data de publicació");
        panel.add(textdata);
        
        textcopies = new JTextField();
        textcopies.setBounds(200, 160, 140, 25);
        textcopies.setText("");
        textcopies.setToolTipText("Ha d'introduir les copies disponibles");
        panel.add(textcopies);
        
        textIDAutor = new JTextField();
        textIDAutor.setBounds(200, 200, 140, 25);
        textIDAutor.setText("");
        textIDAutor.setToolTipText("Ha d'introduir el ID de l'autor");
        panel.add(textIDAutor);
        
        textIDCategoria = new JTextField();
        textIDCategoria.setBounds(200, 240, 140, 25);
        textIDCategoria.setText("");
        textIDCategoria.setToolTipText("Ha d'introduir el ID de la categoria");
        panel.add(textIDCategoria);
        
        textIDLlibre = new JTextField();
        textIDLlibre.setBounds(200, 280, 140, 25);
        textIDLlibre.setText("");
        textIDLlibre.setToolTipText("Ha d'introduir el ID del llibre que vol modificar");
        panel.add(textIDLlibre);

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonUpdateBook() {
        botomodificarllibre = new JButton();
        botomodificarllibre.setBounds(60, 360, 130, 40);
        botomodificarllibre.setForeground(Color.black);
        botomodificarllibre.setText("MODIFICAR");
        botomodificarllibre.setOpaque(true);
        botomodificarllibre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botomodificarllibre.setBackground(Color.WHITE);
        botomodificarllibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botomodificarllibre);

        botomodificarllibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                BookUpdate updatellibre = new BookUpdate();

                updatellibre.setTitulLlibre(texttitol.getText());
                updatellibre.setDataPublicacio(textdata.getText());
                updatellibre.setCopiesDisponibles(Integer.parseInt(textcopies.getText()));
                updatellibre.setIdAutor(Integer.parseInt(textIDAutor.getText()));
                updatellibre.setIdCategoria(Integer.parseInt(textIDCategoria.getText()));
                String ID = textIDLlibre.getText();

                tken = app.getToken();

                Missatge msg = ApiConnector.updateBook(tken, ID, updatellibre);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "El llibre s'ha actualitzat correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "El llibre no s'ha pogut actualitzar");
                }
            }
        });
    }
    
    /**
     *  Clear all jTextFields
     */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 360, 130, 40);
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
                textdata.setText("");
                textcopies.setText("");
                textIDAutor.setText("");
            }
        });
    }
    
    private void setbuttonDate() {
        btnintroduirdata = new JButton();
        btnintroduirdata.setBounds(480, 120, 120, 25);
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

                textdata.setText(df.format(jdatechooser1.getDate()));
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
        setbuttonDate();
    }
    
    
}
