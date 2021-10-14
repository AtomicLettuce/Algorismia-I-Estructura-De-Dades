
package taller_1;
public class Node {
    
    private int info;
    private Node seg;

    // Constructor que estableix el camp info al valor enter passat per paràmetre
    public Node(int info) {
        this.info = info;
        seg=null;
    }

    // Mètodes Getters dels atributs
    public int getInfo() {
        return info;
    }

    public Node getSeg() {
        return seg;
    }

    // Mètodes Setters Dels atributs
    public void setInfo(int info) {
        this.info = info;
    }

    public void setSeg(Node seg) {
        this.seg = seg;
    }
    
    
    
    
    
    
}
