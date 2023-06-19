package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Bibliotheque.Bibliotheque;
import Livres.LivreFiction;

public class JdialogLivreFiction extends JDialog {
    private JPanel contentPane;
    private JButton ajouterButton;
    private JButton supprimerButton;
    private JTextField textFieldTitre;
    private JTextField textFieldAuteur;
    private JTextField textFieldPrix;
    private JTextField textFieldISBN;
    private JTextField textFieldAnnePubli;
    private JTextField textFieldEditeur;
    private JCheckBox disponibleCheckBox;
    private JTable table1;
    private JTextField textFieldGenre;
    private JLabel titreLabel;
    private JLabel auteurLabel;
    private JLabel prixLabel;
    private JLabel ISBNLabel;
    private JLabel annéePublicationLabel;
    private JLabel editeurLabel;
    private JLabel genreLabel;

    public JdialogLivreFiction(JFrame parent, boolean modal , String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(contentPane);
        pack();
        // Créer les titres de colonnes
        String[] columnNames = {"Titre", "Année Publication", "Auteur", "Prix", "ISBN", "Disponible", "Editeur", "Genre"};

        // Créer des données pour la table
        //
        Object[][] data = {
        };

        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);

        this.remplirTableauAvecLivreFiction();

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String titre = textFieldTitre.getText();
                int AnneePublication =Integer.parseInt(textFieldAnnePubli.getText());
                String nomAuteur = textFieldAuteur.getText();
                double Prix = Double.parseDouble(textFieldPrix.getText());
                long ISBN = Long.parseLong(textFieldISBN.getText());
                boolean Disponible = disponibleCheckBox.isSelected();
                String Editeur = textFieldEditeur.getText();
                String Domaine = textFieldGenre.getText();

                if(titre.isEmpty() || AnneePublication <= 0 || nomAuteur.isEmpty() || Prix <= 0 || ISBN <= 0 || Editeur.isEmpty() || Domaine.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else
                {
                    LivreFiction livreFiction = new LivreFiction(titre, AnneePublication, nomAuteur, Prix, ISBN, Disponible, Editeur, Domaine);
                    Bibliotheque.getInstance().ajouterLivreFiction(livreFiction);

                    DefaultTableModel model =(DefaultTableModel) table1.getModel();
                }

                model.addRow(new Object[]{titre,AnneePublication,nomAuteur,Prix,ISBN,Disponible,Editeur,Domaine});

                textFieldTitre.setText("");
                textFieldAnnePubli.setText("");
                textFieldAuteur.setText("");
                textFieldPrix.setText("");
                textFieldISBN.setText("");
                textFieldEditeur.setText("");
                textFieldGenre.setText("");
                disponibleCheckBox.setSelected(false);



            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table1.getSelectedRow();

                if(selectedRow >=0)
                {
                    LivreFiction livreFiction = Bibliotheque.getInstance().getListelivreFictions().get(selectedRow);

                    Bibliotheque.getInstance().supprimerLivreFiction(livreFiction);

                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.removeRow(selectedRow);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à supprimer", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }

        });



    }
    public void remplirTableauAvecLivreFiction() {
        // Récupérer le DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // Parcourir la liste d'auteurs
        for (LivreFiction livreFiction : Bibliotheque.getInstance().getListelivreFictions()) {
            // Créer un tableau avec les données de l'auteur
            Object[] row = new Object[] {
                    livreFiction.getTitre(),livreFiction.getAnneePublication(),livreFiction.getAuteursnom(),livreFiction.getPrix(),
                    livreFiction.getIsbn(),livreFiction.getEditeur(),livreFiction.getGenre(),livreFiction.isDisponible()

            };

            // Ajouter la ligne à la table
            model.addRow(row);
        }
    }


    public static void main(String[] args) {
        JdialogLivreFiction dialog = new JdialogLivreFiction(null, true, "Livre Fiction");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
