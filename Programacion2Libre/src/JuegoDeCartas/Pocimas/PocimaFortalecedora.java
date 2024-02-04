package JuegoDeCartas.Pocimas;

public class PocimaFortalecedora extends Pocima {

    private float valor;
    public PocimaFortalecedora(String nombre, float valor) {
        super(nombre);
        this.valor=valor;
    }


    public float getValor() {
        return valor;
    }

    public float aplicarPocima(Carta carta,Atributo atributo){
        float valor = getValor();
        for (Atributo e: carta.getAtributos()) {
            e.setValor(e.getValor()+(e.getValor() * valor/100));
        }
        noEstaActivo();
        return carta.getValorAtributo(atributo);
    }
}
