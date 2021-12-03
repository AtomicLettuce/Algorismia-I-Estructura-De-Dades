/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica1;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class NodeReferenciaEstudiant {

    private int codi;
    private NodeReferenciaEstudiant seg;

    // Constructor que estableix el camp info al valor enter passat per paràmetre
    public NodeReferenciaEstudiant(int info) {
        this.codi = info;
        seg = null;
    }

    // Mètodes Getters dels atributs
    public int getInfo() {
        return codi;
    }

    public NodeReferenciaEstudiant getSeg() {
        return seg;
    }

    // Mètodes Setters Dels atributs
    public void setInfo(int info) {
        this.codi = info;
    }

    public void setSeg(NodeReferenciaEstudiant seg) {
        this.seg = seg;
    }

}
