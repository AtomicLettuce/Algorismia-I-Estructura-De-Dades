/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

public class Tauler {

    int[][] tauler;
    int n;

    public Tauler(int n) {
        this.n = n;
        tauler = new int[n][n];
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                tauler[fila][columna] = 0;
            }
        }
    }

    public int[][] getTauler() {
        return tauler;
    }

    public boolean solucio(int reines) {
        if (reines == n) {
            return true;
        }
        for (int f = 0; f < n; ++f) {
            for (int c = 0; c < n; ++c) {
                if (esPossible(f, c)) {
                    posarReina(f, c);

                    if (solucio(reines + 1)) {
                        return true;
                    }
                    llevarReina(f, c);
                }
            }
        }
        return false;
    }

    public boolean esPossible(int fila, int columna) {

        // Comprovar si hi ha reines en aquesta fila
        for (int i = 0; i < n; i++) {
            if (tauler[fila][i] == 1) {
                return false;
            }
        }

        // Comprovar si hi ha reines en aquesta columna
        for (int i = 0; i < n; i++) {
            if (tauler[i][columna] == 1) {
                return false;
            }
        }

        // Comprovar si hi ha reines diagonal descendet
        for (int x = -fila; x < -fila + n; ++x) {
            if (fila + x >= 0 && fila + x < n && columna + x < n && columna + x >= 0) {
                if (tauler[fila + x][columna + x] == 1) {
                    return false;
                }
            }
        }

        // Comprovar si hi ha reines diagonal ascendet
        for (int x = -fila; x < -fila + n; ++x) {
            if (fila + x >= 0 && fila + x < n && columna - x >= 0 && columna - x < n) {
                if (tauler[fila + x][columna - x] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public void posarReina(int fila, int columna) {
        tauler[fila][columna] = 1;
    }

    public void llevarReina(int fila, int columna) {
        tauler[fila][columna] = 0;
    }

    @Override
    public String toString() {
        String retorn = "";
        for (int fila = 0; fila < n; fila++) {
            for (int columna = 0; columna < n; columna++) {
                retorn = retorn + tauler[fila][columna];
            }
            retorn = retorn + "\n";
        }
        return retorn;

    }

}
