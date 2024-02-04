package JuegoDeCartas.LasCartas;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> mazo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mazo = new ArrayList<Carta>();
    }
    public void addCarta(Carta nueva){
            mazo.add(nueva);
    }

    public Carta getPrimera(){
        if(!mazo.isEmpty())
            return mazo.get(0);
        return null;
    }
    public void removeCarta(Carta nuevo){
        if(mazo.contains(nuevo)){
            mazo.remove(nuevo);
        }
    }
    public boolean tieneCartas(){
        return !mazo.isEmpty();
    }

    public String getNombre() {
        return nombre;
    }
    public int getCantidadCartas(){
        return mazo.size();
    }
    public void mandaAlFondo( ){
        mazo.add(mazo.get(0));
        mazo.remove(0);
    }
    public void imprimirCartas(){
        for (Carta carta:mazo) {
            System.out.println(carta);
        }
    }

    @Override
    public String toString() {
        return  " "+nombre+" "+mazo+" ";
    }
}
