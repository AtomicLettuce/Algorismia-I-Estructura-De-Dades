/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import ClassesModel.Assignatura;
import Interfaces.IntfLlista;

/**
 *
 * @author aturs
 */
//SEGONS UN CURS, LLISTA ASSIGNATURES CONTÉ ORDENADES 
//HA DE PERMETRE SABRE ELS ESTUDIANTS QUE TÉ CADA ASSIGNATURA---- LLISTA RefEst
public class Llista_Ass implements IntfLlista {

    private Assignatura primer = null;

    public Llista_Ass(Assignatura primer) {
        this.primer = primer;
    }

    // Mètode que situa el curs passat per paràmetre com a primer de la llista
    @Override
    public void afegirElement(Object obj) {
        Assignatura aux = (Assignatura) obj;
        aux.setSeg(primer);
        primer = aux;

    }

    public void afegirSeg(Assignatura seg) {
        seg.setSeg(primer);
        primer = seg;
    }

    public Assignatura getPrimer() {
        return primer;
    }

    public void setPrimer(Assignatura primer) {
        this.primer = primer;
    }

    // Mètode que comprova si compté una assignatura amb el codi passat per paràmetre
    @Override
    public boolean compte(int codi) {
        // Variable auxiliar per cercar
        Assignatura aux = primer;
        // Mentre no arribem al final, segueix iterant
        while (aux != null) {
            // Si l'hem trobat, retorna true
            if (aux.getCodi() == codi) {
                return true;
            }
            aux = aux.getSeg();
        }
        // Si no l'hem trobat retorna false
        return false;
    }

    @Override
    public void sort() {
        // No és necessari en aquesta llista ja que els ordenam a les llistes de referències
    }

    //ALERTA!! Aquest mètode no elimina l'element i-èssim. Elimina l'element amb codi i
    @Override
    public void eliminarElement(int i) {
        // Variables auxiliars per poder fer la eliminació
        Assignatura aux = primer;
        Assignatura aux2 = null;
        // Variable entera auxiliar que té la seva utilitat per si l'element que volem eliminar és el primer
        int comptador = 0;
        while (aux != null) {

            if (aux.getCodi() == i) {
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

    @Override
    public void afegirElement(Object obj, int pos) {
        // No s'ha implementat perquè no s'ha tengut necessitat d'usar-lo
    }

    @Override
    public int length() {
        int comptador = 0;
        Assignatura aux = primer;
        while (aux != null) {
            aux = aux.getSeg();
            comptador++;
        }
        return comptador;
    }

    //Mètode implementa un cercador de cursos segons el codi pasat per param
    @Override
    public Assignatura getElement(int codi) {
        // Variable auxiliar per cercar l'assignatura
        Assignatura aux = primer;
        // Mentre no haguem arribat al final, segueix iterant
        while (aux != null) {
            // Si hem trobat l'assignatura, retorna
            if ((aux.getCodi() == codi)) {
                return aux;
            }
            aux = aux.getSeg();
        }
        // Si no l'hem trobada, retorna null
        return null;
    }
    /*
    public void afegirAss(Assignatura ass) {
        add(ass);
    }

    public void ordenar(Llista_Ass llista) {
        Collections.sort(llista, new Comparator<Assignatura>() {
            public int compare(Assignatura a1, Assignatura a2) {
                return new Integer(a1.getCodi()).compareTo(new Integer(a2.getCodi()));
            }
        });
    }
    public Assignatura trobat(int codi, Llista_Ass lista){
        Assignatura aux=null;
        for (int i = 0; i < lista.size(); i++) {
            aux=(Assignatura)lista.get(i);
            if(aux.getCodi()!=codi){
                aux=null;
            }   
        }  
     return aux;    
    }

    //EN CAS IMPLEMENTAR ARRAY
    public void imprimeixLlistaAss(Llista_Ass assignatures) {
        System.out.println(assignatures);
    }*/
}
