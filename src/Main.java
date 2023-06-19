
import Auteur.*;
import Livres.*;
import Membres.*;
import Pret.*;


import java.time.LocalDate;

public class Main {

    public static void main(String args[])
    {

        // Création d'un auteur
        Auteur auteur1 = new Auteur("J.K.Rowling", "Royaume-Uni",LocalDate.now(), "Anglais");

        // Création d'un livre
        LivreNonFiction livre1 = new LivreNonFiction("Harry Potter et la pierre philosophale", 1997,  "J.K.R", 12.99, 9782070541261L, true, "Gallimard","Historique");

        // Création d'un membre
        Membre membre1 = new Membre("Dupont", "3 rue des Lilas, Paris", 123456, LocalDate.now());
        MembreRegular membre= new MembreRegular("Gayet","rue d ela chapelle 11 4347 fexhe", 123456789,LocalDate.now() ,5);
        // Création d'un prêt
        Pret pret1 = new Pret(livre1, membre1, LocalDate.of(2022, 4, 1));

        membre.Affiche();

    }


}
