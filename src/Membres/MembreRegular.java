package Membres;

import java.time.LocalDate;

public class MembreRegular  extends Membre
{
    private  int nbrLivreMax;

    public  MembreRegular()
    {
        super("","",0,LocalDate.now());
        this.nbrLivreMax=0;
    }
    public MembreRegular(String nom, String adresse, int numeroMembre, LocalDate dateInscription, int nbrLivreMax) {
        super(nom, adresse, numeroMembre, dateInscription);
        this.nbrLivreMax = nbrLivreMax;
    }

    public int getNbrLivreMax() {
        return nbrLivreMax;
    }

    public void setNbrLivreMax(int nbrLivreMax) {
        this.nbrLivreMax = nbrLivreMax;
    }

    @Override
    public String toString() {
        return  "Membre Regular n°" + getNumeroMembre() + " - " + getNom();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MembreRegular that)) return false;
        if (!super.equals(o)) return false;

        return getNbrLivreMax() == that.getNbrLivreMax();
    }

}
