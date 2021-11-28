package javaapplication27;

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
        barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item1 = new JMenuItem("item1");
        item1.addActionListener(new gestorEventsMenu());
        JMenuItem item2 = new JMenuItem("item2");
        item2.addActionListener(new gestorEventsMenu());
        JMenuItem item3 = new JMenuItem("item3");
        item3.addActionListener(new gestorEventsMenu());

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        barraMenu.add(menu);

        this.setJMenuBar(barraMenu);
    }

    private class gestorEventsMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
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
