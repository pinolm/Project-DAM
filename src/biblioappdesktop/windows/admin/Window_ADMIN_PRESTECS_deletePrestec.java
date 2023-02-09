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
import biblioappdesktop.mappers.Prestecs;
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
public class Window_ADMIN_PRESTECS_deletePrestec extends JFrame {
    
    App app = new App();

    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelidPrestec;
    public JLabel labelisbn;
    public JLabel labeleditorial;
    public JLabel labeldescripcio;
    public JTextField textIDPrestec;
    public JTextField textisbn;
    public JTextField texteditorial;
    public JTextField textdescripcio;
    public JButton botoeliminarPrestec;
    public JButton botonetejacamps;
    public JLabel imagePrestec;
    
    public JComboBox comboboxID;
    private Vector vectorIDs;
    public List<Prestecs> prestecs;
    public JButton btnmostrarIDS;
    public JButton btnestablirID;
    
    String number;
    String number2;
    
    String tken;
    
    public Window_ADMIN_PRESTECS_deletePrestec() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Eliminar Préstec");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/prestamo.png");
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
        labeltitol.setText("Eliminar prestec");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelidPrestec = new JLabel();
        labelidPrestec.setText("ID del préstec:");
        labelidPrestec.setBounds(60, 50, 200, 100);
        labelidPrestec.setForeground(Color.BLACK);
        labelidPrestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidPrestec);

        imagePrestec = new JLabel();
        imagePrestec.setBounds(400, 380, 140, 140);
        imagePrestec.setIcon(new ImageIcon("src/biblioappdesktop/img/libroassign.png"));
        panel.add(imagePrestec);
    }
    
    private void setTextField() {
        textIDPrestec = new JTextField();
        textIDPrestec.setBounds(160, 80, 140, 25);
        textIDPrestec.setText("");
        textIDPrestec.setToolTipText("Ha d'introduir el ID del préstec");
        panel.add(textIDPrestec);
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonDeletePrestec() {
        botoeliminarPrestec = new JButton();
        botoeliminarPrestec.setBounds(60, 280, 130, 40);
        botoeliminarPrestec.setForeground(Color.black);
        botoeliminarPrestec.setText("ELIMINAR");
        botoeliminarPrestec.setOpaque(true);
        botoeliminarPrestec.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoeliminarPrestec.setBackground(Color.WHITE);
        botoeliminarPrestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoeliminarPrestec);

        botoeliminarPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JDialog.setDefaultLookAndFeelDecorated(true);

                int response = JOptionPane.showConfirmDialog(null, "Segur que vols eliminar el préstec?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {
                    String idPrestec = textIDPrestec.getText();

                    tken = app.getToken();

                    Missatge msg = ApiConnector.deletePrestec(tken, idPrestec);

                    if (msg
                            != null) {
                        JOptionPane.showMessageDialog(null, "El préstec s'ha eliminat correctament");
                    } else {
                        JOptionPane.showMessageDialog(null, "El préstec no s'ha pogut eliminar");
                    }

                } else if (response == JOptionPane.CLOSED_OPTION) {
                    System.out.println("JOptionPane closed");
                }
            }

        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 280, 130, 40);
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
                textIDPrestec.setText("");
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
                
              textIDPrestec.setText(number2);
                
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

                prestecs = ApiConnector.getPrestecs(tken);

                vectorIDs = new Vector();

                prestecs.forEach(a -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(a.getIdPrestec());
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
        setButtonDeletePrestec();
        setButtonclean();
        getusersID();
        setJcombo();
        setButtonEstablirId();
    }
    
}
