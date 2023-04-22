package Membres;
import java.time.LocalDate;

public class Test
{
    public static void main(String[] args)
    {
        Membre membre1 = new Membre("Jean Dupont", "123 rue des fleurs", 1, LocalDate.now());
        Membre membre2 = new Membre("Marie Martin", "456 avenue des oiseaux", 2, LocalDate.of(2022, 3, 15));

        System.out.println(membre1.toString());
        System.out.println(membre2.toString());



        MembrePremium membre3 = new MembrePremium();
        membre3.setNom("Dupont");
        membre3.setAdresse("5 rue des Lilas");
        membre3.setNumeroMembre(12345);
        membre3.setDateInscription(LocalDate.of(2022, 3, 15));
        membre3.setPrixAbo(49.99);

        membre3.Affiche();


        MembreRegular membre4 = new MembreRegular();
        membre4.setNom("Dupont");
        membre4.setAdresse("12 rue des Lilas, Paris");
        membre4.setNumeroMembre(123456);
        membre4.setDateInscription(LocalDate.now());
        membre4.setNbrLivreMax(3);

        System.out.println("Nom : " + membre4.getNom());
        System.out.println("Adresse : " + membre4.getAdresse());
        System.out.println("Numéro de membre : " + membre4.getNumeroMembre());
        System.out.println("Date d'inscription : " + membre4.getDateInscription());
        System.out.println("Nombre de livres maximum : " + membre4.getNbrLivreMax());


    }
}
