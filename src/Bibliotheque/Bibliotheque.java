package Bibliotheque;
import Livres.*;
import  Membres.*;
import Auteur.Auteur;
import Pret.*;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
public class Bibliotheque {
        private static Bibliotheque instance = null;

        private ArrayList<LivreFiction> ListelivreFictions;
        private ArrayList<LivreNonFiction> ListelivreNonFictions;
        private ArrayList<MembrePremium> ListemembrePremium;
        private ArrayList<MembreRegular> ListemembreRegulars;
        private ArrayList<Pret> Listeprets;
        private ArrayList<Auteur> ListeAuteurs;

        private Bibliotheque() {
            this.ListelivreFictions = new ArrayList<>();
            this.ListelivreNonFictions = new ArrayList<>();
            this.ListemembrePremium = new ArrayList<>();
            this.ListemembreRegulars = new ArrayList<>();
            this.Listeprets = new ArrayList<>();
            this.ListeAuteurs = new ArrayList<>();

            // Ajout des auteurs prédéfinis
            /*ListeAuteurs.add(new Auteur("Hugo", "Victor", LocalDate.parse("1802-02-26"), "Français"));
            ListeAuteurs.add(new Auteur("Tolkien", "J.R.R.", LocalDate.parse("1892-01-03"), "Britannique"));
            ListeAuteurs.add(new Auteur("Rowling", "J.K.", LocalDate.parse("1965-07-31"), "Britannique"));
            ListeAuteurs.add(new Auteur("Austen", "Jane", LocalDate.parse("1775-12-16"), "Britannique"));
            ListeAuteurs.add(new Auteur("Hemingway", "Ernest", LocalDate.parse("1899-07-21"), "Américain"));*/



            // Ajout des livres de fiction prédéfinis
            ListelivreFictions.add(new LivreFiction("Les Misérables", 1862, "victorHugo", 9.99, 978067960, true, "Gallimard", "Roman"));
            ListelivreFictions.add(new LivreFiction("Le Seigneur des Anneaux", 1954, "tolkien", 20.99, 9780618, true, "HarperCollins", "Fantasy"));
            ListelivreFictions.add(new LivreFiction("Harry Potter à l'école des sorciers", 1997, "rowling", 10.99, 9781524, true, "Bloomsbury", "Fantasy"));
            ListelivreFictions.add(new LivreFiction("Orgueil et Préjugés", 1813, "janeAusten", 7.99, 97818532, true, "Penguin Classics", "Roman"));
            ListelivreFictions.add(new LivreFiction("Le Vieil Homme et la Mer", 1952, "ernestHemingway", 8.99, 97806, true, "Scribner", "Roman"));

            //Ajout des livres non fiction prédéfinis

            ListelivreNonFictions.add(new LivreNonFiction("A Brief History of Time", 1988, "Hawking", 14.99, 9780553380163L, true, "Bantam", "Science"));
            ListelivreNonFictions.add(new LivreNonFiction("Outliers", 2008, "Gladwell", 9.99, 9780316017930L, true, "Little, Brown and Company", "Psychology"));
            ListelivreNonFictions.add(new LivreNonFiction("Sapiens", 2011, "NoahHarari", 11.99, 9780099590088L, true, "Harvill Secker", "History"));
            ListelivreNonFictions.add(new LivreNonFiction("The Checklist Manifesto", 2009, "Gawande", 8.99, 9780312430009L, true, "Metropolitan Books", "Medical"));
            ListelivreNonFictions.add(new LivreNonFiction("Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future", 2015, "Musk", 14.99, 9780062301239L, true, "Ecco", "Biography"));

            //Ajout des Membre Premium

            ListemembrePremium.add(new MembrePremium("Gayet","Rue de la chapelle 11 4347 Fexhe-Le-Haut-Clocher",123456,LocalDate.parse("2005-11-25"),25));
            ListemembrePremium.add(new MembrePremium("Dupont", "Rue de la Source 27, 1050 Bruxelles", 123457, LocalDate.parse("2010-05-20"), 30));
            ListemembrePremium.add(new MembrePremium("Lefevre", "Avenue Louise 345, 1000 Bruxelles", 123458, LocalDate.parse("2015-07-13"), 35));
            ListemembrePremium.add(new MembrePremium("Peeters", "Boulevard de l'Impératrice 15, 1000 Bruxelles", 123459, LocalDate.parse("2012-02-28"), 28));
            ListemembrePremium.add(new MembrePremium("Simon", "Rue Royale 143, 1000 Bruxelles", 123460, LocalDate.parse("2018-04-11"), 32));

            //Ajout des Membre  Non Premium

            ListemembreRegulars.add(new MembreRegular("Gayet","Rue de la chapelle 11 4347 Fexhe-Le-Haut-Clocher",123456,LocalDate.parse("2005-11-25"),2));
            ListemembreRegulars.add(new MembreRegular("Dupont", "Rue de la Source 27, 1050 Bruxelles", 123457, LocalDate.parse("2010-05-20"), 3));
            ListemembreRegulars.add(new MembreRegular("Lefevre", "Avenue Louise 345, 1000 Bruxelles", 123458, LocalDate.parse("2015-07-13"), 4));
            ListemembreRegulars.add(new MembreRegular("Peeters", "Boulevard de l'Impératrice 15, 1000 Bruxelles", 123459, LocalDate.parse("2012-02-28"), 3));
            ListemembreRegulars.add(new MembreRegular("Simon", "Rue Royale 143, 1000 Bruxelles", 123460, LocalDate.parse("2018-04-11"), 0));

            // Ajout des prêts prédéfinis
            Listeprets.add(new Pret(ListelivreFictions.get(0), ListemembrePremium.get(0), LocalDate.now()));
            Listeprets.add(new Pret(ListelivreNonFictions.get(1), ListemembrePremium.get(1), LocalDate.now()));
            Listeprets.add(new Pret(ListelivreFictions.get(2), ListemembreRegulars.get(0), LocalDate.now()));
            Listeprets.add(new Pret(ListelivreNonFictions.get(3), ListemembreRegulars.get(1), LocalDate.now()));
            Listeprets.add(new Pret(ListelivreFictions.get(4), ListemembrePremium.get(2), LocalDate.now()));

        }

