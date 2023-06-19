package Membres;

import java.time.LocalDate;

public class MembrePremium extends Membre
{
    private double prixAbo;

    public MembrePremium()
    {
        super("","",0,LocalDate.now());
        this.prixAbo = 0;
    }
    public MembrePremium(String nom, String adresse, int numeroMembre, LocalDate dateInscription, double prixAbo) {
        super(nom, adresse, numeroMembre, dateInscription);
        this.prixAbo = prixAbo;
    }

    public double getPrixAbo() {
        return prixAbo;
    }

    public void setPrixAbo(double prixAbo) {
        this.prixAbo = prixAbo;
    }

    public void Affiche() {
        System.out.println(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MembrePremium that)) return false;
        if (!super.equals(o)) return false;

        return Double.compare(that.getPrixAbo(), getPrixAbo()) == 0;
    }

    @Override
    public String toString() {
        return   "Membre Premium n°" + getNumeroMembre() + " - " + getNom();
    }
}
