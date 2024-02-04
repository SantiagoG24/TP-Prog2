package JuegoDeCartas.Estrategia;


import java.util.ArrayList;
import java.util.Random;

public class Timbero implements Estrategia {

    private Random random = new Random();

    public Atributo elegirAtributo(Carta carta) {
        ArrayList<Atributo> atributos = carta.getAtributos();
        int indice = random.nextInt(atributos.size());
        return atributos.get(indice);
    }

    public String toString() {
        return "Timbero";
    }

    public boolean equals(Object obj){
        boolean equals = obj.toString().equals(this.toString());
        return equals;

    }

}
