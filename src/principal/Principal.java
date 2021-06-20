package src.principal;

import src.jugadores.Manejador;

//clase principal
public class Principal {
    
    public static void main(String[] args){
        System.out.println("\n\n********Bienvenido al Juego de Damas !***********\n\n");
        Principal Damas = new Principal();
        
    }
    private Juego partida;
    private Manejador jugadores = new Manejador();

    public Principal() {
        menuPrincipa();
    }

    public void menuPrincipa(){
        int op = 0;
        do {
            System.out.println("\n\n****Menu Principal****\n--------opciones");
            System.out.println("*-1) Ingresar Jugadores Nuevos");
            System.out.println("*-2) Jugar una Partida");
            System.out.println("*-3) Ver  Jugadores");
            System.out.println("*-4) Salir");
            op=EntradaDatos.getEntero("Digite la opcion que desea realizar: ", false);
            if (op > 4) {
                System.out.println("------Opcion invalida--------\n");  
            }else{
                accionesMenu(op);
            }
        } while (op != 4);
    }

    public void accionesMenu(int op){
        switch (op) {
            case 1:
                System.out.println("\nBien ha elegido ingresar Jugadores Nuevos!!!!\n");
                jugadores.ingresoJugador();
                break;
            case 2:
                this.partida = new Juego(jugadores);
                partida.iniciarJuego();
                break;
            case 3:
                System.out.println("\nBien ha elegido Ver Listado de Jugadores!!!!\n");
                jugadores.jugadoresLista();
                break;
            default:
                break;
        }
    }
   
    
}
