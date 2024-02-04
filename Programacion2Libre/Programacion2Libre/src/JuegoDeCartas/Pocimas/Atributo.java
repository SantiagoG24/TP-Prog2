package JuegoDeCartas.Pocimas;

public class Atributo {
    private String nombre;
    private float valor;

    public Atributo(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;

    }
    public Atributo(Atributo atributo) {
        this.nombre = atributo.getNombre();
        this.valor = atributo.getValor();

    }

    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        Atributo otro = (Atributo) obj;
        return nombre.equals(otro.getNombre());
    }

    @Override
    public String toString() {
        return  " "+nombre+" con "+valor+" ";
    }
}
