/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import java.util.Arrays;


/**
 *
 * @author aturs
 */
//LLISTA DE TOTS ELS ESTUDIANTS-- PERMET SABRE CURS MATRICULAT I ASSIGNATURES FA 
public class Llista_Est {

    private Estudiant primer = null;

    public Llista_Est(Estudiant primer) {
        this.primer = primer;
    }

    public void afegirSeg(Estudiant seg) {
        seg.setSeg(primer);
        primer = seg;
    }

    public Estudiant getPrimer() {
        return primer;
    }

    public void setPrimer(Estudiant primer) {
        this.primer = primer;
    }

    public Estudiant getElement(int Dni) {
        Estudiant aux = primer;
        while (aux != null) {
            if (aux.getCodi() == Dni) {
                return aux;
            }
            aux = aux.getSeg();
        }
        return null;
    }
    public Estudiant getElement2(String nom){
     Estudiant aux = primer;
        while (aux != null) {
            //Si els noms son iguals
            if (aux.getNom().compareTo(nom)==0) {
                return aux;
            }
            aux = aux.getSeg();
        }
        return null;  
    }
    public String[] ordrealfabetic(Llista_RefEst ref, Llista_Est est) {
        //obtenim llargÃ ria llista
        int n = ref.length();
        int Dni;
        //Array noms estudiants
        String noms[] = new String[n];
        //Array estudiants ordenats 
        String[]ordenats=new String[n];
        
        //Cercam els noms dels estudiants de cada assignatura
        for (int j = 0; j < n; j++) {
            Dni = ref.getElement(j).getCodi();
            noms[j] = est.getElement(Dni).getNom();  
           
        }
        //Ordenam alfabeticament array de noms 
        Arrays.sort(noms, String.CASE_INSENSITIVE_ORDER);
        //Obtenims els objectes estudiants
        for (int i = 0; i < n; i++) {
            ordenats[i]=getElement2(noms[i]).toString();
        }
        return ordenats;
    }

    public void imprimeixLLista() {
        Estudiant aux = primer;
        int posicio = 1;
        System.out.println("-----Inici de llista-----");
        while (aux != null) {
            System.out.println("Posicio = " + posicio + " NOM: " + aux.getNom());
            aux = aux.getSeg();
            posicio++;
        }
        System.out.println("-----Final de llista-----");
    }

}
