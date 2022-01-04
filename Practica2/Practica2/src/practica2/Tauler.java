/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

public class Tauler {

    int[][] tauler;
    int n;
    public static int MovX[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int MovY[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public static int numSoluciones, totSoluciones;

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

    public void setPosInicial(int fila, int columna) {
        posarReina(fila, columna);
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
                    if (reines >= 1) {
                        llevarReina(f, c);
                    }
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
//Siguiente  casilla del tablero siguiendo el movimiento del caballo

    public int siguienteCasilla(int n, int x, int y, int movimiento) {
        int f, c;
        //Indica fila y columna del siguiente movimiento del caballo
        f = x + MovX[movimiento];
        c = y + MovY[movimiento];
        //Si se encuentra dentro del tablero y no se ha pasado por esta casilla 
        if (((f >= 0) && (f <= n - 1)) && ((c >= 0) && (c <= n - 1)) && (tauler[f][c] == 0)) {
            return f * n + c; // Se devuelve como indice de array lineal   
        }
        return -1;
    }

    public void saltoCaballoR(int n, int x, int y, int salto) {
        int i, f, c, fc;
        //Bucle con los movimientos del caballo
        for (i = 0; i < 8; i++) {
            //se mira la siguiente casilla 
            fc = siguienteCasilla(n, x, y, i);
            //Si no se ha pasado por ella
            if (fc >= 0) {
                //Se busca fila y columna indicada
                f = fc / n;
                c = fc % n;
                //Se indica el número por el que se ha pasado en esa casilla
                tauler[f][c] = salto; // anotar
                if (salto == n * n) { // si ya ha recorrido todo el tablero
                    numSoluciones++;
                    //Se imprime el tablero
                    if (numSoluciones == 1) {
                        System.out.println("Una solució:");
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < n; k++) {

                                System.out.print(tauler[j][k]);
                                System.out.print(" ");
                            }
                            System.out.println("\n");
                        }
                    }
                }
                //Se llama a la funcion recursiva
                saltoCaballoR(n, f, c, salto + 1);
                tauler[f][c] = 0; // se desanota el ultimo movimiento
            }
        }
    }

    public void saltoCaballo(int n, int x, int y) {
        int i, f, c, fc, ix, iy;

        for (i = 0; i < 8; i++) {
            //numSoluciones = 0;
            fc = siguienteCasilla(n, x, y, i);
            if (fc >= 0) {
                f = fc / n;
                c = fc % n;
                tauler[f][c] = 2; // anotar
                saltoCaballoR(n, f, c, 3);
                tauler[f][c] = 0; // se desanota el ultimo movimiento
            }
            totSoluciones += numSoluciones;
        }

        if (totSoluciones == 0) {
            System.out.println("No se ha encontrado 3 soluciones con el tamaño de esta n");
        }
    }
}
