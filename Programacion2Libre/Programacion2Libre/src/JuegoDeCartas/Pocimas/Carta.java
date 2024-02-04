package JuegoDeCartas.Pocimas;

import java.util.ArrayList;

public class Carta {
    private ArrayList<Atributo> atributos;
    private String nombre;
    private Pocima pocima;

    public Carta(String nombre) {
        this.nombre = nombre;
        atributos = new ArrayList<>();
        pocima=new PocimaFortalecedora("nada",0.0f) ;

    }
    public Carta() {
        this.nombre = "nombre";
        atributos = new ArrayList<>();
        pocima=new PocimaFortalecedora("nada",0.0f) ;

    }
    public void agregarReferencia(Pocima pocima){
        this.pocima= pocima;
    }

    public void addPocima(Pocima nueva ){
        pocima=nueva;
    }

    public void addAtributo(Atributo nuevo){
        if(!atributos.contains(nuevo)){
            atributos.add(nuevo);
        }
    }


    public ArrayList<Atributo>getAtributos(){ // devuelve una copia del Array de atributos
        ArrayList<Atributo> salida =new ArrayList<>();
        for (Atributo e:atributos) {
            salida.add(e);
        }
        return salida;
    }

    public String getNombre() {
        return nombre;
    }

    public float getValorAtributo(Atributo filtro){ // devuelve el valor de un atributo dado dentro de un array
        for (Atributo aa:atributos) {
            if(aa.equals(filtro))
                return aa.getValor();
        }
        return 0;
    }

    public boolean tenesEstaLista(ArrayList<Atributo> referemcia){
        return referemcia.containsAll(this.getAtributos());
    }

    @Override
    public boolean equals(Object obj) {
        Carta nueva = (Carta) obj;
        return (nombre.equals(nueva.nombre) && atributos.equals(nueva.getAtributos()));
    }
    public boolean tienePocima(){
        return pocima.estaActivo() == true;
    }

    public String toString(Atributo atributo) {
        Atributo buscado = null;
        for (Atributo item:atributos) {
            if (item.equals(atributo))
                buscado= new Atributo(item);
        }
        return  nombre+buscado.toString();
    }




    public float aplicarPocima(Atributo atributo){
        return pocima.aplicarPocima(this,atributo);
    }

    public Pocima getPocima(){
        return pocima;
    }

    public String toString(){
        return " "+nombre +" "+ atributos+" "+ pocima+" ";
    }
}
