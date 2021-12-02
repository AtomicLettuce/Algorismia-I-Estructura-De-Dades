/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import ClassesModel.Assignatura;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author aturs
 */
//SEGONS UN CURS, LLISTA ASSIGNATURES CONTÉ ORDENADES 
//HA DE PERMETRE SABRE ELS ESTUDIANTS QUE TÉ CADA ASSIGNATURA---- LLISTA RefEst
public class Llista_Ass extends ArrayList{
     private Assignatura primer = null;

   public Llista_Ass(Assignatura primer) {
        this.primer = primer;
    }
   public void afegirAss(Assignatura ass){
       add(ass);
   }
   public void ordenar(Assignatura ass){
       /*sort(new Comparator<Assignatura>){
       @Override
       public Assignatura compare(Assignatura a, Assignatura b){
           if(a.getNom().compareTo(b.getNom()).equals(a.getNom())){
               return a;
           }else{
               return b;
           }
       }
   }*/
   }
   
   //EN CAS IMPLEMENTAR ARRAY
    public void imprimeixLlistaAss(Llista_Ass assignatures) {
        System.out.println(assignatures);
    }
   
   
}
   
