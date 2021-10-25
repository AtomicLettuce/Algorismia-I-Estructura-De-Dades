package taller_1;

public class Llista {

    private Node primer = null;

    // Constructor que inicialitza la llista
    public Llista(Node primer) {
        this.primer = primer;
    }

    // Mètode getter
    public Node getPrimer() {
        return primer;
    }

    // Mètode setter
    public void setPrimer(Node primer) {
        this.primer = primer;
    }

    // Mètode que situa el node passat per paràmetre com a primer de la llista
    public void afegirInici(Node node) {
        node.setSeg(primer);
        primer = node;

    }

    // Mètode que situa el node passat per paràmetre com a darrer de la llista
    public void afegirFinal(Node node) {
        Node aux = primer;

        // Cercar el darrer node de la llista
        while (aux.getSeg() != null) {
            aux = aux.getSeg();
        }
        // Definim que el punter seg vagi cap al nou node
        aux.setSeg(node);

        // Ens asseguram que el seu apuntador apunti a null
        node.setSeg(null);
    }

    // Mètode que insereix un node a la posicio passada per parametre
    public void afegirPosicio(int pos, Node node) {
        Node aux = primer;
        Node aux2 = null;
        for (int i = 0; i < pos - 1; i++) {
            // If preventiu ja que si s'ha introduit una posicio més gran que
            // el núm total de nodes es col·locara a la darrera posició
            if (aux != null) {
                aux2 = aux;
                aux = aux.getSeg();
            }
        }
        if (aux2 != null) {
            node.setSeg(aux);
            aux2.setSeg(node);
        } else {
            System.out.println("no s'ha pogut posar el node en la posicio desitjtada");
        }

    }

    // Mètode que retorna el node situat a la posició passada per paràmetre
    public Node getNode(int pos) {
        Node aux = primer;
        for (int i = 0; i < pos-1; i++) {
            if (aux != null) {
                aux = aux.getSeg();
            }
        }
        return aux;
    }

    // Mètode que elimina el node situat a la posició passada per paràmetre
    public void eliminarNode(int pos) {
        Node aux = primer;
        Node aux2 = primer;

        if (pos == 1) {
            primer=primer.getSeg();
        } else {

            for (int i = 1; i < pos; i++) {
                aux2 = aux;
                aux = aux.getSeg();
            }

            if (aux == null) {
                aux2.setSeg(null);
            } else if (aux.getSeg() != null) {
                aux2.setSeg(aux.getSeg());
            }else{
                aux2.setSeg(null);
            }
        }

        /*
        
        // Cercam el node que està a la posicio indicada
        for (int i = 0; i < pos - 1; i++) {
            if (aux != null) {
                aux2 = aux;
                aux = aux.getSeg();
            }
        }
        // Feim el canvi de punters si és que existeix tal posició
        if (aux != null) {
            aux2.setSeg(aux.getSeg());
        } else {
            System.out.println("No existeix tal posicio");
        }*/
    }

    // Mètode que imprimeix per pantalla tot el contingut de la llista
    public void imprimeixLlista() {
        Node aux = primer;
        int posicio = 1;
        System.out.println("-----Inici de llista-----");
        while (aux != null) {
            System.out.println("Posicio = " + posicio + " Info: " + aux.getInfo());
            aux = aux.getSeg();
            posicio++;
        }
        System.out.println("-----Final de llista-----");
    }

    public void afegirNode(Node nounode) {
        //Utilitzarem dos nodes auxiliars i una variable booleana per sabre si es troba col·locat
        Node aux = primer;
        Node aux2 = null;
        boolean colocado = false;

        //si és més petit que el primer node, es coloca al inici de la llista 
        //colocat a true
        if (nounode.getInfo() < aux.getInfo()) {
            afegirInici(nounode);
            colocado = true;
        } else {
            //sino es troba al principi recorregut de la llista comparant    
            while (aux != null) {
                //seleccionam node llista dins aux2 i seleccionam el següent a aux
                aux2 = aux;
                aux = aux.getSeg();
                //Comparació entre aux2, nounode i el següent de la llista
                if ((aux2.getInfo() < nounode.getInfo()) && (nounode.getInfo() < aux.getInfo())) {
                    //Col·locam node dins llista, colocat a true i aux= null per sortir del bucle
                    aux2.setSeg(nounode);
                    nounode.setSeg(aux);
                    colocado = true;
                    aux = null;
                }

            }
        }
        //Si es més gran que la resta de nombres de la llista, no col·locat, posam al final
        if (!colocado) {
            afegirFinal(nounode);
        }
    }
}
