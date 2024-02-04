package JuegoDeCartas.Pocimas;

public class PocimaSelectiva extends Pocima{
    private Atributo atributo;

    private float valor;

    public PocimaSelectiva(String nombre, float valor,Atributo atributo) {
        super(nombre);
        this.atributo= atributo;
        this.valor=valor;
    }
    public float getValor() {
        return valor;
    }
    public float aplicarPocima(Carta carta,Atributo atributo){
        for (Atributo e: carta.getAtributos()) {
            if (e.equals(atributo)){
                e.setValor(e.getValor()+(e.getValor() * (valor/100)));
                noEstaActivo();
            }
        }
        return carta.getValorAtributo(atributo);
    }



}
