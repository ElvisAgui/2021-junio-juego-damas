package src.tablero;

public class Ficha {

    private boolean colocado;
    private boolean esNegro;
    private final String imagen = "■";

    public Ficha(boolean colocado, boolean esNegro) {
        this.colocado = colocado;
        this.esNegro = esNegro;
    }

    public boolean isColocado() {
        return colocado;
    }

    public void setColocado(boolean colocado) {
        this.colocado = colocado;
    }

    public boolean isEsNegro() {
        return esNegro;
    }

    public void setEsNegro(boolean esNegro) {
        this.esNegro = esNegro;
    }

    public String getImagen() {
        return imagen;
    }

    public String getFicha() {
        String ficha = " ";
        String negro = "\033[30m";
        String amarrillo = "\u001B[31m";
        if (colocado && esNegro) {
            ficha = negro + this.imagen;
        }
        if (colocado && esNegro == false) {
            ficha = amarrillo + this.imagen;
        }
        return ficha;
    }

}
