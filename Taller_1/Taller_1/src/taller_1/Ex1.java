package taller_1;

import java.util.Random;

public class Ex1 {

    Llista llista;
    char opcioMenu;
    Node nounode;
    int posicio;

    public void inici() {
        crearLlista();
        menu();
    }

    public void menu() {
        try {
            System.out.println("Que vols fer?");
            System.out.println("1: Introduir node");
            System.out.println("2: Veure Llista");
            System.out.println("3: Sortir");

            opcioMenu = new LT().llegirCaracter();

            switch (opcioMenu) {
                case '1':
                    System.out.println("Introdueix valor del camp info");
                    int num = new LT().llegirSencer();
                    nounode = new Node(num);
                    llista.afegirPosicio(num, nounode);
                    menu();
                    break;
                case '2':
                    llista.imprimeixLlista();
                    menu();
                    break;
                case '3':
                    System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: no s'ha pogut completar l'operacio");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("ERROR: no s'ha pogut completar l'operacio");
            menu();
        }

    }

    // Mètode que crea una llista amb 15 elements amb els camp info aleatoris
    public void crearLlista() {
        llista = new Llista(new Node(new Random().nextInt(100)));
        for (int i = 1; i < 15; i++) {
            llista.afegirInici(new Node(new Random().nextInt(100)));
        }
    }

    public static void main(String[] args) {

        new Ex1().inici();

    }

}
