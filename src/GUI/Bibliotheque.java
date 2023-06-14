package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
    }

    public static void main(String[] args){

        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.pack();
        bibliotheque.setLocationRelativeTo(null);
        bibliotheque.setVisible(true);
        bibliotheque.setSize(500,500);
    }
}

