/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AutorList;
import biblioappdesktop.mappers.Missatge;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class Window_ADMIN_AUTORS_deleteAutor extends JFrame {
    
    App app = new App();

    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelIDautor;
    public JLabel imageautor;
    public JTextField textIDAutor;
    public JButton botoeliminarautor;
    public JButton botonetejacamps;
    public JComboBox comboboxID;
    private Vector vectorIDs;
    List<AutorList> autors;
    public JButton btnmostrarIDS;
    public JButton btnestablirID;
    
    String number;
    String number2;
    
    String tken;
    
    public Window_ADMIN_AUTORS_deleteAutor() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Eliminar Autor");
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
        labeltitol.setText("Eliminar autor");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelIDautor = new JLabel();
        labelIDautor.setText("ID de l'autor:");
        labelIDautor.setBounds(60, 50, 200, 100);
        labelIDautor.setForeground(Color.BLACK);
        labelIDautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIDautor);

        imageautor = new JLabel();
        imageautor.setBounds(480, 140, 140, 140);
        imageautor.setIcon(new ImageIcon("src/biblioappdesktop/img/editor.png"));
        panel.add(imageautor);
    }
    
    private void setTextField() {
        textIDAutor = new JTextField();
        textIDAutor.setBounds(160, 80, 140, 25);
        textIDAutor.setText("");
        textIDAutor.setToolTipText("Ha d'introduir el ID de l'autor");
        panel.add(textIDAutor);
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonDeleteAutor() {
        botoeliminarautor = new JButton();
        botoeliminarautor.setBounds(60, 300, 130, 40);
        botoeliminarautor.setForeground(Color.black);
        botoeliminarautor.setText("ELIMINAR");
        botoeliminarautor.setOpaque(true);
        botoeliminarautor.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoeliminarautor.setBackground(Color.WHITE);
        botoeliminarautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoeliminarautor);

        botoeliminarautor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JDialog.setDefaultLookAndFeelDecorated(true);

                int response = JOptionPane.showConfirmDialog(null, "Segur que vols eliminar l'autor?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {
                    String idllibre = textIDAutor.getText();

                    tken = app.getToken();

                    Missatge msg = ApiConnector.deleteAutor(tken, idllibre);

                    if (msg
                            != null) {
                        JOptionPane.showMessageDialog(null, "L'autor s'ha eliminat correctament");
                    } else {
                        JOptionPane.showMessageDialog(null, "L'autor no s'ha pogut eliminar");
                    }

                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }
            }
        });
    }
    
    /**
     *  Clear all jTextFields
     */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 300, 130, 40);
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
                textIDAutor.setText("");
            }
        });
    }
    
    private void setJcombo(){
        comboboxID = new JComboBox();
        comboboxID.setBounds(330, 80, 90, 25);
        panel.add(comboboxID);
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonEstablirId(){
        btnestablirID = new JButton();
        btnestablirID.setBounds(430, 130, 120, 30); 
        btnestablirID.setForeground(Color.black);
        btnestablirID.setBackground(Color.WHITE);
        btnestablirID.setText("Establir");
        btnestablirID.setBackground(Color.GRAY);
        btnestablirID.setToolTipText("Mostrar taula");
        panel.add(btnestablirID);

         btnestablirID.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                number = comboboxID.getSelectedItem().toString();
                number2 = number.replaceAll("[\\(\\)\\[\\]\\{\\}]", "");
                
                textIDAutor.setText(number2);
                
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void getusersID() {
        btnmostrarIDS = new JButton();
        btnmostrarIDS.setBounds(430, 75, 120, 30);
        btnmostrarIDS.setForeground(Color.black);
        btnmostrarIDS.setBackground(Color.WHITE);
        btnmostrarIDS.setText("Obtenir ID'S");
        btnmostrarIDS.setBackground(Color.GRAY);
        btnmostrarIDS.setToolTipText("Mostrar taula");
        panel.add(btnmostrarIDS);

        btnmostrarIDS.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tken = app.getToken();

                autors = ApiConnector.getAutors(tken);

                vectorIDs = new Vector();

                autors.forEach(a -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(a.getIdAutor());
                    vectorIDs.add(row);

                });

                Object[] arr = vectorIDs.toArray();

                for (int i = 0; i < vectorIDs.size(); i++) {

                    comboboxID.addItem(arr[i]);

                }
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
        setButtonDeleteAutor();
        setButtonclean();
        getusersID();
        setJcombo();
        setButtonEstablirId();
    }
    
}
