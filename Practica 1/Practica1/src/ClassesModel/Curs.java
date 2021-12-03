package ClassesModel;

import Interfaces.IntfDades;
import Practica1.Llista_Ass;

public class Curs implements IntfDades {

    protected String nom;
    protected int codi;
    protected Curs seg;
    protected Llista_Ass assignatures;
    public Curs(String nom, int codi,Llista_Ass assignatures) {
        this.nom = nom;
        this.codi = codi;
        this.assignatures=assignatures;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getCodi() {
        return codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public Curs getSeg() {
        return seg;
    }

    public void setSeg(Curs seg) {
        this.seg = seg;
    }

    public Llista_Ass getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(Llista_Ass assignatures) {
        this.assignatures = assignatures;
    }
    
    @Override
    public String toString() {
        return "Cursos{" + "nom=" + nom + ", codi=" + codi + '}';
    }
    
    

}
