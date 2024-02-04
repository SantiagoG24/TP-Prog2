package JuegoDeCartas.Pocimas;

import java.util.ArrayList;

public class PocimaCocktail extends Pocima{
    private ArrayList<Pocima> pocimas;

    public PocimaCocktail(String nombre,ArrayList<Pocima> pocimas) {
        super(nombre);
        this.pocimas = pocimas;
    }
    public float aplicarPocima(Carta carta,Atributo atributo){
        for (Pocima pocima: pocimas) {
            pocima.aplicarPocima(carta,atributo);
            pocima.noEstaActivo();
        }
        return carta.getValorAtributo(atributo);
    }


}
