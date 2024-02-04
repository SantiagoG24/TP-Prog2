package JuegoDeCartas.Estrategia;

public class PocimaFortalecedora extends Pocima {

    private float valor;
    public PocimaFortalecedora(String nombre, float valor) {
        super(nombre);
        this.valor=valor;
    }


    public float getValor() {
        return valor;
    }

    public void aplicarPocima(Carta carta, Atributo atributo){
        for (Atributo e: carta.getAtributos()) {
            e.setValor(e.getValor()+(e.getValor() * getValor()/100));
        }
        noEstaActivo();

    }
}
