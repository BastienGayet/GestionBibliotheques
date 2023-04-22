package Livres;
import Auteur.Auteur;

public class LivreFiction extends Livre
{
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LivreFiction() {
        super("", 0, new Auteur(), 0.0, 0, false, "");
        this.genre = "";
    }

    public LivreFiction(String titre, int anneePublication, Auteur auteurs, double prix, long isbn, boolean disponible, String editeur, String genre) {
        super(titre, anneePublication, auteurs, prix, isbn, disponible, editeur);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + "LivreFiction{" +
                "genre='" + genre + '\'' +
                '}';
    }
   /* public void Affiche() {
        System.out.println(this);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivreFiction that)) return false;
        if (!super.equals(o)) return false;

        return getGenre() != null ? getGenre().equals(that.getGenre()) : that.getGenre() == null;
    }




}
