package GUI;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

import Auteur.Auteur;
import Bibliotheque.Bibliotheque;
import Pret.Pret;
import Membres.*;
import Livres.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JdialogPrets extends JDialog {
    private JPanel contentPane;
    private JTable table1;
    private JButton ajouterButton;
    private JButton supprimerButton;
    private JComboBox comboBoxLivres;
    private JComboBox comboBoxMembres;
    private static final int LIMITE_LIVRES_EMPRUNTES_REGULAR = 5;

    public JdialogPrets(JFrame parent, boolean modal, String titre) {
        super(parent, modal);
        setTitle(titre);

        setContentPane(contentPane);
        pack();
        // Créer les titres de colonnes
        String[] columnNames = {"Titre Livre", "Numéro Membre ", "Date d'emprunt", "Genre du livre", "Type de Membre"};

        // Créer des données pour la table
        Object[][] data = {};
        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);
        this.remplirTableauAvecPret();


        // Remplir les JComboBox avec les membres et les livres disponibles
        for (MembrePremium membrePremium : Bibliotheque.getInstance().getListemembrePremium()) {
            comboBoxMembres.addItem(membrePremium);
        }
        for (MembreRegular membreRegular : Bibliotheque.getInstance().getListemembreRegulars()) {
            comboBoxMembres.addItem(membreRegular);
        }

        for (LivreFiction livreFiction : Bibliotheque.getInstance().getListelivreFictions()) {
            comboBoxLivres.addItem(livreFiction);
        }

        for (LivreNonFiction livreNonFiction : Bibliotheque.getInstance().getListelivreNonFictions()) {
            comboBoxLivres.addItem(livreNonFiction);
        }


        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Membre selectedMembre = (Membre) comboBoxMembres.getSelectedItem();
                Livre selectedLivre = (Livre) comboBoxLivres.getSelectedItem();
                if (selectedMembre == null || selectedLivre == null) {
                    JOptionPane.showMessageDialog(contentPane, "Veuillez sélectionner un membre et un livre.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (selectedMembre instanceof MembreRegular && ((MembreRegular) selectedMembre).getNbrLivreMax() >= LIMITE_LIVRES_EMPRUNTES_REGULAR) {
                    JOptionPane.showMessageDialog(contentPane, "Un membre régulier ne peut pas emprunter plus de 10 livres.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    LocalDate dateemprunt = LocalDate.now();
                    String genreLivre = "Inconnu";
                    if (selectedLivre instanceof LivreFiction) {
                        genreLivre = "Fiction";
                    } else if (selectedLivre instanceof LivreNonFiction) {
                        genreLivre = "Non-fiction";
                    }
                    String typeMembre = "Inconnu";
                    if (selectedMembre instanceof MembrePremium) {
                        typeMembre = "Premium";
                    } else if (selectedMembre instanceof MembreRegular) {
                        typeMembre = "Regular";
                    }


                    Pret nouveauPret = new Pret(selectedLivre, selectedMembre, dateemprunt);
                    Bibliotheque.getInstance().ajouterPret(nouveauPret);

                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.addRow(new Object[]{selectedLivre.getTitre(), selectedMembre.getNumeroMembre(), dateemprunt, genreLivre, typeMembre});
                    table1.setModel(model);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table1.getSelectedRow();

                if(selectedRow >=0)
                {
                    Pret pret = Bibliotheque.getInstance().getListeprets().get(selectedRow);

                    Bibliotheque.getInstance().supprimerPret(pret);

                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }


    public static void main(String[] args) {
        JdialogPrets dialog = new JdialogPrets(null, true, "Prets");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void remplirTableauAvecPret() {
        // Récupérer le DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // Parcourir la liste MembrePremium
        for (Pret pret : Bibliotheque.getInstance().getListeprets()) {
            Livre livre = pret.getBorrowedLivres();
            Membre membre = pret.getBorrowingMembre();
            String genreLivre = "Inconnu";
            if (livre instanceof LivreFiction) {
                genreLivre = "Fiction";
            } else if (livre instanceof LivreNonFiction) {
                genreLivre = "Non-fiction";
            }
            String typeMembre = "Inconnu";
            if (membre instanceof MembrePremium) {
                typeMembre = "Premium";
            } else if (membre instanceof MembreRegular) {
                typeMembre = "Regular";
            }

            model.addRow(new Object[]{livre.getTitre(),membre.getNumeroMembre(), pret.getDateEmprunt(),genreLivre,typeMembre });
        }
        table1.setModel(model);
    }

}

