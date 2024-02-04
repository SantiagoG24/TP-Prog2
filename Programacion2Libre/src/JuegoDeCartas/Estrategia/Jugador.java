package JuegoDeCartas.Estrategia;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Carta> mazo;
    private Estrategia estrategia;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mazo = new ArrayList<Carta>();
        estrategia = new Timbero();
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
    public boolean tieneCarta(){
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


    public void setearEstrategia(Estrategia nueva ){
        if(nueva.toString().equals("Obstinado")){
            ArrayList<Atributo> atributos = mazo.get(0).getAtributos();
            int contador=1;
            Atributo selecionado;
            for (Atributo atributo:atributos) {
                System.out.println("si desea elegir este atributo "+atributo.getNombre() +" escriba el numero "+ contador);
                contador++;
            }
            try {
                BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
                int numero= Integer.valueOf(entrada.readLine());
                if(numero-1<=atributos.size() && numero-1>0) {
                    selecionado= atributos.get(numero - 1);
                    nueva = new Obstinado(selecionado);
                }
            } catch (Exception exc) {
                System.out.println(exc);
            }
        }
        this.estrategia=nueva;

    }
    public Atributo elegirAtributo(Carta carta){
        return estrategia.elegirAtributo(carta);
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    @Override
    public String toString() {
        return  " "+nombre+" "+mazo+" ";
    }
}
