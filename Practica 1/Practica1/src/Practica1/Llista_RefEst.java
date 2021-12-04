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

    NodeReferenciaEstudiant primer = null;

    @Override
    public int length() {
        int length = 0;
        NodeReferenciaEstudiant aux = primer;
        for (int i = 0; aux != null; i++) {
            length++;
            aux = aux.getSeg();
        }
        return length;
    }

    @Override
    public void afegirElement(Object obj) {
        NodeReferenciaEstudiant aux1 = (NodeReferenciaEstudiant) obj;
        aux1.setSeg(primer);
        primer = aux1;
    }

    @Override
    public NodeReferenciaEstudiant getElement(int i) {
        // Apuntam al primer
        NodeReferenciaEstudiant aux = primer;
        // Iteram per obtenir l'element ièssim
        for (int k = 0; k < i; k++) {
            aux = aux.getSeg();
        }
        // Retornam
        return aux;
    }

    @Override
    public boolean compte(int codi) {
        NodeReferenciaEstudiant aux = primer;
        int n = length();
        for (int i = 0; i < n; i++) {
            if (aux.getCodi() == codi) {
                return true;
            }
            aux = aux.getSeg();
        }
        return false;
    }

    @Override
    public void sort() {
        //FER SORT
    }

    @Override
    public void eliminarElement(int i) {
        if (i == 0) {
            primer = primer.getSeg();
        } else {
            NodeReferenciaEstudiant aux = primer;
            NodeReferenciaEstudiant aux2 = primer;
            for (int k = 0; k < i; k++) {
                aux2 = aux;
                aux = aux.getSeg();
            }
            aux2.setSeg(aux.getSeg());

        }
    }

    @Override
    public void afegirElement(Object obj, int pos) {
        NodeReferenciaEstudiant node = (NodeReferenciaEstudiant) obj;
        if (pos == 0) {
            node.setSeg(primer);
            primer = node;
        } else {
            NodeReferenciaEstudiant aux = primer;
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.getSeg();
            }
            node.setSeg(aux.getSeg());
            aux.setSeg(node);
        }
    }

    @Override
    public String toString() {
        int n = length();
        String str = "";
        NodeReferenciaEstudiant aux = primer;

        for (int i = 0; i < n; i++) {
            str = str + "Codi: " + aux.getCodi() + "\t";
            aux = aux.getSeg();
        }

        return str;
    }

}
