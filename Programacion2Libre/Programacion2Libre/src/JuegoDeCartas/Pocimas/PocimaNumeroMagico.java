package JuegoDeCartas.Pocimas;

public class PocimaNumeroMagico extends Pocima {

    private float valor;
    public PocimaNumeroMagico(String nombre, float valor) {
        super(nombre);
    }
    public float getValor() {
        return valor;
    }
    public float aplicarPocima(Carta carta,Atributo atributo){
        for (Atributo e: carta.getAtributos()) {
                e.setValor(getValor());
        }
        noEstaActivo();
        return carta.getValorAtributo(atributo);
    }
}
