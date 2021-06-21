package src.jugadores;

import src.principal.EntradaDatos;

public class Manejador {

    private Jugador[] jugadores = new Jugador[10];
    private Jugador jugCompetidor[] = new Jugador[2];

    public Manejador() {
        
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
                        System.out.println("\nJugador Regristrado con Exito!!!!\n");
                        break;
                    }
                }
            } else {
                System.out.println("\nYa no cuentas con espacios para mas Jugadores\n");
            }
            System.out.println("-1) Agregar otro Juagador ");
            System.out.println("-2) Regresar al Menu Principal");
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
        System.out.println("\n\n************************************************\n\n");
    }

    public void ejegir2() {
        boolean repit = true, pit = true;
        jugadoresLista();
        do {
            int aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0 < aux && aux <= 5) {
                this.jugCompetidor[0] = this.jugadores[aux-1];
                repit = false;
            }
            aux = EntradaDatos.getEntero("--Digite el numero de jugador que va competir", false);
            if (0 < aux && aux <= 5) {
                this.jugCompetidor[1] = this.jugadores[aux-1];
                pit = false;
            }
            if (pit && repit) {
                System.out.println("Datos incorrectos******* :(");
            }
        } while (repit && pit);
    }

    public void jugarPPTijera(){
        int val1;
        int val2;
        do{
            System.out.println("\n ****Jugando Piedra Papeli o Tijeras*****");
            val1 = this.jugCompetidor[0].getMiniJuego().tirarDado();
            System.out.println(this.jugCompetidor[0].getNombre()+" Tu haz sacado "+this.jugCompetidor[0].getMiniJuego().resultado(val1));
            val2 = this.jugCompetidor[1].getMiniJuego().tirarDado();
            System.out.println(this.jugCompetidor[1].getNombre()+" Tu haz sacado "+this.jugCompetidor[1].getMiniJuego().resultado(val2));
            if (val1 ==val2) {
                System.out.println("****Empate*****");  
            }else{
                System.out.println("\nEl ganador es: ----- "+ganadorPPTij(val1,val2));
            }
        }while(val1 ==val2);
        
        

    }

    public String ganadorPPTij(int val1, int val2) {
        
        String ganador = "";
        if (val1 < val2 && (val2 - val1) != 2) {
            ganador = this.jugCompetidor[1].getNombre();
        }
        if (val1 > val2 && (val1 - val2) != 2) {
            ganador = this.jugCompetidor[0].getNombre();
        }
        if (val1 < val2 && (val2 - val1) == 2) {
            ganador = this.jugCompetidor[0].getNombre();
        }
        if (val1 > val2 && (val2 - val1) == 2) {
            ganador = this.jugCompetidor[1].getNombre();
        }
        if(ganador == this.jugCompetidor[1].getNombre()){
            Jugador aux1 = this.jugCompetidor[1];
            Jugador aux2 = this.jugCompetidor[0];
            this.jugCompetidor[0] = aux1;
            this.jugCompetidor[1] = aux2;
        }

        return ganador;
    }

    public void elgirFicha() {
        int aux = 0;
        do {
            System.out.println("jugador : "+ jugCompetidor[0].getNombre()+" Escoge la ficha que quieras");
            System.out.println("\n---Fichas a escoger");
            System.out.println("1- Amarrilas");
            System.out.println("2- Negros");
            aux = EntradaDatos.getEntero("--Digite el numero de ficha a jugar", false);
            if (aux == 1) {
                jugCompetidor[0].setTurno(true);
                jugCompetidor[1].setTurno(false);
            }
            if (aux == 2) {
                jugCompetidor[0].setTurno(false);
                jugCompetidor[1].setTurno(true);
            }

        } while (aux > 2);
    }


    public Jugador[] getJugCompetidor() {
        return jugCompetidor;
    }


    public void setJugCompetidor(Jugador[] jugCompetidor) {
        this.jugCompetidor = jugCompetidor;
    }
    
    public void datosJugaresPartida(){
        System.out.println("**Jugador nombre: " + jugCompetidor[0].getNombre() +" piezas Comidas: "+jugCompetidor[0].getPiezsComidas()+" Pieza perdidas: "+jugCompetidor[0].getPiezsPerdidas()+" ");
        System.out.println("**Jugador nombre: " + jugCompetidor[1].getNombre() +" piezas Comidas: "+jugCompetidor[1].getPiezsComidas()+" Pieza perdidas: "+jugCompetidor[1].getPiezsPerdidas()+" ");
    }

    public void odenamiento(){
        int iteraciones = 0;
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] != null) {
                iteraciones++;
            }
        }
        if (iteraciones > 0) {
            for (int i = 0; i < iteraciones; i++) {
                for (int j = 0; j < iteraciones; j++) {
                    if (this.jugadores[j].getPartidasGanadas() > this.jugadores[j+1].getPartidasGanadas()) {
                        Jugador tem = jugadores[j];
                        jugadores[j]=jugadores[j+1];
                        jugadores[j+1] = tem; 
                    }
                }
            }
        }else{
            System.out.println("primero  ingresa Jugadores ;V");
        }

    }

}
