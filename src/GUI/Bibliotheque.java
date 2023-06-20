package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Properties;

public class Bibliotheque extends JFrame {

    private JButton pretButton;
    private JButton livreFictionButton;
    private JButton membreRegularButton;
    private JButton buttonAuteur;
    private JPanel panel1;
    private JButton livreNonFictionButton;
    private JButton membrePremiumButton;

    public Bibliotheque() {
        setTitle("Gestion Bibliotheque JAVA");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //setSize(400,400);
       // PositionFenetre();

        buttonAuteur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JdialogAuteur dialog = new JdialogAuteur(null, true, "Auteur");
                dialog.setVisible(true);
            }

        });
        pretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JdialogPrets dialog = new JdialogPrets(null, true, "Pret");
                dialog.setVisible(true);
            }
        });
        membreRegularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JdialogMembreRegular dialog = new JdialogMembreRegular(null, true , "Membre Regular");
                dialog.setVisible(true);
            }
        });
        membrePremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JdialogMembrePremium dialog = new JdialogMembrePremium(null, true, "Membre Premium");
                dialog.setVisible(true);
            }
        });
        livreNonFictionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JdialogLivreNonFiction dialog = new JdialogLivreNonFiction(null, true, "Livre Non Fiction");
                dialog.setVisible(true);
            }
        });
        livreFictionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JdialogLivreFiction dialog = new JdialogLivreFiction(null, true, "Livre Fiction ");
                dialog.setVisible(true);
            }
        });

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                Properties properties = new Properties();
                properties.setProperty("window.x", String.valueOf(getX()));
                properties.setProperty("window.y", String.valueOf(getY()));
                try (OutputStream output = new FileOutputStream("windows.properties")) {
                    properties.store(output, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }finally {
                    System.exit(0);
                }
            }


            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }
    /*private void PositionFenetre()
    {
        Properties properties = new Properties();
        File propertiesFile = new File("Fenetre.properties");
        if(!propertiesFile.exists())
        {
            try
            {
                if(propertiesFile.createNewFile())
                {
                    System.out.println("File cree: " + propertiesFile.getName());
                }else
                {
                    System.out.println("File deja existant.");
                }
            }
            catch(IOException e)
            {
                System.out.println("Erreur  creation du file.");
                e.printStackTrace();
                return;
            }
        }
         try(OutputStream output = new FileOutputStream(propertiesFile)) {
             properties.store(output,null);
         }catch (IOException e){
             e.printStackTrace();

        }

        // Récupérer les coordonnées x et y à partir des propriétés
        String xString = properties.getProperty("window.x");
        String yString = properties.getProperty("window.y");

        if (xString != null && yString != null) {
            try {
                int x = Integer.parseInt(xString);
                int y = Integer.parseInt(yString);
                setLocation(x, y);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }*/

    public static void main(String[] args){

        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.pack();
        bibliotheque.setLocationRelativeTo(null);
        bibliotheque.setVisible(true);
        bibliotheque.setSize(300,300);
    }
}

