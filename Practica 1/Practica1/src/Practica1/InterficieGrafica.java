package Practica1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterficieGrafica extends JFrame {

    Container panelContinguts;
    JMenuBar barraMenu;

    // Constructor de la interficie grafica
    public InterficieGrafica() {
        // Establim mida i titol de la finestra
        setTitle("Practica 1 Algorismia i Estructura de Dades");
        setSize(1200, 500);

        // Ens guardam el panel de continguts dins de la variable global panelContinguts
        panelContinguts = getContentPane();

        crearMenu();

        // Definim operacio de sortida per defecte i feim visible la finestra
        setDefaultCloseOperation(InterficieGrafica.EXIT_ON_CLOSE);
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
        JMenuItem aCurs = new JMenuItem("Alta Curs");
        aCurs.addActionListener(new gestorEventsMenu());
        altes.add(aCurs);

        // Menú de BAIXES
        JMenuItem bCurs = new JMenuItem("Baixa Curs");
        bCurs.addActionListener(new gestorEventsMenu());
        baixes.add(bCurs);
        
        JMenuItem bAss = new JMenuItem("Baixa Assignatura");
        bAss.addActionListener(new gestorEventsMenu());
        baixes.add(bAss);
        
        // Menú MATRICULAR
        JMenuItem mAlu = new JMenuItem("Matricular Alumne");
        mAlu.addActionListener(new gestorEventsMenu());
        matricular.add(mAlu);
        
        // Menú VEURE
        JMenuItem vAssCurs = new JMenuItem("Veure Assignatura de Curs");
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

        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println(event.getActionCommand());
            switch (event.getActionCommand()) {
                case "item1":
                    break;
                case "item2":
                    System.exit(0);
                    break;
                case "item3":
                    System.out.println("eskeler");
                    break;
            }
        }

    }
}
