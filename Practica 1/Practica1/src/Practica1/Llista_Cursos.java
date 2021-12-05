package Practica1;

import ClassesModel.Curs;
import Interfaces.IntfLlista;
//Aquesta llista son punters
//LLISTA TOTS ELS CURSOS DONATS D'ALTA
//Ha de permetre sabre les assignatures conté cada curs --- LIST ASS

public class Llista_Cursos implements IntfLlista {

    private Curs primer = null;

    @Override
    public int length() {
        int retorn = 0;
        Curs aux = primer;
        while (aux != null) {
            retorn++;
            aux = aux.getSeg();
        }
        return retorn;
    }

    public Llista_Cursos(Curs primer) {
        this.primer = primer;
    }

    @Override
    public void afegirElement(Object obj) {
        Curs seg = (Curs) obj;
        seg.setSeg(primer);
        primer = seg;
    }

    public Curs getPrimer() {
        return primer;
    }

    public void setPrimer(Curs primer) {
        this.primer = primer;
    }

    //ALERTA! Aquest mètode no retorna l'element i-èssim, aquest mètode
    // Retorna el curs que té per codi l'especificat per paràmetre
    @Override
    public Curs getElement(int codi) {
        // Variable auxiliar per fer la cerca
        Curs aux = primer;
        // Mentre no haguem arribat al final, segueix iterant
        while (aux != null) {
            // Si l'hem trobat, retorna'l
            if ((aux.getCodi() == codi)) {
                return aux;
            }
            aux = aux.getSeg();
        }
        return null;
    }

    public Curs getElementPos(int i) {
        Curs retorn = primer;
        for (int j = 0; (j < i) && (retorn != null); j++) {
            retorn = retorn.getSeg();
        }

        return retorn;
    }

    @Override
    public void sort() {
        // No és necessari per aquesta llista
    }

    @Override
    public void afegirElement(Object obj, int pos) {
        // no es necessari per aquesta llista
    }

    // Mètode que comprova si hi ha un element amb el codi que s'ha especificat per paràmetre
    @Override
    public boolean compte(int codi) {
        Curs aux = primer;
        while (aux != null) {
            if (aux.getCodi() == codi) {
                return true;
            }
            aux = aux.getSeg();
        }
        return false;
    }

    // Per eliminar el curs que te per codi l'especificat per paràmetre
    @Override
    public void eliminarElement(int codi) {
        Curs aux = primer;
        Curs aux2 = primer;
        // Variable entera auxiliar que té la seva utilitat per si l'element que volem eliminar és el primer
        int comptador = 0;
        while (aux != null) {

            if (aux.getCodi() == codi) {
                // Si l'Assignatura que volem eliminar és la primera, canviam el punter primer
                // Per tal de que quedi eliminada
                if (comptador == 0) {
                    primer = aux.getSeg();

                }// Si no és la primera, feim un canvi de punters amb l'assignatura que ocupa la posició anterior
                else {
                    aux2.setSeg(aux.getSeg());
                }
            }
            // Per seguir recorrent la llista
            aux2 = aux;
            aux = aux.getSeg();
            comptador++;

        }
    }

    public void imprimeixLLista() {
        Curs aux = primer;
        Llista_Ass prova;
        System.out.println("-----Inici de llista-----");
        while (aux != null) {
            System.out.println(aux.toString());
            aux = aux.getSeg();
        }
        System.out.println("-----Final de llista-----");
    }
}
