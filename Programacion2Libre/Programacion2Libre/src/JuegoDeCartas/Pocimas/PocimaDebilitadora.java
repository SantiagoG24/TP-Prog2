package JuegoDeCartas.Pocimas;

public class PocimaDebilitadora extends Pocima {
    private float valor;
    public PocimaDebilitadora(String nombre, float valor) {
        super(nombre);
        this.valor=valor;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public float aplicarPocima(Carta carta, Atributo atributo){
        for (Atributo e: carta.getAtributos()) {
            e.setValor(e.getValor()-(e.getValor() * valor/100));
        }
        noEstaActivo();
        return carta.getValorAtributo(atributo);
    }
}
