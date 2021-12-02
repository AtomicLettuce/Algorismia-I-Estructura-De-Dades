package ClassesModel;

import Interfaces.IntfDades;

public class Assignatura implements IntfDades{

    protected String nom;
    protected int codi;

    public Assignatura(String nom, int codi) {
        this.nom = nom;
        this.codi = codi;
    }

    @Override
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    @Override
    public String toString() {
        return "Assignatures{" + "nom=" + nom + ", codi=" + codi + '}';
    }

}
