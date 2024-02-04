package JuegoDeCartas.Estrategia;

public interface Estrategia {

    public abstract Atributo elegirAtributo(Carta carta);

    public abstract boolean equals(Object obj);

}