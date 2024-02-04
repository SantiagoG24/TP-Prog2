package JuegoDeCartas.Estrategia;

import java.util.ArrayList;

public class Ambicioso implements Estrategia {

    public Atributo elegirAtributo(Carta carta){
        ArrayList<Atributo> atributos =carta.getAtributos();

        Atributo maxAtributo= new Atributo("minimo",0.0f);

        for (Atributo atributo:atributos){
            if(maxAtributo.getValor()<=atributo.getValor())
                maxAtributo = atributo;
        }
        return maxAtributo;
    }

    public String toString() {
        return "Ambicioso";
    }

    public boolean equals(Object obj){
        boolean equals = obj.toString().equals(this.toString());
        return equals;

    }



}
