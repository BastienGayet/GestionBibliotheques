package Bibliotheque;
import Livres.*;
import  Membres.*;
import Auteur.Auteur;
import Pret.*;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            ListeAuteurs.add(new Auteur("Hugo", "Victor", LocalDate.parse("1802-02-26"), "Français"));
            ListeAuteurs.add(new Auteur("Tolkien", "J.R.R.", LocalDate.parse("1892-01-03"), "Britannique"));
            ListeAuteurs.add(new Auteur("Rowling", "J.K.", LocalDate.parse("1965-07-31"), "Britannique"));
            ListeAuteurs.add(new Auteur("Austen", "Jane", LocalDate.parse("1775-12-16"), "Britannique"));
            ListeAuteurs.add(new Auteur("Hemingway", "Ernest", LocalDate.parse("1899-07-21"), "Américain"));


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

        // Méthodes pour modifier des éléments des listes
        public void modifierLivreFiction(LivreFiction ancienLivre, LivreFiction nouveauLivre) {
            int index = ListelivreFictions.indexOf(ancienLivre);
            if (index != -1) {
                ListelivreFictions.set(index, nouveauLivre);
            }
        }

        public void modifierLivreNonFiction(LivreNonFiction ancienLivre, LivreNonFiction nouveauLivre) {
            int index = ListelivreNonFictions.indexOf(ancienLivre);
            if (index != -1) {
                ListelivreNonFictions.set(index, nouveauLivre);
            }
        }

        public void modifierMembrePremium(MembrePremium ancienMembre, MembrePremium nouveauMembre) {
            int index = ListemembrePremium.indexOf(ancienMembre);
            if (index != -1) {
                ListemembrePremium.set(index, nouveauMembre);
            }
        }

        public void modifierMembreRegular(MembreRegular ancienMembre, MembreRegular nouveauMembre) {
            int index = ListemembreRegulars.indexOf(ancienMembre);
            if (index != -1) {
                ListemembreRegulars.set(index, nouveauMembre);
            }
        }

        public void modifierPret(Pret pret, LocalDate dateRetour, boolean prolonge){
            if(Listeprets.contains(pret))
            {
                int index = Listeprets.indexOf(pret);
                Pret pretmodifier = Listeprets.get(index);

                pretmodifier.setDateRetour(dateRetour);

                Listeprets.set(index,pretmodifier);
                System.out.println("Le prêt a été modifié avec succès.");
            }
            else
            {
                System.out.println("Le prêt n'a pas été trouvé dans la bibliothèque.");
            }
        }

        public  void modifierAuteur(Auteur ancienauteur, Auteur nouveauauteurs)
        {
            int index = ListeAuteurs.indexOf(ancienauteur);
            if(index !=-1)
            {
                ListeAuteurs.set(index,nouveauauteurs);
            }
        }

        // Méthode pour obtenir la liste d'auteurs
        public ArrayList<Auteur> getListeAuteurs() {
            return this.ListeAuteurs;
        }

        public  ArrayList<Pret> getListeprets(){
            return  this.Listeprets;
        }
        public  ArrayList<MembrePremium> getListemembrePremium(){
            return  this.ListemembrePremium;
        }
        public  ArrayList<MembreRegular> getListemembreRegulars(){
            return  this.ListemembreRegulars;
        }
        public  ArrayList<LivreFiction> getListelivreFictions(){return this.ListelivreFictions;
        }
        public  ArrayList<LivreNonFiction> getListelivreNonFictions(){
            return this.ListelivreNonFictions;
        }



}
