/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.Missatge;
import biblioappdesktop.mappers.UserPost;
import biblioappdesktop.mappers.addprestec;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
public class Window_ADMIN_PRESTECS_addPrestec extends JFrame {
    
     App app = new App();

    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelidUsuari;
    public JLabel labelidLlibre;
    public JLabel labeldataPrestec;
    public JLabel labeldataDevolucioPrevista;
    public JLabel labeldataDevolucio;

    public JTextField textidUsuari;
    public JTextField textidLlibre;
    public JTextField textdataPrestec;
    public JTextField textdataDevolucioPrevista;
    public JTextField textdataDevolucio;
    public JButton botoafegirprestec;
    public JLabel imageprestec;
    public JButton botonetejacamps;
    
    private JDateChooser jdatechooser1;
    private JDateChooser jdatechooser2;
    private JDateChooser jdatechooser3;
    public JButton btnintroduirdata;
    public JButton btnintroduirdata2;
    public JButton btnintroduirdat3;

    String tken;
    
    public Window_ADMIN_PRESTECS_addPrestec() {
        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Afegir Préstec");
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
        panel.setBounds(0, 0, 700, 600);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void setlabels() {
        labeltitol = new JLabel();
        labeltitol.setText("Afegir nou préstec");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelidUsuari = new JLabel();
        labelidUsuari.setText("ID Usuari:");
        labelidUsuari.setBounds(60, 50, 200, 100);
        labelidUsuari.setForeground(Color.BLACK);
        labelidUsuari.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidUsuari);

        labelidLlibre = new JLabel();
        labelidLlibre.setText("ID Llibre:");
        labelidLlibre.setBounds(60, 90, 200, 100);
        labelidLlibre.setForeground(Color.BLACK);
        labelidLlibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidLlibre);

