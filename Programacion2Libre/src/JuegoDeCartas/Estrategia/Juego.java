package JuegoDeCartas.Estrategia;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Juego {
    private ArrayList<Carta> mazo;
    private int rondas;
    private ArrayList<Atributo> atributos;
    private ArrayList<Pocima> pocimas;

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
        System.out.println("El jugador "+ p1.getNombre())  ;
        p1.imprimirCartas();
        System.out.println(" ");
        System.out.println("El jugador "+ p2.getNombre());
        p2.imprimirCartas();
        int rondaActual = 1;
        while (p1.tieneCarta() && p2.tieneCarta() && rondaActual < rondas) {

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
        //System.out.println(mazo);
        Collections.shuffle(mazo);
        Collections.shuffle(pocimas);
        //System.out.println("POCIMAS"+pocimas);

        while (!mazo.isEmpty()){
            if(!pocimas.isEmpty()){
                referencioPocimaACarta(mazo.get(0),pocimas.get(0));
                pocimas.remove(0);
            }
            p1.addCarta(mazo.get(0));
            mazo.remove(0);
            if (!mazo.isEmpty()) {
                if(!pocimas.isEmpty()){
                    referencioPocimaACarta(mazo.get(0),pocimas.get(0));
                    pocimas.remove(0);
                }
                p2.addCarta(mazo.get(0));
                mazo.remove(0);

            }
        }
    }
    public void referencioPocimaACarta(Carta carta, Pocima pocima){
        carta.addPocima(pocima);
    }
    public void JuegaRonda(Jugador p1 , Jugador p2, int rondaActual){
        Carta cartPJ1 =p1.getPrimera();
        Carta cartPJ2 =p2.getPrimera();

        Atributo atributoRonda ;

        System.out.println("");
        System.out.println("//////////////////////////////////////////////////En la RONDA "+ rondaActual+"///////////////////////////////////////////////////////");

        if(rondaActual%2==0) {
            preguntarEstrategia(p2);
            atributoRonda= p2.elegirAtributo(cartPJ2);
            System.out.println("El jugador "+p2.getNombre()+" selecciona jugar por el atributo "+ atributoRonda.getNombre() +" usando la estrategia "+ p2.getEstrategia());

        }else {
            preguntarEstrategia(p1);
            atributoRonda= p1.elegirAtributo(cartPJ1);
            System.out.println("El jugador "+p1.getNombre()+" selecciona jugar por el atributo "+ atributoRonda.getNombre()+" usando la estrategia "+ p1.getEstrategia());
        }
        float valorPJ1 = cartPJ1.getValorAtributo(atributoRonda);
        float valorPJ2 = cartPJ2.getValorAtributo(atributoRonda);


            System.out.println(p1.getNombre()+" a lanzado la carta " + cartPJ1.getNombre()+" con "+valorPJ1);
            if(cartPJ1.tienePocima()) {
                cartPJ1.aplicarPocima(atributoRonda);
                valorPJ1 = cartPJ1.getValorAtributo(atributoRonda);
                System.out.println(", se aplico la pocima "+ cartPJ1.getPocima()+" valor resultante "+ valorPJ1);
            }

            System.out.println(p2.getNombre()+" a lanzado la carta " + cartPJ2.getNombre()+" con "+valorPJ2);
            if(cartPJ2.tienePocima()){
                cartPJ2.aplicarPocima(atributoRonda);
                valorPJ2 = cartPJ2.getValorAtributo(atributoRonda);
                System.out.print(", se aplico la pocima "+ cartPJ2.getPocima()+" valor resultante "+ valorPJ2);
                System.out.println("");
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

        System.out.println(" ");

    }

    public void preguntarEstrategia(Jugador jugador ) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("El jugador "+jugador.getNombre()+" quiere cambiar su estrategia actual "+jugador.getEstrategia()+", responda si o no");
            String mensaje= String.valueOf(entrada.readLine());
            if (mensaje.equals("si")){
                cambiarEstrategia(jugador);
            }

        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
    public void  cambiarEstrategia(Jugador jugador) {
        Estrategia actual = jugador.getEstrategia();

        Random random = new Random();

        ArrayList<Estrategia> estrategias = new ArrayList<>();

        estrategias.add(new Timbero());
        estrategias.add(new Ambicioso());
        estrategias.add(new Obstinado());

        estrategias.remove(actual);

        int indice = random.nextInt(estrategias.size());
        Estrategia nueva = estrategias.get(indice);
            jugador.setearEstrategia(nueva);


    }
    public ArrayList<Atributo> getAtributos() {
        ArrayList<Atributo> atributoscopia = new ArrayList<>();
        for (Atributo original : atributos) {
            atributoscopia.add(original);

        }
        return atributoscopia;
    }
}
