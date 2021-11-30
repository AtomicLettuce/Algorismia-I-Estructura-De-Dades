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
public class Ass_Optativa extends Assignatura {

    protected String perfil;

    public Ass_Optativa(String nom, int codi, int opcio) {
        super(nom, codi);
        switch (opcio) {
            case 1:
                perfil = "Pràctic";
                break;
            case 2:
                perfil = "Teòric";
                break;

            default:
                System.out.println("ERROR, TIPUS INCORRECTE");
                break;
        }
    }

    public String getTipus() {
        return perfil;
    }

    public void setTipus(String tipus) {
        this.perfil = tipus;
    }
    
}
