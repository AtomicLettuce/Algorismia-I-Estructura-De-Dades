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
    public Curs cercadorcurs(String [] resultatusuari){
        int codi= Integer.parseInt(resultatusuari[0]);
        Curs aux = primer;
        Curs aux2=null;
        while(aux!=null){
            if((aux.getCodi()==codi)){
              aux2=aux;
              aux.setSeg(null);
            }
            aux=aux.getSeg();
        }
        return aux2;
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
