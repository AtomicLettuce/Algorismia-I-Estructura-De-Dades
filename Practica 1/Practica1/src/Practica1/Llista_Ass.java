/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import ClassesModel.Assignatura;

/**
 *
 * @author aturs
 */
//SEGONS UN CURS, LLISTA ASSIGNATURES CONTÉ ORDENADES 
//HA DE PERMETRE SABRE ELS ESTUDIANTS QUE TÉ CADA ASSIGNATURA---- LLISTA RefEst
public class Llista_Ass {

    private Assignatura primer = null;

    public Llista_Ass(Assignatura primer) {
        this.primer = primer;
    }
   
    // Mètode que situa el curs passat per paràmetre com a primer de la llista
    public void afegirprimer(Assignatura aux){
        aux.setSeg(primer);
        primer = aux;

    }
    public void afegirSeg(Assignatura seg){
         seg.setSeg(primer);
        primer = seg;
    }
    public Assignatura getPrimer() {
        return primer;
    }

    public void setPrimer(Assignatura primer) {
        this.primer = primer;
    }
    
    //Mètode implementa un cercador de cursos segons el codi pasat per param
    public Assignatura cercadorAss(int codi){
        // Variable auxiliar per cercar l'assignatura
        Assignatura aux = primer;
        // Mentre no haguem arribat al final, segueix iterant
        while(aux!=null){
            // Si hem trobat l'assignatura, retorna
            if((aux.getCodi()==codi)){
              return aux;
            }
            aux=aux.getSeg();
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
