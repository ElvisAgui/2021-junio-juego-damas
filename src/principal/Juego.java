package src.principal;

import src.jugadores.Manejador;
import src.tablero.Tablero;

public class Juego {
    private Manejador jugPartida;
    private Tablero tablero;

    public Juego(Manejador jugPartida) {
        this.jugPartida = jugPartida;
        tablero = new Tablero();
    }


    
    public void iniciarJuego(){
        do{
            jugPartida.ejegir2();
            do{
                jugPartida.jugarPPTijera();
                tablero.dibujarTablero();
            }while(revancha());
            
        }while(otroJuego());
        
    }

    public void prueba(){
        tablero.moverFicha(2, 0, 3, 1);
        tablero.dibujarTablero();
    }

    public boolean revancha(){
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

    private boolean otroJuego(){
        boolean opis = false;
        int op;
        System.out.println("\nDesean Jugar Otra Partida con Otros Jugadores????\n");
        System.out.println("\nDigita \n1- para Si \n2-para No");
        op = EntradaDatos.getEntero("Digite la opcion que desea realizar: ", false);
        if(op == 1){
            opis = true;
        }
        return opis;
    }

}
