package Auteur;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {

        // Création d'un auteur avec le constructeur par défaut
        Auteur auteur1 = new Auteur();
       // System.out.println(auteur1);
        auteur1.Affiche();

        // Modification des attributs de l'auteur
        auteur1.setNom("Doe");
        auteur1.setPrenom("John");
        auteur1.setDateNaissance(LocalDate.of(1980, 5, 10));
        auteur1.setNationalite("Américaine");

        // Affichage de l'auteur
        System.out.println(auteur1);
        auteur1.Affiche();

        // Création d'un auteur avec le constructeur paramétré
        Auteur auteur2 = new Auteur("Doe", "Jane", LocalDate.of(1985, 8, 20), "Canadienne");
        System.out.println(auteur2);
        auteur2.Affiche();

        // Comparaison de deux auteurs
        System.out.println("auteur1 et auteur2 sont égaux : " + auteur1.equals(auteur2));

        // Création d'un autre auteur avec les mêmes attributs que auteur1
        Auteur auteur3 = new Auteur("Doe", "John", LocalDate.of(1980, 5, 10), "Américaine");

        // Comparaison de deux auteurs avec les mêmes attributs
        System.out.println("auteur1 et auteur3 sont égaux : " + auteur1.equals(auteur3));
    }

}
