package taller_1;

import java.util.Random;

public class Ex2 {

    Llista llista;
    Llista lliures;
    char opcioMenu;
    int pos;
    Node aux;

    public void inici() {
        crearLlista();
        menu();
    }

    public void menu() {
        System.out.println("Que vols fer?");
        System.out.println("1: Eliminar node");
        System.out.println("2: Veure llista");
        System.out.println("3: Veure lliures");
        System.out.println("4: Sortir");

        opcioMenu = new LT().llegirCaracter();
        try {
            switch (opcioMenu) {
                case '1':
                    System.out.println("Introdueix la posicio que vols eliminar");
                    pos = new LT().llegirSencer();
                    aux = llista.getNode(pos);
                    llista.eliminarNode(pos);
                    lliures.afegirFinal(aux);
                    menu();
                    break;
                case '2':
                    llista.imprimeixLlista();
                    menu();
                    break;
                case '3':
                    lliures.imprimeixLlista();
                    menu();
                    break;
                case '4':
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: no s'ha pogut completar l'operacio");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("ERROR: no s'ha pogut completar l'operacio");
        }
    }

// Mètode que crea les dues llistes
    public void crearLlista() {

        System.out.println("Introdueix el nombre de nodes que tindrà la llista");
        int num = new LT().llegirSencer();
        llista = new Llista(null);
        /* for (int i = 1; i < 15; i++) {
            llista.afegirInici(new Node(new Random().nextInt(100)));
        }*/

        for (int i = 0; i < num; i++) {
            System.out.println("Introdueix la info del node: " + (i + 1));
            int info = new LT().llegirSencer();
            llista.afegirInici(new Node(info));
        }
        lliures = new Llista(new Node(0));
    }

    public static void main(String[] args) {
        new Ex2().inici();
    }

}
