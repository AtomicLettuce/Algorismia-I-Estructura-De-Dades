package Practica1;

import ClassesModel.Curs;

public class FP extends Curs {

    protected String especialitat;

  
    public FP(String nom, int codi, int opcio) throws ErrorEntradaIncorrecta {
        super(nom, codi);
        switch (opcio) {
            case 1:
                especialitat = "Mecànica";
                break;
            case 2:
                especialitat = "Electrònica";
                break;
            case 3:
                especialitat = "Informàtica";
                break;
            default:
                throw new ErrorEntradaIncorrecta();
        }

    }

    public String getEspecialitat() {
        return especialitat;
    }

    @Override
    public String toString() {
        return "Nom: " +nom+" Codi: "+ codi + " Especialitat=" + especialitat + "}";
    }
    
    
}
