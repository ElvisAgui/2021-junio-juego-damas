package src.tablero;

public class Casilla {
    private boolean jugable;
    private int posfila;
    private int posColumna;
    private Ficha ficha;
    private boolean esNegro;
    private boolean ocupada;

    public Casilla(boolean jugable, boolean esNegro, boolean ocupada) {
        this.jugable = jugable;
        this.esNegro = esNegro;
        this.ocupada = ocupada;
        inicFicha(esNegro);
    }

    private void inicFicha(boolean esNegro) {
        if (jugable) {
            this.ficha = new Ficha(true,esNegro); 
        }
        if (jugable == false) {
            this.ficha = new Ficha(false,esNegro);
        }
    }
    

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public boolean isJugable() {
        return jugable;
    }

    public void setJugable(boolean jugable) {
        this.jugable = jugable;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public boolean isEsNegro() {
        return esNegro;
    }

    public void setEsNegro(boolean esNegro) {
        this.esNegro = esNegro;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
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

    public String getCelda(){
        String celda = "     ";
        String reset = "\u001B[0m";
        String fondoBalco = "\u001B[47m";

        if (jugable && ocupada == true) {
            celda = fondoBalco+"  "+this.ficha.getFicha()+"  "+reset;
        }
        if (jugable && ocupada == false) {
            celda = fondoBalco+ celda +reset;
        }
        return celda;
    }



}
