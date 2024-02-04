package JuegoDeCartas.Estrategia;

public abstract class Pocima {

    private boolean  activo;
    private String nombre;


    public Pocima(String nombre) {
        this.nombre=nombre;
        activo=false;
    }
    public String getNombre() {
        return nombre;
    }

    public boolean estaActivo() {
        return activo;
    }
    public void noEstaActivo(){
        activo=false;
    }
    public void SiEstaActivo(){
        activo=true;
    }
    public abstract void aplicarPocima(Carta carta, Atributo atributo);

    @Override
    public String toString() {
        return nombre;
    }
}
