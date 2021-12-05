package ClassesModel;

import Interfaces.IntfDades;
import Practica1.Llista_RefEst;
import Practica1.NodeReferenciaEstudiant;

public class Assignatura implements IntfDades {

    protected String nom;
    protected int codi;
    protected Assignatura seg;
    protected Llista_RefEst llistaEst;

    public Assignatura(String nom, int codi) {
        this.nom = nom;
        this.codi = codi;
        this.llistaEst = new Llista_RefEst();
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

    public Assignatura getSeg() {
        return seg;
    }

    public void setSeg(Assignatura seg) {
        this.seg = seg;
    }

    @Override
    public String toString() {
        return "Assignatures{" + "nom=" + nom + ", codi=" + codi + '}';
    }

    // Mètode per ordenar la llista d'estudiants d'una assignatura
    public void ordenarEst() {
        llistaEst.sort();
    }

    // Per obtenir l'element i-èssim de la llista de ref estudiants
    public NodeReferenciaEstudiant getElement(int i) {
        return llistaEst.getElement(i);
    }

    // Per matricular un alumne
    public void afegirEstudiant(NodeReferenciaEstudiant node) {
        llistaEst.afegirElement(node);
    }

    // Per donar de baixa tots els alumnes de l'assignatura
    public void eliminarLlista() {
        llistaEst = new Llista_RefEst();
    }
}
