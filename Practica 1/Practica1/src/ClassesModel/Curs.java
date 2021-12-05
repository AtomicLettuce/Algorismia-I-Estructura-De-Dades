package ClassesModel;

import Interfaces.IntfDades;

public class Curs implements IntfDades {

    protected String nom;
    protected int codi;
    protected Curs seg;
    protected int[] referenciesAss;
    // Variable que compta quantes Assignatures s'han afegit al curs
    protected int nAss;
    protected boolean esFP;


    public Curs(String nom, int codi) {
        this.nom = nom;
        this.codi = codi;
        this.nAss = 0;
    }
    public boolean compte(int codi){
        for(int i=0;i<referenciesAss.length;i++){
            if(referenciesAss[i]==codi){
                return true;
            }
        }
        return false;
    }
    
    public boolean esFP(){
        return esFP;
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

    public int[] getReferenciesAss() {
        return referenciesAss;
    }

    // Mètode que inicialitza l'array de Referències a Assignatures
    public void inicialitzarLlistaAss(int num) {
        referenciesAss = new int[num];
        // L'inicialitzam tot a -1 per evitar possibles problemes
        for (int i = 0; i < referenciesAss.length; i++) {
            referenciesAss[i] = -1;
        }
    }

    public void afegirAss(int codi) {
        // Afegim el nou codi a l'array de referències i incrementam en 1 nAss
        // per tal de que la pròxima vegada que usem el mètode apunti on toca
        referenciesAss[nAss] = codi;
        nAss++;
    }

    public void eliminarAss(int codi) {
        // Booleana que controlarà si s'ha eliminat l'element donat
        boolean eliminat = false;
        // Cream array auxiliar d'una posició menys
        int[] aux = new int[referenciesAss.length - 1];
        // Recorrem tot l'array
        for (int i = 0, j = 0; i < referenciesAss.length; i++) {
            // Mentre que no sigui el codi indicat seguim copiant
            if (referenciesAss[i] != codi) {
                aux[j] = referenciesAss[i];
                j++;
            }
            // Si hem trobat el codi indicat NO EL COPIAM, decrementam nAss en 1
            // i posam la darrera casella a -1 per indicar que no hi ha cap assignatura en aquella posició
            if (referenciesAss[i] == codi) {
                nAss--;
                eliminat = true;
            }
        }
        if (eliminat) {
            referenciesAss = aux;
        }
    }

    //ordenacio d'array pel metode de la bombolla.Atenció ordena de menor a major
    public void ordenacioReferencies() {
        int aux_elem;
        for (int i = 0; i < referenciesAss.length - 1; i++) {
            for (int j = 1; j < referenciesAss.length; j++) {
                if (referenciesAss[j] < referenciesAss[j - 1]) {   // si el elemento anterior es mayor, hacemos el cambio
                    aux_elem = referenciesAss[j];
                    referenciesAss[j] = referenciesAss[j - 1];
                    referenciesAss[j - 1] = aux_elem;

                }
            }
        }
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
        return "Cursos{" + "nom=" + nom + ", codi=" + codi + "}";
    }

}
