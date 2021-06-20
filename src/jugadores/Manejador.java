package src.jugadores;

import src.principal.EntradaDatos;

public class Manejador {

    private Jugador[] jugadores = new Jugador[10];
    private Jugador jugCompetidor[] = new Jugador[2];
    public Manejador() {
        ingresoJugador();
    }

    public void ingresoJugador() {
        String nombre = " ";
        int op = 0;
        do {
            if (jugadores[9] == null) {
                for (int i = 0; i < jugadores.length; i++) {
                    if (jugadores[i] == null) {
                        nombre = EntradaDatos.getTexto("Ingrese el Nombre del Jugador #" + (i + 1) + " ");
                        jugadores[i] = new Jugador(nombre);
                        break;
                    }
                } 
            }else{
                System.out.println("\nYa no cuentas con espacios para mas Jugadores\n");
            }
            System.out.println("\n-1) Agregar otro Juagador ");
            System.out.println("-2) Regresar al Menu Principal\n"); 
            op = EntradaDatos.getEntero("Digite la opcion que desea realizar: ", false); 
        } while (op != 2);

    }

    public void jugadoresLista() {
        System.out.println("\n***Lista de Jugadores****\n");
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null) {
                System.out.println("-" + (i + 1) + ") " + jugadores[i].toString());
            }   
        }
    }

    public Jugador[] ejegir2() {
        boolean repit = true, pit = true;
        jugadoresLista();
        do {
            int aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0 < aux && aux <= 5) {
                this.jugCompetidor[0] = this.jugadores[aux];
                repit = false;
            }
            aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0 < aux && aux <= 5) {
                this.jugCompetidor[1] = this.jugadores[aux];
                pit = false;
            }
            if (pit && repit) {
                System.out.println("Datos incorrectos******* :(");
            }
        } while (repit && pit);
        return this.jugCompetidor;
    }


    public void jugarPPTijera(){
        
        System.out.println("\n ****Jugando Piedra Papeli o Tijeras*****");
        int val1 = this.jugCompetidor[0].getMiniJuego().tirarDado();
        System.out.println(this.jugCompetidor[0].getNombre()+" Tu haz sacado "+this.jugCompetidor[0].getMiniJuego().resultado());
        int val2 = this.jugCompetidor[1].getMiniJuego().tirarDado();
        System.out.println(this.jugCompetidor[1].getNombre()+" Tu haz sacado "+this.jugCompetidor[1].getMiniJuego().resultado());
        if (val1 ==val2) {
            System.out.println("****Empate*****");  
        }else{
            System.out.println("\nEl ganador es: ----- "+ganadorPPTij(val1,val2));
        }
        

    }

    public String ganadorPPTij(int val1, int val2){
        String ganador = "";
        if (val1 < val2 && (val2-val1) != 2)  {
            ganador = this.jugCompetidor[1].getNombre();
        }
        if (val1 > val2 && (val1-val2) != 2) {
            ganador = this.jugCompetidor[0].getNombre();
        }
        if (val1 < val2 && (val2-val1) == 2) {
            ganador = this.jugCompetidor[0].getNombre();
        }
        if (val1 > val2 && (val2-val1) == 2) {
            ganador = this.jugCompetidor[1].getNombre();
        }
        return ganador;
    }

    public String elegirCasilla() {
        int aux = 1;
        String tem = "";
        do {
            System.out.println("\n---Fichas a escoger");
            System.out.println("1- Blancos");
            System.out.println("2- Negros");
            aux = EntradaDatos.getEntero("--Digite el numero de ficha a jugar", false);
            if (aux == 1) {
                tem = "blanco";
            }
            if (aux == 2) {
                tem = "blanco";
            }

        } while (aux > 2);
        return tem;
    }

}
