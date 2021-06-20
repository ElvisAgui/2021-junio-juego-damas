package src.jugadores;

import src.principal.EntradaDatos;

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
    
    public Jugador[] ejegir2(){
        Jugador jugCompetidor[] = new Jugador[2];
        boolean repit = true,pit = true;
        jugadoresLista();
        do {
            int aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0<aux && aux <= 5 ) {
                jugCompetidor[0] = this.jugadores[aux];
                repit = false;
            }
            aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0<aux && aux <= 5 ) {
                jugCompetidor[1] = this.jugadores[aux];
                pit = false;
            } 
            if (pit && repit) {
                System.out.println("Datos incorrectos******* :(");
            }
        } while (repit && pit); 
        return jugCompetidor;  
        
    }

    public String elegirCasilla() {
        int aux =1;
        String tem= "";
        do{
            System.out.println("\n---Fichas a escoger");
            System.out.println("1- Blancos");
            System.out.println("2- Negros");
            aux = EntradaDatos.getEntero("--Digite el numero de ficha a jugar", false);
            if(aux == 1){
                tem = "blanco";
            }
            if(aux  == 2){
                tem = "blanco";
            }

        }while(aux >2);
        return tem;
    }
    

    
}