        labeldataPrestec = new JLabel();
        labeldataPrestec.setText("Data préstec:");
        labeldataPrestec.setBounds(60, 130, 200, 100);
        labeldataPrestec.setForeground(Color.BLACK);
        labeldataPrestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldataPrestec);

        labeldataDevolucioPrevista = new JLabel();
        labeldataDevolucioPrevista.setText("Data Devolucio Prevista:");
        labeldataDevolucioPrevista.setBounds(60, 170, 200, 100);
        labeldataDevolucioPrevista.setForeground(Color.BLACK);
        labeldataDevolucioPrevista.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldataDevolucioPrevista);

        labeldataDevolucio = new JLabel();
        labeldataDevolucio.setText("Data Devolució:");
        labeldataDevolucio.setBounds(60, 210, 200, 100);
        labeldataDevolucio.setForeground(Color.BLACK);
        labeldataDevolucio.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldataDevolucio);
        
        jdatechooser1 = new JDateChooser();
        jdatechooser1.setBounds(380, 160, 100, 25);
        jdatechooser1.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser1);
        
        jdatechooser2 = new JDateChooser();
        jdatechooser2.setBounds(380, 200, 100, 25);
        jdatechooser2.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser2);
        
        jdatechooser3 = new JDateChooser();
        jdatechooser3.setBounds(380, 240, 100, 25);
        jdatechooser3.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser3);

        imageprestec = new JLabel();
        imageprestec.setBounds(500, 5, 140, 140);
        imageprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/libroassign.png"));
        panel.add(imageprestec);
    }

    private void setTextField() {
        textidUsuari = new JTextField();
        textidUsuari.setBounds(230, 80, 140, 25);
        textidUsuari.setText("");
        textidUsuari.setToolTipText("Ha d'introduir el ID d'usuari");
        panel.add(textidUsuari);

        textidLlibre = new JTextField();
        textidLlibre.setBounds(230, 120, 140, 25);
        textidLlibre.setText("");
        textidLlibre.setToolTipText("Ha d'introduir el ID del llibre");
        panel.add(textidLlibre);

        textdataPrestec = new JTextField();
        textdataPrestec.setBounds(230, 160, 140, 25);
        textdataPrestec.setText("");
        textdataPrestec.setToolTipText("Ha d'introduir la data del préstec");
        panel.add(textdataPrestec);

        textdataDevolucioPrevista = new JTextField();
        textdataDevolucioPrevista.setBounds(230, 200, 140, 25);
        textdataDevolucioPrevista.setText("");
        textdataDevolucioPrevista.setToolTipText("Ha d'introduir la data de devolució prevista");
        panel.add(textdataDevolucioPrevista);

        textdataDevolucio = new JTextField();
        textdataDevolucio.setBounds(230, 240, 140, 25);
        textdataDevolucio.setText("");
        textdataDevolucio.setToolTipText("Ha d'introduir la data de devolució");
        panel.add(textdataDevolucio);

    }
    
    /**
     *  Clear all jTextFields
     */
    private void setButtonAddPrestec() {
        botoafegirprestec = new JButton();
        botoafegirprestec.setBounds(60, 380, 130, 40);
        botoafegirprestec.setForeground(Color.black);
        botoafegirprestec.setText("AFEGIR");
        botoafegirprestec.setOpaque(true);
        botoafegirprestec.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botoafegirprestec.setBackground(Color.WHITE);
        botoafegirprestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botoafegirprestec);

        List<String> rols = new ArrayList();

        botoafegirprestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                addprestec addprstec = new addprestec();
                addprstec.setIdUsuari(Integer.parseInt(textidUsuari.getText()));
                addprstec.setIdLlibre(Integer.parseInt(textidLlibre.getText()));
                addprstec.setDataPrestec( textdataPrestec.getText());
                addprstec.setDataDevolucioPrevista(textdataDevolucioPrevista.getText());
                addprstec.setDataDevolucio(textdataDevolucio.getText());
             
                tken = app.getToken();

                Missatge msg = ApiConnector.addPrestec(tken, addprstec);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "EL préstec s'ha afegit correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "El préstec no s'ha pogut afegir");
                }
            }
        });
    }

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

                textdataPrestec.setText(df.format(jdatechooser1.getDate()));
            }
        });
     
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setbuttonDate2() {
        btnintroduirdata2 = new JButton();
        btnintroduirdata2.setBounds(510, 200, 120, 25);
        btnintroduirdata2.setForeground(Color.black);
        btnintroduirdata2.setBackground(Color.WHITE);
        btnintroduirdata2.setText("Establir data");
        btnintroduirdata2.setBackground(Color.GRAY);
        btnintroduirdata2.setToolTipText("Estableix la data");
        panel.add(btnintroduirdata2);

        btnintroduirdata2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");

                textdataDevolucioPrevista.setText(df2.format(jdatechooser2.getDate()));
            }
        });              
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setbuttonDate3() {      
        btnintroduirdat3 = new JButton();
        btnintroduirdat3.setBounds(510, 240, 120, 25);
        btnintroduirdat3.setForeground(Color.black);
        btnintroduirdat3.setBackground(Color.WHITE);
        btnintroduirdat3.setText("Establir data");
        btnintroduirdat3.setBackground(Color.GRAY);
        btnintroduirdat3.setToolTipText("Estableix la data");
        panel.add(btnintroduirdat3);
        
        btnintroduirdat3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                DateFormat df3 = new SimpleDateFormat("dd-MM-yyyy");

                textdataDevolucio.setText(df3.format(jdatechooser3.getDate()));

            }
        });
                 
    }
    
    /**
    * This method set the specific button for panel
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

                textidUsuari.setText("");
                textidLlibre.setText("");
                textdataPrestec.setText("");
                textdataDevolucioPrevista.setText("");
                textdataDevolucio.setText("");
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
        setButtonAddPrestec();
        setButtonclean();
        setbuttonDate();
        setbuttonDate2();
        setbuttonDate3();
    }

}
