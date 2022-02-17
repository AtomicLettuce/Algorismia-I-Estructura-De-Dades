package practica2;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
    int taulerU[][];
    int taulerDos[][];
    int taulerTres[][];
    int comptador;

    public Practica2() {
        BorderLayout bl = new BorderLayout();
        finestra = this;
        this.setTitle("Practica 1 Algorismia i Estructura de Dades");
        this.setSize(700, 500);

        // Definim gestor de layout
        setLayout(new BorderLayout());

        // Ens guardam el panel de continguts dins de la variable global panelContinguts
        panelContinguts = getContentPane();
        panelContinguts.setBackground(LIGHT_GRAY);
        // Cream la barra de menú
        crearMenu();

        setDefaultCloseOperation(Practica2.EXIT_ON_CLOSE);
        //TITULO
        setTitle("BACKTRACKING-ALGORÍSMIA I ESTRUCTURA DE DADES- 2021-2021 - UIB");
        setSize(1000, 845);
        // EN EJECUTARLO SALDRÁ EN EL CENTRO DE LA PANTALLA
        setLocationRelativeTo(null);
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

    private void imprimirTauler(int[][] tauler, int n, int opcio, String posicio) {
        // Rebem la representació en String del tauler i el mostram per pantalla
        // El paràmetre opcio serveix per mirar si hem d'imprimir l'exercici dels cavalls o de les reines
        switch (opcio) {
            // Cas cavalls
            case 1:
                
                JPanel frame = new JPanel();
                JPanel squares[][] = new JPanel[n][n];

                frame.setLayout(new GridLayout(n, n));

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        squares[i][j] = new JPanel();

                        if ((i + j) % 2 == 0) {
                            squares[i][j].setBackground(Color.black);

                        } else {
                            squares[i][j].setBackground(Color.LIGHT_GRAY);
                        }
                        String str = "" + tauler[i][j];
                        JLabel lbl = new JLabel(str);
                        lbl.setForeground(yellow);
                        lbl.setFont(new Font("Serif", Font.BOLD, 20));
                        squares[i][j].add(lbl);

                        frame.add(squares[i][j]);
                    }
                }
                finestra.add(frame, posicio);
                finestra.revalidate();
                finestra.repaint();
                setVisible(true);
                break;
            // Cas reines
            case 2:
                
                ImageIcon foto = new ImageIcon("pixel_art.png");
                Image img = foto.getImage();

                JPanel frameR = new JPanel();
                JPanel[][] squaresR = new JPanel[n][n];

                frameR.setLayout(new GridLayout(n, n));

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        squaresR[i][j] = new JPanel();

                        if ((i + j) % 2 == 0) {
                            squaresR[i][j].setBackground(Color.black);
                        } else {
                            squaresR[i][j].setBackground(Color.white);
                        }

                        if (tauler[i][j] == 1) {
                            Image newimg = img.getScaledInstance(700 / n, 500 / n, java.awt.Image.SCALE_SMOOTH);
                            foto = new ImageIcon(newimg);
                            squaresR[i][j].add(new JLabel(foto));

                        }

                        frameR.add(squaresR[i][j]);
                    }
                }
                finestra.add(frameR, posicio);
                finestra.revalidate();
                finestra.repaint();
                setVisible(true);
                break;
        }

    }

    private void reines() {
        try {
            String[] resultatUsuari;
            String[] literalsIntroduccio = {"Introdueix el valor de 'n' (int)"};
            String[] literalsIntroduccio2 = {"Fila inicial (de 0 fins a n-1) (int)", "Columna inicial (de 0 fins a n-1) (int)"};
            int n, fila, columna;
            resultatUsuari = new lecturaDatos(finestra, literalsIntroduccio).getDatosTexto();
            n = Integer.parseInt(resultatUsuari[0]);

            resultatUsuari = new lecturaDatos(finestra, literalsIntroduccio2).getDatosTexto();
            fila = Integer.parseInt(resultatUsuari[0]);
            columna = Integer.parseInt(resultatUsuari[1]);

            Tauler tauler = new Tauler(n);

            tauler.setPosInicial(fila, columna);
            if (tauler.solucio(1)) {
                finestra.add(new JLabel(""), BorderLayout.EAST);
                finestra.add(new JLabel(""), BorderLayout.WEST);
                imprimirTauler(tauler.getTauler(), n, 2, BorderLayout.CENTER);
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTEIX SOLUCIÓ PER AQUEST VALOR DE 'n' I POSICIÓ INICIAL");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ENTRADA INCORRECTA");
            System.out.println(e.toString());
        }
    }

    private void cavalls() {
        try {
            String[] resultatUsuari;
            String[] literalsIntroduccio = {"Introdueix el valor de 'n' (int)"};
            int n;
            resultatUsuari = new lecturaDatos(finestra, literalsIntroduccio).getDatosTexto();

            n = Integer.parseInt(resultatUsuari[0]);
            //Tamaño del tablero
            //Inicialitzam talers
            int[][] tablero = new int[n][n];
            taulerU = new int[n][n];
            taulerDos = new int[n][n];
            taulerTres = new int[n][n];
            for (int f = 0; f < n; f++) {
                for (int c = 0; c < n; c++) {
                    tablero[f][c] = 0;
                    taulerU[f][c] = 0;
                    taulerDos[f][c] = 0;
                    taulerTres[f][c] = 0;

                }
            }
            //Casilla inicial
            String[] resultatUsuari2;
            String[] literalsIntroduccio2 = {"Introdueix el valor de 'x' (int):", "Introduceix el valor de la 'y'(int):"};
            resultatUsuari2 = new lecturaDatos(finestra, literalsIntroduccio2).getDatosTexto();

            //Mira si esta dentro de la casilla inicial
            int ini_caballo_x = Integer.parseInt(resultatUsuari2[0]);
            int ini_caballo_y = Integer.parseInt(resultatUsuari2[1]);
            if ((ini_caballo_y < 0) || (ini_caballo_y >= n)) {
                JOptionPane.showMessageDialog(null, "Fila debe estar en el rango 0.." + n);
            }
            if ((ini_caballo_x < 0) || (ini_caballo_x >= n)) {
                JOptionPane.showMessageDialog(null, "Columna debe estar en el rango 0.." + n);

            }
            comptador = 0;
            tablero[ini_caballo_x][ini_caballo_y] = 1;

            if (metodeRCavalls(tablero, n, 1, ini_caballo_x, ini_caballo_y)) {
                imprimirTauler(taulerU, n, 1, BorderLayout.EAST);
                imprimirTauler(taulerDos, n, 1, BorderLayout.CENTER);
                imprimirTauler(taulerTres, n, 1, BorderLayout.WEST);
                //JOptionPane.showMessageDialog(null, "S'han trobat TOTES les Solucions");

            } else {
                if (comptador == 0) {
                    JOptionPane.showMessageDialog(null, "ERROR: S'han trobat 0 Solucions");
                } else {
                    if (comptador == 1) {
                        imprimirTauler(taulerU, n, 1, BorderLayout.CENTER);
                        finestra.add(new JLabel(""), BorderLayout.EAST);
                        finestra.add(new JLabel(""), BorderLayout.WEST);
                    } else if (comptador == 2) {
                        imprimirTauler(taulerU, n, 1, BorderLayout.WEST);
                        imprimirTauler(taulerDos, n, 1, BorderLayout.EAST);
                        finestra.add(new JLabel(""), BorderLayout.CENTER);
                    }
                    JOptionPane.showMessageDialog(null, "S'han trobat " + comptador + "solucions");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR ENTRADA INCORRECTA");
            System.out.println(e.toString());
        }
    }

    public boolean metodeRCavalls(int tablero[][], int n, int caballos, int cx, int cy) {
        if (caballos == n * n) {
            comptador++;
            switch (comptador) {
                case 1:
                    for (int f = 0; f < n; f++) {
                        for (int c = 0; c < n; c++) {
                            taulerU[f][c] = tablero[f][c];
                        }
                    }
                    tablero[cx][cy] = 0;
                    return false;
                case 2:
                    for (int f = 0; f < n; f++) {
                        for (int c = 0; c < n; c++) {
                            taulerDos[f][c] = tablero[f][c];
                        }
                    }
                    tablero[cx][cy] = 0;
                    return false;
                case 3:
                    for (int f = 0; f < n; f++) {
                        for (int c = 0; c < n; c++) {
                            taulerTres[f][c] = tablero[f][c];
                        }
                    }
                    return true;
                default:
                    break;
            }
        }
        int ncx;
        int ncy;
        //int[] desp_x = {-1, 1, -1, 1, 2, 2, -2, -2};
        //int desp_x[]={-2,-2,2,2,1,-1,1,-1};
        int desp_x[] = {-2, 2, -1, -1, -2, 2, 1, 1};
        //int[] desp_y = {2, 2, -2, -2, 1, -1, 1, -1};
        //int [] desp_y={-1,1,-1,1,-2,-2,2,2};
        int[] desp_y = {1, 1, -2, 2, -1, -1, -2, 2};

        for (int i = 0; i < desp_x.length; i++) {
            ncx = cx + desp_x[i];
            ncy = cy + desp_y[i];
            //CADA UNA DE LAS CASILLAS DE LOS POSIBLES MOVIMIENTOS
            if (es_possible(tablero, n, ncx, ncy)) {
                tablero[ncx][ncy] = caballos + 1;
                if (metodeRCavalls(tablero, n, caballos + 1, ncx, ncy)) {
                    return true;
                }
                tablero[ncx][ncy] = 0;
            }

        }
        return false;
    }

    public boolean es_possible(int[][] tablero, int n, int cx, int cy) {
        //return cx>=0 && cx<n && cy>=0 && cy<n && tablero [cx][cy] ==0;
        if (cx < 0 || cx >= n) {
            return false;
        }
        if (cy < 0 || cy >= n) {
            return false;
        }
        return (tablero[cx][cy] == 0);
    }

    private class gestorEventsMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            switch (ae.getActionCommand()) {
                case "Cavalls":
                    finestra.getContentPane().removeAll();
                    cavalls();
                    break;
                case "Reines":
                    finestra.getContentPane().removeAll();
                    reines();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Practica2();
    }
}