        public static Bibliotheque getInstance() {
            if (instance == null) {
                instance = new Bibliotheque();
            }
            return instance;
        }

        // Méthodes pour ajouter des éléments aux listes
        public void ajouterLivreFiction(LivreFiction livre) {
            ListelivreFictions.add(livre);
        }

        public void ajouterLivreNonFiction(LivreNonFiction livre) {
            ListelivreNonFictions.add(livre);
        }

        public void ajouterMembrePremium(MembrePremium membre) {
            ListemembrePremium.add(membre);
        }

        public void ajouterMembreRegular(MembreRegular membre) {
            ListemembreRegulars.add(membre);
        }

        public void ajouterPret(Pret pret) {
            Listeprets.add(pret);
        }

       // public void ajouterPretRegular(Pret pret){ListepretsRegular.add(pret);}

        public void AjouterAuteur(Auteur auteur) {ListeAuteurs.add(auteur);}

        // Méthodes pour supprimer des éléments des listes
        public void supprimerLivreFiction(LivreFiction livre) {
            ListelivreFictions.remove(livre);
        }

        public void supprimerLivreNonFiction(LivreNonFiction livre) {
            ListelivreNonFictions.remove(livre);
        }

        public void supprimerMembrePremium(MembrePremium membre) {
            ListemembrePremium.remove(membre);
        }

        public void supprimerMembreRegular(MembreRegular membre) {
            ListemembreRegulars.remove(membre);
        }

        public void supprimerPret(Pret pret) {
            Listeprets.remove(pret);
        }


        public void supprimerAuteur(Auteur auteur) {ListeAuteurs.remove(auteur);}

        public ArrayList<Auteur> getListeAuteurs() {
            return ListeAuteurs;
        }
         public void readCSVFile(String filePath) {
            String csvDelimiter = ";";

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;

                // Lecture de l'en-tête
                line = br.readLine();
                String[] headers = line.split(csvDelimiter);

                // Vérification des colonnes
                if (headers.length < 4 || !headers[0].equals("Nom") || !headers[1].equals("Prenom") || !headers[2].equals("DateNaissance") || !headers[3].equals("Nationalite")) {
                    System.out.println("Le format du fichier CSV est incorrect.");
                    return;
                }

                // Lecture des lignes de données
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvDelimiter);

                    // Vérification du nombre de colonnes
                    if (data.length >= 4) {
                        String nom = data[0];
                        String prenom = data[1];
                        String nationalite = data[3];

                        try {
                            LocalDate dateNaissance = LocalDate.parse(data[2]);
                            Auteur auteur = new Auteur(nom, prenom, dateNaissance, nationalite);
                            ListeAuteurs.add(auteur);
                        } catch (DateTimeParseException e) {
                            System.err.println("La date n'a pas pu être parsée: " + e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        public  ArrayList<Pret> getListeprets(){
            return  Listeprets;
        }

        public  ArrayList<MembrePremium> getListemembrePremium(){
            return  ListemembrePremium;
        }
        public  ArrayList<MembreRegular> getListemembreRegulars(){
            return  ListemembreRegulars;
        }
        public  ArrayList<LivreFiction> getListelivreFictions(){return ListelivreFictions;
        }
        public  ArrayList<LivreNonFiction> getListelivreNonFictions(){
            return ListelivreNonFictions;
        }

}
