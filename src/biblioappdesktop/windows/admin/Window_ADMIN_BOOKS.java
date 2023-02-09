/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.BooksList;
import biblioappdesktop.mappers.Users;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Cristian
 */
public class Window_ADMIN_BOOKS extends JFrame {
    
    App app = new App();
    Window_ADMIN_BOOKS_addBook addbook = new Window_ADMIN_BOOKS_addBook();
    Window_ADMIN_BOOKS_updateBook updatebook = new Window_ADMIN_BOOKS_updateBook();
    Window_ADMIN_BOOKS_deleteBook deleteBook = new Window_ADMIN_BOOKS_deleteBook();
    
    //Elements visuals que conté el Frame
    public JTextArea jtextarea;
    public JPanel container;
    public JPanel panel;
    public JPanel pane2;
    public JLabel labeltitol;
    public JLabel labelllistat;
    public JLabel imagellibre;
    public JLabel labelinfodades;
    public JLabel labelafegirllibre;
    public JLabel labelmodificarllibre;
    public JLabel labeleliminarllibre;
    public JLabel labeltable;
    public JLabel imageflecha;
    public JButton btnafegirllibre;
    public JButton btnmodificarllibre;
    public JButton btneliminarllibre;
    public JButton btnmostrartaula;
    public JButton btnamagartaula;
    
    private Vector fileVector;
    private Vector columnNames;
    public List<BooksList> books;
    public JTable table;
    public JScrollPane jscrollpne;
    
    String tken;
    
    public Window_ADMIN_BOOKS() {

        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(900, 800);
        this.setTitle("Admin - Llibres");
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
        container = new JPanel();
        container = new JPanel();
        //container.setBorder(new TitledBorder(new LineBorder(Color.white), "Panell general", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        container.setBackground(Color.LIGHT_GRAY);
        container.setBounds(0, 0, 700, 800);
        container.setLayout(null);
        this.getContentPane().add(container);
        
        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.white), "Gestió de llibres", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
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
    private void setButtonBookAdd() {
        btnafegirllibre = new JButton();
        btnafegirllibre.setBounds(520, 80, 80, 80);
        btnafegirllibre.setForeground(Color.black);
        btnafegirllibre.setBackground(Color.WHITE);      
        btnafegirllibre.setIcon(new ImageIcon("src/biblioappdesktop/img/addbook.png"));
        btnafegirllibre.setBackground(Color.GRAY);              
        btnafegirllibre.setToolTipText("Afegir llibres");
        panel.add(btnafegirllibre);   
        
        btnafegirllibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               addbook.setVisible(true);
            }
        });
        
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonBookUpdate() {
        btnmodificarllibre = new JButton();
        btnmodificarllibre.setBounds(620, 80, 80, 80);
        btnmodificarllibre.setForeground(Color.black);
        btnmodificarllibre.setBackground(Color.WHITE);
        btnmodificarllibre.setIcon(new ImageIcon("src/biblioappdesktop/img/updatebook.png"));
        btnmodificarllibre.setBackground(Color.GRAY);
        btnmodificarllibre.setToolTipText("Modificar llibres");
        panel.add(btnmodificarllibre);

        btnmodificarllibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updatebook.setVisible(true);
            }
        });

    }
    
    /**
    * This method set the specific button for panel
    */
    private void setButtonBookDelete() {
        btneliminarllibre = new JButton();
        btneliminarllibre.setBounds(720, 80, 80, 80);
        btneliminarllibre.setForeground(Color.black);
        btneliminarllibre.setBackground(Color.WHITE);
        btneliminarllibre.setIcon(new ImageIcon("src/biblioappdesktop/img/deletebook.png"));
        btneliminarllibre.setBackground(Color.GRAY);
        btneliminarllibre.setToolTipText("Eliminar llibres");
        panel.add(btneliminarllibre);

        btneliminarllibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                deleteBook.setVisible(true);
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
                columnNames.add("ID Llibre");
                columnNames.add("Titol Llibre");
                columnNames.add("Data Publicació");
                columnNames.add("Copies Disponibles");
                columnNames.add("ISBN");
                columnNames.add("Descripcio");
                columnNames.add("ID Autor");
                columnNames.add("ID Categoria");
             
                books = ApiConnector.getBooks(tken);
                
                fileVector = new Vector();

                books.forEach(b -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(b.getIdLlibre());
                    row.add(b.getTitulLlibre());
                    row.add(b.getDataPublicacio());
                    row.add(b.getCopiesDisponibles());
                    row.add(b.getIsbn());
                    row.add(b.getDescripcio());
                    row.add(b.getIdAutor());
                    row.add(b.getIdCategoria());
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
    
    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setBounds(120, 10, 330, 50);
        labeltitol.setIcon(new ImageIcon("src/biblioappdesktop/img/info.png"));
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeltitol);

        jtextarea = new JTextArea("Aquesta finestra permet fer el manteniment de llibres:\n \n - Afegir\n - Actualitzar\n - Eliminar\n - Visualitzar \n  \n Execepte visualitzar, la resta obrirà una nova finestra.");
        jtextarea.setBounds(160, 25, 340, 130);
        jtextarea.setEditable(false);
        jtextarea.setBackground(Color.LIGHT_GRAY);
        panel.add(jtextarea);

        labelafegirllibre = new JLabel();
        labelafegirllibre.setText("Afegir");
        labelafegirllibre.setBounds(520, 20, 100, 100);
        labelafegirllibre.setForeground(Color.BLACK);
        labelafegirllibre.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelafegirllibre);

        labelmodificarllibre = new JLabel();
        labelmodificarllibre.setText("Modificar");
        labelmodificarllibre.setBounds(620, 20, 100, 100);
        labelmodificarllibre.setForeground(Color.BLACK);
        labelmodificarllibre.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelmodificarllibre);

        labeleliminarllibre = new JLabel();
        labeleliminarllibre.setText("Eliminar");
        labeleliminarllibre.setBounds(720, 20, 100, 100);
        labeleliminarllibre.setForeground(Color.BLACK);
        labeleliminarllibre.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labeleliminarllibre);
        
        labeltable = new JLabel();
        labeltable.setText("TAULA AMB LA LLISTA DE TOTS ELS LLIBRES:");
        labeltable.setBounds(20, 20, 340, 100);
        labeltable.setForeground(Color.BLACK);
        labeltable.setFont(new Font("Calibri", Font.PLAIN, 18));
        pane2.add(labeltable);

        imagellibre = new JLabel();
        imagellibre.setBounds(30, 50, 80, 80);
        imagellibre.setIcon(new ImageIcon("src/biblioappdesktop/img/book-stack.png"));
        panel.add(imagellibre);
        

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
        setButtonBookAdd();
        setButtonBookUpdate();
        setButtonBookDelete();
        setButtonShowTable();
        setButtonNOTVisibleTable();
    }
    
}
