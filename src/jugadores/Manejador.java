package jugadores;

import principal.EntradaDatos;

public class Manejador {

    private Jugador[] jugadores = new Jugador[5];
    
    public Manejador() {
        ingresoJugador();
    }

    public void ingresoJugador(){
        String nombre = " ";
        for (int i = 0; i < jugadores.length; i++) {
            nombre = EntradaDatos.getTexto("Ingrese el Nombre del Jugador #"+(i+1)+" ");
            jugadores[i] =new Jugador(nombre);
        }
    }

    public void jugadoresLista(){
        System.out.println("\n***Lista de Jugadores****\n");
        for ( int i = 0; i < jugadores.length; i++) {
            System.out.println("-"+(i+1)+") "+jugadores[i].toString());
        }
    }
    
    public void ejegir2(){
        boolean repit = true,pit = true;
        jugadoresLista();
        do {
            int aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0<aux && aux <= 5 ) {
                
            }
            
        } while (repit && pit);
        
        
    }
    

    
}
