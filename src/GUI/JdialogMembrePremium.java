package GUI;

import Membres.*;
import Bibliotheque.Bibliotheque;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JdialogMembrePremium extends JDialog {
    private JPanel contentPane;
    private JButton ajouterButton;
    private JButton modifierButton;
    private JTextField textFieldNom;
    private JTextField textFieldAdresse;
    private JTextField textFieldNumMembre;
    private JTextField textFieldDateInscription;
    private JTextField textFieldPrixAbo;
    private JButton supprimerButton;
    private JTable table1;

    public JdialogMembrePremium(JFrame parent, boolean modal , String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(contentPane);
        pack();

        // Créer les titres de colonnes
        String[] columnNames = {"Nom","Adresse","Numéro Membre","Date Inscription", "Prix abonnement"};

        // Créer des données pour la table
        //
        Object[][] data = {};

        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);

        this.remplirTableauAvecMembrePremium();

       ajouterButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String nom = textFieldNom.getText();
               String adresse = textFieldAdresse.getText();
               int numMembre = Integer.parseInt(textFieldNumMembre.getText());
               String dateinscription = textFieldDateInscription.getText();
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
               LocalDate dateInscription = LocalDate.parse(dateinscription,formatter);

               double prixAbo = Double.parseDouble(textFieldPrixAbo.getText());

               if(nom.isEmpty() || adresse.isEmpty() || textFieldNumMembre.getText().isEmpty() || textFieldDateInscription.getText().isEmpty() || textFieldPrixAbo.getText().isEmpty()) {
                   JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                   return;
               }


               MembrePremium membrePremium = new MembrePremium(nom, adresse, numMembre, dateInscription, prixAbo);
               Bibliotheque.getInstance().ajouterMembrePremium(membrePremium);
               DefaultTableModel model =(DefaultTableModel) table1.getModel();
               model.addRow(new Object[]{nom,adresse,numMembre,dateInscription,prixAbo});

               textFieldNom.setText("");
               textFieldAdresse.setText("");
               textFieldNumMembre.setText("");
               textFieldDateInscription.setText("");
               textFieldPrixAbo.setText("");
           }
       });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if(selectedRow >= 0) {
                    MembrePremium membreToDelete = Bibliotheque.getInstance().getListemembrePremium().get(selectedRow);
                    Bibliotheque.getInstance().supprimerMembrePremium(membreToDelete);
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un membre pour le supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void remplirTableauAvecMembrePremium() {
        // Récupérer le DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // Parcourir la liste MembrePremium
        for (MembrePremium membrePremium : Bibliotheque.getInstance().getListemembrePremium()) {
            // Créer un tableau avec les données du membre
            Object[] row = new Object[] {

                    membrePremium.getNom(),
                    membrePremium.getAdresse(),
                    membrePremium.getNumeroMembre(),
                    membrePremium.getDateInscription(),
                    membrePremium.getPrixAbo()
            };

            // Ajouter la ligne à la table
            model.addRow(row);
        }
    }
    public static void main(String[] args) {
        JdialogMembrePremium dialog = new JdialogMembrePremium(null, true, "MembrePremium");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
