package Pret;
import Livres.Livre;
import Livres.LivreFiction;
import Membres.Membre;
import java.time.LocalDate;
import Auteur.Auteur;

public class Test
{
    public static void main(String[] args) {
        LivreFiction livre1;
        livre1 = new LivreFiction("Titre du livre 1", 2022, new Auteur("Gayet", "Bastien", LocalDate.of(1996, 11, 15), "Belge"), 19.99, 1234567890L, true,"Thomas","S-F");

        // Création d'un membre
        Membre membre1 = new Membre("Nom du membre 1", "Adresse du membre 1", 1, LocalDate.now());
        LocalDate today = LocalDate.now();
        LocalDate dateRetour= today.plusDays(5);
        // Création d'un prêt
        Pret pret1 = new Pret(livre1, membre1, LocalDate.now(),dateRetour);

// Affichage des informations du prêt
        pret1.Affiche();
    }
}
