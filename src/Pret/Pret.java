package Pret;
import Livres.Livre;
import Membres.Membre;
import Membres.MembrePremium;

import java.time.LocalDate;

public class Pret
{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pret pret)) return false;

        if (getBorrowedLivres() != null ? !getBorrowedLivres().equals(pret.getBorrowedLivres()) : pret.getBorrowedLivres() != null)
            return false;
        if (getBorrowingMembre() != null ? !getBorrowingMembre().equals(pret.getBorrowingMembre()) : pret.getBorrowingMembre() != null)
            return false;
        return getDateEmprunt() != null ? getDateEmprunt().equals(pret.getDateEmprunt()) : pret.getDateEmprunt() == null;
    }



    private Livre borrowedLivres;
    private Membre borrowingMembre;
    private LocalDate dateEmprunt;


    public Pret() {
        this.borrowedLivres = null;
        this.borrowingMembre = null;
        this.dateEmprunt = null;

    }
    public Pret(Livre borrowedLivres, Membre borrowingMembre, LocalDate dateEmprunt) {
        this.borrowedLivres = borrowedLivres;
        this.borrowingMembre = borrowingMembre;
        this.dateEmprunt = dateEmprunt;

    }

    public Livre getBorrowedLivres() {
        return borrowedLivres;
    }

    public void setBorrowedLivres(Livre borrowedLivres) {
        this.borrowedLivres = borrowedLivres;
    }

    public Membre getBorrowingMembre() {
        return borrowingMembre;
    }

    public void setBorrowingMembre(Membre borrowingMembre) {
        this.borrowingMembre = borrowingMembre;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }



    @Override
    public String toString() {
        return "Pret" +
                "borrowedLivres=" + borrowedLivres.getTitre() +
                ", borrowingMembre=" + borrowingMembre.getNom() +
                ", dateEmprunt=" + dateEmprunt;
    }


    public void Affiche() {
        System.out.println(this);
    }
}
