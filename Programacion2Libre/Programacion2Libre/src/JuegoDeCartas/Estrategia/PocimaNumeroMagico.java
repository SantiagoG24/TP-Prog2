package JuegoDeCartas.Estrategia;

public class PocimaNumeroMagico extends Pocima {

    private float valor;
    public PocimaNumeroMagico(String nombre, float valor) {
        super(nombre);
        this.valor=valor;
    }
    public float getValor() {
        return valor;
    }
    public void aplicarPocima(Carta carta, Atributo atributo){
        for (Atributo e: carta.getAtributos()) {
                e.setValor(getValor());
        }
        noEstaActivo();

    }
}
