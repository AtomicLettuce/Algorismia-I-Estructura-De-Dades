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
//segons una assignatura estudiants matriculats
public class Llista_RefEst {
    private Estudiant primer;
    
    public Llista_RefEst(Estudiant referencia){
       primer= referencia;
    }
    public void afegirSeg(Estudiant seg){
         seg.setSeg(primer);
        primer = seg;
    }
    public void ordenarEst(){
        
    }
  // Mètode que imprimeix per pantalla tot el contingut de la llista
    public void imprimeixLlistaAss() {
        Estudiant aux= primer;
        int posicio = 1;
        System.out.println("-----Inici de llista-----");
        while(aux!=null){
         System.out.println("Posicio = ");
            aux = aux.getSeg();
            posicio++;
        }   
        
        System.out.println("-----Final de llista-----");
    }   
}
