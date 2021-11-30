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
public class Ass_Obligatoria extends Assignatura {

    protected int ncredits;

    public Ass_Obligatoria(String nom, int codi, int ncredits) {
        super(nom, codi);
        this.ncredits = ncredits;
    }

    public int getNcredits() {
        return ncredits;
    }
    

}