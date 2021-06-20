package src.principal;

import src.jugadores.Jugador;
import src.jugadores.Manejador;
import src.tablero.Tablero;

public class Juego {
    private Jugador jugPartida[] = new Jugador[2];
    private Manejador vecJugadores;
    private Tablero tablero;

    public Juego() {
        tablero = new Tablero();
    }

    public void iniciarJuego(){
        //this.vecJugadores = new Manejador();
        //this.jugPartida = vecJugadores.ejegir2();
        tablero.dibujarTablero();
    }

    public void prueba(){
        tablero.moverFicha(2, 0, 3, 1);
        tablero.dibujarTablero();
    }

}
