package Bibliotheque;
import Livres.*;
import  Membres.*;
import Auteur.Auteur;
import Pret.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
        private static Bibliotheque instance = null;

        private List<LivreFiction> livreFictions;
        private List<LivreNonFiction> livreNonFictions;
        private List<MembrePremium> membresPremium;
        private List<MembreRegular> membreRegulars;
        private List<Pret> prets;

        private Bibliotheque() {
            this.livreFictions = new ArrayList<>();
            this.livreNonFictions = new ArrayList<>();
            this.membresPremium = new ArrayList<>();
            this.membreRegulars = new ArrayList<>();
            this.prets = new ArrayList<>();
        }

        public static Bibliotheque getInstance() {
            if (instance == null) {
                instance = new Bibliotheque();
            }
            return instance;
        }

        // Méthodes pour ajouter des éléments aux listes
        public void ajouterLivreFiction(LivreFiction livre) {
            livreFictions.add(livre);
        }

        public void ajouterLivreNonFiction(LivreNonFiction livre) {
            livreNonFictions.add(livre);
        }

        public void ajouterMembrePremium(MembrePremium membre) {
            membresPremium.add(membre);
        }

        public void ajouterMembreRegular(MembreRegular membre) {
            membreRegulars.add(membre);
        }

        public void ajouterPret(Pret pret) {
            prets.add(pret);
        }

        // Méthodes pour supprimer des éléments des listes
        public void supprimerLivreFiction(LivreFiction livre) {
            livreFictions.remove(livre);
        }

        public void supprimerLivreNonFiction(LivreNonFiction livre) {
            livreNonFictions.remove(livre);
        }

        public void supprimerMembrePremium(MembrePremium membre) {
            membresPremium.remove(membre);
        }

        public void supprimerMembreRegular(MembreRegular membre) {
            membreRegulars.remove(membre);
        }

        public void supprimerPret(Pret pret) {
            prets.remove(pret);
        }

        // Méthodes pour modifier des éléments des listes
        public void modifierLivreFiction(LivreFiction ancienLivre, LivreFiction nouveauLivre) {
            int index = livreFictions.indexOf(ancienLivre);
            if (index != -1) {
                livreFictions.set(index, nouveauLivre);
            }
        }

        public void modifierLivreNonFiction(LivreNonFiction ancienLivre, LivreNonFiction nouveauLivre) {
            int index = livreNonFictions.indexOf(ancienLivre);
            if (index != -1) {
                livreNonFictions.set(index, nouveauLivre);
            }
        }

        public void modifierMembrePremium(MembrePremium ancienMembre, MembrePremium nouveauMembre) {
            int index = membresPremium.indexOf(ancienMembre);
            if (index != -1) {
                membresPremium.set(index, nouveauMembre);
            }
        }

        public void modifierMembreRegular(MembreRegular ancienMembre, MembreRegular nouveauMembre) {
            int index = membreRegulars.indexOf(ancienMembre);
            if (index != -1) {
                membreRegulars.set(index, nouveauMembre);
            }
        }

        public void modifierPret(Pret pret, LocalDate dateRetour, boolean prolonge){
            if(prets.contains(pret))
            {
                int index = prets.indexOf(pret);
                Pret pretmodifier = prets.get(index);

                pretmodifier.setDateRetour(dateRetour);

                prets.set(index,pretmodifier);
                System.out.println("Le prêt a été modifié avec succès.");
            }
            else
            {
                System.out.println("Le prêt n'a pas été trouvé dans la bibliothèque.");
            }
        }

}
