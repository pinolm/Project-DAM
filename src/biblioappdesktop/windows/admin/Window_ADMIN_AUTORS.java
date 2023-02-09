/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AutorList;
import biblioappdesktop.mappers.Prestecs;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cristian
 */
public class Window_ADMIN_AUTORS extends JFrame {
    
    App app = new App();
    Window_ADMIN_AUTORS_addAutor afegirautor = new Window_ADMIN_AUTORS_addAutor();
    Window_ADMIN_AUTORS_updateAutor modificarautor = new Window_ADMIN_AUTORS_updateAutor();
    Window_ADMIN_AUTORS_deleteAutor eliminarautor = new Window_ADMIN_AUTORS_deleteAutor();
    
    //Elements visuals que conté el Frame
    public JTextArea jtextarea;
    public JPanel container;
    public JPanel panel;
    public JPanel pane2;
    public JButton btnafegirAutor;
    public JButton btnmodificarAutor;
    public JButton btneliminarAutor;
    public JLabel imageAutors;
    public JLabel labeltitol;
    public JLabel labelafegirAutor;
    public JLabel labelmodificarAutor;
    public JLabel labeleliminarAutor;
    public JLabel labeltable;
    public JButton btnmostrartaula;
    public JButton btnamagartaula;  
    private Vector fileVector;
    private Vector columnNames;
    public List<AutorList> autors;
    public JTable table;
    public JScrollPane jscrollpne;
    public JLabel labelinfodades;
    String tken;

    public Window_ADMIN_AUTORS() {

        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(900, 800);
        this.setTitle("Admin - Autors");
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
        
        container = new JPanel();
        container = new JPanel();
        //container.setBorder(new TitledBorder(new LineBorder(Color.white), "Panell general", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        container.setBackground(Color.LIGHT_GRAY);
        container.setBounds(0, 0, 700, 800);
        container.setLayout(null);
        this.getContentPane().add(container);
        
        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.white), "Gestió de autors", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(20, 20, 840, 200);
        panel.setLayout(null);      
        container.add(panel);
        
        pane2 = new JPanel();
        pane2.setBorder(new TitledBorder(new LineBorder(Color.white), "Visualització de dades", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        pane2.setBackground(Color.LIGHT_GRAY);
        pane2.setBounds(20, 250, 840, 420);
        pane2.setLayout(null);
        container.add(pane2);
        
    }
    
    /**
    * This method set the text and image in jpanel
    */ 
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setBounds(120, 10, 330, 50);
        labeltitol.setIcon(new ImageIcon("src/biblioappdesktop/img/info.png"));
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltitol);

        jtextarea = new JTextArea("Aquesta finestra permet fer el manteniment de autors:\n \n - Afegir\n - Actualitzar\n - Eliminar\n - Visualitzar \n  \n Execepte visualitzar, la resta obrirà una nova finestra.");
        jtextarea.setBounds(160, 25, 340, 130);
        jtextarea.setEditable(false);
        jtextarea.setBackground(Color.LIGHT_GRAY);
        panel.add(jtextarea);

