package Practica1;

import ClassesModel.Curs;

public class Batxillerat extends Curs {

    protected String Curs;

    public Batxillerat(String nom, int codi, int opcio) throws ErrorEntradaIncorrecta {
        super(nom, codi);
        switch (opcio) {
            case 1:
                Curs = "Primer";
                break;
            case 2:
                Curs = "Segon";
                break;

            default:
                throw new ErrorEntradaIncorrecta();
        }
    }

    public String getCurs() {
        return Curs;
    }

    @Override
    public String toString() {
        return "Nom: "+nom+" Codi:"+codi+" Batxillerat{" + "Curs=" + Curs + "}";
    }
    
}
