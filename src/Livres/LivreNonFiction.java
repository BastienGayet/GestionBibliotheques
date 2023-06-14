package Livres;
import Auteur.Auteur;
public class LivreNonFiction  extends Livre
{
    private String domaine;

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }
    public LivreNonFiction() {
        super("", 0, "", 0.0, 0, false, "");
        this.domaine = "";
    }

    public LivreNonFiction(String titre, int anneePublication, String auteurs, double prix, long isbn, boolean disponible, String editeur, String domaine) {
        super(titre, anneePublication,auteurs, prix, isbn, disponible, editeur);
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return  super.toString() + "LivreNonFiction{" +
                "domaine='" + domaine + '\'' +
                '}';
    }
    /*public void Affiche() {
        System.out.println(this);
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivreNonFiction that)) return false;
        if (!super.equals(o)) return false;

        return getDomaine().equals(that.getDomaine());
    }

}

