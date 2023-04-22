package GUI;

import javax.swing.*;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JDialogAuteur extends JDialog
{
   private JTextField textnomField;
   private JTextField prenomField;
  private   JTextField dateNaissanceField;
   private JTextField nationaliteField;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    private String nom;
   private String prenom;
   private LocalDate dateNaissance;
   private String nationalite;
    private JPanel mainPanel;
    private JTextField textFieldPrenom;
    private JTextField textFieldDateNaissance;
    private JTextField textFieldNationnaelit;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JTable table1;

    public  JDialogAuteur()
    {
        super((JFrame)null, "Gestion Auteur",true);
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800,600);
        pack();
    }
    public static void main(String[] args) {
        JDialogAuteur dialog = new JDialogAuteur();
        dialog.setVisible(true);
    }

}

