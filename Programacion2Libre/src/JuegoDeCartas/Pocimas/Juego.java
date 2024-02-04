package JuegoDeCartas.Pocimas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Juego {
    private ArrayList<Carta> mazo;
    private int rondas;
    private ArrayList<Atributo> atributos;
    ArrayList<Pocima> pocimas;

    public Juego(int rondas) {
        this.rondas = rondas;
        mazo = new ArrayList<>();
        atributos = new ArrayList<>();
        pocimas = new ArrayList<>();
    }

    public void crearMazo(Carta nueva) {
        if (mazo.isEmpty()) {
            mazo.add(nueva);
            atributos = mazo.get(0).getAtributos();
        } else if (nueva.tenesEstaLista(atributos)) {
            mazo.add(nueva);
        }
    }
    public void addPocima(ArrayList<Pocima> nueva){
        pocimas.addAll(nueva);
    }
    public void jugar(Jugador p1 , Jugador p2) {
        repartirCartas(p1, p2);
        //System.out.println("El jugador "+ p1.getNombre())  ;
        //p1.imprimirCartas();
        //System.out.println(" ");
        //System.out.println("El jugador "+ p2.getNombre());
        //p2.imprimirCartas();
        int rondaActual = 1;
        while (p1.tieneCartas() && p2.tieneCartas() && rondaActual < rondas) {
            JuegaRonda(p1, p2, rondaActual);
            rondaActual++;
        }
        System.out.println("//////////////////////////////////////////// FIN /////////////////////////////////////////////////////////////");
        System.out.println(" ");
        if (p1.getCantidadCartas() > p2.getCantidadCartas()){
            System.out.println("EL GANADOR ES EL JUGADOR " + p1.getNombre());
        } else if (p2.getCantidadCartas()>p1.getCantidadCartas()) {
            System.out.println("EL GANADOR ES EL JUGADOR " + p2.getNombre());
        }else{
            System.out.println("Ambos jugadores tienen la misma cantidad de cartas F :(");
        }
    }
    public void repartirCartas(Jugador p1 , Jugador p2){
        System.out.println(mazo);
        Collections.shuffle(mazo);
        Collections.shuffle(pocimas);
        //System.out.println("POCIMAS"+pocimas);

        while (!mazo.isEmpty()){
            if(!pocimas.isEmpty()){
                referencioPocionesYCartas(mazo.get(0),pocimas.get(0));
                pocimas.remove(0);
            }
            p1.addCarta(mazo.get(0));
            mazo.remove(0);
            if (!mazo.isEmpty()) {
                if(!pocimas.isEmpty()){
                    referencioPocionesYCartas(mazo.get(0),pocimas.get(0));
                    pocimas.remove(0);
                }
                p2.addCarta(mazo.get(0));
                mazo.remove(0);

            }
        }
    }
    public void referencioPocionesYCartas(Carta carta, Pocima pocima){
        carta.addPocima(pocima);
    }
    public void sacoPocimas(Pocima pocima){
        pocimas.remove(0);
    }
    public void JuegaRonda(Jugador p1 , Jugador p2, int rondaActual){
        Carta cartPJ1 =p1.getPrimera();
        Carta cartPJ2 =p2.getPrimera();

        Atributo atributoRonda = getAtributoRandom();
        float valorPJ1 = cartPJ1.getValorAtributo(atributoRonda);
        float valorPJ2 = cartPJ2.getValorAtributo(atributoRonda);
        System.out.println("");
        System.out.println("//////////////////////////////////////////////////En la RONDA "+ rondaActual+"///////////////////////////////////////////////////////");

        if(rondaActual%2==0) {
            System.out.println("El jugador "+p2.getNombre()+" selecciona jugar por el atributo "+ atributoRonda.getNombre());
        }else {
            System.out.println("El jugador "+p2.getNombre()+" selecciona jugar por el atributo "+ atributoRonda.getNombre());
        }
        if(cartPJ1.tienePocima() && cartPJ2.tienePocima()){ // caso las 2 cartas con pocima
            System.out.println(p1.getNombre()+" a lanzado la carta " + cartPJ1.getNombre()+" con "+cartPJ1.getValorAtributo(atributoRonda) +", se aplico la pocima "+ cartPJ1.getPocima()+" valor resultante "+cartPJ1.aplicarPocima(atributoRonda));
            System.out.println(p2.getNombre()+" a lanzado la carta " + cartPJ2.getNombre()+" con "+cartPJ2.getValorAtributo(atributoRonda) +", se aplico la pocima "+ cartPJ2.getPocima()+" valor resultante "+cartPJ2.aplicarPocima(atributoRonda));

        } else if (cartPJ1.tienePocima()) { //caso solo pj1 tiene carta con pocima
            System.out.println(p1.getNombre()+" a lanzado la carta " + cartPJ1.getNombre()+" con "+cartPJ1.getValorAtributo(atributoRonda) +", se aplico la pocima "+ cartPJ1.getPocima()+" valor resultante "+cartPJ1.aplicarPocima(atributoRonda));
            System.out.println(p2.getNombre()+" a lanzado la carta " + cartPJ2.toString(atributoRonda)+"puntos");

        } else if (cartPJ2.tienePocima()) { // caso solo pj2 tiene carta con pocima
            System.out.println(p1.getNombre()+" a lanzado la carta " + cartPJ1.toString(atributoRonda)+"puntos");
            System.out.println(p2.getNombre()+" a lanzado la carta " + cartPJ2.getNombre()+" con "+cartPJ2.getValorAtributo(atributoRonda) +", se aplico la pocima "+ cartPJ2.getPocima()+" valor resultante "+cartPJ2.aplicarPocima(atributoRonda));

        }else {
            System.out.println(p1.getNombre()+" a lanzado la carta " + cartPJ1.toString(atributoRonda)+"puntos");
            System.out.println(p2.getNombre()+" a lanzado la carta " + cartPJ2.toString(atributoRonda)+"puntos");
        }

        if (valorPJ1>valorPJ2){
            System.out.println("El ganador de la ronda es el jugardor "+p1.getNombre());
            p1.addCarta(cartPJ2);
            p2.removeCarta(cartPJ2);

        } else if (valorPJ2>valorPJ1) {
            System.out.println("El ganador de la ronda es el jugardor "+p2.getNombre());
            p2.addCarta(cartPJ1);
            p1.removeCarta(cartPJ1);

        } else{
            System.out.println("EMPATE");
            p1.mandaAlFondo();
            p2.mandaAlFondo();
        }
        System.out.println("El jugador "+p1.getNombre()+" tiene "+p1.getCantidadCartas()+" cartas "+" y el jugador "+p2.getNombre()+" tiene  "+p2.getCantidadCartas()+" cartas");
    }
    public Atributo getAtributoRandom(){
        int indiceRandom = obtenerPosicionAleatoria(atributos);
        Atributo salida= atributos.get(indiceRandom);
        return salida;
    }
    public static int obtenerPosicionAleatoria(ArrayList<Atributo> lista) {// paso por parametro porque es static?
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }
        Random random = new Random();
        return random.nextInt(lista.size());
    }
}
