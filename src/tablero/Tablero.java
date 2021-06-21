package src.tablero;

public class Tablero {
    private final Casilla[][] tablero = new Casilla[8][8];;

    public Tablero() {
        inicialCasilla1();
        inicialCasilla2();
        inicialCasilla3();
    }

    public void dibujarTablero() {
        System.out.println("\n-----------Partida en Proceso------------------\n");
        System.out.println("\t-------------------------------------------------");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\t|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j].getCelda());
                System.out.print("|");
            }
            System.out.println("");
            System.out.println("\t-------------------------------------------------");

        }
    }

    private void inicialCasilla1() {
        boolean esColorInicio = false;
        boolean esColorIteracion = false;
        for (int i = 0; i < 3; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new Casilla(esColorIteracion, esColorIteracion, esColorIteracion);
                esColorIteracion = !esColorIteracion;
            }
            esColorInicio = !esColorInicio;
        }
    }

    private void inicialCasilla2() {
        boolean esColorInicio = true;
        boolean esColorIteracion = true;
        for (int i = 3; i < 5; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new Casilla(esColorIteracion, esColorIteracion, false);
                esColorIteracion = !esColorIteracion;
            }
            esColorInicio = !esColorInicio;
        }
    }

    private void inicialCasilla3() {

        boolean esColorInicio = true;
        boolean esColorIteracion = true;
        for (int i = 5; i < 8; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = new Casilla(esColorIteracion, false, esColorIteracion);
                esColorIteracion = !esColorIteracion;
            }
            esColorInicio = !esColorInicio;
        }

    }

    public boolean moverFicha(int inicioI,int inicioJ,int finI , int finJ){
        boolean movExito = false;
        boolean color;
        if (casillaOcupada(inicioI, inicioJ) && casillaOcupada(finI,finJ) == false){
            color = tablero[inicioI][inicioJ].getFicha().isEsNegro();
            tablero[finI][finJ].getFicha().setEsNegro(color);
            tablero[finI][finJ].setOcupada(true);
            tablero[inicioI][inicioJ].setOcupada(false);
            movExito= true;
        }
        

        return movExito;
    }

    public boolean saltoFila(int inicioI,int finI){
        int interedio = inicioI-finI;
        boolean saltoFila = false;
        if(interedio == 2 || interedio == -2){
            saltoFila = true;
        }
        return saltoFila;
    }

    public boolean derecha(int inicioJ, int finJ){
        boolean derecha = false;
        if(inicioJ < finJ){
            derecha = true;
        }
        return derecha;
    }

    public void borrarFicha(int inicioI,int finI ,int inicioJ, int finJ){
        int posI = 0;
        int posJ = 0;
        if (derecha(inicioJ, finJ) && finI < inicioI) {
            posI = inicioI-1;
            posJ = inicioJ+1;
        }
        if(derecha(inicioJ, finJ) == false && finI < inicioI ){
            posI = inicioI-1;
            posJ = inicioJ-1; 
        }
        if (derecha(inicioJ, finJ) && inicioI < finI) {
            posI = inicioI+1;
            posJ = inicioJ+1; 
            
        }
        if (derecha(inicioJ, finJ) == false && inicioI < finI) {
            posI = inicioI+1;
            posJ = inicioJ-1;
        }
        tablero[posI][posJ].setOcupada(false);
        
    }

    
    public boolean casillaOcupada(int posi, int posj){
        boolean ocup = false;
        if(tablero[posi][posj].isJugable() && tablero[posi][posj].isOcupada()){
            ocup = true;
        }
        if (tablero[posi][posj].isJugable() && tablero[posi][posj].isOcupada() == false) {
            ocup = false;
        }

        return ocup;
    }

    public boolean jugable(int posi, int posj){
        boolean jug = false;
        if (tablero[posi][posj].isJugable()){
            jug = true;
        }

        return jug;
    }

    

}
