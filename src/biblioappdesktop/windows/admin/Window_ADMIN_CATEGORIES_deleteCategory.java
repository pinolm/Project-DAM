/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AutorList;
import biblioappdesktop.mappers.CategoryList;
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
public class Window_ADMIN_CATEGORIES_deleteCategory extends JFrame {
    
    App app = new App();

    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelIDautor;
    public JLabel imageautor;
    public JTextField textIDCategoria;
    public JButton botoeliminarcategoria;
    public JButton botonetejacamps;
    
    public JComboBox comboboxID;
    private Vector vectorIDs;
    public List<CategoryList> categories;
    public JButton btnmostrarIDS;
    public JButton btnestablirID;
    
    String number;
    String number2;
    
    String tken;
    
    public Window_ADMIN_CATEGORIES_deleteCategory() {
        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Eliminar Categoria");
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
        labeltitol.setText("Eliminar categoria");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelIDautor = new JLabel();
        labelIDautor.setText("ID de la categoria:");
        labelIDautor.setBounds(60, 50, 200, 100);
        labelIDautor.setForeground(Color.BLACK);
        labelIDautor.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelIDautor);

        imageautor = new JLabel();
        imageautor.setBounds(450, 350, 140, 140);
        imageautor.setIcon(new ImageIcon("src/biblioappdesktop/img/categoria.png"));
        panel.add(imageautor);
    }
    
    private void setTextField() {
        textIDCategoria = new JTextField();
        textIDCategoria.setBounds(220, 80, 140, 25);
        textIDCategoria.setText("");
        textIDCategoria.setToolTipText("Ha d'introduir el ID de la categoria");
        panel.add(textIDCategoria);
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonDeleteCategoria() {
        botoeliminarcategoria = new JButton();
        botoeliminarcategoria.setBounds(60, 220, 130, 40);
        botoeliminarcategoria.setForeground(Color.black);
        botoeliminarcategoria.setText("ELIMINAR");
        botoeliminarcategoria.setOpaque(true);
        botoeliminarcategoria.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoeliminarcategoria.setBackground(Color.WHITE);
        botoeliminarcategoria.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoeliminarcategoria);

        botoeliminarcategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                JDialog.setDefaultLookAndFeelDecorated(true);

                int response = JOptionPane.showConfirmDialog(null, "Segur que vols eliminar la categoria?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.NO_OPTION) {
                    System.out.println("No button clicked");
                } else if (response == JOptionPane.YES_OPTION) {
                    String idcategoria = textIDCategoria.getText();

                    tken = app.getToken();

                    Missatge msg = ApiConnector.deleteCategory(tken, idcategoria);

                    if (msg
                            != null) {
                        JOptionPane.showMessageDialog(null, "La categoria s'ha eliminat correctament");
                    } else {
                        JOptionPane.showMessageDialog(null, "La categoria no s'ha pogut eliminar");
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
                textIDCategoria.setText("");
            }
        });
    }
    
    private void setJcombo(){
        comboboxID = new JComboBox();
        comboboxID.setBounds(400, 80, 90, 25);
        panel.add(comboboxID);
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonEstablirId(){
        btnestablirID = new JButton();
        btnestablirID.setBounds(500, 130, 120, 30); 
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
                
                textIDCategoria.setText(number2);
                
            }
        });
    }
    
    /**
    * This method set the specific button for panel
    */
    private void getusersID() {
        btnmostrarIDS = new JButton();
        btnmostrarIDS.setBounds(500, 75, 120, 30);
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

                categories = ApiConnector.getCategories(tken);

                vectorIDs = new Vector();

                categories.forEach(a -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(a.getIdCategoria());
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
        setButtonDeleteCategoria();
        setButtonclean();
        getusersID();
        setJcombo();
        setButtonEstablirId();
    }
    
}
