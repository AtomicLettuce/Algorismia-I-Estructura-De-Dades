package Practica1;

import ClassesModel.Assignatura;
import ClassesModel.Curs;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main extends JFrame {

    Container panelContinguts;
    JMenuBar barraMenu;
    JFrame finestra = this;
    JPanel titol;

    // Declaració de les 3 llistes globals de cursos, assignatures i estudiants
    Llista_Cursos cursos = new Llista_Cursos(null);
    Llista_Ass assignatures = new Llista_Ass(null);
    Llista_Est estudiants = new Llista_Est(null);

    // Constructor de la interficie grafica
    public Main() {
// Establim mida, titol, color de la finestra
        setTitle("Practica 1 Algorismia i Estructura de Dades");
        setSize(1200, 1000);

        // Definim gestor de layout
        setLayout(new BorderLayout());

        // Ens guardam el panel de continguts dins de la variable global panelContinguts
        panelContinguts = getContentPane();
        panelContinguts.setBackground(LIGHT_GRAY);
        // Cream la barra de menú
        crearMenu();
        MostrarGif();
        panelContinguts.add(titol, BorderLayout.NORTH);
        // Definim operacio de sortida per defecte i feim visible la finestra
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        //Sortirà enmig finestra
        setLocationRelativeTo(null);
        setVisible(true);
        this.getContentPane().add(titol);
    }

    private void MostrarGif() {
        //Get the URL
        titol = new JPanel();
        Icon icon = new ImageIcon("src/Imagen/Titulo2.gif");
        JLabel Gif = new JLabel(icon);
        titol.add(Gif);
    }

    private void crearMenu() {
        // Inicialitzam barra de Menú
        barraMenu = new JMenuBar();
        barraMenu.setBackground(GRAY);

        // Cream i inicialitzam els diferents menús
        JMenu altes = new JMenu("Altes");
        JMenu baixes = new JMenu("Baixes");
        JMenu matricular = new JMenu("Matricular");
        JMenu veure = new JMenu("Veure");
        altes.setForeground(BLUE.brighter());
        baixes.setForeground(GREEN.brighter());
        matricular.setForeground(RED.brighter());
        veure.setForeground(WHITE.brighter());

        // Inserim els items de cada menú i el seu gestor d'events
        //Menú d'ALTES
        // Altes FP
        JMenu aCursFP = new JMenu("Alta Curs FP");
        aCursFP.setForeground(BLUE);

        JMenuItem aCursFPMe = new JMenuItem("Alta Curs FP Mecànica");
        aCursFPMe.addActionListener(new gestorEventsMenu());
        aCursFPMe.setForeground(BLUE);
        aCursFP.add(aCursFPMe);

        JMenuItem aCursFPEl = new JMenuItem("Alta Curs FP Electrònica");
        aCursFPEl.addActionListener(new gestorEventsMenu());
        aCursFPEl.setForeground(BLUE);
        aCursFP.add(aCursFPEl);

        JMenuItem aCursFPIn = new JMenuItem("Alta Curs FP Informàtica");
        aCursFPIn.addActionListener(new gestorEventsMenu());
        aCursFPIn.setForeground(BLUE);
        aCursFP.add(aCursFPIn);

        // Altes Batx
        JMenuItem aCursBat = new JMenuItem("Alta Curs Batx.");
        aCursBat.addActionListener(new gestorEventsMenu());
        aCursBat.setForeground(BLUE);
        altes.add(aCursFP);
        altes.add(aCursBat);

        // Menú de BAIXES
        JMenuItem bCurs = new JMenuItem("Baixa Curs");
        bCurs.addActionListener(new gestorEventsMenu());
        bCurs.setForeground(GREEN.darker());
        baixes.add(bCurs);

        JMenuItem bAss = new JMenuItem("Baixa Assignatura");
        bAss.addActionListener(new gestorEventsMenu());
        bAss.setForeground(GREEN.darker());
        baixes.add(bAss);

        // Menú MATRICULAR
        JMenuItem mAlu = new JMenuItem("Matricular Alumne d'Assignatura");
        mAlu.addActionListener(new gestorEventsMenu());
        mAlu.setForeground(RED.darker());
        matricular.add(mAlu);

        // Menú VEURE
        JMenuItem vAssCurs = new JMenuItem("Veure Assignatures de Curs");
        vAssCurs.addActionListener(new gestorEventsMenu());
        veure.add(vAssCurs);

        JMenuItem vCursAssAlu = new JMenuItem("Veure Curs d'Assignatura i Alumnes");
        vCursAssAlu.addActionListener(new gestorEventsMenu());
        veure.add(vCursAssAlu);

        JMenuItem vAssEst = new JMenuItem("Veure Assignatures d'Estudiants");
        vAssEst.addActionListener(new gestorEventsMenu());
        veure.add(vAssEst);

        barraMenu.add(altes);
        barraMenu.add(baixes);
        barraMenu.add(matricular);
        barraMenu.add(veure);
        this.setJMenuBar(barraMenu);
    }

    private class gestorEventsMenu implements ActionListener {

        // ATRIBUTS que s'empraran per fer la captura de teclat
        String[] resultatUsuari;// Array de Strings amb el contingut del que ha ficat l'usuari per teclat

        String[] literalsIntroduccioFP = {"NOM:", "CODI (int):"};
        String[] literalsIntroduccioBatx = {"NOM:", "CODI (int):", "OPCIÓ (1 = Primer , 2 = Segon):"};
        String[] literalsIntroduccioBaixaCurs = {"Codi del Curs (int)"};
        String[] literalsIntroduccioVeureAssCurs = {"Codi del Curs (int)"};
        String[] literalsIntroduccioCodiAss = {"Codi de l'Assignatura (int)"};
        String[] literalsIntroduccioDniEst = {"Dni de l'Estudiant (int)"};
        String[] literalsIntroduccioMatr = {"Nom de l'estudiant", "Dni(int): "};

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println(event.getActionCommand());
            switch (event.getActionCommand()) {
                case "Alta Curs FP Mecànica":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioFP).getDatosTexto();
                     {
                        try {
                            FP curs1 = new FP(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]), 1);
                            cursos.afegirprimer(curs1);
                            afegirAss(curs1);
                        } catch (ErrorEntradaIncorrecta ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "Alta Curs FP Electrònica":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioFP).getDatosTexto();

                    try {
                        FP curs2 = new FP(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]), 2);
                        cursos.afegirprimer(curs2);
                        afegirAss(curs2);

                    } catch (ErrorEntradaIncorrecta ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Alta Curs FP Informàtica":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioFP).getDatosTexto();
                    try {
                        FP curs3 = new FP(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]), 3);
                        afegirAss(curs3);
                        cursos.afegirprimer(curs3);

                    } catch (ErrorEntradaIncorrecta ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Alta Curs Batx.":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioBatx).getDatosTexto();
                     {
                        try {
                            Batxillerat batxiller = new Batxillerat(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]), Integer.parseInt(resultatUsuari[2]));
                            afegirAss(batxiller);
                            cursos.afegirprimer(batxiller);

                        } catch (ErrorEntradaIncorrecta ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;

                case "Baixa Curs":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioBaixaCurs).getDatosTexto();
                    break;
                case "Baixa Assignatura":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioCodiAss).getDatosTexto();
                    break;
                case "Matricular Alumne d'Assignatura.":
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioMatr).getDatosTexto();
                    Estudiant est = new Estudiant(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]));
                    //matriculacio(est);
                    break;
                case "Veure Assignatures de Curs":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioVeureAssCurs).getDatosTexto();
                    impressioCurs(resultatUsuari[0]);

                    break;
                case "Veure Curs d'Assignatura i Alumnes":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioCodiAss).getDatosTexto();
                    impressioAss(resultatUsuari[0]);

                    break;
                case "Veure Assignatures d'Estudiants":
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioDniEst).getDatosTexto();
                    break;
            }
            // Posam el punter a null per evitar possibles problemes
            resultatUsuari = null;
        }

        public void afegirAss(Curs curs) {
            try {
                // Strings[] necesaris per fer la interacció per teclat amb l'usuari
                String[] literalsAss = {"Número assignatures afegir (int):"};
                String[] literalsObl = {"NOM:", "CODI (int):", "Número de crèdits(int)"};
                String[] literalsOpt = {"NOM:", "CODI (int):", "Perfil(1=Pràctic,2=Teòric)"};
                String[] literalsPerfil = {"Obligatòria", "Optativa"};
                // String[] que recull les dades introduides per l'usuari
                String[] resUsuari;
                // Variables necessàries per poder donar d'alta assignatures
                Ass_Optativa opt;
                Ass_Obligatoria obl;
                // Variable que canvia el seu valor depenent de si l'assignatura a 
                // introduir és optativa o obligatòria
                int opcio;
                // Variable que compté el numero d'assignatures a introduir
                int nAss;

                // Demanam a l'usuari quantes assignatures vol introduir
                resUsuari = new lecturaDatos(finestra, literalsAss).getDatosTexto();
                // Inicialitzam la llista de referències Assignatura del Curs
                curs.inicialitzarLlistaAss(Integer.parseInt(resUsuari[0]));
                nAss = Integer.parseInt(resUsuari[0]);

                //La finestra sortira tantes vegades com assignatures
                for (int i = 0; i < nAss; i++) {
                    //Llegim de teclat
                    opcio = new lecturaJRB(finestra, "TIPUS ASSIGNATURA", literalsPerfil).getSeleccionat();
                    //Si obligatoria seleccionada
                    if (opcio == 0) {
                        resUsuari = new lecturaDatos(finestra, literalsObl).getDatosTexto();
                        obl = new Ass_Obligatoria(resUsuari[0], Integer.parseInt(resUsuari[1]), Integer.parseInt(resUsuari[2]));
                        //assignatures.add(obl);
                        assignatures.afegirprimer(obl);
                        curs.afegirAss(Integer.parseInt(resUsuari[1]));
                    } else { //si optativa seleccionada
                        resUsuari = new lecturaDatos(finestra, literalsOpt).getDatosTexto();
                        opt = new Ass_Optativa(resUsuari[0], Integer.parseInt(resUsuari[1]), Integer.parseInt(resUsuari[2]));
                        //assignatures.add(opt);
                        assignatures.afegirprimer(opt);
                        curs.afegirAss(Integer.parseInt(resUsuari[1]));
                    }
                    //assignatures.ordenar(assignatures);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR EN L'ENTRADA DE DADES, ABORTANT");
                cursos.eliminarElement(curs.getCodi());
            }
        }

        /*
         public void matriculacio(Estudiant alumne){
            Curs cercat;
            Llista_Ass ass;
            //Demanam usuari de quin curs es vol matricular.
            String[] resultatcurs= new lecturaDatos(finestra,literalsIntroduccioBaixaCurs).getDatosTexto();
            cercat=cursos.cercadorcurs(resultatcurs);
            //Si s'ha trobat el curs
            if(cercat!=null){
              ass=cercat.getAssignatures();
              
            }else{
                System.out.println("NO S'HA TROBAT EL CURS!!!");  
            } 
        }*/
        //Aquest mètode cerca un curs i mostra la seva llista d'assignatures i alumnes matriculats
        public void impressioCurs(String resultatUsuari) {
            //Cercam l'assignatura passada pel codi 
            Curs curs = cursos.cercadorcurs(resultatUsuari);
            int[] ass_curs;
            Assignatura aux;
            //Si s'ha trobat el curs
            if (curs != null) {
                //Obtenem les assignatures del curs i les mostram per pantalla

                System.out.println(curs.toString());
                System.out.println("\n");
                ass_curs = curs.getReferenciesAss();
                ass_curs = curs.ordenacioReferencies(ass_curs);
                for (int i = 0; i < ass_curs.length; i++) {
                    aux = assignatures.cercadorAss(ass_curs[i], assignatures);
                    System.out.println(aux.toString());
                }
            } else {
                System.out.println("No s'ha trobat el curs");
            }
        }

        public void impressioAss(String resultatUsuari) {
            //Aquest és el codi de cerca
            int c = Integer.parseInt(resultatUsuari);
            //Ens situam en el primer curs de la llista
            Curs aux = cursos.getPrimer();
            //Obtenim array de referencies d'assigantures del curs
            int codis[];
            //Recorrem llista de cursos
            while ((aux != null)) {
                codis = aux.getReferenciesAss();
                //Recorrem array de ref assignatures
                for (int i = 0; i < codis.length; i++) {
                    //Si es el mateix codi obtenim curs i sortim bucle
                    if (c == codis[i]) {
                        System.out.println(aux.toString());
                    }
                }
                //Continuam itinerant a la llista i obtenim array ref
                aux = aux.getSeg();

            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
