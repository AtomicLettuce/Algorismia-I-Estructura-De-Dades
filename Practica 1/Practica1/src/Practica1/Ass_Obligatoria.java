/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import ClassesModel.Assignatura;
import ClassesModel.Curs;

/**
 *
 * @author aturs
 */
public class Ass_Obligatoria extends Assignatura {

    protected int ncredits;

    public Ass_Obligatoria(String nom, int codi, int ncredits, Curs curs) {
        super(nom, codi, curs);
        this.ncredits = ncredits;
    }

    public int getNcredits() {
        return ncredits;
    }

    @Override
    public String toString() {
       return "Nom: " +nom+" Codi: "+ codi + " Tipus: Obligatoria " + " Credits: " + ncredits + "}\n"
               + "\tdel Curs: "+curs.toString();
    }
    

}