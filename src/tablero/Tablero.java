package tablero;

public class Tablero {
    String negro="\033[30m";
    String blanco="\033[37m";
    String reset="\u001B[0m";
    public  final String SIMBOLO_VACIO = " ";
    public  final String SIMBOLO_BLANCA = "X";
    public  final String SIMBOLO_NEGRA = "0";
    private final Casilla[][] tablero = new Casilla[8][8];;

    public Tablero() {
        inicialCasilla(); 
        llenarTablero();
    }

    public void dibujarTablero() {
        System.out.println("\t_________________________________________________");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\t|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("  ");
                System.out.print(tablero[i][j].getFigura1() + "  ");
                System.out.print("|");
            }
            System.out.println("");
            System.out.println("\t_________________________________________________");
        }
    }
    private void llenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (casillaCor(i, j) == "blanca") {
                    tablero[i][j].setFigura1(pintarSigura(SIMBOLO_BLANCA, blanco)); 
                }
                if (casillaCor(i, j) == "negra") {
                    tablero[i][j].setFigura1(pintarSigura(SIMBOLO_NEGRA, negro)); 
                }
                if (casillaCor(i, j) == "vacio") {
                    tablero[i][j].setFigura1(SIMBOLO_VACIO); 
                }
                
            }

        }
    }

    public String pintarSigura(String figura,String color){
        String pintado;
        pintado = color+figura+this.reset;
        return pintado;
    }

    public String casillaCor(int i,int j){
        String fig = "vacio";
        if((i ==0 && j == 0) || (i ==0 && j == 2) || (i ==0 && j == 4)|| (i ==0 && j == 6)){
            fig = "blanca";
        }
        if((i ==1 && j == 1) || (i ==1 && j == 3) || (i ==1 && j == 5)|| (i ==1 && j == 7)){
            fig = "blanca";
        }
        if((i ==2 && j == 0) || (i ==2 && j == 2) || (i ==2 && j == 4)|| (i ==2 && j == 6)){
            fig = "blanca";
        }
        if((i ==5 && j == 0) || (i ==5 && j == 2) || (i ==5 && j == 4)|| (i ==5 && j == 6)){
            fig = "negra";
        }
        if((i ==6 && j == 1) || (i ==6 && j == 3) || (i ==6 && j == 5)|| (i ==6 && j == 7)){
            fig = "negra";
        }
        if((i ==7 && j == 0) || (i ==7 && j == 2) || (i ==7 && j == 4)|| (i ==7 && j == 6)){
            fig = "negra";
        }
        return fig;
    }
    public void inicialCasilla(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Casilla();
            }
        }
        
    }
}