        labelafegirAutor = new JLabel();
        labelafegirAutor.setText("Afegir");
        labelafegirAutor.setBounds(520, 20, 100, 100);
        labelafegirAutor.setForeground(Color.BLACK);
        labelafegirAutor.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelafegirAutor);

        labelmodificarAutor = new JLabel();
        labelmodificarAutor.setText("Modificar");
        labelmodificarAutor.setBounds(620, 20, 100, 100);
        labelmodificarAutor.setForeground(Color.BLACK);
        labelmodificarAutor.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelmodificarAutor);

        labeleliminarAutor= new JLabel();
        labeleliminarAutor.setText("Eliminar");
        labeleliminarAutor.setBounds(720, 20, 100, 100);
        labeleliminarAutor.setForeground(Color.BLACK);
        labeleliminarAutor.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labeleliminarAutor);
        
        labeltable = new JLabel();
        labeltable.setText("TAULA AMB LA LLISTA DE TOTS ELS AUTORS:");
        labeltable.setBounds(20, 20, 340, 100);
        labeltable.setForeground(Color.BLACK);
        labeltable.setFont(new Font("Calibri", Font.PLAIN, 18));
        pane2.add(labeltable);

        imageAutors = new JLabel();
        imageAutors.setBounds(30, 50, 80, 80);
        imageAutors.setIcon(new ImageIcon("src/biblioappdesktop/img/editor.png"));
        panel.add(imageAutors);
        
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAutorAdd() {
        btnafegirAutor = new JButton();
        btnafegirAutor.setBounds(520, 80, 80, 80);
        btnafegirAutor.setForeground(Color.black);
        btnafegirAutor.setBackground(Color.WHITE);
        btnafegirAutor.setIcon(new ImageIcon("src/biblioappdesktop/img/anadir1.png"));
        btnafegirAutor.setBackground(Color.GRAY);
        btnafegirAutor.setToolTipText("Afegir llibres");
        panel.add(btnafegirAutor);
        
        btnafegirAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                afegirautor.setVisible(true);
            }
        });
    }
        
    /**
    * This method set the specific button for panel
    */
    private void setButtonAutorUpdate() {
        btnmodificarAutor = new JButton();
        btnmodificarAutor.setBounds(620, 80, 80, 80);
        btnmodificarAutor.setForeground(Color.black);
        btnmodificarAutor.setBackground(Color.WHITE);
        btnmodificarAutor.setIcon(new ImageIcon("src/biblioappdesktop/img/editar1.png"));
        btnmodificarAutor.setBackground(Color.GRAY);
        btnmodificarAutor.setToolTipText("Modificar llibres");
        panel.add(btnmodificarAutor);
        
        btnmodificarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                modificarautor.setVisible(true);
            }
        });

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonAutorDelete() {
        btneliminarAutor = new JButton();
        btneliminarAutor.setBounds(720, 80, 80, 80);
        btneliminarAutor.setForeground(Color.black);
        btneliminarAutor.setBackground(Color.WHITE);
        btneliminarAutor.setIcon(new ImageIcon("src/biblioappdesktop/img/eliminar1.png"));
        btneliminarAutor.setBackground(Color.GRAY);
        btneliminarAutor.setToolTipText("Eliminar autors");
        panel.add(btneliminarAutor);

        btneliminarAutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               eliminarautor.setVisible(true);
            }
        });
       
    }
    
    /**
     * This method show the jtable with data when click in button in jpanel2
     */
    private void setButtonShowTable() {
        btnmostrartaula = new JButton();
        btnmostrartaula.setBounds(620, 20, 80, 30);
        btnmostrartaula.setForeground(Color.black);
        btnmostrartaula.setBackground(Color.WHITE);
        btnmostrartaula.setText("Mostrar");
        btnmostrartaula.setBackground(Color.GRAY);
        btnmostrartaula.setToolTipText("Mostrar taula");
        pane2.add(btnmostrartaula);

        btnmostrartaula.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tken = app.getToken();

                columnNames = new Vector();
                columnNames.add("ID Autor");
                columnNames.add("Nom Autor");
                
                autors = ApiConnector.getAutors(tken);

                fileVector = new Vector();

                autors.forEach(a -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(a.getIdAutor());
                    row.add(a.getNom());
                    fileVector.add(row);
                });

                table = new JTable(fileVector, columnNames);

                jscrollpne = new JScrollPane(table);
                jscrollpne.setBounds(10, 101, 800, 300);
                jscrollpne.setVisible(true);
                pane2.add(jscrollpne);
            }
        });
    }
    
    /**
     * This method hidden the Jtable
     */
    private void setButtonNOTVisibleTable() {
        btnamagartaula = new JButton();
        btnamagartaula.setBounds(720, 20, 80, 30);
        btnamagartaula.setForeground(Color.black);
        btnamagartaula.setBackground(Color.WHITE);
        btnamagartaula.setText("Ocultar");
        btnamagartaula.setBackground(Color.GRAY);
        btnamagartaula.setToolTipText("Oculta dades");
        pane2.add(btnamagartaula);

        btnamagartaula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                jscrollpne.setVisible(false);

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
        setButtonAutorAdd();
        setButtonAutorUpdate();
        setButtonAutorDelete();
        setButtonShowTable();
        setButtonNOTVisibleTable();
    }

}
