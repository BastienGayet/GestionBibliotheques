package Membres;

import java.time.LocalDate;

public class Membre
{
    private String nom;
    private String adresse;
    private int numeroMembre;
    private LocalDate dateInscription;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumeroMembre() {
        return numeroMembre;
    }

    public void setNumeroMembre(int numeroMembre) {
        this.numeroMembre = numeroMembre;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }
    public Membre(){
        nom="";
        adresse = "";
        numeroMembre = 0;
        dateInscription = LocalDate.now();
    }

    public Membre(String nom, String adresse, int numeroMembre, LocalDate dateInscription) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroMembre = numeroMembre;
        this.dateInscription = dateInscription;
    }
    @Override
    public String toString() {
        return "Membre{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", numeroMembre=" + numeroMembre +
                ", dateInscription=" + dateInscription +
                '}';
    }
    public void Affiche() {
        System.out.println(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Membre membre)) return false;

        if (getNumeroMembre() != membre.getNumeroMembre()) return false;
        if (!getNom().equals(membre.getNom())) return false;
        if (!getAdresse().equals(membre.getAdresse())) return false;
        return getDateInscription().equals(membre.getDateInscription());
    }

}
