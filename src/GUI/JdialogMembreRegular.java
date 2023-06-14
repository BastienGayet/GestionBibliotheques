package GUI;
import Membres.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import  Bibliotheque.Bibliotheque;

public class JdialogMembreRegular extends JDialog
{
    private JTable table1;
    private JPanel panel1;
    private JTextField textFieldNom;
    private JTextField textFieldAdresse;
    private JTextField textFieldNumeroMembre;
    private JTextField textFieldDateInscription;
    private JSpinner spinnerNbreLivre;
    private JButton ajouterButton;
    private JButton supprimerButton;
    private JLabel nomLabel;
    private JLabel adresseLabel;
    private JLabel numéroMembreLabel;
    private JLabel dateInscriptionLabel;
    private JLabel nombreLivreLabel;

    public JdialogMembreRegular(JFrame parent, boolean modal, String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(panel1);
        pack();

        // Créer les titres de colonnes
        String[] columnNames = {"Nom","Adresse","Numéro Membre","Date Inscription", "Nombre de Livre"};

        // Créer des données pour la table
        //
        Object[][] data = {};

        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);

        this.remplirTableauAvecMembreRegular();

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textFieldNom.getText();
                String adresse = textFieldAdresse.getText();
                int numMembre = Integer.parseInt(textFieldNumeroMembre.getText());
                String dateinscription = textFieldDateInscription.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateInscription = LocalDate.parse(dateinscription,formatter);
                Object selectedValue = spinnerNbreLivre.getValue();
                int intValue = (int) selectedValue; // Conversion en int

                if(nom.isEmpty() || adresse.isEmpty() || textFieldNumeroMembre.getText().isEmpty() || textFieldDateInscription.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                MembreRegular membreRegular = new MembreRegular(nom, adresse, numMembre, dateInscription, intValue);
                Bibliotheque.getInstance().ajouterMembreRegular(membreRegular);

                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                model.addRow(new Object[]{nom, adresse, numMembre, dateInscription, intValue});

                textFieldNom.setText("");
                textFieldAdresse.setText("");
                textFieldNumeroMembre.setText("");
                textFieldDateInscription.setText("");
                spinnerNbreLivre.setValue(0);


            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();
                if(selectedRow >= 0) {
                    MembreRegular membreRegular = Bibliotheque.getInstance().getListemembreRegulars().get(selectedRow);
                    Bibliotheque.getInstance().supprimerMembreRegular(membreRegular);
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un membre pour le supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
    public void remplirTableauAvecMembreRegular() {
        // Récupérer le DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // Parcourir la liste MembrePremium
        for (MembreRegular membreRegular : Bibliotheque.getInstance().getListemembreRegulars()) {
            // Créer un tableau avec les données du membre
            Object[] row = new Object[] {

                    membreRegular.getNom(),
                    membreRegular.getAdresse(),
                    membreRegular.getNumeroMembre(),
                    membreRegular.getDateInscription(),
                    membreRegular.getNbrLivreMax()
            };

            // Ajouter la ligne à la table
            model.addRow(row);
        }
    }


    public static void main(String[] args) {
        JdialogMembreRegular dialog = new JdialogMembreRegular(null, true, "MembrePremium");

        dialog.setVisible(true);
        System.exit(0);
    }
}