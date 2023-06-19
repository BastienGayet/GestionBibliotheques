package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import  Bibliotheque.Bibliotheque;
import Livres.LivreNonFiction;

public class JdialogLivreNonFiction extends JDialog
{
    private JPanel contentPane;
    private JButton ajouterButton;
    private JButton supprimerButton;
    private JTable table1;
    private JTextField textFieldTitre;
    private JTextField textFieldAuteur;
    private JTextField textFieldPrix;
    private JTextField textFieldISBN;
    private JTextField textFieldAnnePubli;
    private JTextField textFieldDomaine;
    private JCheckBox disponibleCheckBox;
    private JLabel titreLabel;
    private JLabel auteurLabel;
    private JLabel prixLabel;
    private JLabel ISBNLabel;
    private JLabel annéePublicationLabel;
    private JLabel domaineLabel;
    private JTextField textFieldEditeur;
    private JLabel editeurLabel;

    public JdialogLivreNonFiction(JFrame parent, boolean modal , String titre) {
        super(parent, modal);
        setTitle(titre);
        setContentPane(contentPane);
        pack();
        // Créer les titres de colonnes
        String[] columnNames = {"Titre", "Année Publication","Auteur","Prix","ISBN","Disponible", "Editeur", "Genre"};

        // Créer des données pour la table
        //
        Object[][] data = {
        };

        // Définir le modèle de table avec les données et les noms de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Appliquer ce modèle à votre table
        table1.setModel(model);
        this.remplirTableauAvecLivreNonFiction();

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
                String Domaine = textFieldDomaine.getText();

                if(titre.isEmpty() || AnneePublication <= 0 || nomAuteur.isEmpty() || Prix <= 0 || ISBN <= 0 || Editeur.isEmpty() || Domaine.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else
                {
                    LivreNonFiction livreNonFiction = new LivreNonFiction(titre, AnneePublication, nomAuteur, Prix, ISBN, Disponible, Editeur, Domaine);
                    Bibliotheque.getInstance().ajouterLivreNonFiction(livreNonFiction);

                    DefaultTableModel model =(DefaultTableModel) table1.getModel();
                }

                model.addRow(new Object[]{titre,AnneePublication,nomAuteur,Prix,ISBN,Disponible,Editeur,});

                textFieldTitre.setText("");
                textFieldAnnePubli.setText("");
                textFieldAuteur.setText("");
                textFieldPrix.setText("");
                textFieldISBN.setText("");
                textFieldEditeur.setText("");
                textFieldDomaine.setText("");
                disponibleCheckBox.setSelected(false);



            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectedRow = table1.getSelectedRow();

                if(selectedRow >=0)
                {
                    LivreNonFiction livreNonFiction = Bibliotheque.getInstance().getListelivreNonFictions().get(selectedRow);

                    Bibliotheque.getInstance().supprimerLivreNonFiction(livreNonFiction);

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
    public void remplirTableauAvecLivreNonFiction() {
        // Récupérer le DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table1.getModel();

        // Parcourir la liste d'auteurs
        for (LivreNonFiction livreNonFiction : Bibliotheque.getInstance().getListelivreNonFictions()) {
            // Créer un tableau avec les données de l'auteur
            Object[] row = new Object[] {
                    livreNonFiction.getTitre(),livreNonFiction.getAnneePublication(),livreNonFiction.getAuteursnom(),livreNonFiction.getPrix(),
                    livreNonFiction.getIsbn(),livreNonFiction.getEditeur(),livreNonFiction.getDomaine(),livreNonFiction.isDisponible()

            };

            // Ajouter la ligne à la table
            model.addRow(row);
        }
    }




    public static void main(String[] args) {
        JdialogLivreNonFiction dialog = new JdialogLivreNonFiction(null, true, "Livre Non Fiction ");
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
