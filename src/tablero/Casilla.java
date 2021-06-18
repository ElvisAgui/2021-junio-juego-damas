package tablero;

public class Casilla {
    private int posfila;
    private int posColumna;
    private boolean ocupada = false;
    private String figura1;

    public Casilla() {
        
    }

    
    public String getFigura1() {
        return figura1;
    }


    public void setFigura1(String figura1) {
        this.figura1 = figura1;
    }


    public int getPosfila() {
        return posfila;
    }


    public void setPosfila(int posfila) {
        this.posfila = posfila;
    }


    public int getPosColumna() {
        return posColumna;
    }


    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }


    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    

    
}
