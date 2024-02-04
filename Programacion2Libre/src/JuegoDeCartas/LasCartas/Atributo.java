package JuegoDeCartas.LasCartas;

public class Atributo {
    private String nombre;
    private int valor;

    public Atributo(String nombre, int valor) {
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

    public int getValor() {
        return valor;
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
