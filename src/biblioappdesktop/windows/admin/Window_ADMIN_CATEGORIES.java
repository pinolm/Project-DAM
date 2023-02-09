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
public class Window_ADMIN_CATEGORIES extends JFrame {
    
    App app = new App();
    Window_ADMIN_CATEGORIES_addCategory addCategoria = new Window_ADMIN_CATEGORIES_addCategory();
    Window_ADMIN_CATEGORIES_updateCategory updateCategoria = new Window_ADMIN_CATEGORIES_updateCategory();
    Window_ADMIN_CATEGORIES_deleteCategory deleteCategoria = new Window_ADMIN_CATEGORIES_deleteCategory();
    
    public JPanel container;
    public JPanel panel;
    public JPanel pane2;
    public JButton btnafegircategoria;
    public JButton btnmodificarcategoria;
    public JButton btneliminarcategoria;
    public JLabel labeltitol;
    public JLabel labelinfodades;
    public JLabel labelllistat;
    public JTextArea jtextarea;
    public JLabel imagecategoria;
    public JLabel labelafegircategoria;
    public JLabel labelmodificarcategoria;
    public JLabel labeleliminarcategoria;
    public JLabel labeltable;
    public JButton btnmostrartaula;
    public JButton btnamagartaula;
    
    private Vector fileVector;
    private Vector columnNames;
    public List<CategoryList> categories;
    public JTable table;
    public JScrollPane jscrollpne;
    
    
    
    String tken;

    public Window_ADMIN_CATEGORIES() {

        iniciarComponents();
    }
    
    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(900, 800);
        this.setTitle("Admin - Categories");
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

        container = new JPanel();
        container = new JPanel();
        //container.setBorder(new TitledBorder(new LineBorder(Color.white), "Panell general", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        container.setBackground(Color.LIGHT_GRAY);
        container.setBounds(0, 0, 700, 800);
        container.setLayout(null);
        this.getContentPane().add(container);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.white), "Gestió de categories", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
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
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setBounds(120, 10, 330, 50);
        labeltitol.setIcon(new ImageIcon("src/biblioappdesktop/img/info.png"));
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltitol);

        jtextarea = new JTextArea("Aquesta finestra permet fer el manteniment de categories:\n \n - Afegir\n - Actualitzar\n - Eliminar\n - Visualitzar \n  \n Execepte visualitzar, la resta obrirà una nova finestra.");
        jtextarea.setBounds(160, 25, 340, 130);
        jtextarea.setEditable(false);
        jtextarea.setBackground(Color.LIGHT_GRAY);
        panel.add(jtextarea);

        labelafegircategoria = new JLabel();
        labelafegircategoria.setText("Afegir");
        labelafegircategoria.setBounds(520, 20, 100, 100);
        labelafegircategoria.setForeground(Color.BLACK);
        labelafegircategoria.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelafegircategoria);

        labelmodificarcategoria = new JLabel();
        labelmodificarcategoria.setText("Modificar");
        labelmodificarcategoria.setBounds(620, 20, 100, 100);
        labelmodificarcategoria.setForeground(Color.BLACK);
        labelmodificarcategoria.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelmodificarcategoria);

        labeleliminarcategoria = new JLabel();
        labeleliminarcategoria.setText("Eliminar");
        labeleliminarcategoria.setBounds(720, 20, 100, 100);
        labeleliminarcategoria.setForeground(Color.BLACK);
        labeleliminarcategoria.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labeleliminarcategoria);

        labeltable = new JLabel();
        labeltable.setText("TAULA AMB LA LLISTA DE TOTES LES CATEGORIES:");
        labeltable.setBounds(20, 20, 400, 100);
        labeltable.setForeground(Color.BLACK);
        labeltable.setFont(new Font("Calibri", Font.PLAIN, 18));
        pane2.add(labeltable);

        imagecategoria = new JLabel();
        imagecategoria.setBounds(30, 50, 80, 80);
        imagecategoria.setIcon(new ImageIcon("src/biblioappdesktop/img/categoria.png"));
        panel.add(imagecategoria);

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonCategoriaAdd() {
        btnafegircategoria = new JButton();
        btnafegircategoria.setBounds(520, 80, 80, 80);
        btnafegircategoria.setForeground(Color.black);
        btnafegircategoria.setBackground(Color.WHITE);
        btnafegircategoria.setIcon(new ImageIcon("src/biblioappdesktop/img/anadir1.png"));
        btnafegircategoria.setBackground(Color.GRAY);
        btnafegircategoria.setToolTipText("Afegir llibres");
        panel.add(btnafegircategoria);

        btnafegircategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addCategoria.setVisible(true);
            }
        });

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonCategoriaUpdate() {
        btnmodificarcategoria = new JButton();
        btnmodificarcategoria.setBounds(620, 80, 80, 80);
        btnmodificarcategoria.setForeground(Color.black);
        btnmodificarcategoria.setBackground(Color.WHITE);
        btnmodificarcategoria.setIcon(new ImageIcon("src/biblioappdesktop/img/editar1.png"));
        btnmodificarcategoria.setBackground(Color.GRAY);
        btnmodificarcategoria.setToolTipText("Modificar llibres");
        panel.add(btnmodificarcategoria);

        btnmodificarcategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updateCategoria.setVisible(true);
            }
        });

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonCategoriaDelete() {
        btneliminarcategoria = new JButton();
        btneliminarcategoria.setBounds(720, 80, 80, 80);
        btneliminarcategoria.setForeground(Color.black);
        btneliminarcategoria.setBackground(Color.WHITE);
        btneliminarcategoria.setIcon(new ImageIcon("src/biblioappdesktop/img/eliminar1.png"));
        btneliminarcategoria.setBackground(Color.GRAY);
        btneliminarcategoria.setToolTipText("Eliminar llibres");
        panel.add(btneliminarcategoria);

        btneliminarcategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                deleteCategoria.setVisible(true);
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
                columnNames.add("ID Categoria");
                columnNames.add("Nom Categoria");
                
                categories = ApiConnector.getCategories(tken);

                fileVector = new Vector();

                categories.forEach(c -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(c.getIdCategoria());
                    row.add(c.getNomCategoria());
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
        setButtonCategoriaAdd();
        setButtonCategoriaUpdate();
        setButtonCategoriaDelete();
        setButtonShowTable();
        setButtonNOTVisibleTable();
    }
    
}
