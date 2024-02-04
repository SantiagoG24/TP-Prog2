package JuegoDeCartas.LasCartas;

import java.util.Random;
public class main {
    public static void main(String[] args) {


/////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Generar 20 cartas aleatorias

        Juego prueba = new Juego(10);
        for (int i = 0; i < 20; i++) {
            Carta carta = generarCartaAleatoria();
            prueba.crearMazo(carta);
        }

        Jugador p1 = new Jugador("Juan");
        Jugador p2 = new Jugador("Hajime");


        prueba.jugar(p1,p2);

    }
        private static Carta generarCartaAleatoria() {
            Random random = new Random();

            // Generar un nombre aleatorio para la carta
            String[] nombres = {"Superman", "Batman", "Mujer Maravilla", "Flash", "Linterna Verde", "Aquaman", "Spiderman",
                                "Iron Man", "Capitán América", "Hulk","DeadPool","Messi","Manhunter","Firestorm"};
            String nombre = nombres[random.nextInt(nombres.length)];

            // Generar atributos aleatorios
            Atributo fuerza = new Atributo("Fuerza", random.nextInt(101));
            Atributo peso = new Atributo("Peso", random.nextInt(101));
            Atributo altura = new Atributo("Altura", random.nextInt(201));

            // Crear la carta y agregar atributos
            Carta carta = new Carta(nombre);
            carta.addAtributo(fuerza);
            carta.addAtributo(peso);
            carta.addAtributo(altura);

            return carta;
        }
}
