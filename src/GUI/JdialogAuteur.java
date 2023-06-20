package GUI;


import Auteur.Auteur;
import Bibliotheque.Bibliotheque;
import ressources.DataSerialiser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import ressources.*;

public class JdialogAuteur extends JDialog {
    private JPanel contentPane;
    private JTextField textFieldNom;
    private JTextField textFieldPrenom;
    private JTextField textFieldDateNaissance;
    private JTextField textFieldNationaliter;
    private JButton ajouterButton;
    private JButton supprimerButton;
    private JButton modifierButton;
    private JTable table1;
    private JButton saveButton;
    private JButton loadButton;

    private DataSerialiser serialiser = new DataSerialiser();
    private ArrayList<Auteur> auteurs;



    public JdialogAuteur( JFrame parent, boolean modal , String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(contentPane);
        pack();

        // Créer les titres de colonnes
        String[] columnNames = {"Nom", "Prénom", "Date de naissance", "Nationalité"};

        // Créer des données pour la table
        Object[][] data = {};

        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);

       // Bibliotheque.getInstance().readCSVFile("src\\ressources\\ListeAuteurs.csv");
        this.remplirTableauAvecAuteurs();


        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = textFieldNom.getText();
                String prenom = textFieldPrenom.getText();
                String dateNaissanceStr = textFieldDateNaissance.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr,formatter);
                String nationalite = textFieldNationaliter.getText();


                if(nom.isEmpty() || prenom.isEmpty() || dateNaissanceStr.isEmpty() || nationalite.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;

                }


                // Créer un nouvel auteur
                Auteur auteur = new Auteur(nom, prenom, dateNaissance, nationalite);
                // Ajouter l'auteur à la liste d'auteurs
                Bibliotheque.getInstance().AjouterAuteur(auteur);
                DefaultTableModel model =(DefaultTableModel) table1.getModel();
                model.addRow(new Object[]{nom,prenom,dateNaissance,nationalite});

                textFieldNom.setText("");
                textFieldPrenom.setText("");
                textFieldDateNaissance.setText("");
                textFieldNationaliter.setText("");
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table1.getSelectedRow();

                if(selectedRow >=0)
                {
                    Auteur auteur = Bibliotheque.getInstance().getListeAuteurs().get(selectedRow);

                    Bibliotheque.getInstance().supprimerAuteur(auteur);


                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }


        });


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String filePath = "ListeAuteurs.csv";
                System.out.println(Bibliotheque.getInstance().getListeAuteurs());
                serialiser.saveAuteur( Bibliotheque.getInstance().getListeAuteurs(),filePath);

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath =  "ListeAuteurs.csv";;
                ArrayList<Auteur> auteurs = serialiser.loadAuteur(filePath);
                Bibliotheque.getInstance().setListeAuteurs(auteurs); // Met à jour la liste des auteurs dans la bibliothèque
                remplirTableauAvecAuteurs(); // Met à jour la table
            }
        });
    }
    public void remplirTableauAvecAuteurs() {
        // Récupérer le DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // Parcourir la liste d'auteurs
        for (Auteur auteur : Bibliotheque.getInstance().getListeAuteurs()) {
            // Créer un tableau avec les données de l'auteur
            Object[] row = new Object[] {
                    auteur.getNom(),
                    auteur.getPrenom(),
                    auteur.getDateNaissance(),
                    auteur.getNationalite()
            };

            // Ajouter la ligne à la table
            model.addRow(row);
        }
    }


    public static void main(String[] args) {
        JdialogAuteur dialog = new JdialogAuteur(null, true, "Auteur");

        dialog.setVisible(true);
        System.exit(0);
    }

}
