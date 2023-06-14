package Livres;
import java.time.LocalDate;
import Auteur.Auteur;
public class Test
{
        public static void main(String[] args) {
            // Création d'un auteur
            Auteur auteur1 = new Auteur("Doe", "John", LocalDate.of(1985, 2, 20), "Américain");

            // Création d'un livre
            LivreFiction livre1 = new LivreFiction("Titre du livre", 2022, "Doe", 20.5, 9781234567890L, true, "Editions ABC","Fantastique");

            // Affichage des informations du livre
            System.out.println("Titre : " + livre1.getTitre());
            System.out.println("Année de publication : " + livre1.getAnneePublication());
            System.out.println("Prix : " + livre1.getPrix());
            System.out.println("ISBN : " + livre1.getIsbn());
            System.out.println("Disponible : " + livre1.isDisponible());
            System.out.println("Editeur : " + livre1.getEditeur());

            // Affichage des informations de l'auteur du livre
           // System.out.println("Auteur : " + livre1.getAuteurs().getNom() + " " + livre1.getAuteurs().getPrenom());
           // System.out.println("Date de naissance de l'auteur : " + livre1.getAuteurs().getDateNaissance());
           // System.out.println("Nationalité de l'auteur : " + livre1.getAuteurs().getNationalite());
            livre1.toString();






           // Auteur auteur = new Auteur("Smith", "John", LocalDate.of(1985, 5, 12), "Américain");

            // Création d'un livre de fiction
            LivreFiction livreFiction = new LivreFiction();
            livreFiction.setTitre("Titre du livre de fiction");
            livreFiction.setAnneePublication(2022);
            livreFiction.setAuteurs("John");
            livreFiction.setPrix(15.99);
            livreFiction.setIsbn(1234567890123L);
            livreFiction.setDisponible(true);
            livreFiction.setEditeur("Éditions de la Fiction");
            livreFiction.setGenre("Science-fiction");

            // Affichage des informations du livre de fiction
            System.out.println(livreFiction.toString());





             //Auteur auteurs = new Auteur("Doe", "John", LocalDate.of(1970, 1, 1), "USA");
            LivreNonFiction livre = new LivreNonFiction("Therorie java", 2022, "Doe", 20.5, 1234567890123L, true, "Éditeur", "Informatique");
            System.out.println(livre.toString());
        }




}
