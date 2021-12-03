/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

import Interfaces.IntfLlista;

/**
 *
 * @author aturs
 */
//segons una assignatura estudiants matriculats
public class Llista_RefEst implements IntfLlista {

    int length = 0;
    NodeReferenciaEstudiant primer = null;

    @Override
    public int length() {
        return length;
    }

    @Override
    public void afegirElement(Object obj) {
        NodeReferenciaEstudiant aux = primer;        
        
    }

    @Override
    public Object getElement(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compte(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarElement(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
