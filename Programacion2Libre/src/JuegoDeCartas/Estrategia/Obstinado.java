package JuegoDeCartas.Estrategia;

public class Obstinado implements Estrategia{

    private Atributo elegido;

    public Obstinado(Atributo elegido) {
        this.elegido = elegido;
    }
    public Obstinado() {
        this.elegido= new Atributo("Fuerza",0.0f);
    }

    public Atributo elegirAtributo (Carta carta){
        return elegido;
    }
    public String toString() {
        return "Obstinado";
    }


    public boolean equals(Object obj){
        boolean equals = obj.toString().equals(this.toString());
        return equals;
    }
}
