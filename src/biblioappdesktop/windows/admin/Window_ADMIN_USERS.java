/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.Users;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cristian
 */
public class Window_ADMIN_USERS extends JFrame {

    //Constructors necessaris
    App app = new App();
    Window_ADMIN_USERS_addUser adduser = new Window_ADMIN_USERS_addUser();
    Window_ADMIN_USERS_updateUser updateuser = new Window_ADMIN_USERS_updateUser();
    Window_ADMIN_USERS_deleteUser deleteuser = new Window_ADMIN_USERS_deleteUser();

    //Elements visuals que conté el Frame
    public JTextArea jtextarea;
    public JPanel container;
    public JPanel panel;
    public JPanel pane2;
    public JLabel labeltitol;
    public JLabel labelinfodades;
    public JLabel labelllistat;
    public JLabel imageusuari;
    public JLabel labelafegirusuari;
    public JLabel labelmodificarusuari;
    public JLabel labeleliminarusuari;
    public JLabel labeltable;
    public JButton btnafegirusuari;
    public JButton btnmodificarusuari;
    public JButton btneliminarusuari;
    public JButton btnmostrartaula;
    public JButton btnamagartaula;
    public JButton botonetejacamps;

    private Vector fileVector;
    private Vector columnNames;
    public List<Users> users;
    public JTable table;
    public JScrollPane jscrollpne;

    String tken;

    public Window_ADMIN_USERS() {

        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(900, 800);
        this.setTitle("Admin - Usuaris");
        this.setResizable(false);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        ImageIcon ImageIcon = new ImageIcon("src/biblioappdesktop/img/users.png");
        Image image = ImageIcon.getImage();
        this.setIconImage(image);

    }

    /**
    * This method set the panel in frame
    */ 
    private void setPanel() {
        container = new JPanel();
        //container.setBorder(new TitledBorder(new LineBorder(Color.white), "Panell general", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        container.setBackground(Color.LIGHT_GRAY);
        container.setBounds(0, 0, 700, 800);
        container.setLayout(null);
        this.getContentPane().add(container);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.white), "Gestió de usuaris", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
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
    * This method set the specific button for panel
    */
    private void setButtonUserAdd() {
        btnafegirusuari = new JButton();
        btnafegirusuari.setBounds(520, 80, 80, 80);
        btnafegirusuari.setForeground(Color.black);
        btnafegirusuari.setBackground(Color.WHITE);
        btnafegirusuari.setIcon(new ImageIcon("src/biblioappdesktop/img/adduser.png"));
        btnafegirusuari.setBackground(Color.GRAY);
        btnafegirusuari.setToolTipText("Afegir usuaris");
        panel.add(btnafegirusuari);

        btnafegirusuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                adduser.setVisible(true);
            }
        });
    }

    /**
    * This method set the specific button for panel
    */
    private void setButtonUserUpdate() {
        btnmodificarusuari = new JButton();
        btnmodificarusuari.setBounds(620, 80, 80, 80);
        btnmodificarusuari.setForeground(Color.black);
        btnmodificarusuari.setBackground(Color.WHITE);
        btnmodificarusuari.setIcon(new ImageIcon("src/biblioappdesktop/img/updateuser.png"));
        btnmodificarusuari.setBackground(Color.GRAY);
        btnmodificarusuari.setToolTipText("Modificar usuaris");
        panel.add(btnmodificarusuari);

        btnmodificarusuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updateuser.setVisible(true);
            }
        });
    }

    /**
    * This method set the specific button for panel
    */
    private void setButtonUserDelete() {
        btneliminarusuari = new JButton();
        btneliminarusuari.setBounds(720, 80, 80, 80);
        btneliminarusuari.setForeground(Color.black);
        btneliminarusuari.setBackground(Color.WHITE);
        btneliminarusuari.setIcon(new ImageIcon("src/biblioappdesktop/img/deleteuser.png"));
        btneliminarusuari.setBackground(Color.GRAY);
        btneliminarusuari.setToolTipText("Eliminar usuaris");
        panel.add(btneliminarusuari);

        btneliminarusuari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                deleteuser.setVisible(true);
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
                columnNames.add("ID Usuari");
                columnNames.add("Nom Usuari");
                columnNames.add("Correu");
                columnNames.add("Nom");
                columnNames.add("Cognoms");
                columnNames.add("Telefon");
             
                users = ApiConnector.getUsers(tken);
                
                fileVector = new Vector();

                users.forEach(u -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(u.getIdUsuari());
                    row.add(u.getNomUsuari());
                    row.add(u.getEmail());
                    row.add(u.getNom());
                    row.add(u.getCognoms());
                    row.add(u.getTelefon());
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
    * This method set the text and image in jpanel
    */ 
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setBounds(120, 10, 330, 50);
        labeltitol.setIcon(new ImageIcon("src/biblioappdesktop/img/info.png"));
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltitol);

        jtextarea = new JTextArea("Aquesta finestra permet fer el manteniment de usuaris:\n \n - Afegir\n - Actualitzar\n - Eliminar\n - Visualitzar \n  \n Execepte visualitzar, la resta obrirà una nova finestra.");
        jtextarea.setBounds(160, 25, 340, 130);
        jtextarea.setEditable(false);
        jtextarea.setBackground(Color.LIGHT_GRAY);
        panel.add(jtextarea);

        labelafegirusuari = new JLabel();
        labelafegirusuari.setText("Afegir");
        labelafegirusuari.setBounds(520, 20, 100, 100);
        labelafegirusuari.setForeground(Color.BLACK);
        labelafegirusuari.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelafegirusuari);

        labelmodificarusuari = new JLabel();
        labelmodificarusuari.setText("Modificar");
        labelmodificarusuari.setBounds(620, 20, 100, 100);
        labelmodificarusuari.setForeground(Color.BLACK);
        labelmodificarusuari.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelmodificarusuari);

        labeleliminarusuari = new JLabel();
        labeleliminarusuari.setText("Eliminar");
        labeleliminarusuari.setBounds(720, 20, 100, 100);
        labeleliminarusuari.setForeground(Color.BLACK);
        labeleliminarusuari.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labeleliminarusuari);
        
        labeltable = new JLabel();
        labeltable.setText("TAULA AMB LA LLISTA DE TOTS ELS USUARIS:");
        labeltable.setBounds(20, 20, 350, 100);
        labeltable.setForeground(Color.BLACK);
        labeltable.setFont(new Font("Calibri", Font.PLAIN, 18));
        pane2.add(labeltable);

        imageusuari = new JLabel();
        imageusuari.setBounds(30, 50, 80, 80);
        imageusuari.setIcon(new ImageIcon("src/biblioappdesktop/img/man.png"));
        panel.add(imageusuari);          
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
        setButtonUserAdd();
        setButtonUserUpdate();
        setButtonUserDelete();
        setButtonShowTable();
        setButtonNOTVisibleTable();
    }

}
