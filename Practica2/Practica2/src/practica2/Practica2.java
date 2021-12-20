package practica2;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Practica2 extends JFrame {

    JMenuBar barraMenu;
    Container panelContinguts;
    JFrame finestra;

    public Practica2() {
        finestra = this;
        this.setTitle("Practica 1 Algorismia i Estructura de Dades");
        this.setSize(1200, 1000);

        // Definim gestor de layout
        setLayout(new BorderLayout());

        // Ens guardam el panel de continguts dins de la variable global panelContinguts
        panelContinguts = getContentPane();
        panelContinguts.setBackground(LIGHT_GRAY);
        // Cream la barra de menú
        crearMenu();

        setDefaultCloseOperation(Practica2.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void crearMenu() {
        // Barra de Menú
        barraMenu = new JMenuBar();
        barraMenu.setBackground(GRAY);

        //Menu
        JMenu ex = new JMenu("EXERCICI");
        ex.setForeground(CYAN);

        //Ítems de menu i gestors d'events
        JMenuItem cavalls = new JMenuItem("Cavalls");
        cavalls.addActionListener(new gestorEventsMenu());
        JMenuItem reines = new JMenuItem("Reines");
        reines.addActionListener(new gestorEventsMenu());

        // Inserció en pantalla
        ex.add(cavalls);
        ex.add(reines);
        barraMenu.add(ex);
        finestra.setJMenuBar(barraMenu);

    }

    private void imprimirTauler(int[][] tauler, int n, int opcio) {
        // Rebem la representació en String del tauler i el mostram per pantalla
        // El paràmetre opcio serveix per mirar si hem d'imprimir l'exercici dels cavalls o de les reines

        switch (opcio) {
            // Cas cavalls
            case 1:
                break;
            // Cas reines
            case 2:
                JPanel frame = new JPanel();
                JPanel squares[][] = new JPanel[n][n];

                frame.setLayout(new GridLayout(n, n));

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        squares[i][j] = new JPanel();

                        if ((i + j) % 2 == 0) {
                            squares[i][j].setBackground(Color.black);
                        } else {
                            squares[i][j].setBackground(Color.white);
                        }
                        
                        if(tauler[i][j]==1){
                            squares[i][j].add(new JLabel(new ImageIcon("reina.jfif")));
                        }
                        
                        
                        frame.add(squares[i][j]);
                    }
                }
                finestra.add(frame, BorderLayout.CENTER);
                setVisible(true);
                break;
        }

    }

    private void reines() {
        try {
            String[] resultatUsuari;
            String[] literalsIntroduccio = {"Introdueix el valor de 'n' (int)"};
            int n;
            resultatUsuari = new lecturaDatos(finestra, literalsIntroduccio).getDatosTexto();

            n = Integer.parseInt(resultatUsuari[0]);

            Tauler tauler = new Tauler(n);

            if (tauler.solucio(0)) {
                imprimirTauler(tauler.getTauler(), n, 2);
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTEIX SOLUCIÓ PER AQUEST VALOR DE 'n'");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ENTRADA INCORRECTA");
            System.out.println(e.toString());
        }
    }

    private class gestorEventsMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (ae.getActionCommand()) {
                case "Cavalls":
                    break;
                case "Reines":
                    reines();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Practica2();
    }
}
