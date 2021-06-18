package principal;

import tablero.Tablero;

public class Principal {
    public static void main(String[] args){
        System.out.println("Bienvenido al Juego de Damas !");
        Juego partida = new Juego();
        partida.iniciarJuego();
    }
   
    
}
