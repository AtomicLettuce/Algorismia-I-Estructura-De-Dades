package ClassesModel;

public class Curs {

    protected String nom;
    protected int codi;
    protected Curs seg;
    
    public Curs(String nom, int codi) {
        this.nom = nom;
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

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
    
    @Override
    public String toString() {
        return "Cursos{" + "nom=" + nom + ", codi=" + codi + '}';
    }
    
    

}
