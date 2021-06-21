package src.principal;

import src.jugadores.Manejador;
import src.tablero.Tablero;

public class Juego {
    private Manejador jugPartida;
    private Tablero tablero;
    private int inicioI;
    private int finI;
    private int inicioJ;
    private int finJ;

    public Juego(Manejador jugPartida) {
        this.jugPartida = jugPartida;
        
    }

    public void iniciarJuego() {
        do {
            this.tablero = new Tablero();
            jugPartida.ejegir2();
            do {
                jugPartida.jugarPPTijera();
                jugPartida.elgirFicha();
                do {
                    movFicha();
                } while (jugPartida.getJugCompetidor()[0].getPiezsPerdidas() != 12
                        || jugPartida.getJugCompetidor()[1].getPiezsPerdidas() != 12);
                if (jugPartida.getJugCompetidor()[0].getPiezsPerdidas() == 12) {
                    System.out.println("El ganadro es: " + jugPartida.getJugCompetidor()[1].getNombre());
                    jugPartida.getJugCompetidor()[1].setPartidasGanadas(1);
                    jugPartida.getJugCompetidor()[0].setPartidasPerdidas(1);
                } else {
                    System.out.println("El ganadro es: " + jugPartida.getJugCompetidor()[0].getNombre());
                    jugPartida.getJugCompetidor()[0].setPartidasGanadas(1);
                    jugPartida.getJugCompetidor()[1].setPartidasPerdidas(1);
                }

            } while (revancha());

        } while (otroJuego());

    }

    public void movFicha() {
        tablero.dibujarTablero();
        pedirPos();
        if (tablero.moverFicha(this.inicioI, this.inicioJ, this.finI, this.finJ)) {
            tablero.dibujarTablero();
            if (tablero.saltoFila(this.inicioI, this.finI)) {
                System.out.println("Pieza comida :V");
                tablero.borrarFicha(this.inicioI, this.finI, this.inicioJ, this.finJ);
                if (jugPartida.getJugCompetidor()[0].getTurno()) {
                    jugPartida.getJugCompetidor()[0].setPiezsComidas(1);
                    jugPartida.getJugCompetidor()[1].setPiezsPerdidas(1);

                } else {
                    jugPartida.getJugCompetidor()[1].setPiezsComidas(1);
                    jugPartida.getJugCompetidor()[0].setPiezsPerdidas(1);

                }
              

            }
            if (jugPartida.getJugCompetidor()[0].getTurno()) {
                jugPartida.getJugCompetidor()[0].setTurno(false);
                jugPartida.getJugCompetidor()[1].setTurno(true);
            } else {
                jugPartida.getJugCompetidor()[1].setTurno(false);
                jugPartida.getJugCompetidor()[0].setTurno(true);
            }
            System.out.println("++++++Movimiento exitoso++++++");
        } else {
            System.out.println("Movimieto no realizado");
        }
    }

    public void pedirPos() {

        if (jugPartida.getJugCompetidor()[0].getTurno()) {
            jugPartida.datosJugaresPartida();
            System.out.println("\n----Truno de " + jugPartida.getJugCompetidor()[0].getNombre() + " con Fichas Amarrillas---\n");
            this.inicioJ = EntradaDatos.getEntero("Digite la posicion en 'X' de la ficha que desea Mover ", false);
            this.inicioI = EntradaDatos.getEntero("Digite la posicion en 'Y' de la ficha que desea Mover ", false);
            if (inicioI < 9 && inicioJ < 9) {
                System.out.println("\nBien Datos Correctos!!!!\n");
            } else {
                System.out.println("Datos Incorrectos \n");
            }
            this.finJ = EntradaDatos.getEntero("Digite la posicion en 'X' donde quiere mover la ficha ", false);
            this.finI = EntradaDatos.getEntero("Digite la posicion en 'Y' donde quiere mover la ficha ", false);
            if (inicioI < 9 && inicioJ < 9) {
                System.out.println("\nBien Datos Correctos!!!!\n");
            } else {
                System.out.println("Datos Incorrectos \n");
            }

        }
        if (jugPartida.getJugCompetidor()[1].getTurno()) {
            jugPartida.datosJugaresPartida();
            System.out.println(
                    "----Truno de " + jugPartida.getJugCompetidor()[1].getNombre() + " con Fichas Negras---\n");
            this.inicioI = EntradaDatos.getEntero("Digite la posicion en 'X' de la ficha que desea Mover ", false);
            this.inicioJ = EntradaDatos.getEntero("Digite la posicion en 'Y' de la ficha que desea Mover ", false);
            if (inicioI < 9 && inicioJ < 9) {
                System.out.println("\nBien Datos Correctos!!!!\n");
            } else {
                System.out.println("Datos Incorrectos \n");
            }
            this.finI = EntradaDatos.getEntero("Digite la posicion en 'X' donde quiere mover la ficha ", false);
            this.finJ = EntradaDatos.getEntero("Digite la posicion en 'Y' donde quiere mover la ficha ", false);
        }
    }

    public void prueba() {
        /*
         * tablero.moverFicha(2,0,3,1); tablero.moverFicha(5,1,4,0);
         * tablero.dibujarTablero();
         */
    }

    public boolean revancha() {
        boolean revancha = false;
        int op;
        System.out.println("\nDesean La revancha????\n");
        System.out.println("\nDigita \n1- para Si \n2-para No");
        op = EntradaDatos.getEntero("Digite la opcion que desea realizar: ", false);
        if (op == 1) {
            revancha = true;
        }
        return revancha;
    }

    private boolean otroJuego() {
        boolean opis = false;
        int op;
        System.out.println("\nDesean Jugar Otra Partida con Otros Jugadores????\n");
        System.out.println("\nDigita \n1- para Si \n2-para No");
        op = EntradaDatos.getEntero("Digite la opcion que desea realizar: ", false);
        if (op == 1) {
            opis = true;
        }
        return opis;
    }

}
