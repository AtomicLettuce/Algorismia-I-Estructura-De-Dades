package Practica1;

import ClassesModel.Curs;
//Aquesta llista son punters
//LLISTA TOTS ELS CURSOS DONATS D'ALTA
//Ha de permetre sabre les assignatures conté cada curs --- LIST ASS
public class Llista_Cursos {
    
  private Curs primer = null;

    public Llista_Cursos(Curs primer) {
        this.primer = primer;
    }
    // Mètode que situa el curs passat per paràmetre com a primer de la llista
    public void afegirprimer(Curs aux){
        aux.setSeg(primer);
        primer = aux;

    }
    public void afegirSeg(Curs seg){
         seg.setSeg(primer);
        primer = seg;
    }
    public Curs getPrimer() {
        return primer;
    }

    public void setPrimer(Curs primer) {
        this.primer = primer;
    }
    
    //Mètode implementa un cercador de cursos segons el codi pasat per param
    public Curs cercadorcurs(int codi){
        // Variable auxiliar per fer la cerca
        Curs aux = primer;
        // Mentre no haguem arribat al final, segueix iterant
        while(aux!=null){
            // Si l'hem trobat, retorna'l
            if((aux.getCodi()==codi)){
                return aux;
            }
            aux=aux.getSeg();
        }
        return null;
    }
    
    public void eliminarElement(int codi){
        // ELIMINAR CURS
    }
    
    public void imprimeixLLista(){
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
