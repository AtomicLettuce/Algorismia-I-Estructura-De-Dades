/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;


/**
 *
 * @author aturs
 */
//LLISTA DE TOTS ELS ESTUDIANTS-- PERMET SABRE CURS MATRICULAT I ASSIGNATURES FA 
public class Llista_Est {
    private Estudiant primer=null;

    public Llista_Est(Estudiant primer) {
        this.primer=primer;
    }
    public void afegirSeg(Estudiant seg){
         seg.setSeg(primer);
        primer = seg;
    }

    public Estudiant getPrimer() {
        return primer;
    }

    public void setPrimer(Estudiant primer) {
        this.primer = primer;
    }
    //FALTA CONTROL ERROR SI NO TROBA CODI!!!!
    public Estudiant cercadorcurs(String [] resultatusuari){
        int codi= Integer.parseInt(resultatusuari[0]);
        Estudiant aux = primer;
        while(aux.getSeg()!=null){
           /* if(aux.getCodi()==codi){
               aux.setSeg(null);
            }
            aux=aux.getSeg();*/
        }
        return aux;
    }
    public void imprimeixLLista(){
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
