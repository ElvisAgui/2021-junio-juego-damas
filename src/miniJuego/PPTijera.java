package src.miniJuego;

public class PPTijera {

    private int random;

    public PPTijera(){

    }

    public int tirarDado(){
        this.random =  (int)(Math.random()*3);
        return this.random;
    }

    public String  resultado(){
        String result = "";
        if (tirarDado() == 0) {
            result = "****PIEDRA****";
        }
        if (tirarDado() == 1) {
            result = "****PAPEL****";
        }
        if (tirarDado() == 2) {
            result = "****TIJERA****";
        }

        return result;

    }
    
}
