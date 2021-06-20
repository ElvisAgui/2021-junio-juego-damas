package src.miniJuego;

public class PPTijera {

    private int random;

    public PPTijera(){

    }

    public int tirarDado(){
        this.random =  (int)(Math.random()*2);
        return this.random;
    }

    public String  resultado(int valor){
        String result = "";
        if (valor== 0) {
            result = "****PIEDRA****";
        }
        if (valor == 1) {
            result = "****PAPEL****";
        }
        if (valor == 2) {
            result = "****TIJERA****";
        }

        return result;

    }
    
}
