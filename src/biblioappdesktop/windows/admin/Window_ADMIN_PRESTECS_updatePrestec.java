/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioappdesktop.windows.admin;

import biblioappdesktop.comunication.ApiConnector;
import biblioappdesktop.main.App;
import biblioappdesktop.mappers.AddBook;
import biblioappdesktop.mappers.Missatge;
import biblioappdesktop.mappers.PrestecUpdate;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class Window_ADMIN_PRESTECS_updatePrestec extends JFrame {

    App app = new App();

    //Elements visuals que conté el Frame
    public JPanel panel;
    public JLabel labeltitol;
    public JLabel labelidPrestec;
    public JLabel labelidusuari;
    public JLabel labelidLlibre;
    public JLabel labeldataPrestec;
    public JLabel labelDataDevolucioPrevista;
    public JLabel labelDataDevolucio;
    public JTextField texttitol;
    public JTextField textIdPrestec;
    public JTextField textIdUsuari;
    public JTextField textIdLlibre;
    public JTextField textDataPrestec;
    public JTextField textDataDevolucioPrevista;
    public JTextField textDataDevolucio;
    public JButton botomodificarPrestec;
    public JButton botonetejacamps;
    public JLabel imageprestec;
    private JDateChooser jdatechooser1;
    private JDateChooser jdatechooser2;
    private JDateChooser jdatechooser3;
    public JButton btnintroduirdata;
    public JButton btnintroduirdata2;
    public JButton btnintroduirdat3;

    String tken;

    public Window_ADMIN_PRESTECS_updatePrestec() {
        iniciarComponents();
    }

    /**
    * This method set the frame
    */
    private void setWindow() {
        this.setSize(700, 600);
        this.setTitle("Admin - Modificar préstec");
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
        labeltitol.setText("Modificar préstec");
        labeltitol.setBounds(60, 0, 200, 100);
        labeltitol.setForeground(Color.BLACK);
        labeltitol.setFont(new Font("Calibri", Font.PLAIN, 25));
        panel.add(labeltitol);

        labelidPrestec = new JLabel();
        labelidPrestec.setText("ID Prestec:");
        labelidPrestec.setBounds(60, 50, 200, 100);
        labelidPrestec.setForeground(Color.BLACK);
        labelidPrestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidPrestec);

        labelidusuari = new JLabel();
        labelidusuari.setText("ID Usuari:");
        labelidusuari.setBounds(60, 90, 200, 100);
        labelidusuari.setForeground(Color.BLACK);
        labelidusuari.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidusuari);

        labelidLlibre = new JLabel();
        labelidLlibre.setText("ID Llibre:");
        labelidLlibre.setBounds(60, 130, 200, 100);
        labelidLlibre.setForeground(Color.BLACK);
        labelidLlibre.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelidLlibre);

        labeldataPrestec = new JLabel();
        labeldataPrestec.setText("Data préstec:");
        labeldataPrestec.setBounds(60, 170, 200, 100);
        labeldataPrestec.setForeground(Color.BLACK);
        labeldataPrestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labeldataPrestec);

        labelDataDevolucioPrevista = new JLabel();
        labelDataDevolucioPrevista.setText("Data Devolució Prevista:");
        labelDataDevolucioPrevista.setBounds(60, 210, 200, 100);
        labelDataDevolucioPrevista.setForeground(Color.BLACK);
        labelDataDevolucioPrevista.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelDataDevolucioPrevista);

        labelDataDevolucio = new JLabel();
        labelDataDevolucio.setText("Data Devolució:");
        labelDataDevolucio.setBounds(60, 250, 200, 100);
        labelDataDevolucio.setForeground(Color.BLACK);
        labelDataDevolucio.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(labelDataDevolucio);

        jdatechooser1 = new JDateChooser();
        jdatechooser1.setBounds(380, 200, 100, 25);
        jdatechooser1.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser1);
        
        jdatechooser2 = new JDateChooser();
        jdatechooser2.setBounds(380, 240, 100, 25);
        jdatechooser2.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser2);
        
        jdatechooser3 = new JDateChooser();
        jdatechooser3.setBounds(380, 280, 100, 25);
        jdatechooser3.setDateFormatString("dd/MM/yyyy");
        panel.add(jdatechooser3);

        imageprestec = new JLabel();
        imageprestec.setBounds(500, 40, 140, 140);
        imageprestec.setIcon(new ImageIcon("src/biblioappdesktop/img/libroassign.png"));
        panel.add(imageprestec);
    }

    private void setTextField() {
        textIdPrestec = new JTextField();
        textIdPrestec.setBounds(230, 80, 140, 25);
        textIdPrestec.setText("");
        textIdPrestec.setToolTipText("Ha d'introduir el ID del préstec");
        panel.add(textIdPrestec);

        textIdUsuari = new JTextField();
        textIdUsuari.setBounds(230, 120, 140, 25);
        textIdUsuari.setText("");
        textIdUsuari.setToolTipText("Ha d'introduir el ID de l'usuari");
        panel.add(textIdUsuari);

        textIdLlibre = new JTextField();
        textIdLlibre.setBounds(230, 160, 140, 25);
        textIdLlibre.setText("");
        textIdLlibre.setToolTipText("Ha d'introduir el ID del llibre");
        panel.add(textIdLlibre);

        textDataPrestec = new JTextField();
        textDataPrestec.setBounds(230, 200, 140, 25);
        textDataPrestec.setText("");
        textDataPrestec.setToolTipText("Ha d'introduir la data del préstec");
        panel.add(textDataPrestec);

        textDataDevolucioPrevista = new JTextField();
        textDataDevolucioPrevista.setBounds(230, 240, 140, 25);
        textDataDevolucioPrevista.setText("");
        textDataDevolucioPrevista.setToolTipText("Ha d'introduir la data de devolució prevista");
        panel.add(textDataDevolucioPrevista);

        textDataDevolucio = new JTextField();
        textDataDevolucio.setBounds(230, 280, 140, 25);    
        textDataDevolucioPrevista.setText("");
        textDataDevolucio.setToolTipText("Ha d'introduir la data de devolució");
        panel.add(textDataDevolucio);
    }

    /**
    * This method set the specific button for panel
    */
    private void setButtonUpdatePrestec() {
        botomodificarPrestec = new JButton();
        botomodificarPrestec.setBounds(60, 370, 130, 40);
        botomodificarPrestec.setForeground(Color.black);
        botomodificarPrestec.setText("MODIFICAR");
        botomodificarPrestec.setOpaque(true);
        botomodificarPrestec.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        botomodificarPrestec.setBackground(Color.WHITE);
        botomodificarPrestec.setFont(new Font("Calibri", Font.PLAIN, 16));
        panel.add(botomodificarPrestec);

        botomodificarPrestec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                PrestecUpdate updateprestec = new PrestecUpdate();

                updateprestec.setIdUsuari(Integer.parseInt(textIdUsuari.getText()));
                updateprestec.setIdLlibre(Integer.parseInt(textIdLlibre.getText()));
                updateprestec.setDataPrestec(textDataPrestec.getText());
                updateprestec.setDataDevolucioPrevista(textDataDevolucioPrevista.getText());
                updateprestec.setDataDevolucio(textDataDevolucio.getText());

                String ID = textIdPrestec.getText();

                tken = app.getToken();

                Missatge msg = ApiConnector.updatePrestec(tken, ID, updateprestec);

                if (msg != null) {
                    JOptionPane.showMessageDialog(null, "El préstec s'ha actualitzat correctament");
                } else {
                    JOptionPane.showMessageDialog(null, "El préstec no s'ha pogut actualitzar");
                }
            }
        });
    }

    /**
    * This method set the specific button for panel
    */
    private void setbuttonDate() {
        btnintroduirdata = new JButton();
        btnintroduirdata.setBounds(510, 200, 120, 25);
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

                textDataPrestec.setText(df.format(jdatechooser1.getDate()));

            }
        });
     
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setbuttonDate2() {      
        btnintroduirdata2 = new JButton();
        btnintroduirdata2.setBounds(510, 240, 120, 25);
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

                textDataDevolucioPrevista.setText(df2.format(jdatechooser2.getDate()));

            }
        });
                 
    }
    
    /**
    * This method set the specific button for panel
    */
    private void setbuttonDate3() {      
        btnintroduirdat3 = new JButton();
        btnintroduirdat3.setBounds(510, 280, 120, 25);
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

                textDataDevolucio.setText(df3.format(jdatechooser3.getDate()));
            }
        });          
    }
        
    /**
     * Clear all jTextFields
     */
    private void setButtonclean() {
        botonetejacamps = new JButton();
        botonetejacamps.setBounds(340, 370, 130, 40);
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
                textIdPrestec.setText("");
                textIdUsuari.setText("");
                textIdLlibre.setText("");
                textDataPrestec.setText("");
                textDataDevolucioPrevista.setText("");
                textDataDevolucio.setText("");
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
        setButtonUpdatePrestec();
        setButtonclean();
        setbuttonDate();
        setbuttonDate2();
        setbuttonDate3();
    }

}
