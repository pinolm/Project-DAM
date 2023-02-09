/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.Prestecs;
import biblioappdesktop.mappers.Users;
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
public class Window_ADMIN_PRESTECS extends JFrame {

    App app = new App();
    Window_ADMIN_PRESTECS_addPrestec addPrestec = new Window_ADMIN_PRESTECS_addPrestec();
    Window_ADMIN_PRESTECS_updatePrestec updatePrestec = new Window_ADMIN_PRESTECS_updatePrestec();
    Window_ADMIN_PRESTECS_deletePrestec deletePrestec = new Window_ADMIN_PRESTECS_deletePrestec();

    public JPanel container;
    public JPanel panel;
    public JPanel pane2;
    public JButton btnafegirprestec;
    public JButton btnmodificarprestec;
    public JButton btneliminarprestec;
    public JLabel labeltitol;
    public JLabel labelinfodades;
    public JLabel labelllistat;
    public JLabel imageprestec;
    public JLabel labelafegirprestec;
    public JLabel labelmodificarprestec;
    public JLabel labeleliminarprestec;
    public JLabel labeltable;
    public JTextArea jtextarea;
    public JLabel imagellegir;
    public JLabel imageflecha;
    public JButton btnmostrartaula;
    public JButton btnamagartaula;
    private Vector fileVector;
    private Vector columnNames;
    public List<Prestecs> prestecs;
    public JTable table;
    public JScrollPane jscrollpne;

    String tken;

    public Window_ADMIN_PRESTECS() {

        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(900, 800);
        this.setTitle("Admin - Prestecs");
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

        container = new JPanel();
        container = new JPanel();
        //container.setBorder(new TitledBorder(new LineBorder(Color.white), "Panell general", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
        container.setBackground(Color.LIGHT_GRAY);
        container.setBounds(0, 0, 700, 800);
        container.setLayout(null);
        this.getContentPane().add(container);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(Color.white), "Gestió de préstecs", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), Color.BLACK));
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
    private void setButtonPrestecAdd() {
        btnafegirprestec = new JButton();
        btnafegirprestec.setBounds(520, 80, 80, 80);
        btnafegirprestec.setForeground(Color.black);
        btnafegirprestec.setBackground(Color.WHITE);
        btnafegirprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/anadir1.png"));
        btnafegirprestec.setBackground(Color.GRAY);
        btnafegirprestec.setToolTipText("Afegir llibres");
        panel.add(btnafegirprestec);

        btnafegirprestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                addPrestec.setVisible(true);
            }
        });

    }

    /**
    * This method set the specific button for panel
    */
    private void setButtonPrestecUpdate() {
        btnmodificarprestec = new JButton();
        btnmodificarprestec.setBounds(620, 80, 80, 80);
        btnmodificarprestec.setForeground(Color.black);
        btnmodificarprestec.setBackground(Color.WHITE);
        btnmodificarprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/editar1.png"));
        btnmodificarprestec.setBackground(Color.GRAY);
        btnmodificarprestec.setToolTipText("Modificar llibres");
        panel.add(btnmodificarprestec);

        btnmodificarprestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updatePrestec.setVisible(true);
            }
        });

    }

    /**
    * This method set the specific button for panel
    */
    private void setButtonPrestecDelete() {
        btneliminarprestec = new JButton();
        btneliminarprestec.setBounds(720, 80, 80, 80);
        btneliminarprestec.setForeground(Color.black);
        btneliminarprestec.setBackground(Color.WHITE);
        btneliminarprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/eliminar1.png"));
        btneliminarprestec.setBackground(Color.GRAY);
        btneliminarprestec.setToolTipText("Eliminar llibres");
        panel.add(btneliminarprestec);

        btneliminarprestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                deletePrestec.setVisible(true);
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

        jtextarea = new JTextArea("Aquesta finestra permet fer el manteniment de préstecs:\n \n - Afegir\n - Actualitzar\n - Eliminar\n - Visualitzar \n  \n Execepte visualitzar, la resta obrirà una nova finestra.");
        jtextarea.setBounds(160, 25, 340, 130);
        jtextarea.setEditable(false);
        jtextarea.setBackground(Color.LIGHT_GRAY);
        panel.add(jtextarea);

        labelafegirprestec = new JLabel();
        labelafegirprestec.setText("Afegir");
        labelafegirprestec.setBounds(520, 20, 100, 100);
        labelafegirprestec.setForeground(Color.BLACK);
        labelafegirprestec.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelafegirprestec);

        labelmodificarprestec = new JLabel();
        labelmodificarprestec.setText("Modificar");
        labelmodificarprestec.setBounds(620, 20, 100, 100);
        labelmodificarprestec.setForeground(Color.BLACK);
        labelmodificarprestec.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labelmodificarprestec);

        labeleliminarprestec = new JLabel();
        labeleliminarprestec.setText("Eliminar");
        labeleliminarprestec.setBounds(720, 20, 100, 100);
        labeleliminarprestec.setForeground(Color.BLACK);
        labeleliminarprestec.setFont(new Font("Calibri", Font.PLAIN, 18));
        panel.add(labeleliminarprestec);

        labeltable = new JLabel();
        labeltable.setText("TAULA AMB LA LLISTA DE TOTS ELS PRÉSTECS:");
        labeltable.setBounds(20, 20, 340, 100);
        labeltable.setForeground(Color.BLACK);
        labeltable.setFont(new Font("Calibri", Font.PLAIN, 18));
        pane2.add(labeltable);

        labelinfodades = new JLabel();
        labelinfodades.setText("FES CLICK AL BOTÓ MOSTRAR PER VEURE LES DADES");
        labelinfodades.setBounds(130, 60, 800, 300);
        labelinfodades.setForeground(Color.BLACK);
        labelinfodades.setFont(new Font("Calibri", Font.PLAIN, 20));
        pane2.add(labelinfodades);

        imagellegir = new JLabel();
        imagellegir.setBounds(30, 50, 80, 80);
        imagellegir.setIcon(new ImageIcon("src/biblioappdesktop/img/leer.png"));
        panel.add(imagellegir);

       

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
                columnNames.add("ID Préstec");
                columnNames.add("ID Usuari");
                columnNames.add("ID Llibre");
                columnNames.add("Data Préstec");
                columnNames.add("Data Devolució Prevista");
                columnNames.add("Data Devolució");

                prestecs = ApiConnector.getPrestecs(tken);

                fileVector = new Vector();

                prestecs.forEach(p -> {
                    Vector<Object> row = new Vector<Object>();
                    row.add(p.getIdPrestec());
                    row.add(p.getIdUsuari());
                    row.add(p.getIdLlibre());
                    row.add(p.getDataPrestec());
                    row.add(p.getDataDevolucioPrevista());
                    row.add(p.getDataDevolucio());
                    fileVector.add(row);
                });

                labelinfodades.setVisible(false);
                
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
        setButtonPrestecAdd();
        setButtonPrestecUpdate();
        setButtonPrestecDelete();
        setButtonShowTable();
        setButtonNOTVisibleTable();
    }
}
