package Practica1;

import Interfaces.IntfDades;

public class Estudiant implements IntfDades {

    private String nom;
    private int DNI;
    private Estudiant seg;

    public Estudiant(String nom, int DNI) {
        this.nom = nom;
        this.DNI = DNI;
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
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Estudiant getSeg() {
        return seg;
    }

    public void setSeg(Estudiant seg) {
        this.seg = seg;
    }

    @Override
    public String toString() {
        return "Estudiant{" + "nom=" + nom + ", DNI=" + DNI + '}';
    }

}
