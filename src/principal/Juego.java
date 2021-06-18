package principal;

import jugadores.Jugador;
import jugadores.Manejador;
import tablero.Tablero;

public class Juego {
    private Jugador jugPartida[] = new Jugador[2];
    private Manejador vecJugadores;
    private Tablero tablero;

    public Juego() {
        tablero = new Tablero();
    }

    public void iniciarJuego(){
        this.vecJugadores = new Manejador();
        this.jugPartida = vecJugadores.ejegir2();
        tablero.dibujarTablero();
    }

}
