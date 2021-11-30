package Practica1;

import ClassesModel.Curs;

public class Llista_Cursos {
    
  private Curs primer;

    public Llista_Cursos(Curs primer) {
        this.primer = primer;
    }

    public Curs getPrimer() {
        return primer;
    }

    public void setPrimer(Curs primer) {
        this.primer = primer;
    }
  
}
