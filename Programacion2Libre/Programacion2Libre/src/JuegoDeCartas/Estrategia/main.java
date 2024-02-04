package JuegoDeCartas.Estrategia;
import java.util.ArrayList;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Generar 20 cartas aleatorias

        Juego prueba = new Juego(20);
        ArrayList<Pocima> pocima= genrarPocima();
        prueba.addPocima(pocima);
        for (int i = 0; i < 20; i++) {
            Carta carta = generarCartaAleatoria();
            prueba.crearMazo(carta);

        }



        Jugador p1 = new Jugador("José");
        Jugador p2 = new Jugador("Santi");


        prueba.jugar(p1, p2);

    }
    private static ArrayList<Pocima> genrarPocima(){
        ArrayList<Pocima>salida=new ArrayList<>();
        String[] nombres = {"Fotalecedora", "Fotalecedoraplus", "Debilitadora", "Debilitadoraplus", " SelectivaFuerza", "SelectivaPeso", "NumeroMagico50", "NumeroMagico1000", "Cocktail", "Cocktailv2"};
        Pocima pocima =new PocimaFortalecedora("Fotalecedora",20.0f) ;
        for (int  j=0; j< nombres.length;j++){
            if(j==0){
                pocima= new PocimaFortalecedora("Fotalecedora",20.0f);
                salida.add(pocima);
            }
            if(j==1){
                pocima= new PocimaFortalecedora("FotalecedoraPlus",40.0f);
                salida.add(pocima);
            }
            if(j==2){
                pocima= new PocimaDebilitadora("Debilitadora",15);
                salida.add(pocima);

            }
            if(j==3){
                pocima= new PocimaDebilitadora("DebilitadoraPlus",30);
                salida.add(pocima);
            }
            if(j==4){
                Atributo atributo= new Atributo("Fuerza",0f);
                pocima= new PocimaSelectiva("Pocima Selectiva Fuerza",45,atributo);
                salida.add(pocima);
            }
            if(j==5){
                Atributo atributo =new Atributo("Peso",0f);
                pocima= new PocimaSelectiva("Pocima Selectiva Peso",10,atributo);
                salida.add(pocima);
            }
            if(j==6){
                pocima=new PocimaNumeroMagico("Numero Magico 50",50);
                salida.add(pocima);
            }
            if(j==7){
                pocima=new PocimaNumeroMagico("Numero Magico 912",912);
                salida.add(pocima);
            }
            if(j==8){
                ArrayList<Pocima> aux= new ArrayList<>();

                aux.add(new PocimaNumeroMagico("Numero Magico 912",912));
                aux.add(new PocimaFortalecedora("FotalecedoraPlus",40.0f));
                Atributo atributo =new Atributo("Peso",0f);
                aux.add(new PocimaSelectiva("Pocima Selectiva Peso",10,atributo));

                pocima= new PocimaCocktail("Pocima cocktail 1 " ,aux);
                salida.add(pocima);
            }
            if(j==9) {
                ArrayList<Pocima> aux = new ArrayList<>();

                aux.add(new PocimaNumeroMagico("Numero Magico 912", 912));
                aux.add(new PocimaFortalecedora("FotalecedoraPlus", 40.0f));
                Atributo atributo = new Atributo("Peso", 0f);
                aux.add(new PocimaSelectiva("Pocima Selectiva Peso", 10, atributo));

                Pocima pocimacocktail= new PocimaCocktail("Pocima cocktail 1 " ,aux);

                ArrayList<Pocima> aux2 = new ArrayList<>();

                aux2.add(pocimacocktail);
                aux2.add(new PocimaNumeroMagico("Numero Magico 912", 912));
                aux2.add(new PocimaFortalecedora("FotalecedoraPlus", 40.0f));

                pocima = new PocimaCocktail("Pocima cocktail 2 ", aux2);
                salida.add(pocima);
            }
        }
        for (Pocima pocima1: salida) {
            pocima1.SiEstaActivo();
        }
        return salida;
    }
    private static Carta generarCartaAleatoria() {
        Random random = new Random();

        // Generar un nombre aleatorio para la carta
        String[] nombres = {"Superman", "Batman", "Mujer Maravilla", "Flash", "Linterna Verde", "Aquaman", "Spiderman",
                "Iron Man", "Capitán América", "Hulk","DeadPool","Messi","Manhunter","Firestorm"};
        String nombre = nombres[random.nextInt(nombres.length)];

        // Generar atributos aleatorios
        Atributo fuerza = new Atributo("Fuerza", random.nextInt(Math.abs(100)));
        Atributo peso = new Atributo("Peso", random.nextInt(Math.abs(100)));
        Atributo altura = new Atributo("Altura", random.nextInt(Math.abs(100)));

        // Crear la carta y agregar atributos
        Carta carta = new Carta(nombre);
        carta.addAtributo(fuerza);
        carta.addAtributo(peso);
        carta.addAtributo(altura);

        return carta;
    }
}
