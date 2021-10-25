/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_1;
/**
 *
 * @author aturs
 */
public class Ex3 {
     Llista llistaordenada;
     
    char opcioMenu;
    Node nounode;

public void inici() {
        menu();
    }
 public void menu() {
        try {
            System.out.println("Que vols fer?");
            System.out.println("1: Introduir node");
            System.out.println("2: Veure Llista");
            System.out.println("3: Crear llista");
            System.out.println("4: Sortir");

            opcioMenu = new LT().llegirCaracter();

            switch (opcioMenu) {
                case '1':
                    System.out.println("Introdueix valor del camp info");
                    int num = new LT().llegirSencer();
                    nounode = new Node(num);
                    llistaordenada.afegirNode(nounode);
                    menu();
                    break;
                case '2':
                    llistaordenada.imprimeixLlista();
                    menu();
                    break;
                case '3':
                    crearLlistaordenada();
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
            llistaordenada.afegirFinal(nounode);
            menu();
        }
 }
         // Mètode que crea una llista ordenada amb tants de nodes desitji usuari, 
    public void crearLlistaordenada() {
        System.out.println("Introdueix el nombre de nodes que tindrà la llista");
        int num = new LT().llegirSencer();
        llistaordenada = new Llista(null);
        Node conjunt[]= new Node [num];
        for (int i = 0; i < num; i++) {
            System.out.println("Introdueix el camp info del node: "+(i+1));
        int info = new LT().llegirSencer();
            conjunt[i]=new Node(info);
        }
        Node aux= null; 
        for (int j = 0; j < num; j++) {
            for (int k = 0; k < num-1; k++) {
                if(conjunt[k].getInfo()<conjunt[k+1].getInfo()){
                    aux=conjunt[k];
                    conjunt[k]=conjunt[k+1];
                    conjunt[k+1]=aux;
                }   
            }
        }
        for (int i = 0; i < num; i++) {
            llistaordenada.afegirInici(conjunt[i]);
        }
       
    }
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Ex3().inici();
    }
    
}
