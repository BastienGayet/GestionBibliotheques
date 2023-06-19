package Auteur;

import java.io.Serializable;
import java.time.LocalDate;

public class Auteur
{
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Auteur()
    {
        nom="";
        prenom = "";
        dateNaissance = LocalDate.now();
        nationalite = "";
    }
    public Auteur(String nom, String prenom, LocalDate dateNaissance, String nationalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "Auteur" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", nationalite='" + nationalite + '\'';
    }
   public void Affiche() {
        System.out.println(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Auteur auteur)) return false;
        if (getNom() != null ? !getNom().equals(auteur.getNom()) : auteur.getNom() != null) return false;
        if (getPrenom() != null ? !getPrenom().equals(auteur.getPrenom()) : auteur.getPrenom() != null) return false;
        if (getDateNaissance() != null ? !getDateNaissance().equals(auteur.getDateNaissance()) : auteur.getDateNaissance() != null)
            return false;
        return getNationalite() != null ? getNationalite().equals(auteur.getNationalite()) : auteur.getNationalite() == null;
    }

}
