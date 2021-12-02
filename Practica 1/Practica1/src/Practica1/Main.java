package Practica1;

import ClassesModel.Curs;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main extends JFrame {

    Container panelContinguts;
    JMenuBar barraMenu;
    JFrame finestra = this;
    Llista_Cursos cursos=new Llista_Cursos(null);
    Llista_Ass assignatures= new Llista_Ass(null);
    // Constructor de la interficie grafica
    public Main() {
        // Establim mida i titol de la finestra
        setTitle("Practica 1 Algorismia i Estructura de Dades");
        setSize(1200, 500);

        // Definim gestor de layout
        setLayout(new BorderLayout());

        // Ens guardam el panel de continguts dins de la variable global panelContinguts
        panelContinguts = getContentPane();

        // Cream la barra de menú
        crearMenu();

        // Definim operacio de sortida per defecte i feim visible la finestra
        setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void crearMenu() {
        // Inicialitzam barra de Menú
        barraMenu = new JMenuBar();

        // Cream i inicialitzam els diferents menús
        JMenu altes = new JMenu("Altes");
        JMenu baixes = new JMenu("Baixes");
        JMenu matricular = new JMenu("Matricular");
        JMenu veure = new JMenu("Veure");

        // Inserim els items de cada menú i el seu gestor d'events
        //Menú d'ALTES
        // Altes FP
        JMenu aCursFP = new JMenu("Alta Curs FP");

        JMenuItem aCursFPMe = new JMenuItem("Alta Curs FP Mecànica");
        aCursFPMe.addActionListener(new gestorEventsMenu());
        aCursFP.add(aCursFPMe);

        JMenuItem aCursFPEl = new JMenuItem("Alta Curs FP Electrònica");
        aCursFPEl.addActionListener(new gestorEventsMenu());
        aCursFP.add(aCursFPEl);

        JMenuItem aCursFPIn = new JMenuItem("Alta Curs FP Informàtica");
        aCursFPIn.addActionListener(new gestorEventsMenu());
        aCursFP.add(aCursFPIn);

        // Altes Batx
        JMenuItem aCursBat = new JMenuItem("Alta Curs Batx.");
        aCursBat.addActionListener(new gestorEventsMenu());

        altes.add(aCursFP);
        altes.add(aCursBat);

        // Menú de BAIXES
        JMenuItem bCurs = new JMenuItem("Baixa Curs");
        bCurs.addActionListener(new gestorEventsMenu());
        baixes.add(bCurs);

        JMenuItem bAss = new JMenuItem("Baixa Assignatura");
        bAss.addActionListener(new gestorEventsMenu());
        baixes.add(bAss);

        // Menú MATRICULAR
        JMenuItem mAlu = new JMenuItem("Matricular Alumne d'Assignatura");
        mAlu.addActionListener(new gestorEventsMenu());
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
                            afegirAss();
                            
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
                        afegirAss();
                        
                    } catch (ErrorEntradaIncorrecta ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Alta Curs FP Informàtica":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioFP).getDatosTexto();
                    try {
                        FP curs3 = new FP(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]), 3);
                        cursos.afegirprimer(curs3);
                        afegirAss();
                    } catch (ErrorEntradaIncorrecta ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Alta Curs Batx.":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioBatx).getDatosTexto();
                     {
                        try {
                            Batxillerat batxiller = new Batxillerat(resultatUsuari[0], Integer.parseInt(resultatUsuari[1]),
                                    Integer.parseInt(resultatUsuari[2]));
                            cursos.afegirprimer(batxiller);
                            afegirAss();
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
                case "Matricular Alumne d'Assignatura...":
                    break;
                case "Veure Assignatures de Curs":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioVeureAssCurs).getDatosTexto();
                    assignatures.imprimeixLlistaAss(assignatures);

                    break;
                case "Veure Curs d'Assignatura i Alumnes":
                    //Llegim de teclat
                    resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioCodiAss).getDatosTexto();
                   
                    break;
                case "Veure Assignatures d'Estudiants":
                    //Llegim de teclat
                    String aux[]={"el","pepe","maikol","uwu","iofgbvusefdbu"};
                    System.out.println(new lecturaJRB(finestra,"ESKELER",aux).getSeleccionat());
                    
                    //resultatUsuari = new lecturaDatos(finestra, literalsIntroduccioDniEst).getDatosTexto();
                    break;
            }
            // Posam el punter a null per evitar possibles problemes
            resultatUsuari = null;
        }
        public void afegirAss(){
            String[] literalsAss = {"Número assignatures afegir (int):" };
            String[] literalsObl = { "NOM:", "CODI (int):","Número de crèdits(int)"};
            String[] literalsOpt = { "NOM:", "CODI (int):","Perfil(1=Pràctic,2=Teòric)"};
            String[] resultatUsuariObl;// Array de Strings amb el contingut del que ha ficat l'usuari per teclat
            String[] resultatUsuariOpt;
            Ass_Optativa opt;
            Ass_Obligatoria obl;
            
            resultatUsuari=new lecturaDatos(finestra,literalsAss).getDatosTexto();
            //La finestra sortira tantes vegades com assignatures
            for (int i = 0; i < Integer.parseInt(resultatUsuari[0]); i++) {
            //FER FINESTRA RADIOBUTTONS PER ELEGIR
            /*Si obligatoria seleccionada
            if(obligatoria.selected){*/
            resultatUsuariObl= new lecturaDatos(finestra, literalsObl).getDatosTexto();
            obl= new Ass_Obligatoria(resultatUsuariObl[0],Integer.parseInt(resultatUsuariObl[1]), Integer.parseInt(resultatUsuariObl[2]));
            assignatures.add(obl);
            /*else{ si optativa seleccionada*/
            resultatUsuariOpt= new lecturaDatos(finestra, literalsOpt).getDatosTexto();
            opt= new Ass_Optativa(resultatUsuariOpt[0],Integer.parseInt(resultatUsuariOpt[1]), Integer.parseInt(resultatUsuariOpt[2]));
            assignatures.add(opt);
            }
            
            
        }

    }

    public static void main(String[] args) {
        new Main();
    }

}
