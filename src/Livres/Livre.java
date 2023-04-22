package Livres;
import Auteur.Auteur;

public abstract class Livre
{
    private String titre;
    private int anneePublication;
    private Auteur auteur;
    private double prix;
    private long isbn;
    private boolean disponible;
    private String editeur;


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public Auteur getAuteursnom() {
        return auteur;
    }

    public void setAuteurs(Auteur auteurs) {
        this.auteur = auteurs;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Livre()// const defaut
    {
        this.titre = "";
        this.anneePublication = 0;
        this.auteur =null;
        this.prix = 0.0;
        this.isbn = 0L;
        this.disponible = false;
        this.editeur = "";
    }
    //const init
    public Livre(String titre, int anneePublication, Auteur auteur, double prix, long isbn, boolean disponible, String editeur) {
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.auteur = auteur;
        this.prix = prix;
        this.isbn = isbn;
        this.disponible = disponible;
        this.editeur = editeur;
    }


    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", anneePublication=" + anneePublication +
                ", auteurs=" + auteur.getNom() +
                ", prix=" + prix +
                ", isbn=" + isbn +
                ", disponible=" + disponible +
                ", editeur='" + editeur + '\'' +
                '}';
    }
   /* public void Affiche() {
        System.out.println(this);
    }*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livre livre)) return false;
        if (getAnneePublication() != livre.getAnneePublication()) return false;
        if (Double.compare(livre.getPrix(), getPrix()) != 0) return false;
        if (getIsbn() != livre.getIsbn()) return false;
        if (isDisponible() != livre.isDisponible()) return false;
        if (getTitre() != null ? !getTitre().equals(livre.getTitre()) : livre.getTitre() != null) return false;
        if (getAuteursnom() != null ? !getAuteursnom().equals(livre.getAuteursnom()) : livre.getAuteursnom() != null) return false;
        return getEditeur() != null ? getEditeur().equals(livre.getEditeur()) : livre.getEditeur() == null;
    }
}
